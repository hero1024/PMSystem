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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")//×¢²áµÄservlet
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String role = "sfaff";
	
    /**
     *  HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
        
        Staff staff = new Staff();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");	
        
        
        staff.setUsername(username);
        staff.setPassword(password);
        //user.setRole(role);
        int n = service.addUser(staff);
        if(n!=0){
        	request.getSession().setAttribute("flag", "success");
        	response.sendRedirect("success.jsp");	
        }else{
        	request.getSession().setAttribute("flag", "error");
        	response.sendRedirect("success.jsp");
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
