package com.personnel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Job;
import com.personnel.service.JobService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired JobService jobService;
	
	private String jobPath = "/job/";
	
	@RequestMapping("/jobList")						//显示职务列表
	public String jobList(Model model) {
		List<Job> jobList = jobService.getJobListAll();
		int totalNumber = jobList.size();
		model.addAttribute("jobList", jobList);
		model.addAttribute("totalNumber", totalNumber);
		return  jobPath + "jobList";
	}
	
	@RequestMapping("/jobAddDisp")					//添加职务页面显示
	public String jobAddDisp() {
		return jobPath + "jobAdd"; 
	}
	
	@RequestMapping("/jobAdd")						//添加职务
	@ResponseBody
	public int jobAdd(Job record) {
		int flag = 0;
		System.out.println(record.toString());
		flag = jobService.addJob(record);
		return flag;
	}
	
	@RequestMapping("/deletejob")						//删除职务
	@ResponseBody
	public int deleteJob(Long id) {
		System.out.println(id);
		return jobService.deleteJob(id);
	}
	
	@RequestMapping("/editJobDisp")						//编辑职务页面显示
	public String editJobDisp(Long id,Model model) {
		Job job = jobService.getJobById(id);
		model.addAttribute("job",job);
		return jobPath + "jobEdit";
	}
	
	@RequestMapping("/editjob")							//修改职务
	@ResponseBody
	public int editJob(Job record) {					
		System.out.println(record.toString());
		return jobService.updateJob(record);
	}
	
	@RequestMapping("/search")							//根据关键字查询
	public String searchJobByKey(String key,Model model) {
		System.out.println("key" + key);
		List<Job> jobList = jobService.getJobListByKey(key);
		System.out.println(jobList.toString());
		int totalNumber = jobList.size();
		model.addAttribute("jobList",jobList);
		model.addAttribute("totalNumber", totalNumber);
		return jobPath + "jobList";
		
	}
}
