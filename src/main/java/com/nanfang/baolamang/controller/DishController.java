package com.nanfang.baolamang.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nanfang.baolamang.common.R;
import com.nanfang.baolamang.dao.DishDto;
import com.nanfang.baolamang.entity.Category;
import com.nanfang.baolamang.entity.Dish;
import com.nanfang.baolamang.entity.DishFlavor;
import com.nanfang.baolamang.service.CategorySerivce;
import com.nanfang.baolamang.service.DishFlavorService;
import com.nanfang.baolamang.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @Autowired
    private CategorySerivce categorySerivce;

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){

        dishService.saveWithflavor(dishDto);

        return  R.success("添加成功");

    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        //添加分页构造器
        Page<Dish> pageinfo = new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        //添加条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.like(name!=null,Dish::getName,name)
                .orderByDesc(Dish::getUpdateTime);

        dishService.page(pageinfo,queryWrapper);
        //复制数据
        BeanUtils.copyProperties(pageinfo,dishDtoPage,"records");

        List<Dish> records = pageinfo.getRecords();

        //进行遍历
        List<DishDto> list = records.stream().map((item)-> {
            DishDto dishDto = new DishDto();

            BeanUtils.copyProperties(item,dishDto);

            Long  categoryid = item.getCategoryId();

            //获取分类中的信息
            Category category = categorySerivce.getById(categoryid);

            String categoryName =category.getName();

            dishDto.setCategoryName(categoryName);

            return  dishDto;


        }).collect(Collectors.toList());

        dishDtoPage.setRecords(list);

        return  R.success(dishDtoPage);



    }

    @GetMapping("/{id}")
    public R<DishDto> getDisdto(@PathVariable Long id){


        DishDto dishDto = dishService.getdishWihtflavor(id);

        return R.success(dishDto);

    }



    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){

        dishService.updateWithflavor(dishDto);

        return  R.success("更新成功");

    }


    //查询所有的菜单包括口味
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        //构造查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null ,Dish::getCategoryId,dish.getCategoryId());
        //添加条件，查询状态为1（起售状态）的菜品
        queryWrapper.eq(Dish::getStatus,1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(queryWrapper);

        List<DishDto> dishDtoList = list.stream().map((item) -> {
            DishDto dishDto = new DishDto();

            BeanUtils.copyProperties(item,dishDto);

            Long categoryId = item.getCategoryId();//分类id
            //根据id查询分类对象
            Category category = categorySerivce.getById(categoryId);

            if(category != null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }

            //当前菜品的id
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(DishFlavor::getDishId,dishId);
            //SQL:select * from dish_flavor where dish_id = ?
            List<DishFlavor> dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
            dishDto.setFlavors(dishFlavorList);
            return dishDto;
        }).collect(Collectors.toList());

        return R.success(dishDtoList);
    }



}
