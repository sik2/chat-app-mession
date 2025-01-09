package com.ll.chatApp.domain.article.articleComment.service;

import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatApp.domain.article.articleComment.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> findByAuthorId(Long id) {
        return articleCommentRepository.findByAuthorId(id);
    }
}
