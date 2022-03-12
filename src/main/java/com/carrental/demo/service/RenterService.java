package com.carrental.demo.service;

import com.carrental.demo.entity.Renter;

public interface RenterService {

    Renter queryByPhone(String phone);

    int saveRenter(Renter renter);

    int updateUser(Renter renter);

}
