package com.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.DepartmentMapper;
import com.personnel.entity.Department;
import com.personnel.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentMapper departmentMapper;

	@Override
	public List<Department> getDepartmentListAll() {
		return departmentMapper.getDepartmentListAll();
	}

	@Override
	public int addDepartment(Department record) {
		return departmentMapper.insertSelective(record);
	}

	@Override
	public int deleteDepartment(Long id) {
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateDepartment(Department record) {
		return departmentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Department> getDepartmentListByKey(String key) {
		return departmentMapper.getDepartmentListByKey(key);
	}

}
