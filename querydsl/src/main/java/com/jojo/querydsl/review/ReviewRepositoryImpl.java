package com.jojo.querydsl.review;

import com.jojo.querydsl.member.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findByConfidenceQuerydsl(int confidence) {
        QReview r = QReview.review;
        QMember member = QMember.member;

        return queryFactory.selectFrom(r)
                .leftJoin(r.member,member).fetchJoin()
                .where(member.confidence.gt(confidence))
                .fetch();
    }
}
