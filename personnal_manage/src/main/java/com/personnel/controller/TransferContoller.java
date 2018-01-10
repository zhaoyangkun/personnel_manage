package com.personnel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Department;
import com.personnel.entity.Job;
import com.personnel.entity.Transfer;
import com.personnel.entity.Work;
import com.personnel.service.BasicInfoService;
import com.personnel.service.DepartmentService;
import com.personnel.service.JobService;
import com.personnel.service.TransferService;

@Controller
@RequestMapping(value = "/transfer")
public class TransferContoller {
	
	@Autowired TransferService transferService;
	@Autowired DepartmentService departmentService;
	@Autowired JobService jobService;
	@Autowired BasicInfoService basicInfoService;
	
	private String transferPath = "/transfer/";
	
	@RequestMapping("/transferList")
	public String transferList(Model model) {
		int totalNumber;
		List<Transfer> transferList = transferService.getTransferListAll();
		List<Department> departmentList = departmentService.getDepartmentListAll();
		List<Job> jobList = jobService.getJobListAll();
		totalNumber = transferList.size();
		model.addAttribute("transferList", transferList);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("jobList", jobList);
		model.addAttribute("totalNumber", totalNumber);
		return transferPath + "transferList";
	}
	
	@RequestMapping("/AddTransferDisp")
	public String AddTransferDisp(Model model) {
		List<Department> departmentList = departmentService.getDepartmentListAll();
		List<Work> workList = basicInfoService.getWorkListAll();
		List<Job> jobList = jobService.getJobListAll();
		model.addAttribute("jobList", jobList);
		model.addAttribute("workList", workList);
		model.addAttribute("departmentList", departmentList);
		return transferPath + "transferAdd";
	}
	
	@RequestMapping("/AddTransfer")
	@ResponseBody
	public int AddTransfer(Transfer transfer) {
		int flag = 0;
		Work work = basicInfoService.getWorkById(transfer.getEmpId());
		work.setDepId(transfer.getLaterDepId());
		work.setDepJob(transfer.getLaterJobId());
		transfer.setName(work.getName());
		if(basicInfoService.updateWork(work) == 1 && transferService.addTransfer(transfer) == 1) {
			flag = 1;
		}
		return flag;
	}
	
	@RequestMapping("/editTransferDisp")
	public String editTransferDisp(Model model,Long id) {
		Transfer transfer = transferService.getTransferById(id);
		List<Department> departmentList = departmentService.getDepartmentListAll();
		List<Work> workList = basicInfoService.getWorkListAll();
		List<Job> jobList = jobService.getJobListAll();
		model.addAttribute("jobList", jobList);
		model.addAttribute("workList", workList);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("transfer", transfer);
		return transferPath + "transferEdit";
	}
	
	@RequestMapping("/editTransfer")
	@ResponseBody
	public int editTransfer(Transfer transfer) {
		int flag = 0;
		Work work = basicInfoService.getWorkById(transfer.getEmpId());
		work.setDepId(transfer.getLaterDepId());
		work.setDepJob(transfer.getLaterJobId());
		transfer.setName(work.getName());
		if(basicInfoService.updateWork(work) == 1 && transferService.updateTransfer(transfer) == 1) {
			flag = 1;
		}
		return flag;
	}
	
	@RequestMapping("/deleteTransfer")
	@ResponseBody
	public int deleteTransfer(Long id) {
		return transferService.deleteTransfer(id);
	}
	
}
