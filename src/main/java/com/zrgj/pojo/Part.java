package com.zrgj.pojo;

public class Part {
  private int part_id;
  private String part_name;
  private double part_price;
  private int part_num;

  public int getPart_id() {
    return part_id;
  }

  public void setPart_id(int part_id) {
    this.part_id = part_id;
  }

  public String getPart_name() {
    return part_name;
  }

  public void setPart_name(String part_name) {
    this.part_name = part_name;
  }

  public double getPart_price() {
    return part_price;
  }

  public void setPart_price(double part_price) {
    this.part_price = part_price;
  }

  public int getPart_num() {
    return part_num;
  }

  public void setPart_num(int part_num) {
    this.part_num = part_num;
  }

  @Override
  public String toString() {
    return "Part{" +
            "part_id=" + part_id +
            ", part_name='" + part_name + '\'' +
            ", part_price=" + part_price +
            ", part_num=" + part_num +
            '}';
  }

  public Part(int part_id, String part_name, double part_price, int part_num) {
    this.part_id = part_id;
    this.part_name = part_name;
    this.part_price = part_price;
    this.part_num = part_num;
  }

  public Part() {
  }
}
