package com.jojo.querydsl.review;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    public ReviewResponses findAllReviewByConfidence(int confidence){
        List<Review> reviews = reviewRepository.findByConfidenceQuerydsl(confidence);
        List<ReviewResponse> responses = new ArrayList<>();
        for (Review r : reviews) {
            responses.add(ReviewResponse.builder()
                    .reviewId(r.getReviewId())
                    .title(r.getTitle())
                    .content(r.getContent())
                    .writerId(r.getMember().getMemberId())
                    .build());
        }
        return  ReviewResponses.builder()
                .reviewList(responses)
                .build();
    }
}
