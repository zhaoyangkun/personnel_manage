package com.personnel.dao;

import java.util.List;

import com.personnel.entity.Transfer;

public interface TransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
    
    List<Transfer> getTransferListAll();
    
}