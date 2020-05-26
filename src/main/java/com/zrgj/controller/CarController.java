package com.zrgj.controller;

import com.zrgj.pojo.Car;
import com.zrgj.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CarController {

  @Autowired
  private ICarService carService;

  @RequestMapping("/carList")
  public String carList(Model model){
    List<Car> carList = carService.getCarList();
    model.addAttribute("carList", carList);
    return "car/car-list";
  }

  @PostMapping("/selectCar")
  public String selectCar(HttpServletRequest request, HttpServletResponse response, Model model){
    String carSort = request.getParameter("carSort");
    String keyword = request.getParameter("keyword");
    List<Car> carListByIf = carService.getCarListByIf(carSort, keyword);
    model.addAttribute("carList", carListByIf);
    return "car/car-list";
  }
}
