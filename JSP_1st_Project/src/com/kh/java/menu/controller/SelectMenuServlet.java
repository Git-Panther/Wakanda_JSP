package com.kh.java.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectMenuServlet
 */
@WebServlet("/selectMenu.do")
public class SelectMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 1. 전송값에 한글이 있으면 한글 인코딩 2. 전송값 변수에 저장 3. 비즈니스 로직 -> 서비스 호출 4. 결과값 화면에 출력(전송값 전달)
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String menu = request.getParameter("menu");
		
		String name = "";
		String menuStr = "";
		int score = 0;
		
		switch(menu){
		case "champion1":
			name = "마이충";
			menuStr = "마타하지마라";
			score = 0;
			break;
		case "champion2":
			name = "미드타릭";
			menuStr = "마타하지마라";
			score = 0;
			break;
		case "champion3":
			name = "미드이렐";
			menuStr = "너프시급함";
			score = 99;
			break;
		case "champion4":
			name = "카이사";
			menuStr = "카이사했다";
			score = 100;
			break;
		case "champion5":
			name = "신챔충";
			menuStr = "파이크충 생기겄네;";
			score = 50;
			break;
		case "champion6":
			name = "모기";
			menuStr = "즙라디냐 물만두냐 동수칸이냐 그것이 문제로다";
			score = 30;
			break;
		default:
			name = "티모";
			menuStr = "티모";
			score = Integer.MIN_VALUE;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("menu", menuStr);
		request.setAttribute("score", score);
		
		RequestDispatcher view = request.getRequestDispatcher("views/4.menuResult.jsp");
		view.forward(request, response);
	}

}
