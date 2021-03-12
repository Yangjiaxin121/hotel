package com.hotel.dao;

import com.hotel.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);


    List<Room> getRoomList();

    List<Room> getRoomByName(String roomName);

    int updateRoomStatus(@Param("roomId") int roomId, @Param("roomStatus") Integer roomStatus);

    List<Room> selectByRoomStatus(Integer status);

    List<Room> selectRoomByAttribute(Room room);
}