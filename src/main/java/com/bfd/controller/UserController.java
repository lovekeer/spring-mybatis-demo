package com.bfd.controller;

import com.bfd.bean.User;
import com.bfd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> list =  userService.findAllUser();
        return list;
    }

    @RequestMapping("test")
    public Object test() {
        System.out.println("test123");
        logger.debug("this is debug level");
        logger.info("this is info level");
        logger.warn("this is warn level");
        logger.error("this is error level");
        return "test123";
    }

}
