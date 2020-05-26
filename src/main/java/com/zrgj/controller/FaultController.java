package com.zrgj.controller;

import com.zrgj.pojo.Fault;
import com.zrgj.service.IFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FaultController {

  @Autowired
  private IFaultService faultService;

  @RequestMapping("/faultList")
  public String faultList(Model model){
    List<Fault> faults = faultService.faultList();
    model.addAttribute("faults", faults);
    return "car/fault-list";
  }

  @GetMapping("/addFault")
  public String toAddFault(){
    return "car/fault-add";
  }

  @PostMapping("/addFault")
  public String addFault(Fault fault){
    faultService.addFault(fault);
    return "redirect:/faultList";
  }
}
