package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> registerManager(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);


    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    //backend
    ServerResponse checkAdminRole(User user);

    ServerResponse checkManagerRole(User user);


    ServerResponse deleteUserById(Integer userId);

    ServerResponse changRole(Integer userId, Integer role);

    ServerResponse getAllCustomer(Integer pageNum, Integer pageSize);

    ServerResponse getUserByAttribute(User user, Integer pageNum, Integer pageSize);

    ServerResponse getManagerByAttribute(User user, Integer pageNum, Integer pageSize);


    ServerResponse checkUsername(Integer userId, String username);
}
