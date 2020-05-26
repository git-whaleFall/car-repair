package com.zrgj.pojo;

public class Order {
  private int order_id;
  private String car_id;
  private String fault_id;
  private String user_account;
  private String user_name;
  private String user_phone;
  private String order_time;
  private String order_state;
  private String notes;

  public int getOrder_id() {
    return order_id;
  }

  public void setOrder_id(int order_id) {
    this.order_id = order_id;
  }

  public String getCar_id() {
    return car_id;
  }

  public void setCar_id(String car_id) {
    this.car_id = car_id;
  }

  public String getFault_id() {
    return fault_id;
  }

  public void setFault_id(String fault_id) {
    this.fault_id = fault_id;
  }

  public String getUser_account() {
    return user_account;
  }

  public void setUser_account(String user_account) {
    this.user_account = user_account;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getUser_phone() {
    return user_phone;
  }

  public void setUser_phone(String user_phone) {
    this.user_phone = user_phone;
  }

  public String getOrder_time() {
    return order_time;
  }

  public void setOrder_time(String order_time) {
    this.order_time = order_time;
  }

  public String getOrder_state() {
    return order_state;
  }

  public void setOrder_state(String order_state) {
    this.order_state = order_state;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Order{" +
            "order_id=" + order_id +
            ", car_id='" + car_id + '\'' +
            ", fault_id='" + fault_id + '\'' +
            ", user_account='" + user_account + '\'' +
            ", user_name='" + user_name + '\'' +
            ", user_phone='" + user_phone + '\'' +
            ", order_time='" + order_time + '\'' +
            ", order_state='" + order_state + '\'' +
            ", notes='" + notes + '\'' +
            '}';
  }

  public Order(int order_id, String car_id, String fault_id, String user_account, String user_name, String user_phone, String order_time, String order_state, String notes) {
    this.order_id = order_id;
    this.car_id = car_id;
    this.fault_id = fault_id;
    this.user_account = user_account;
    this.user_name = user_name;
    this.user_phone = user_phone;
    this.order_time = order_time;
    this.order_state = order_state;
    this.notes = notes;
  }

  public Order() {
  }
}
