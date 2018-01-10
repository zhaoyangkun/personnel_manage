package com.personnel.service;

import java.util.List;


import com.personnel.entity.Job;

public interface JobService {
	
	List<Job> getJobListAll();
<<<<<<< HEAD
	
	List<Job> getJobListByDep(Long depId);
=======

	int addJob(Job record);
	
	int deleteJob(Long id);

	Job getJobById(Long id);

	int updateJob(Job record);

	List<Job> getJobListByKey(String key);



	
	
>>>>>>> branch 'master' of https://github.com/zhaoyangkun/personnel_manage.git
}
