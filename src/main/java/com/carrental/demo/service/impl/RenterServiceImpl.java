package com.carrental.demo.service.impl;

import com.carrental.demo.entity.Renter;
import com.carrental.demo.mapper.RenterDaoCustom;
import com.carrental.demo.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterServiceImpl implements RenterService {

    @Autowired
    RenterDaoCustom renterDaoCustom;


    @Override
    public Renter queryByPhone(String phone) {
        return renterDaoCustom.getByPhone(phone);
    }

    @Override
    public int saveRenter(Renter Renter) {
        return renterDaoCustom.insert(Renter);
    }

    @Override
    public int updateUser(Renter Renter) {
        return renterDaoCustom.updateById(Renter);
    }
}
