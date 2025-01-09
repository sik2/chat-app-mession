package com.ll.chatApp.domain.article.article.repository;

import com.ll.chatApp.domain.article.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByOrderByIdDesc();
    Page<Article> findByTitleContainingOrContentContaining(String kw, String kw_, Pageable pageable);
    Page<Article> findByTitleContaining(String kw, Pageable pageable);
    Page<Article> findByContentContaining(String kw, Pageable pageable);

}
