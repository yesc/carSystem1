package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.utils.JSONResult;
import com.jkxy.car.api.utils.Pager;
import java.util.List;


public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByCarName(String carName);

    void deleteById(int id);

    void updateById(Car car);

    void insertCar(Car car);

    JSONResult buyCar(int id, int buyCount);
    Pager<Car> listByCarName(String carName, int current, int size);
}
