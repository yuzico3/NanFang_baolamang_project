package com.nanfang.baolamang.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nanfang.baolamang.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
