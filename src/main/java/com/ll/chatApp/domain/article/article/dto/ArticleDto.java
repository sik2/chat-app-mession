package com.ll.chatApp.domain.article.article.dto;

import com.ll.chatApp.domain.article.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor().getUsername();
        this.createdDate = article.getCreateDate();
        this.modifiedDate = article.getModifyDate();
    }
}
