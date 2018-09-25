package com.qst.itoffer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.alibaba.fastjson.JSONObject;
import com.qst.itoffer.bean.Page;
import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.bean.StaffForm;
import com.qst.itoffer.service.Service;
import com.qst.itoffer.service.impl.ServiceImpl;

/**
 * Servlet implementation class GradeManageServlet
 */
@WebServlet("/GradeManageServlet")
public class GradeManageServlet extends HttpServlet {
	public static final String SUCCESS_MESSAGE = "success";
	public static final String ERROR_MESSAGE = "failed";
	private static final long serialVersionUID = 1L;
	
	
	static Service service =  new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  GradeManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String op = request.getParameter("op");
		
		if(op.equals("page")){
			pageList(request,response);
		}else if(op.equals("delete")){
			deleteStaff(request,response);
		}else if(op.equals("delmore")){
			deleteMoreStaff(request,response);
		}else if(op.equals("edit")){
			editStaff(request,response);
		}else if(op.equals("update")){
			updateStaff(request,response);
		}else if(op.equals("add")){
			addStaff(request,response);
		}else if(op.equals("find")){
			findStaff(request,response);
		}else if(op.endsWith("findName")){
			String name = (String)request.getSession().getAttribute("name");
			
			pageListName(request,response,name);
		}
		
		
	}

	

	private void findStaff(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		
		if(id!=""){
			Staff sta = service.findStaffById(id);
			
			session.setAttribute("staff", sta);
			
			response.sendRedirect(request.getContextPath()+"/staffFind2.jsp");
		}else{
			session.setAttribute("name", name);
			
			
			pageListName(request,response,name);
			
		}
		
		
		
		
		
	}

	private void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        StaffForm staForm = new StaffForm();
		
		Staff sta = new Staff();
		 try {
		BeanUtils.populate(staForm, request.getParameterMap());
		
		ConvertUtils.register(new Converter()        
			       {  
			           @SuppressWarnings("rawtypes")  
			           @Override  
			           public Object convert(Class arg0, Object arg1)  
			           {  
			               /*System.out.println("ע���ַ�ת��Ϊdate����ת����"); */ 
			               if(arg1 == null)  
			               {  
			                   return null;  
			               }  
			               if(!(arg1 instanceof String))  
			               {  
			                   throw new ConversionException("ֻ֧���ַ�ת�� !");  
			               }  
			                  
			               String str = (String)arg1;  
			               if(str.trim().equals(""))  
			               {  
			                   return null;  
			               }  
			                  
			               SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");  
			                  
			               try{  
			                   return sd.parse(str);  
			               }  
			               catch(ParseException e)  
			               {  
			                   throw new RuntimeException(e);  
			               }  
			                  
			           }  
			              
			       }, Date.class);  
		
		
		BeanUtils.copyProperties(sta, staForm);
		service.addStaff(sta);
		//System.out.println(n+":"+sta);
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 response.sendRedirect(request.getContextPath()+"/InfoManageServlet?op=page&currentPageIndex=1");
	}

	private void updateStaff(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String id = request.getParameter("id");
		StaffForm staForm = new StaffForm();
		
		Staff sta = new Staff();
		 try {
		BeanUtils.populate(staForm, request.getParameterMap());
		
		ConvertUtils.register(new Converter()      //��Ҳ�㲻��Ϊʲô���û���� �����ϴ���д�ľͿ���  
			       {  
			           @SuppressWarnings("rawtypes")  
			           @Override  
			           public Object convert(Class arg0, Object arg1)  
			           {  
			               /*System.out.println("ע���ַ�ת��Ϊdate����ת����"); */ 
			               if(arg1 == null)  
			               {  
			                   return null;  
			               }  
			               if(!(arg1 instanceof String))  
			               {  
			                   throw new ConversionException("ֻ֧���ַ�ת�� !");  
			               }  
			                  
			               String str = (String)arg1;  
			               if(str.trim().equals(""))  
			               {  
			                   return null;  
			               }  
			                  
			               SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");  
			                  
			               try{  
			                   return sd.parse(str);  
			               }  
			               catch(ParseException e)  
			               {  
			                   throw new RuntimeException(e);  
			               }  
			                  
			           }  
			              
			       }, Date.class);  
		
		
		BeanUtils.copyProperties(sta, staForm);
		service.updateStaffById(id, sta);
		//System.out.println(n+":"+stu);
		
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 response.sendRedirect(request.getContextPath()+"/modInfo.jsp");
		
	}

	private void editStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		
		Staff sta = service.findStaffById(id);
		
		request.getSession().setAttribute("staff", sta);
		
		response.sendRedirect(request.getContextPath()+"/gradeManage.jsp");
		
	}

	private void deleteMoreStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String ids = request.getParameter("ids");
		
        if(ids.length()>0){
		ids.substring(0,ids.length()-1);
		
		String []  strIds = ids.split(",");
		
		for(int i=0;i<strIds.length;i++){
			service.deleteStaffById(strIds[i]);
		}
        }
		
		pageList(request,response);
		
	}

	private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String id = request.getParameter("id");
			
		service.deleteStaffById(id);
		
    
		
		pageList(request,response);
		
	}

	private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPageIndex = request.getParameter("currentPageIndex");
		
		int pageIndex = Integer.parseInt(currentPageIndex);
		
		int pageCount = service.getPageCount(5);
		
		if(pageIndex<1)
			pageIndex =1 ;
		if(pageIndex>pageCount)
			pageIndex=pageCount;
		
		Page page = service.getPageList2(pageIndex,5);
		page.setCurrentPageIndex(pageIndex);
		
		HttpSession session = request.getSession();
		Integer start = (Integer) session.getAttribute("startIndex");
		Integer end = (Integer) session.getAttribute("endIndex");
		
		//session.setAttribute("currentPageIndex", pageIndex);
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
		
		//����Ϣ��ȡ��session���� ��Ϊ�������ض������� ����ֱ�Ӵ���ҳ�������request���� 
		session.setAttribute("pageAll", page);
		
		//�����ض���listҳ�� �����ǿͻ�����ת ���Ա���Ӹ�·��
		response.sendRedirect(request.getContextPath()+"/gradeManage.jsp");
		
	}
private void pageListName(HttpServletRequest request, HttpServletResponse response,String name) throws ServletException, IOException {
		
		String currentPageIndex = request.getParameter("currentPageIndex");
		
		int pageIndex = Integer.parseInt(currentPageIndex);
		
		int pageCount = service.getNamePageCount(5, name);
		
		if(pageIndex<1)
			pageIndex =1 ;
		if(pageIndex>pageCount)
			pageIndex=pageCount;
		
		Page page = service.getPageListByName(pageIndex, 5, name);
		page.setCurrentPageIndex(pageIndex);
		
		HttpSession session = request.getSession();
		Integer start = (Integer) session.getAttribute("startIndex");
		Integer end = (Integer) session.getAttribute("endIndex");
		
		//session.setAttribute("currentPageIndex", pageIndex);
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
		
		if(pageCount<5){
			session.setAttribute("endIndex", pageCount);
		}
			
		
		//����Ϣ��ȡ��session���� ��Ϊ�������ض������� ����ֱ�Ӵ���ҳ�������request���� 
		session.setAttribute("pageName", page);
		
		//�����ض���listҳ�� �����ǿͻ�����ת ���Ա���Ӹ�·��
		response.sendRedirect(request.getContextPath()+"/gradeManage.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
