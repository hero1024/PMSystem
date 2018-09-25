package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.itoffer.bean.Page;
import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.service.Service;
import com.qst.itoffer.service.impl.ServiceImpl;


/*权限管理*/
@WebServlet("/AuthManageServlet")
public class AuthManageServlet extends HttpServlet {
	
	public static final String SUCCESS_MESSAGE = "success";
	public static final String ERROR_MESSAGE = "failed";
	private static final long serialVersionUID = 1L;
	
	
	static Service service =  new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  AuthManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("op");
		
		if(op.equals("page")){
			pageList(request,response);
		}else if(op.equals("find")){
			findStaff(request,response);
		}else if(op.equals("edithrs")){
			editHrs(request,response);
		}else if(op.equals("editstaff")){
			editStaff(request,response);
		}
//		else if(op.endsWith("findName")){
//			String name = (String)request.getSession().getAttribute("name");
//			pageListName(request,response,name);
//		}
		
		
	}

	

private void findStaff(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
//		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		
		if(id!=""){
			Staff sta = service.findStaffById(id);
			
			session.setAttribute("staff", sta);
			
			response.sendRedirect(request.getContextPath()+"/staffFind4.jsp");
		}
//		else{
//			session.setAttribute("name", name);
//			
//			
//			pageListName(request,response,name);
//			
//		}
		
		
	}



private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPageIndex = request.getParameter("currentPageIndex");
		
		int pageIndex = Integer.parseInt(currentPageIndex);
		
		int pageCount = service.getPageCount(5);
		
		if(pageIndex<1)
			pageIndex =1 ;
		if(pageIndex>pageCount)
			pageIndex=pageCount;
		
		Page page = service.getPageList(pageIndex,5);
		page.setCurrentPageIndex(pageIndex);
		
		HttpSession session = request.getSession();
		Integer start = (Integer) session.getAttribute("startIndex");
		Integer end = (Integer) session.getAttribute("endIndex");
		
		//session.setAttribute("currentPageIndex", pageIndex);//
		if(start == null){
			session.setAttribute("startIndex", 1);
		}
		if(end == null){
			if(pageCount<5){
				session.setAttribute("endIndex", pageCount);
			}else{
			session.setAttribute("endIndex", 5);
			}
		}
		if(pageIndex == (Integer) session.getAttribute("startIndex") &&pageIndex !=1){
			session.setAttribute("startIndex", (Integer)session.getAttribute("startIndex")-1);
			session.setAttribute("endIndex", (Integer)session.getAttribute("endIndex")-1);
		}
		if(pageIndex == (Integer) session.getAttribute("endIndex") &&pageIndex !=pageCount){
			session.setAttribute("startIndex", (Integer)session.getAttribute("startIndex")+1);
			session.setAttribute("endIndex",  (Integer)session.getAttribute("endIndex")+1);
		}
		
		if(pageIndex < (Integer) session.getAttribute("startIndex")){
			session.setAttribute("startIndex", pageIndex-1);
			session.setAttribute("endIndex",  pageIndex+3);
			if(pageIndex <= 2){
				session.setAttribute("startIndex", 1);
				session.setAttribute("endIndex",  5);
				if(pageCount <5){
					session.setAttribute("endIndex",  pageCount);
				}
			}
			
		}
		
		if(pageIndex > (Integer) session.getAttribute("endIndex")){
			session.setAttribute("startIndex", pageIndex-3);
			session.setAttribute("endIndex",  pageIndex+1);
			if(pageIndex >= pageCount - 1){
				session.setAttribute("startIndex", pageIndex-4);
				session.setAttribute("endIndex",  pageCount);
			}
		}
		
		if((Integer) session.getAttribute("endIndex")>pageCount){
			session.setAttribute("startIndex", pageIndex-4);
			session.setAttribute("endIndex",  pageCount);
		}
	    
		if((Integer) session.getAttribute("startIndex")<0){
			session.setAttribute("startIndex", 1);
		}
		
		if((Integer) session.getAttribute("startIndex")==1 && pageCount>5){
			session.setAttribute("endIndex", 5);
		}
		
		//将信息存取到session当中 因为是请求重定向所以 不能直接存在页面或者是request当中 
		session.setAttribute("pageAll", page);
		
		//请求重定向到list页面 由于是客户端跳转 所以必须加根路径
		response.sendRedirect(request.getContextPath()+"/authManage.jsp");
		
	}
