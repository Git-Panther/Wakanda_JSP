package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signin.do")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		MemberVo member = new MemberService().signin(id, pw);

		if(member != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			response.sendRedirect("index.jsp");	
		} else {
			// 다시 로그인하라는 페이지로 이동한다.
			request.setAttribute("msg1", "Invalid ID or password.");
			request.setAttribute("msg2", "Please check them again.");
			RequestDispatcher rd = request.getRequestDispatcher("views/common/signin.jsp");
			rd.forward(request, response);
		}
	}
}
