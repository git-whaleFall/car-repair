package com.zrgj.service.impl;

import com.zrgj.dao.FaultDao;
import com.zrgj.dao.OrderDao;
import com.zrgj.dao.UserInfoDao;
import com.zrgj.pojo.Order;
import com.zrgj.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

  @Autowired
  private OrderDao orderDao;
  
  @Autowired
  private FaultDao faultDao;

  @Autowired
  private UserInfoDao userInfoDao;

  @Override
  public List<Order> getAllOrder(int pageNo) {
    return orderDao.getAllOrder(pageNo);
  }

  @Override
  public List<Order> getOrderByName(String account) {
    return orderDao.getOrderByName(account);
  }

  @Override
  public int getOrderNum() {
    return orderDao.getOrderNum();
  }

  @Override
  public int orderNoHandler() {
    return orderDao.orderNoHandler();
  }

  @Override
  public int orderHandler() {
    return orderDao.orderHandler();
  }

  @Override
  public void addOrder(Order order) {
    //获取当前系统时间
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String time = df.format(date);
    orderDao.addOrder(order.getCar_id(), order.getFault_id(), order.getUser_account(), order.getUser_name(), order.getUser_phone(), time,"未处理", order.getNotes());
  }

  @Override
  public void updOrderState(int id) {
    Order orderById = orderDao.getOrderById(id);
    String fault_id = orderById.getFault_id();
    String user_account = orderById.getUser_account();
    double price = faultDao.getPrice(fault_id);
    double userPrice = userInfoDao.getUserPrice(user_account);
    double money = userPrice - price;
    userInfoDao.updPrice(money, user_account);
    orderDao.updOrderState(id);
  }

  @Override
  public void delOrder(int id) {
    orderDao.delOrder(id);
  }
}
