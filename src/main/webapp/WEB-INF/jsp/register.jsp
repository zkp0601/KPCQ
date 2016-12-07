<!DOCTYPE html>
<%@ page language="java" contentType="textml; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>注册页面</title>      
</head>

<body>
<p>欢迎注册！请填写一下信息 </p>
<div>
	<table  class="register_table">
		<caption>注册信息</caption>
			<tr>
				<td>用户名</td> <td><input type="text"class="input_style" name="userName"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td>用户密码 </td> <td> <input type="password"class="input_style" name="userPassword"> </td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td>电子邮箱</td> <td> <input type="text"class="input_style" name="userEmail"> </td>
			</tr>
	</table>    &nbsp;
	<div align="center">
		<input type="button" class="button_finish" id="finish_register" value="完成注册 ">
	</div>
</div>
</body>
</html>
<script type="text/javascript" src='<c:url value="/static/js/jquery-1.8.2.min.js"></c:url>'></script>
<script type="text/javascript">
$(function(){
	    $(".input_style").focus(function(){	    
	        var text=$(this).val();
	        if(text!=""){
	            $(this).val("");
	            $(".input_style").css({"backgroud-color":"white"});
	        }
	     });
	    $(".input_style").blur(function(){
	        $(".input_style").css("backgroud-color","red");
	         
	    })
	$("#finish_register").click(function(){
		 var nameValue = $("*[name='userName']").val();
		 var passValue=$("*[name='userPassword']").val();
		 var emailValue=$("*[name='userEmail']").val();
		 if(nameValue == "" || passValue ==""){
			 alert("用户名或密码不能为空");
			 return;
		 }
		 else{
			 $.ajax({
				    url:'register/register_submit', 
				   data:{userName:nameValue, userPass:passValue,userEmail:emailValue},
				type:'post',
				datatype:'json',
				success : function(data){
					
					if(data== "true"){
						window.location.href="homepage";
					}else{
						alert(data);
					}
					return;
				},		
				error : function(e){
					alert("系统错误");
				}
				
			 });
		 }		 		
	});
})
</script>
<script src='<c:url value="/static/js/jquery.min.js"></c:url>' />
<script src='<c:url value="/static/js/bootstrap.min.js"></c:url>' />