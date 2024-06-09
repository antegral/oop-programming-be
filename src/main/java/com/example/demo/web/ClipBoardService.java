package com.example.demo.web;

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

    // 클립을 데이터베이스에서 가져옵니다.
    public HashMap<String, Object> selectClip(HashMap<String, Object> hashmap) {
        return clipBoardDao.selectClip(hashmap); // 가져온 클립을 반환합니다.
    }

    // 클립을 데이터베이스에 저장합니다.
    public int saveClip(HashMap<String, Object> hashmap) {
        // 데이터베이스에 클립을 저장합니다.
        int cnt = clipBoardDao.saveClip(hashmap);
        if (cnt != 1) {
            return -1;
        }

        // 데이터베이스에 저장된 클립의 아이디를 가져옵니다.
        int id = clipBoardDao.getLastId();
        return id; // 저장된 클립의 아이디를 반환합니다.
    }

}