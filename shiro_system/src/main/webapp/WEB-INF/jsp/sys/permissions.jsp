<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<%@include file="/WEB-INF/jsp/include/head.jsp" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/user.css">
<link href="${pageContext.request.contextPath}/static/treeTable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/treeTable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/css/permissions.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/static/treeTable/jquery.treetable.js" type="text/javascript"></script>

</head>
<body class="theme-blue">

	<%@include file="/WEB-INF/jsp/include/top.jsp" %>
    <%@include file="/WEB-INF/jsp/include/left.jsp" %>

	<script type="text/javascript">
        
        $(document).ready(function() {
        	$("#treeTable").treetable({ expandable: true });
		});
    </script>


	<div class="content">
		<div class="header">
			<h1 class="page-title">权限管理</h1>
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">主页</a></li>
				<li class="active">权限列表</li>
			</ul>
		</div>
		<div class="main-content">

			<div class="btn-toolbar list-toolbar">
				<button class="btn btn-primary">
					<a class="color_white" href="${pageContext.request.contextPath}/permission/get?status=1"><i class="fa fa-plus"></i> 新增</a>
				</button>
				<button class="btn btn-default">Import</button>
				<button class="btn btn-default">Export</button>
				<div class="btn-group"></div>
			</div>
			<table class="table" id="treeTable">
				<thead>
					<tr>
						<th class="th_width_first">权限介绍</th>
						<th class="th_width_second">权限标识</th>
						<th class="th_width_last">是否可用</th>
						<th class="th_width_last"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${permissionList}" var="permission" varStatus="status">
						<tr data-tt-id='${permission.parentIdsAndId}' data-tt-parent-id='${permission.parentIds}'>
							<td>${permission.description}</td>
							<td>${permission.permission}</td>
							<td>
							<c:choose>
		                         <c:when test="${permission.available=='0'}"><font style="color: green;">使用</font></c:when>
		                         <c:otherwise><font style="color: red;">禁用</font></c:otherwise>
		                    </c:choose>
                   			</td>
							<td class="user_list">
								<a href="user.html"><i class="fa fa-pencil"></i></a>
								<a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
								<a href="${pageContext.request.contextPath}/permission/get?parentId=${permission.id}&status=1" role="button" data-toggle="modal">添加下级</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 弹出框 -->
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
