package com.example.controller;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.PUT)
    public @ResponseBody String findByName(@PathVariable("name") String name){

        Role loaded = roleService.findByName(name);
        System.out.println("loaded1"+loaded);
        Role cached = roleService.findByName(name);
        System.out.println("cached="+cached);
//        loaded = roleService.findByName(name);
//        System.out.println("loaded2="+loaded);
        return "ok";
    }

    @RequestMapping(value = "/save/{name}", method = RequestMethod.PUT)
    public @ResponseBody String save(@PathVariable("name") String name){
        roleService.save(new Role(name));
        return "ok";
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.PUT)
    public @ResponseBody String delete(@PathVariable("name") String name){
        Role role = roleService.findByName(name);
        roleService.delete(role);
        return "ok";
    }

}
