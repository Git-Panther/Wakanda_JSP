package com.kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.member.model.vo.MemberVo;

public class MemberDao {
	public MemberDao(){
		
	}
	
	public MemberVo signin(String id, String pw){
		MemberVo result = null;
		Connection conn = JDBCTemplate.getConnection(); // connection 생성
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실행할 jdbc 라이브러리 등록. 가끔씩 Build Path에서 인식을 못하는데, 이러면 lib에 넣어줘서 컴파일한다.
			stmt = conn.createStatement();

			String query = "SELECT * "
					+ "FROM MEMBER " // 주의 : 쿼리를 여러 줄에 걸쳐 쓸거면 마지막 전까지는 줄이 끝나는 곳엔 항상 뒤에 띄어쓰기 등으로 구분해줘야 한다.
					+ "WHERE USERID = '" + id + "' AND PASSWORD = '" + pw + "'"; // 문자형 비교이면 변수 앞뒤로 따옴표 붙여줘야 한다. 그리고 맨 마지막에 ;는 붙이지 않는다.
			rs = stmt.executeQuery(query); // SQL 실행하여 표 형식으로 반환
			while(rs.next()){ // hasNext() 가 아닌 next()에 주의. 참고로 로그인은 하나의 인스턴스만 검색될 것이기에 여러 개 불러올 상황은 생각하지 않는다(만일 그런 문제가 발생하면 테이블 잘못 만든거).
				result = new MemberVo();
				result.setUserid(rs.getString("USERID"));
				result.setPassword(rs.getString("PASSWORD"));
				result.setUsername(rs.getString("USERNAME"));
				result.setAddress(rs.getString("ADDRESS"));
				result.setAge(rs.getInt("AGE"));
				result.setEnrolldate(rs.getDate("ENROLLDATE"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 열었던 것들을 닫아준다. 나중에 연 것부터 닫아준다.
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return result;
	}

	public int insertMember(MemberVo m) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = JDBCTemplate.getConnection(); // connection 생성
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실행할 jdbc 라이브러리 등록. 가끔씩 Build Path에서 인식을 못하는데, 이러면 lib에 넣어줘서 컴파일한다.
			stmt = conn.createStatement();
			String query = "INSERT INTO MEMBER " // 주의 : 쿼리를 여러 줄에 걸쳐 쓸거면 마지막 전까지는 줄이 끝나는 곳엔 항상 뒤에 띄어쓰기 등으로 구분해줘야 한다.
					+ "VALUES('" + m.getUserid()
					+ "', '" + m.getPassword()
					+ "', '" + m.getUsername()
					+ "', '" + m.getGender()
					+ "', " + m.getAge()
					+ ", '" + m.getEmail()
					+ "', '" + m.getPhone()
					+ "', '" + m.getAddress()
					+ "', '" + m.getHobbies()
					+ "', " + "SYSDATE); COMMIT"; // 문자형 비교이면 변수 앞뒤로 따옴표 붙여줘야 한다. 그리고 맨 마지막에 ;는 붙이지 않는다.
			result = stmt.executeUpdate(query); // SQL 실행하여 표 형식으로 반환
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 열었던 것들을 닫아준다. 나중에 연 것부터 닫아준다.
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return result;
	}
}
