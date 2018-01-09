package com.personnel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.personnel.entity.User;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByPhone(String phone);
    
    List<User> getUserListAll();
    
    List<User> getUserListByKey(@Param(value="key")String key);
}