package com.kh.java.member.controller;

import java.io.IOException;

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
		String email = request.getParameter("email");
		String phone = request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address1") + " / " + request.getParameter("address2");
		String fullAddr = address + "|" + zipcode;
		String[] hobbies = request.getParameterValues("hobby");
		/*
		LinkedList<String> allHobby = new LinkedList<>();
		for(String hobby : hobbies){
			allHobby.add(hobby);
		}
		*/
		StringBuilder allHobby = new StringBuilder();
		for(int index = 0; index < hobbies.length; index++){
			allHobby.append(hobbies[index]);
			if(index != hobbies.length - 1) allHobby.append("|");
		}
		
		MemberService ms = new MemberService();
		int result = ms.signupMember(new MemberVo(id, pw, name, gender, age, email, phone, fullAddr, allHobby.toString(), null));
	}

}
