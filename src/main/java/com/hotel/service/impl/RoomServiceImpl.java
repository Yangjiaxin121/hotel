package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.common.Const;
import com.hotel.common.ResponseCode;
import com.hotel.common.ServerResponse;
import com.hotel.dao.RoomMapper;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.service.IRoomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("iRoomService")
public class RoomServiceImpl implements IRoomService {


    @Autowired
    RoomMapper roomMapper;

    /**
     * 添加Room
     *
     * @param room
     * @return
     */
    @Override
    public ServerResponse addRoom(Room room) {
        if (room != null) {
            if (StringUtils.isNotBlank(room.getSubImages())) {
                String[] subImageArray = room.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    room.setMainImage(subImageArray[0]);
                }
            }

            int rowCount = roomMapper.insert(room);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("新增房间成功");
            }
            return ServerResponse.createByErrorMessage("新增房间失败");

        }

        return ServerResponse.createByErrorMessage("参数错误");
    }


    /**
     * 更新Room
     *
     * @param room
     * @return
     */
    @Override
    public ServerResponse updateRoom(Room room) {

        if (room != null) {
            if (StringUtils.isNotBlank(room.getSubImages())) {
                String[] subImageArray = room.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    room.setMainImage(subImageArray[0]);
                }
            }

            if (room.getId() == null) {
                return ServerResponse.createByErrorMessage("id不能为空");
            }
            int rowCount = roomMapper.updateByPrimaryKeySelective(room);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("更新房间成功");
            }
            return ServerResponse.createByErrorMessage("更新房间失败");

        }

        return ServerResponse.createByErrorMessage("参数错误");
    }


    /**
     * 设置房间状态
     *
     * @param roomId
     * @param roomStatus
     * @return
     */
    @Override
    public ServerResponse setRoomStatus(Integer roomId, Integer roomStatus) {

        if (roomId == null || roomStatus == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Room room = new Room();
        room.setId(roomId);
        room.setStatus(roomStatus);
        int rowCount = roomMapper.updateByPrimaryKeySelective(room);
        if (rowCount > 0) {
            return ServerResponse.createBySuccess("修改房间状态成功");
        }
        return ServerResponse.createByErrorMessage("修改房间状态失败");
    }


    /**
     * 获取房间的详情
     *
     * @param roomId
     * @return
     */
    @Override
    public ServerResponse getRoomDetail(Integer roomId) {

        if (roomId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room == null) {
            return ServerResponse.createByErrorMessage("房间不存在");
        }
        return ServerResponse.createBySuccess(room);
    }


    /**
     * 获取全部room列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getRoomList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Room> roomList = roomMapper.getRoomList();
        PageInfo pageInfo = new PageInfo(roomList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 根据房间名字模糊查询房间
     *
     * @param roomName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse searchRoomByName(String roomName, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(roomName)) {
            roomName = new StringBuilder().append("%").append(roomName).append("%").toString();
        }

        List<Room> roomList = roomMapper.getRoomByName(roomName);

        PageInfo pageInfo = new PageInfo(roomList);

        return ServerResponse.createBySuccess(pageInfo);

    }

    /**
     * 根据房间状态查询
     *
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse searchRoomByStatus(Integer status, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        if (status == Const.RoomStatus.EmptyRoom || status == Const.RoomStatus.RESERVED) {


            List<Room> roomList = roomMapper.selectByRoomStatus(status);

            PageInfo pageInfo = new PageInfo(roomList);

            return ServerResponse.createBySuccess(pageInfo);
        }

        return ServerResponse.createByErrorMessage("status错误");
    }


    /**
     * 根据属性获取room
     * @param room
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getRoomByAttribute(Room room, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Room> roomList = roomMapper.selectRoomByAttribute(room);

        PageInfo pageInfo = new PageInfo(roomList);

        return ServerResponse.createBySuccess(pageInfo);
    }


    /**
     * 搜索适合的房间
     * @param reserveTime
     * @param reserveEndTime
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse searchRoomByTime(String reserveTime, String reserveEndTime, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Room> roomList = roomMapper.getRoomList();
        List<Room> roomListNew = new ArrayList<>();
        for(Room room : roomList){
            if (checkRoomTime(room,reserveTime,reserveEndTime)){
                roomListNew.add(room);
            }
        }

        PageInfo pageInfo = new PageInfo(roomList);
        pageInfo.setList(roomListNew);

        return ServerResponse.createBySuccess(pageInfo);
    }


    /**
     * 判断房间时间
     * @param room
     * @param reserveTimeNew
     * @param reserveEndTimeNew
     * @return
     */
     boolean checkRoomTime(Room room, String reserveTimeNew, String reserveEndTimeNew){
        String reserveTime = room.getReserveTime();
        String reserveEndTime = room.getReserveEndTime();
        if (StringUtils.isBlank(reserveTime) && StringUtils.isBlank(reserveEndTime)){
            return true;
        }
        String[] reserveTimeArray = reserveTime.split(",");
        String[] reserveEndTimeArray = reserveEndTime.split(",");

        int flag = 0;
        for (int i = 0; i < reserveTimeArray.length; i++){
            if (reserveTimeNew.compareTo(reserveTimeArray[i]) >= 0 && reserveTimeNew.compareTo(reserveEndTimeArray[i]) <= 0){
                flag = 1;
            }
            if (reserveEndTimeNew.compareTo(reserveTimeArray[i]) >= 0 && reserveEndTimeNew.compareTo(reserveEndTimeArray[i]) <= 0){
                flag = 1;
            }
            if (reserveTimeNew.compareTo(reserveTimeArray[i]) <= 0 && reserveEndTimeNew.compareTo(reserveEndTimeArray[i]) >= 0){
                flag = 1;
            }
            if (reserveEndTimeNew.compareTo(reserveTimeArray[i]) >= 0 && reserveEndTimeNew.compareTo(reserveEndTimeArray[i]) <= 0){
                flag = 1;
            }

            if (flag == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 删除房间字符串重的
     * @param room
     * @param reserveTimeNew
     * @param reserveEndTimeNew
     * @return
     */
    public Room deleteRoomTime(Room room, String reserveTimeNew, String reserveEndTimeNew){
        String reserveTime = room.getReserveTime();
        String reserveEndTime = room.getReserveEndTime();
        if (StringUtils.isBlank(reserveTime) && StringUtils.isBlank(reserveEndTime)){
            return room;
        }


        String[] reserveTimeArray = reserveTime.split(",");
        String[] reserveEndTimeArray = reserveEndTime.split(",");

        String reserveEndTimeNewStr = "";
        String reserveTimeNewStr = "";

        for (int i = 0; i < reserveTimeArray.length; i++){
            if (reserveTimeNew.equals(reserveTimeArray[i]) && reserveEndTimeNew.equals(reserveEndTimeArray[i])){

            } else{
                reserveTimeNewStr = reserveTimeNewStr + "," + reserveTimeArray[i];
                reserveEndTimeNewStr = reserveEndTimeNewStr + "," + reserveEndTimeArray[i];
            }
        }
        if (!reserveTimeNewStr.equals("")){
            reserveTimeNewStr = reserveTimeNewStr.substring(1);
            reserveEndTimeNewStr = reserveEndTimeNewStr.substring(1);
        }


        room.setReserveTime(reserveTimeNewStr);
        room.setReserveEndTime(reserveEndTimeNewStr);

        return room;
    }

}
















