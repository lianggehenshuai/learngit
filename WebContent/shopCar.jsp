<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shop.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
</head>
<body>
<div style="width: 100%; height: 300px;">
		
		<form action="QueryPage" method="get">
		<table border="1px" width="100%" height="50px">
			
			<tr class="success">
				<td>商品名字</td>
				<td>商品价格</td>
				<td>选择数量</td>
			</tr>
			<%
			Enumeration<String> s=request.getSession().getAttributeNames();
			while(s.hasMoreElements()){
			          Object obj =  request.getSession().getAttribute(s.nextElement());
			          if(obj instanceof ProductBean)
			          {
			        	  ProductBean pb = (ProductBean)obj;
			        %>
			
			<tr class="success">
					<%-- <td id="cid">${pb.pnamme}</td> --%>
					<td id="cid"><%=pb.getPnamme() %></td>
					 <td><%=pb.getPrice() %></td>
					<td><%=pb.getCounts() %></td> 	
			</tr>
       		 <% 	  
			          }
					}
			
			%>
		</table>
		<p>
			<button class="btn btn-large btn-primary" type="button"
				onclick="javascript:window.location.href='orderCommit.jsp'">提交订单</button>
			<button class="btn btn-large btn-primary" type="button"
				onclick="javascript:window.location.href='ProductServ?pageNo=1&pageSize=8'">返回继续选购商品</button>
		</p>
		</form>		
	</div>
</body>
</html>