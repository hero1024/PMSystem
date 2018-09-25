<%@ page language="java" import="java.util.*"  
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/BeAlert.css" rel="stylesheet" >
    <title>个人评分与薪水查询</title>
    <style>
    .lb-control{
        position:relative;
        float:left;
        width:120px;
        font-size:20px;
    }
    .bt-posi-control{
        postiton:relative;
        float:left;
        margin-top:20px;
        margin-left:300px;
    }
    </style>
  </head>
  
  <body>
    <script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/BeAlert.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	
	<script type="text/javascript">
	

	
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
  
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="staffIndex.jsp"><span>人事管</span>理系统</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-pencil"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="staffInfo.jsp"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
							<li><a href="javascript:;" id="confirm"><span class="glyphicon glyphicon-pencil"></span> 注销</a></li>
						</ul>
					</li>
				</ul>
			</div>			
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li><a href="InfoqueryServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 评分与薪水查询</a></li>
			<li><a href="StaffInfoServlet?op=page&currentPageIndex=1"><span class="glyphicon glyphicon-pencil"></span> 个人信息</a></li>
			
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="staffIndex.jsp"><span class="glyphicon glyphicon-pencil"></span></a></li>
				<li class="active">评分与薪水查询</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">评分与薪水查询</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form id="formTest">
								<div class="row">
									<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control">业务成绩  :</label>			
			
													<div class="col-sm-8">
														<input type="text" id="form-field-1" placeholder="业务成绩" class="form-control" disabled="disabled" value="${staff.businessgrade }">
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control" for="form-field-1">品行成绩 :</label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-2" name="password" placeholder="品行成绩" class="form-control" disabled="disabled" value="${staff.behaviorgrade }">
													</div>
												</div>
											</div>
											
											</div>
											<br>
											<div class="row">
											
											
											<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control" for="form-field-1">薪水 :</label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-3" placeholder="薪水" class="form-control" disabled="disabled" value="${staff.salary}">
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<label class="lb-control" for="form-field-1">奖金 :</label>
			
													<div class="col-sm-8">
														<input type="text" id="form-field-3" placeholder="奖金" class="form-control" disabled="disabled" value="${staff.reward}">
													</div>
												</div>
											</div>
											
											</div>
											
											</form>
											</div>
											</div>
											</div>
	</div>
  </body>
</html>
