package com.zetcode.dao;

import com.zetcode.bean.Car;
import java.util.List;

public interface CarsDAO {

  public void saveCar(Car car);
  public Car findCarByName(String name);
  public List<Car> findAll();
}