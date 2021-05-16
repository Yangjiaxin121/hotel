package com.hotel.controller.admin;


import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;
import com.hotel.service.IUserManagerService;
import com.hotel.service.IUserService;
import com.hotel.bo.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/dream/admin/manager")
public class ManagerAdminController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserManagerService iUserManagerService;


    @RequestMapping(value = "list_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getManagerList(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());

        return iUserManagerService.getManagerList(pageNum, pageSize);

    }

    @RequestMapping(value = "add_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addManager(HttpSession session, @RequestBody User user) {


        return iUserService.registerManager(user);

    }

    @RequestMapping(value = "search_manager_by_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchManagerByName(HttpSession session, @RequestBody Map map) {

        Integer pageNum = Integer.valueOf(map.get("pageNum").toString());
        Integer pageSize = (Integer) map.get("pageSize");
        String userName = map.get("userName").toString();

        User user = (User) session.getAttribute(Const.CURRENT_USER);

        return iUserManagerService.searchManager(userName, pageNum, pageSize);

    }

    @RequestMapping(value = "search_manager_by_id.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchManagerById(HttpSession session, @RequestBody Map map) {


        Integer userId = Integer.valueOf(map.get("userId").toString());


        return iUserService.getInformation(userId);

    }

    @RequestMapping(value = "delete_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteManager(HttpSession session, @RequestBody Map map) {

        Integer userId = Integer.valueOf(map.get("userId").toString());

        return iUserService.deleteUserById(userId);

    }

    @RequestMapping(value = "update_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateManager(HttpSession session, @RequestBody User user) {

        return iUserService.updateInformation(user);

    }

    @RequestMapping(value = "change_role.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeRole(HttpSession session, @RequestBody Map map) {

        Integer userId = Integer.valueOf(map.get("userId").toString());
        Integer role = Integer.valueOf(map.get("role").toString());


        return iUserService.changRole(userId, role);

    }


    @RequestMapping(value = "get_manager_by_attribute.do")
    @ResponseBody
    public ServerResponse getCustomerByAttribute(@RequestBody UserBo userBo) {


        Integer pageNum = userBo.getPageNum();
        Integer pageSize = userBo.getPageSize();
        User user = userBo.getUser();

        return iUserService.getManagerByAttribute(user, pageNum, pageSize);

    }

}
