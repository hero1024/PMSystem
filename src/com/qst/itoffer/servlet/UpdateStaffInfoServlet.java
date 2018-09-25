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

/*用于对主管信息进行查看、修改的Servlet*/
@WebServlet("/UpdateStaffInfoServlet")
public class UpdateStaffInfoServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS_MESSAGE = "success";
	public static final String ERROR_MESSAGE = "failed";
	
	
	public UpdateStaffInfoServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Staff staff = (Staff)request.getSession().getAttribute("staff");
		
		Service service = new ServiceImpl();
		

		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String location = request.getParameter("location");
	
		System.out.println(password);
		System.out.println(name);
		System.out.println(sex);
		System.out.println(location);
		
		staff.setPassword(password);
		staff.setName(name);
		staff.setSex(sex);
		staff.setLocation(location);
		int n = service.updateStaffInfoById(staff.getId(), staff);
		
		Message message = new Message();
		
		if (n==0) {
			message.setResult(ERROR_MESSAGE);
			message.setMessageInfo("修改失败");
			
			String messageJson = JSONObject.toJSONString(message);
			out.write(messageJson);
		}
		else {
			request.getSession().setAttribute("staff", staff);
			message.setResult(SUCCESS_MESSAGE);
			message.setMessageInfo("修改成功");
			
			String messageJson = JSONObject.toJSONString(message);
			out.write(messageJson);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}