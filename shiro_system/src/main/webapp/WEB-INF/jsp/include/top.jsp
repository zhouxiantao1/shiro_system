<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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
        $(function() {
            $(".knob").knob();
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
				<li class="dropdown hidden-xs">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
					<span class="glyphicon glyphicon-user padding-right-small" style="position: relative; top: 3px;"></span> 
					Jack Smith <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="./">My Account</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Admin Panel</li>
						<li><a href="./">Users</a></li>
						<li><a href="./">Security</a></li>
						<li><a tabindex="-1" href="./">Payments</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1"
							href="${pageContext.request.contextPath}/logout">Logout</a></li>
					</ul>
				</li>
			</ul>

		</div>
	</div>
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/" title="系统管理">系统管理</a>
	</div>

	
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>

