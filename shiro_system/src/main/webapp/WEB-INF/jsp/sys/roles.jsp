<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/stylesheets/theme.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/stylesheets/premium.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/user.css">
<link href="${pageContext.request.contextPath}/static/common/table.css" rel="stylesheet" type="text/css" />

<script
	src="${pageContext.request.contextPath}/static/lib/jquery-1.11.1.min.js"
	type="text/javascript"></script>

</head>
<body class=" theme-blue">

	<!-- Demo page code -->

	<script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
	<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>

	<script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="" href="index.html"><span class="navbar-brand"><span
					class="fa fa-paper-plane"></span> Aircraft</span></a>
		</div>

		<div class="navbar-collapse collapse" style="height: 1px;">
			<ul id="main-menu" class="nav navbar-nav navbar-right">
				<li class="dropdown hidden-xs"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user padding-right-small"
						style="position: relative; top: 3px;"></span> Jack Smith <i
						class="fa fa-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a href="./">My Account</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Admin Panel</li>
						<li><a href="./">Users</a></li>
						<li><a href="./">Security</a></li>
						<li><a tabindex="-1" href="./">Payments</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
					</ul></li>
			</ul>

		</div>
	</div>
	</div>


	<div class="sidebar-nav">
		<ul>
			<li><a href="#" data-target=".dashboard-menu" class="nav-header"
				data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>
					后台管理系统<i class="fa fa-collapse"></i></a></li>
			<li><ul class="dashboard-menu nav nav-list collapse in">
					<li><a href="${pageContext.request.contextPath}/"><span
							class="fa fa-caret-right"></span> 主菜单</a></li>
					<li><a href="${pageContext.request.contextPath}/user/list"><span
							class="fa fa-caret-right"></span> 用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/role/list"><span
							class="fa fa-caret-right"></span> 角色管理</a></li>
					<li><a href="${pageContext.request.contextPath}/permission/list"><span class="fa fa-caret-right"></span>
							权限管理</a></li>
				</ul></li>

			<li data-popover="true"
				data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>."
				rel="popover" data-placement="right"><a href="#"
				data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					Premium Features<i class="fa fa-collapse"></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse">
					<li class="visible-xs visible-sm"><a href="#">- Premium
							features require a license -</a></span>
					<li><a href="premium-profile.html"><span
							class="fa fa-caret-right"></span> Enhanced Profile</a></li>
					<li><a href="premium-blog.html"><span
							class="fa fa-caret-right"></span> Blog</a></li>
					<li><a href="premium-blog-item.html"><span
							class="fa fa-caret-right"></span> Blog Page</a></li>
					<li><a href="premium-pricing-tables.html"><span
							class="fa fa-caret-right"></span> Pricing Tables</a></li>
					<li><a href="premium-upgrade-account.html"><span
							class="fa fa-caret-right"></span> Upgrade Account</a></li>
					<li><a href="premium-widgets.html"><span
							class="fa fa-caret-right"></span> Widgets</a></li>
					<li><a href="premium-timeline.html"><span
							class="fa fa-caret-right"></span> Activity Timeline</a></li>
					<li><a href="premium-users.html"><span
							class="fa fa-caret-right"></span> Enhanced Users List</a></li>
					<li><a href="premium-media.html"><span
							class="fa fa-caret-right"></span> Enhanced Media</a></li>
					<li><a href="premium-invoice.html"><span
							class="fa fa-caret-right"></span> Invoice</a></li>
					<li><a href="premium-build.html"><span
							class="fa fa-caret-right"></span> Advanced Tools</a></li>
					<li><a href="premium-colors.html"><span
							class="fa fa-caret-right"></span> Additional Color Themes</a></li>
				</ul></li>

			<li><a href="#" data-target=".accounts-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-briefcase"></i> Account <span
					class="label label-info">+3</span></a></li>
			<li><ul class="accounts-menu nav nav-list collapse">
					<li><a href="sign-in.html"><span
							class="fa fa-caret-right"></span> Sign In</a></li>
					<li><a href="sign-up.html"><span
							class="fa fa-caret-right"></span> Sign Up</a></li>
					<li><a href="reset-password.html"><span
							class="fa fa-caret-right"></span> Reset Password</a></li>
				</ul></li>

			<li><a href="#" data-target=".legal-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-legal"></i> Legal<i class="fa fa-collapse"></i></a></li>
			<li><ul class="legal-menu nav nav-list collapse">
					<li><a href="privacy-policy.html"><span
							class="fa fa-caret-right"></span> Privacy Policy</a></li>
					<li><a href="terms-and-conditions.html"><span
							class="fa fa-caret-right"></span> Terms and Conditions</a></li>
				</ul></li>

			<li><a href="help.html" class="nav-header"><i
					class="fa fa-fw fa-question-circle"></i> Help</a></li>
			<li><a href="faq.html" class="nav-header"><i
					class="fa fa-fw fa-comment"></i> Faq</a></li>
			<li><a href="http://portnine.com/bootstrap-themes/aircraft"
				class="nav-header" target="blank"><i class="fa fa-fw fa-heart"></i>
					Get Premium</a></li>
		</ul>
	</div>

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


			<footer>
				<hr>


				<p class="pull-right">
					Collect from <a href="http://www.cssmoban.com/"
						title="系统管理" target="_blank">系统管理</a>
				</p>
				<p>
					Â© 2014 <a href="#" target="_blank">Portnine</a>
				</p>
			</footer>
		</div>
	</div>


	<script
		src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>


</body>
</html>
