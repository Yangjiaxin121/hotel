package com.hotel.controller.customer;


import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.pojo.User;
import com.hotel.service.IOrderService;
import com.hotel.service.IUserService;
import com.hotel.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/dream/customer/order/")
public class OrderCustomerController {


    @Autowired
    IUserService iUserService;

    @Autowired
    IOrderService iOrderService;


    @RequestMapping("create_my_order.do")
    @ResponseBody
    public ServerResponse orderCreate(HttpSession session, @RequestBody Map map) {

        Order order = new Order();
        order.setRoomId(Integer.valueOf(map.get("roomId").toString()));
        order.setUserId(Integer.valueOf(map.get("userId").toString()));
        order.setPayment(new BigDecimal(map.get("payment").toString()));
        order.setTotalDays(Integer.valueOf(map.get("totalDays").toString()));

        String reserveTime = map.get("reserveTime").toString();
        String reserveEndTime = map.get("reserveEndTime").toString();

        Integer roomNumber = Integer.valueOf(map.get("roomNumber").toString());
        String realName = map.get("realName").toString();


        Date reserveTime1 = DateTimeUtil.strToDate(reserveTime);
        Date reserveEndTime1 = DateTimeUtil.strToDate(reserveEndTime);

        order.setReserveTime(reserveTime1);
        order.setReserveEndTime(reserveEndTime1);

        order.setRoomNumber(roomNumber);
        order.setRealName(realName);


        order.setStayDays(0);


        return iOrderService.createOrder(order);

    }

    @RequestMapping("get_my_order.do")
    @ResponseBody
    public ServerResponse orderDetail(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iOrderService.getOrderByUserId(user.getId());

    }

    //废除
    @RequestMapping("update_my_order.do")
    @ResponseBody
    public ServerResponse orderUpdate(HttpSession session, Order order) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        Integer orderId = order.getId();
        Order order1 = (Order) iOrderService.getOrderDetail(orderId).getData();
        if (!order1.getUserId().equals(order.getUserId())) {
            return ServerResponse.createByErrorMessage("横向越权");
        }
        return iOrderService.updateOrder(order);

    }


    @RequestMapping("my_order_pay.do")
    @ResponseBody
    public ServerResponse setOrderPay(HttpSession session, @RequestBody Map map) {

        Integer orderId = Integer.valueOf(map.get("orderId").toString());


        return iOrderService.myOrderPay(orderId);
    }


}
