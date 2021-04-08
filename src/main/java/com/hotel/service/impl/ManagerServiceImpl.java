package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.bo.UserVo;
import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.dao.ManagerMapper;
import com.hotel.dao.UserMapper;
import com.hotel.pojo.Manager;
import com.hotel.pojo.User;
import com.hotel.service.IManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iManagerService")
public class ManagerServiceImpl implements IManagerService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    ManagerMapper managerMapper;

    /**
     *     获取前台人员信息
     */
    @Override
    public ServerResponse<PageInfo> getManagerList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        //List<User> userList = userMapper.getManagerList();
        List<Manager> userList = managerMapper.getManagerList();
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

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            //开始校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = managerMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int resultCount = managerMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名Email已存在");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> registerManager(Manager manager) {

        ServerResponse validResponse = checkValid(manager.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

//        validResponse = checkValid(user.getEmail(), Const.EMAIL);
//        if (!validResponse.isSuccess()) {
//            return validResponse;
//        }

        manager.setRole(Const.Role.ROLE_MANAGER);
        //MD5加密
        //user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount = managerMapper.insert(manager);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }

        return ServerResponse.createBySuccessMessage("注册成功");
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
        if (StringUtils.isBlank(username)){
            return ServerResponse.createByErrorMessage("username不能为空");
        }
        List<Manager> userList = managerMapper.selectManagerByUsername(username);

//        List<UserVo> userVoList = Lists.newArrayList();
//        for (User user : userList){
//            UserVo userVo = assembleUserVo(user);
//            userVoList.add(userVo);
//        }
        PageInfo pageResult = new PageInfo(userList);
//        pageResult.setList(userVoList);

        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse getInformation(Integer userId) {
        Manager manager = managerMapper.selectByPrimaryKey(userId);
        if (manager == null) {
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        //user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(manager);
    }

    @Override
    public ServerResponse deleteUserById(Integer userId) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("userId不能为空");
        }
        int checkValue = managerMapper.deleteByPrimaryKey(userId);
        if (checkValue > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("查无此人");
    }

    @Override
    public ServerResponse updateInformation(Manager manager) {
        //username不能被更新
        //email要进行一个校验，校验新的email是否已经存在，并且存在的email如果相同的话，不能是我们当前这个用户的
        int resultCount = managerMapper.checkUsernameById(manager.getId(),manager.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在，请更换用户名再尝试更新");
        }
//        User updateUser = new User();
//        updateUser.setId(user.getId());
//        updateUser.setEmail(user.getEmail());
//        updateUser.setPhone(user.getPhone());
//        updateUser.setQuestion(user.getQuestion());
//        updateUser.setAnswer(user.getAnswer());

        int updateCount = managerMapper.updateByPrimaryKeySelective(manager);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("更新个人信息成功");
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }


    @Override
    public ServerResponse changRole(Integer userId, Integer role) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("userId不能为空");
        }
        if (role == 0 || role == 1 || role == 2) {
            int checkValue = managerMapper.updateRole(userId, role);

            if (checkValue > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }

        }


        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse getManagerByAttribute(Manager manager, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Manager> userList = managerMapper.selectManagerByAttribute(manager);

        PageInfo pageInfo = new PageInfo(userList);

        return ServerResponse.createBySuccess(pageInfo);
    }


    @Override
    public ServerResponse login(String username, String password) {
        if (username == null || password == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = managerMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo 密码登陆MD5
        //String md5Password = MD5Util.MD5EncodeUtf8(password);
        Manager manager = managerMapper.selectLogin(username, password);
        if (manager == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        manager.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess("登陆成功", manager);
    }




}
