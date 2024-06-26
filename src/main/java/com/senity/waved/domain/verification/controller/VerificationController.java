package com.senity.waved.domain.verification.controller;

import com.senity.waved.common.ResponseDto;
import com.senity.waved.domain.verification.dto.request.VerificationRequestDto;
import com.senity.waved.domain.verification.service.VerificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/verify")
public class VerificationController {

    private final VerificationService verificationService;

    @PostMapping("/{challengeGroupId}")
    public ResponseEntity<ResponseDto> verifyChallenge(
            @AuthenticationPrincipal User user,
            @PathVariable("challengeGroupId") Long challengeGroupId,
            @ModelAttribute VerificationRequestDto requestDto
    ) {
        verificationService.verifyChallenge(requestDto, user.getUsername(), challengeGroupId);
        return ResponseDto.of(HttpStatus.OK, "인증이 성공적으로 제출되었습니다.");
    }
}
