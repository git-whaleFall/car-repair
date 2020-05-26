package com.zrgj.service;

import com.zrgj.pojo.UserInfo;

import java.util.*;

public interface IUserInfoService {

  UserInfo getUserInfo(String account);

  double getUserPrice(String account);

  void updPrice(double price, String account);

  void updUserInfo(int age, String sex, String card, String email, String addrs, String account);

}
