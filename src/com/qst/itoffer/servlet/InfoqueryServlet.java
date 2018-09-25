package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.itoffer.service.Service;
import com.qst.itoffer.service.impl.ServiceImpl;

@WebServlet("/InfoqueryServlet")
public class InfoqueryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS_MESSAGE = "success";
	public static final String ERROR_MESSAGE = "failed";
	
	static Service service =  new ServiceImpl();
	
	public InfoqueryServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("op");
		
		if(op.equals("page")){
			pageList(request,response);
		}
		
	}

	

	private void pageList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//请求重定向到list页面 由于是客户端跳转 所以必须加根路径
		response.sendRedirect(request.getContextPath()+"/infoquery.jsp");
		
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
