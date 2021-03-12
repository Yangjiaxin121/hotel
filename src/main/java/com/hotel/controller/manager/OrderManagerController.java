package com.hotel.controller.manager;


import com.github.pagehelper.PageInfo;
import com.hotel.common.Const;
import com.hotel.common.ResponseCode;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.pojo.User;
import com.hotel.service.IOrderService;
import com.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/dream/manager1/order")
public class OrderManagerController {

    @Autowired
    IUserService iUserService;

    @Autowired
    IOrderService iOrderService;


    @RequestMapping("get_order_list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session, @RequestBody Map map){

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录前台人员");
//
//        }
        if(iUserService.checkManagerRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑
            return iOrderService.getOrderList(pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("get_order_detail.do")
    @ResponseBody
    public ServerResponse orderDetail(HttpSession session, @RequestBody Map map){

        Integer orderId = Integer.valueOf(map.get("orderId").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录前台人员");
//
//        }
        if(iUserService.checkManagerRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑

            return iOrderService.getOrderDetail(orderId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

//    @RequestMapping("get_order_staying.do")
//    @ResponseBody
//    public ServerResponse orderStay(HttpSession session, @RequestBody Map map){
//
//        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
//        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
//
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
////        if(user == null){
////            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
////
////        }
//        if(iUserService.checkManagerRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//
//            return iOrderService.getOrderByRoomStatus(Const.RoomStatus.STAYING,pageNum,pageSize);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
//    }

    @RequestMapping("get_order_reserved.do")
    @ResponseBody
    public ServerResponse orderReserved(HttpSession session, @RequestBody Map map){

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
        if(iUserService.checkManagerRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑

            return iOrderService.getOrderByRoomStatus(Const.RoomStatus.RESERVED,pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

//    @RequestMapping("get_order_unsubscribing.do")
//    @ResponseBody
//    public ServerResponse orderUnsubscribed(HttpSession session, @RequestBody Map map){
//
//        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
//        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
//
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
////        if(user == null){
////            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
////
////        }
//        if(iUserService.checkManagerRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//
//            return iOrderService.getOrderByRoomStatus(Const.RoomStatus.UNSUBSCRIBING, pageNum,pageSize);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
//    }

    @RequestMapping("get_order_by_status.do")
    @ResponseBody
    public ServerResponse getOrderByStatus(HttpSession session, @RequestBody Map map){

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        Integer status = Integer.valueOf(map.get("status").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
        if(iUserService.checkManagerRole(user).isSuccess()){
            //填充我们增加产品的业务逻辑

            return iOrderService.getOrderByRoomStatus(status, pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }


    //1
    @RequestMapping("set_order_checkin.do")
    @ResponseBody
    public ServerResponse setOrderCheckin(HttpSession session, @RequestBody Map map){

        Integer orderId = Integer.valueOf(map.get("orderId").toString());
        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }

        Order order = (Order) iOrderService.getOrderDetail(orderId).getData();
        Date reserveTime = order.getReserveTime();
        Date currentDate = new Date();
//        if (reserveTime.compareTo(currentDate) > 0){
//            return ServerResponse.createByErrorMessage("不在预定时间，无法入住");
//        }

       // if(iUserService.checkManagerRole(user).isSuccess()){
            return iOrderService.setOrderRoomStatus(orderId,Const.RoomStatus.CHECKIN);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }

    //1
    @RequestMapping("set_order_stay.do")
    @ResponseBody
    public ServerResponse setOrderStay(HttpSession session, @RequestBody Map map){

        Integer orderId = Integer.valueOf(map.get("orderId").toString());
        Integer stayDays = Integer.valueOf(map.get("stayDays").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
       // if(iUserService.checkManagerRole(user).isSuccess()){

            return iOrderService.setOrderStay(orderId,stayDays);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }

    //1
    @RequestMapping("set_order_unsubscribed.do")
    @ResponseBody
    public ServerResponse setOrderUnsubscribed(HttpSession session, @RequestBody Map map){

        Integer orderId = Integer.valueOf(map.get("orderId").toString());

        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//
//        }
     //   if(iUserService.checkManagerRole(user).isSuccess()){

            return iOrderService.setOrderRoomStatus(orderId,Const.RoomStatus.UNSUBSCRIBED);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }



}
