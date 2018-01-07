package com.personnel.service;

import java.util.List;

import com.personnel.entity.Department;

public interface DepartmentService {
	List<Department> getDepartmentListAll();				/*获取全部部门列表*/
	
	int addDepartment(Department record);					/*添加部门*/
	
	int deleteDepartment(Long id);							/*删除部门*/
	
	Department getDepartmentById(Long id);					/*通过id（主键）获取部门*/
	
	int updateDepartment(Department record);				/*修改部门*/
	
	List<Department> getDepartmentListByKey(String key);	/*根据关键字搜索部门列表*/
}
