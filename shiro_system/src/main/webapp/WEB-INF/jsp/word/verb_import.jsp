<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入excel</title>
</head>
<body>
<h1>导入excel动词表</h1>

<form method="post" action="${pageContext.request.contextPath}/words/import" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="file" />
	<input type="submit" value="上传" />
</form>
</body>
</html>