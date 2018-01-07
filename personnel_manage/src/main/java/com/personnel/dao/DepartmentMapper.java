package com.personnel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.personnel.entity.Department;

public interface DepartmentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Department> getDepartmentListAll();
    
    List<Department> getDepartmentListByKey(@Param(value="key")String key);
}