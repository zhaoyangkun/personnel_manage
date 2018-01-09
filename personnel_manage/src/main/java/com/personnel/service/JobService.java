package com.personnel.service;

import java.util.List;

import com.personnel.entity.Job;

public interface JobService {
/*	int deleteJob(Long id);*/
	
	List<Job> getJobListAll();
	
	List<Job> getJobListByDep(Long depId);
}
