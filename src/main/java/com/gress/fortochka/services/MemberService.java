package com.gress.fortochka.services;

import com.gress.fortochka.model.Member;
import com.gress.fortochka.repositories.MemberRepository;
import org.springframework.stereotype.Service;

/**
 * @author Roman_Radetskiy.
 */
@Service
public class MemberService implements AbstractService<Member> {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member getItemById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member getItemByProp(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    @Override
    public Iterable<Member> findAll() {
        return memberRepository.findAll();
    }
}