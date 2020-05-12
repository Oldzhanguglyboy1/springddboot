package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  private List<User> listuser =Collections.synchronizedList(new ArrayList<User>());

    /**
     * 获取到全部的用户
     * @return
     */
    @GetMapping("/")
    public List<User> getUser(){
        return listuser;
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping("/")
    public String createUser(User user){
        listuser.add(user);
        return "success";
    }
    /**
     *根据id获取用户信息
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        for(User u : listuser){
            if(u.getId()==id){
                return u;
            }
        }
        return new User();
    }

    /**
     * 根据id更新用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    @ApiOperation(value="更新指定id用户信息", notes="根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    public String updateUser(@PathVariable Long id,User user){
        for(User u:listuser){
            if(u.getId()==id){
                u.setAge(user.getAge());
                u.setName(user.getName());
                return "success";
            }
        }
        return null;
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value="删除指定id用户信息", notes="根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    public String deleteUser(@PathVariable("id") Long id){
        listuser.remove(getUser(id));
        return "success";
    }
}
