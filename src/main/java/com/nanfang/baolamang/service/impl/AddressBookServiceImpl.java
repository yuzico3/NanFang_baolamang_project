package com.nanfang.baolamang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nanfang.baolamang.Mapper.AddressBookMapper;
import com.nanfang.baolamang.entity.AddressBook;
import com.nanfang.baolamang.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
