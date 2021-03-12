package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.common.TokenCache;
import com.hotel.dao.UserMapper;
import com.hotel.pojo.User;
import com.hotel.service.IUserService;
import com.hotel.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        if (username == null || password == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo 密码登陆MD5
        //String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {

        ServerResponse validResponse = checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

//        validResponse = checkValid(user.getEmail(), Const.EMAIL);
//        if (!validResponse.isSuccess()) {
//            return validResponse;
//        }

        user.setRole(Const.Role.ROLE_CUSTOMER);
        //MD5加密
        //user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }

        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> registerManager(User user) {

        ServerResponse validResponse = checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

//        validResponse = checkValid(user.getEmail(), Const.EMAIL);
//        if (!validResponse.isSuccess()) {
//            return validResponse;
//        }

        user.setRole(Const.Role.ROLE_MANAGER);
        //MD5加密
        //user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }

        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            //开始校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(str);
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
    public ServerResponse selectQuestion(String username) {

        ServerResponse validResponse = this.checkValid(Const.USERNAME, username);
        if (!validResponse.isSuccess()) {
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String question = userMapper.selectQuestionByUsername(username);
        if (StringUtils.isNotBlank(question)) {
            return ServerResponse.createBySuccess(question);
        }
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int resultCount = userMapper.checkAnswer(username, question, answer);
        if (resultCount > 0) {
            //说明问题和问题答案是这个用户的，并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }

    @Override
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)) {
            return ServerResponse.createByErrorMessage("参数错误，token需要传递");
        }

        ServerResponse validResponse = this.checkValid(Const.USERNAME, username);
        if (!validResponse.isSuccess()) {
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
        if (StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMessage("token无效或已过期");
        }

        if (StringUtils.equals(forgetToken, token)) {
            String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount = userMapper.updatePasswordByUsername(username, md5Password);
            if (rowCount > 0) {
                return ServerResponse.createBySuccessMessage("密码修改成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("token错误，请重新获取重置密码的token");
        }

        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        //防止横向越权，需要校验一下这个用户的旧密码一定要指定是这个用户，如果不指定id，结果就是true啦，count>0
        int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }

        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    @Override
    public ServerResponse<User> updateInformation(User user) {
        //username不能被更新
        //email要进行一个校验，校验新的email是否已经存在，并且存在的email如果相同的话，不能是我们当前这个用户的
        int resultCount = userMapper.checkUsernameById(user.getId(),user.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在，请更换用户名再尝试更新");
        }
//        User updateUser = new User();
//        updateUser.setId(user.getId());
//        updateUser.setEmail(user.getEmail());
//        updateUser.setPhone(user.getPhone());
//        updateUser.setQuestion(user.getQuestion());
//        updateUser.setAnswer(user.getAnswer());

        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("更新个人信息成功");
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }


    @Override
    public ServerResponse<User> getInformation(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }


    //backend
    @Override
    public ServerResponse checkAdminRole(User user) {
        if (user != null && user.getRole().intValue() == Const.Role.ROLE_ADMIN) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse checkManagerRole(User user) {
        if (user != null && user.getRole().intValue() == Const.Role.ROLE_MANAGER) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    /**
     * 根据userId删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public ServerResponse deleteUserById(Integer userId) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("userId不能为空");
        }
        int checkValue = userMapper.deleteByPrimaryKey(userId);
        if (checkValue > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("查无此人");
    }


    /**
     * 修改用户权限
     *
     * @param userId
     * @param role
     * @return
     */
    @Override
    public ServerResponse changRole(Integer userId, Integer role) {
        if (userId == null) {
            return ServerResponse.createByErrorMessage("userId不能为空");
        }
        if (role == 0 || role == 1 || role == 2) {
            int checkValue = userMapper.updateRole(userId, role);

            if (checkValue > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }

        }


        return ServerResponse.createByErrorMessage("修改失败");
    }



    /**
     * 获取所有普通用户
     * @return
     */
    @Override
    public ServerResponse getAllCustomer(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.getCustomerList();


        PageInfo pageResult = new PageInfo(userList);


        return ServerResponse.createBySuccess(pageResult);
    }


    /**
     * 根据参数搜索user
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse getUserByAttribute(User user, Integer pageNum, Integer pageSize) {
//roomName = new StringBuilder().append("%").append(roomName).append("%").toString();

        PageHelper.startPage(pageNum,pageSize);

        List<User> userList = userMapper.selectByAttribute(user);

        PageInfo pageInfo = new PageInfo(userList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse getManagerByAttribute(User user, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<User> userList = userMapper.selectManagerByAttribute(user);

        PageInfo pageInfo = new PageInfo(userList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse checkUsername(Integer userId, String username) {

        if (userId == null || username == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        int checkValue = userMapper.checkUsernameById(userId,username);
        return null;
    }


}
















