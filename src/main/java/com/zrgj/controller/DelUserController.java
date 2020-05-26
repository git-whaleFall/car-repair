package com.zrgj.controller;

import com.zrgj.pojo.DelUser;
import com.zrgj.service.IDelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DelUserController {

  @Autowired
  private IDelUserService delUserService;

  @RequestMapping("/toDelUser")
  public String toDelUser(String pageNum, Model model){
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
    int totalCount = delUserService.getDelUserCount();
    //最大页数
    int maxPage = totalCount%5==0?totalCount/5:totalCount/5+1;
    if(maxPage != 0) {
      if(pageNo > maxPage){
        pageNo = maxPage;
      }
    }
    int tempPageNo = (pageNo - 1) * 5;
    List<DelUser> delUsers = delUserService.delUserList(tempPageNo);
    model.addAttribute("delUsers", delUsers);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("maxPage", maxPage);
    return "super/user-del";
  }


}
