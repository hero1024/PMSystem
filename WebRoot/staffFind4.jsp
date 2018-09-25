<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
 .lb-control{
        position:relative;
        float:left;
        width:90px;
        font-size:19px;
    }
    .a-width{
        width:auto;
        position:relative;
        float:left;
        left:15px;   
    }
    
</style>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>权限管理</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/BeAlert.css" rel="stylesheet" >
<link rel="stylesheet" type="text/css" href="datetimepicker/css/jquery-ui-1.9.2.custom.min.css" />
<link rel="stylesheet" type="text/css" href="datetimepicker/css/jquery-ui-timepicker-addon.css" />

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="hrsIndex.jsp"><span>人事管</span>理系统</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-pencil"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="HrsInfoServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
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
				<li class="active">权限管理</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">权限管理</h1>
			</div>
		</div><!--/.row-->
		
		<div>
			<div>
				<div class="col-xs-12 ">
					<form action="${pageContext.request.contextPath}/AuthManageServlet?op=find&currentPageIndex=1" id="findform" method="post">
						<div class="row">
							<div class="col-sm-5">
								<div>
									<label class="lb-control">编&nbsp;号:</label>
									<div class="col-sm-9">
										<input type="text" name="id" id="id"  placeholder="员工编号"  class="form-control date_calendar" >
									</div>
								</div>
							</div>
							<div class="col-sm-5" >
								<div class="form-group">
									<!-- <label class="lb-control">员&nbsp;工&nbsp;姓&nbsp;名:</label>
									<div class="col-sm-9">
										<input type="text" name="name" id="name"  placeholder="员工姓名" class="form-control">
									</div> -->
									<button class="btn btn-primary" type="submit">
										<i class="icon-ok bigger-110"></i> 查询
									</button>
									
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-info" type="reset">
										<i class="icon-undo bigger-110"></i> 重置
									</button>
								</div>
							</div>
							
						</div>
						<br />
						
					</form>
				</div>				

				<div class="col-xs-12">

					<div class="table-responsive">
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center"><input type="checkbox" id="all" onclick="checkall(this.checked)">选择</th>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>部门</th>
									<th class="hidden-480">操作</th>

								</tr>
							</thead>
                    <c:choose>
                    <c:when test="${empty staff}" >
                        <tr>
                        <td colspan="10" align="center">查无此人</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
							<tbody>
									<tr>
										<td ><label> <input type="checkbox" name="ids" id="ids" value="${staff.id}" /> <span class="lbl"></span>
										</label></td>
										<!-- <td>${(pageAll.currentPageIndex-1)*5+status.index +1 }</td> -->
										<td>${staff.id}</td>
										<td>${staff.name }</td>
										<td>${staff.sex }</td>
										<td>${staff.department}</td>
										<td>
											<div>
												 <a href="${pageContext.request.contextPath }/AuthManageServlet?op=edithrs&id=${staff.id}" > hrs</a>
												 <a href="${pageContext.request.contextPath }/AuthManageServlet?op=editstaff&id=${staff.id}" > staff</a>
											</div>
										</td>
									</tr>
							</tbody>
							</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
			</div>
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
	
	 function checkall(flag){
	    	//拿到所有的记录
	    	var ids =  document.getElementsByName("ids");
	    	for(var i=0;i<ids.length;i++){
	    		ids[i].checked = flag;
	    	}
	    	
	    }
	 
	
	
	function aJump(index){
		var pagecount =  document.getElementById("gradePageCount").value;
    	var index = document.getElementById("pageindex").value;
    	if(index !=""){
    		if(isNaN(index) || index>pagecount){
    			alert("输入的数据不合法");
    			return;
    		}
    	}
    	window.location.href="${pageContext.request.contextPath }/AuthManageServlet?op=page&currentPageIndex="+index+"&currentPageIndex=${pageAll.currentPageIndex}";
    }
    
    function selectJump(index){
    	window.location.href="${pageContext.request.contextPath }/AuthManageServlet?op=page&currentPageIndex="+index+"&currentPageIndex=${pageAll.currentPageIndex}";
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
			