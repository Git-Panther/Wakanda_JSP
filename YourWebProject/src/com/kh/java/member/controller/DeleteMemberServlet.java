package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/delete.do") // 계정 : account, 탈퇴 : delete my account, 
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 리퀘스트의 값
		String id = request.getParameter("userid");
		/*
		// 세션의 값
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		String id2 = user.getUserid();
		*/
		
		MemberService ms = new MemberService();
		int result = ms.deleteMember(id);
		
		if(result == 0){
			// 실패
			request.setAttribute("msg", "Failed");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		} else {
			// 성공했으니 로그아웃
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/uwp/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
