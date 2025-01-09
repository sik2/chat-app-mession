package com.ll.chatApp.domain.article.article.entity;

import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Article extends BaseEntity {
    private String title;
    private String content;
    @ManyToOne
    private Member author;
}
