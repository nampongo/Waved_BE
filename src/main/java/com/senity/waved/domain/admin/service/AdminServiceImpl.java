package com.senity.waved.domain.admin.service;

import com.senity.waved.common.TimeUtil;
import com.senity.waved.domain.challengeGroup.entity.ChallengeGroup;
import com.senity.waved.domain.challengeGroup.repository.ChallengeGroupRepository;
import com.senity.waved.domain.challengeGroup.service.ChallengeGroupUtil;
import com.senity.waved.domain.event.repository.EventRepository;
import com.senity.waved.domain.member.entity.Member;
import com.senity.waved.domain.member.repository.MemberRepository;
import com.senity.waved.domain.myChallenge.entity.MyChallenge;
import com.senity.waved.domain.myChallenge.service.MyChallengeUtil;
import com.senity.waved.domain.notification.entity.Notification;
import com.senity.waved.domain.notification.repository.NotificationRepository;
import com.senity.waved.domain.verification.dto.response.AdminVerificationDto;
import com.senity.waved.domain.verification.entity.Verification;
import com.senity.waved.domain.verification.exception.AlreadyDeletedVerificationException;
import com.senity.waved.domain.verification.exception.VerificationNotFoundException;
import com.senity.waved.domain.verification.repository.VerificationRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ChallengeGroupRepository groupRepository;
    private final VerificationRepository verificationRepository;
    private final MemberRepository memberRepository;
    private final NotificationRepository notificationRepository;
    private final EventRepository eventRepository;

    private final ChallengeGroupUtil challengeGroupUtil;
    private final MyChallengeUtil myChallengeUtil;
    private final TimeUtil timeUtil;

    @Override
    @Transactional(readOnly = true)
    public List<ChallengeGroup> getGroups() {
        ZonedDateTime todayStart = timeUtil.getTodayZoned();
        return groupRepository.findChallengeGroupsInProgress(todayStart);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminVerificationDto> getGroupVerificationsPaged(Long challengeGroupId, int pageNumber, int pageSize) {
        ChallengeGroup challengeGroup = challengeGroupUtil.getById(challengeGroupId);
        List<Verification> verifications = verificationRepository.findByChallengeGroupIdAndIsDeletedFalse(challengeGroup.getId());

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<AdminVerificationDto> verificationDtoList = getPaginatedVerificationDtoList(verifications, pageable);
        return new PageImpl<>(verificationDtoList, pageable, verifications.size());
    }

    @Override
    @Transactional
    public void deleteVerification(Long groupId, Long verificationId) {
        Verification verification = getVerificationById(verificationId);
        if (verification.getIsDeleted()) {
            throw new AlreadyDeletedVerificationException("이미 삭제된 인증 내역입니다.");
        }
        verification.markAsDeleted(true);

        Member member = getMemberByIdWithNull(verification.getMemberId());
        ChallengeGroup group = challengeGroupUtil.getById(verification.getChallengeGroupId());

        MyChallenge myChallenge = myChallengeUtil.getByGroupAndMemberId(group, verification.getMemberId());
        myChallenge.deleteVerification(verification.getCreateDate());
        verificationRepository.save(verification);

        if (member != null) {
            createCanceledVerificationNotification(verification, group.getGroupTitle(), member);
            dispatchDeleteEvent(member.getId(), "인증삭제알림");
            member.updateNewEvent(true);
            memberRepository.flush();
        }
    }

    private void dispatchDeleteEvent(Long memberId, String content) {
        String eventFormatted = new JSONObject().put("content", content).toString();
        SseEmitter sseEmitter = eventRepository.get(memberId);
        if (sseEmitter != null) {
            try {
                sseEmitter.send(SseEmitter.event().name("event").data(eventFormatted));
            } catch (IOException e) {
                eventRepository.deleteById(memberId);
            }
        }
    }

    private List<AdminVerificationDto> getPaginatedVerificationDtoList(List<Verification> verifs, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), verifs.size());

        return verifs.subList(start, end)
                .stream()
                .map(verification -> {
                    Member member = getMemberByIdWithNull(verification.getMemberId());
                    if (member == null) {
                        return AdminVerificationDto.from(verification, "탈퇴한서퍼");
                    }
                    return AdminVerificationDto.from(verification, member.getNickname());
                })
                .collect(Collectors.toList());
    }

    private Member getMemberByIdWithNull(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isEmpty()) {
            return null;
        }
        return member.get();
    }

    private Verification getVerificationById(Long id) {
        return verificationRepository.findById(id)
                .orElseThrow(() -> new VerificationNotFoundException("해당 인증 내역을 찾을 수 없습니다."));
    }

    private void createCanceledVerificationNotification(Verification verification, String groupTitle, Member member) {
        int month = verification.getCreateDate().getMonthValue();
        int day = verification.getCreateDate().getDayOfMonth();
        String message = String.format("%s의 \r\n%d월 %d일 인증이 취소되었습니다.", groupTitle, month, day);

        Notification newNotification = Notification.of(member, "인증 취소", message);
        notificationRepository.save(newNotification);
    }
}

