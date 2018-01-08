package com.personnel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personnel.entity.Reward;
import com.personnel.service.RewardService;

@Controller
@RequestMapping("/reward")
public class RewardController {
	@Autowired RewardService rewardService;
	
	private String rewardPath ="/reward/";
	
	@RequestMapping("/rewardList")					//显示奖惩记录
	public String rewardList(Model model) {
		List<Reward> rewardList = rewardService.getRewardListAll();
		int totalNumber = rewardList.size();
		model.addAttribute("rewardList", rewardList);
		model.addAttribute("totalNumber", totalNumber);
		return rewardPath + "rewardList";
	}
	
	@RequestMapping("/rewardAddDisp")				//添加奖惩记录页面显示
	public String rewardAddDisp() {
		return rewardPath + "rewardAdd";
	}
	
	@RequestMapping("/rewardAdd")					//添加奖惩记录
	@ResponseBody
	public int rewardAdd(Reward record) {
		int flag = 0 ;
		System.out.println(record.toString());
		flag = rewardService.addReward(record);
		return flag;
	}
	
	@RequestMapping("/deleteReward")				//删除奖惩记录
	@ResponseBody
	public int deleteReward(Long id) {
		System.out.println(id);
		return rewardService.deleteReward(id);
	}
	
	@RequestMapping("/editRewardDisp")				//编辑奖惩记录页面显示
	public String editRewardDisp(Long id,Model model) {
		Reward reward = rewardService.getRewardById(id);
		model.addAttribute("reward", reward);
		return rewardPath + "rewardEdit" ;
	}
	
	@RequestMapping("/editReward")					//编辑奖惩记录
	@ResponseBody
	public int eiitReward(Reward record) {
		System.out.println(record);
		return rewardService.updateReward(record);
	}
	
	@RequestMapping("/search")						//根据关键字查询
	public String searchReward(String key,Model model) {
		System.out.println("key"+ key);
		List<Reward> rewardList = rewardService.getRewardListByKey(key);
		System.out.println(rewardList.toString());
		int totalNumber = rewardList.size();
		model.addAttribute("rewardList", rewardList);
		model.addAttribute("totalNumber", totalNumber);
		return rewardPath + "rewardList";
	}
}
