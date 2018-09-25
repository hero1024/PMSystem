package com.qst.itoffer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StaffInfoServlet")
public class StaffInfoServlet extends HttpServlet {
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  StaffInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String op = request.getParameter("op");
		
		if(op.equals("page")){
			pageList(request,response);
		}
		
		
		
	}

	

	private void pageList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//请求重定向到list页面 由于是客户端跳转 所以必须加根路径
		response.sendRedirect(request.getContextPath()+"/staffInfo.jsp");
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
