package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;

public interface IOrderService {

    ServerResponse getOrderList(Integer pageNum, Integer pageSize);

    ServerResponse getOrderDetail(Integer orderId);

    ServerResponse getOrderByRoomStatus(Integer roomStatus, Integer pageNum, Integer pageSize);

    ServerResponse setOrderRoomStatus(Integer orderId,Integer roomStatus);

    ServerResponse getOrderByUserId(Integer userId);

    ServerResponse updateOrder(Order order);

    ServerResponse createOrder(Order order);

//    ServerResponse setOrderStaying(Integer userId, OrderStayBo orderStayBo);

    ServerResponse myOrderPay(Integer orderId);

    ServerResponse setOrderStay(Integer orderId, Integer stayDays);


    ServerResponse getOrderByAttribute(Order order, Integer pageNum, Integer pageSize);
}
