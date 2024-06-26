package com.senity.waved.domain.challenge.controller;

import com.senity.waved.domain.challenge.entity.Challenge;
import com.senity.waved.domain.challenge.service.ChallengeService;
import com.senity.waved.domain.challengeGroup.dto.response.ChallengeGroupHomeResponseDto;
import com.senity.waved.domain.challengeGroup.mapper.ChallengeGroupMapper;
import com.senity.waved.domain.review.dto.response.ChallengeReviewResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;
    private final ChallengeGroupMapper challengeGroupMapper;

    @GetMapping("/waiting")
    public List<ChallengeGroupHomeResponseDto> getHomeChallengeGroups() {
        List<Challenge> challenges = challengeService.getHomeChallengeGroupsListed();
        return challenges.stream()
                .map(challenge -> challengeGroupMapper.toHomeResponseDto(challenge))
                .collect(Collectors.toList());
    }

    @GetMapping("/{challengeId}/reviews")
    public Page<ChallengeReviewResponseDto> getReviews(
            @PathVariable("challengeId") Long challengeId,
            @RequestParam(value = "page", defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", defaultValue = "5") int pageSize
    ) {
        return challengeService.getReviewsPaged(challengeId, pageNumber, pageSize);
    }
}
