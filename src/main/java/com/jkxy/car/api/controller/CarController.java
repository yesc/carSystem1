package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import com.jkxy.car.api.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }

    /**
     * 购车
     *
     * @param id       车辆id
     * @param buyCount 购买数量
     * @return
     */
    @GetMapping("buyCar")
    public JSONResult buyCar(@RequestParam("id") int id, @RequestParam("buyCount") int buyCount) {
        return carService.buyCar(id, buyCount);
    }

    /**
     * 按品牌获取
     *
     * @param carName 车辆品牌
     * @param current 当前页
     * @param size    单页数量
     * @return
     */
    @GetMapping("findByCarNameList")
    public JSONResult buyCar(@RequestParam("carName") String carName,
                             @RequestParam("current") int current, @RequestParam("size") int size) {
        Pager<Car> res = carService.listByCarName(carName, current, size);
        return JSONResult.ok(res);
    }
}
