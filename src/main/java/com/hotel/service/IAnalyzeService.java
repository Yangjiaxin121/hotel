package com.hotel.service;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.User;

public interface IAnalyzeService {

    ServerResponse getSexNum();

    ServerResponse getOrderAnalyze();

    ServerResponse getRoomAnalyze();

    ServerResponse getAgeNum();
}
