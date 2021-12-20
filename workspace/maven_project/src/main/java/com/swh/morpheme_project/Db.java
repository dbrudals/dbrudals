package com.swh.morpheme_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://dev-swh.gq:3306/market?serverTimezone=UTC";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";


	public String db(){
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER).newInstance();
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			//			System.out.println("MariaDB 연결.");
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT contents FROM stock_news LIMIT 1;");

			if(rs.next()){
				return rs.getString("contents");
				/*
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
//				long employee_contact = rs.getLong("employee_contact");
				System.out.println("id : " + id);
				System.out.println("name: " + name);
				System.out.println("gender: " + gender);
//				System.out.println("employee_contact: " + employee_contact);
				System.out.println(rs.getInt(1));	// 첫번 째 열
				 */
			}
			rs.close(); 
		}catch(SQLException se1){
			se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			}catch(SQLException se2){
			}
		}

//		System.out.println("MariaDB 연결종료.");
		return null;
	}
}
