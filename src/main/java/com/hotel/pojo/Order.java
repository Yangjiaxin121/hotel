package com.hotel.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Long orderNo;

    private Integer roomId;

    private Integer userId;

    private String realName;

    private BigDecimal payment;

    private BigDecimal totalPayment;

    private Integer paymentType;

    private Integer status;

    private Integer roomStatus;

    private Date paymentTime;

    private Date intakeTime;

    private Date endTime;

    private Date reserveTime;

    private Date reserveEndTime;

    private Integer stayDays;

    private Integer totalDays;

    private Date createTime;

    private Date updateTime;

    private Integer roomNumber;

    public Order(Integer id, Long orderNo, Integer roomId, Integer userId, String realName, BigDecimal payment, BigDecimal totalPayment, Integer paymentType, Integer status, Integer roomStatus, Date paymentTime, Date intakeTime, Date endTime, Date reserveTime, Date reserveEndTime, Integer stayDays, Integer totalDays, Date createTime, Date updateTime, Integer roomNumber) {
        this.id = id;
        this.orderNo = orderNo;
        this.roomId = roomId;
        this.userId = userId;
        this.realName = realName;
        this.payment = payment;
        this.totalPayment = totalPayment;
        this.paymentType = paymentType;
        this.status = status;
        this.roomStatus = roomStatus;
        this.paymentTime = paymentTime;
        this.intakeTime = intakeTime;
        this.endTime = endTime;
        this.reserveTime = reserveTime;
        this.reserveEndTime = reserveEndTime;
        this.stayDays = stayDays;
        this.totalDays = totalDays;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.roomNumber = roomNumber;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
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

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Date getReserveEndTime() {
        return reserveEndTime;
    }

    public void setReserveEndTime(Date reserveEndTime) {
        this.reserveEndTime = reserveEndTime;
    }

    public Integer getStayDays() {
        return stayDays;
    }

    public void setStayDays(Integer stayDays) {
        this.stayDays = stayDays;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
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

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}