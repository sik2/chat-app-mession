package com.ll.chatApp.domain.article.articleComment.repository;

import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    List<ArticleComment> findByArticleId(Long articleId);

    List<ArticleComment> findByAuthorId(Long id);
}
