package com.hotel.pojo;

import java.util.Date;

public class RoomComments {
    private Integer id;

    private Integer orderId;

    private Integer userId;

    private Integer roomId;

    private String username;

    private String roomName;

    private Integer commentLevel;

    private String content;

    private Date createdTime;

    private Date updatedTime;

    public RoomComments(Integer id, Integer orderId, Integer userId, Integer roomId, String username, String roomName, Integer commentLevel, String content, Date createdTime, Date updatedTime) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.roomId = roomId;
        this.username = username;
        this.roomName = roomName;
        this.commentLevel = commentLevel;
        this.content = content;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public RoomComments() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}