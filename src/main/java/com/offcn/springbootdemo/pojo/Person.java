package com.offcn.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Column(name = "password", nullable = true, length = 10)
    private String password;
    @OneToMany(mappedBy ="personId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Dog> dogs;
}
