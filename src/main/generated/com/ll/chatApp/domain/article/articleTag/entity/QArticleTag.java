package com.ll.chatApp.domain.article.articleTag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleTag is a Querydsl query type for ArticleTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleTag extends EntityPathBase<ArticleTag> {

    private static final long serialVersionUID = -28600095L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleTag articleTag = new QArticleTag("articleTag");

    public final com.ll.chatApp.global.jpa.QBaseEntity _super = new com.ll.chatApp.global.jpa.QBaseEntity(this);

    public final com.ll.chatApp.domain.article.article.entity.QArticle article;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QArticleTag(String variable) {
        this(ArticleTag.class, forVariable(variable), INITS);
    }

    public QArticleTag(Path<? extends ArticleTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleTag(PathMetadata metadata, PathInits inits) {
        this(ArticleTag.class, metadata, inits);
    }

    public QArticleTag(Class<? extends ArticleTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new com.ll.chatApp.domain.article.article.entity.QArticle(forProperty("article"), inits.get("article")) : null;
    }

}