//private void pageListName(HttpServletRequest request, HttpServletResponse response,String name) 
//		throws ServletException, IOException {
//		
//		String currentPageIndex = request.getParameter("currentPageIndex");
//		
//		int pageIndex = Integer.parseInt(currentPageIndex);
//		
//		int pageCount = service.getNamePageCount(5, name);
//		
//		if(pageIndex<1)
//			pageIndex =1 ;
//		if(pageIndex>pageCount)
//			pageIndex=pageCount;
//		
//		Page page = service.getPageListByName(pageIndex, 5, name);
//		page.setCurrentPageIndex(pageIndex);
//		
//		HttpSession session = request.getSession();
//		Integer start = (Integer) session.getAttribute("startIndex");
//		Integer end = (Integer) session.getAttribute("endIndex");
//		
//		//session.setAttribute("currentPageIndex", pageIndex);
//		if(start == null){
//			session.setAttribute("startIndex", 1);
//		}
//		if(end == null){
//			if(pageCount<5){
//				session.setAttribute("endIndex", pageCount);
//			}else{
//			session.setAttribute("endIndex", 5);
//			}
//		}
//		if(pageIndex == (Integer) session.getAttribute("startIndex") &&pageIndex !=1){
//			session.setAttribute("startIndex", (Integer)session.getAttribute("startIndex")-1);
//			session.setAttribute("endIndex", (Integer)session.getAttribute("endIndex")-1);
//		}
//		if(pageIndex == (Integer) session.getAttribute("endIndex") &&pageIndex !=pageCount){
//			session.setAttribute("startIndex", (Integer)session.getAttribute("startIndex")+1);
//			session.setAttribute("endIndex",  (Integer)session.getAttribute("endIndex")+1);
//		}
//		
//		if(pageIndex < (Integer) session.getAttribute("startIndex")){
//			session.setAttribute("startIndex", pageIndex-1);
//			session.setAttribute("endIndex",  pageIndex+3);
//			if(pageIndex <= 2){
//				session.setAttribute("startIndex", 1);
//				session.setAttribute("endIndex",  5);
//				if(pageCount <5){
//					session.setAttribute("endIndex",  pageCount);
//				}
//			}
//			
//		}
//		
//		if(pageIndex > (Integer) session.getAttribute("endIndex")){
//			session.setAttribute("startIndex", pageIndex-3);
//			session.setAttribute("endIndex",  pageIndex+1);
//			if(pageIndex >= pageCount - 1){
//				session.setAttribute("startIndex", pageIndex-4);
//				session.setAttribute("endIndex",  pageCount);
//			}
//		}
//		
//		if((Integer) session.getAttribute("endIndex")>pageCount){
//			session.setAttribute("startIndex", pageIndex-4);
//			session.setAttribute("endIndex",  pageCount);
//		}
//		
//		if((Integer) session.getAttribute("startIndex")<0){
//			session.setAttribute("startIndex", 1);
//		}
//		
//		if(pageCount<5){
//			session.setAttribute("endIndex", pageCount);
//		}
//			
//		
//		//将信息存取到session当中 因为是请求重定向所以 不能直接存在页面或者是request当中 
//		session.setAttribute("pageName", page);
//		
//		//请求重定向到list页面 由于是客户端跳转 所以必须加根路径
//		response.sendRedirect(request.getContextPath()+"/authManage.jsp");
//		
//	}

    private void editStaff(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Staff staff = (Staff)request.getSession().getAttribute("staff");
		
		Service service = new ServiceImpl();
		
		String id = request.getParameter("id");
		String role = "staff";
		System.out.println(id);
		int n = service.updateRole(id, role);
		staff.setRole(role);
		
		response.sendRedirect(request.getContextPath()+"/authManage.jsp");
    	
    }
    
    private void editHrs(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Staff staff = (Staff)request.getSession().getAttribute("staff");
		
		Service service = new ServiceImpl();
		
		String id = request.getParameter("id");
		String role = "hrs";
		System.out.println(id);
		int n = service.updateRole(id, role);
		staff.setRole(role);
		
		response.sendRedirect(request.getContextPath()+"/authManage.jsp");
        	
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