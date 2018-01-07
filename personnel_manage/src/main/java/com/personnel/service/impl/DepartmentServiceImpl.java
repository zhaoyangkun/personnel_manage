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

}
