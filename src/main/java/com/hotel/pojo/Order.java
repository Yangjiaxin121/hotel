package com.hotel.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Long orderNo;

    private Integer userId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer status;

    private Integer roomStatus;

    private Date paymentTime;

    private Date intakeTime;

    private Date endTime;

    private Integer stayDays;

    private Date createTime;

    private Date updateTime;

    public Order(Integer id, Long orderNo, Integer userId, BigDecimal payment, Integer paymentType, Integer status, Integer roomStatus, Date paymentTime, Date intakeTime, Date endTime, Integer stayDays, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
        this.payment = payment;
        this.paymentType = paymentType;
        this.status = status;
        this.roomStatus = roomStatus;
        this.paymentTime = paymentTime;
        this.intakeTime = intakeTime;
        this.endTime = endTime;
        this.stayDays = stayDays;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getIntakeTime() {
        return intakeTime;
    }

    public void setIntakeTime(Date intakeTime) {
        this.intakeTime = intakeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStayDays() {
        return stayDays;
    }

    public void setStayDays(Integer stayDays) {
        this.stayDays = stayDays;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}