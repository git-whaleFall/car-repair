package com.zrgj.dao;

import com.zrgj.pojo.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface CarDao {

  /*查询所有车辆信息*/
  @Select(value = "select * from car")
  List<Car> getCarList();

  /*根据车牌号查询车辆信息*/
  @Select(value = "select * from car where id=#{id}")
  Car getCarInfoById(int id);

  /*查询车辆数量*/
  @Select(value = "select count(*) from car")
  int getCarNum();

  /*根据车牌号查询车辆信息*/
  @Select(value = "select * from car where car_id like '%${car_id}%'")
  List<Car> getCarListById(String car_id);

  /*根据品牌查询车辆信息*/
  @Select(value = "select * from car where car_brand like '%${car_brand}%'")
  List<Car> getCarListByBrand(String car_brand);

  /*根据车主查询车辆信息*/
  @Select(value = "select * from car where car_owner like '%${car_owner}%'")
  List<Car> getCarListByOwner(String car_owner);

  /*添加车辆*/
  @Select(value = "insert into car (car_id,car_brand,car_model,car_color,car_price,car_time,car_owner)" +
          " values (#{car_id},#{car_brand},#{car_model},#{car_color},#{car_price},#{time},#{owner})")
  void addCar(String car_id, String car_brand, String car_model, String car_color, String car_price, String time, String owner);

  /*修改车辆信息*/
  @Select(value = "update car set car_id=#{car_id},car_brand=#{brand},car_model=#{model},car_color=#{color},car_price=#{price},car_time=#{time}" +
          " where id=#{id}")
  void updUserInfo(String car_id, String brand, String model, String color, String price, String time, int id);

  /*删除车辆信息*/
  @Select(value = "delete from car where id=#{id}")
  void delCarInfo(int id);

  /*根据车主账号删除*/
  @Select(value = "delete from car where car_owner=#{name}")
  void delCarByName(String name);
}
