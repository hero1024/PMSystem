<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果</title>
</head>
<style>
     body{
background-image:url(images/bg.jpg);

    /* 背景图垂直、水平均居中 */
background-position: center center;
 
/* 背景图不平铺 */
background-repeat: no-repeat;
 
/* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
background-attachment: fixed;
 
/* 让背景图基于容器大小伸缩 */
background-size: cover;
 
/* 设置背景颜色，背景图加载过程中会显示背景色 */
background-color: #464646;
    }
</style>
<body >
<div align="center">
<c:choose>
<c:when test="${flag =='success'}"><h1><font color="red">注册成功!(三秒后返回登录界面)</font></h1>
<%  
   response.setHeader("refresh","3;url="+request.getContextPath()+"/login.jsp");//定时刷新  
 %>  
 </c:when>
<c:otherwise><h1><font color="red">注册失败!(三秒后返回注册界面)</font></h1>
<%
response.setHeader("refresh","3;url="+request.getContextPath()+"/register.jsp");
%>
</c:otherwise>
</c:choose>
</div>
</body>
</html>