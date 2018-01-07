package com.personnel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personnel.entity.Job;
import com.personnel.service.JobService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired JobService jobService;
	
	private String jobPath = "/job";
	
	@RequestMapping("/jobList")
	public String jobList(Model model) {
		List<Job> jobList = jobService.getJobListAll();
		model.addAttribute("jobList", jobList);
		return  jobPath + "jobList";
	}
	
}
