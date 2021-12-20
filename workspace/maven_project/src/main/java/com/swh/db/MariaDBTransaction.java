package com.swh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <pre>
 * kr.co.swh.lecture.database.java
 * MariaDBTransaction.java
 *
 * 설명 :데이터베이스 트랜잭션 예제
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class MariaDBTransaction {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://dev-swh.gq:3306/k_min?serverTimezone=UTC";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatementInsert = null;
		PreparedStatement preparedStatementUpdate = null;

		String insertTableSQL = "INSERT INTO person"
				+ "(id, name) VALUES"
				+ "(?,?)";

		String updateTableSQL = "UPDATE person SET NAME = ?"
				+ "WHERE id = ?";
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");

			connection.setAutoCommit(false); // 기본값 true

			preparedStatementInsert = connection.prepareStatement(insertTableSQL);
			preparedStatementInsert.setInt(1, 301);
			preparedStatementInsert.setString(2, "돌샘");
			preparedStatementInsert.executeUpdate();

			preparedStatementUpdate = connection.prepareStatement(updateTableSQL);
			
			/*	정상처리	*/
//			preparedStatementUpdate.setString(1, "소리");
//			preparedStatementUpdate.setInt(2, 168);
			
			/*	오류
			 * 	첫번째 쿼리가 수행되지 않음	
			 * */
			preparedStatementUpdate.setString(1, "소리");
			
			
			preparedStatementUpdate.executeUpdate();
			connection.commit(); // 여기서 수행
			System.out.println("트랜잭션 정상처리");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			connection.rollback();
		} finally {
			if (preparedStatementInsert != null) preparedStatementInsert.close();
			if (preparedStatementUpdate != null) preparedStatementUpdate.close();
			if (connection != null) connection.close();
		}
		System.out.println("MariaDB 연결종료.");
	}

}