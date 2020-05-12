package com.offcn.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "personId")
    private Long personId;

}
