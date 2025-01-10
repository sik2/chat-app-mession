package com.ll.chatApp.domain.member.member.repository;

import com.ll.chatApp.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
    Optional<Member> findByRefreshToken(String refreshToken);
}
