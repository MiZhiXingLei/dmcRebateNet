<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="../images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">用户注册</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
									<form action="${pageContext.request.contextPath}/member/user" method="post">
										
							   <div class="user-email">
										<label for="memberName"><i class="am-icon-user"></i></label>
										<input type="text" name="memberName" id="memberName" required="required" placeholder="请输入用户名">
                              </div>										
				              <div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label>
									<input type="password" name="memberPwd1" id="password" required="required" placeholder="设置密码">
				              </div>										
				              <div class="user-pass">
					                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
									<input type="password" name="memberPwd" id="passwordRepeat" required="required" placeholder="确认密码">
				              </div>	
				              <div class="user-phone">
								    <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
								    <input type="tel" name="memberPhone" id="phone" placeholder="请输入手机号">
                              </div>   
                              <div class="verification">
											<label for="code"><i class="am-icon-code-fork"></i></label>
											<input type="tel" name="code" required="required" id="code" placeholder="请输入验证码">
										<button id="huoqu" type="button" class="am-btn-xs am-btn-secondary am-round" style="font-size:18px;height:40px;width:55px" onclick="huoqus()">获取</button>
							  </div>
							   <div class="login-links">
								    <input id="reader-me" type="checkbox" style="width:13px;height: 13px;"> 点击表示您同意商城《服务协议》
                              </div>   
                              <div class="am-cf">
								<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
							  </div>
				                 </form>

							</div>
						</div>

				</div>
			</div>
			
					<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
					<script type="text/javascript">
					      $("#memberName").blur(function(){
					    	  if($("#memberName").val()!=""&&$("#memberName").val()!=null)
					    	$.ajax({
					    	  type:"post",
					    	  url:"${pageContext.request.contextPath}/member/isuser",
					    	  data:{"memberName":$("#memberName").val()},
					    	  	success:function(result){
					    	  		if(result=="true"){
					    	  			alert("用户名可用");
					    	  		}else{
					    	  			alert("用户名已经存在");
					    	  		}
					    	  	}  
					    	  }
					    	)  
					    	  
					      });
						function huoqus(){
							
						 var  phonerge = /^[1][3,4,5,7,8,9][0-9]{9}$/;
						
							if($("#phone").val()!="" && phonerge.test($("#phone").val())){
							var phone =	$("#phone").val();
							$("#huoqu").attr("disabled","disabled");
							$("#huoqu").css("background","#CCCCCC");
							var alltime=60;
							
							$.ajax({
								 type : "post", //提交方式 
							     url : "${pageContext.request.contextPath}/member/code",//路径 
							     data : { 
							         "code" : phone
							        },//数据，这里使用的是Json格式进行传输 

							     success : function(result) {//返回数据根据结果进行相应的处理 
							      alert(result);
							     } 
	
							})
							clearInterval(time);
							var time = setInterval(function(){
								var t = alltime;
								if(t==0){
									 $("#huoqu").text("获取");
									$("#huoqu").removeAttr("disabled");
							        $("#huoqu").css("background","");
							        clearInterval(time);
								}else{
									$("#huoqu").text(t);
								alltime--;
								}
								
								
							},1000)
							}else{
								alert("手机号码有误空");
							}
							
						}
						
					</script>
	</body>
          
</html>