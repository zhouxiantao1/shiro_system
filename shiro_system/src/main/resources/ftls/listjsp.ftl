<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
   <%@include file="/WEB-INF/jsp/include/head.jsp" %>
   
</head>

<body class="theme-blue">
   
   <%@include file="/WEB-INF/jsp/include/top.jsp" %>
   <%@include file="/WEB-INF/jsp/include/left.jsp" %>
  
      <div class="content">
		<div class="header">

			<h1 class="page-title">${catalog}管理</h1>
			<ul class="breadcrumb">
				<li><a href="/">story管理</a></li>
				<li class="active">${catalog}列表</li>
			</ul>

		</div>
		<div class="main-content">

			<div class="btn-toolbar list-toolbar">
				<button class="btn btn-primary">
					<a href="${r'${pageContext.request.contextPath}'}/${className}/toAdd"><i class="fa fa-plus"></i>新增</a>
				</button>
				<button class="btn btn-default">导入</button>
				<button class="btn btn-default">导出</button>
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th class="row_line">#</th>
						<th class="row_line">人物姓名</th>
						<th class="row_line">人物年龄</th>
						<th class="row_line">人物性别</th>
						<th class="row_line">肖像特征</th>
						<th style="width: 10em;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${r'${storypersons}'}" var="${className}" varStatus="status">
						<tr>
							<td>${r'${status.index+1}'}</td>
							<td>${r'${storyperson.personName}'}</td>
							<td>${r'${storyperson.personAge}'}</td>
							<td>${r'${storyperson.personGender}'}</td>
							<td>${r'${storyperson.facialKey}'}</td>
							<td class="user_list">
								<a href="${r'${pageContext.request.contextPath}'}/storyPerson/toUpdate?id=${r'${storyperson.id}'}"><i class="fa fa-pencil"></i></a> 
								<i class="fa fa-trash-o" onClick="delStoryPerson('${r'${storyperson.id}'}')"></</td>
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

			<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
							<h3 id="myModalLabel">删除成功</h3>
						</div>
						<div class="modal-body">

							<p >
								<i><img src="${r'${pageContext.request.contextPath}'}/static/images/icon/succeed.png"></i></br></br>
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
	   function delStoryPerson(id){
		   $.ajax({
       		type: 'POST',
	       		async: true,
	       		data: { 
	       			id: id
	       			},
	       		url:"${r'${pageContext.request.contextPath}'}/${className}/del",
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
