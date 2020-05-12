package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.pojo.User;
import com.offcn.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerDb {
    @Autowired
    UserService userService;
    /***
     * 获取全部用户信息
     * @return
     */
    @GetMapping("/")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/")
    public String createUser(User user) {
        userService.createUser(user);
        return "success";
    }

    /***
     * 获取指定id用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id")int id) {

        return userService.getUser(id);
    }
    /**
     * 更新指定id用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") int id,User user) {
        userService.updateUser(id, user);
        return "success";
    }

    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {

        userService.deleteUser(id);
        return "success";

    }

}
