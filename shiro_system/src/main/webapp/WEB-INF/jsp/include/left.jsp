<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 左边菜单 -->
	<div class="sidebar-nav">
		<ul>
			<li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse">
				<i class="fa fa-fw fa-dashboard"></i>系统管理<i class="fa fa-collapse"></i></a>
			</li>
			<li>
				<ul class="dashboard-menu nav nav-list collapse in">
					<li><a href="${pageContext.request.contextPath}/"><span class="fa fa-caret-right"></span> 主菜单</a></li>
					<li><a href="${pageContext.request.contextPath}/user/list"><span class="fa fa-caret-right"></span> 用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/role/list"><span class="fa fa-caret-right"></span> 角色管理</a></li>
					<li><a href="${pageContext.request.contextPath}/permission/list"><span class="fa fa-caret-right"></span> 权限管理</a></li>
				</ul>
			</li>

			<li data-popover="true" data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>."
				rel="popover" data-placement="right"><a href="#"data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					story管理<i class="fa fa-collapse"></i></a>
			</li>
			<li>
				<ul class="premium-menu nav nav-list collapse">
					<li class="visible-xs visible-sm"><a href="#">- Premium features require a license -</a></span>
					<li><a href="${pageContext.request.contextPath}/storyPerson/toList"><span class="fa fa-caret-right"></span> 人物管理</a></li>
					<li><a href="premium-blog.html"><span class="fa fa-caret-right"></span> Blog</a></li>
					<li><a href="premium-blog-item.html"><span class="fa fa-caret-right"></span> Blog Page</a></li>
					<li><a href="premium-pricing-tables.html"><span class="fa fa-caret-right"></span> Pricing Tables</a></li>
					<li><a href="premium-upgrade-account.html"><span class="fa fa-caret-right"></span> Upgrade Account</a></li>
					<li><a href="premium-widgets.html"><span class="fa fa-caret-right"></span> Widgets</a></li>
					<li><a href="premium-timeline.html"><span class="fa fa-caret-right"></span> Activity Timeline</a></li>
					<li><a href="premium-users.html"><span class="fa fa-caret-right"></span> Enhanced Users List</a></li>
					<li><a href="premium-media.html"><span class="fa fa-caret-right"></span> Enhanced Media</a></li>
					<li><a href="premium-invoice.html"><span class="fa fa-caret-right"></span> Invoice</a></li>
					<li><a href="premium-build.html"><span class="fa fa-caret-right"></span> Advanced Tools</a></li>
					<li><a href="premium-colors.html"><span class="fa fa-caret-right"></span> Additional Color Themes</a></li>
				</ul>
			</li>
			<li><a href="#" data-target=".accounts-menu" class="nav-header collapsed" data-toggle="collapse">
				<i class="fa fa-fw fa-briefcase"></i> Account <span class="label label-info">+3</span></a>
			</li>
			<li>
				<ul class="accounts-menu nav nav-list collapse">
					<li><a href="sign-in.html"><span class="fa fa-caret-right"></span> Sign In</a></li>
					<li><a href="sign-up.html"><span class="fa fa-caret-right"></span> Sign Up</a></li>
					<li><a href="reset-password.html"><span class="fa fa-caret-right"></span> Reset Password</a></li>
				</ul>
			</li>

			<li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse">
				<i class="fa fa-fw fa-legal"></i> Legal<i class="fa fa-collapse"></i></a>
			</li>
			<li>
				<ul class="legal-menu nav nav-list collapse">
					<li><a href="privacy-policy.html"><span class="fa fa-caret-right"></span> Privacy Policy</a></li>
					<li><a href="terms-and-conditions.html"><span class="fa fa-caret-right"></span> Terms and Conditions</a></li>
				</ul>
			</li>

			<li><a href="help.html" class="nav-header"><i class="fa fa-fw fa-question-circle"></i> Help</a></li>
			<li><a href="faq.html" class="nav-header"><i class="fa fa-fw fa-comment"></i> Faq</a></li>
			<li><a href="http://portnine.com/bootstrap-themes/aircraft" class="nav-header" target="blank">
				<i class="fa fa-fw fa-heart"></i>Get Premium</a>
			</li>
		</ul>
	</div>