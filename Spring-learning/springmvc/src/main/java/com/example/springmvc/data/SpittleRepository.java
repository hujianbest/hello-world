package com.example.springmvc.data;

import java.util.List;

import com.example.springmvc.Spittle;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
