package com.example.demo.web;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

@Configuration
public class MybatisConfig {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/**/*.xml"));
            return sessionFactory.getObject();
        } catch (IOException e) {
            logger.error("Error creating SqlSessionFactory: ", e);
            throw new RuntimeException("Failed to create SqlSessionFactory", e);
        } catch (Exception e) {
            logger.error("Error creating SqlSessionFactory: ", e);
            throw new RuntimeException("Failed to create SqlSessionFactory", e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}