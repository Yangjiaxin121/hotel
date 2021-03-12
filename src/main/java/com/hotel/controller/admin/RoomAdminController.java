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


    @RequestMapping(value = "add_room.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addRoom(@RequestBody Room room){
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
      //  if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.addRoom(room);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "update_room.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRoom(HttpSession session, @RequestBody Room room){
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
     //   if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.updateRoom(room);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "set_room_status.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateRoom(HttpSession session,@RequestBody Map map ){
        Integer roomId = Integer.valueOf(map.get("rooId").toString());
        Integer roomStatus = Integer.valueOf(map.get("roomStatus").toString());
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
       // if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.setRoomStatus(roomId, roomStatus);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "get_room_detail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, @RequestBody Map map){

        Integer roomId = Integer.valueOf(map.get("roomId").toString());
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
       // if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.getRoomDetail(roomId);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "get_room_list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomList(HttpSession session, @RequestBody Map map){

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
      //  if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.getRoomList(pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "search_room_by_name.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomByName(HttpSession session, @RequestBody Map map ){
        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        String roomName = map.get("roomName").toString();

//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
       // if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.searchRoomByName(roomName, pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }

    @RequestMapping(value = "search_room_by_status.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getRoomListByStatus(HttpSession session,@RequestBody Map map ){

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        Integer status = Integer.valueOf(map.get("status").toString());
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
     //   if (iUserService.checkAdminRole(user).isSuccess()){
            return iRoomService.searchRoomByStatus(status, pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
//        }
    }



    @RequestMapping(value="get_room_by_attribute.do")
    @ResponseBody
    public ServerResponse getRoomByAttribute(@RequestBody RoomBo roomBo ){


        Integer pageNum = roomBo.getPageNum();
        Integer pageSize = roomBo.getPageSize();
        Room room = roomBo.getRoom();
//        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
//        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

//        User user = new User();
//        if (map.containsKey("id")){
//            user.setId(Integer.valueOf(map.get("id").toString()));
//        }
//        if (map.containsKey("username")){
//            user.setUsername(map.get("username").toString());
//        }
//        if (map.containsKey("email"))
        return iRoomService.getRoomByAttribute(room,pageNum,pageSize);

    }



    @RequestMapping("upload.do")
    @ResponseBody
    public ServerResponse upload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request){
//        User user = (User)session.getAttribute(Const.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录管理员");
//        }
       // if(iUserService.checkAdminRole(user).isSuccess()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            String targetFileName = iFileService.upload(file,path);
            String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFileName;

            Map fileMap = Maps.newHashMap();
            fileMap.put("uri",targetFileName);
            fileMap.put("url",url);
            return ServerResponse.createBySuccess(fileMap);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }


    @RequestMapping("richtext_img_upload.do")
    @ResponseBody
    public Map richtextImgUpload(HttpSession session, @RequestParam(value = "upload_file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        Map resultMap = Maps.newHashMap();
      //  User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            resultMap.put("success", false);
//            resultMap.put("msg", "请登录管理员");
//            return resultMap;
//        }
        //富文本中对于返回值有自己的要求,我们使用是simditor所以按照simditor的要求进行返回
//        {
//            "success": true/false,
//                "msg": "error message", # optional
//            "file_path": "[real file path]"
//        }
       // if (iUserService.checkAdminRole(user).isSuccess()) {
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
//        } else {
//            resultMap.put("success", false);
//            resultMap.put("msg", "无权限操作");
//            return resultMap;
//        }
    }
}
