<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>登录</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/stylesheets/premium.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/supersized.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css">
    
    <script src="${pageContext.request.contextPath}/static/lib/jquery-1.11.1.min.js" type="text/javascript"></script>

</head>
<body class=" theme-blue">

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>


    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">

        </div>
      </div>
    </div>
    


        <div class="dialog">
    <div class="panel panel-default">
        <p class="panel-heading no-collapse">后台管理登录</p>
        <div class="panel-body">
            <form action="" method="post">
                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" name="username" class="form-control span12">
                </div>
                <div class="form-group">
                <label>密码</label>
                    <input type="password" name="password" class="form-controlspan12 form-control">
                </div>      
                <label class="remember-me"><input name="rememberMe" type="checkbox"> 记住账号</label>
                <input type="submit" class="btn btn-primary pull-right" value="登录">
                <div class="img_weibo" id="weiboLogin"><img src="${pageContext.request.contextPath}/static/images/weibo.png"/></div>
                <div class="clearfix"></div>
            </form>
        </div>
    </div>
    <p class="pull-right" style=""><a href="#" target="blank" style="font-size: .75em; margin-top: .25em;">注     销</a></p>
    <p><a href="reset-password.html">忘记密码?</a></p>
</div>



    <script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/supersized.3.2.7.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/supersized-init.js"></script>
    <script type="text/javascript">
    	$("#weiboLogin").click(function(){
    		window.location.replace("https://api.weibo.com/oauth2/authorize?client_id=3472698345&response_type=code&redirect_uri=http://172.16.19.118:8090/shiro_system/weibogetlogin");
    	})
    </script>
  
</body></html>
