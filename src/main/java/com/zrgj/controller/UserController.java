package com.zrgj.controller;

import com.zrgj.pojo.OperUser;
import com.zrgj.pojo.Order;
import com.zrgj.service.IOperUserService;
import com.zrgj.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private IOrderService orderService;

  /*@RequestMapping("/repairCar")
  public String repairCar(Model model){
    List<Order> allOrder = orderService.getAllOrder();
    model.addAttribute()
    return "user/repair-car";
  }*/


}
