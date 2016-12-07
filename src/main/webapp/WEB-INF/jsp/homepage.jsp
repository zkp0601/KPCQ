<!DOCTYPE html>
<%@ page language="java" contentType="textml; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=utf-8">
<script type="text/javascript"
			src='<c:url value="/static/js/jquery-1.8.2.min.js"></c:url>'></script>
<script type="text/javascript"
			src='<c:url value="/static/js/ajaxfileupload.js"></c:url>'></script>
<script type="text/javascript">
$(function(){
    var page=-1;
    $("#upload").click(function(){
        //var file_img = $('#file_img'), 
            img_tag = $('#show_img'),
            tip = $(".tip");
            $.ajaxFileUpload({
                url : 'homepage/uploadpicture',//用于文件上传的服务器端请求地址
                type:'post',
                fileElementId : 'file_img',
                dataType : 'json',//返回值类型 ,可以使xml、text、json、html 
                data:{description:"ffff"},              
                success : function(data) //服务器成功响应处理函数
                {
                	 var res=eval('('+data+')');   
                	 if(res.result=="false")
                	 alert(res.message);              	   
                    
                },
                error : function(data)//服务器响应失败处理函数
                {
                	console.log(data);
                    alert('异常，请联系网站维护人员！');
                }
            });
    });
    $("#show_img_button").click(function(){
    	page=page+1;
    	//alert(page);
    	$.ajax({
    		url:'homepage/showpicture',
    		type:'post',
    		datatype:'json', 		
    	     success : function(data) //服务器成功响应处理函数
             {
             	var img=[ $('#show_img1'), $('#show_img2'), $('#show_img3'), $('#show_img4'), $('#show_img5')];
             	var res=eval('('+data+')');    
             	for(var i=0;i<res.length;i++){
             	//	alert(res[i].photo_url);
             		img[i].attr('src',res[i].photo_url);
             		
             	}            	                   
             },
             error : function(data)//服务器响应失败处理函数
             {
             	console.log(data);
                 alert('异常，请联系网站维护人员！');
             }
         });  	
    });
});
</script>
<title>上传页面</title>
</head>
<body>
<input name="file" type="file" value="" id="file_img"/>
  <input type="submit" value="上传" name="upload" id="upload"  />
  <input type="button" value="我的图片" name="show_img" id="show_img_button"/>
        <p class="tip" >文件正在上传...</p>
        <div>
        <img id="show_img1"  src="" />
        <img id="show_img2" src=""/>
         <img id="show_img3"  src=""/>
          <img id="show_img4"  src=""/>
           <img id="show_img5"  src=""/>
           </div>

</body>
</html>