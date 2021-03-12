package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.common.ServerResponse;
import com.hotel.dao.UserMapper;
import com.hotel.pojo.User;
import com.hotel.service.IUserManagerService;
import com.hotel.bo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserManagerService")
public class UserManagerServiceImpl implements IUserManagerService {

    @Autowired
    UserMapper userMapper;

    /**
     *     获取前台人员信息
     */
    @Override
    public ServerResponse<PageInfo> getManagerList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.getManagerList();

//        List<UserVo> userVoList = Lists.newArrayList();
//
//        for (User user : userList){
//            UserVo userVo = assembleUserVo(user);
//            userVoList.add(userVo);
//        }
        PageInfo pageResult = new PageInfo(userList);
//        pageResult.setList(userVoList);

        return ServerResponse.createBySuccess(pageResult);
    }


    /**
     * 组装userVo
     * @param user
     * @return
     */
    private UserVo assembleUserVo(User user){
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setEmail(user.getEmail());
        userVo.setPhone(user.getPhone());
        userVo.setRole(user.getRole());
        userVo.setCreateTime(user.getCreateTime());
        userVo.setUpdateTime(user.getUpdateTime());

        return userVo;

    }

    /**
     * 根据用户名查询manager
     * @param username
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> searchManager(String username, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isNotBlank(username)){
            username = new StringBuilder().append("%").append(username).append("%").toString();
        }
        List<User> userList = userMapper.selectManagerByUsername(username);

//        List<UserVo> userVoList = Lists.newArrayList();
//        for (User user : userList){
//            UserVo userVo = assembleUserVo(user);
//            userVoList.add(userVo);
//        }
        PageInfo pageResult = new PageInfo(userList);
//        pageResult.setList(userVoList);

        return ServerResponse.createBySuccess(pageResult);
    }



}



















