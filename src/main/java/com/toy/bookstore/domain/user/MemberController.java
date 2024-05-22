package com.toy.bookstore.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @QueryMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @QueryMapping
    public Member findById(@Argument("id") Long id) {
        return memberService.getMemberById(id).orElse(null);
    }

    @MutationMapping
    public Member addMember(@Argument("username") String username, @Argument("email") String email, @Argument("password") String password) {
        return memberService.createMember(username, email, password);
    }


    @MutationMapping
    public Member updateMember(@Argument("id") Long id, @Argument("username") String username, @Argument("email") String email, @Argument("password") String password) {
        return memberService.updateMember(id, username, email, password).orElse(null);
    }

    @MutationMapping
    public boolean deleteMember(Long id) {
        return memberService.deleteMember(id);
    }
}
