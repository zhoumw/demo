package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhoumw on 2016/12/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.PUT)
    public @ResponseBody String findByName(@PathVariable("name") String name){

        User loaded = userService.findByName(name);
        System.out.println("loaded1"+loaded);
        User cached = userService.findByName(name);
        System.out.println("cached="+cached);
//        loaded = userService.findByName(name);
//        System.out.println("loaded2="+loaded);
        return "ok";
    }

    @RequestMapping(value = "/save/{name}", method = RequestMethod.PUT)
    public @ResponseBody String save(@PathVariable("name") String name){
        userService.save(new User(name, 10));
        return "ok";
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.PUT)
    public @ResponseBody String delete(@PathVariable("name") String name){
        User user = userService.findByName(name);
        userService.delete(user);
        return "ok";
    }

}
