package com.personnel.dao;

import com.personnel.entity.Wages;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WagesMapper {


    int deleteByPrimaryKey(Long id);

    int insert(Wages record);

    int insertSelective(Wages record);

    Wages selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Wages record);

    int updateByPrimaryKey(Wages record);
    
    List<Wages> getWagesListAll();
    
    List<Wages> getWagesListByKey(@Param(value="key")String key);
}