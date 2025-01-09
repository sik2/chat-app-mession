package com.ll.chatApp.domain.article.articleTag.repository;

import com.ll.chatApp.domain.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle_authorId(Long authorId);

    List<ArticleTag> findByArticle_authorUsername(String authorUsername);
}
