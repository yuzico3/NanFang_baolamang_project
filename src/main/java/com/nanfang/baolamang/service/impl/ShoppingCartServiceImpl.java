package com.nanfang.baolamang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nanfang.baolamang.Mapper.ShoppingCartMapper;
import com.nanfang.baolamang.entity.ShoppingCart;
import com.nanfang.baolamang.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
