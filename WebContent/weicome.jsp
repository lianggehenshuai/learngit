<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shop.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<!--
        	作者：1473854002@qq.com
        	时间：2017-10-05
        	描述：商品列表
        -->
	<head>
		<meta charset="UTF-8">
		<title>
			商品列表
		</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/shopList.css" />
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
	<style type="text/css">
	.box{
		border:1px solid red;
		/*padding-top:20px;*/
		padding-bottom:40px;
		height:506px;
		width:1523px;
		margin:auto;
		position:relative;
		overflow:hidden;
	}
	#prev
	{
		position:absolute;
		top:140px;
		left:20px;
	}
	#next
	{
		position:absolute;
		right:20px;
		top:140px;
	}
	#picbox img
	{
		float:left;
		width:1523px;
		height:506px;
	}
	#box a
	{
		text-decoration:none;
		color:white;
		font-size:38px;
		background-color:black;
	}
  </style>
    <script type="text/javascript">
	function onload()
	{
		//创建图片数组
		var imgs = [
		{"src":"img/11.jpg"},
		{"src":"img/22.jpg"},
		{"src":"img/33.jpg"}];
		

		var width = 1523;				//定义一张图片的宽度
		var height = 400;				//定义一张图片的高度
		var imgsWidth = imgs.length * width + width*2;		//定义图片的总宽度
		/*alert(imgsWidth);*/
		
		//创建图片总区域
		var picbox = document.getElementById("picbox");
		//设置总区域样式
		var _Style = "position:absolute;width:"+imgsWidth+"px;height:400px;left:-1523px;transition:left 0.5s";
		picbox.setAttribute("style",_Style);
		//获取左箭头
		var prev = document.getElementById("prev");
		//获取右箭头
		var next = document.getElementById("next");
		//添加最后一张图片为第一张
		var _img = document.createElement("img");
		_img.setAttribute("src",imgs[imgs.length-1].src);
		picbox.appendChild(_img);
		//正常添加四张图片
		for(var i=0;i<imgs.length;i++)
		{
			var _img = document.createElement("img");
			_img.setAttribute("src",imgs[i].src);
			picbox.appendChild(_img);
		}
		//添加最后一张图片即第一张图片
		var _img = document.createElement("img");
		_img.setAttribute("src",imgs[0].src);
		picbox.appendChild(_img);

		//改变图片位置的方法
		function animate(offset)
		{
			//获取当前图片的left像素
			//因为获取到的为字符串所以的转成整数
			var newleft = parseInt(picbox.style.left)+offset;
			picbox.style.left = newleft+"px";

			//移除事件
			document.getElementById("picbox").removeEventListener("webkitTransitionEnd", cancleNext, false);
			document.getElementById("picbox").removeEventListener("webkitTransitionEnd", canclePrev, false);
			
			//设置过渡动画
			picbox.style.transition = "1s";
			

			//判断图片是否走到最后一张
			if(newleft<-(imgsWidth-width*2))
			{
				picbox.style.left = -(imgsWidth-width)+"px";
				document.getElementById("picbox").addEventListener("webkitTransitionEnd",cancleNext,false);
			}
			//判断图片是否在第二张
			if(newleft>-width)
			{
				picbox.style.left=0+"px";
				document.getElementById("picbox").addEventListener("webkitTransitionEnd", canclePrev,false);
			}

		}
		function cancleNext()
		{
			picbox.style.transition="";
			picbox.style.left = -width+"px";
		}
		function canclePrev()
		{
			picbox.style.transition="";
			picbox.style.left=-(imgsWidth-width*2)+"px";
		}

		prev.onclick=function()
		{
			animate(width);
		}

		
		next.onclick=function()
		{
			animate(-width);
		}

		//自动轮播
		var timer;
		function play()
		{
			timer = setInterval(function()
			{
				next.onclick()
			},3000)
		}
		
		var container = document.getElementById("box");
		function stop()
		{
			clearInterval(timer);
		}
		container.onmouseover = stop;
		container.onmouseout = play;
	}
  </script>
	</head>
	<body style="height: 1500px;"onload="onload()">
		<!--
        	头div
        -->
		<div style="border: 1px solid red;width: 100%;height: 52px;background-color: #1B252F;">
			<img src="img/china.png" width="30px" height="30px" style="position: absolute;left: 250px;top: 12px;"/>
			<span style="line-height: 52px;margin-left: 285px;color: white;">China&nbsp;&nbsp;|&nbsp;&nbsp;天津&nbsp;&nbsp;|&nbsp;&nbsp;空港经济区&nbsp;&nbsp;||&nbsp;&nbsp;运海商城</span>
			<img src="img/login1.png" width="30px" height="30px" style="position: absolute;right: 350px;top: 12px;"/>
			<img src="img/register.png" width="30px" height="30px" style="position: absolute;right: 300px;top: 12px;"/>
			<img src="img/tel.png"  width="30px" height="30px" style="position: absolute;right: 250px;top: 12px;"/>
		</div>
		
		<!--
        	头下面的第一个div
        -->
		<div style="border: 1px solid green;width: 100%;height: 206px;margin-top: 15px;">
			<img src="img/logo.png" style="margin-left: 250px;position: absolute;"/>
			<form class="form-inline"style="margin-left: 600px;margin-top: 30px;" action="LikeRearchServ" method="post">
  				<div class="form-group">
    				<label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
    				<div class="input-group">
     				 	<input type="text" class="form-control" id="exampleInputAmount" placeholder="查找商品" name="rearchInput">
      					
    				</div>
  				</div>
  				<button type="submit" class="btn btn-primary">点击查找</button>
			</form>
			<img src="img/heart.png" style="margin-left: 1155px;position: absolute;width: 30px;height: 30px;top: 100px;" />
			<a href="shopCar.jsp"><img src="img/shopCar.png" style="margin-left: 1205px;position: absolute;width: 30px;height: 30px;top: 100px;"/></a>
			<ul style="margin-top: 110px;margin-left: 480px;">
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
				<li>商城简介</li>
			</ul>
		</div>
		
		<!--
			选择栏div
		-->
		<div id="selectDiv" style="border: 1px solid black;width:16%;height: 570px;position: absolute;top: 185px;left: 230px;border-radius: 15px;overflow: hidden;z-index: 9999;background-color: white;">
			<div style="border: 1px solid royalblue;width: 100%;height: 88px;background-color:#B11E22 ;">
				<span style="line-height: 88px;margin-left:30px;font-family: '微软雅黑';font-size: 20px;color: white;" id="showList">查看商品列表<span style="margin-left: 10px;">></span></span>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
			<div id="selectDivTwo" style="border-bottom: 1px solid darkblue;width: 100%;height: 30px;">
				<a style="line-height: 30px;margin-left: 37%;">生活用品</a>
			</div>
		</div>
		<!--
			轮播图div
		-->
		<div style="border: 1px solid lightseagreen;width: 100%;height: 506px;">
			<div id="box" class="box">
				<div id="picbox"></div>
				<a href="javascript:;" id="prev"> < </a>
				<a href="javascript:;" id="next">></a>
			</div>		
		</div>
		
		<!--
        	商品列表div
        -->
        
		<div style="border: 1px solid lightcoral;width: 1000px;height: 700px;margin-top: 40px;margin-left: 250px;">
			
				 <%
						Object obj = request.getAttribute("msgs");
						if (obj != null) {
							PageModel<ProductBean> list =  (PageModel<ProductBean>)obj;
							for(int i=0;i<list.getPageInfo().size();i++)
							{
      	 		 %>	
      	 		 <form action="ShopCarServ" method="post">
					<div style="width: 248px;float: left;">
						<img src="http://localhost:7878/ShoppingSystem/images/<%=list.getPageInfo().get(i).getPic() %>"/>
						<input  name="pname" value="<%=list.getPageInfo().get(i).getPnamme() %>" />
						<input  name="price" value="<%=list.getPageInfo().get(i).getPrice() %>"/>
						<input type="hidden" name="id" value="<%=list.getPageInfo().get(i).getId() %>"/>
						<span >数量</span>
						<input type="text" name="counts" style="width: 80px;display: inline;" />
						<input type="submit" value="添加到购物车" />
					</div>
				</form>	
				<%
	        		}
				%>
			<div style="margin-left:400px;margin-top:50px;">
				<div class="btn-group" role="group" aria-label="..."> 
					<button type="button"><a href="ProductServ?pageNo=1&pageSize=8">首页</a></button>
					<button type="button"><a href="ProductServ?pageNo=<%=list.getCurrentPageNo()-1==0?list.getCurrentPageNo():list.getCurrentPageNo()-1%>&pageSize=8">上一页</a></button>
					<button type="button"><a href="ProductServ?pageNo=1&pageSize=8">1页 </a></button>
					<button type="button"><a href="ProductServ?pageNo=2&pageSize=8">2页</a></button>
					<button type="button"><a href="ProductServ?pageNo=3&pageSize=8">3页</a></button>
					<button type="button"><a href="ProductServ?pageNo=<%=list.getCurrentPageNo()+1==list.getAllPages()+1?list.getAllPages():list.getCurrentPageNo()+1 %>&pageSize=8">下一页</a></button>
					<button type="button"><a href="ProductServ?pageNo=<%=list.getAllPages()%>&pageSize=8">尾页</a></button> 
				</div>
			</div>
		</div>
				<%	
					}
						Object obi = request.getAttribute("result");
						if(obi instanceof Boolean)
						{
							Boolean bool = (Boolean)obi;
							if(bool.equals(true))
							{
								%>
									<script>alert("已经添加到购物车")</script>
								<% 
							}
						}
	            %>
		<!--页面底部div-->
		<div></div>
	</body>
</html>