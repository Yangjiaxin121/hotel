package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.common.ServerResponse;
import com.hotel.dao.OrderMapper;
import com.hotel.dao.RoomCommentsMapper;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomComments;
import com.hotel.service.IRoomCommentsService;
import com.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iRoomCommentsService")
public class RoomCommentsService implements IRoomCommentsService {

    @Autowired
    RoomCommentsMapper roomCommentsMapper;

    @Autowired
    OrderMapper orderMapper;


    @Override
    public ServerResponse addComments(RoomComments roomComments) {

        int checkValue = roomCommentsMapper.insert(roomComments);
        if (checkValue > 0){
            Order order = new Order();
            order.setId(roomComments.getOrderId());
            order.setIsCommented(1);
            orderMapper.updateByPrimaryKeySelective(order);

            return ServerResponse.createBySuccessMessage("评论成功");
        }
        return ServerResponse.createByErrorMessage("评论失败");
    }

    @Override
    public ServerResponse getCommentByAttribute(RoomComments roomComments, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<RoomComments> commentList = roomCommentsMapper.selectCommentsByAttribute(roomComments);
        PageInfo pageInfo = new PageInfo(commentList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse updateComments(RoomComments roomComments) {

        int checkValue = roomCommentsMapper.updateByPrimaryKeySelective(roomComments);

        if (checkValue > 0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }



    @Override
    public ServerResponse deleteComment(Integer commentsId) {

        int checkValue = roomCommentsMapper.deleteByPrimaryKey(commentsId);

        RoomComments roomComments = roomCommentsMapper.selectByPrimaryKey(commentsId);

        if (checkValue > 0){
            Order order = new Order();
            order.setId(roomComments.getOrderId());
            order.setIsCommented(0);
            orderMapper.updateByPrimaryKeySelective(order);
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }


}


















