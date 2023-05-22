package com.jojo.querydsl.member;

import com.jojo.querydsl.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int confidence;

//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER) //1:N
    @OneToMany(mappedBy = "member") //1:N
    private List<Review> reviews = new ArrayList<>();
}
