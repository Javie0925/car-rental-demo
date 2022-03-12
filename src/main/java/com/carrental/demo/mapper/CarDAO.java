package com.carrental.demo.mapper;

import com.carrental.demo.entity.Car;
import com.carrental.demo.entity.CarExample;
import org.springframework.stereotype.Repository;

/**
 * CarDAO继承基类
 */
@Repository
public interface CarDAO extends BaseDao<Car, Integer, CarExample> {
}