package com.carrental.demo.mapper;

import com.carrental.demo.vo.CarVO;
import com.carrental.demo.vo.ModelVO;

import java.util.List;

public interface CarDaoCustom {

    List<ModelVO> getAllModel(long now);

    List<CarVO> getAllCarByModel(String model, long now);

    int getCountByRenterId(int renterId);

}
