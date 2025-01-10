package com.ll.chatApp.domain.member.member.dto;

import com.ll.chatApp.domain.member.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private String username;

    public MemberDto(Member member) {
        this.username = member.getUsername();
    }
}
