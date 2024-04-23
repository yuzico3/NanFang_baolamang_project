package com.nanfang.baolamang.dao;

import com.nanfang.baolamang.entity.Dish;
import com.nanfang.baolamang.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
