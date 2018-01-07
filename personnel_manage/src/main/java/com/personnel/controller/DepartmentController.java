package com.personnel.controller;

import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personnel.entity.Department;
import com.personnel.service.DepartmentService;
import com.personnel.utils.Contants;

@Controller
@RequestMapping("/depart")
public class DepartmentController {
	
	@Autowired DepartmentService departmentService;
	private String departmentPath = Contants.path.DEPTMENT_PATH;
	
	@RequestMapping("/departmentList")
	public String departmentList(Model model) {
		List<Department> departmentList = departmentService.getDepartmentListAll();
		model.addAttribute("departmentList", departmentList);
		return departmentPath + "departmentList";
	}
}
