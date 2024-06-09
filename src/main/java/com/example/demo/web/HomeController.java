package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ModelAndView homeUrl() {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("boardSn", "1");
		homeService.selectClip(hashMap);
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/clip/{boardSn}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	// 클라이언트로부터 클립의 아이디를 받아서 데이터베이스에서 클립을 가져옵니다.
	public Map<String, Object> GetClip(@PathVariable("boardSn") Number id) {
		// 데이터베이스에서 클립을 가져옵니다.
		HashMap<String, Object> DatabasePayload = new HashMap<String, Object>();
		DatabasePayload.put("boardSn", id);

		// 데이터베이스에서 클립을 가져옵니다.
		Map<String, Object> result = homeService.selectClip(DatabasePayload);

		// 클라이언트에게 응답을 보냅니다.
		return result;
	}

	@PostMapping("/clip")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@ResponseBody
	// 클라이언트로부터 클립의 내용을 받아서 데이터베이스에 저장합니다.
	public Map<String, Object> PostClip(@RequestBody ClipRequest req) {

		// 클라이언트로부터 받은 데이터를 데이터베이스에 저장합니다.
		HashMap<String, Object> DatabasePayload = new HashMap<String, Object>();
		DatabasePayload.put("boardContent", req.boardContent);

		// 데이터베이스에 저장된 클립의 아이디를 가져옵니다.
		int id = homeService.saveClip(DatabasePayload);

		// 클라이언트에게 응답을 보냅니다.
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
