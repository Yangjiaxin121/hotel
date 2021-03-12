package com.hotel.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Room {
    private Integer id;

    private String number;

    private String name;

    private String intro;

    private String category;

    private BigDecimal price;

    private Double score;

    private Integer status;

    private String detail;

    private String mainImage;

    private String subImages;

    private String reserveTime;

    private String reserveEndTime;

    private Date createTime;

    private Date updateTime;

    public Room(Integer id, String number, String name, String intro, String category, BigDecimal price, Double score, Integer status, String detail, String mainImage, String subImages, String reserveTime, String reserveEndTime, Date createTime, Date updateTime) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.intro = intro;
        this.category = category;
        this.price = price;
        this.score = score;
        this.status = status;
        this.detail = detail;
        this.mainImage = mainImage;
        this.subImages = subImages;
        this.reserveTime = reserveTime;
        this.reserveEndTime = reserveEndTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Room() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages == null ? null : subImages.trim();
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime == null ? null : reserveTime.trim();
    }

    public String getReserveEndTime() {
        return reserveEndTime;
    }

    public void setReserveEndTime(String reserveEndTime) {
        this.reserveEndTime = reserveEndTime == null ? null : reserveEndTime.trim();
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