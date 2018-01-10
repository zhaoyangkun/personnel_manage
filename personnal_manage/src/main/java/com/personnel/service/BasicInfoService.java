package com.personnel.service;

import java.util.List;

import com.personnel.entity.Basic;
import com.personnel.entity.Work;

public interface BasicInfoService {
	public int addBasicInfo(Basic recrod);
	
	public int deleteBasicInfo(Long id);
	
	public int updateBasicInfo(Basic record);
	
	public Basic queryBasicInfoById(Long id);
	
	public List<Basic> getBasicListByPage(Integer startPos,Integer pageSize);
	
	int getBasicCount();
	
	public List<Work> getInfoListByPage(Integer startPos,Integer pageSize,String key,Long depId,Long jobId);
	
	int getInfoCount(String key,Long depId,Long jobId);
	
	public int addWork(Work record);
	
	public int delete(Long id);
	
	public int updateWork(Work record);
	
	public List<Work> getWorkListAll();
	
	public Work getWorkById(Long id);
}
