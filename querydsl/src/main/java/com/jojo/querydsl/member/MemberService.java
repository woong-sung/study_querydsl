package com.jojo.querydsl.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper mapper;
    public MemberResponse findById(long id){
        Member m = memberRepository.findById(id).get();
        m.getReviews();
        return mapper.MemberToResponse(m);
    }

    public void findAll() {
        memberRepository.findAll();
    }

    public void getReviewCnt(){
        List<Member> list = memberRepository.findAll();
//        List<Member> list = memberRepository.findAllJPQLFetch();  // FetchJoin을 사용한 방법 - 직접 작성
//        List<Member> list = memberRepository.findAllJPQLFetch2(); // FetchJoin을 사용한 방법 - EntityGraph 어노테이션 사용

        int sum = 0;
        for (Member m : list) {
            System.out.println(m.getReviews().size());
        }
    }
}
