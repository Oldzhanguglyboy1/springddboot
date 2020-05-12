package com.offcn.springbootdemo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    //设置最大值
    @Max(value = 100,message = "id不能大于100")
    private Integer id;
    //不为空白并且字符串长度再2-10
    @NotBlank(message = "名字不能为空")
    @Length(min = 2,max = 10,message = "用户名 长度必须在 {min} -{max}之间")
    /*@Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",
            message = "手机号格式不合法")*/
    private String name;
    //判断最大值与最小值 max是判断整数类型，DecimalMin判断字符串
    @DecimalMin(value = "1.0",message = "价格最低1.0元")
    @DecimalMax(value = "10",message = "价格最高10元")
    private Float price;
    //时间格式转化，两个都一样
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdate;
    //忽略字段不转换为json
    @JsonIgnore
    private String memo;
    //设置当属性值为空时，不转换为json
    @JsonInclude
    @NotNull(message = "属性字段不能为空")
    @NotBlank(message = "属性字段不能为空白")
    private String isnull;
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",
            message = "邮箱格式不合法")
    private String email;
}
