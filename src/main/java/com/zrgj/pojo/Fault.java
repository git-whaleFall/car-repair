package com.zrgj.pojo;

public class Fault {
  private int id;
  private String fault_id;
  private String fault_name;
  private double fault_price;
  private String fault_state;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFault_id() {
    return fault_id;
  }

  public void setFault_id(String fault_id) {
    this.fault_id = fault_id;
  }

  public String getFault_name() {
    return fault_name;
  }

  public void setFault_name(String fault_name) {
    this.fault_name = fault_name;
  }

  public double getFault_price() {
    return fault_price;
  }

  public void setFault_price(double fault_price) {
    this.fault_price = fault_price;
  }

  public String getFault_state() {
    return fault_state;
  }

  public void setFault_state(String fault_state) {
    this.fault_state = fault_state;
  }

  @Override
  public String toString() {
    return "Fault{" +
            "id=" + id +
            ", fault_id='" + fault_id + '\'' +
            ", fault_name='" + fault_name + '\'' +
            ", fault_price=" + fault_price +
            ", fault_state='" + fault_state + '\'' +
            '}';
  }

  public Fault(int id, String fault_id, String fault_name, double fault_price, String fault_state) {
    this.id = id;
    this.fault_id = fault_id;
    this.fault_name = fault_name;
    this.fault_price = fault_price;
    this.fault_state = fault_state;
  }

  public Fault() {
  }
}
