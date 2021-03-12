package com.hotel.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by geely
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";



    public interface Role{
        int ROLE_CUSTOMER = 2; //普通用户
        int ROLE_MANAGER = 1;//管理员
        int ROLE_ADMIN = 0;//管理员
    }

    // 空房间0/已预订10/已退订20/已续租30/用户申请退订(退订中)40/用户申请续租(续租中)50/已入住60
    public interface RoomStatus{
        int EmptyRoom = 1;
        int RESERVED = 10;
        int UNSUBSCRIBED = 20;
        int Stay = 30;
//        int UNSUBSCRIBING = 40;
//        int STAYING = 50;

        int CHECKIN = 60;
    }

    public interface PayType{
        int ONLINE_PAY = 1;
        int OFFLINE_PAYMENT = 2;
    }

    public enum ProductStatusEnum{
        ON_SALE(1,"在线");
        private String value;
        private int code;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


    public enum OrderStatusEnum{
        //CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已付款"),

        ORDER_SUCCESS(50,"订单完成");


        OrderStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum : values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("么有找到对应的枚举");
        }
    }








}
