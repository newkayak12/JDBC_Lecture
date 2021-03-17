 package com.bulletin.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import static com.comm.JDBCTEMPLATE.*;
import com.bulletin.abstView.DaoAbstract;
import com.bulletin.model.vo.Member;

public class MemberDao extends DaoAbstract <Member> {
	private List<Member> mList = new ArrayList<>();
	private Properties prop = new Properties();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String query ="";
	
	public MemberDao(){
		
		try {
				prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/M_sql.properties.properties"));
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<Member> queryAll(Connection conn) {
		mList.clear();
		query = prop.getProperty("queryAll");
			try {
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
					
						while(rs.next()) {
							int idx = rs.getInt("IDX");
							String id = rs.getString("MEMBER_ID");
							String pwd = rs.getString("Member_pwd");
							String name = rs.getString("MEMBER_NAME");
							String email = rs.getString("EMAIL");
							String address = rs.getString("ADDRESS");
							String phone  = rs.getString("PHONE");
							String enrollDate = rs.getString("ENROLL_DATE");
							
							Member mem = new Member(idx, id, pwd, name, email, address, phone, enrollDate);
							mList.add(mem);
									
						}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		return mList;
		
	}

	@Override
	public List<Member> queryConditionId(Connection conn, String ref) {
		query = prop.getProperty("queryId");
		query = query +"'"+ref+"'";
		
			try {
					
					mList.clear();
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
					
						while(rs.next()) {
							int idx = rs.getInt("IDX");
							String id = rs.getString("MEMBER_ID");
							String pwd = rs.getString("Member_pwd");
							String name = rs.getString("MEMBER_NAME");
							String email = rs.getString("EMAIL");
							String address = rs.getString("ADDRESS");
							String phone  = rs.getString("PHONE");
							String enrollDate = rs.getString("ENROLL_DATE");
							
							Member mem = new Member(idx, id, pwd, name, email, address, phone, enrollDate);
							mList.add(mem);
									
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		return mList;
	}

	@Override
	public List<Member> queryConditionTitle(Connection conn, String ref) {
		query = prop.getProperty("queryName");
		query = query +"'"+ref+"'";
		
			try {
					
					mList.clear();
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
					
						while(rs.next()) {
							int idx = rs.getInt("IDX");
							String id = rs.getString("MEMBER_ID");
							String pwd = rs.getString("Member_pwd");
							String name = rs.getString("MEMBER_NAME");
							String email = rs.getString("EMAIL");
							String address = rs.getString("ADDRESS");
							String phone  = rs.getString("PHONE");
							String enrollDate = rs.getString("ENROLL_DATE");
							
							Member mem = new Member(idx, id, pwd, name, email, address, phone, enrollDate);
							mList.add(mem);
									
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
		return mList;
	}

	@Override
	public int queryInsert(Connection conn, Member ref) {
		int result = 0;
		query = prop.getProperty("queryInsert");
		query += "seq_mem.nextval, ?, ?, ?,  ?, ?, ?, sysdate)";
		
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, ref.getMemberId());
				pstmt.setString(2, ref.getMemberPwd());
				pstmt.setString(3, ref.getMemberName());
				pstmt.setString(4, ref.getEmail());
				pstmt.setString(5, ref.getAddress());
				pstmt.setString(6, ref.getPhone());
//				pstmt.setString(7, ref.getEnrollDate()); //여기서 문제인가봄
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
		return result;
		
	}

	@Override
	public int queryModify(Connection conn, String[] ref) {
		int result = 0;
		query = prop.getProperty("queryModify");
		query = query.replace("!", ref[0]);
		query = query.replace("@", ref[1]);
		query = query.replace("#", ref[2]);
		
			try {
				pstmt = conn.prepareStatement(query);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
		

		
	}

	@Override
	public int queryDelete(Connection conn, String ref) {
		int result = 0;
		query = prop.getProperty("queryDelete");
		query += "'"+ref+"'";
		
			try {
					pstmt = conn.prepareStatement(query);
					result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
		

		
	}

}
