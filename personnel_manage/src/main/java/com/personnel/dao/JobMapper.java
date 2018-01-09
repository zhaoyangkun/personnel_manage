 package com.personnel.dao;

import com.personnel.entity.Job;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
    
    List<Job> getJobListAll();
    
    List<Job> getJobListByDep(Long depId);
}