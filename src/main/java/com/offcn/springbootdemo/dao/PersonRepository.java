package com.offcn.springbootdemo.dao;

import com.offcn.springbootdemo.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person,Long>{
    @Query("select p from Person p where p.id=:id")
    Person findPerson(@Param("id")Long id);
}
