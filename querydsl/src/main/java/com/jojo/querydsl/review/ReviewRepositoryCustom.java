package com.jojo.querydsl.review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findByConfidenceQuerydsl(int confidence);
}
