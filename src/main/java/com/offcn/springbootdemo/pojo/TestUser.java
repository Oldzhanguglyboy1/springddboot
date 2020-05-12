package com.offcn.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "testuser")
public class TestUser implements Serializable {
    private String name;
    private String password;
    private String birthday;

}
