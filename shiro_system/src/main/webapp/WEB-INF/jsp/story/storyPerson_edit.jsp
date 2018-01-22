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
									<label>人物姓名</label> <input type="text" id="personName" value="${data.personName}" class="form-control" required="required">
								</div>
								<div class="form-group">
									<label>人物年龄</label> <input type="text" id="personAge" value="${data.personAge}" class="form-control" required="required">
								</div>
								<div class="form-group">
									<label>人物性别</label> <input type="text" id="personGender" value="${data.personGender}" class="form-control" required="required">
								</div>
								<div class="form-group">
									<label>肖像特征</label> <input type="text" id="facialKey" value="${data.facialKey}" class="form-control" required="required">
								</div>

								<div class="form-group">
									<label>人物肖像</label>
									<textarea  rows="6" id="personFacial" class="form-control" required="required">${data.personFacial}</textarea>
								</div>
							</form>
						</div>
					</div>

					<div class="btn-toolbar list-toolbar">
						<button class="btn btn-primary" id="save_storyPerson">
							<i class="fa fa-save"></i> 保存
						</button>
						<a class="btn btn-danger cancel_storyPerson">取消</a>
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
							<button  class="btn btn-primary cancel_storyPerson">返回列表</button>
						</div>
					</div>
				</div>
			</div>


			<%@include file="/WEB-INF/jsp/include/foot.jsp"%>
		</div>
	</div>
	
	<script type="text/javascript">
	 $(".cancel_storyPerson").click(function(){
		 window.location.href="${pageContext.request.contextPath}/storyPerson/toList";
		 
	 });
	
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        
        
        $("#save_storyPerson").click(function(){
        	var id = ${data.id};
        	$.ajax({
        		type: 'POST',
        		async: true,
        		data: { 
        			id:id,
        			personName: $("#personName").val(), 
        			personAge: $("#personAge").val(), 
        			personGender:$("#personGender").val(),
        			facialKey:$("#facialKey").val(),
        			personFacial:$("#personFacial").val(),
        			},
        		url:"${pageContext.request.contextPath}/storyPerson/update",
        		success:function(result){	
        			$('#myModal').modal();
    			}
        	});
        });
    </script>
</body>
</html>
