<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>登录并授权</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/jquery-1.11.1.min.js"></script>
</head>
 <script type="text/javascript">
 
   // 微博登录 
   function loginWeibo(){
      // weiboAuthWin = window.open("https://api.weibo.com/oauth2/authorize?client_id=3472698345&response_type=code&redirect_uri=http://172.16.19.118:8090/shiro_system/weibogetlogin",
     //            '微博授权登录','width=770,height=600,menubar=0,scrollbars=1,'+
     //  'resizable=1,status=1,titlebar=0,toolbar=0,location=1');
       window.location.replace("https://api.weibo.com/oauth2/authorize?client_id=3472698345&response_type=code&redirect_uri=http://172.16.19.118:8090/shiro_system/weibogetlogin");
   }
   
   //关闭微博子窗口
   function closeWeiboWin(){
       var result = $("#weibo").val();
       if(result != ""){
           console.log(result);
           weiboAuthWin.close();
       }else{
           console.log("值为空");
       }
   }
 </script>
<body>

	<br>
	<input type="hidden" id="weibo" value="">
	<a href="#" onClick="loginWeibo()">微博登录</a>
	
</body>
</html>