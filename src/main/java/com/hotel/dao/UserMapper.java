package com.hotel.dao;

import com.hotel.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    int checkEmail(String username);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username")String username, @Param("question") String question, @Param("answer")String answer);

    int updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    int checkEmailByUserId(@Param("email")String email, @Param("userId")Integer userId);

    List<User> getManagerList();

    List<User> selectManagerByUsername(String username);

    int updateRole(@Param("userId") Integer userId, @Param("role") Integer role);

    List<User> getCustomerList();

    List<User> selectByAttribute(User user);

    List<User> selectManagerByAttribute(User user);

    int checkUsernameById(@Param("userId") Integer userId, @Param("username") String username);
}