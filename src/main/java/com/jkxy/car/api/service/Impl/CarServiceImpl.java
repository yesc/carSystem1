package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import com.jkxy.car.api.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car findById(int id) {
        return carDao.findById(id);
    }

    @Override
    public List<Car> findByCarName(String carName) {
        return carDao.findByCarName(carName);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void updateById(Car car) {
        carDao.updateById(car);
    }

    @Override
    public void insertCar(Car car) {
        carDao.insertCar(car);
    }

    @Override
    public JSONResult buyCar(int id, int buyCount) {
        JSONResult result = null;
        Car existCar = this.findById(id);
        if (existCar.getCount() < buyCount) {
            result = JSONResult.errorMsg(String.format("%s剩余%d辆，少于购买数量%d", existCar.getCarName(), existCar.getCount(), buyCount));
        } else {
            Car needUpdate = new Car();
            needUpdate.setId(id);
            needUpdate.setCount(existCar.getCount() - buyCount);
            carDao.updateCount(needUpdate);
            result = JSONResult.ok();
        }
        return result;
    }

    @Override
    public Pager<Car> listByCarName(String carName, int current, int size) {
        int page = (current - 1) * size;
        Long total = carDao.countByCarName(carName);
        List<Car> data = carDao.listByCarName(carName, page, size);
        return new Pager<Car>(current, size, total, data);
    }
}
