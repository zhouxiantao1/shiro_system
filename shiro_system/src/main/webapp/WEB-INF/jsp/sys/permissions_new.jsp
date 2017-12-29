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
			<h1 class="page-title">权限编辑</h1>
			<ul class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">主页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/permission/list">权限列表</a>
				</li>
				<li class="active">编辑权限</li>
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
									<label>权限描述</label> <input type="text" placeholder="例如：用户管理"
										id="description" class="form-control">
								</div>
								<div class="form-group">
									<label>权限标识</label> <input type="text"
										placeholder="例如：sys:user:list" id="permission"
										class="form-control">
								</div>
								<div class="form-group">
									<label>是否可用</label> <select name="available" id="available"
										class="form-control">
										<option value="0">使用</option>
										<option value="1">禁用</option>
									</select>
								</div>
								<div class="form-group" hidden="hidden">
									<label>父类id</label> <input type="text" id="parentId"
										value="${permission.parentId}" class="form-control">
								</div>
								<div class="form-group" hidden="hidden">
									<label>status</label> <input type="text" value="${status}"
										id="status" class="form-control">
								</div>
							</form>
						</div>
					</div>

					<div class="btn-toolbar list-toolbar">
						<button id="save_permissions" class="btn btn-primary">
							<i class="fa fa-save"></i> 保存
						</button>
						<a href="#myModal" data-toggle="modal" class="btn btn-danger">取消</a>
					</div>
				</div>
			</div>

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
								delete the user?
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
			<%@include file="/WEB-INF/jsp/include/foot.jsp"%>
		</div>
	</div>

	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        
        $("#save_permissions").click(function(){
        	$.ajax({
        		type: 'POST',
        		async: true,
        		data: { 
	        			description: $("#description").val(), 
	        			permission: $("#permission").val(), 
	        			available:$("#available").val(),
	        			status:$("#status").val(),
	        			parentId:$("#parentId").val(),
        			},
        		url:"${pageContext.request.contextPath}/permission/add",
        		success:function(result){
        			alert("保存成功");
        			window.location.href="${pageContext.request.contextPath}/permission/list";
    			}
        	});
        });
    </script>


</body>
</html>
