package com.personnel.service;

import java.util.List;

import com.personnel.entity.Wages;

public interface WagesService {
	
	List<Wages> getWagesListAll();				/*获取全部工资列表*/
	
	int addWages(Wages record);					/*添加工资信息*/
	
	int deleteWages(Long id);					/*删除员工工资*/
	
	Wages getWagesById(Long id);				/*通过id（主键）获取员工工资*/
	
	int updateWages(Wages record);				/*修改员工工资*/
	
	List<Wages> getWagesListByKey(String key);	/*根据关键字搜索员工工资列表*/

}
