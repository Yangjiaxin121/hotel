package com.hotel.controller.customer;

import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomComments;
import com.hotel.pojo.User;
import com.hotel.service.IOrderService;
import com.hotel.service.IRoomCommentsService;
import com.hotel.service.IRoomService;
import com.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/dream/customer/comments/")
public class RoomCommentCustomerController {

    @Autowired
    IRoomCommentsService iRoomCommentsService;

    @Autowired
    IOrderService iOrderService;

    @Autowired
    IRoomService iRoomService;

    @Autowired
    IUserService iUserService;

    @RequestMapping("add_comments.do")
    @ResponseBody
    public ServerResponse addComments(@RequestBody Map map) {

        Integer orderId = Integer.valueOf(map.get("orderId").toString());
        Integer userId = Integer.valueOf(map.get("userId").toString());
        Integer roomId = Integer.valueOf(map.get("roomId").toString());
        Integer commentLevel = Integer.valueOf(map.get("commentLevel").toString());
        String content = map.get("content").toString();


        Order order = (Order) iOrderService.getOrderDetail(orderId).getData();
        if (order == null){
            return ServerResponse.createByErrorMessage("订单不存在");
        }
        if (order.getUserId() != userId ){
            return ServerResponse.createByErrorMessage("横向越权错误");
        }

        Room room = (Room) iRoomService.getRoomDetail(roomId).getData();
        if (room == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }

        User user = iUserService.getInformation(userId).getData();

        RoomComments roomComments = new RoomComments();
        roomComments.setUserId(userId);
        roomComments.setRoomId(roomId);
        roomComments.setOrderId(orderId);
        roomComments.setCommentLevel(commentLevel);
        roomComments.setContent(content);
        roomComments.setUsername(user.getUsername());

        roomComments.setRoomName(room.getName());

        return iRoomCommentsService.addComments(roomComments);

    }

    @RequestMapping("get_my_comments.do")
    @ResponseBody
    public ServerResponse getMyComments(@RequestBody Map map) {

        Integer userId = Integer.valueOf(map.get("userId").toString());

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());


        RoomComments roomComments = new RoomComments();
        roomComments.setUserId(userId);

        return iRoomCommentsService.getCommentByAttribute(roomComments,pageNum,pageSize);

    }

    @RequestMapping("update_my_comments.do")
    @ResponseBody
    public ServerResponse updateMyComments(@RequestBody RoomComments roomComments) {

        if (roomComments == null){
            return ServerResponse.createByErrorMessage("不能为空");
        }

        return iRoomCommentsService.updateComments(roomComments);

    }

    @RequestMapping("delete_my_comments.do")
    @ResponseBody
    public ServerResponse deleteMyComments(@RequestBody Map map) {

        Integer commentsId = Integer.valueOf(map.get("commentsId").toString());

        return iRoomCommentsService.deleteComment(commentsId);

    }

}


















