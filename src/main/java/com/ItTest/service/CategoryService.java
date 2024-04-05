package com.ItTest.service;

import com.ItTest.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void addCategory(String categoryName, String categoryAlias);

    List<Category> getCategoryList();

    Category  getCategoryDetail(Integer id );

    void updateCategory(Integer id, String categoryName, String categoryAlias);

    void deleteCategory(Integer deleteId);
}
