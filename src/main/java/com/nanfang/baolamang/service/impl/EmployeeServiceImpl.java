package com.nanfang.baolamang.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfang.baolamang.Mapper.EmployeeMapper;
import com.nanfang.baolamang.entity.Employee;
import com.nanfang.baolamang.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
