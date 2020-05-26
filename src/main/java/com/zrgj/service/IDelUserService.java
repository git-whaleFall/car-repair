package com.zrgj.service;

import com.zrgj.pojo.DelUser;
import com.zrgj.pojo.OperUser;

import java.util.List;

public interface IDelUserService {

  List<DelUser> delUserList(int pageNo);

  void addDelUser(OperUser operUser);

  void deleteDelUser(String name);

  DelUser getDelUser(String name);

  void recoverDelUser(DelUser delUser);

  int getDelUserCount();
}
