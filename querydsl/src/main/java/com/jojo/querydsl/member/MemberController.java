package com.jojo.querydsl.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponse findBydId(@PathVariable("id") long id){
        return memberService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void findAll(){
        memberService.findAll();
    }

    @GetMapping("/conf")
    @ResponseStatus(HttpStatus.OK)
    public void getConfidence(){
        memberService.getReviewCnt();
    }
}
