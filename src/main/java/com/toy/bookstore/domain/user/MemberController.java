package com.toy.bookstore.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @SchemaMapping(typeName = "Query",value = "findAll")
    public List<Member> findAll(){
        return memberService.findAll();
    }
}
