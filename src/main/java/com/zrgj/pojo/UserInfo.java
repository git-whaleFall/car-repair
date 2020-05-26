package com.zrgj.pojo;

public class UserInfo {
  private int user_id;
  private String user_sex;
  private String user_age;
  private String user_card;
  private String user_email;
  private String user_addrs;
  private double user_price;
  private String account;

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getUser_sex() {
    return user_sex;
  }

  public void setUser_sex(String user_sex) {
    this.user_sex = user_sex;
  }

  public String getUser_age() {
    return user_age;
  }

  public void setUser_age(String user_age) {
    this.user_age = user_age;
  }

  public String getUser_card() {
    return user_card;
  }

  public void setUser_card(String user_card) {
    this.user_card = user_card;
  }

  public String getUser_email() {
    return user_email;
  }

  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }

  public String getUser_addrs() {
    return user_addrs;
  }

  public void setUser_addrs(String user_addrs) {
    this.user_addrs = user_addrs;
  }

  public double getUser_price() {
    return user_price;
  }

  public void setUser_price(double user_price) {
    this.user_price = user_price;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
            "user_id=" + user_id +
            ", user_sex='" + user_sex + '\'' +
            ", user_age='" + user_age + '\'' +
            ", user_card='" + user_card + '\'' +
            ", user_email='" + user_email + '\'' +
            ", user_addrs='" + user_addrs + '\'' +
            ", user_price=" + user_price +
            ", account='" + account + '\'' +
            '}';
  }

  public UserInfo(int user_id, String user_sex, String user_age, String user_card, String user_email, String user_addrs, double user_price, String account) {
    this.user_id = user_id;
    this.user_sex = user_sex;
    this.user_age = user_age;
    this.user_card = user_card;
    this.user_email = user_email;
    this.user_addrs = user_addrs;
    this.user_price = user_price;
    this.account = account;
  }

  public UserInfo() {
  }
}
