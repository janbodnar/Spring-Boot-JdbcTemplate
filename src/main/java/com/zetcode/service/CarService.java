package com.zetcode.service;

import com.zetcode.model.Car;
import com.zetcode.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository carRepository;

    public Car findByName(String name) {

        return carRepository.findCarByName(name);
    }

    public List<Car> findAll() {

        return carRepository.findAll();
    }
}
