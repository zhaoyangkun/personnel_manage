package com.personnel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.personnel.entity.Basic;
import com.personnel.entity.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
    
    List<Work> getInfoListByPageDepJob(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="key")String key,@Param(value="depId")Long depId,@Param(value="jobId")Long jobId);
    
    List<Work> getInfoListByPageDep(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="key")String key,@Param(value="depId")Long depId);
    
    List<Work> getInfoListByPage(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="key")String key);
    
    List<Work> getWorkListAll();
    
    long getInfoCount(String key);
    
    long getInfoCountByDep(@Param(value="key")String key,@Param(value="depId")Long depId,@Param(value="jobId")Long jobId);
    
    List<Work> getInfoAll();
}