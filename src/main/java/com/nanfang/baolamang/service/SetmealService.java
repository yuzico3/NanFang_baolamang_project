package com.nanfang.baolamang.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.nanfang.baolamang.dao.SetmealDto;
import com.nanfang.baolamang.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void  removeWithDish(List<Long> ids);
}
