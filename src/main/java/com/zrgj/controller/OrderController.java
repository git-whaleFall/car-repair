package com.zrgj.controller;

import com.zrgj.pojo.Fault;
import com.zrgj.pojo.OperUser;
import com.zrgj.pojo.Order;
import com.zrgj.service.IFaultService;
import com.zrgj.service.IOperUserService;
import com.zrgj.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {

  @Autowired
  private IOrderService orderService;

  @Autowired
  private IFaultService faultService;

  @Autowired
  private IOperUserService operUserService;

  @RequestMapping("/getOrderList")
  public String getOrderList(String pageNum, Model model){
    //页数
    int pageNo = 0;
    if(pageNum == null){
      pageNo = 1;
    }else {
      pageNo = Integer.valueOf(pageNum);
      if(pageNo <= 0){
        pageNo = 1;
      }
    }
    //数据总数
    int totalCount = orderService.getOrderNum();
    //最大页数
    int maxPage = totalCount%5==0?totalCount/5:totalCount/5+1;
    if(maxPage != 0) {
      if(pageNo > maxPage){
        pageNo = maxPage;
      }
    }
    int tempPageNo = (pageNo - 1) * 5;
    List<Order> allOrder = orderService.getAllOrder(tempPageNo);
    model.addAttribute("allOrder", allOrder);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("maxPage", maxPage);
    return "order/order-list2";
  }

  @GetMapping("addOrder")
  public String toAddOrder(Model model){
    List<Fault> faultByState = faultService.getFaultByState();
    List<OperUser> userBypower = operUserService.getUserBypower();
    model.addAttribute("userBypower", userBypower);
    model.addAttribute("faultByState", faultByState);
    return "order/order-add2";
  }

  @PostMapping("/addOrder")
  public String addOrder(Order order){
    orderService.addOrder(order);
    return "redirect:/getOrderList";
  }
}
