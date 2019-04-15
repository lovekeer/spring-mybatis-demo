package com.bfd.service.impl;

import com.bfd.bean.User;
import com.bfd.mapper.UserMapper;
import com.bfd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser(){
        return  userMapper.findAllUser();
    }
}
