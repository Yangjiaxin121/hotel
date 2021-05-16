package com.hotel.controller.admin;


import com.google.common.collect.Maps;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Room;
import com.hotel.service.IFileService;
import com.hotel.service.IRoomService;
import com.hotel.service.IUserService;
import com.hotel.util.PropertiesUtil;
import com.hotel.bo.RoomBo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/dream/admin/room")
public class RoomAdminController {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoomService iRoomService;

    @Autowired
    IFileService iFileService;


    @RequestMapping(value = "add_room.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addRoom(@RequestBody Room room) {

        return iRoomService.addRoom(room);

    }

    @RequestMapping(value = "update_room.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRoom(HttpSession session, @RequestBody Room room) {

        return iRoomService.updateRoom(room);

    }

    @RequestMapping(value = "set_room_status.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRoom(HttpSession session, @RequestBody Map map) {
        Integer roomId = Integer.valueOf(map.get("rooId").toString());
        Integer roomStatus = Integer.valueOf(map.get("roomStatus").toString());

        return iRoomService.setRoomStatus(roomId, roomStatus);

    }

    @RequestMapping(value = "get_room_detail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, @RequestBody Map map) {

        Integer roomId = Integer.valueOf(map.get("roomId").toString());

        return iRoomService.getRoomDetail(roomId);

    }

    @RequestMapping(value = "get_room_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomList(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        return iRoomService.getRoomList(pageNum, pageSize);

    }

    @RequestMapping(value = "search_room_by_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomByName(HttpSession session, @RequestBody Map map) {
        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        String roomName = map.get("roomName").toString();


        return iRoomService.searchRoomByName(roomName, pageNum, pageSize);

    }

    @RequestMapping(value = "search_room_by_status.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomListByStatus(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        Integer status = Integer.valueOf(map.get("status").toString());

        return iRoomService.searchRoomByStatus(status, pageNum, pageSize);

    }


    @RequestMapping(value = "get_room_by_attribute.do")
    @ResponseBody
    public ServerResponse getRoomByAttribute(@RequestBody RoomBo roomBo) {


        Integer pageNum = roomBo.getPageNum();
        Integer pageSize = roomBo.getPageSize();
        Room room = roomBo.getRoom();

        return iRoomService.getRoomByAttribute(room, pageNum, pageSize);

    }

    @RequestMapping(value = "delete_room_by_id.do")
    @ResponseBody
    public ServerResponse getRoomByAttribute(@RequestBody Map map) {

        Integer roomId = Integer.valueOf(map.get("roomId").toString());

        return iRoomService.deleteRoomById(roomId);

    }


    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request) {

        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file, path);
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;

        Map fileMap = Maps.newHashMap();
        fileMap.put("uri", targetFileName);
        fileMap.put("url", url);
        return ServerResponse.createBySuccess(fileMap);

    }


    @RequestMapping("richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap = Maps.newHashMap();

        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file, path);
        if (StringUtils.isBlank(targetFileName)) {
            resultMap.put("success", false);
            resultMap.put("msg", "上传失败");
            return resultMap;
        }
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;
        resultMap.put("success", true);
        resultMap.put("msg", "上传成功");
        resultMap.put("file_path", url);
        response.addHeader("Access-Control-Allow-Headers", "X-File-Name");
        return resultMap;

    }
}
