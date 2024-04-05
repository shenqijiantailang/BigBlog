package com.ItTest.vo;

import com.ItTest.pojo.Article;
import com.ItTest.pojo.Category;
import com.ItTest.service.ArticleService;
import com.ItTest.service.CategoryService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public class ArticleCateGory {
    @Autowired
    private CategoryService categoryService ;
    public String getCategoryName(Integer  categoryId){
        Category categoryDetail = categoryService.getCategoryDetail(categoryId);
        return  categoryDetail.getCategoryName();

    }

}
