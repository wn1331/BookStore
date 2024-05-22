package com.toy.bookstore.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     *{
     *   findAll {
     *     id
     *     username
     *     email
     *     password
     *   }
     * }
     *
     */

    @Transactional(readOnly = true)
    public List<Member> findAll(){
        return memberRepository.findAll();
    }



    @Transactional
    public Member createMember(String username, String email, String password) {
        return memberRepository.save(new Member(username, email, password));
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public Optional<Member> updateMember(Long id, String username, String email, String password) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.update(username, email, password);
            return Optional.of(member);
        }
        return Optional.empty();
    }

    @Transactional
    public boolean deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
