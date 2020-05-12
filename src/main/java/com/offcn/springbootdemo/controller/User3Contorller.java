package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.dao.User2Repository;
import com.offcn.springbootdemo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user3")
public class User3Contorller {
    @Autowired
    User2Repository personRepository;
    @GetMapping("getPerson/{name}")
    public User2 getPerson(@PathVariable String name) {
        return personRepository.getUser2(name);
    }

    @GetMapping("login/{name}/{password}")
    public User2 login(@PathVariable String name,@PathVariable int password) {
        return personRepository.login(name, password);
    }

    @GetMapping("getNamesLike/{name}")
    public List<User2> getNamesLike(@PathVariable String name) {
        return personRepository.getNamesLike(name);
    }

    @GetMapping("getPasswordisFive")
    public List<User2> getPasswordisFive() {
        return personRepository.getPasswordisFive();
    }
    @PutMapping(path="updateName/{id}/{name}")
    public int updateName(@PathVariable int id,@PathVariable String name) {
        return personRepository.UpdateName(id,name);
    }

    @DeleteMapping(path="deleteName/{name}")
    public int DeleteName(@PathVariable String name) {
        return personRepository.DeleteName(name);
    }

}
