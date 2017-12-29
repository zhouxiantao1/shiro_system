<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<%@include file="/WEB-INF/jsp/include/head.jsp"%>

<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/static/zTree_v3/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/zTree_v3/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/zTree_v3/js/jquery.ztree.excheck.js"></script>

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
									<span class="font_color">${role}</span>-<label>权限配置</label>
								</div>
								<div class="form-group" hidden="hidden">
									<label>角色id</label> <input type="text" id="roleId"
										value="${roleId}" class="form-control">
								</div>

								<div class="zTreeDemoBackground left">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</form>
						</div>
					</div>

					<div class="btn-toolbar list-toolbar">
						<button id="save_role_permission" class="btn btn-primary">
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
      
        var setting = {
    			check: {
    				enable: true
    			},
    			data: {
    				simpleData: {
    					enable: true
    				}
    			}
    		};
        	
            var zNodes = ${trees};

    		$(document).ready(function(){
    			var treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    			treeObj.expandAll(true);
    		});
    		
    		$("#save_role_permission").click(function(){
    			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    			var nodes=treeObj.getCheckedNodes(true);
    			
    			 var permissionIds='';
    			 for (var i = 0; i < nodes.length; i++) {  
                     var halfCheck = nodes[i].getCheckStatus();  
                     if (!halfCheck.half){  
                    	  permissionIds += nodes[i].id +',';  
                     }   
                 }
    			 if(permissionIds!=''){
    				 permissionIds.substring(0,permissionIds.length-1);
    			 }
    				 
    			 $.ajax({
    	        		type: 'POST',
    	        		async: true,
    	        		data: { 
    	        			    permissionIds: permissionIds, 
    	        			    roleId: $("#roleId").val()
    	        			},
    	        		url:"${pageContext.request.contextPath}/role/addRolePermission",
    	        		success:function(result){
    	        			alert("保存成功");
    	        			window.location.href="${pageContext.request.contextPath}/role/list";
    	    			}
    	        });
    			alert(result);
    		})    		   		
    </script>

</body>
</html>
