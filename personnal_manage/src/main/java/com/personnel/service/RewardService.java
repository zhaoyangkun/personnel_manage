package com.personnel.service;

import java.util.List;

import com.personnel.entity.Reward;

public interface RewardService {	
	List<Reward> getRewardListAll();

	int addReward(Reward record);

	int deleteReward(Long id);

	Reward getRewardById(Long id);

	int updateReward(Reward record);

	List<Reward> getRewardListByKey(String key);
}

