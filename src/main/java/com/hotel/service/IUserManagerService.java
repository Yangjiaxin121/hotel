package com.hotel.service;

import com.github.pagehelper.PageInfo;
import com.hotel.common.ServerResponse;

public interface IUserManagerService {

    ServerResponse<PageInfo> getManagerList(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo> searchManager(String username, Integer pageNum, Integer pageSize);
}
