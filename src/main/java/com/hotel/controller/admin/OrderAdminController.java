package com.hotel.controller.admin;


import com.github.pagehelper.PageInfo;
import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.service.IOrderService;
import com.hotel.service.IUserService;
import com.hotel.bo.OrderBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/dream/admin/order")
public class OrderAdminController {


    @Autowired
    IUserService iUserService;

    @Autowired
    IOrderService iOrderService;


    @RequestMapping("get_order_list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        //填充我们增加产品的业务逻辑
        return iOrderService.getOrderList(pageNum, pageSize);

    }


    @RequestMapping("get_order_detail.do")
    @ResponseBody
    public ServerResponse<Order> orderDetail(HttpSession session, @RequestBody Map map) {

        Integer orderId = Integer.valueOf(map.get("orderId").toString());


        return iOrderService.getOrderDetail(orderId);

    }

    @RequestMapping("get_order_stay.do")
    @ResponseBody
    public ServerResponse orderStay(HttpSession session, @RequestBody Map map) {
        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());


        return iOrderService.getOrderByRoomStatus(Const.RoomStatus.Stay, pageNum, pageSize);

    }

    @RequestMapping("get_order_reserved.do")
    @ResponseBody
    public ServerResponse orderReserved(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());


        return iOrderService.getOrderByRoomStatus(Const.RoomStatus.RESERVED, pageNum, pageSize);

    }

    @RequestMapping("get_order_unsubscribed.do")
    @ResponseBody
    public ServerResponse orderUnsubscribed(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        return iOrderService.getOrderByRoomStatus(Const.RoomStatus.UNSUBSCRIBED, pageNum, pageSize);

    }

    @RequestMapping(value = "get_order_by_attribute.do")
    @ResponseBody
    public ServerResponse getRoomByAttribute(@RequestBody OrderBo orderBo) {


        Integer pageNum = orderBo.getPageNum();
        Integer pageSize = orderBo.getPageSize();
        Order order = orderBo.getOrder();

        return iOrderService.getOrderByAttribute(order, pageNum, pageSize);
    }


}

















