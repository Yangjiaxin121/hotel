package com.hotel.service.impl;

import com.hotel.common.ServerResponse;
import com.hotel.dao.AdminMapper;
import com.hotel.pojo.Admin;
import com.hotel.service.IAdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iAdminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public ServerResponse<Admin> login(String username, String password) {
        if (username == null || password == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = adminMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo 密码登陆MD5
        //String md5Password = MD5Util.MD5EncodeUtf8(password);
        Admin admin = adminMapper.selectLogin(username, password);
        if (admin == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        admin.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess("登陆成功", admin);
    }
}
