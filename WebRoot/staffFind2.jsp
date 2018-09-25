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



</head>

<body>
<input type="hidden" id="pagecount" value="${page.pagecount}">
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
			<!--<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
						</a>
					</li>
				</ul>
			</li>
		</ul> -->
		
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="hrsIndex.jsp"><span class="glyphicon glyphicon-pencil"></span></a></li>
				<li class="active">员工评分管理</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">员工评分管理</h1>
			</div>
		</div><!--/.row-->
		
		<div >
			<div>
				<div class="col-xs-12 ">
					<form action="${pageContext.request.contextPath}/GradeManageServlet?op=find&currentPageIndex=1" id="findform" method="post">
						<div class="row">
							
							
							<div class="col-sm-5">
								<div>
									<label class="lb-control">员&nbsp;工&nbsp;编&nbsp;号:</label>
									<div class="col-sm-9">
										<input type="text" name="id" id="id"  placeholder="员工编号"  class="form-control date_calendar" >
									</div>
								</div>
							</div>
							<div class="col-sm-5" >
								<div class="form-group">
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

				<div class="col-xs-12">

					<div class="row">
						<div class="a-width">
							<div class="dataTables_info" id="sample-table-2_info">
								<div>
									<a class="btn btn-info" href="${pageContext.request.contextPath }/addStaff.jsp"> 添加员工
									</a>
								</div>
							</div>
						</div>				
						<div class="a-width">
						<div class="dataTables_info" id="sample-table-2_info">
								<div>
									<a class="btn btn-info" href="javascript:delmore()"> 批量删除
									</a>
								</div>
							</div>
						</div>
					</div>




					<div class="table-responsive">
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center"><input type="checkbox" id="all" onclick="checkall(this.checked)">选择</th>
									<th>员工编号</th>
									<th>姓名</th>
									<th>业务评分</th>
									<th>品行评分</th>
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
										<td>${staff.businessgrade}</td>
										<td>${staff.behaviorgrade }</td>
										<td>
											<div>
												 <a href="${pageContext.request.contextPath }/InfoManageServlet?op=edit&id=${staff.id}" > 编辑</a>
												 <a  class="delete_a" data-did="${staff.id }" href="javascript:void(0);"> 删除</a>
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
	
	function delmore(){
		confirm("是否删除被选中学生学籍?","删除学籍将无法恢复!",function (isConfirm) {
            if (isConfirm) {
            	var ids =  document.getElementsByName("ids");
            	var s = "";
            	for(var i=0;i<ids.length;i++){
            		if(ids[i].checked){
            			s += ids[i].value+",";
            		}
            	}
            	
            	//将数据传递到服务端进行删除
            	window.location = "${pageContext.request.contextPath }/InfoManageServlet?op=delmore&ids="+s+"&currentPageIndex=${pageAll.currentPageIndex}";
            	
            	} else {
                //after click the cancel
            }
        }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
    }
	
	 function checkall(flag){
	    	//拿到所有的记录
	    	var ids =  document.getElementsByName("ids");
	    	for(var i=0;i<ids.length;i++){
	    		ids[i].checked = flag;
	    	}
	    	
	    }
	
	 $(".delete_a").on('click',function(){
		     var id=$(this).data('did');
		     var url="InfoManageServlet?op=delete&currentPageIndex=${pageAll.currentPageIndex}&id="+id;
		     confirm("是否删除该学生成绩?","删除成绩将无法恢复!",function (isConfirm) {
                 if (isConfirm) {
                	location.href=url;
                 } else {
                     //after click the cancel
                 }
             }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
		     
		 });
	 
	 
	
	
	function aJump(index){
		var pagecount =  document.getElementById("gradePageCount").value;
    	var index = document.getElementById("pageindex").value;
    	if(index !=""){
    		if(isNaN(index) || index>pagecount){
    			alert("输入的数据不合法");
    			return;
    		}
    	}
    	window.location.href="${pageContext.request.contextPath }/InfoManageServlet?op=page&currentPageIndex="+index+"&currentPageIndex=${pageAll.currentPageIndex}";
    }
    
    function selectJump(index){
    	window.location.href="${pageContext.request.contextPath }/InfoManageServlet?op=page&currentPageIndex="+index+"&currentPageIndex=${pageAll.currentPageIndex}";
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
			