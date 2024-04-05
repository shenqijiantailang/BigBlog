package com.ItTest.controller;

import com.ItTest.pojo.Article;
import com.ItTest.pojo.PageBean;
import com.ItTest.pojo.Result;
import com.ItTest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/article")
    public Result<PageBean<Article>> GetList(Integer pageNum,Integer pageSize,@RequestParam(required = false) Integer categoryId,@RequestParam(required = false) String state){
       PageBean<Article> pageBean = articleService.GetList(pageNum,pageSize,categoryId,state);
        return Result.success(pageBean) ;
    }
    @PostMapping("/article")
    public Result addArticle(@RequestBody @Validated Article article){
        articleService.addArticle(article);
        return Result.success();

    }
    @GetMapping("/article/detail")
    public Result<Article> getDetail(@RequestParam(name = "id") Integer articleId){
        Article article =  articleService.getDetail(articleId);
        return Result.success(article);
    }
    @PutMapping("/article")
    public Result updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return Result.success();

    }
    @DeleteMapping("/article")
    public Result deleteArticle(@RequestParam(name = "id") Integer deleteId){
        articleService.deleteArticle(deleteId);
        return Result.success();
    }
}
