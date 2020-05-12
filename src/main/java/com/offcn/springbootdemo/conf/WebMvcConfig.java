package com.offcn.springbootdemo.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      /*//将所有D:\\springboot\\pic\\ 访问都映射到/myPic/** 路径下
      registry.addResourceHandler("/myPic/**").addResourceLocations("file:E:\\file\\bbb\\");*/
      /*registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/demo/0.0.1/");*/
     registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
     .resourceChain(true);//加入resourceChain属性，不然还是去除了版本是路径找不到
    }
}
