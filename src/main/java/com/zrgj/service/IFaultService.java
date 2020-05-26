package com.zrgj.service;

import com.zrgj.pojo.Fault;

import java.util.*;

public interface IFaultService {

  List<Fault> faultList();

  void updFaultState(String state, String fault_id);

  void addFault(Fault fault);

  List<Fault> getFaultByState();

}
