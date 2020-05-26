package com.zrgj.dao;

import com.zrgj.pojo.Fault;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface FaultDao {

  /*查询故障信息*/
  @Select(value = "select * from car_fault")
  List<Fault> faultList();

  /*修改故障状态*/
  @Select(value = "update car_fault set fault_state=#{state} where fault_id=#{fault_id}")
  void updFaultState(String state, String fault_id);

  /*添加服务*/
  @Select(value = "insert into car_fault (fault_id,fault_name,fault_price,fault_state) " +
          "values (#{id},#{name},#{price},#{state})")
  void addFault(String id, String name, double price, String state);

  /*根据状态查询信息*/
  @Select(value = "select * from car_fault where fault_state='启用'")
  List<Fault> getFaultByState();

  /*根据服务码查询价格*/
  @Select(value = "select fault_price from car_fault where fault_id=#{fault_id}")
  double getPrice(String fault_id);
}
