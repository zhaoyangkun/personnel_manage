package com.personnel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.personnel.entity.Basic;

public interface BasicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Basic record);

    int insertSelective(Basic record);

    Basic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Basic record);

    int updateByPrimaryKey(Basic record);
    
    List<Basic> getBasicListByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    long getBasicCount();
}