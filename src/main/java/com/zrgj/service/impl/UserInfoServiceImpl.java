package com.zrgj.service.impl;

import com.zrgj.dao.UserInfoDao;
import com.zrgj.pojo.UserInfo;
import com.zrgj.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

  @Autowired
  private UserInfoDao userInfoDao;


  @Override
  public UserInfo getUserInfo(String account) {
    return userInfoDao.getUserInfo(account);
  }

  @Override
  public double getUserPrice(String account) {
    return userInfoDao.getUserPrice(account);
  }

  @Override
  public void updPrice(double price, String account) {
    UserInfo userInfo = userInfoDao.getUserInfo(account);
    double money = userInfo.getUser_price();
    double totalPrice = price + money;
    userInfoDao.updPrice(totalPrice, account);
  }

  @Override
  public void updUserInfo(int age, String sex, String card, String email, String addrs, String account) {
    userInfoDao.updUserInfo(age ,sex, card, email, addrs, account);
  }


}
