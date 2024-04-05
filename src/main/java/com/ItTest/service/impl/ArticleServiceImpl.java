package com.ItTest.service.impl;

import com.ItTest.mapper.ArticleMapper;
import com.ItTest.pojo.Article;
import com.ItTest.pojo.PageBean;
import com.ItTest.service.ArticleService;
import com.ItTest.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("ID");
        article.setCreateUser(id);

        articleMapper.addArticle(article);

    }

    @Override
    public PageBean<Article> GetList(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer)map.get("ID");
        PageBean<Article> pageBean =new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList= articleMapper.getArticleList(id,categoryId,state);
        Page<Article> page = (Page<Article>) articleList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }

    @Override
    public Article getDetail(Integer articleId) {

        return articleMapper.getArticleDetail(articleId);
    }

    @Override
    public void updateArticle(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(Integer deleteId) {
        articleMapper.deleteArticle(deleteId);
    }
}
