package com.bfd.mapper;

import com.bfd.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAllUser();

}