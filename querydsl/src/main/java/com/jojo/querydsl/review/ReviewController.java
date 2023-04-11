package com.jojo.querydsl.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping("/{confidence}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponses getAllReviewByConfidence(@PathVariable("confidence") int confidence){
        return reviewService.findAllReviewByConfidence(confidence);
    }
}
