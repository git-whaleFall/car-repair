package com.zrgj.dao;

import com.zrgj.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface OrderDao {

  /*查询所有订单*/
  @Select(value = "select * from orders LIMIT #{pageNo},5")
  List<Order> getAllOrder(int pageNo);

  /*根据用户查询订单*/
  @Select(value = "select * from orders where user_account=#{account}")
  List<Order> getOrderByName(String account);

  /*查询所有订单数量*/
  @Select(value = "select count(*) from orders")
  int getOrderNum();

  /*查询未处理的订单数*/
  @Select(value = "select count(*) from orders where order_state='未处理'")
  int orderNoHandler();

  /*查询已处理的订单数*/
  @Select(value = "select count(*) from orders where order_state='已处理'")
  int orderHandler();

  /*根据id查询订单*/
  @Select(value = "select * from orders where order_id=#{id}")
  Order getOrderById(int id);

  /*添加订单*/
  @Select(value = "insert into orders (car_id,fault_id,user_account,user_name,user_phone,order_time,order_state,notes) " +
          "values (#{car_id},#{fault_id},#{user_account},#{user_name},#{user_phone},#{order_time},#{state},#{notes})")
  void addOrder(String car_id, String fault_id, String user_account, String user_name, String user_phone, String order_time, String state, String notes);

  /*修改订单状态*/
  @Select(value = "update orders set order_state='已处理' where order_id=#{id}")
  void updOrderState(int id);

  /*删除订单*/
  @Select(value = "delete from orders where order_id=#{id}")
  void delOrder(int id);
}
