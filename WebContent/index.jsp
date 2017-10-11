<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>运海商城</title>
	<meta name="keywords" content="运海商城">
	<meta name="content" content="运海商城">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body class="login_bj" >

<div class="zhuce_body">
	<div class="logo"><a href="#"><img src="images/logobighh.png" width="150" height="54" border="0"></a></div>
    <div class="zhuce_kong">
    	<div class="zc">
    	<%
    	Object obj = request.getAttribute("user");
    		
    		if(obj!=null)
    		{
    	%>
    	<script type="text/javascript">alert("注册成功")</script>
    	<% 
    		}
    	%>
 
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form action="RegisterServ" method="get">
                <input name="loginName" type="text" class="kuang_txt email" placeholder="邮箱">
                <input name="password" type="text" class="kuang_txt possword" placeholder="密码">
                <input name="" type="text" class="kuang_txt possword" placeholder="邀请码<非必填>">
                <input name="" type="text" class="kuang_txt yanzm" placeholder="验证码<非必填>">
                <div>
                	<div class="hui_kuang"><img src="images/zc_22.jpg" width="92" height="31"></div>
                	<div class="shuaxin"><a href="#"><img src="images/zc_25.jpg" width="13" height="14"></a></div>
                </div>
                <div>
               		<input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《运海商城使用协议》</span></a></span>
                </div>
                <input name="注册" type="submit" class="btn_zhuce" value="注册">
                
                </form>
            </div>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="login.jsp">立即登录</a></p>
            
            </div>
        </div>
        <P>yaKun.cn&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您来到运海商城</P>
    </div>

</div>
    
<div style="text-align:center;">

</div>

</body>
</html>