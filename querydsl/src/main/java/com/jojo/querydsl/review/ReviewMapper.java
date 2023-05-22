package com.jojo.querydsl.review;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapper {
    public ReviewResponses reviewListToResponse(List<Review> list){
        List<ReviewResponse> responses = new ArrayList<>();
        for (Review r : list) {
            responses.add(ReviewResponse.builder()
                    .reviewId(r.getReviewId())
                    .title(r.getTitle())
                    .content(r.getContent())
                    .writerId(r.getMember().getMemberId())
                    .build()
            );
        }
        return ReviewResponses.builder().reviewList(responses).build();
    }
}
