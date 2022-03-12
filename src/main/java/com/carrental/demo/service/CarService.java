package com.carrental.demo.service;

import com.carrental.demo.vo.CarVO;
import com.carrental.demo.vo.ModelVO;
import com.carrental.demo.vo.Result;

import java.util.List;
import java.util.Map;


public interface CarService {


    List<ModelVO> getAllModel();

    List<CarVO> getAllCarByModel(String model);

    Result bookCar(Map map);

}
