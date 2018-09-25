<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
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
    input {
    width: 150px;
    height: 32px;
    margin-top: 5px;
    padding: 0 15px;
    background: #2d2d2d; /* browsers that don't support rgba */
    background: rgba(45,45,45,.15);
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #3d3d3d; /* browsers that don't support rgba */
    border: 1px solid rgba(255,255,255,.15);
    -moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    -webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}
</style>
<script src="assets/js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">  
      
        var xmlHttp = null;  
          
        //声明XMLHttpRequest对象函数  
        function getXMLHttp()  
        {     
            try{  
                //fireFox、Opera、Safari  
                xmlHttp = new XMLHttpRequest();  
            }catch(e){  
                try{  
                    //IE6.0+  
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  
                }catch(e){  
                    try{  
                        //IE5.5+  
                        xmlHttp = xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");  
                    }catch(e){  
                        alert("你的浏览器不支持AJAX!");  
                        return false;  
                    }  
                }  
            }  
            return xmlHttp;  
        }  
          
        //验证函数  
        function check()  
        {  
            var userName = document.getElementById("username").value;  
          
      
            var xmlHttp = getXMLHttp();  
              
            xmlHttp.open("POST","CheckAction?tt="+Math.random(),true);   
            xmlHttp.onreadystatechange = handleResult;  
            xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");  
            xmlHttp.send("username="+userName);  
          
        }
        
        function checkPassword(){
        	var password = document.getElementById("password").value;
        	var repassword = document.getElementById("repassword").value;
        	
        	if(password!=repassword){
        		document.getElementById("repasswordInfo").innerHTML = "<font color='red'>两次的密码不一致!</font>";
        		
        		document.getElementById("submit").disabled = "disabled";
        	}else{
        		document.getElementById("repasswordInfo").innerHTML ="";
        		
        		document.getElementById("submit").disabled = "";
        	}
        	
        }
        
          
        //返回结果处理  
        function handleResult()  
        {     
            if(xmlHttp.readyState == 4)  
            {  
                if(xmlHttp.status == 200)  
                {  
                    document.getElementById("nameInfo").innerHTML = xmlHttp.responseText;  
                    //document.getElementById("passwordInfo").innerHTML = xmlHttp.responseText;  
                }  
            }  
        }  
    </script>  
<style>
    .formClass{
        position:fixed;
        left:40%;
    }

</style>


<body>
<h1 align="center"><strong>用户注册</strong></h1><br>
<hr width="90%"><br>
<div class="formClass">
    <form id="formname" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    <table>
    <tr><td align="center"><strong>&nbsp;用户名&nbsp;:</strong></td>
    <td><input type="text" id="username" name="username" onblur="check()"><span id="nameInfo"></span></td>
    </tr>
    <tr></tr>
    <tr><td align="center"  ><strong>&nbsp;密&nbsp;码&nbsp;:</strong></td>
    <td><input type="password" id="password" name="password"><span id="passwordInfo"></span></td></tr>
    <tr><td align="center"  ><strong>&nbsp;确认密码&nbsp;:</strong></td>
    <td><input type="password" id="repassword" name="repassword" onblur="checkPassword()"><span id="repasswordInfo"></span></td></tr>  
    <tr><td><input type="submit" value="注册" name="submit" id="submit" width="50px"></td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" width="50px"></td></tr>
       </table>
    <br>
    
    </form>
</div>
</body>
</html>