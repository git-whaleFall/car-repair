package com.zrgj.dao;

import com.zrgj.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface UserInfoDao {

  /*根据登录名查询用户信息*/
  @Select(value = "select * from user_info where account=#{account}")
  UserInfo getUserInfo(String account);

  /*修改金额*/
  @Select(value = "update user_info set user_price=#{price} where account = #{account}")
  void updPrice(double price, String account);

  /*修改用户信息*/
  @Select(value = "update user_info set user_age=#{age},user_sex=#{sex},user_card=#{card},user_email=#{email},user_addrs=#{addrs} where account=#{account}")
  void updUserInfo(int age, String sex, String card, String email, String addrs, String account);

  /*查询余额*/
  @Select(value = "select user_price from user_info where account=#{account}")
  double getUserPrice(String account);

  /*新增用户信息*/
  @Select(value = "insert into user_info (account) values (#{name})")
  void addUserInfo(String name);

  /*删除用户信息*/
  @Select(value = "delete from user_info where account=#{name}")
  void delUserInfo(String name);
}
