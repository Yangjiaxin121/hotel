package com.hotel.controller.admin;

import com.hotel.bo.CommentsBo;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.pojo.RoomComments;
import com.hotel.service.IOrderService;
import com.hotel.service.IRoomCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/dream/admin/comments/")
public class RoomCommentAdminController {

    @Autowired
    IRoomCommentsService iRoomCommentsService;

    @Autowired
    IOrderService iOrderService;



    @RequestMapping("get_comments_by_attribute.do")
    @ResponseBody
    public ServerResponse getMyComments(@RequestBody CommentsBo commentsBo) {

        RoomComments roomComments = commentsBo.getRoomComments();
        Integer pageNum = commentsBo.getPageNum();
        Integer pageSize = commentsBo.getPageSize();


        return iRoomCommentsService.getCommentByAttribute(roomComments,pageNum,pageSize);

    }

    @RequestMapping("update_comments.do")
    @ResponseBody
    public ServerResponse updateComments(@RequestBody RoomComments roomComments) {

        if (roomComments == null){
            return ServerResponse.createByErrorMessage("不能为空");
        }

        return iRoomCommentsService.updateComments(roomComments);

    }

    @RequestMapping("delete_comments.do")
    @ResponseBody
    public ServerResponse deleteMyComments(@RequestBody Map map) {

        Integer commentsId = Integer.valueOf(map.get("commentsId").toString());

        return iRoomCommentsService.deleteComment(commentsId);

    }

}


















