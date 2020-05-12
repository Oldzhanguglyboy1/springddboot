package com.offcn.springbootdemo.dao;

import com.offcn.springbootdemo.pojo.User;

import java.util.List;

public interface UserDao {
    public void save(User user);

    public void update(User user);

    public void delete(int id);

    public List<User> getAll();

    public User findOne(int id);


}
