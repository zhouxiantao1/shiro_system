<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>token验证</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/accessToken" method="post">
   client_id：<input type="text" name="client_id" value="c1ebe466-1cdc-4bd3-ab69-77c3561b9dee"><br/>
   client_secret：<input type="text" name="client_secret" value="d8346ea2-6017-43ed-ad68-19c0f971738b"><br/>
   grant_type<input type="text" name="grant_type" value="authorization_code"><br/> 
   code<input type="text" name="code" value="828beda907066d058584f37bcfd597b6"><br/> 
   redirect_uri<input type="text" name="redirect_uri" value="http://localhost:8090/shiro_system/oauth2login"><br/>
   <input type="submit" value="登录并授权">
</form>

</body>
</html>