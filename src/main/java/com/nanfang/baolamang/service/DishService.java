package com.nanfang.baolamang.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.nanfang.baolamang.dao.DishDto;
import com.nanfang.baolamang.entity.Dish;

public interface DishService extends IService<Dish> {

    public void saveWithflavor(DishDto dishDto);

    public  DishDto getdishWihtflavor(Long id);


    public void updateWithflavor(DishDto dishDto);
}
