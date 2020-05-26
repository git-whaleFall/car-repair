package com.zrgj.controller;

import com.zrgj.pojo.DelUser;
import com.zrgj.pojo.OperUser;
import com.zrgj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AjaxController {

  @Autowired
  private IOperUserService operUserService;

  @Autowired
  private IDelUserService delUserService;

  @Autowired
  private IFaultService faultService;

  @Autowired
  private IOrderService orderService;

  @Autowired
  private IPartService partService;

  @RequestMapping(value = "changeState")
  @ResponseBody
  public void changeState(HttpServletRequest request, HttpServletResponse response){
    String state = request.getParameter("state");
    String name = request.getParameter("name");
    if("停用".equals(state)){
      operUserService.updateState(0, "已停用", name);
    }else {
      operUserService.updateState(1, "已启用", name);
    }
  }

  @RequestMapping(value = "delAdmin")
  @ResponseBody
  public void delAdmin(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    OperUser userByAccount = operUserService.getUserByAccount(name);
    operUserService.delUser(name);
    delUserService.addDelUser(userByAccount);
  }

  @RequestMapping(value = "deleteDelUser")
  @ResponseBody
  public void deleteDelUser(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    delUserService.deleteDelUser(name);
  }

  @RequestMapping(value = "recoverDelUser")
  @ResponseBody
  public void recoverDelUser(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    DelUser delUser = delUserService.getDelUser(name);
    delUserService.recoverDelUser(delUser);
  }


  @RequestMapping(value = "faultState")
  @ResponseBody
  public void faultState(HttpServletRequest request, HttpServletResponse response) {
    String state = request.getParameter("state");
    String name = request.getParameter("name");
    faultService.updFaultState(state, name);
  }

  @RequestMapping(value = "changeOrderState")
  @ResponseBody
  public void changeOrderState(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    int id = Integer.parseInt(name);
    orderService.updOrderState(id);
  }

  @RequestMapping(value = "delOrder")
  @ResponseBody
  public void delOrder(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    int id = Integer.parseInt(name);
    orderService.delOrder(id);
  }

  @RequestMapping(value = "subPart")
  @ResponseBody
  public void subPart(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    String count = request.getParameter("count");
    int id = Integer.parseInt(name);
    int num = Integer.parseInt(count);
    partService.updPartNum(id, num);
  }

  @RequestMapping(value = "delPart")
  @ResponseBody
  public void delPart(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    int id = Integer.parseInt(name);
    partService.delPart(id);
  }

  @RequestMapping(value = "buyParts")
  @ResponseBody
  public void buyPart(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    int count = partService.getCount(name);
    if(count == 0){
      partService.addPart(name, price, 1);
    }else {
      int partNum = partService.getPartNum(name);
      partNum += 1;
      partService.updPartNumByName(name, partNum);
    }
  }

  /*@RequestMapping(value = "deleteCarInfo")
  @ResponseBody
  public void delCarInfo(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("---------------");
    String name = request.getParameter("name");
    System.out.println("name:"+name);
  }*/

  /*@RequestMapping(value = "recharge")
  @ResponseBody
  public void recharge(HttpServletRequest request, HttpServletResponse response) {
    String money = request.getParameter("money");
    int price = Integer.parseInt(money);
    System.out.println(price);

  }*/


  /*@RequestMapping(value = "quickAddAdmin")
  public String addAdmin(HttpServletRequest request, HttpServletResponse response){
    String name = request.getParameter("name");
    System.out.println(name);
    return "";
  }*/
}
