package com.zrgj.dao;

import com.zrgj.pojo.OperUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface OperUserDao {

  /*根据账号密码查询用户*/
  @Select(value = "select * from oper_user where account=#{username} and password=#{password}")
  OperUser findOperUser(String username, String password);

  /*修改登录信息*/
  @Select(value = "update oper_user set login_time=#{time} where account=#{account}")
  void updateLogin(String time, String account);

  /*查询管理员或用户数量*/
  @Select(value = "select count(*) from oper_user where power=#{count}")
  int getUserNum(int count);

  /*分权限查询注册用户*/
  @Select(value = "select * from oper_user where power=#{power} LIMIT #{pageNo},5")
  List<OperUser> adminOrUserList(int power, int pageNo);

  /*修改用户状态*/
  @Select(value = "update oper_user set state=#{state},state_desc=#{state_desc} where account=#{name}")
  void updateState(int state, String state_desc, String name);

  /*根据id查询用户*/
  @Select(value = "select * from oper_user where id=#{id}")
  OperUser getUserById(int id);

  /*根据名字模糊查询管理员*/
  @Select(value = "select * from oper_user where power=1 and full_name like '%${name}%'")
  List<OperUser> selectAdminByName(String name);

  /*根据名字模糊查询普通会员*/
  @Select(value = "select * from oper_user where power=2 and full_name like '%${name}%'")
  List<OperUser> selectUserByName(String name);

  /*根据account查询用户*/
  @Select(value = "select * from oper_user where account=#{name}")
  OperUser getUserByAccount(String name);

  /*修改用户手机*/
  @Select(value = "update oper_user set phone=#{phone} where account=#{account}")
  void updUserPhone(String phone, String account);

  /*修改用户信息*/
  @Select(value = "update oper_user set account=#{account},password=#{password},full_name=#{full_name},phone=#{phone} where id=#{id}")
  void updAdmin(String account, String password, String phone, String full_name, int id);

  /*修改用户密码*/
  @Select(value = "update oper_user set password=#{pwd} where account=#{account}")
  void updatePwd(String account, String pwd);

  /*添加用户*/
  @Select(value = "insert into oper_user (account,password,full_name,phone,create_time,state,state_desc,power,power_desc)" +
          "values (#{account},#{password},#{name},#{phone},#{create_time},#{state},#{state_desc},#{power},#{power_desc})")
  void addAdmin(String account, String password, String name, String phone,
                String create_time, int state, String state_desc, int power, String power_desc);

  /*查询在用的普通会员*/
  @Select(value = "select * from oper_user where power=2 and state=1")
  List<OperUser> getUserBypower();

  /*删除用户*/
  @Select(value = "delete from oper_user where account=#{name}")
  void delUser(String name);
}
