package com.hotel.controller.customer;


import com.hotel.common.Const;
import com.hotel.common.ResponseCode;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;
import com.hotel.service.IRoomService;
import com.hotel.service.IUserService;
import com.hotel.util.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/dream/customer/room/")
public class RoomCustomerController {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoomService iRoomService;

    @RequestMapping(value = "get_room_detail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, @RequestBody Map map) {

        Integer roomId = Integer.valueOf(map.get("roomId").toString());

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iRoomService.getRoomDetail(roomId);
    }

    @RequestMapping(value = "get_room_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomList(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iRoomService.getRoomList(pageNum, pageSize);

    }

    @RequestMapping(value = "search_room_by_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomListByName(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        String roomName = map.get("roomName").toString();

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iRoomService.searchRoomByName(roomName, pageNum, pageSize);

    }

    @RequestMapping(value = "search_room_by_status.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchRoomByStatus(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        Integer status = Integer.valueOf(map.get("status").toString());

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iRoomService.searchRoomByStatus(status, pageNum, pageSize);

    }

    @RequestMapping(value = "search_room_by_time.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchRoomByTime(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());


        String reserveTime = map.get("reserveTime").toString();
        String reserveEndTime = map.get("reserveEndTime").toString();

        if (StringUtils.isBlank(reserveTime) || StringUtils.isBlank(reserveEndTime)) {
            return iRoomService.getRoomList(pageNum, pageSize);
        }

        Date reserveTime1 = DateTimeUtil.strToDate(reserveTime);
        Date reserveEndTime1 = DateTimeUtil.strToDate(reserveEndTime);

        String reserveTime2 = String.valueOf(reserveTime1.getTime());
        String reserveEndTime2 = String.valueOf(reserveEndTime1.getTime());

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iRoomService.searchRoomByTime(reserveTime2, reserveEndTime2, pageNum, pageSize);

    }

}
