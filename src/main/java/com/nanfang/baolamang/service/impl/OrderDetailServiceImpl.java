package com.nanfang.baolamang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nanfang.baolamang.Mapper.OrderDetailMapper;
import com.nanfang.baolamang.entity.OrderDetail;
import com.nanfang.baolamang.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}