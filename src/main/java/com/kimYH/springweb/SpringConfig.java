package com.kimYH.springweb;

import com.kimYH.springweb.repository.MemberRepository;
import com.kimYH.springweb.repository.MemoryMemberRepository;
import com.kimYH.springweb.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
