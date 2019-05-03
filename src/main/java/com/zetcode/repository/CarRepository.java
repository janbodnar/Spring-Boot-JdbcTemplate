package com.zetcode.repository;

import com.zetcode.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository implements ICarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveCar(Car car) {

        var sql = "INSERT INTO cars(name, price) VALUES (?, ?)";
        Object[] params = new Object[] {car.getName(), car.getPrice()};

        jdbcTemplate.update(sql, params);
    }

    @Override
    public Car findCarByName(String name) {

        var sql = "SELECT * FROM cars WHERE name = ?";
        Object[] param = new Object[] {name};

        return jdbcTemplate.queryForObject(sql, param,
                BeanPropertyRowMapper.newInstance(Car.class));
    }

    @Override
    public List<Car> findAll() {

        var sql = "SELECT * FROM cars";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Car.class));
    }
}
