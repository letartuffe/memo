package com.memo.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.memo.memo.MemoVO;

import com.memo.db.DBconnect;



public class MemoDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String query;
	
	int result;
		
	MemoVO vo;
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int insert(MemoVO vo){
		try{
			
			//데이터 삽입
			
			query = "insert into t_memo values (t_memo_seq.nextval,?,?,?,SYSDATE)";
			
			//스테이트먼트 객체 생성
			con = DBconnect.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getContent());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	return result;
	}//insert

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int delete(MemoVO vo){
	
		try {
			query = "delete from t_memo where no=?";
			
			con = DBconnect.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, Integer.toString(vo.getNo()));
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int update(MemoVO vo){

				

		try {
			
			query = "update t_memo set content =? where no=?";
			con = DBconnect.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, Integer.toString(vo.getNo()));
			result = pstmt.executeUpdate();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch blocke
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

			
		
		return result;
		
	}//update
	
	
	public Vector<MemoVO> select() {
		Vector<MemoVO> selectResult = new Vector<MemoVO>();
		
		try {
			
			con = DBconnect.getConnection();
			query = "select * from t_memo";//select query
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				//데이터 담을 vo 객체
				vo = new MemoVO();
				
				//vo에 담기
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setNick(rs.getString("nick"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("rDATE"));
				
				selectResult.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return selectResult;
			
	}//method

	
	public Vector<MemoVO> select(String s) {
		
		Vector<MemoVO> selectResult = new Vector<MemoVO>();
		
		try {
			
			
			
			con = DBconnect.getConnection();
			query = "select * from t_memo where no=?";//select query
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				//데이터 담을 vo 객체
				vo = new MemoVO();

				//vo에 담기
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setNick(rs.getString("nick"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("rDATE"));
				
				selectResult.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return selectResult;
			
	}//method
	
	
}//class
