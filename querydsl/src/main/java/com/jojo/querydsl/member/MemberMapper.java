package com.jojo.querydsl.member;

import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberResponse MemberToResponse(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .confidence(member.getConfidence())
                .email(member.getEmail())
                .build();
    }
}
