package com.aia.mm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRestApiApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	private SqlSessionTemplate sessionTemplate;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println(dataSource);
		Connection conn = dataSource.getConnection();
		System.out.println("check HikariCP"+dataSource);
	}

	
	@Test
	public void testSqlSessionFactory() {
		System.out.println("check SqlSessionFactory"+sessionFactory);
	}
	
	@Test
	public void testSqlSessionTemplate() {
		System.out.println("check SqlSessionTemplate"+sessionTemplate);
	}
	
	
}
