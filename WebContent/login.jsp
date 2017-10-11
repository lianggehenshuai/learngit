<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shop.entity.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>运海商城</title>
	<meta name="keywords" content="运海商城">
	<meta name="content" content="运海商城">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
</head>
<body class="login_bj" >
<div class="zhuce_body">
	<div class="logo"><a href="#"><img src="images/logobighh.png" width="150" height="54" border="0"></a></div>
    <div class="zhuce_kong login_kuang">
    	<div class="zc">
    		<%
    			Object obj = session.getAttribute("user");
    			if(obj instanceof UsersBean)
    			{
    				UsersBean ub = (UsersBean)obj;
    		%>
        	<div class="bj_bai">
            <h3>登录</h3>
       	  	  <form action="LoginServlet" method="get">
                <input name="lName" type="text" class="kuang_txt" placeholder="<%=ub.getLoginname()%>" value="<%=ub.getLoginname()%>">
                <input name="pass" type="text" class="kuang_txt" placeholder="<%=ub.getPassword()%>" value="<%=ub.getPassword()%>">
                <div>
               		<a href="#">忘记密码？</a><input name="" type="checkbox" value="" checked><span>记住我</span> 
                </div>
                <input name="登录" type="submit" class="btn_zhuce" value="登录">
                
                </form>
            </div>
           <% 
           		}
    		%>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="#">立即登录</a></p>
            
            </div>
        </div>
        <P>yaKun.cn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您登录运海商城</P>
    </div>

</div>
    
</body>
</html>