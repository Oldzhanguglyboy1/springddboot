package com.offcn.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "userbody")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBody {
    private String name;
    private String password;
    private String birthday;
    private String mobile;
    private String address;

}
