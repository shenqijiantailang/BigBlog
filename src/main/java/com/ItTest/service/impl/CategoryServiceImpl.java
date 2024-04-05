package com.ItTest.service.impl;

import com.ItTest.mapper.CategoryMapper;
import com.ItTest.pojo.Category;
import com.ItTest.service.CategoryService;
import com.ItTest.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void addCategory(String categoryName, String categoryAlias) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("ID");
        categoryMapper.addCategory(categoryName,categoryAlias,id);

    }

    @Override
    public List<Category> getCategoryList() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("ID");
        return  categoryMapper.getCategoryList(id);


    }

    @Override
    public Category getCategoryDetail(Integer id) {
        return categoryMapper.getCategoryDetail(id);
    }

    @Override
    public void updateCategory(Integer id, String categoryName, String categoryAlias) {
        categoryMapper.updateCategory(id,categoryName,categoryAlias);
    }

    @Override
    public void deleteCategory(Integer deleteId) {
        categoryMapper.deleteCategory(deleteId);
    }
}
