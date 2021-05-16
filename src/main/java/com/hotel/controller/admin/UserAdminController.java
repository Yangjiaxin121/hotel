package com.hotel.controller.admin;

import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;
import com.hotel.service.IUserService;
import com.hotel.bo.UserBo;


import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by geely
 */

@Api(value = "管理员用户相关接口", tags = {"管理员用户相关接口"})
@Controller
@RequestMapping("/dream/admin/user")
public class UserAdminController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "管理员登陆", notes = "管理员登陆", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "管理员用户名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "管理员密码", required = true, paramType = "String"),
    })
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse login(
            @RequestBody Map map) {

        String username = map.get("username").toString();
        String password = map.get("password").toString();


        ServerResponse<User> response = iUserService.login(username, password);
        User user = response.getData();
        if (user != null) {
            Integer userId = response.getData().getId();
            return ServerResponse.createBySuccess(userId);
        }

        return response;
    }


    @ApiOperation(value = "获取所有用户", notes = "获取所有用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, paramType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的条数", required = true, paramType = "pageSize"),
    })
    @RequestMapping(value = "get_all_customer.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getAllCustomer(@RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        return iUserService.getAllCustomer(pageNum, pageSize);

    }

    @ApiOperation(value = "根据用户的特征查找用户", notes = "获取所有用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, paramType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示的条数", required = true, paramType = "pageSize"),
    })
    @RequestMapping(value = "get_customer_by_attribute.do")
    @ResponseBody
    public ServerResponse getCustomerByAttribute(@RequestBody UserBo userBo) {


        Integer pageNum = userBo.getPageNum();
        Integer pageSize = userBo.getPageSize();
        User user = userBo.getUser();

        return iUserService.getUserByAttribute(user, pageNum, pageSize);

    }


    @RequestMapping(value = "get_user_by_id.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getUserInfo(@RequestBody Map map) {

        Integer userId = Integer.valueOf(map.get("userId").toString());

        return iUserService.getInformation(userId);
    }

    @RequestMapping(value = "deletet_user_by_id.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteUserById(@RequestBody Map map) {

        Integer userId = Integer.valueOf(map.get("userId").toString());

        return iUserService.deleteUserById(userId);
    }


}














