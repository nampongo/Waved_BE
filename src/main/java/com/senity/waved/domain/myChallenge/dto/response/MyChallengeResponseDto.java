package com.senity.waved.domain.myChallenge.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyChallengeResponseDto {
    private String groupTitle;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Long successCount;
    private Boolean isReviewed;
    private Boolean isVerified;
    private Boolean isGithubConnected;

    private Long challengeGroupId;
    private Long myChallengeId;
}
