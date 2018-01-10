package com.personnel.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.dao.WorkMapper;
import com.personnel.entity.Basic;
import com.personnel.entity.Department;
import com.personnel.entity.Job;
import com.personnel.entity.Work;
import com.personnel.service.BasicInfoService;
import com.personnel.service.DepartmentService;
import com.personnel.service.JobService;
import com.personnel.utils.Page;

@Controller
@RequestMapping("/basicInfo")
public class BasicInfoController {
	
	@Autowired BasicInfoService basicInfoService;
	@Autowired DepartmentService departmentService;
	@Autowired JobService jobService;
	@Autowired WorkMapper workMapper;
	
	@RequestMapping("/showBasic")
	public String showBasic(HttpServletRequest request) {
		String pageNow = request.getParameter("pageNow"); 
		Page page = null;
		List<Basic> list = new ArrayList();
		int count = basicInfoService.getBasicCount();
		if(pageNow!=null) {
			page = new Page(count, Integer.parseInt(pageNow));  
			list = basicInfoService.getBasicListByPage(page.getStartPos(), page.getPageSize());
		}else {
			page = new Page(count, 1); 
			list = basicInfoService.getBasicListByPage(page.getStartPos(), page.getPageSize());
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "info/basiclist";
	}
	
	@RequestMapping("/showInfo")
	public String showInfo(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageNow = request.getParameter("pageNow");
		String key = request.getParameter("key");
		String depIdS = request.getParameter("depId");
		Long depId = null;
		String jobIdS = request.getParameter("jobId");
		Long jobId = null;
		if(jobIdS!=null && jobIdS!="") {
			jobId = Long.valueOf(jobIdS);
			request.setAttribute("jobId", jobId);
		}
		if(depIdS!=null && depIdS!="") {
			depId = Long.valueOf(depIdS);
			List<Job> listjp = jobService.getJobListByDep(depId);
			request.setAttribute("listjp", listjp);
		}
		System.out.println("pageNow"+pageNow+"     key:"+key+ "   depId"+depId+ "  jobId="+jobId);
		if(key == null)
			key = "";
		Page page = null;
		List<Work> list = new ArrayList();
		int count = basicInfoService.getInfoCount(key,depId,jobId);
		if(pageNow!=null) {
			page = new Page(count, Integer.parseInt(pageNow));  
			list = basicInfoService.getInfoListByPage(page.getStartPos(), page.getPageSize(),key,depId,jobId);
			System.out.println("list"+list);
		}else {
			page = new Page(count, 1); 
			list = basicInfoService.getInfoListByPage(page.getStartPos(), page.getPageSize(),key,depId,jobId);
		}
		List<Department> listd = departmentService.getDepartmentListAll();
		List<Job> listj = jobService.getJobListAll();
		request.setAttribute("list", list);
		request.setAttribute("listd", listd);
		request.setAttribute("listj", listj);
		request.setAttribute("page", page);
		request.setAttribute("key", key);
		request.setAttribute("depId", depId);
		return "info/worklist";
	}
	
	@RequestMapping("/addInfoDisp")
	public String addInfoDisp(HttpServletRequest request) {
		List<Department> listd = departmentService.getDepartmentListAll();
		request.setAttribute("listd", listd);
		String depId = request.getParameter("depId");
		if(depId!=null && depId!="") {
			List<Job> listj = jobService.getJobListByDep(Long.valueOf(depId));
			request.setAttribute("listj", listj);
			request.setAttribute("depId", depId);
		}
		return "info/addWork";
	}
	
	@RequestMapping("/addInfo")
	@ResponseBody
	public int addInfo(Work record) {
		int flag = basicInfoService.addWork(record);
		return flag;
	}
	
	@RequestMapping("/deleteInfo")
	@ResponseBody
	public int deleteInfo(Long id) {
		return basicInfoService.delete(id);
	}
	
	@RequestMapping("/editInfoDisp")
	public String editInfoDisp(HttpServletRequest request,Long id) {
		Work work = workMapper.selectByPrimaryKey(id);
		List<Department> listd = departmentService.getDepartmentListAll();
		List<Job> listj = jobService.getJobListAll();
		request.setAttribute("listd", listd);
		request.setAttribute("work", work);
		request.setAttribute("listj", listj);
		return "info/editWork";
	}
	
	@RequestMapping("/editInfo")
	@ResponseBody
	public int editInfo(Work record) {
		return basicInfoService.updateWork(record);
	}
	
	
	@RequestMapping("/exportExcel")
	@ResponseBody
	public int exportExcel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("导出excel");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/x-download");

		HSSFWorkbook wb = new HSSFWorkbook();//创建WebBook，对应一个excel文件
		HSSFSheet sheet = wb.createSheet("员工信息表");//添加一个sheet
		HSSFRow row = sheet.createRow((int) 0);//添加0行
		HSSFCellStyle style = wb.createCellStyle();//创建单元格，设置表头居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建居中格式
		
		@SuppressWarnings("deprecation")
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("id");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 2);
		cell.setCellValue("部门号");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("职位号");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 4);
		cell.setCellValue("备注");
		cell.setCellStyle(style);
		
		List<Work> list = workMapper.getInfoAll();
		List<Department> listd = departmentService.getDepartmentListAll();
		List<Job> listj = jobService.getJobListAll();
		for(int i=0;i<list.size();i++) {
			row = sheet.createRow((int) i + 1);
			Work work = list.get(i);
			row.createCell((short) 0).setCellValue(work.getId());
			row.createCell((short) 1).setCellValue(work.getName());
			for (Department d : listd) {
				if(d.getId() == work.getDepId())
					row.createCell((short) 2).setCellValue(d.getName());
			}
			for (Job job : listj) {
				if(work.getDepJob() == job.getId())
					row.createCell((short) 3).setCellValue(job.getName());
			}
			row.createCell((short) 4).setCellValue(work.getRemark());
		}
		try {
			OutputStream out = resp.getOutputStream();
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
