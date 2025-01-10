package com.ll.chatApp.domain.article.article.controller;

import com.ll.chatApp.domain.article.article.dto.ArticleDto;
import com.ll.chatApp.domain.article.article.dto.ArticleWriteRequest;
import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.service.ArticleService;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleService.findAll();

        List<ArticleDto> articleDtoList = articles.stream()
                .map(ArticleDto::new)
                .toList();

        return articleDtoList;
    }

    @GetMapping({"/{id}"})
    private ArticleDto getArticle(@PathVariable("id") Long id) {
        Article article = articleService.findById(id).orElseGet(Article::new);

        return new ArticleDto(article);
    }

    @PostMapping
    public RsData<ArticleDto>  writeArticle(@RequestBody ArticleWriteRequest articleWriteRequest) {
        Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());

        return RsData.of(
                "200",
                "게시글이 작성에 성공하였습니다.",
                new ArticleDto(article)
        );
    }

    @PatchMapping({"/{id}"})
    public RsData<ArticleDto> updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
            Article modifiedArticle = this.articleService.modify(article, article.getTitle(), article.getContent());

            return RsData.of(
                    "200",
                    "게시글이 수정에 성공하였습니다.",
                    new ArticleDto(modifiedArticle)
            );
    }

    @DeleteMapping({"/{id}"})
    public RsData<Void> deleteArticle(@PathVariable("id") Long id) {
            this.articleService.delete(id);

            return RsData.of(
                    "200",
                    "게시글이 삭제에 성공하였습니다.",
                    null
            );
    }
}
