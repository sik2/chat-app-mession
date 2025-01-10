package com.ll.chatApp.domain.article.article.controller;

import com.ll.chatApp.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public void getArticles() {

    }

    @GetMapping({"/{id}"})
    private void getArticle(@PathVariable("id") Long id) {

    }

    @PostMapping
    public void writeArticle() {

    }

    @PatchMapping({"/{id}"})
    public void updateArticle(@PathVariable("id") Long id) {

    }

    @DeleteMapping({"/{id}"})
    public void deleteArticle(@PathVariable("id") Long id) {

    }

}
