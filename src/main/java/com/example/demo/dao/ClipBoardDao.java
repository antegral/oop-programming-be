package com.example.demo.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClipBoardDao {

    public HashMap<String, Object> selectClip(HashMap<String, Object> hashmap);

    public int saveClip(HashMap<String, Object> hashmap);

    public int getLastId();
}