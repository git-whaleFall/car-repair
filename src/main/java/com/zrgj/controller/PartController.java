package com.zrgj.controller;

import com.zrgj.pojo.Part;
import com.zrgj.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PartController {

  @Autowired
  private IPartService partService;


  @GetMapping("/stockPart")
  public String getAllParts(Model model){
    List<Part> allPart = partService.getAllPart();
    model.addAttribute("allPart", allPart);
    return "part/stock-part";
  }
}
