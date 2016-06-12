package com.zetcode.client;

import com.zetcode.dao.CarsDAO;
import com.zetcode.bean.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CarsDAO cdao;

    @Override
    public void run(String... args) throws Exception {

        try {
            Car car = cdao.findCarByName("Citroen");
            System.out.printf("ID: %d%n", car.getId());
            System.out.printf("Name: %s%n", car.getName());
            System.out.printf("Price: %d%n", car.getPrice());
            
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Car was not found");
        }

        List<Car> cars = cdao.findAll();
        
        for (Car car: cars) {
            System.out.printf("%d ", car.getId());
            System.out.printf("%s ", car.getName());
            System.out.println(car.getPrice());
        }
    }
}
