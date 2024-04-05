package com.ItTest.mapper;

import com.ItTest.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    void addArticle(Article article);

    List<Article> getArticleList(Integer id, Integer categoryId, String state);

    Article getArticleDetail(Integer articleId);

    void updateArticle(Article article);

    void deleteArticle(Integer deleteId);
}
