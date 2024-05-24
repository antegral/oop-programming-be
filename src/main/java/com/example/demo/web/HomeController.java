package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
	@Autowired
	ClipBoardService homeService;
	
	

	
	@RequestMapping("/")
	public ModelAndView homeUrl() {
		ModelAndView mv = new ModelAndView();
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("boardSn", "1");
		Map<String,Object> result = homeService.selectClip(hashMap);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/home/selectClip")
	@ResponseBody
	public Map<String,Object> selectClip(@ModelAttribute HashMap<String,Object> hashMap) {
		
		Map<String,Object> result = homeService.selectClip(hashMap);
		
		return result;
	}
	
	@RequestMapping("/home/saveClip")
	@ResponseBody
	public Map<String,Object> saveClip(@ModelAttribute HashMap<String,Object> hashMap) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		int result = homeService.saveClip(hashMap);
		
		if(result == 1) {
			resultMap.put("message","등록 성공했습니다.");
		}else {
			resultMap.put("message","등록 오류입니다.");
		}
		
		return resultMap;
	}
	
	
	
	
}
