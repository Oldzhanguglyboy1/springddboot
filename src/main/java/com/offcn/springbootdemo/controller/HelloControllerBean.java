package com.offcn.springbootdemo.controller;


import com.offcn.springbootdemo.pojo.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(TestUser.class)
public class HelloControllerBean {
    @Autowired
    TestUser testUser;

    @GetMapping("/gettestuser")
    public String gettestUser() {
        return testUser.toString();
    }

}
