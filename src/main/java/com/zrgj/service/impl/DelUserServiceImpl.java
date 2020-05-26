package com.zrgj.service.impl;

import com.zrgj.dao.CarDao;
import com.zrgj.dao.DelUserDao;
import com.zrgj.dao.OperUserDao;
import com.zrgj.dao.UserInfoDao;
import com.zrgj.pojo.DelUser;
import com.zrgj.pojo.OperUser;
import com.zrgj.service.IDelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DelUserServiceImpl implements IDelUserService {

  @Autowired
  private DelUserDao delUserDao;

  @Autowired
  private OperUserDao operUserDao;

  @Autowired
  private UserInfoDao userInfoDao;

  @Autowired
  private CarDao carDao;

  @Override
  public List<DelUser> delUserList(int pageNo) {
    return delUserDao.delUserList(pageNo);
  }

  @Override
  public void addDelUser(OperUser operUser) {
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    delUserDao.addDelUser(operUser.getAccount(), operUser.getPassword(), operUser.getFull_name(),
            operUser.getPhone(), time);
  }

  @Override
  public void deleteDelUser(String account) {
    DelUser delUser = delUserDao.getDelUser(account);
    String name = delUser.getDel_name();
    delUserDao.deleteDelUser(account);
    userInfoDao.delUserInfo(account);
    carDao.delCarByName(name);
  }

  @Override
  public DelUser getDelUser(String name) {
    return delUserDao.getDelUser(name);
  }

  @Override
  public void recoverDelUser(DelUser delUser) {
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    operUserDao.addAdmin(delUser.getDel_account(), delUser.getDel_password(), delUser.getDel_name(), delUser.getDel_phone(),
            time, 1, "已启用", 2, "普通用户");
    delUserDao.deleteDelUser(delUser.getDel_account());
  }

  @Override
  public int getDelUserCount() {
    return delUserDao.getDelUserCount();
  }


}
