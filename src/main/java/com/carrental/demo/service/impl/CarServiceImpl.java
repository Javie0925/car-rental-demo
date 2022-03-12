package com.carrental.demo.service.impl;

import com.carrental.demo.constant.CarStatusConstant;
import com.carrental.demo.entity.Car;
import com.carrental.demo.entity.CarExample;
import com.carrental.demo.entity.Renter;
import com.carrental.demo.mapper.CarDAO;
import com.carrental.demo.mapper.CarDaoCustom;
import com.carrental.demo.mapper.RenterDAO;
import com.carrental.demo.mapper.RenterDaoCustom;
import com.carrental.demo.service.CarService;
import com.carrental.demo.vo.CarVO;
import com.carrental.demo.vo.ModelVO;
import com.carrental.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

    private final static int LOCK_TTL = 2 * 60 * 60 * 1000;

    @Autowired
    CarDaoCustom carDaoCustom;

    @Autowired
    CarDAO carDao;
    @Autowired
    RenterDaoCustom renterDaoCustom;
    @Autowired
    RenterDAO renterDao;

    public List<ModelVO> getAllModel() {
        return carDaoCustom.getAllModel(System.currentTimeMillis());
    }

    @Override
    public List<CarVO> getAllCarByModel(String model) {
        return carDaoCustom.getAllCarByModel(model, System.currentTimeMillis());
    }

    /**
     * book a car
     *
     * @param map
     * @return
     */
    @Override
    @Transactional
    public Result bookCar(Map map) {
        //{"id":"2","carModel":"BMW 650","name":"fasdf","phone":"15659807545","address":""}
        Integer carId = Integer.valueOf((String) map.get("id"));
        String carModel = (String) map.get("carModel");
        String name = (String) map.get("name");
        String phone = (String) map.get("phone");
        String address = (String) map.get("address");
        // check fields
        if (null == carId) {
            return Result.fail(500, "carId can not be null!");
        }
        if (StringUtils.isEmpty(name)) {
            return Result.fail(500, "name can not be null!");
        }
        if (StringUtils.isEmpty(phone)) {
            return Result.fail(500, "phone can not be null!");
        }
        Car car = carDao.selectByPrimaryKey(carId);
        // car not exist
        if (Objects.isNull(car)) return Result.fail(500, "booking fail,this car does not exist!");
        // car not available
        if (car.getStatus() == CarStatusConstant.RENTED ||
                (car.getStatus() == CarStatusConstant.LOCKED && car.getLockTime() > System.currentTimeMillis() - LOCK_TTL)) {
            return Result.fail(500, "booking fail,this car is not available!");
        }
        // check renter
        Renter renter = renterDaoCustom.getByPhone(phone);
        if (Objects.isNull(renter)) {
            // create a new renter
            renter = new Renter();
            renter.setAddress(address);
            renter.setName(name);
            renter.setPhone(phone);
            if (renterDao.insert(renter) == 0) {
                return Result.fail(500, "booking fail,please try again later!");
            }
            // lock car
            car.setLockTime(System.currentTimeMillis());
            car.setRenterId(renter.getId());
            carDao.updateByPrimaryKey(car);
        } else {
            // renter exist
            CarExample bookingCountExample = new CarExample();
            bookingCountExample.createCriteria()
                    .andRenterIdEqualTo(renter.getId())
                    .andStatusEqualTo(CarStatusConstant.LOCKED)
                    .andLockTimeGreaterThan(System.currentTimeMillis() - LOCK_TTL);
            CarExample rentCountExample = new CarExample();
            rentCountExample.createCriteria()
                    .andRenterIdEqualTo(renter.getId())
                    .andStatusEqualTo(CarStatusConstant.RENTED);
            if (carDao.countByExample(bookingCountExample) > 0 || carDao.countByExample(rentCountExample) > 0) {
                // renter can only book one car
                return Result.fail(500, "sorry, you can only book one car!");
            } else {
                // lock car
                car.setLockTime(System.currentTimeMillis());
                car.setStatus(CarStatusConstant.LOCKED);
                car.setRenterId(renter.getId());
                carDao.updateByPrimaryKey(car);
            }
        }
        return Result.success();
    }
}
