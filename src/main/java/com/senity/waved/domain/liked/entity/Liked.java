package com.senity.waved.domain.liked.entity;

import com.senity.waved.common.BaseEntity;
import com.senity.waved.domain.verification.entity.Verification;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Liked extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verification_id")
    private Verification verification;

    @Column(name = "member_id")
    private Long memberId;

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public static Liked of(Verification verification, Long memberId) {
        return Liked.builder()
                .memberId(memberId)
                .verification(verification)
                .build();
    }
}
