package com.example.demo.web;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ClipBoardDao;

import java.util.HashMap;

@Service
@Transactional
public class ClipBoardService {
	
	@Autowired
	private ClipBoardDao clipBoardDao;
	
	
    public HashMap<String, Object> selectClip(HashMap<String, Object> hashmap) {
        return clipBoardDao.selectClip(hashmap);
    }

    public int saveClip(HashMap<String, Object> hashmap) {
    	int resultCount = clipBoardDao.saveClip(hashmap);
    	return resultCount;
    }
    
}