package com.hotel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.common.Const;
import com.hotel.common.ServerResponse;
import com.hotel.common.TokenCache;
import com.hotel.dao.OrderMapper;
import com.hotel.dao.RoomMapper;
import com.hotel.dao.UserMapper;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.pojo.User;
import com.hotel.service.IAnalyzeService;
import com.hotel.service.IUserService;
import com.hotel.util.MD5Util;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("iAnalyzeService")
public class AnalyzeServiceImpl implements IAnalyzeService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    OrderMapper orderMapper;


    @Override
    public ServerResponse getSexNum() {

        List<Order> orderList = orderMapper.getOrderList();
        if (orderList == null){
            return ServerResponse.createByErrorMessage("无此信息");
        }

        List<User> userList = new ArrayList<>();

        for (Order order : orderList){
            User user = userMapper.selectByPrimaryKey(order.getUserId());
            userList.add(user);
        }

        int man = 0;
        int woman = 0;

        for (User user : userList){
            if (user.getSex().equals("男")){
                man++;
            } else {
                woman++;
            }
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("男",man);
        map.put("女",woman);
        map.put("总计",man+woman);

        return ServerResponse.createBySuccess(map);
    }

    @Override
    public ServerResponse getOrderAnalyze() {

        Map<String,Double> map = new HashMap<>();

        List<Order> orderList = orderMapper.getOrderList();
        if (orderList == null){
            return ServerResponse.createByErrorMessage("无此信息");
        }

        map.put("orderNum", (double) orderList.size()+1);

        Double totalPayment = 0.0;

        for (Order order : orderList){
            totalPayment = totalPayment + Double.parseDouble(order.getTotalPayment().toString());
        }

        map.put("orderTotalPayment",totalPayment);


        return ServerResponse.createBySuccess(map);
    }

    @Override
    public ServerResponse getRoomAnalyze() {

        Map<Integer,Integer> roomMap = new HashMap<>();

        List<Order> orderList = orderMapper.getOrderList();
        if (orderList == null){
            return ServerResponse.createByErrorMessage("无此信息");
        }

        for (Order order : orderList){
            Room room = roomMapper.selectByPrimaryKey(order.getRoomId());
            Integer roomId = room.getId();
            if (!roomMap.containsKey(roomId)){
                roomMap.put(roomId,1);
            } else {
                roomMap.put(roomId,roomMap.get(roomId) + 1);
            }
        }

        roomMap = sortMapValue(roomMap);


        return ServerResponse.createBySuccess(roomMap);
    }




    Map sortMapValue(Map map){

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Integer,Integer> map1 = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> temp = list.get(i);
//            System.out.print(id + "  ");
            map1.put(temp.getKey(),temp.getValue());
        }

        return map1;
    }

    @Override
    public ServerResponse getAgeNum() {

        List<Order> orderList = orderMapper.getOrderList();
        if (orderList == null){
            return ServerResponse.createByErrorMessage("无此信息");
        }

        List<User> userList = new ArrayList<>();

        for (Order order : orderList){
            User user = userMapper.selectByPrimaryKey(order.getUserId());
            userList.add(user);
        }

        Map<String,Integer> map = new HashMap<>();

        map.put("小于18",0);
        map.put("18-30",0);
        map.put("30-40",0);
        map.put("40-50",0);
        map.put("50-60",0);
        map.put("大于60",0);
        System.out.println(map);

        for (User user : userList){
            if (user.getAge() < 18){
                map.put("小于18",map.get("小于18")+1);
            } else if (user.getAge() >= 18 && user.getAge() < 30){
                map.put("18-30",map.get("18-30")+1);
            } else if (user.getAge() >= 30 && user.getAge() < 40) {
                map.put("30-40",map.get("30-40")+1);
            } else if (user.getAge() >= 40 && user.getAge() < 50){
                map.put("40-50",map.get("40-50")+1);
            } else if (user.getAge() >= 50 && user.getAge() <= 60){
                map.put("50-60",map.get("50-60")+1);
            } else {
                map.put("大于60",map.get("大于60")+1);
            }
        }

        return ServerResponse.createBySuccess(map);

    }



}
















