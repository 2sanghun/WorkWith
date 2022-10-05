package org.test.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/workwith?serverTimezone=Asia/seoul";
	String user="root";
	String pw="1234";
	
	@Test
	public void testConnection() throws ClassNotFoundException{
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url,user,pw)){
			System.out.println("DB 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
