package com.carrental.demo;

import com.carrental.demo.service.CarService;
import com.carrental.demo.vo.CarVO;
import com.carrental.demo.vo.ModelVO;
import com.carrental.demo.vo.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    public void getAllModel() {
        List<ModelVO> allModel = carService.getAllModel();
        Assert.notNull(allModel, "model is null");
        Assert.isTrue(allModel.size() == 2, "model list size is not 2");
    }

    @Test
    public void getAllCarByModel() {
        List<CarVO> cars = carService.getAllCarByModel("Toyota Camry");
        Assert.notNull(cars, "cars is null");
        Assert.isTrue(cars.size() == 2, "car list size is not 2");
    }

    @Test
    public void bookCar() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "name");
        map.put("phone", "15659887744");
        map.put("address", "wall street");
        Result result = carService.bookCar(map);
        Assert.isTrue(result.getCode() == 0, "book car fail");
        Result result2 = carService.bookCar(map);
        Assert.isTrue(result2.getCode() != 0, "car can be booked twice");

    }


}
