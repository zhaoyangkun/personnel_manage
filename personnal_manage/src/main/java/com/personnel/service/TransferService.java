package com.personnel.service;

import java.util.List;

import com.personnel.entity.Transfer;

public interface TransferService {
	List<Transfer> getTransferListAll();
	
	int updateTransfer(Transfer transfer);
	
	int addTransfer(Transfer transfer);
	
	Transfer getTransferById(Long id);
	
	int deleteTransfer(Long id);
}
