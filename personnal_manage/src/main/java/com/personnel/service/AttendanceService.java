package com.personnel.service;

import java.util.List;

import com.personnel.entity.Attendance;

public interface AttendanceService {

	List<Attendance> getAttendanceListAll();       /*获取全部考勤信息*/
	
	int addAttendance(Attendance record);          /*添加考勤信息*/
	
	int deleteAttendance(Long id);                  /*删除考勤信息*/
	
	Attendance getAttendanceById(Long id);         /*通过id（主键）获取考勤信息*/
	
	int updateAttendance(Attendance record);       /*修改考勤信息*/
	
	List<Attendance> getAttendanceListByKey(String key);      /*根据关键字搜索考勤信息列表*/
	
	Attendance getAttendanceByEid(Long Eid);  
}
