package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.dao") // MyBatis Mapper를 스캔합니다.
public class ClipBoardProjectApplication {

	public static void main(String[] args) {
		// 스프링 부트 애플리케이션을 실행합니다.
		// ClipBoardProjectApplication 클래스는 스프링 부트 애플리케이션의 Entry Point로 지정됩니다.
		SpringApplication.run(ClipBoardProjectApplication.class, args);
	}

}
