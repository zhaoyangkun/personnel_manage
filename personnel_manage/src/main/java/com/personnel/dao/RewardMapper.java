package com.personnel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.personnel.entity.Reward;

public interface RewardMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Reward record);

    int insertSelective(Reward record);

    Reward selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Reward record);

    int updateByPrimaryKey(Reward record);
    
    List<Reward> getRewardListAll();

	List<Reward> getRewardListByKey(@Param(value="key")String key);
    
    
}