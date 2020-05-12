package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.dao.User2Repository;
import com.offcn.springbootdemo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/person")
public class User2Controller {
    @Autowired
    User2Repository personRepository;
    /**
     * 向数据库中增加数据1
     */
    @PostMapping(path = "addPerson")
    public void addUser(@RequestBody User2 user2){
        personRepository.save(user2);
    }
    /**
     * 获取数据库中的所哟数据
     */
    @GetMapping(path = "getAllUser")
    public List<User2> getUser(){
        return personRepository.findAll();
    }
    /**
     * 删除数据库中的数据
     */
    @DeleteMapping(path = "deleteUser")
    public void deleteUser(@RequestParam int id){
        personRepository.deleteById(id);
    }
    /**
     * 更改数据
     */
    @PutMapping(path = "updateUser")
    public void updateUser(@RequestBody User2 user){
         personRepository.saveAndFlush(user);
    }

    /**
     * 根据名字查询用户
     * @param name
     * @return
     */
    @GetMapping("/findByNameIs/{name}")
    public User2 findByNameIs(@PathVariable("name")String name){
      return personRepository.findByNameIs(name);
    }

    /**
     * 根据用户名密码查询用户
     * @param name
     * @param age
     * @return
     */
    @GetMapping("findByNameIsAndPassword/{name}/{age}")
    public User2 findByNameIsAnAge(@PathVariable("name") String name,@PathVariable("age") int age){
        return personRepository.findByNameIsAndAge(name,age);
    }
    @GetMapping("findByNameContaining/{name}")
    public List<User2> findByNameContaining(@PathVariable("name") String name){
         return  personRepository.findByNameContaining(name);
    }
}
