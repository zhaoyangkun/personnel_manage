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

	@Override
	public List<Job> getJobListAll() {
		List<Job> jobList = new ArrayList<>();
		jobList = jobMapper.getJobListAll();
		return jobList;
	}
	
	@Override
	public int addJob(Job record){
		return jobMapper.insertSelective(record);
	}

	@Override
<<<<<<< HEAD
	public List<Job> getJobListByDep(Long depId) {
		return jobMapper.getJobListByDep(depId);
	}

=======
	public int deleteJob(Long id) {
		return jobMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public Job getJobById(Long id) {
		return jobMapper.selectByPrimaryKey(id);		
	}
	
	@Override
	public int updateJob(Job record) {
		return jobMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<Job> getJobListByKey(String key){
		return jobMapper.getJobListByKey(key);
	}
>>>>>>> branch 'master' of https://github.com/zhaoyangkun/personnel_manage.git
}
