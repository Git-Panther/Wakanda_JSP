package com.kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

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
			
			String[] hobbies = null;
			List<String> hobbylist = new LinkedList<>();
			while(rs.next()){ // hasNext() 가 아닌 next()에 주의. 참고로 로그인은 하나의 인스턴스만 검색될 것이기에 여러 개 불러올 상황은 생각하지 않는다(만일 그런 문제가 발생하면 테이블 잘못 만든거).
				result = new MemberVo();
				result.setUserid(rs.getString("USERID"));
				result.setPassword(rs.getString("PASSWORD"));
				result.setUsername(rs.getString("USERNAME"));
				result.setGender(rs.getString("GENDER").charAt(0));
				result.setAge(rs.getInt("AGE"));
				result.setPhone(rs.getString("PHONE"));
				result.setEmail(rs.getString("EMAIL"));
				result.setAddress(rs.getString("ADDRESS"));
				hobbies = rs.getString("HOBBY").split(", "); // 스플릿하여 분해
				for(String hobby : hobbies){ // 리스트에 저장
					hobbylist.add(hobby);
				}
				result.setHobby(hobbylist); // 리스트 저장
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
					+ "', '" + m.getAllHobby()
					+ "', " + "SYSDATE)"; // 문자형 비교이면 변수 앞뒤로 따옴표 붙여줘야 한다. 그리고 맨 마지막에 ;는 붙이지 않는다.
			result = stmt.executeUpdate(query); // SQL 실행하여 표 형식으로 반환	
			if(result == 0){ // 0이라면 실패했다는 의미
				conn.rollback(); // 롤백은 이렇게
			}else{
				conn.commit(); // 커밋은 이렇게
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
		return result;
	}

	public MemberVo selectMemberById(String id) {
		// TODO Auto-generated method stub
		MemberVo result = null;
		Connection conn = JDBCTemplate.getConnection(); // connection 생성
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실행할 jdbc 라이브러리 등록. 가끔씩 Build Path에서 인식을 못하는데, 이러면 lib에 넣어줘서 컴파일한다.
			stmt = conn.createStatement();

			String query = "SELECT * "
					+ "FROM MEMBER " // 주의 : 쿼리를 여러 줄에 걸쳐 쓸거면 마지막 전까지는 줄이 끝나는 곳엔 항상 뒤에 띄어쓰기 등으로 구분해줘야 한다.
					+ "WHERE USERID = '" + id + "'"; // 문자형 비교이면 변수 앞뒤로 따옴표 붙여줘야 한다. 그리고 맨 마지막에 ;는 붙이지 않는다.
			rs = stmt.executeQuery(query); // SQL 실행하여 표 형식으로 반환
			String[] hobbies = null;
			List<String> hobbylist = new LinkedList<>();
			if(rs.next()){
			// ID로 가져오기 때문에 1개의 행만 나와야 한다.
				result = new MemberVo();
				result.setUserid(rs.getString("USERID"));
				// id 중복만을 따지므로 이하의 정보는 필요가 없다.
				
				result.setPassword(rs.getString("PASSWORD"));
				result.setUsername(rs.getString("USERNAME"));
				result.setGender(rs.getString("GENDER").charAt(0));
				result.setAge(rs.getInt("AGE"));
				result.setPhone(rs.getString("PHONE"));
				result.setAddress(rs.getString("ADDRESS"));
				result.setEmail(rs.getString("EMAIL"));
				hobbies = rs.getString("HOBBY").split(", "); // 스플릿하여 분해
				for(String hobby : hobbies){ // 리스트에 저장
					hobbylist.add(hobby);
				}
				result.setHobby(hobbylist); // 리스트 저장
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

	public int updateMember(MemberVo m) {
		// TODO Auto-generated method stub
		int result = 0;
		// DB 연결 - 쿼리 전송 객체 생성 - 쿼리 작성 - 실행 결과 저장 - 객체 닫기
		Connection conn = JDBCTemplate.getConnection(); // connection 생성
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실행할 jdbc 라이브러리 등록. 가끔씩 Build Path에서 인식을 못하는데, 이러면 lib에 넣어줘서 컴파일한다.
			stmt = conn.createStatement();
			String query = "UPDATE MEMBER SET "; // 주의 : 쿼리를 여러 줄에 걸쳐 쓸거면 마지막 전까지는 줄이 끝나는 곳엔 항상 뒤에 띄어쓰기 등으로 구분해줘야 한다.
			if(m.getPassword()!=null && m.getPassword().length() > 0) query += "PASSWORD = '" + m.getPassword() + "', ";
			// 비밀번호를 변경했을 때만 반영
			query += "USERNAME = '" + m.getUsername()
					+ "', GENDER = '" + m.getGender()
					+ "', AGE = " + m.getAge()
					+ ", EMAIL = '" + m.getEmail()
					+ "', PHONE = '" + m.getPhone()
					+ "', ADDRESS = '" + m.getAddress()
					+ "', HOBBY = '" + m.getAllHobby()
					+ "' WHERE USERID = '" + m.getUserid() + "'"; // 문자형 비교이면 변수 앞뒤로 따옴표 붙여줘야 한다. 그리고 맨 마지막에 ;는 붙이지 않는다.
			System.out.println(query);
			result = stmt.executeUpdate(query); // SQL 실행하여 표 형식으로 반환			
			if(result == 0){ // 0이라면 실패했다는 의미
				conn.rollback(); // 롤백은 이렇게
			}else{
				conn.commit(); // 커밋은 이렇게
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
		return result;
	}

	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		
		Connection conn = JDBCTemplate.getConnection(); // connection 생성
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 실행할 jdbc 라이브러리 등록. 가끔씩 Build Path에서 인식을 못하는데, 이러면 lib에 넣어줘서 컴파일한다.
			stmt = conn.createStatement();
			String query = "DELETE FROM MEMBER WHERE USERID = '" + id + "'";
			result = stmt.executeUpdate(query); // SQL 실행하여 표 형식으로 반환	
			if(result == 0){ // 0이라면 실패했다는 의미
				conn.rollback(); // 롤백은 이렇게
			}else{
				conn.commit(); // 커밋은 이렇게
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
