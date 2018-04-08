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

			<h1 class="page-title">新增区域</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">story管理</a></li>
				<li><a href="users.html">区域列表</a></li>
				<li class="active">新增</li>
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
									<label>区域名称</label> <input type="text" id="areaName" class="form-control">
								</div>
								<div class="form-group">
									<label>区域描述</label> <input type="text" id="areaDescription" class="form-control">
								</div>
								<div class="form-group">
									<label>是否可用</label> <select name="available" id="available"
										class="form-control">
										<option value="0">使用</option>
										<option value="1">禁用</option>
									</select>
								</div>
								<div class="form-group" hidden="hidden">
									<label>父类id</label> <input type="text" id="areaParentids"
										value="${storyArea.areaParentids}" class="form-control">
								</div>
							</form>
						</div>
					</div>

					<div class="btn-toolbar list-toolbar">
						<button class="btn btn-primary" id="save_storyPerson">
							<i class="fa fa-save"></i> 保存
						</button>
						<a class="btn btn-danger cancel_storyArea">取消</a>
					</div>
				</div>
			</div>

			<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
							<h3 id="myModalLabel">保存成功</h3>
						</div>
						<div class="modal-body">

							<p >
								<i><img src="${pageContext.request.contextPath}/static/images/icon/succeed.png"></i></br></br>
								保存成功
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-success" data-dismiss="modal" aria-hidden="true">继续添加</button>
							<button  class="btn btn-primary cancel_storyPerson">返回列表</button>
						</div>
					</div>
				</div>
			</div>


			<%@include file="/WEB-INF/jsp/include/foot.jsp"%>
		</div>
	</div>
	
	<script type="text/javascript">
	 $(".cancel_storyArea").click(function(){
		 window.location.href="${pageContext.request.contextPath}/storyArea/toList";
		 
	 });
	
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        
        $("#save_storyPerson").click(function(){
        	$.ajax({
        		type: 'POST',
        		async: true,
        		data: { 
        				areaName: $("#areaName").val(), 
        				areaDescription: $("#areaDescription").val(), 
	        			available:$("#available").val(),
	        			areaParent:$("#areaParentids").val(),
        			},
        		url:"${pageContext.request.contextPath}/storyArea/add",
        		success:function(result){
        			alert("保存成功");
        			window.location.href="${pageContext.request.contextPath}/storyArea/toList";
    			}
        	});
        });
    </script>
</body>
</html>
