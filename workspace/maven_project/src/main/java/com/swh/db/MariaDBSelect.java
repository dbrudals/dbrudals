package com.swh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 * kr.co.swh.lecture.database.java
 * MariaDBSelect.java
 *
 * 설명 :데이터베이스 검색 예제
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class MariaDBSelect {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://dev-swh.gq:3306/k_min?serverTimezone=UTC";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try{
			Class.forName(JDBC_DRIVER).newInstance();
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");
			statement = connection.createStatement();
			

			//	insert
			/*
			boolean result = statement.execute("insert into person(id, name, gender) values(030807, '진구', '남');");
//						boolean result = statement.execute(String.format("insert into a(c1,c2) values(%d, %s);", v1, v2));
			if(result) System.out.println("ResultSet 값 있다.");
			else System.out.println("업데이트 된 행이 있거나 리턴되는 값이 없는 경우");
			*/

			//	update
			//			int result = statement.executeUpdate("update a set c1 = v1;");		//	result = 업데이터된 행의 숫자
			//			if(result > 0) System.out.println("정상처리");
			//			else System.out.println("비정상처리");

			//	select
			ResultSet rs = statement.executeQuery("SELECT * FROM person;");

			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
//				long employee_contact = rs.getLong("employee_contact");
				System.out.println("id : " + id);
				System.out.println("name: " + name);
				System.out.println("gender: " + gender);
//				System.out.println("employee_contact: " + employee_contact);
				System.out.println(rs.getInt(1));	// 첫번 째 열
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
		System.out.println("MariaDB 연결종료.");
	}

}
