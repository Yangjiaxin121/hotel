package com.hotel.controller.customer;

import com.hotel.common.ServerResponse;
import com.hotel.common.Const;
import com.hotel.common.ResponseCode;
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
@RequestMapping("/dream/customer/user/")
public class UserCustomerController {


    @Autowired
    private IUserService iUserService;


    /**
     * 用户登录
     * @param
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(@RequestBody Map map, HttpSession session){
        String username = map.get("username").toString();
        String password = map.get("password").toString();

        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(@RequestBody User user){
        return iUserService.register(user);
    }


    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(@RequestBody Map map){

        String str = map.get("str").toString();
        String type = map.get("type").toString();

        return iUserService.checkValid(str,type);
    }


    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }


    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(@RequestBody Map map){

        String username = map.get("username").toString();

        return iUserService.selectQuestion(username);
    }


    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(@RequestBody Map map){

        String username = map.get("username").toString();
        String question = map.get("question").toString();
        String answer = map.get("answer").toString();

        return iUserService.checkAnswer(username,question,answer);
    }


    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(@RequestBody Map map){
        String username = map.get("username").toString();
        String passwordNew = map.get("passwordNew").toString();
        String forgetToken = map.get("forgetToken").toString();

        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }



    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session,@RequestBody Map map){

        String passwordOld = map.get("passwordOld").toString();
        String passwordNew = map.get("passwordNew").toString();

        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }


    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session, @RequestBody User user){
//        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
//        if(currentUser == null){
//            return ServerResponse.createByErrorMessage("用户未登录");
//        }
//        user.setId(currentUser.getId());
//        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);

        return response;
    }

    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }






























}
