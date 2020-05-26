package com.zrgj.pojo;


public class OperUser {
  private int id;
  private String account;
  private String password;
  private String full_name;
  private String phone;
  private String create_time;
  private String login_time;
  private int state;
  private String state_desc;
  private int power;
  private String power_desc;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFull_name() {
    return full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getLogin_time() {
    return login_time;
  }

  public void setLogin_time(String login_time) {
    this.login_time = login_time;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getState_desc() {
    return state_desc;
  }

  public void setState_desc(String state_desc) {
    this.state_desc = state_desc;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public String getPower_desc() {
    return power_desc;
  }

  public void setPower_desc(String power_desc) {
    this.power_desc = power_desc;
  }

  @Override
  public String toString() {
    return "OperUser{" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", full_name='" + full_name + '\'' +
            ", phone='" + phone + '\'' +
            ", create_time='" + create_time + '\'' +
            ", login_time='" + login_time + '\'' +
            ", state=" + state +
            ", state_desc='" + state_desc + '\'' +
            ", power=" + power +
            ", power_desc='" + power_desc + '\'' +
            '}';
  }

  public OperUser() {
  }

  public OperUser(int id, String account, String password, String full_name, String phone, String create_time, String login_time, int state, String state_desc, int power, String power_desc) {
    this.id = id;
    this.account = account;
    this.password = password;
    this.full_name = full_name;
    this.phone = phone;
    this.create_time = create_time;
    this.login_time = login_time;
    this.state = state;
    this.state_desc = state_desc;
    this.power = power;
    this.power_desc = power_desc;
  }
}
