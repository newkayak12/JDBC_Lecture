package com.bulletin.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.comm.JDBCTEMPLATE.*;

import com.bulletin.abstView.DaoAbstract;
import com.bulletin.model.vo.Board;
import com.bulletin.model.vo.Member;

public class BoardDao extends DaoAbstract <Board>{
	private List<Board> bList = new ArrayList<>();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String query = "";
	private Properties prop = new Properties();
	Board board ;
	public BoardDao() {
		
			try {
				prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/B_sql.properties.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	@Override
	public List<Board> queryAll(Connection conn) {
		query = prop.getProperty("queryAll");
			if(bList != null) {
				
				bList.clear();
			}
		
		
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
					while(rs.next()) {
						int idx = rs.getInt("IDX");
						String div = rs.getString("DIV");
						String title = rs.getString("Title");
						String content = rs.getString("Contents");
						int writer = rs.getInt("writer");
						String writeDate = rs.getDate("Write_date").toString();
						
					board = new Board(idx, div, title, content, writer, writeDate);
						
						bList.add(board);
						
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				
			}
			
		////IDX	NUMBER
		////DIV	VARCHAR2(10 BYTE)
		////TITLE	VARCHAR2(50 BYTE)
		////CONTENTS	VARCHAR2(3000 BYTE)
		////WRITER	NUMBER
		////WRITE_DATE	DATE
		//private int idx;
		//private String div, title, cotents;
		//private int writer;
		//private String writeDate;
		//
			
			
			
		
		return bList;
	}

	@Override
	public List<Board> queryConditionId(Connection conn, String ref) {
		query = prop.getProperty("queryId");
		int parse = Integer.parseInt(ref);
		query += parse;
			if(bList != null) {
				
				bList.clear();
			}

			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					int idx = rs.getInt("IDX");
					String div = rs.getString("DIV");
					String title = rs.getString("Title");
					String content = rs.getString("Contents");
					int writer = rs.getInt("writer");
					String writeDate = rs.getDate("Write_date").toString();
					
					board = new Board(idx, div, title, content, writer, writeDate);
					
					bList.add(board);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		
		return bList;
	}

	@Override
	public List<Board> queryConditionTitle(Connection conn, String ref) {
		query = prop.getProperty("queryTitle");
//		SELECT * FROM BOARD WHERE title = 
		query += "'"+ref+"'";
			if(bList != null) {
				
				bList.clear();
			}

			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int idx = rs.getInt("IDX");
					String div = rs.getString("DIV");
					String title = rs.getString("Title");
					String content = rs.getString("Contents");
					int writer = rs.getInt("writer");
					String writeDate = rs.getDate("Write_date").toString();
					
				board = new Board(idx, div, title, content, writer, writeDate);
					
					bList.add(board);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		
		return bList;
	}

	@Override
	public int queryInsert(Connection conn, Board m) {
		int result = 0;
		query = prop.getProperty("queryInsert");
		query += "seq_board, ?,?,?, ?,?)";
	////DIV	VARCHAR2(10 BYTE)
	////TITLE	VARCHAR2(50 BYTE)
	////CONTENTS	VARCHAR2(3000 BYTE)
	////WRITER	NUMBER
	////WRITE_DATE	DATE
		
		try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, m.getDiv());
				pstmt.setString(2, m.getTitle());
				pstmt.setString(3, m.getCotents());
				pstmt.setInt(4, m.getWriter());
				pstmt.setString(5, m.getWriteDate());
				
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
		
//		parsing
		return result;
	}

	@Override
	public int queryDelete(Connection conn, String ref) {
		// parsing
		int result = 0;
		query = prop.getProperty("queryDelete");
		query += ref;
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
	
////IDX	NUMBER
////DIV	VARCHAR2(10 BYTE)
////TITLE	VARCHAR2(50 BYTE)
////CONTENTS	VARCHAR2(3000 BYTE)
////WRITER	NUMBER
////WRITE_DATE	DATE
//private int idx;
//private String div, title, cotents;
//private int writer;
//private String writeDate;
//
	
	
	
//			queryAll = SELECT * FROM BOARD
//			queryId  = SELECT * FROM BOARD WHERE Writer = 
//			queryTitle = SELECT * FROM BOARD WHERE title = 
//			queryInsert = INSERT INTO BOARD VALUES(
//			queryModify = UPDATE BOARD SET ! = @ WHERE writer= #
//			queryDelete = DELETE BOARD WHERE idx = 

}
