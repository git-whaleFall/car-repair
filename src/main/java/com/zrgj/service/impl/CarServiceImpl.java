package com.zrgj.service.impl;

import com.zrgj.dao.CarDao;
import com.zrgj.pojo.Car;
import com.zrgj.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

  @Autowired
  private CarDao carDao;

  @Override
  public List<Car> getCarList() {
    return carDao.getCarList();
  }

  @Override
  public Car getCarInfoById(int id) {
    return carDao.getCarInfoById(id);
  }

  @Override
  public int getCarNum() {
    int carNum = carDao.getCarNum();
    return carNum;
  }

  @Override
  public List<Car> getCarListByIf(String carSort, String value) {
    List<Car> carListByIf = new ArrayList<Car>();
    if("car_id".equals(carSort)){
      carListByIf = carDao.getCarListById(value);
    }else if("car_brand".equals(carSort)) {
      carListByIf = carDao.getCarListByBrand(value);
    }else {
      carListByIf = carDao.getCarListByOwner(value);
    }
    return carListByIf;
  }

  @Override
  public void addCar(Car car, String time, String owner) {
    carDao.addCar(car.getCar_id(), car.getCar_brand(), car.getCar_model(), car.getCar_color(), car.getCar_price(), time, owner);
  }

  @Override
  public void updUserInfo(Car car, String time) {
    carDao.updUserInfo(car.getCar_id(), car.getCar_brand(), car.getCar_model(), car.getCar_color(), car.getCar_price(), time, car.getId());
  }

  @Override
  public void delCarInfo(int id) {
    carDao.delCarInfo(id);
  }
}
