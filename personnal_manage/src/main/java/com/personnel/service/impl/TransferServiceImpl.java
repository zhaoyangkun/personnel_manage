package com.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personnel.dao.TransferMapper;
import com.personnel.entity.Transfer;
import com.personnel.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {
	
	@Autowired TransferMapper transferMapper;
	
	@Override
	public List<Transfer> getTransferListAll() {
		return transferMapper.getTransferListAll();
	}

	@Override
	public int updateTransfer(Transfer transfer) {
		return transferMapper.updateByPrimaryKeySelective(transfer);
	}

	@Override
	public int addTransfer(Transfer transfer) {
		return transferMapper.insertSelective(transfer);
	}

	@Override
	public Transfer getTransferById(Long id) {
		return transferMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteTransfer(Long id) {
		return transferMapper.deleteByPrimaryKey(id);
	}
	
}
