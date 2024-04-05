package com.ItTest.mapper;

import com.ItTest.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void addCategory(String categoryName, String categoryAlias, Integer id);

    List<Category> getCategoryList (Integer id);

    Category getCategoryDetail(Integer id);

    void updateCategory(Integer id, String categoryName, String categoryAlias);

    void deleteCategory(Integer deleteId);
}
