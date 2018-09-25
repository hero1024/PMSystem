<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>人事管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/BeAlert.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="datetimepicker/css/jquery-ui-1.9.2.custom.min.css" />
<link rel="stylesheet" type="text/css" href="datetimepicker/css/jquery-ui-timepicker-addon.css" />
 
<style>
.lb-control{
    font-size:19px;
}
</style>



</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="main.jsp"><span>人事管</span>理系统</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-pencil"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="panels.jsp"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
							<li><a href="javascript:;" id="confirm"><span class="glyphicon glyphicon-pencil"></span> 注销</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<li><a href="InfoManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工信息管理</a></li>
			<li><a href="GradeManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工评分管理</a></li>
			<li><a href="SalaryManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 员工薪水管理</a></li>
			<li><a href="AuthManageServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 权限管理</a></li>
			<li><a href="HrsInfoServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
			
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="hrsIndex.jsp"><span class="glyphicon glyphicon-pencil"></span></a></li>
				<li class="active">员工信息管理</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" align="center">员工添加</h1>
			</div>
		</div><!--/.row-->
		<div align="center">
		<form action="${pageContext.request.contextPath}/InfoManageServlet?op=add" method="post">
		    <table>
		    <tr>
		        <td><label class="lb-control">员&nbsp;工&nbsp;编&nbsp;号&nbsp;:</label></td>
		        <td><input name="id" type="text" ></td>
		    </tr>
		    		    <tr>
		        <td><label class="lb-control">用&nbsp;户&nbsp;名&nbsp;:</label></td>
		        <td><input name="username"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">密&nbsp;码&nbsp;:</label></td>
		        <td><input name="password"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">姓&nbsp;名&nbsp;:</label></td>
		        <td><input name="name" type="text" ></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">性	&nbsp;别&nbsp;:</label></td>
		        <td><input name="sex"type="text" ></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">部&nbsp;门&nbsp;:</label></td>
		        <td><input name="department"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">住&nbsp;址&nbsp;:</label></td>
		        <td><input name="location"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">业&nbsp;务&nbsp;评&nbsp;分&nbsp;:</label></td>
		        <td><input name="businessgrade"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">品&nbsp;行&nbsp;评&nbsp;分&nbsp;:</label></td>
		        <td><input name="behaviorgrade"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">薪&nbsp;水&nbsp;:</label></td>
		        <td><input name="salary"type="text"></td>
		    </tr>
		    <tr>
		        <td><label class="lb-control">奖&nbsp;金&nbsp;:</label></td>
		        <td><input name="reward"type="text"></td>
		    </tr>
		    </table>
		    <input type="submit" value="添加">
		    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input onclick="bereturn()" type="button" value="返回">
		</form>
		</div>


	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/BeAlert.js"></script>
	<script src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="datetimepicker/js/jquery-ui-1.9.2.core.min.js"></script>
	<script type="text/javascript" src="datetimepicker/js/jquery-ui-1.9.2.datatimeSlider.min.js"></script>
	<script type="text/javascript" src="datetimepicker/js/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="datetimepicker/js/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript" src="datetimepicker/js/jquery.ui.datepicker-zh-CN.js"></script>
	
	
	
	<script>
	
	function bereturn(){
		location.href="InfoManageServlet?op=page&currentPageIndex=1";
	}
	
	$(function() {
		equip_add.initial();
	});
	var equip_add = {
		initial : function initial() {
			
			//时间插件
			$('.date_calendar').datetimepicker({
			    timeFormat: "HH:mm:ss",
			    dateFormat: "yy-mm-dd",
				showSecond:true,
				beforeShow:function(input){
					$(input).css({
						"position":"relative",
						"z-index":9999
					});
				} 
			});
		}
	}
	
	
	
	
        $(function () {
            $("#confirm").click(function () {
                confirm("是否退出登录?","退出登录将返回到登录界面!",function (isConfirm) {
                    if (isConfirm) {
                        location.href="login.jsp";
                    } else {
                        //after click the cancel
                    }
                }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
            });
        });
	</script>	
</body>

</html>
