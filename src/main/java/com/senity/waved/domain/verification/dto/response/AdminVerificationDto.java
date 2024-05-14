package com.senity.waved.domain.verification.dto.response;

import com.senity.waved.domain.verification.entity.Verification;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class AdminVerificationDto {

    private Long verificationId;
    private String content;
    private String link;
    private String imageUrl;
    private ZonedDateTime verificationDate;
    private String nickname;
    private Boolean isDeleted;

    public static AdminVerificationDto from(Verification verification, String nickname) {
        return AdminVerificationDto.builder()
                .nickname(nickname)
                .content(verification.getContent())
                .imageUrl(verification.getImageUrl())
                .link(verification.getLink())
                .verificationId(verification.getId())
                .verificationDate(verification.getCreateDate())
                .isDeleted(verification.getIsDeleted())
                .build();
    }
}