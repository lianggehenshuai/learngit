<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax</title>
</head>
<script type="text/javascript">
	function _ajax()
	{
		 var xmlhttp;
		if(window.XMLHttpRequest)
			{
				xmlhttp = new XMLHttpRequest();
			}
		else
			{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		xmlhttp.open("GET","http://localhost:8080/ShoppingSystem/ReadAd",true);
		xmlhttp.send();
		
		xmlhttp.onreadystatechange=function()
		{		
			if(xmlhttp.readyState==4&&xmlhttp.status==200)
				{		//JSON.parse
					 var ps = eval(xmlhttp.responseText);
					// alert(ps);
					 var pinfo = "";
					 document.getElementById("mySelect3").innerHTML = "";
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
					//document.write(escape(filed.value) + "<br />")
		
					//xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
					xmlhttp2.open("GET","http://localhost:8080/ShoppingSystem/ReadAd2?add="+filed.value,true);
				}
			xmlhttp2.send();
			xmlhttp2.onreadystatechange=function()
			{		
				if(xmlhttp2.readyState==4&&xmlhttp2.status==200)
					{		//JSON.parse
						 var ps = eval(xmlhttp2.responseText);
						// alert(ps);
						 var pinfo = "";
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
<body onload="_ajax()">
	<!-- <button onclick="_ajax()">点我点我</button> -->
	<p id="_p"></p>
	
	<select id="mySelect" value="options[selectedIndex].value" name="sel2" style="width: 200px; height: 25px;" onchange="selectProv(this)"></select>
	<select id="mySelect3"  name="sel3" style="width: 200px; height: 25px;"></select>
	
	
</body>
</html>