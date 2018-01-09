package com.personnel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.JobMapper;
import com.personnel.entity.Job;
import com.personnel.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired JobMapper jobMapper;
	
/*	@Override
	public int deleteJob(Long id) {
		return 0;
	}*/

	@Override
	public List<Job> getJobListAll() {
		List<Job> jobList = new ArrayList<>();
		jobList = jobMapper.getJobListAll();
		return jobList;
	}

}
