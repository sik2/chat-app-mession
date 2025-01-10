package com.ll.chatApp.domain.member.member.controller;

import com.ll.chatApp.domain.member.member.dto.MemberDto;
import com.ll.chatApp.domain.member.member.dto.MemberRequest;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.domain.member.member.service.MemberService;
import com.ll.chatApp.global.jwt.JwtProvider;
import com.ll.chatApp.global.rsData.RsData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class ApiV1MemberController {
    private final MemberService memberService;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public RsData<MemberDto> signup(@Valid @RequestBody MemberRequest memberRequest) {
        Member member = memberService.join(memberRequest.getUsername(), memberRequest.getPassword());

        return new RsData<>("200", "회원가입에 성공하였습니다.", new MemberDto(member));
    }

    @PostMapping("/login")
    public RsData<Void> login(@Valid @RequestBody MemberRequest memberRequest, HttpServletResponse response) {
        Member member = memberService.getMember(memberRequest.getUsername());

        // 토큰 생성
        String token = jwtProvider.genAccessToken(member);

        // 응답 데이터에 accessToken 이름으로 토큰을 발급
        Cookie cookie = new Cookie("accessToken", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        String refreshToken = member.getRefreshToken();
            Cookie refreshTokenCookie  = new Cookie("refreshToken", refreshToken);
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setSecure(true);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setMaxAge(60 * 60);
        response.addCookie(refreshTokenCookie);

        return new RsData<>("200", "로그인에 성공하였습니다.");
    }

    @GetMapping("/logout")
    public void logout() {
        System.out.println("logout");
    }

    @GetMapping("/me")
    public RsData<MemberDto> me(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       String accessToken = "";

       for (Cookie cookie : cookies) {
           if (cookie.getName().equals("accessToken")) {
               accessToken = cookie.getValue();
           }
       }

       Map<String, Object> claims = jwtProvider.getClaims(accessToken);
        String username = (String) claims.get("username");

        Member member = this.memberService.getMember(username);

        return new RsData("200", "회원정보 조회 성공", new MemberDto(member));
    }
}
