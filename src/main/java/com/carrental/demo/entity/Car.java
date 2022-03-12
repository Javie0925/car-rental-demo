package com.carrental.demo.entity;

import java.io.Serializable;

/**
 * car
 * @author 
 */
public class Car implements Serializable {
    private Integer id;

    private String carModel;

    /**
     * if the car is ordered but not confirm, it will be locked for 1 hour
     */
    private Long lockTime;

    /**
     * the time a car is rented
     */
    private Long rentTime;

    private Integer renterId;

    /**
     * car status: 0 -> free, 1 -> lock, 2 -> rented
     */
    private Integer status;

    private String picture;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Long getLockTime() {
        return lockTime;
    }

    public void setLockTime(Long lockTime) {
        this.lockTime = lockTime;
    }

    public Long getRentTime() {
        return rentTime;
    }

    public void setRentTime(Long rentTime) {
        this.rentTime = rentTime;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Car other = (Car) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarModel() == null ? other.getCarModel() == null : this.getCarModel().equals(other.getCarModel()))
            && (this.getLockTime() == null ? other.getLockTime() == null : this.getLockTime().equals(other.getLockTime()))
            && (this.getRentTime() == null ? other.getRentTime() == null : this.getRentTime().equals(other.getRentTime()))
            && (this.getRenterId() == null ? other.getRenterId() == null : this.getRenterId().equals(other.getRenterId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarModel() == null) ? 0 : getCarModel().hashCode());
        result = prime * result + ((getLockTime() == null) ? 0 : getLockTime().hashCode());
        result = prime * result + ((getRentTime() == null) ? 0 : getRentTime().hashCode());
        result = prime * result + ((getRenterId() == null) ? 0 : getRenterId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carModel=").append(carModel);
        sb.append(", lockTime=").append(lockTime);
        sb.append(", rentTime=").append(rentTime);
        sb.append(", renterId=").append(renterId);
        sb.append(", status=").append(status);
        sb.append(", picture=").append(picture);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}