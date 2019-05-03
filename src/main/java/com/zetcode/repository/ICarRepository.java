package com.zetcode.repository;

import com.zetcode.model.Car;

import java.util.List;

public interface ICarRepository {

    void saveCar(Car car);
    Car findCarByName(String name);
    List<Car> findAll();
}
