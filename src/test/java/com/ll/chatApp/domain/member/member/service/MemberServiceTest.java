package com.ll.chatApp.domain.member.member.service;

import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.domain.member.member.service.MemberService;
import com.ll.chatApp.global.rsData.RsData;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @DisplayName("회원가입")
    @Test
    void t1() {
        RsData<Member> joinRs = memberService.join("usernew", "1234");
        Member member = joinRs.getData();
        assertThat(member.getId()).isGreaterThan(0L);
    }
}
