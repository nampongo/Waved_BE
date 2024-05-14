package com.senity.waved.domain.event.service;

import com.senity.waved.domain.event.repository.EventRepository;
import com.senity.waved.domain.member.entity.Member;
import com.senity.waved.domain.member.exception.MemberNotFoundException;
import com.senity.waved.domain.member.repository.MemberRepository;
import com.senity.waved.domain.member.service.MemberUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final MemberUtil memberUtil;

    @Override
    public SseEmitter subscribe(String email) {
        Member member = memberUtil.getMemberByEmail(email);
        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);

        sendInitEvent(sseEmitter);
        eventRepository.save(member.getId(), sseEmitter);

        sseEmitter.onCompletion(() -> eventRepository.deleteById(member.getId()));
        sseEmitter.onTimeout(() -> eventRepository.deleteById(member.getId()));
        sseEmitter.onError((e) -> eventRepository.deleteById(member.getId()));
        return sseEmitter;
    }

    @Override
    public String checkNewEvent(String email) {
        Member member = memberUtil.getMemberByEmail(email);
        return new JSONObject().put("newEvent", member.getHasNewEvent()).toString();
    }

    private void sendInitEvent(SseEmitter sseEmitter) {
        try {
            sseEmitter.send(SseEmitter.event().name("INIT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
