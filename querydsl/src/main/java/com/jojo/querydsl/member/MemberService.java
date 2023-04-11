package com.jojo.querydsl.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member findById(long id){
        return memberRepository.findById(id).get();
    }
}
