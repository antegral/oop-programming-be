package com.example.demo.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClipBoardDao {

    // 클립을 데이터베이스에서 가져옵니다.
    public HashMap<String, Object> selectClip(HashMap<String, Object> hashmap);

    // 클립을 데이터베이스에 저장합니다.
    public int saveClip(HashMap<String, Object> hashmap);

    // 데이터베이스에서 생성된 마지막 클립의 아이디를 가져옵니다.
    public int getLastId();
}