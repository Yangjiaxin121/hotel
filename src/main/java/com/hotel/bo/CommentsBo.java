package com.hotel.bo;

import com.hotel.pojo.RoomComments;

public class CommentsBo {

    RoomComments roomComments;
    Integer pageNum;
    Integer pageSize;

    public RoomComments getRoomComments() {
        return roomComments;
    }

    public void setRoomComments(RoomComments roomComments) {
        this.roomComments = roomComments;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
