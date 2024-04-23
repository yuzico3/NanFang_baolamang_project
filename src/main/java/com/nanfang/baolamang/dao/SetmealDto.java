package com.nanfang.baolamang.dao;


import com.nanfang.baolamang.entity.Setmeal;
import com.nanfang.baolamang.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
