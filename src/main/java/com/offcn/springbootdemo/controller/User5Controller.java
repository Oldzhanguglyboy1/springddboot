package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.dao.User2Repository;
import com.offcn.springbootdemo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user5")
public class User5Controller {
    @Autowired
    User2Repository user2Repository;
    //根据名字获取第一条数据降序排列
    @GetMapping("findFirstByNameOrderByIdDesc/{name}")
    public User2 findFirstByNameOrderByIdDesc(@PathVariable("name") String name){
        return user2Repository.findFirstByNameOrderByIdDesc(name);
    }
    //模糊查询用户名称，按照id降序排序前10条记录
    @GetMapping("findTopByNameOrderByIdAsc/{name}")
    public List<User2> findTopByNameOrderByIdAsc(@PathVariable("name") String name){
        return user2Repository.findFirst10ByNameLikeOrderByIdDesc("%"+name+"%");
    }
    //模糊查询用户名称，按照id升序排序前10条记录
    @GetMapping("findTop10ByNameLikeOrderByIdAsc/{name}")
    public List<User2> findTop10ByNameLikeOrderByIdAsc(@PathVariable("name") String name){
        return user2Repository.findFirst10ByNameLikeOrderByIdAsc("%"+name+"%");
    }
}
