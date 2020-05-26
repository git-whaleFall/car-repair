package com.zrgj.service;

import com.zrgj.pojo.Part;

import java.util.List;

public interface IPartService {

  List<Part> getAllPart();

  void updPartNum(int id, int num);

  void updPartNumByName(String name, int num);

  int getPartNum(String name);

  int getCount(String name);

  void addPart(String name, String price, int num);

  void delPart(int id);
}
