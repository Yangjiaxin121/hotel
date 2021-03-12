package com.hotel.dao;

import com.hotel.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getOrderList();

    List<Order> selectOrderByRoomStatus(Integer roomStatus);

    int updateRoomStatus(@Param("orderId") Integer orderId, @Param("roomStatus") Integer roomStatus);

    Order selectByUserId(Integer userId);

    List<Order> selectOrderByAttribute(Order order);

}