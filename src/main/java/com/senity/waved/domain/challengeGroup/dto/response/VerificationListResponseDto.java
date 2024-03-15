package com.senity.waved.domain.challengeGroup.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senity.waved.domain.verification.entity.Verification;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
public class VerificationListResponseDto {
    private Long verificationId;
    private String content;
    private ZonedDateTime verificationDate;

    @JsonProperty("isLiked")
    private boolean isLiked;

    public VerificationListResponseDto(Verification verification, boolean isLiked) {
        this.verificationId = verification.getId();
        this.content = verification.getContent();
        this.isLiked = isLiked;

        if (verification.getCreateDate() != null) {
            LocalDateTime localDateTime = verification.getCreateDate().toLocalDateTime();
            this.verificationDate = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));
        }
    }
}
