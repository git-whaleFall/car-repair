package com.zrgj.service.impl;

import com.zrgj.dao.OperUserDao;
import com.zrgj.dao.UserInfoDao;
import com.zrgj.pojo.OperUser;
import com.zrgj.pojo.UserInfo;
import com.zrgj.service.IOperUserService;
import com.zrgj.util.SpellHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OperUserServiceImpl implements IOperUserService {

  @Autowired
  private OperUserDao operUserDao;

  @Autowired
  private UserInfoDao userInfoDao;

  @Override
  public OperUser findOperUser(String username, String password) {
    return operUserDao.findOperUser(username, password);
  }

  @Override
  public void updateLogin(String account) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    operUserDao.updateLogin(time, account);
  }

  @Override
  public int getUserNum(int count) {
    int userNum = operUserDao.getUserNum(count);
    return userNum;
  }

  @Override
  public List<OperUser> adminOrUserList(int power, int pageNo) {
    return operUserDao.adminOrUserList(power, pageNo);
  }

  @Override
  public List<OperUser> selectAdminByName(String name) {
    return operUserDao.selectAdminByName(name);
  }

  @Override
  public List<OperUser> selectUserByName(String name) {
    return operUserDao.selectUserByName(name);
  }

  @Override
  public void updateState(int state, String state_desc, String name) {
    operUserDao.updateState(state, state_desc, name);
  }

  @Override
  public OperUser getUserById(int id) {
    return operUserDao.getUserById(id);
  }

  @Override
  public OperUser getUserByAccount(String name) {
    return operUserDao.getUserByAccount(name);
  }

  @Override
  public void updAdmin(OperUser operUser) {
    String account = operUser.getAccount();
    String password = operUser.getPassword();
    String name = operUser.getFull_name();
    String phone = operUser.getPhone();
    int id = operUser.getId();
    operUserDao.updAdmin(account, password, phone, name, id);
  }

  @Override
  public void updUserPhone(String phone, String account) {
    operUserDao.updUserPhone(phone, account);
  }

  @Override
  public void updatePwd(String account, String pwd) {
    operUserDao.updatePwd(account, pwd);
  }

  @Override
  public void addAdmin(OperUser operUser) {
    String account = operUser.getAccount();
    String password = operUser.getPassword();
    String name = operUser.getFull_name();
    String phone = operUser.getPhone();
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    if(operUser.getPower() == 1){
      operUserDao.addAdmin(account, password, name, phone, time, 1,"已启用", 1, "管理员");
    }else {
      operUserDao.addAdmin(account, password, name, phone, time, 1,"已启用", 2, "普通会员");
      userInfoDao.addUserInfo(account);
    }
  }


  @Override
  public void quickAddAdmin(String name) {
    //获取拼音简码
    SpellHelper sp = new SpellHelper();
    String account = sp.convertHanzi2Pinyin(name,false);
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    operUserDao.addAdmin(account, "", name, "", time, 1,"已启用", 1, "管理员");
  }

  @Override
  public void quickAddUser(String name) {
    //获取拼音简码
    SpellHelper sp = new SpellHelper();
    String account = sp.convertHanzi2Pinyin(name,false);
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    operUserDao.addAdmin(account, "", name, "", time, 1,"已启用", 2, "普通会员");
    userInfoDao.addUserInfo(account);
  }

  @Override
  public void delUser(String name) {
    operUserDao.delUser(name);
  }

  @Override
  public List<OperUser> getUserBypower() {
    return operUserDao.getUserBypower();
  }


}
