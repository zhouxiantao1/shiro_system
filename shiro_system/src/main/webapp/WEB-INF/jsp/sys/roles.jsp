<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<%@include file="/WEB-INF/jsp/include/head.jsp" %>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/user.css">


</head>
<body class=" theme-blue">

	<%@include file="/WEB-INF/jsp/include/top.jsp" %>
    <%@include file="/WEB-INF/jsp/include/left.jsp" %>

	<div class="content">
		<div class="header">
			<h1 class="page-title">角色管理</h1>
			<ul class="breadcrumb">
				<li><a href="/">主页</a></li>
				<li class="active">角色列表</li>
			</ul>
		</div>
		<div class="main-content">

			<div class="btn-toolbar list-toolbar">
				<button class="btn btn-primary">
					<i class="fa fa-plus"></i> New User
				</button>
				<button class="btn btn-default">Import</button>
				<button class="btn btn-default">Export</button>
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th class="row_line">#</th>
						<th class="row_line">角色名称</th>
						<th class="row_line">角色描述</th>
						<th class="row_line">是否可用</th>
						<th style="width: 10em;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roles}" var="role" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${role.role}</td>
							<td>${role.description}</td>
							<td><c:choose>
		                         <c:when test="${role.available=='0'}"><font style="color: green;">使用</font></c:when>
		                         <c:otherwise><font style="color: red;">禁用</font></c:otherwise>
		                   </c:choose></td>
							<td class="user_list"><a href="${pageContext.request.contextPath}/role/get"><i class="fa fa-pencil"></i></a> 
							<a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>

			<div class="modal small fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">Ã</button>
							<h3 id="myModalLabel">Delete Confirmation</h3>
						</div>
						<div class="modal-body">
							<p class="error-text">
								<i class="fa fa-warning modal-icon"></i>Are you sure you want to
								delete the user?<br>This cannot be undone.
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-default" data-dismiss="modal"
								aria-hidden="true">Cancel</button>
							<button class="btn btn-danger" data-dismiss="modal">Delete</button>
						</div>
					</div>
				</div>
			</div>


			<%@include file="/WEB-INF/jsp/include/foot.jsp" %>
		</div>
	</div>
</body>
</html>
