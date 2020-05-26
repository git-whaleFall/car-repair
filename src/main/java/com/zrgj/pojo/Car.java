package com.zrgj.pojo;

public class Car {
  private int id;
  private String car_id;
  private String car_brand;
  private String car_model;
  private String car_color;
  private String car_price;
  private String car_time;
  private String car_owner;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCar_id() {
    return car_id;
  }

  public void setCar_id(String car_id) {
    this.car_id = car_id;
  }

  public String getCar_brand() {
    return car_brand;
  }

  public void setCar_brand(String car_brand) {
    this.car_brand = car_brand;
  }

  public String getCar_model() {
    return car_model;
  }

  public void setCar_model(String car_model) {
    this.car_model = car_model;
  }

  public String getCar_color() {
    return car_color;
  }

  public void setCar_color(String car_color) {
    this.car_color = car_color;
  }

  public String getCar_price() {
    return car_price;
  }

  public void setCar_price(String car_price) {
    this.car_price = car_price;
  }

  public String getCar_time() {
    return car_time;
  }

  public void setCar_time(String car_time) {
    this.car_time = car_time;
  }

  public String getCar_owner() {
    return car_owner;
  }

  public void setCar_owner(String car_owner) {
    this.car_owner = car_owner;
  }

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", car_id='" + car_id + '\'' +
            ", car_brand='" + car_brand + '\'' +
            ", car_model='" + car_model + '\'' +
            ", car_color='" + car_color + '\'' +
            ", car_price='" + car_price + '\'' +
            ", car_time='" + car_time + '\'' +
            ", car_owner='" + car_owner + '\'' +
            '}';
  }

  public Car(int id, String car_id, String car_brand, String car_model, String car_color, String car_price, String car_time, String car_owner) {
    this.id = id;
    this.car_id = car_id;
    this.car_brand = car_brand;
    this.car_model = car_model;
    this.car_color = car_color;
    this.car_price = car_price;
    this.car_time = car_time;
    this.car_owner = car_owner;
  }

  public Car() {
  }
}
