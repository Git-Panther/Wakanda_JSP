package com.kh.java.info.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Protocol : " + request.getProtocol());
		System.out.println("Server's name : " + request.getServerName());
		System.out.println("Web root at : " + request.getContextPath());
		System.out.println("Current at : " + request.getRequestURI());
		System.out.println("Requester IP : " + request.getRemoteAddr());
		
		Enumeration<String> headers = request.getHeaderNames(); // Iterator와 사용법이 똑같다.
		String headerName = "";
		while(headers.hasMoreElements()){
			headerName = headers.nextElement();
			System.out.println(headerName + " : " + request.getHeader(headerName));
		}
		
		HttpSession session = request.getSession();
		System.out.println("Issued Session ID : " + session.getId());
		System.out.println("Recently accessed time : " + session.getLastAccessedTime()); 
		
		// 접속했던 사람들에 대한 기록
		// application 영역에 데이터를 저장
		
		ServletContext application = getServletContext();
		Set<String> userList = (Set<String>)application.getAttribute("userName");
		
		if(userList == null){
			userList = new HashSet<String>();
		}
		
		userList.add(request.getRemoteAddr());
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<ol>");
		for(String userip : userList){
			out.println("<li>" + userip + "</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
	}

}
