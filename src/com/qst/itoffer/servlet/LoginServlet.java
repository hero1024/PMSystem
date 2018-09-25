package com.qst.itoffer.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.qst.itoffer.bean.Message;
import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.service.Service;
import com.qst.itoffer.service.impl.ServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")//鐧诲綍鐨剆ervlet
public class LoginServlet extends HttpServlet {
	
	public static final String SUCCESS_MESSAGE = "success";
	public static final String ERROR_MESSAGE = "failed";
	private static final long serialVersionUID = 1L;
       
    /**
     *  HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *  HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Service service = new ServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Staff staff = new Staff();
		staff = service.login(username, password);
		Message message = new Message();
		
		if(staff == null){
			
			message.setResult(ERROR_MESSAGE);
			message.setMessageInfo("success");
			
			String messageJson = JSONObject.toJSONString(message);
			out.write(messageJson);
			
			
		}else{
			//灏嗙敤鎴风殑淇℃伅灏佽鍒皊ession涓�
			request.getSession().setAttribute("staff", staff);
			
			message.setResult(SUCCESS_MESSAGE);
			message.setMessageInfo("failed");
			
			String messageJson = JSONObject.toJSONString(message);
			out.write(messageJson);
			
				}
			
		}
		
		
		
	

	/**
	 *  HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
