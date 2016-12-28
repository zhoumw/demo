package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhoumw on 2016/12/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public @ResponseBody String findByName(){

        User loaded = userService.findByName("BBB");
        System.out.println("loaded1"+loaded);
        User cached = userService.findByName("BBB");
        System.out.println("cached="+cached);
        loaded = userService.findByName("CCC");
        System.out.println("loaded2="+loaded);
        return "ok";
    }

    @RequestMapping("/save")
    public @ResponseBody String save(String name){
        userService.save(new User(name, 10));
        return "ok";
    }

    @RequestMapping("/delete")
    public @ResponseBody String delete(String name){
        User user = userService.findByName("BBB");
        userService.delete(user);
        return "ok";
    }

}
