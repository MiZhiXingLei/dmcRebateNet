<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--Author: 勾思奇
	本页面为搜索页面，绑定了搜索接口，通过链接搜索特定商品，跳转到商品显示页面
	样式文件为css文件夹下的style1.css
	
	后期需要对页面设计进行完善
-->
<html>
<head>
<title>Flat Search Box Responsive Widget Template | Home :: w3layouts</title>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Flat Search Box Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>

</head>
<body>
<!--search start here-->
<div class="search">
	<i> </i>
	<div class="s-bar">
	   <form>
		<input type="text" id="scanUrl" value="请输入商品网址链接" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入商品网址链接';}">
		<input type="button" id="searchGood" value="Search"/>
	  </form>
	</div>
	<p>Popular searches: <a href="#">Modern PSD template,</a> <a href="#"> Portfolio design </a></p>
</div>
<!--search end here-->	
<div class="copyright">
	 <p>2015 &copy Flat Search Box All rights reserved | Template by  <a href="http://w3layouts.com/" target="_blank">  W3layouts </a></p>
</div>

<script type="text/javascript">
	$(function(){
		$("#searchGood").click(function(){
			var scanUrl = $("#scanUrl").val();
			window.location.href="${pageContext.request.contextPath}/home/introduction.jsp?scanUrl="+scanUrl; 	
			/* $.ajax({
				url: "https://api.shenjian.io/?appid=0d9539f3470ea5876a7263a622c5721d?scanUrl="+scanUrl,
				dataType:"jsonp",
				success:function(json){
					jumpToIntroduction(json.data);
				},
				error:function(){		
    				alert("没有查询搜索结果，请重新链接地址");
    			}
			}) */
		});
	})
</script>
	
</body>
</html>