<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>addUser</title>  
</head>  
<body>  
    <h1>addUser</h1>  
    <form id="" action="/shiro_system/user/add" method="post">  
        <label>用户名</label> <input tyep="text" name="username" maxLength="40" /></br> 
        <label>密码</label><input type="password" name="password" /> 
        <input type="submit" value="addUser" />  
    </form>
</body>  
</html> 