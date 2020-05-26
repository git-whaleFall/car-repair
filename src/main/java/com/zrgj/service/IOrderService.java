package com.zrgj.service;

import com.zrgj.pojo.Order;

import java.util.*;

public interface IOrderService {

  List<Order> getAllOrder(int pageNo);

  List<Order> getOrderByName(String account);

  int getOrderNum();

  int orderNoHandler();

  int orderHandler();

  void addOrder(Order order);

  void updOrderState(int id);

  void delOrder(int id);
}
