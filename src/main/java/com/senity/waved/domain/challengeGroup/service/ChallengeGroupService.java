package com.senity.waved.domain.challengeGroup.service;

import com.senity.waved.domain.challenge.entity.Challenge;
import com.senity.waved.domain.challengeGroup.entity.ChallengeGroup;
import com.senity.waved.domain.myChallenge.entity.MyChallenge;
import com.senity.waved.domain.verification.dto.response.VerificationResponseDto;
import org.springframework.data.util.Pair;

import java.sql.Timestamp;
import java.util.List;

public interface ChallengeGroupService {
    Long applyForChallengeGroup(String email, Long groupId, Long deposit);
    Pair<ChallengeGroup, Challenge> getGroupDetail(Long groupId);
    MyChallenge getMyChallenge(String email, Long groupId);
    List<VerificationResponseDto> getVerifications(String email, Long challengeGroupId, Timestamp verificationDate);
    List<VerificationResponseDto> getUserVerifications(String username, Long challengeGroupId, Timestamp verificationDate);
}