package com.hotel.service;

import com.github.pagehelper.PageInfo;
import com.hotel.common.ServerResponse;
import com.hotel.pojo.Manager;

public interface IManagerService {
    ServerResponse<PageInfo> getManagerList(Integer pageNum, Integer pageSize);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> registerManager(Manager manager);

    ServerResponse searchManager(String userName, Integer pageNum, Integer pageSize);

    ServerResponse getInformation(Integer userId);

    ServerResponse deleteUserById(Integer userId);

    ServerResponse updateInformation(Manager manager);

    ServerResponse changRole(Integer userId, Integer role);

    ServerResponse getManagerByAttribute(Manager manager, Integer pageNum, Integer pageSize);

    ServerResponse login(String username, String password);
}
