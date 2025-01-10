package com.ll.chatApp.domain.article.article.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatApp.domain.article.articleTag.entity.ArticleTag;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true) // fetch = FetchType.LAZY
    @Builder.Default
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    public void addComment(Member memberAuthor, String commentBody) {
        ArticleComment comment = ArticleComment.builder()
                .article(this)
                .author(memberAuthor)
                .body(commentBody)
                .build();

        comments.add(comment);
    }

    public void removeComment(ArticleComment articleComment) {
        comments.remove(articleComment);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<ArticleTag> tags = new ArrayList<>();

    public void addTag(String tagContent) {
        ArticleTag tag = ArticleTag.builder()
                .article(this)
                .content(tagContent)
                .build();
        tags.add(tag);
    }

    public void addTags(String... tagContents) {
        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }


    public String getTagsStr() {
        String tagsStr = tags
                .stream()
                .map(ArticleTag::getContent)
                .collect(Collectors.joining(" #"));

        if (tagsStr.isBlank()) {
            return "";
        }

        return "#" + tagsStr;

    }
}
