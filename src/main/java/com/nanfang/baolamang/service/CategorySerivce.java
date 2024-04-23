package com.nanfang.baolamang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfang.baolamang.entity.Category;

public interface CategorySerivce extends IService<Category> {
    //判断是否与菜品，套餐关联之后删除的方法

    public void removeByid(Long id);


}
