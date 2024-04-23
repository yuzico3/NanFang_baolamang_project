package com.nanfang.baolamang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfang.baolamang.Mapper.CategoryMapper;
import com.nanfang.baolamang.entity.Category;
import com.nanfang.baolamang.entity.Dish;
import com.nanfang.baolamang.entity.Setmeal;
import com.nanfang.baolamang.service.CategorySerivce;
import com.nanfang.baolamang.service.DishService;
import com.nanfang.baolamang.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategorySerivce {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void removeByid(Long id) {
        //添加查询是否与菜品关联的条件
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        //查询是否与菜品关联
        int count1 = (int) dishService.count(dishLambdaQueryWrapper);
        if(count1 > 0){
           throw  new RuntimeException("已经与菜品关联，无法删除");
        }
        //添加查询是否与套餐关联的条件
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        //查询是否与套餐关联
        int count2 = (int) setmealService.count(setmealLambdaQueryWrapper);
        if(count2 > 0){
            //已经与套餐关联
            throw  new RuntimeException("已经与套餐关联,无法删除");

        }

        super.removeById(id);

    }
}
