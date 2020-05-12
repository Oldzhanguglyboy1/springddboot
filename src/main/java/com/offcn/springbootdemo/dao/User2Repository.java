package com.offcn.springbootdemo.dao;

import com.offcn.springbootdemo.pojo.User2;
import org.hibernate.validator.constraints.LuhnCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface User2Repository extends JpaRepository<User2,Integer> {
      //查询指定用户姓名的用户
      public User2 findByNameIs(String name);
    //查询指定用户姓名和年纪都相同的用户
    public  User2 findByNameIsAndAge(String name,int age);
    //查询包含指定名字的用户
    public List<User2> findByNameContaining(String name);
    //使用query注解进行sql 语句查询
      @Query("select u from User2 u where u.name=:name")
    public User2 getUser2(@Param("name")String name);
      //根据用户名年龄查询
    @Query("select u from User2 u where u.name=:name and u.age=:age")
    public User2 login(@Param("name") String name,@Param("age")int age);
    //查询名字里边包含指定字符的
    @Query("select u from User2 u where u.name like %:name%")
    public List<User2> getNamesLike(@Param("name") String name);
    //查询年龄是五位的
    @Query(value = "select * from User2 where length(age)=5",nativeQuery = true
    )
    public List<User2> getPasswordisFive();
    //修改用户名称，使用自定义与来更新
    //只要是对数据库进行改动都需哟使用modifying
    @Modifying
    @Query(value = "UPDATE User2 u SET u.name=:name where u.id=:id")
    @Transactional(readOnly = false)
    int UpdateName(@Param("id") int id,@Param("name") String name);
    @Transactional
    @Modifying
    @Query("delete from User2 u where u.name=?1")
    int DeleteName(String name);

    //排序查询，返回list集合
    List<User2> findByNameContaining(String name, Sort sort);
   //分页查询.,查询计算元素总个数，总页数，数据量大的时候代价昂贵
    Page<User2> findByNameContaining(String name,Pageable pageable);
   //分页查询，返回的是一个片段
    Slice<User2> getByNameContaining(String name,Pageable pageable);

    //查询指定用户名称，按照id降序排列
    User2 findFirstByNameOrderByIdDesc(String name);
   //模糊查询用户名称，按照id降序排序前10条记录
    List<User2> findFirst10ByNameLikeOrderByIdDesc(String name);
    //模糊查询用户名称，按照id升序排序前10条记录
    List<User2> findFirst10ByNameLikeOrderByIdAsc(String name);
}
