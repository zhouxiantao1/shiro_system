<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
   <%@include file="/WEB-INF/jsp/include/head.jsp" %>
	<link href="${pageContext.request.contextPath}/static/treeTable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/static/treeTable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/static/treeTable/jquery.treetable.js" type="text/javascript"></script>
</head>

<body class="theme-blue">
   
   <%@include file="/WEB-INF/jsp/include/top.jsp" %>
   <%@include file="/WEB-INF/jsp/include/left.jsp" %>
  
      <div class="content">
		<div class="header">

			<h1 class="page-title">区域管理</h1>
			<ul class="breadcrumb">
				<li><a href="/">story管理</a></li>
				<li class="active">区域列表</li>
			</ul>

		</div>
		<div class="main-content">

			<div class="btn-toolbar list-toolbar">
				<button class="btn btn-primary">
					<a href="${pageContext.request.contextPath}/storyArea/toAdd"><i class="fa fa-plus"></i>新增</a>
				</button>
				<button class="btn btn-default">导入</button>
				<button class="btn btn-default">导出</button>
				<div class="btn-group"></div>
			</div>
			<table class="table treetable" id="treeTable">
				<thead>
					<tr>
						<th class="th_width_first">区域名称</th>
						<th class="th_width_second">区域介绍</th>
						<th class="th_width_last">是否可用</th>
						<th class="th_width_last">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${storyAreaTrees}" var="storyAreaTrees" varStatus="status">
						<tr data-tt-id='${storyAreaTrees.areaParentids}' data-tt-parent-id='${storyAreaTrees.areaParent}'>
							<td>${storyAreaTrees.areaName}</td>
							<td>${storyAreaTrees.areaDescription}</td>
							<td>
							<c:choose>
		                         <c:when test="${storyAreaTrees.available=='0'}"><font style="color: green;">使用</font></c:when>
		                         <c:otherwise><font style="color: red;">禁用</font></c:otherwise>
		                    </c:choose>
                   			</td>
							<td class="user_list">
								<a href="user.html"><i class="fa fa-pencil"></i></a>
								<a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o" onClick="delStoryPerson('${storyAreaTrees.id}')"></i></a>
								<a href="${pageContext.request.contextPath}/storyArea/toAdd?areaParentids=${storyAreaTrees.areaParentids}" role="button" data-toggle="modal">添加下级</i></a>
							</td>
						</tr>
						<c:forEach items="${storyAreaTrees.children}" var="children" varStatus="status1">
							<tr data-tt-id='${children.areaParentids}' data-tt-parent-id='${children.areaParent}'>
								<td>${children.areaName}</td>
								<td>${children.areaDescription}</td>
								<td>
								<c:choose>
			                         <c:when test="${children.available=='0'}"><font style="color: green;">使用</font></c:when>
			                         <c:otherwise><font style="color: red;">禁用</font></c:otherwise>
			                    </c:choose>
	                   			</td>
								<td class="user_list">
									<a href="user.html"><i class="fa fa-pencil"></i></a>
									<a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o" onClick="delStoryPerson('${children.id}')"></i></a>
									<a href="${pageContext.request.contextPath}/storyArea/toAdd?areaParentids=${children.areaParentids}" role="button" data-toggle="modal">添加下级</i></a>
								</td>
							</tr>
						</c:forEach>
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

			<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
							<h3 id="myModalLabel">删除成功</h3>
						</div>
						<div class="modal-body">

							<p >
								<i><img src="${pageContext.request.contextPath}/static/images/icon/succeed.png"></i></br></br>
								删除成功
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" data-dismiss="modal" aria-hidden="true">确定</button>
						</div>
					</div>
				</div>
			</div>


			<%@include file="/WEB-INF/jsp/include/foot.jsp" %>
		</div>
	</div>
   <!-- END FOOTER -->
   <script type="text/javascript">   
   		$(document).ready(function() {
	   		$("#treeTable").treetable({ expandable: true });
		});
   		
	   function delStoryPerson(id){
		   $.ajax({
       		type: 'POST',
	       		async: true,
	       		data: { 
	       			id: id
	       			},
	       		url:"${pageContext.request.contextPath}/storyArea/del",
	       		success:function(result){ 			
	       			$('#myModal').modal();
	   			}
	       	});
		}		
   
	   $(".btn-success").click(function(){
		   window.location.reload();
			 
		});
    </script>
</body>
</html>
