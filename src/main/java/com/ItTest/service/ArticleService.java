package com.ItTest.service;

import com.ItTest.pojo.Article;
import com.ItTest.pojo.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    void addArticle(Article article);

    PageBean<Article> GetList(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article getDetail(Integer articleId);

    void updateArticle(Article article);

    void deleteArticle(Integer deleteId);
}
