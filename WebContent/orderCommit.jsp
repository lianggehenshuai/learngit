<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shop.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提交订单页面</title>






		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/shopList.css" />
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body>
		

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
		<div style="border: 1px solid green;width: 100%;height: 100px;margin-top: 15px;">
			<img src="img/logo.png" style="margin-left: 250px;position: absolute;"/>
			<img src="img/okOrder.png" style="margin-left:  820px;position: absolute;margin-top: 10px;"/>
		</div>
		<hr style="border: 2px solid red;" />
		<p>
			<img src="img/index.jpg" style="margin-left: 255px;"/>
			请在
			<!--  <script>
		        var xx = 30,
		            interval;
		        window.onload = function() {
		            var d = new Date("1111/1/1,0:" + xx + ":0");
		            interval = setInterval(function() {
		                var m = d.getMinutes();
		                var s = d.getSeconds();
		                m = m < 10 ? "0" + m : m;
		                s = s < 10 ? "0" + s : s;
		                btn.innerHTML = m + ":" + s;
		                if (m == 0 && s == 0) {
		                    clearInterval(interval);
		                    return;
		                }
		                d.setSeconds(s - 1);
		            }, 1000);
		        }
    		</script> -->
			<span id="btn" style="color: red;"></span>
			内完成订单的提交
		</p>	
		<form action="OrderOn" method="post">
		<h3 style="margin-left:255px;">您的订单编号为:
			<a style="color:red">${UUID.randomUUID().toString().substring(0, 8)}</a>
			<input type="hidden" name="oid" value=${UUID.randomUUID().toString().substring(0, 8)}/>
		</h3>	
		<div style="width: 1050px;height: 40px;border-left: 2px solid red;margin-left: 255px;background-color: #F9F9F9;">
			<span style="line-height: 40px;font-weight: bold;">收货信息</span>		
				  <div class="form-group">
				    <div class="col-sm-10">
				      <input name="oName" type="text" class="form-control" id="inputPassword" placeholder="请输入收货人姓名" style="width: 300px;">
				    </div>
				    <div class="col-sm-10">
				      <input name="oPhone" type="text" class="form-control" id="inputPassword" placeholder="请输入联系方式" style="width: 300px;">
				    </div>
				  </div>
				   <select id="mySelect" value="options[selectedIndex].value" name="sel2" style="width: 200px; height: 30px;margin-left:15px;" onchange="selectProv(this)">
						<option>请选择省份</option>
					  </select>
				   <select id="mySelect3"  name="sel3" style="width: 200px; height: 30px;" onchange="selectCity(this)">
						<option>请选择城市</option>
				   </select>
				   <select id="mySelect4" name="sel4" style="width: 200px; height: 30px;">
						<option>请选择地区</option>
				  </select>
				    <div class="form-group">
				    <div class="col-sm-10">
				      <input name="detailInfo" type="text" class="form-control" id="inputPassword" placeholder="请输入详细地址" style="width: 300px;">
				    </div>
				  </div>
		</div>	
		<div style="width: 100%;height: 700px;margin-top: 150px;">
	
		<div style="width: 1050px;height: 40px;border-left: 2px solid red;margin-left: 255px;background-color: #F9F9F9;margin-top: 100px;">
			<span style="line-height: 40px;font-weight: bold;">订单商品信息</span>
			<table width="1050px" border="1px" style="text-align: center;" id="tab">	
			<tr class="success">
				<td>商品id</td>
				<td>商品名字</td>
				<td>商品价格</td>
				<td>选择数量</td>
				<td>单件商品金额</td>
			</tr>
			<%
			Enumeration<String> s=request.getSession().getAttributeNames();
			int i = 0;
			while(s.hasMoreElements()){
					  i++;
			          Object obj =  request.getSession().getAttribute(s.nextElement());
			          if(obj instanceof ProductBean)
			          {
			        	  ProductBean pb = (ProductBean)obj;
			        %>
			<tr class="success">
					<td><%=pb.getId() %></td>	
					<td><%=pb.getPnamme() %></td>
					<td><%=pb.getPrice() %></td>
					<td><%=pb.getCounts() %></td>
					<td><%=pb.getPrice()*pb.getCounts() %>0<td>				
			</tr>
       		 <% 	  
			          }
					}
			%>
		</table>
		</div>
		
		
	
		<div style="width: 1050px;height: 40px;border-left: 2px solid red;margin-left: 255px;background-color: #F9F9F9;margin-top:200px;">
			<span style="line-height: 40px;font-weight: bold;">支付方式</span>
			<span id="_span" style="color:red"></span>
			<div style="width: 900px;height: 60px;border: 1px solid khaki;margin-left: 40px;">
				<span style="line-height: 60px;padding-left: 50px;">
				<input type="radio" value="1" name="payStyle"/>在线支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value="2" name="payStyle"/>微信支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value="3" name="payStyle"/>支付宝支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				</span>
			</div>
		</div>
		<script type="text/javascript">
			
			var tableId = document.getElementById("tab"); 
			var str = ""; 
			var number = 0;
			for(var i=1;i<tableId.rows.length;i++) 
			{ 
				number += parseInt(tableId.rows[i].cells[4].innerHTML);	
			} 
			document.getElementById("_span").innerHTML="您要支付的费用一共为:"+number+"元&nbsp;&nbsp;&nbsp;请选择";  
		
		</script>
		<div style="width: 1050px;height: 40px;border-left: 2px solid red;margin-left: 255px;background-color: #F9F9F9;margin-top:100px;">
			<span style="line-height: 40px;font-weight: bold;">备注信息</span>
			<span id="_span" style="color:red"></span>
			<div style="width: 900px;height: 150px;border: 1px solid khaki;margin-left: 40px;">
				<textarea style="width: 900px;height: 150px;" rows="3" name="info"></textarea>
			</div>
		</div>
		<button type="submit" class="btn btn-primary" style="margin-left: 255px;margin-top: 200px;">确认发货</button>
		</form>
	</div>
	
	
	
	<script type="text/javascript">
	window.onload=function _ajax()
	{
		alert("1");
		var xmlhttp;
		if(window.XMLHttpRequest)
			{
				xmlhttp = new XMLHttpRequest();
			}
		else
			{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		xmlhttp.open("GET","http://localhost:7878/ShoppingSystem/ReadAd",true);
		xmlhttp.send();
		
		xmlhttp.onreadystatechange=function()
		{		
			
			if(xmlhttp.readyState==4&&xmlhttp.status==200)
				
				{		//JSON.parse
					 var ps = eval(xmlhttp.responseText);
					 var pinfo = "";				 
					for(var i=0;i<ps.length;i++)
						{	
							
							var address = ps[i];
							pinfo=address.provience;
							var x=document.getElementById("mySelect");
							var option=document.createElement("option");
							option.text=pinfo;
							    try{
							        // 对于更早的版本IE8
							        x.add(option,x.options[null]);
							    }catch (e){
							         x.add(option,null);
							    }
/* 							pinfo+=address.provience+address.city+address.area+"<br/>"; */
						}
				/* 	document.getElementById("_p").innerHTML = pinfo;   */
				}
		} 
	}
	function selectProv(filed)
	{
		    var xmlhttp2;
		    if(window.XMLHttpRequest)
			{
				xmlhttp2 = new XMLHttpRequest();
				/* alert(filed.value); */
				xmlhttp2.open("GET","http://localhost:7878/ShoppingSystem/ReadAd2?add="+escape(escape(filed.value)),true);
			}
		else
			{
				xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp2.open("GET","http://localhost:7878/ShoppingSystem/ReadAd2?add="+escape(escape(filed.value)),true);
			}
			xmlhttp2.send(); 
			
	   /*   var xmlhttp2;
		    
		    if(window.XMLHttpRequest)
			{
				xmlhttp2 = new XMLHttpRequest();
				alert(filed.value);
				xmlhttp2.open("POST","http://localhost:8080/ShoppingSystem/ReadAd2",true);
				xmlhttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			}
		else
			{
				xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp2.open("POST","http://localhost:8080/ShoppingSystem/ReadAd2",true);
				xmlhttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			}
		    xmlhttp2.send("add="+filed.value); */
			

			
			xmlhttp2.onreadystatechange=function()
			{		
				if(xmlhttp2.readyState==4&&xmlhttp2.status==200)
					{		//JSON.parse
						 var ps = eval(xmlhttp2.responseText);
						// alert(ps);
						 var pinfo = "";
						document.getElementById("mySelect3").innerHTML = "";
						var mySel3 = document.getElementById("mySelect3");
						var option3=document.createElement("option");
						option3.text = "请选择城市"
						mySel3.add(option3,mySel3.options[null]);
						
						for(var i=0;i<ps.length;i++)
							{	
								var address = ps[i];
								pinfo=address.city;
								var y=document.getElementById("mySelect3");
								var option=document.createElement("option");
								option.text=pinfo;
								    try{
								        // 对于更早的版本IE8
								        y.add(option,y.options[null]);
								    }catch (e){
								         y.add(option,null);
								    }
	/* 							pinfo+=address.provience+address.city+address.area+"<br/>"; */
							}
					/* 	document.getElementById("_p").innerHTML = pinfo;   */
						
					}
			} 
	}
	
	
	
	function selectCity(val)
	{
		
		     var xmlhttp3;
		    
		    if(window.XMLHttpRequest)
			{
				xmlhttp3 = new XMLHttpRequest();
				/* alert(val.value); */
				xmlhttp3.open("GET","http://localhost:7878/ShoppingSystem/ReadAd3?addee="+escape(escape(val.value)),true);
			}
		else
			{
				xmlhttp3 = new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp3.open("GET","http://localhost:7878/ShoppingSystem/ReadAd3?addee="+escape(escape(val.value)),true);
			}
			xmlhttp3.send(); 
			
	   /*   var xmlhttp2;
		    
		    if(window.XMLHttpRequest)
			{
				xmlhttp2 = new XMLHttpRequest();
				alert(filed.value);
				xmlhttp2.open("POST","http://localhost:8080/ShoppingSystem/ReadAd2",true);
				xmlhttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			}
		else
			{
				xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
				xmlhttp2.open("POST","http://localhost:8080/ShoppingSystem/ReadAd2",true);
				xmlhttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			}
		    xmlhttp2.send("add="+filed.value); */
			

			
			xmlhttp3.onreadystatechange=function()
			{		
				if(xmlhttp3.readyState==4&&xmlhttp3.status==200)
					{		//JSON.parse
						 var ps = eval(xmlhttp3.responseText);
						// alert(ps);
						 var pinfo = "";
						 document.getElementById("mySelect4").innerHTML = "";
						 var mySel4 = document.getElementById("mySelect3");
							var option4=document.createElement("option");
							option4.text = "请选择地区"
							mySel4.add(option4,mySel4.options[null]);
						for(var i=0;i<ps.length;i++)
							{	
								var address = ps[i];
								pinfo=address.area;
								var z=document.getElementById("mySelect4");
								var option=document.createElement("option");
								option.text=pinfo;
								    try{
								        // 对于更早的版本IE8
								        z.add(option,y.options[null]);
								    }catch (e){
								         z.add(option,null);
								    }
	/* 							pinfo+=address.provience+address.city+address.area+"<br/>"; */
							}
					/* 	document.getElementById("_p").innerHTML = pinfo;   */
						
					}
			} 
	}
	
	/* 
		function displayResult(){
    var x=document.getElementById("mySelect");
    var option=document.createElement("option");
    option.text="山西省";
    try{
        // 对于更早的版本IE8
        x.add(option,x.options[null]);
    }catch (e){
         x.add(option,null);
    }
}
		
	*/
	
</script>	
	
	
	
	
	</body>
</html>