package com.offcn.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User2 {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name",length = 20,nullable = true)
    private String name;
    @Column(name = "age",nullable = true,length = 4)
    private Integer age;
}
