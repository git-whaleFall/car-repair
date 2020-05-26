package com.zrgj.dao;

import com.zrgj.pojo.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface PartDao {

  /*查询零件*/
  @Select(value = "select * from car_part")
  List<Part> getAllPart();

  /*修改零件库存*/
  @Select(value = "update car_part set part_num=#{num} where part_id=#{id}")
  void updPartNum(int id, int num);

  /*修改零件库存*/
  @Select(value = "update car_part set part_num=#{num} where part_name=#{name}")
  void updPartNumByName(String name, int num);

  /*根据名字查询零件数量*/
  @Select(value = "select part_num from car_part where part_name=#{name}")
  int getPartNum(String name);

  /*查询是否存在该库存*/
  @Select(value = "select count(*) from car_part where part_name=#{name}")
  int getCount(String name);

  /*添加库存*/
  @Select(value = "insert into car_part (part_name,part_price,part_num) " +
          "values (#{name},#{price},#{num})")
  void addPart(String name, String price, int num);

  /*删除库存*/
  @Select(value = "delete from car_part where part_id=#{id}")
  void delPart(int id);
}
