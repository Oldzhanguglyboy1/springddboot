package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.pojo.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({UserBody.class})
public class HelloConfigController {
    @Value("${offcn_ip}")
    private String offcn_ip;
    @Value("${offcn_port}")
    private String offcn_port;
    @Autowired
    private UserBody userBody;
    @GetMapping("/getvalue")
    public String getValue() {
        return "ip:" + offcn_ip + "port:" + offcn_port;
    }
    @RequestMapping("/getuser")
    public String getuser(){
        return userBody.toString();
    }
}
