package com.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Util;
import com.personnel.dao.BasicMapper;
import com.personnel.dao.WorkMapper;
import com.personnel.entity.Basic;
import com.personnel.entity.Work;
import com.personnel.service.BasicInfoService;
import com.personnel.utils.Page;
import com.personnel.utils.Utils;

@Service
public class BasicInfoServiceImpl implements BasicInfoService {
	
	@Autowired
	BasicMapper basicMapper;
	@Autowired
	WorkMapper workMapper;

	@Override
	public int addBasicInfo(Basic recrod) {
		return basicMapper.insertSelective(recrod);
	}

	@Override
	public int deleteBasicInfo(Long id) {
		return basicMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateBasicInfo(Basic record) {
		return basicMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Basic queryBasicInfoById(Long id) {
		return basicMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Basic> getBasicListByPage(Integer startPos,Integer pageSize) {
		return basicMapper.getBasicListByPage(startPos,pageSize);
	}

	@Override
	public int getBasicCount() {
		return (int)basicMapper.getBasicCount();
	}

	@Override
	public List<Work> getInfoListByPage(Integer startPos,Integer pageSize,String key,Long depId,Long jobId) {
		key = "%" + key + "%";
		if(depId==null && jobId ==null)
			return workMapper.getInfoListByPage(startPos, pageSize,key);
		if(depId!=null && jobId ==null)
			return workMapper.getInfoListByPageDep(startPos, pageSize,key,depId);
		else
			return workMapper.getInfoListByPageDepJob(startPos, pageSize, key, depId, jobId);
	}

	@Override
	public int getInfoCount(String key,Long depId,Long jobId) {
		key = "%" + key + "%";
		if(depId == null)
			return (int) workMapper.getInfoCount(key);
		else
			return (int) workMapper.getInfoCountByDep(key,depId,jobId);
	}

	@Override
	public int addWork(Work record) {
		return workMapper.insertSelective(record);
	}
	
	@Override
	public int delete(Long id) {
		return workMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int updateWork(Work record) {
		return workMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Work> getWorkListAll() {
		return workMapper.getWorkListAll();
	}

	@Override
	public Work getWorkById(Long id) {
		return workMapper.selectByPrimaryKey(id);
	}
}
