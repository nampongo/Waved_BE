package com.senity.waved.domain.review.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponseDto {
    private String nickname;
    private String jobTitle;
    private String challengeGroupTitle;
    private String content;
    private LocalDateTime createDate;
}
