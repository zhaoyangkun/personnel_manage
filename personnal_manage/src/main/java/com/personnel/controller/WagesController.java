package com.personnel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Attendance;
import com.personnel.entity.Wages;
import com.personnel.service.AttendanceService;
import com.personnel.service.WagesService;
import com.personnel.utils.Contants;

@Controller
@RequestMapping("/wages")
public class WagesController {

	@Autowired
	WagesService wagesService;
	
	@Autowired AttendanceService attendanceService;
	
	private String wagesPath = Contants.path.Wages_PATH;
	
	@RequestMapping("wagesList")                                      /*显示员工工资列表*/
	public String departmentList(Model model) {
		List<Wages> wagesList = wagesService.getWagesListAll();
		int totalNumber = wagesList.size();
		model.addAttribute("wagesList", wagesList);
		model.addAttribute("totalNumber", totalNumber);
		return wagesPath + "wagesList";
	}
	
	@RequestMapping("/wagesAddDisp")						       /*添加员工工资信息*/
	public String wagesAddDisp() {
		return wagesPath + "wagesAdd";
	}
	
	@RequestMapping("/wagesAdd")							       /*添加员工工资信息*/
	@ResponseBody
	public int wagesAdd(Wages record) {
		int flag = 0;
		Long e_id = record.getEmpId();
		Attendance attendance = attendanceService.getAttendanceByEid(e_id);
		System.out.println(attendance.toString());
		int sjgz = attendance.getAttendanceDay()*100 + attendance.getVocationOvertime()*300 + attendance.getDailyOvertime()*100 - attendance.getLeaveDay()*50 + record.getGjj() + record.getYlj();
		int yfgz = attendance.getAttendanceDay()*100 + attendance.getVocationOvertime()*300 + attendance.getDailyOvertime()*100 - attendance.getLeaveDay()*50 + record.getGjj() + record.getYlj() - record.getSds();
		int basepay = attendance.getAttendanceDay()*100;
		int jbbt = attendance.getVocationOvertime()*300 + attendance.getDailyOvertime()*100;
		record.setSjgz(sjgz);
		record.setYfgz(yfgz);
		record.setBasepay(basepay);
		record.setJbbt(jbbt);
		flag = wagesService.addWages(record);
		return flag;
	}
	
	@RequestMapping("/deleteWages")						            /*删除员工工资信息*/
	@ResponseBody
	public int deleteWages(Long id) {
		System.out.println(id);
		return wagesService.deleteWages(id);
	}
	
	@RequestMapping("/editWagesDisp")						//编辑员工工资页面显示
	public String editDepartmentDisp(Long id,Model model) {
		Wages wages = wagesService.getWagesById(id);
		model.addAttribute("wages",wages);
		return wagesPath + "wagesEdit";
	}
	
	@RequestMapping("/editWages")							//编辑员工工资信息
	@ResponseBody
	public int editWages(Wages record) {
		System.out.println(record.toString());
		return wagesService.updateWages(record);
	}
	
	@RequestMapping("/search")									//根据关键词查询
	public String searchWagesByKey(String key,Model model){	 
		System.out.println("key " + key);
		List<Wages> wagesList = wagesService.getWagesListByKey(key);
		System.out.println(wagesList.toString());
		int totalNumber = wagesList.size();
		model.addAttribute("wagesList",wagesList);
		model.addAttribute("totalNumber", totalNumber);
		return wagesPath + "wagesList";
	}
}
