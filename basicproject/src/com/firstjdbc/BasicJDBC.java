package com.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BasicJDBC {

	public static void main(String[] args) {
//		JDBC활용 객체는 반드시 반환을 해야하기 떄문에
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs =null;
		//conn, stmt, rs exception 처리를 해줘야함, try안에 선언됨. > 정상적으로 반환할 수 없음.
		//try 문 외부에서 지역변수로 선언을 해줘야함. 지역변수는 반드시 초기화를 해줘야하기 떄문에 null을 넣음
		
//   properties파일을 따로 만들자..그냥
		
//					DATABASE연결하기
		
//		1. Class.forName()메소드를 이용해서 jdbc 드라이버를 등록한다.
//		Oracle 기준으로 > "oracle.jdbc.driver.OracleDriver"
		
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
						System.out.println("드라이버 등록 성공");
				
				
//		2. DataBase연결을 위한 Connection 객체를 생성하기
//		DriverManager객체의 getConnection()메소드를 이용해서 Connection을 생성
//		getConnection()메소드 매개변수 >> 총 3 개의 문자열 매개변수를 가짐

//		1 : DB 접속 주소 > "jdbc:oracle:thin:@db서버ip주소:DB포트번호:db의 SID"
//					eg) 내 환경에서는 "jdbc:oracle:thin:@주소.주소.org:포트:xe"
				
//		2 : 사용자 계정명 > 문자열로 계정명 작성 
//					eg) "st"
				
//		3 : 사용자 비밀번호 > 문자열로 비밀번호작성
//					eg) "st"
			
					 conn = DriverManager.getConnection("jdbc:oracle:thin:@rclass.iptime.org:8877:xe", 
																	"student_sh", "student");
					
						System.out.println("DB접속 성공");
//		3. SQL문 실행할 객체를 생성한다. Connection객체를 이용해서 
//		Statement객체
//		Connection객체의 createStatement() 메소드를 이용해서 생성
					 stmt = conn.createStatement();
						System.out.println("statement 생성 완료");
						
//		4. 실행할 sql문 작성 > 문자열로
//		sqlDeveloper에서 사용한 구문을 사용하면 됨 (select, insert, update, delete) > 여기에서는 DDL을 쓸 이유가... 딱히...
//		구문을 작성할 때, 반드시 ';'는 제외한다. 
						
					String sql = "SELECT * FROM MEMBER";
					
//		5. 작성된 sql문을 실행 > Statement.executeQuery() || executeUpdate()메소드를 이용
//		executeQuery( 실행할 구문 ) : SELECT문을 실행할 때 사용하고  > return type : ResultSet
//		executeUpdate( 실행할 구문 ) : insert/delete/update를 실행 할 때 사용, > return type : int
					
					 rs = stmt.executeQuery(sql);  //SQL실행 메소드
						System.out.println("SQL문 실행");
						
//		6. 결과 확인하기!
//		SELECT문의 실행 결과는 ResultSet객체에 테이블 형식의 데이터가 저장되어있다.
//		resultset객체의 1행씩 데이터를 가져와야함
//		ResultSet.next() > 결과로 가져온 테이블 row를 한 개씩 지칭함. (스택으로 구성되어있음) > 한 개 row를 지정
//		컬럼에 있는 데이터를 가져오려면 > getString || getInt || getDate || getDouble( 문자열로 컬럼명을 넣는다 )메소드를 이용해야한다.

//		자동으로 char/varchar2 > String ||  Number는 (정수 > int) / (실수 > double) || Date는 java.sql.Date로 변환 
						
						
						while(rs.next()/*1번 row를 지정한다.*/) { //rs.next의 결과는 boolean
						
								System.out.print(rs.getString("member_id")+" ");  //매개변수의 컬럼 명은 대소문자 구분하지 않는다. 
								
								System.out.print(rs.getString("member_pwd")+" ");
								
								System.out.print(rs.getString("member_name")+" ");
								
								System.out.println(rs.getInt("age"));
							
						}
					
						// insert실행하기
						// 컬럼에 들어갈 값을 작성할 때 리터럴 표시를 정확하게 해줘야함
						// 문자열은 '', 숫자는 그냥 , sysdate || '93/07/10' 이렇게
//						실제 sql
						sql = "Insert into member values('sang123', 'sang123', '김상현','M', 40,  'sang@sang.com', '27114160', '서울시 구로구', '독서, 운동', sysdate )";
						
					
						int result = stmt.executeUpdate(sql);
							System.out.println(result);
							System.out.println();
//							
							
						sql = "Insert into member values('ho123', 'ho123', '양호준','M', 40,  'ho@ho.com', '27114160', '서울시 구로구', '독서, 운동', sysdate )";
							
						 result = stmt.executeUpdate(sql);
							
							//제약조건 똑같이 됨
						
						//또 오토커밋됨... > insert , update, delete 트랜젝션 처리를 해줘야함
						 
//		 7. 생성된 객체 닫기
//		 connection, statement, resultset객체는 입출력하는 것으로 반드시 반환해줘야함 >> close()메소드로
//		 반환하는 순서는 생성의 역순으로
//		 resultset.close() > statsment.close() > connection.close()
						 
		 
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
						if(rs!= null && !rs.isClosed()) {
							
							rs.close();
						}
						
						if(stmt!=null && !stmt.isClosed()) {
							
							stmt.close();
						}
						
						if(conn!=null && !conn.isClosed()) {
							
							conn.close();
						}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
			
	

			
			
			
	}

}
