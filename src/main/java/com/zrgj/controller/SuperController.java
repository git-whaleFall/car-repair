package com.zrgj.controller;

import com.zrgj.pojo.OperUser;
import com.zrgj.service.IOperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class SuperController {

  @Autowired
  private IOperUserService operUserService;

  @RequestMapping("/adminList")
  public String adminList(String pageNum, Model model) {
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
    int totalCount = operUserService.getUserNum(1);
    //最大页数
    int maxPage = totalCount%5==0?totalCount/5:totalCount/5+1;
    if(maxPage != 0) {
      if(pageNo > maxPage){
        pageNo = maxPage;
      }
    }
    int tempPageNo = (pageNo - 1) * 5;
    List<OperUser> adminList = operUserService.adminOrUserList(1, tempPageNo);
    model.addAttribute("adminList", adminList);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("maxPage", maxPage);
    return "super/admin-list";
  }

  @RequestMapping("/userList")
  public String userList(String pageNum, Model model){
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
    int totalCount = operUserService.getUserNum(2);
    //最大页数
    int maxPage = totalCount%5==0?totalCount/5:totalCount/5+1;
    if(maxPage != 0) {
      if(pageNo > maxPage){
        pageNo = maxPage;
      }
    }
    int tempPageNo = (pageNo - 1) * 5;
    List<OperUser> userList = operUserService.adminOrUserList(2, tempPageNo);
    model.addAttribute("userList", userList);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("maxPage", maxPage);
    return "super/user-list";
  }

  @GetMapping("/updateAdmin/{id}")
  public String updateAdmin(Model model, @PathVariable("id") Integer id) {
    OperUser userById = operUserService.getUserById(id);
    model.addAttribute("userById", userById);
    return "super/admin-edit";
  }

  @GetMapping("/updateUser/{id}")
  public String updateUser(Model model, @PathVariable("id") Integer id) {
    OperUser userById = operUserService.getUserById(id);
    model.addAttribute("userById", userById);
    return "super/user-edit";
  }

  @GetMapping("/addAdmin")
  public String toAddAdmin(){
    return "super/admin-add";
  }

  @PostMapping("/addAdmin")
  public String addAdmin(OperUser operUser){
    int power = operUser.getPower();
    operUserService.addAdmin(operUser);
    if(power == 1){
      return "redirect:/adminList";
    }else {
      return "redirect:/userList";
    }
  }

  @PostMapping("/updAdmin")
  public String updAdmin(OperUser operUser){
    int power = operUser.getPower();
    operUserService.updAdmin(operUser);
    if(power == 1){
      return "redirect:/adminList";
    }else {
      return "redirect:/userList";
    }
  }

  @PostMapping("/quickAddAdmin")
  public String quickAddAdmin(HttpServletRequest request, HttpServletResponse response){
    String name = request.getParameter("name");
    operUserService.quickAddAdmin(name);
    return "redirect:/adminList";
  }

  @PostMapping("/quickAddUser")
  public String quickAddUser(HttpServletRequest request, HttpServletResponse response){
    String name = request.getParameter("name");
    operUserService.quickAddUser(name);
    return "redirect:/adminList";
  }

  @PostMapping("/selectAdminByName")
  public String selectAdminByName(String username, Model model){
    List<OperUser> operUsers = operUserService.selectAdminByName(username);
    model.addAttribute("adminList", operUsers);
    return "super/admin-list";
  }

  @PostMapping("/selectUserByName")
  public String selectUserByName(String username, Model model){
    List<OperUser> operUsers = operUserService.selectUserByName(username);
    model.addAttribute("userList", operUsers);
    return "super/user-list";
  }

  @GetMapping("/buyPart")
  public String buyPart(){

    return "part/part-list";
  }


}
