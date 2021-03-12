package com.mmall.test;

import com.hotel.common.ServerResponse;
import com.hotel.pojo.Order;
import com.hotel.pojo.Room;
import com.hotel.pojo.User;
import com.hotel.util.DateTimeUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by geely
 */




public class BigDecimalTest {

    @Test
    public void test1(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
    }







    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));
    }

    @Test
    public void test3(){
////        BigDecimal b1 = new BigDecimal("0.05");
////        BigDecimal b2 = new BigDecimal("0.01");
////        System.out.println(b1.add(b2));
//
//        String s1 = String.valueOf(1614603419);
//        String s2 = String.valueOf(1614603499);
//
//        System.out.println(s1.compareTo(s2));

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge(10);
        userList.add(user1);

        User user2 = new User();
        user2.setAge(20);
        userList.add(user2);

        User user3 = new User();
        user3.setAge(70);
        userList.add(user3);

        Map<String,Integer> map = new HashMap<>();

        map.put("小于18",0);
        map.put("18-30",0);
        map.put("30-40",0);
        map.put("40-50",0);
        map.put("50-60",0);
        map.put("大于60",0);
        System.out.println(map);


        for (User user : userList){
            System.out.println(user.getAge());
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
        System.out.println(map);

    }

    @Test
    public void test4(){
        Date eneTime = new Date();
        System.out.println(DateTimeUtil.dateToStr(eneTime));
        Integer stayDays = 1;

        long endTimeLong = eneTime.getTime();
        endTimeLong = endTimeLong + stayDays*24*60*60*1000;

        eneTime = new Date(endTimeLong);

        System.out.println(DateTimeUtil.dateToStr(eneTime));


    }

    @Test
    public void test5(){
        Map<Integer,Integer> roomMap = new HashMap<>();

        roomMap.put(1,3);
        roomMap.put(2,5);
        roomMap.put(3,10);
        roomMap.put(4,1);

//        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(roomMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> o1,
//                               Map.Entry<Integer, Integer> o2) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//
//        Map<Integer,Integer> map1 = new LinkedHashMap<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            Map.Entry<Integer, Integer> temp = list.get(i);
////            System.out.print(id + "  ");
//            map1.put(temp.getKey(),temp.getValue());
//        }
        roomMap = sortMapValue(roomMap);
        System.out.println(roomMap);



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



}
