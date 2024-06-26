package com.senity.waved.domain.myChallenge.dto.response;

import com.senity.waved.domain.challengeGroup.entity.ChallengeGroup;
import com.senity.waved.domain.myChallenge.entity.MyChallenge;
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
    private Long deposit;
    private Long challengeGroupId;

    public static MyChallengeResponseDto of(MyChallenge myChallenge, ChallengeGroup group) {
        return MyChallengeResponseDto.builder()
                .groupTitle(group.getGroupTitle())
                .startDate(group.getStartDate())
                .deposit(myChallenge.getDeposit())
                .endDate(group.getEndDate())
                .challengeGroupId(group.getId())
                .build();
    }
}
