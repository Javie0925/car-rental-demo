package com.carrental.demo.mapper;

import com.carrental.demo.entity.Renter;

public interface RenterDaoCustom {

    Renter getByPhone(String phone);

    int insert(Renter renter);

    int updateById(Renter entity);
}
