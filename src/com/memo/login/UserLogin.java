package com.memo.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSession
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
        String id  = request.getParameter("id");
        String pass  = request.getParameter("pass");
        
        UserChk uck = new UserChk();
        int result = uck.userChk(id, pass);
        
        String sendURL = "/login/main.jsp";
        System.out.println(result);
        if(result == 0){
        	response.sendRedirect("/memo/login/error.jsp?result=0");
        }else if(result == 1){
        	response.sendRedirect("/memo/login/error.jsp?result=1");
        }else{
        	session.setAttribute("userid", id);
        	session.setMaxInactiveInterval(5*60);
        	
        	RequestDispatcher rd = request.getRequestDispatcher(sendURL);
        	rd.forward(request, response);
        }
	}
}
