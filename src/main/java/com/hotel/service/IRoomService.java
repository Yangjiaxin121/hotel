package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.Room;

public interface IRoomService {

    ServerResponse addRoom(Room room);

    ServerResponse updateRoom(Room room);

    ServerResponse setRoomStatus(Integer roomId, Integer roomStatus);

    ServerResponse getRoomDetail(Integer roomId);

    ServerResponse getRoomList(Integer pageNum, Integer pageSize);

    ServerResponse searchRoomByName(String roomName, Integer pageNum, Integer pageSize);

    ServerResponse searchRoomByStatus(Integer status, Integer pageNum, Integer pageSize);

    ServerResponse getRoomByAttribute(Room room, Integer pageNum, Integer pageSize);

    ServerResponse searchRoomByTime(String reserveTime, String reserveEndTime, Integer pageNum, Integer pageSize);
}
