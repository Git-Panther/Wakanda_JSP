package com.kh.java.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Loading...</title>");	
		if(member != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
		} else {
			out.println("<script type='text/javascript' src='/uwp/js/jquery-3.3.1.min.js'></script>");
			out.println("<script>$(function(){alert('Check again your id or password.');});</script>");		
		}
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		response.sendRedirect("index.jsp");
		out.close();
	}

}
