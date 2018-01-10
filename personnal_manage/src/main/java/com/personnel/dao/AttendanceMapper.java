package com.personnel.dao;

import com.personnel.entity.Attendance;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
    
    List<Attendance> getAttendanceListAll();
    
    List<Attendance> getAttendanceListByKey(@Param(value="key")String key);
    
    Attendance getAttendanceByEid(Long Eid);
    
}