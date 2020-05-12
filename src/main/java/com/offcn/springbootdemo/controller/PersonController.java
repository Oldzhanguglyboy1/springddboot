package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.dao.PersonRepository;
import com.offcn.springbootdemo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping("findPerson/{id}")
    public Person findPerson(@PathVariable("id") Long id){
         return personRepository.findPerson(id);
    }
}
