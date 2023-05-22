package com.jojo.querydsl.review;

import com.jojo.querydsl.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    @Column
    private String title;

    @Column
    private String content;

//    @ManyToOne(fetch = FetchType.EAGER) // N:1
    @ManyToOne // N:1
    @JoinColumn(name = "member_id")
    private Member member;
}
