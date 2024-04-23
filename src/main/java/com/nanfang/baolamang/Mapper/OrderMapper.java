package com.nanfang.baolamang.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.nanfang.baolamang.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}