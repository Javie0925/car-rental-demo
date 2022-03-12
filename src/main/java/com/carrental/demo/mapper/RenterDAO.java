package com.carrental.demo.mapper;

import com.carrental.demo.entity.Renter;
import com.carrental.demo.entity.RenterExample;
import org.springframework.stereotype.Repository;

/**
 * RenterDAO继承基类
 */
@Repository
public interface RenterDAO extends BaseDao<Renter, Integer, RenterExample> {
}