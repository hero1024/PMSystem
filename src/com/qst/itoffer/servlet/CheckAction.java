package com.qst.itoffer.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.service.Service;
import com.qst.itoffer.service.impl.ServiceImpl;
/** 
 * Servlet implementation class Register
 */
@WebServlet("/CheckAction")//閻€劍鍩涢崥宥嗙壐瀵繘鐛欑拠浣烘畱servlet
public class CheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  HttpServlet#HttpServlet()
     */
    public CheckAction() {
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
        
        Staff staff = service.check(username);
        //System.out.println(username);  
        if(username.trim().length()==0 || username == null){  
            out.println("<font color='red'>用户名不能为空!</font>");  
        }else if(!username.matches("[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}")){
        	out.println("<font color='red'>用户名格式不正确,必须以字母开头!</font>");
        }else if(staff!=null){  
            out.println("<font color='red'>此用户名已经被注册!</font>");  
        }else{  
            out.println("<font color='green'>此用户名可以使用!</font>");
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
