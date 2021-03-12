package com.hotel.dao;

import com.hotel.pojo.RoomComments;

import java.util.List;

public interface RoomCommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomComments record);

    int insertSelective(RoomComments record);

    RoomComments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomComments record);

    int updateByPrimaryKey(RoomComments record);

    List<RoomComments> selectCommentsByAttribute(RoomComments roomComments);
}