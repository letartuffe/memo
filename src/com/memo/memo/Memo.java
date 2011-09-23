package com.memo.memo;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Memo
 */
public class Memo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void disPacherGO(HttpServletRequest request, HttpServletResponse response, String sendURL) throws ServletException, IOException {
        
		RequestDispatcher rd = request.getRequestDispatcher(sendURL);
        rd.forward(request, response);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		Vector<MemoVO> mv = new Vector<MemoVO>();
		
		MemoDAO mdao = new MemoDAO();
		mv = mdao.select();
		

		request.setAttribute("memo", mv);

        String sendURL = "/memo/memo.jsp";
        
        disPacherGO(request,response, sendURL);


	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String mode = (String) request.getParameter("mode");
		HttpSession session = request.getSession();
		
		//技记 蜡公 眉农
		if( session.getAttribute("userid") != null){
			//葛靛喊 贸府
			if(mode.equals("write")){
				
				MemoVO vo = new MemoVO();
				vo.setId((String) session.getAttribute("userid"));
				vo.setNick((String) session.getAttribute("userid"));
				vo.setContent((String) request.getParameter("Content"));
				
				MemoDAO mdao = new MemoDAO();
				mdao.insert(vo);
				
			}else if(mode.equals("update")){

				MemoVO vo = new MemoVO();
				vo.setNo(Integer.parseInt(request.getParameter("no")));
				vo.setContent(request.getParameter("Content"));
				MemoDAO mdao = new MemoDAO();
				mdao.update(vo);
				
			}else if(mode.equals("delete")){
				MemoVO vo = new MemoVO();
				vo.setNo(Integer.parseInt(request.getParameter("no")));
				
				MemoDAO mdao = new MemoDAO();
				mdao.delete(vo);
			}
			
			

		}
		
		Vector<MemoVO> mv = new Vector<MemoVO>();
		
		MemoDAO mdao = new MemoDAO();
		mv = mdao.select();

		request.setAttribute("memo", mv);

		String sendURL = "/memo/memo.jsp";

        disPacherGO(request,response, sendURL);
	}
}
