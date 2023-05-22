package com.jojo.querydsl.review;

import com.jojo.querydsl.member.Member;
import com.jojo.querydsl.member.MemberRepository;
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
    private final ReviewMapper mapper;
    private final MemberRepository memberRepository;
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

    public ReviewResponses findByMemberId(long id) {
        Member m = memberRepository.findById(id).get();
        return mapper.reviewListToResponse(reviewRepository.findByMember(m));
    }
}
