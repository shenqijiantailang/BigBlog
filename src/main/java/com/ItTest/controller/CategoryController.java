package com.ItTest.controller;

import com.ItTest.pojo.Category;
import com.ItTest.pojo.Result;
import com.ItTest.pojo.User;
import com.ItTest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
public class CategoryController {
   @Autowired
    private CategoryService categoryService ;
    @PostMapping("/category")
    public Result addCategory(  String categoryName,  String categoryAlias){
        //System.out.println("categoryName:"+categoryName+",categoryAlias:"+categoryAlias);
        categoryService.addCategory(categoryName,categoryAlias);
        return  Result.success();
    }
    @GetMapping("/category")
    public  Result<List<Category>>  getCategoryList (){
        List<Category> categoryList =  categoryService.getCategoryList();
        return  Result.success(categoryList);
    }
    @GetMapping("/category/detail")
    public Result<Category> geCategoryDetail(@RequestParam(name = "id") Integer categoryId){
       return  Result.success(categoryService.getCategoryDetail(categoryId));
    }
    @PutMapping("/category")
    public Result updateCategory(@RequestBody Category category){
        Integer id = category.getId();
        String categoryName = category.getCategoryName();
        String categoryAlias = category.getCategoryAlias();
        categoryService.updateCategory(id,categoryName,categoryAlias);
        return Result.success();
    }
    @DeleteMapping("/category")
    public Result deleteCategory(@RequestParam(name = "id") Integer deleteId){
        categoryService.deleteCategory(deleteId);
        return Result.success();

    }
}
