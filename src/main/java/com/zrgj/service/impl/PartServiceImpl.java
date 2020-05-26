package com.zrgj.service.impl;

import com.zrgj.dao.PartDao;
import com.zrgj.pojo.Part;
import com.zrgj.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements IPartService {

  @Autowired
  private PartDao partDao;

  @Override
  public List<Part> getAllPart() {
    return partDao.getAllPart();
  }

  @Override
  public void updPartNum(int id, int num) {
    partDao.updPartNum(id, num);
  }

  @Override
  public void updPartNumByName(String name, int num) {
    partDao.updPartNumByName(name, num);
  }

  @Override
  public int getPartNum(String name) {
    return partDao.getPartNum(name);
  }

  @Override
  public int getCount(String name) {
    return partDao.getCount(name);
  }

  @Override
  public void addPart(String name, String price, int num) {
    partDao.addPart(name, price, num);
  }

  @Override
  public void delPart(int id) {
    partDao.delPart(id);
  }
}
