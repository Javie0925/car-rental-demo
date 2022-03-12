package com.carrental.demo.controller;

import com.carrental.demo.service.CarService;
import com.carrental.demo.service.RenterService;
import com.carrental.demo.vo.CarVO;
import com.carrental.demo.vo.ModelVO;
import com.carrental.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    RenterService renterService;


    /**
     * get car list
     *
     * @return
     */
    @GetMapping
    @ResponseBody
    public Result getCarList(@RequestParam("model") String model) {
        List<CarVO> allCar = carService.getAllCarByModel(model);
        return Result.success(allCar);
    }

    /**
     * get model list
     *
     * @return
     */
    @GetMapping("/model")
    @ResponseBody
    public Result getModelList() {
        List<ModelVO> allCar = carService.getAllModel();
        return Result.success(allCar);
    }

    /**
     * book a car
     *
     * @return
     */
    @PostMapping("/booking")
    @ResponseBody
    public Result bookCar(@RequestBody Map map) {
        //{"id":"2","carModel":"BMW 650 ","name":"fasdf","phone":"15659807545","address":""}
        return carService.bookCar(map);
    }
}
