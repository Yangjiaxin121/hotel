package com.hotel.dao;

import com.hotel.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);


    int checkUsername(String username);

    Admin selectLogin(@Param("username") String username, @Param("password") String password);
}