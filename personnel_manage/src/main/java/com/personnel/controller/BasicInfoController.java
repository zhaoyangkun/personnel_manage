package com.personnel.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.resource.spi.work.WorkManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personnel.dao.WorkMapper;
import com.personnel.entity.Basic;
import com.personnel.entity.Department;
import com.personnel.entity.Job;
import com.personnel.entity.Work;
import com.personnel.service.BasicInfoService;
import com.personnel.service.DepartmentService;
import com.personnel.service.JobService;
import com.personnel.utils.Page;

@Controller
@RequestMapping("/basicInfo")
public class BasicInfoController {
	
	@Autowired BasicInfoService basicInfoService;
	@Autowired DepartmentService departmentService;
	@Autowired JobService jobService;
	
	@RequestMapping("/showBasic")
	public String showBasic(HttpServletRequest request) {
		String pageNow = request.getParameter("pageNow"); 
		Page page = null;
		List<Basic> list = new ArrayList();
		int count = basicInfoService.getBasicCount();
		if(pageNow!=null) {
			page = new Page(count, Integer.parseInt(pageNow));  
			list = basicInfoService.getBasicListByPage(page.getStartPos(), page.getPageSize());
		}else {
			page = new Page(count, 1); 
			list = basicInfoService.getBasicListByPage(page.getStartPos(), page.getPageSize());
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "info/basiclist";
	}
	
	@RequestMapping("/showInfo")
	public String showInfo(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageNow = request.getParameter("pageNow");
		String key = request.getParameter("key");
		String depIdS = request.getParameter("depId");
		Long depId = null;
		String jobIdS = request.getParameter("jobId");
		Long jobId = null;
		if(jobIdS!=null && jobIdS!="") {
			jobId = Long.valueOf(jobIdS);
			request.setAttribute("jobId", jobId);
		}
		if(depIdS!=null && depIdS!="") {
			depId = Long.valueOf(depIdS);
			List<Job> listjp = jobService.getJobListByDep(depId);
			request.setAttribute("listjp", listjp);
		}
		System.out.println("pageNow"+pageNow+"     key:"+key+ "   depId"+depId+ "  jobId="+jobId);
		if(key == null)
			key = "";
		Page page = null;
		List<Work> list = new ArrayList();
		int count = basicInfoService.getInfoCount(key,depId);
		if(pageNow!=null) {
			page = new Page(count, Integer.parseInt(pageNow));  
			list = basicInfoService.getInfoListByPage(page.getStartPos(), page.getPageSize(),key,depId,jobId);
			System.out.println("list"+list.size());
		}else {
			page = new Page(count, 1); 
			list = basicInfoService.getInfoListByPage(page.getStartPos(), page.getPageSize(),key,depId,jobId);
		}
		List<Department> listd = departmentService.getDepartmentListAll();
		List<Job> listj = jobService.getJobListAll();
		request.setAttribute("list", list);
		request.setAttribute("listd", listd);
		request.setAttribute("listj", listj);
		request.setAttribute("page", page);
		request.setAttribute("key", key);
		request.setAttribute("depId", depId);
		return "info/worklist";
	}
	
	@RequestMapping("/addInfoDisp")
	public String addInfoDisp() {
		return "info/addWork";
	}
	
	@RequestMapping("/addInfo")
	public int addInfo(Work record) {
		return basicInfoService.addWork(record);
	}
	
}
