<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<%@include file="/WEB-INF/jsp/include/head.jsp"%>

</head>
<body class=" theme-blue">

	<%@include file="/WEB-INF/jsp/include/top.jsp"%>
	<%@include file="/WEB-INF/jsp/include/left.jsp"%>

	<div class="content">
		<div class="header">

			<h1 class="page-title">编辑人物</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">story管理</a></li>
				<li><a href="users.html">人物列表</a></li>
				<li class="active">编辑</li>
			</ul>

		</div>
		<div class="main-content">

			<div class="row">
				<div class="col-md-4">
					<br>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form id="tab">
								<div class="form-group">
									<label>人物姓名</label> <input type="text" id="personName" value="
Expression data is undefined on line 34, column 137 in detailjsp.ftl.
The problematic instruction:
----------
==> ${data.personName} [on line 34, column 135 in detailjsp.ftl]
----------

Java backtrace for programmers:
----------
freemarker.core.InvalidReferenceException: Expression data is undefined on line 34, column 137 in detailjsp.ftl.
	at freemarker.core.TemplateObject.assertNonNull(TemplateObject.java:124)
	at freemarker.core.TemplateObject.invalidTypeException(TemplateObject.java:134)
	at freemarker.core.Dot._getAsTemplateModel(Dot.java:78)
	at freemarker.core.Expression.getAsTemplateModel(Expression.java:89)
	at freemarker.core.Expression.getStringValue(Expression.java:93)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:76)
	at freemarker.core.Environment.visit(Environment.java:209)
	at freemarker.core.MixedContent.accept(MixedContent.java:92)
	at freemarker.core.Environment.visit(Environment.java:209)
	at freemarker.core.Environment.process(Environment.java:189)
	at freemarker.template.Template.process(Template.java:237)
	at com.example.freemake.generate.MyFreeMarker.CreateDetailJSP(MyFreeMarker.java:550)
	at com.example.freemake.generate.MyFreeMarker.CreateFile(MyFreeMarker.java:101)
	at com.example.freemake.util.Test.main(Test.java:10)
