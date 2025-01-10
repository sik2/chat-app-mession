package com.ll.chatApp.domain.member.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String refreshToken;
}
