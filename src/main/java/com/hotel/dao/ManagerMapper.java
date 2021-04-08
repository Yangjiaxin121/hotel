package com.hotel.dao;

import com.hotel.pojo.Admin;
import com.hotel.pojo.Manager;
import com.hotel.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);


    List<Manager> getManagerList();

    int checkUsername(String username);

    int checkEmail(String username);

    Manager selectManagerByUsername1(String username);

    List<Manager> selectManagerByUsername(String username);

    int checkUsernameById(@Param("id") Integer id, @Param("username") String username);

    int updateRole(@Param("userId") Integer userId, @Param("role") Integer role);

    List<Manager> selectManagerByAttribute(Manager manager);

    Manager selectLogin(@Param("username") String username, @Param("password") String password);
}