package com.zetcode.service;

import com.zetcode.model.Car;

import java.util.List;

public interface ICarService {

    Car findByName(String name);
    List<Car> findAll();
}
