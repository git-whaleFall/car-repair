package com.zrgj.service;

import com.zrgj.pojo.Car;

import java.util.*;

public interface ICarService {

  List<Car> getCarList();

  Car getCarInfoById(int id);

  int getCarNum();

  List<Car> getCarListByIf(String carSort, String value);

  void addCar(Car car, String time, String owner);

  void updUserInfo(Car car, String time);

  void delCarInfo(int id);
}
