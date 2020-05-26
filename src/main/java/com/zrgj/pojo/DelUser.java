package com.zrgj.pojo;

public class DelUser {
  private int del_id;
  private String del_account;
  private String del_password;
  private String del_name;
  private String del_phone;
  private String del_time;

  public int getDel_id() {
    return del_id;
  }

  public void setDel_id(int del_id) {
    this.del_id = del_id;
  }

  public String getDel_account() {
    return del_account;
  }

  public void setDel_account(String del_account) {
    this.del_account = del_account;
  }

  public String getDel_password() {
    return del_password;
  }

  public void setDel_password(String del_password) {
    this.del_password = del_password;
  }

  public String getDel_name() {
    return del_name;
  }

  public void setDel_name(String del_name) {
    this.del_name = del_name;
  }

  public String getDel_phone() {
    return del_phone;
  }

  public void setDel_phone(String del_phone) {
    this.del_phone = del_phone;
  }

  public String getDel_time() {
    return del_time;
  }

  public void setDel_time(String del_time) {
    this.del_time = del_time;
  }

  @Override
  public String toString() {
    return "DelUser{" +
            "del_id=" + del_id +
            ", del_account='" + del_account + '\'' +
            ", del_password='" + del_password + '\'' +
            ", del_name='" + del_name + '\'' +
            ", del_phone='" + del_phone + '\'' +
            ", del_time='" + del_time + '\'' +
            '}';
  }

  public DelUser(int del_id, String del_account, String del_password, String del_name, String del_phone, String del_time) {
    this.del_id = del_id;
    this.del_account = del_account;
    this.del_password = del_password;
    this.del_name = del_name;
    this.del_phone = del_phone;
    this.del_time = del_time;
  }

  public DelUser() {
  }
}
