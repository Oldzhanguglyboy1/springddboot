package com.offcn.springbootdemo.controller;

import com.offcn.springbootdemo.pojo.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/zy")
@Validated
public class demo{
    @RequestMapping(path = "/hellow",method= RequestMethod.GET)
    public String hellow(){
        return "HELLOW WORD";
    }
    @RequestMapping(path = "/car1",method = RequestMethod.GET)
    public Car getcart(){
        Car cart = new Car();
        cart.setId(10);
        cart.setName("毛驴");
        cart.setPrice(1000.00f);
        cart.setCreatedate(new Date());
        return cart;
    }
    @RequestMapping("/getall")
    public List<Car> getAll(){
        ArrayList<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setId(1);
        car.setName("毛驴");
        car.setPrice(1F);
        car.setCreatedate(new Date());
        cars.add(car);
        cars.add(car);
        cars.add(car);
        cars.add(car);
        return cars;
    }
    @RequestMapping("/two/{id}")
    public Car car(@PathVariable(name="id")int id, @RequestParam(name = "name")String name){
        Car car = new Car();
        car.setId(id);
        car.setName(name);
        return car;
    }
    @RequestMapping("/car")
    public Car getcar(@RequestBody Car car){
        return car;
    }
    @RequestMapping("getcar")
    public Car getcarbyid(Car car){
        return car;
    }
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
    @RequestMapping("/valid2")
    public String param(@NotBlank(message = "group不能为空")
                        @RequestParam("group") String group,

                        @NotBlank(message = "email不能为空")
                        @Email(message="不符合邮箱规格")
                        @RequestParam("email") String email) {
        return group + ":" + email;
    }
    @RequestMapping("/getcaraa")
   public Car getcaraa(@RequestBody @Validated Car car){
        return car;
   }
   @RequestMapping("/carvalid2")
   public String getcarvalidate(@Validated Car car, BindingResult bindingResult){
         if(bindingResult.hasErrors()){
             return bindingResult.getFieldError().getDefaultMessage();
         }
         return car.toString();
   }
}
