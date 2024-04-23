package com.nanfang.baolamang.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanfang.baolamang.common.R;
import com.nanfang.baolamang.entity.Category;
import com.nanfang.baolamang.service.CategorySerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategorySerivce categorySerivce;

    @PostMapping
    public R<String> save(@RequestBody Category category){



       categorySerivce.save(category);

       return  R.success("新增成功");

    }

    @GetMapping("/page")
    public R<Page> page(int page ,int pageSize){
        //分页构造器
        Page<Category> pageinfo = new Page<>(page ,pageSize);

        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();

        //添加按照升序排列
        queryWrapper.orderByAsc(Category::getSort);

        categorySerivce.page(pageinfo,queryWrapper);

        return R.success(pageinfo);


    }

    @DeleteMapping
    public R<String> remove(Long id){
       log.info("删除id：{}",id);

       categorySerivce.removeByid(id);

       return R.success("删除成功");
    }


   @PutMapping
    public R<String> update(@RequestBody Category category){

        categorySerivce.updateById(category);

        return R.success("修改分类信息成功");
   }



   //查询所有的分类并显示
  @GetMapping("/list")
    public  R<List<Category>> list(Category category){
        //构建条件构造器
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper= new LambdaQueryWrapper<>();
        //添加条件
        categoryLambdaQueryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
        //添加加根据asc ,dsc 条件
        categoryLambdaQueryWrapper.orderByAsc(Category::getSort)
              .orderByDesc(Category::getUpdateTime);

         List<Category> categoryList = categorySerivce.list(categoryLambdaQueryWrapper);

         return  R.success(categoryList);

  }




}
