package com.zrgj.controller;

import com.zrgj.pojo.Car;
import com.zrgj.pojo.OperUser;
import com.zrgj.pojo.Order;
import com.zrgj.pojo.UserInfo;
import com.zrgj.service.ICarService;
import com.zrgj.service.IOperUserService;
import com.zrgj.service.IOrderService;
import com.zrgj.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {

  @Autowired
  private IOperUserService operUserService;

  @Autowired
  private IUserInfoService userInfoService;

  @Autowired
  private ICarService carService;

  @Autowired
  private IOrderService orderService;

  public OperUser loginInfo;

  @RequestMapping("/login")
  public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
    OperUser operUser = operUserService.findOperUser(username, password);
    if(operUser == null){
      model.addAttribute("msg", "账号或密码错误");
      return "login";
    }else {
      model.addAttribute("operUser", operUser);
      loginInfo = operUser;
      operUserService.updateLogin(username);
      if(operUser.getState() == 0){
        model.addAttribute("msg", "该用户已被禁用");
        return "login";
      }else {
        if(operUser.getPower() == 0){
          return "super_main";
        }else if(operUser.getPower() == 1) {
          return "admin_main";
        }else {
          return "user_main";
        }
      }
    }
  }

  @GetMapping("welcom")
  public String welcom(){
    return "welcom";
  }

  @GetMapping("home")
  public String deskTop(Model model){
    model.addAttribute("adminNum", operUserService.getUserNum(1));
    model.addAttribute("userNum", operUserService.getUserNum(2));
    model.addAttribute("name", loginInfo.getFull_name());
    model.addAttribute("carNum", carService.getCarNum());
    model.addAttribute("orderNum", orderService.getOrderNum());
    model.addAttribute("orderNoHandler", orderService.orderNoHandler());
    model.addAttribute("orderHandler", orderService.orderHandler());
    model.addAttribute("power", loginInfo.getPower());
    return "home";
  }

  @RequestMapping("/getUserInfo")
  public String getUserInfo(Model model){
    UserInfo userInfo = userInfoService.getUserInfo(loginInfo.getAccount());
    OperUser userByAccount = operUserService.getUserByAccount(loginInfo.getAccount());
    model.addAttribute("loginInfo", userByAccount);
    model.addAttribute("userInfo", userInfo);
    return "user/user-info";
  }

  @GetMapping("/updUserInfo")
  public String toUpdUserInfo(Model model){
    UserInfo userInfo = userInfoService.getUserInfo(loginInfo.getAccount());
    OperUser userByAccount = operUserService.getUserByAccount(loginInfo.getAccount());
    model.addAttribute("loginInfo", userByAccount);
    model.addAttribute("userInfo", userInfo);
    return "user/edit-user-info";
  }

  @PostMapping("/updUserInfo")
  public String updUserInfo(HttpServletRequest request, HttpServletResponse response){
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    String idCard = request.getParameter("idCard");
    String sex = request.getParameter("sex");
    int age = Integer.parseInt(request.getParameter("age"));
    String addrs = request.getParameter("addrs");
    operUserService.updUserPhone(phone, loginInfo.getAccount());
    userInfoService.updUserInfo(age, sex, idCard, email, addrs, loginInfo.getAccount());
    return "redirect:/getUserInfo";
  }

  @RequestMapping(value = "recharge")
  public void recharge(HttpServletRequest request, HttpServletResponse response) {
    String money = request.getParameter("money");
//    int price = Integer.parseInt(money);
    double price = Double.parseDouble(money);
    userInfoService.updPrice(price, loginInfo.getAccount());
  }

  @RequestMapping("/carInfo")
  public String carInfo(Model model){
    List<Car> carInfo = carService.getCarListByIf("car_owner", loginInfo.getFull_name());
    model.addAttribute("carInfo", carInfo);
    return "user/car-info";
  }

  @GetMapping("/addCar")
  public String toAddCar(){
    return "car/car-add";
  }

  @PostMapping("/addCar")
  public String addCar(HttpServletRequest request, HttpServletResponse response, Car car){
    String time = request.getParameter("time");
    carService.addCar(car, time, loginInfo.getFull_name());
    return "redirect:/carInfo";
  }

  @GetMapping("/updCarInfo/{id}")
  public String toUpdCarInfo(@PathVariable("id") Integer id, Model model) {
    Car carInfoById = carService.getCarInfoById(id);
    model.addAttribute("carInfoById", carInfoById);
    return "user/update-car";
  }

  @PostMapping("/updateCarInfo")
  public String updateCarInfo(HttpServletRequest request, HttpServletResponse response, Car car){
    String time = request.getParameter("time");
    carService.updUserInfo(car, time);
    return "redirect:/carInfo";
  }

  @GetMapping("/delCarInfo/{id}")
  public String delCarInfo(@PathVariable("id") Integer id){
    carService.delCarInfo(id);
    return "redirect:/carInfo";
  }

  @GetMapping("/updatePwd")
  public String toUpdatePwd(){
    return "user/update-pwd";
  }

  @PostMapping("/updatePwd")
  public String updatePwd(HttpServletRequest request, HttpServletResponse response){
    String pwd = request.getParameter("password");
    operUserService.updatePwd(loginInfo.getAccount(), pwd);
    return "redirect:/getUserInfo";
  }

  @GetMapping("/repairCar")
  public String repairCar(Model model){
    List<Order> orderByName = orderService.getOrderByName(loginInfo.getAccount());
    model.addAttribute("orderByName", orderByName);
    return "user/repair-car";
  }

  @GetMapping("/census")
  public String census(Model model){
    model.addAttribute("adminNum", operUserService.getUserNum(1));
    model.addAttribute("userNum", operUserService.getUserNum(2));
    model.addAttribute("carNum", carService.getCarNum());
    model.addAttribute("orderNum", orderService.getOrderNum());
    model.addAttribute("orderNoHandler", orderService.orderNoHandler());
    model.addAttribute("orderHandler", orderService.orderHandler());
    return "super/census";
  }

  @GetMapping("/notice")
  public String notice(Model model){
    double userPrice = userInfoService.getUserPrice(loginInfo.getAccount());
    model.addAttribute("userPrice", userPrice);
    return "user/notice";
  }

  @GetMapping("loginout")
  public String reBack(){
    return "login";
  }

}
