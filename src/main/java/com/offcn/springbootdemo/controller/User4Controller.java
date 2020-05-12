package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.dao.User2Repository;
import com.offcn.springbootdemo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user4")
public class User4Controller {
    @Autowired
    User2Repository user2Repository;
    //查询包含指定账号的名称，按照id进行排序
    @GetMapping("findByNameSort/{sort}/{name}")
    public List<User2> findByName(@PathVariable("sort")String sort,@PathVariable("name") String name){
       return user2Repository.findByNameContaining(name,Sort.by(Sort.Direction.fromString(sort),"id"));
    }
    /**
     * 查询包含指定账号名称，消耗较大。可以设置游标开始位置，每页记录数，是可以按照id排序：要计算总记录数
     */
    @GetMapping("findByNamePage1/{page}/{size}/{sort}/{name}")
    public Page<User2> findByNamePage1(@PathVariable String name,
                                       @PathVariable int page,
                                       @PathVariable int size,
                                       @PathVariable String sort){
     return user2Repository.findByNameContaining(name, PageRequest.of(page,size,Sort.by(Sort.Direction.fromString(sort),"id")));
    }

    /**
     * 查询包含指定账号名称，设置游标开始位置、每页记录数，可以指定按id排序
     * 使用片段
     * @param name
     * @param page
     * @param size
     * @param sort
     * @return
     */
    @GetMapping("findByNamePage2/{page}/{size}/{sort}/{name}")
    public Slice<User2> findByNamePage2(@PathVariable String name,@PathVariable int page,@PathVariable int size,@PathVariable String sort) {
        return user2Repository.getByNameContaining(name,PageRequest.of(page,size,Sort.by(Sort.Direction.fromString(sort),"id")));
    }
}
