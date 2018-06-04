package com.kh.java.member.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		String name = request.getParameter("username");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email") + "@" + request.getParameter("domain");
		String phone = request.getParameter("phone1")
				+ "-" + request.getParameter("phone2")
				+ "-" + request.getParameter("phone3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address1") + " / " + request.getParameter("address2");
		String fullAddr = address + "|" + zipcode;
		String[] hobbies = request.getParameterValues("hobby");
		LinkedList<String> allHobby = null;
		if(hobbies != null){
			allHobby = new LinkedList<>();
			for(String hobby : hobbies){
				allHobby.add(hobby);
			}	
		}		
		MemberService ms = new MemberService();
		if(ms.getMemberById(id) != null){ // id가 존재하므로 안됨
			System.out.println("Duplicate");
		} else {
			
		}
		int result = ms.signupMember(new MemberVo(id, pw, name, gender, age, email, phone, fullAddr, allHobby, null));
		if(result == 0){
			System.out.println("failed.");
			request.setAttribute("msg", "Failed");
			RequestDispatcher view = request.getRequestDispatcher("views/member/signup.jsp");
			view.forward(request, response);
		}else{
			System.out.println(result + " has been success.");
			response.sendRedirect("index.jsp");
		}
	}

}
