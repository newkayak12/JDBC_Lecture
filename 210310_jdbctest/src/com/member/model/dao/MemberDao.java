package com.member.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.member.model.vo.Member;

public class MemberDao {
	List<Member> memList = new ArrayList<>();
	Map<String, String> prop = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	public void makeProp() {
		Properties p = new Properties();
	}
	
	private void proper() {
		File f = new File("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_student_sh.properties");
		if(f.exists()) {
			try( FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);){
				
				prop = (Map<String, String>)ois.readObject();
				
				
			} catch (IOException | ClassNotFoundException e	) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private Statement querySet() throws ClassNotFoundException, SQLException{
		
		proper();
			
			
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(prop.get("ip"),prop.get("id"), prop.get("pw"));
		stmt = conn.createStatement();
		
		return stmt;
	}
	
	
	
	//DB접속 정보를 가지고 DB에 접속해서 SQL구문을 실행하는 기능을 하는 클래스
	//SQL 실행결과를 호출한 쪽으로 반환해줌
	public List<Member> selectAll() {  //  반환해야지 > 반환형?
		//DB연결해서 resultset으로 데이터 받아오기
		try {
			
			
			
			
			String query = "Select * from Member";
			rs = querySet().executeQuery(query);
			
				while(rs.next()){
					String id = rs.getString("Member_id");
					String pwd = rs.getString("Member_pwd");
					String name = rs.getString("Member_name");
					String gen = rs.getString("gender");
					int age = rs.getInt("Age");
					String email =rs.getString("email");
					String phone = rs.getString("phone");
					String add = rs.getString("address");
					String hob = rs.getString("hobby");
					Date enroll = rs.getDate("enroll_date");
					
					memList.add(new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll));
					
				}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
						if(rs != null & !rs.isClosed()) {
							rs.close();
						}
						if(stmt != null & !stmt.isClosed()) {
							stmt.close();
						}
						if(conn != null & !conn.isClosed()) {
							conn.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		}
		
		
		
		return memList;
	}



	public List<Member> nameSelectAll(String nameInput) {
		String query = "SELECT * FROM MEMBER WHERE MEMBER_NAME like ('%"+nameInput+"%')";
		Member m = null;
		List<Member> temp = new ArrayList<>();
			try {
				rs = querySet().executeQuery(query);
					
					while(rs.next()){
						
							String id = rs.getString("Member_id");
							String pwd = rs.getString("Member_pwd");
							String name = rs.getString("Member_name");
							String gen = rs.getString("gender");
							int age = rs.getInt("Age");
							String email =rs.getString("email");
							String phone = rs.getString("phone");
							String add = rs.getString("address");
							String hob = rs.getString("hobby");
							Date enroll = rs.getDate("enroll_date");
							
							m = new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll);
							temp.add(m);
						}
					
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
					try {
							if(rs!=null && !rs.isClosed()) {
								rs.close();
							}
					
							if(stmt != null && !stmt.isClosed()) {
								stmt.close();
							}
							
							if(conn != null && !conn.isClosed()) {
								conn.close();
							}
							
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			
		
			if(m != null) {
				return temp;
			} else {
				return null;
			}
 
		
		
	}



	public Member idSelectAll(String idInput) {
		String query = "SELECT * FROM MEMBER WHERE MEMBER_id = '"+idInput+"'";
		Member m = null;
			
		 	try {
				rs = querySet().executeQuery(query);
					if(rs.next()) {
						
						String id = rs.getString("Member_id");
						String pwd = rs.getString("Member_pwd");
						String name = rs.getString("Member_name");
						String gen = rs.getString("gender");
						int age = rs.getInt("Age");
						String email =rs.getString("email");
						String phone = rs.getString("phone");
						String address = rs.getString("address");
						String hobby = rs.getString("hobby");
						Date enroll = rs.getDate("enroll_date");
						
						
						m = new Member(id, pwd, name, gen, age, email, phone, address, hobby, enroll);
					}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
					if(rs!=null && !rs.isClosed()) {
						rs.close();
					}
			
					if(stmt != null && !stmt.isClosed()) {
						stmt.close();
					}
					
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
					
				
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		 	
		 	
			if(m != null) {
				return m;
			} else {
				return null;
			}
			
			
		 	
		
	}



	public void enroll(Member mem) {
		String query = "insert into Member  values('"+mem.getMemberId()+"','"+
						mem.getMemberPwd()+"','"+mem.getMemberName()+"','"+
						mem.getGender()+"','"+mem.getAge()+"','"+mem.getEmil()+"','"+
						mem.getPhone()+"','"+mem.getAddress()+"','"+mem.getHobby()+"', default )";
		
		
		
			try {
				
				
				
				//Connection 객체에 트렌젝션을 처리해주는 메소드가 있다. > commit()/ rollback() 메소드!
				// 
				int result = querySet().executeUpdate(query);
				conn.setAutoCommit(false); // 트렌젝션 처리를 개발자가 할 수 있음
				
				
				// insert에 대해서 트랜젝션 처리를 해야함 지금은 auto commit이라...
				
				
				if(result>0) {
					conn.commit();
						System.out.println(result+"행이 삽입 되었습니다.");
					
				} else {
					
					conn.rollback();
						System.out.println(" 오류가 있어 작업을 완료하지 못했습니다. ");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
					try {
						
						
						
						if(stmt != null && !stmt.isClosed()) {
							stmt.close();
							
						}
						
						if(conn != null && !conn.isClosed()) {
							conn.close();
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
	}



	public int update(String query) {
		int num = 0;
			try {
				
				num = querySet().executeUpdate(query);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
					try {
						if(stmt != null && stmt.isClosed()) {
							stmt.close();
						}
						
						if(conn != null && conn.isClosed()) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		
		return num;
	}



	public void delete(String id) {
		String query = "delete from member where member_id = '" + id +"'"; 
		int result = 0;
		try {
			
			result = querySet().executeUpdate(query);
			conn.setAutoCommit(false);
			
			if (result !=0 ) {
				conn.commit();
				System.out.println("삭제완료");
			} else {
				conn.rollback();
				System.out.println("삭제에 실패했습니다.");
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(stmt != null && stmt.isClosed()) {
					stmt.close();
				}
				
				if(conn != null && conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
