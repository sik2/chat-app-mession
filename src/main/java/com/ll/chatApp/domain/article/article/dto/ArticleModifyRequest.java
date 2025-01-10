package com.ll.chatApp.domain.article.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleModifyRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
