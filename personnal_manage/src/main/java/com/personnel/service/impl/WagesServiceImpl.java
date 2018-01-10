package com.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.WagesMapper;
import com.personnel.entity.Wages;
import com.personnel.service.WagesService;

@Service
public class WagesServiceImpl implements WagesService {
	
	@Autowired
	WagesMapper wagesMapper;
	
	@Override
	public List<Wages> getWagesListAll() {
		// TODO Auto-generated method stub
		return wagesMapper.getWagesListAll();
	}

	@Override
	public int addWages(Wages record) {
		// TODO Auto-generated method stub
		return wagesMapper.insertSelective(record);
	}

	@Override
	public int deleteWages(Long id) {
		// TODO Auto-generated method stub
		return wagesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Wages getWagesById(Long id) {
		// TODO Auto-generated method stub
		return wagesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateWages(Wages record) {
		// TODO Auto-generated method stub
		return wagesMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Wages> getWagesListByKey(String key) {
		// TODO Auto-generated method stub
		return wagesMapper.getWagesListByKey(key);
	}

}
