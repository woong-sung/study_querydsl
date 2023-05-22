package com.jojo.querydsl.review;

import com.jojo.querydsl.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>,ReviewRepositoryCustom {
    List<Review> findByMember(Member member);
}
