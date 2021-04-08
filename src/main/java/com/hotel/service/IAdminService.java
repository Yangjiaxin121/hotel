package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.Admin;


public interface IAdminService {
    ServerResponse<Admin> login(String username, String password);
}
