package com.hotel.controller.manager;

import com.hotel.common.Const;
import com.hotel.common.ResponseCode;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;
import com.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by geely
 */

@Controller
@RequestMapping("/manager1/user")
public class UserManagerController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestBody Map map, HttpSession session){

        String username = map.get("username").toString();
        String password = map.get("password").toString();

        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_MANAGER){
                //说明登录的是工作人员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是前台工作人员,无法登录");
            }
        }
        return response;
    }


    @RequestMapping(value="update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpSession session, @RequestBody User user){

//        User user1 = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user1 == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请登录");
//        }
        //校验一下是否是管理员
//        if (iUserService.checkManagerRole(user1).isSuccess()){
//            user.setId(user1.getId());
            return iUserService.updateInformation(user);
//        } else {
//            return ServerResponse.createByErrorMessage("无权限操作，需要前台工作人员权限");
//        }
    }



}


















