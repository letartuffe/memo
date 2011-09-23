package com.memo.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memo.db.DBconnect;



/**
 * Servlet implementation class UserChk
 */
public class UserChk extends HttpServlet {
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	static String dbID = "test";
	static String dbPW = "1111";
	
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String query;
	private UserVO vo;
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	public int userChk(String userNM, String userPW){

		Iterator<UserVO> itID = select(userNM).iterator();
		Iterator<UserVO> it = select(userNM, userPW).iterator();
		
		if (!itID.hasNext()){
			return 0;
		}else if(!it.hasNext()){
			return 1;
		}else{
			return 2;
		}			
	}
	
	public Vector<UserVO> select(String id) {
		Vector<UserVO> selectResult = new Vector<UserVO>();
		
		try {
			
			
			
			con = DBconnect.getConnection();
			query = "select * from T_MEMBER where userid=?";//select query
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				//데이터 담을 vo 객체
				vo = new UserVO();
				
				//vo에 담기
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				vo.setUsernm(rs.getString("usernm"));
				vo.setAddress(rs.getString("address"));
				vo.setUserno(rs.getInt("no"));
				vo.setRegDate(rs.getDate("reg_DATE"));
				
				selectResult.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return selectResult;
			
	}//method
	
	public Vector<UserVO> select(String id, String pw) {
		Vector<UserVO> selectResult = new Vector<UserVO>();
		
		try {
			
			
			
			con = DBconnect.getConnection();
			query = "select * from T_MEMBER where userid=? and userpw=?";//select query
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			while(rs.next()){
				
				//데이터 담을 vo 객체
				vo = new UserVO();
				
				//vo에 담기
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				vo.setUsernm(rs.getString("usernm"));
				vo.setAddress(rs.getString("address"));
				vo.setUserno(rs.getInt("no"));
				vo.setRegDate(rs.getDate("reg_DATE"));
				
				selectResult.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return selectResult;
			
	}//method

}
