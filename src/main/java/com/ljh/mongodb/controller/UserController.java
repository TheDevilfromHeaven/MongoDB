package com.ljh.mongodb.controller;

import com.alibaba.fastjson.JSON;
import com.ljh.mongodb.bean.User;
import com.ljh.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(User user){
        userService.save(user);
        return user.toString();
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable("id") final String id){
        System.out.println(id);
        User user = userService.findOne(id);
        return user.toString();
    }

    @GetMapping()
    public String findUserAll(){
        List<User> userList = userService.findAll();
        return JSON.toJSONString(userList);
    }

    @PutMapping("/{id}")
    public String updateAge(@PathVariable("id") String id,@RequestParam("age") int age){
        return userService.modifyAgeById(age,id)+"";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id){
        userService.delete(id);
        return "删除成功！";
    }
}
