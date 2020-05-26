package com.zrgj.service.impl;

import com.zrgj.dao.FaultDao;
import com.zrgj.pojo.Fault;
import com.zrgj.service.IFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultServiceImpl implements IFaultService {

  @Autowired
  private FaultDao faultDao;

  @Override
  public List<Fault> faultList() {
    return faultDao.faultList();
  }

  @Override
  public void updFaultState(String state, String fault_id) {
    faultDao.updFaultState(state, fault_id);
  }

  @Override
  public void addFault(Fault fault) {
    faultDao.addFault(fault.getFault_id(), fault.getFault_name(), fault.getFault_price(), "启用");
  }

  @Override
  public List<Fault> getFaultByState() {
    return faultDao.getFaultByState();
  }


}
