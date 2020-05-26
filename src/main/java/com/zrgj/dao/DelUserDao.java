package com.zrgj.dao;

import com.zrgj.pojo.DelUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface DelUserDao {

  /*查询减员人员库人员*/
  @Select(value = "select * from del_user LIMIT #{pageNo},5")
  List<DelUser> delUserList(int pageNo);

  /*添加减员人员库人员*/
  @Select(value = "insert into del_user (del_account,del_password,del_name,del_phone,del_time) " +
          "values (#{del_account},#{del_password},#{del_name},#{del_phone},#{del_time})")
  void addDelUser(String del_account, String del_password, String del_name,String del_phone, String del_time);

  /*删除减员人员库中的人员*/
  @Select(value = "delete from del_user where del_account=#{name}")
  void deleteDelUser(String name);

  /*根据account查询减员人员库人员信息*/
  @Select(value = "select * from del_user where del_account=#{name}")
  DelUser getDelUser(String name);

  /*查询人员库数量*/
  @Select(value = "select count(*) from del_user")
  int getDelUserCount();
}
