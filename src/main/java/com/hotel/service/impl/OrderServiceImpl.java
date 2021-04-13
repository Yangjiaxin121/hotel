package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.dao.OrderMapper;
import com.hotel.dao.RoomMapper;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.service.IOrderService;
import com.hotel.util.BigDecimalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RoomServiceImpl roomService;



    /**
     * 查询所有订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getOrderList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.getOrderList();
        for (Order order : orderList){
            Date inTakeTime = order.getIntakeTime();
            Date reserveEndTime = order.getReserveEndTime();
            Date endTime = order.getEndTime();
            if (reserveEndTime.compareTo(new Date()) < 0 && inTakeTime == null && endTime == null){
                order.setIntakeTime(reserveEndTime);
                order.setEndTime(reserveEndTime);
            }
        }

        PageInfo pageInfo = new PageInfo(orderList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 根据orderNo查询订单详情
     *
     * @param orderId
     * @return
     */
    @Override
    public ServerResponse getOrderDetail(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);

        if (order != null) {
            return ServerResponse.createBySuccess(order);
        }

        return ServerResponse.createByErrorMessage("订单不存在");
    }


    /**
     * 根据房间状态查询order
     *
     * @param roomStatus
     * @return
     */
    @Override
    public ServerResponse getOrderByRoomStatus(Integer roomStatus, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = Lists.newArrayList();
        PageInfo pageInfo;
        if (roomStatus == Const.RoomStatus.Stay || roomStatus == Const.RoomStatus.RESERVED || roomStatus == Const.RoomStatus.UNSUBSCRIBED || roomStatus == Const.RoomStatus.CHECKIN  || roomStatus == Const.RoomStatus.EmptyRoom) {
            orderList = orderMapper.selectOrderByRoomStatus(roomStatus);
            pageInfo = new PageInfo(orderList);
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }

        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 修改订单房间状态
     *
     * @param roomStatus
     * @return
     */
    @Override
    public ServerResponse setOrderRoomStatus(Integer orderId,Integer roomStatus) {

        if (orderId == null || roomStatus == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }

        if (roomStatus == Const.RoomStatus.Stay || roomStatus == Const.RoomStatus.RESERVED || roomStatus == Const.RoomStatus.UNSUBSCRIBED || roomStatus == Const.RoomStatus.CHECKIN  || roomStatus == Const.RoomStatus.EmptyRoom) {
            int checkValue = orderMapper.updateRoomStatus(orderId,roomStatus);
            ServerResponse response = getOrderDetail(orderId);
            Order order = (Order) response.getData();
            if (order == null){
                return ServerResponse.createByErrorMessage("订单不存在");
            }
            int roomId = order.getRoomId();

            //这些状态都将房间状态置为已预订
            if (roomStatus == Const.RoomStatus.CHECKIN || roomStatus == Const.RoomStatus.RESERVED || roomStatus == Const.RoomStatus.Stay){
                roomMapper.updateRoomStatus(roomId,Const.RoomStatus.RESERVED);
            } else if (roomStatus == Const.RoomStatus.UNSUBSCRIBED){//退订时将房间状态设置为空
                roomMapper.updateRoomStatus(roomId,Const.RoomStatus.EmptyRoom);
            }

            if (roomStatus == Const.RoomStatus.CHECKIN){
                Order order1 = new Order();
                order1.setId(orderId);
                order1.setIntakeTime(new Date());

                orderMapper.updateByPrimaryKeySelective(order1);
            }
            if (roomStatus == Const.RoomStatus.UNSUBSCRIBED){

                Date checkinTime = order.getIntakeTime();
                if (checkinTime == null || checkinTime.compareTo(new Date()) > 0){
                    return ServerResponse.createByErrorMessage("退房时间非法");
                }
                Order order1 = new Order();
                order1.setId(orderId);
                order1.setEndTime(new Date());
                order1.setStatus(Const.OrderStatusEnum.ORDER_SUCCESS.getCode());

                Room room = roomMapper.selectByPrimaryKey(roomId);


                String reserveTimeStr = String.valueOf(order.getReserveTime().getTime());
                String reserveEndTimeStr = String.valueOf(order.getReserveEndTime().getTime());

                room = roomService.deleteRoomTime(room, reserveTimeStr, reserveEndTimeStr);
                roomMapper.updateByPrimaryKeySelective(room);
                orderMapper.updateByPrimaryKeySelective(order1);
            }

            if (checkValue > 0){
                return ServerResponse.createBySuccessMessage("修改成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("房间状态错误");
        }

        return ServerResponse.createBySuccessMessage("修改失败");
    }

    /**
     * 根据用户id获取order
     * @param userId
     * @return
     */
    @Override
    public ServerResponse getOrderByUserId(Integer userId) {

        Order order = orderMapper.selectByUserId(userId);
        return ServerResponse.createBySuccess(order);
    }


    /**
     * 根据orderId修改Order
     * @param order
     * @return
     */
    @Override
    public ServerResponse updateOrder(Order order) {

        int checkValue = orderMapper.updateByPrimaryKeySelective(order);
        if (checkValue > 0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }


    /**
     * 创建订单
     * @param order
     * @return
     */
    @Override
    public ServerResponse createOrder(Order order) {
        if (order.getUserId() == null || order.getRoomId() == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Room room = roomMapper.selectByPrimaryKey(order.getRoomId());
        if (room == null){
            return ServerResponse.createByErrorMessage("无此房间");
        }
//        if (room.getStatus() == Const.RoomStatus.RESERVED){
//            return ServerResponse.createByErrorMessage("房间已被预定，请重新预定");
//        }
        order.setStatus(Const.OrderStatusEnum.NO_PAY.getCode());
        order.setRoomStatus(Const.RoomStatus.RESERVED);


     //   int checkValue1 = roomMapper.updateRoomStatus(order.getRoomId(),Const.RoomStatus.RESERVED);


        Room room1 = new Room();
        room1.setId(order.getRoomId());
        // 检查是否可以入住


        String reserveTimeNew = String.valueOf(order.getReserveTime().getTime());
        String reserveEndTimeNew = String.valueOf(order.getReserveEndTime().getTime());

        boolean flag = roomService.checkRoomTime(room,reserveTimeNew,reserveEndTimeNew);
        if (!flag){
            return ServerResponse.createByErrorMessage("时间冲突");
        }

        int checkValue = orderMapper.insert(order);

        String reserveTime = room.getReserveTime();
        String reserveEndTime = room.getReserveEndTime();
        if (StringUtils.isBlank(reserveTime) && StringUtils.isBlank(reserveEndTime)){
            reserveTime = String.valueOf(order.getReserveTime().getTime());
            reserveEndTime = String.valueOf(order.getReserveEndTime().getTime());
        } else {
            reserveTime = reserveTime + "," + String.valueOf(order.getReserveTime().getTime());
            reserveEndTime = reserveEndTime + "," + String.valueOf(order.getReserveEndTime().getTime());
        }
        room1.setReserveTime(reserveTime);
        room1.setReserveEndTime(reserveEndTime);
        room1.setStatus(Const.RoomStatus.RESERVED);

        int checkValue1 = roomMapper.updateByPrimaryKeySelective(room1);

        if (checkValue > 0 && checkValue1 > 0){
            return ServerResponse.createBySuccess(order.getId());
        }
        return ServerResponse.createByErrorMessage("创建失败");
    }


//    /**
//     * 用户申请续住
//     * @param userId
//     * @param orderStayBo
//     * @return
//     */
//    @Override
//    public ServerResponse setOrderStaying(Integer userId, OrderStayBo orderStayBo) {
//
//
//        Order order = new Order();
//        order.setId(orderStayBo.getOrderId());
//        order.setStayDays(orderStayBo.getStayDays());
//        order.setStatus(Const.RoomStatus.STAYING);
//
//        Order order1 = orderMapper.selectByPrimaryKey(orderStayBo.getOrderId());
//        Integer roomId = order1.getRoomId();
//        Room room = roomMapper.selectByPrimaryKey(roomId);
//        BigDecimal price = room.getPrice();
//
//        BigDecimal payment = BigDecimalUtil.mul(orderStayBo.getStayDays(),price.doubleValue());
//        order.setPayment(payment);
//
//        int checkValue = orderMapper.updateByPrimaryKeySelective(order);
//        if (checkValue > 0){
//            return ServerResponse.createBySuccessMessage("申请续住成功");
//        }
//        return ServerResponse.createByErrorMessage("申请续住失败");
//    }
//

    /**
     * 用户进行支付
     * @param orderId
     * @return
     */
    @Override
    public ServerResponse myOrderPay(Integer orderId) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        BigDecimal payment = order.getPayment();
        BigDecimal totalPayment = order.getTotalPayment();
        if (totalPayment == null){
            totalPayment = new BigDecimal("0");
        }
        totalPayment = BigDecimalUtil.add(payment.doubleValue(),totalPayment.doubleValue());
        payment = new BigDecimal("0");

        order.setPayment(payment);
        order.setTotalPayment(totalPayment);
        order.setPaymentTime(new Date());
        order.setStatus(Const.OrderStatusEnum.PAID.getCode());
        order.setPaymentType(Const.PayType.ONLINE_PAY);
        order.setPaymentTime(new Date());

        int checkValue = orderMapper.updateByPrimaryKeySelective(order);
        if (checkValue > 0){
            return ServerResponse.createBySuccessMessage("支付成功");
        }
        return ServerResponse.createByErrorMessage("支付失败");
    }

    /**
     * 设置订单续住
     * @param orderId
     * @return
     */
    @Override
    public ServerResponse setOrderStay(Integer orderId, Integer stayDays) {

        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null){
            return ServerResponse.createByErrorMessage("订单不存在");
        }

        Integer roomId = order.getRoomId();
        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (room == null){
            return ServerResponse.createByErrorMessage("订单错误");
        }


        Date reserveEndTime = order.getReserveEndTime();
        Date reserveTime = order.getReserveTime();

        String reserveTimeStr = String.valueOf(order.getReserveTime().getTime());
        String reserveEndTimeStr = String.valueOf(order.getReserveEndTime().getTime());


        //计算续订后的结束时间
        long endTimeLong = reserveEndTime.getTime();
        endTimeLong = endTimeLong + stayDays*24*60*60*1000;

        Room room1 = new Room();
        room1.setReserveTime(room.getReserveTime());
        room1.setReserveEndTime(room.getReserveEndTime());
        room1 =  roomService.deleteRoomTime(room1,reserveTimeStr,reserveEndTimeStr);
        //比较时间，检查时间是否可以
        boolean flag = roomService.checkRoomTime(room1,reserveTimeStr,String.valueOf(endTimeLong));
        if (!flag){
            return ServerResponse.createByErrorMessage("时间冲突");
        }

        //计算加个
        BigDecimal price = room.getPrice();
        BigDecimal payment = BigDecimalUtil.mul(stayDays.doubleValue(),price.doubleValue());
        order.setPayment(payment);

        reserveEndTime = new Date(endTimeLong);

        order.setReserveEndTime(reserveEndTime);
        order.setRoomStatus(Const.RoomStatus.Stay);

        Integer totalDays = order.getTotalDays();
        totalDays = totalDays + stayDays;
        order.setTotalDays(totalDays);
        order.setStayDays(order.getStayDays() + stayDays);

        int checkValue = orderMapper.updateByPrimaryKeySelective(order);



        String roomReserveTime = room.getReserveTime();
        String roomReserveEndTime = room.getReserveEndTime();

        String[] reserveTimeArray = roomReserveTime.split(",");
        String[] reserveEndTimeArray = roomReserveEndTime.split(",");

        String reserveEndTimeNew = "";

        for (int i = 0; i < reserveTimeArray.length; i++){
            if (reserveTimeStr.equals(reserveTimeArray[i]) && reserveEndTimeStr.equals(reserveEndTimeArray[i])){
                reserveEndTimeArray[i] = String.valueOf(endTimeLong);
            }
            reserveEndTimeNew = reserveEndTimeNew + "," + reserveEndTimeArray[i];
        }
        reserveEndTimeNew = reserveEndTimeNew.substring(1);

        room.setReserveEndTime(reserveEndTimeNew);

        int checkValue2 = roomMapper.updateByPrimaryKeySelective(room);





//        Order order1 = orderMapper.selectByPrimaryKey(orderId);
//        order1.setStayDays();
//        int checkValue2 = orderMapper.updateByPrimaryKeySelective(order1);

        if (checkValue > 0 && checkValue2 > 0){
            return ServerResponse.createBySuccessMessage("续住成功");
        }



        return ServerResponse.createByErrorMessage("续住失败");
    }

    /**
     * 根据属性查询order
     * @param order
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getOrderByAttribute(Order order, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Order> orderList = orderMapper.selectOrderByAttribute(order);

        PageInfo pageInfo = new PageInfo(orderList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}




























