package com.senity.waved.domain.review.repository;

import java.time.ZonedDateTime;

public interface ContentCreateDateProjection {
    String getContent();
    ZonedDateTime getCreateDate();
}
