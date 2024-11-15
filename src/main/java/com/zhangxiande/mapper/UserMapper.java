package com.zhangxiande.mapper;

import com.zhangxiande.pojo.User;

import java.util.List;

public interface UserMapper {
    User findById(int uid);
    User findByName(String uname);
    Boolean insertUser(User user);
    Boolean updateUserByID(User user);
    void deleteUserByID(int i);
    List<User> findByNameAndAge(User user);
}
