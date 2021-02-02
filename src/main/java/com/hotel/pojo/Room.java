package com.hotel.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Room {
    private Integer id;

    private Integer number;

    private String name;

    private String intro;

    private String category;

    private BigDecimal price;

    private String score;

    private Integer status;

    private String detail;

    private String mainImage;

    private String subImages;

    private Date createTime;

    private Date updateTime;

    public Room(Integer id, Integer number, String name, String intro, String category, BigDecimal price, String score, Integer status, String detail, String mainImage, String subImages, Date createTime, Date updateTime) {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
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