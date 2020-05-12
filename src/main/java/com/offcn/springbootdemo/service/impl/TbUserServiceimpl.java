package com.offcn.springbootdemo.service.impl;

import com.offcn.springbootdemo.dao.UserDao;
import com.offcn.springbootdemo.pojo.User;
import com.offcn.springbootdemo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceimpl implements TbUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getAll();
    }

    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void updateUser(int id, User user) {
        user.setId(id);
        userDao.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

}
