package com.nanfang.baolamang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfang.baolamang.Mapper.UserMapper;
import com.nanfang.baolamang.entity.User;
import com.nanfang.baolamang.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
