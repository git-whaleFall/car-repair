package com.zrgj.service;

import com.zrgj.pojo.OperUser;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOperUserService {

  OperUser findOperUser(String username, String password);

  void updateLogin(String account);

  int getUserNum(int count);

  List<OperUser> adminOrUserList(int power, int pageNo);

  List<OperUser> selectAdminByName(String name);

  List<OperUser> selectUserByName(String name);

  void updateState(int state, String state_desc, String name);

  OperUser getUserById(int id);

  OperUser getUserByAccount(String name);

  void updAdmin(OperUser operUser);

  void updUserPhone(String phone, String account);

  void updatePwd(String account, String pwd);

  void addAdmin(OperUser operUser);

  void quickAddAdmin(String name);

  void quickAddUser(String name);

  void delUser(String name);

  List<OperUser> getUserBypower();
}
