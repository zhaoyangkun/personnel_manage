package com.personnel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.RewardMapper;
import com.personnel.entity.Reward;
import com.personnel.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService{
	@Autowired RewardMapper rewardMapper;

	@Override
	public List<Reward> getRewardListAll() {
		List<Reward> rewardList = new ArrayList();
		rewardList = rewardMapper.getRewardListAll();
		return rewardList;
	}

	@Override
	public int addReward(Reward record) {
		return rewardMapper.insert(record);
	}

	@Override
	public int deleteReward(Long id) {
		return rewardMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Reward getRewardById(Long id) {
		return rewardMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateReward(Reward record) {
		return rewardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Reward> getRewardListByKey(String key) {
		return rewardMapper.getRewardListByKey(key);
	}
	

}
