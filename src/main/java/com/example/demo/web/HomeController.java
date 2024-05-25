package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.ClipRequest;

@Controller
public class HomeController {
	@Autowired
	ClipBoardService homeService;

	@RequestMapping("/")
	public ModelAndView homeUrl() {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("boardSn", "1");
		homeService.selectClip(hashMap);
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/clip/{boardSn}")
	@ResponseBody
	public Map<String, Object> GetClip(@PathVariable("boardSn") Number id) {

		HashMap<String, Object> DatabasePayload = new HashMap<String, Object>();
		DatabasePayload.put("boardSn", id);

		Map<String, Object> result = homeService.selectClip(DatabasePayload);

		return result;
	}

	@PostMapping("/clip")
	@ResponseBody
	public Map<String, Object> PostClip(@RequestBody ClipRequest req) {

		HashMap<String, Object> DatabasePayload = new HashMap<String, Object>();
		DatabasePayload.put("boardContent", req.boardContent);

		int id = homeService.saveClip(DatabasePayload);

		Map<String, Object> ResponseMap = new HashMap<String, Object>();
		if (id > 0) {
			ResponseMap.put("id", id);
			ResponseMap.put("message", "등록 성공했습니다.");
		} else {
			ResponseMap.put("message", "등록 오류입니다.");
		}

		return ResponseMap;
	}

}
