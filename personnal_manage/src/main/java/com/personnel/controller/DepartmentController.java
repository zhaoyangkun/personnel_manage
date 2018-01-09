package com.personnel.controller;

import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Department;
import com.personnel.service.DepartmentService;
import com.personnel.utils.Contants;

@Controller
@RequestMapping("/department")									
public class DepartmentController {
	
	@Autowired DepartmentService departmentService;
	
	private String departmentPath = Contants.path.DEPTMENT_PATH;
	
	@RequestMapping("/departmentList")							//显示部门列表
	public String departmentList(Model model) {
		List<Department> departmentList = departmentService.getDepartmentListAll();
		int totalNumber = departmentList.size();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("totalNumber", totalNumber);
		return departmentPath + "departmentList";
	}
	
	@RequestMapping("/departmentAddDisp")						//添加部门页面显示
	public String departmentAddDisp() {
		return departmentPath + "departmentAdd";
	}
	
	@RequestMapping("/departmentAdd")							//添加部门
	@ResponseBody
	public int departmentAdd(Department record) {
		int flag = 0;
		System.out.println(record.toString());
		flag = departmentService.addDepartment(record);
		return flag;
	}
	
	@RequestMapping("/deleteDepartment")						//删除部门
	@ResponseBody
	public int deleteDepartment(Long id) {
		System.out.println(id);
		return departmentService.deleteDepartment(id);
	}
	
	@RequestMapping("/editDepartmentDisp")						//编辑部门页面显示
	public String editDepartmentDisp(Long id,Model model) {
		Department department = departmentService.getDepartmentById(id);
		model.addAttribute("department",department);
		return departmentPath + "departmentEdit";
	}
	
	@RequestMapping("/editDepartment")							//编辑部门
	@ResponseBody
	public int editDepartment(Department record) {
		System.out.println(record.toString());
		return departmentService.updateDepartment(record);
	}
	
	@RequestMapping("/search")									//根据关键词查询
	public String searchDepartmentByKey(String key,Model model){	 
		System.out.println("key " + key);
		List<Department> departmentList = departmentService.getDepartmentListByKey(key);
		System.out.println(departmentList.toString());
		int totalNumber = departmentList.size();
		model.addAttribute("departmentList",departmentList);
		model.addAttribute("totalNumber", totalNumber);
		return departmentPath + "departmentList";
	}
	
		
}
