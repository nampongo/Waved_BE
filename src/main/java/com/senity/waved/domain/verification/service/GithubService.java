package com.senity.waved.domain.verification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GHCommit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GithubService {
    private final GithubApi githubApi;

    public boolean hasCommitsToday(String githubId, String token) throws IOException {
        GHCommit commits = githubApi.getCommits(githubId, token);
        ZonedDateTime commitDate = commits.getCommitDate().toInstant().atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.DAYS);
        return commitDate.equals(ZonedDateTime.now(ZoneId.systemDefault()).truncatedTo(ChronoUnit.DAYS));
    }
}
