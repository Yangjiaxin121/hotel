package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.RoomComments;

public interface IRoomCommentsService {

    ServerResponse addComments(RoomComments roomComments);

    ServerResponse getCommentByAttribute(RoomComments roomComments, Integer pageNum, Integer pageSize);

    ServerResponse updateComments(RoomComments roomComments);

    ServerResponse deleteComment(Integer commentsId);



}
