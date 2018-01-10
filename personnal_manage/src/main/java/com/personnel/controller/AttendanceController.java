package com.personnel.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Attendance;
import com.personnel.service.AttendanceService;
import com.personnel.utils.Contants;

@Controller
@RequestMapping("/attendance")	
public class AttendanceController {
	
	@Autowired AttendanceService attendanceService;
	
	private String attendancePath = Contants.path.ATTENDANCE_PATH;
	
	@RequestMapping("/attendanceList")                                    /*显示考勤信息列表*/
	public String attendanceList(Model model) {
		List<Attendance> attendanceList = attendanceService.getAttendanceListAll();
		int totalNumber = attendanceList.size();
		model.addAttribute("attendanceList", attendanceList);
		model.addAttribute("totalNumber", totalNumber);
		return attendancePath + "attendanceList";
	}
	
	@RequestMapping("/attendanceAddDisp")                                 /*添加考勤信息页面显示*/
	public String attendanceAddDisp() {
		return attendancePath + "attendanceAdd";
	}

	@RequestMapping("/attendanceAdd")                                     /*添加考勤信息*/
	@ResponseBody
	public int attendanceAdd(Attendance record) {
		int flag = 0;
		System.out.println(record.toString());
		flag = attendanceService.addAttendance(record);
		return flag;
	}
	
	@RequestMapping("/deleteAttendance")                                  /*删除考勤信息*/
	@ResponseBody
	public int deleteattendance(Long id) {
		System.out.println(id);
		return attendanceService.deleteAttendance(id);
	}
	
	@RequestMapping("/editAttendanceDisp")                                /*编辑考勤信息页面显示*/
	public String editAttendanceDisp(Long id,Model model) {
		Attendance attendance = attendanceService.getAttendanceById(id);
		model.addAttribute("attendance", attendance);
		return attendancePath + "attendanceEdit";
	}
	
	@RequestMapping("/editAttendance")                                     /*编辑考勤信息*/
	@ResponseBody
	public int editAttendance(Attendance record) {
		System.out.println(record.toString());
		return attendanceService.updateAttendance(record);
	}
	
	@RequestMapping("/search")                                              /*根据关键词查询*/
	public String searchAttendanceByKey(String key,Model model) {
		System.out.println("key " + key);
		List<Attendance>attendanceList = attendanceService.getAttendanceListByKey(key);
		System.out.println(attendanceList.toString());
		int totalNumber = attendanceList.size();
		model.addAttribute("attendanceList",attendanceList);
		model.addAttribute("totalNumber", totalNumber);
		return attendancePath + "attendanceList";
	}
}
