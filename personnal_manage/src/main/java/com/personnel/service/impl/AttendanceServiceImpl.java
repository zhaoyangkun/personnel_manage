package com.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.AttendanceMapper;
import com.personnel.entity.Attendance;
import com.personnel.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceMapper attendanceMapper;

	@Override
	public List<Attendance> getAttendanceListAll() {
		// TODO Auto-generated method stub
		return attendanceMapper.getAttendanceListAll();
	}

	@Override
	public int addAttendance(Attendance record) {
		// TODO Auto-generated method stub
		return attendanceMapper.insertSelective(record);
	}

	@Override
	public int deleteAttendance(Long id) {
		// TODO Auto-generated method stub
		return attendanceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Attendance getAttendanceById(Long id) {
		// TODO Auto-generated method stub
		return attendanceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateAttendance(Attendance record) {
		// TODO Auto-generated method stub
		return attendanceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Attendance> getAttendanceListByKey(String key) {
		// TODO Auto-generated method stub
		return attendanceMapper.getAttendanceListByKey(key);
	}

	@Override
	public Attendance getAttendanceByEid(Long Eid) {
		// TODO Auto-generated method stub
		return attendanceMapper.getAttendanceByEid(Eid);
	}

}
