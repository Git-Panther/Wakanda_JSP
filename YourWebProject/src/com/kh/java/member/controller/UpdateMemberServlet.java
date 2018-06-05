package com.kh.java.member.controller;

import java.io.IOException;
import java.util.LinkedList;

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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		
		String id = ((MemberVo)request.getSession().getAttribute("user")).getUserid();
		String pw = request.getParameter("userpw");
		String name = request.getParameter("username");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email") + "@" + request.getParameter("domain");
		String phone = request.getParameter("phone1")
				+ "-" + request.getParameter("phone2")
				+ "-" + request.getParameter("phone3");
		String zipcode = request.getParameter("zipcode");
		String address =  zipcode + ", " + request.getParameter("address1") + ", " + request.getParameter("address2");
		String fullAddr = address;
		String[] hobbies = request.getParameterValues("hobby");
		LinkedList<String> allHobby = null;
		if(hobbies != null){
			allHobby = new LinkedList<>();
			for(String hobby : hobbies){
				allHobby.add(hobby);
			}	
		}		
		MemberService ms = new MemberService();
		MemberVo member = new MemberVo(id, pw, name, gender, age, email, phone, fullAddr, allHobby, null);
		
		int result = ms.updateMember(member);
		if(result == 0){
			System.out.println("failed.");
			request.setAttribute("msg", "Failed");
			RequestDispatcher view = request.getRequestDispatcher("views/member/editMyInfo.jsp");
			view.forward(request, response);
		}else{
			System.out.println(result + " has been success.");
			// 기존 정보 세션 수정하고 리다이렉트
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			response.sendRedirect("index.jsp");
		}
	}

}
