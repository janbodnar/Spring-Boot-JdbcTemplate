package com.zetcode.dao;

import com.zetcode.bean.Car;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBCarsDAO implements CarsDAO {
   
    @Autowired
    protected JdbcTemplate jtm;    

    @Override
    public void saveCar(Car car) {

        String sql = "INSERT INTO Cars(Name, Price) VALUES (?, ?)";
        Object[] params = new Object[]{car.getName(), car.getPrice()};

        jtm.update(sql, params);
    }

    @Override
    public Car findCarByName(String name) {

        String sql = "SELECT * FROM Cars WHERE Name = ?";
        Object[] param = new Object[]{name};

        Car car = (Car) jtm.queryForObject(sql, param,
                new BeanPropertyRowMapper(Car.class));

        return car;
    }

    @Override
    public List<Car> findAll() {

        String sql = "SELECT * FROM Cars";

        List<Car> cars = jtm.query(sql, new BeanPropertyRowMapper(Car.class));

        return cars;
    }
}
