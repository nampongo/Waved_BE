package com.senity.waved.domain.challengeGroup.dto.response;

import com.senity.waved.domain.challenge.entity.Challenge;
import com.senity.waved.domain.challenge.entity.VerificationType;
import com.senity.waved.domain.challengeGroup.entity.ChallengeGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeGroupResponseDto {
    private String groupTitle;
    private Long participantCount;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private VerificationType verificationType;
    private String description;
    private String verificationDescription;
    private Boolean isApplied;
    private Boolean isFree;
    private String imageUrl;
    private Long challengeId;
    private Long myChallengeId;

    public static ChallengeGroupResponseDto of(ChallengeGroup group, Challenge challenge, Long myChallengeId) {
        String imageUrl = String.format("https://wavedstorage.blob.core.windows.net/blob/%s_.png", challenge.getImageUrl());
        Boolean isApplied = myChallengeId > 0;
        return ChallengeGroupResponseDto.builder()
                .groupTitle(group.getGroupTitle())
                .participantCount(group.getParticipantCount())
                .startDate(group.getStartDate())
                .endDate(group.getEndDate())
                .verificationType(challenge.getVerificationType())
                .description(challenge.getDescription())
                .verificationDescription(challenge.getVerificationDescription())
                .isApplied(isApplied)
                .isFree(challenge.getIsFree())
                .myChallengeId(myChallengeId)
                .challengeId(challenge.getId())
                .imageUrl(imageUrl)
                .build();
    }
}
