<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>商品页面</title>

<link
	href="${pageContext.request.contextPath}/front/AmazeUI-2.4.2/assets/css/admin.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/front/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/front/basic/css/demo.css"
	rel="stylesheet" type="text/css" />
<link type="text/css"
	href="${pageContext.request.contextPath}/front/css/optstyle.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/front/css/style.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/basic/js/quick_links.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/js/jquery.imagezoom.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/js/jquery.flexslider.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/front/js/list.js"></script>


<script type="text/javascript">
	$(function(){
		var scanUrl = "${param.scanUrl}";
		ajaxFunc(scanUrl);
	})
</script>

<script type="text/javascript">
	$(function(){
		$("#ai-topsearch").click(function(){
			var scanUrl=$("#searchInput").val();
			window.location.href="${pageContext.request.contextPath}/front/home/introduction.jsp?scanUrl="+scanUrl;
		})
	})
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".jqzoom").imagezoom();
		$("#thumblist li a").click(function() {
			$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
			$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
			$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
		});
	});
</script>

<script type="text/javascript">
	$(function() {});
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation: "slide",
			start: function(slider) {
				$('body').removeClass('loading');
			}
		});
	});
</script>
</head>

<body>
	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a href="login.jsp" target="_top" class="h">亲，请登录</a> <a
						href="register.jsp" target="_top">免费注册</a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="shopcart.jsp" target="_top"><i
						class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h">0</strong></a>
				</div>
			</div>
			
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">	
		<div class="logoBig">
			<a href="home.jsp"><img src="${pageContext.request.contextPath}/front/images/logobig.png" onclick="location.href=home.jsp"/></a>
		</div>
		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form >
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索商品链接" autocomplete="off"> <input
					id="ai-topsearch" class="button am-btn" value="搜索" index="1"
					type="button">
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<b class="line"></b>
	<div class="listMain">

		<!--分类-->
		<div class="nav-table">
			<div class="long-title">
				<span class="all-goods">搜索结果</span>
			</div>
			
		</div>
		<ol class="am-breadcrumb am-breadcrumb-slash">
			
		</ol>

		<!--放大镜-->

		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">

				<div class="box">

					<div class="tb-booth tb-pic tb-s310" id="firstImage">
						<%-- <a href="${pageContext.request.contextPath}/images/01.jpg"><img src="${pageContext.request.contextPath}/images/01_mid.jpg"
							alt="细节展示放大镜特效" rel="${pageContext.request.contextPath}/images/01.jpg" class="jqzoom" /></a>
					 --%></div>
					<ul class="tb-thumb" id="thumblist">
						<!-- 小图列表 -->
						
					</ul>
				</div>

				<div class="clear"></div>
			</div>

			<div class="clearfixRight">

				<!--规格属性-->
				<!--名称-->
				<div class="tb-detail-hd" id="goodsName">
					<p hidden id="goodsId"> </p>
					
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
						<li class="price iteminfo_price" id="current_price">
							<!-- 添加现价 -->
						</li>
						<li class="price iteminfo_mktprice" id="original_price">
							<!-- 添加原价 -->
						</li>
						<div class="clear"></div>
					</div>

					
					<div class="clear"></div>

					<!--销量与评价-->
					<ul class="tm-ind-panel" id="commentsAndSales">
						
					</ul>
					<div class="clear"></div>

					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login">
							<div class="cart-title">
								可选规格<span class="am-icon-angle-right"></span>
							</div>
						</dt>
						<dd>
							<!--操作页面-->

							<div class="theme-popover-mask"></div>

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" name="loginform" action=""
										method="post">

										<div class="theme-signin-left">

											<div class="theme-options">
												<div class="cart-title">规格</div>
												<ul id="sku">
													<!-- 规格列表 -->
												</ul>
											</div>
											
											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd id= "stock">
													<!-- 库存信息 -->
												</dd>

											</div>
											<div class="clear"></div>

										</div>
										

									</form>
								</div>
							</div>

						</dd>
					</dl>
					<div class="clear"></div>
					<!--活动	-->
					<div class="shopPromotion gold">
						<div class="hot">
									<dt class="tb-metatit">返利优惠</dt>
									<div class="gold-list">
										<p>返券15%</p>
									</div>
								</div>
						
					</div>
				</div>

				<div class="pay">
					<div class="pay-opt">
						<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
						<a><span class="am-icon-heart am-icon-fw">收藏</span></a>

					</div>
					<!-- <li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
							<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">立即购买</a>
						</div>
					</li> -->
					<li>
						<div class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="立即购买" href="#"><i></i>立即购买</a>
						</div>
					</li>
				</div>

			</div>

			<div class="clear"></div>

		</div>

		<div class="clear"></div>


		<!-- introduce-->

		<div class="introduce">
			<div class="browse"></div>
			<div class="introduceMain">
				<div class="am-tabs" data-am-tabs>
					<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#"> <span
								class="index-needs-dt-txt">宝贝详情</span></a></li>
					</ul>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-fade am-in am-active">
							<div class="J_Brand">

								<div class="attr-list-hd tm-clear">
									<h4>产品参数：</h4>
								</div>
								<div class="clear"></div>
								<ul id="J_AttrUL">
									<!-- 详细参数 -->
								</ul>
								<div class="clear"></div>
							</div>

							<div class="details">
								<div class="attr-list-hd after-market-hd">
									<h4>商品细节</h4>
								</div>
								<div class="twlistNews" id="goodsDetail">
									<!-- 商品细节 -->
								</div>
							</div>
							<div class="clear"></div>

						</div>

					</div>

				</div>

				<div class="clear"></div>
			</div>

		</div>
	</div>
	<!--菜单 -->
	
	
<script type="text/javascript">
	function ajaxFunc(scanUrl){
		$("#searchInput").val(scanUrl);
		$.ajax({
			url: "https://api.shenjian.io",
			async: false,
			data:{
				/* 接口appid */
				appid:"0d9539f3470ea5876a7263a622c5721d",
				/* 目标链接路径 */
				scanUrl: scanUrl
			},
			type:"get",
			dataType:"jsonp",
			success : function(json) {
				//判断是否查询到结果
				if(json.error_code==0){
					var details = json.data.product_details;
					/* 商品名信息 */
					$("#goodsName").append('<h1 id="comName">'	
								+ details.name +
			          			'</h1>');
					$("#goodsId").append(details.product_id);
					
					/* 设置商品图片显示 */
					var imgArray = details.images;
					for ( var index in imgArray) {
						 if(index==0){
							$("#firstImage").append('<a href="#">'
								+ '<img src="'+imgArray[index]["image_url"]+'"'
								+'alt="细节展示放大镜特效" rel="'+imgArray[index]["image_url"]+'" class="jqzoom" /></a>');
						}
						$("#thumblist").append('<li class="tb-selected">'
								+ '<div class="tb-pic tb-s40">'
								+ '<a href="#"><img src="'+imgArray[index]["image_url"]+'"'
								+'mid="'+imgArray[index]["image_url"]+'" big="'+imgArray[index]["image_url"]+'"></a>'
								+ '</div></li>');
					}
					
					/* 显示商品原价价格 */
					if(details.hasOwnProperty("original_price")){
						$("#original_price").append('<dt>原价</dt>'
								+'<dd>'
								+'<em>¥</em><b class="sys_item_mktprice">'+ details.original_price +'</b>'
								+'</dd>');
					}
				
					/* 销量与评价 */
					if(details.hasOwnProperty("month_sales_success_count")){
						$("#commentsAndSales").append('<li class="tm-ind-item tm-ind-sellCount canClick">'
								+'<div class="tm-indcon">'
								+'<span class="tm-label">月销量</span><span class="tm-count">'+ details.month_sales_success_count +'</span>'
								+'</div>'
								+'</li>');
					}
					if(details.hasOwnProperty("comments_count")){
						$("#commentsAndSales").append('<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">'
								+'<div class="tm-indcon">'
								+'<span class="tm-label">累计评价</span><span class="tm-count">'+ details.comments_count +'</span>'
								+'</div>'
								+'</li>')
					}
					
					/* 商品类型 */
					if(details.hasOwnProperty("product_sku_detail")){
						var skuArray = details.product_sku_detail;
						var length=0;
						for(var index in skuArray){
							length++;
							if(index==0){
								$("#sku").append('<li class="sku-line selected" id="comRank">'+ skuArray[index]["sku_name"] +'</li>')
							}else{
								$("#sku").append('<li class="sku-line">'+ skuArray[index]["sku_name"] +'</li>')
							}
						}
						if(length!=0){
							/* 商品数量选择与库存信息 */
							$("#stock").append('<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />'
										+'<input id="text_box" name="" type="text" value="1" style="width:30px;" />'
										+'<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />'
										+'<span id="Stock" class="tb-hidden">库存<span class="stock">'+ skuArray[0]["sku_stock"] +'</span>件</span>');
							$("#current_price").append('<dt>促销价</dt>'
									+'<dd>'
									+'<em>¥</em><b class="sys_item_price" id="comPrice">'+ skuArray[0]["sku_price"] +'</b>'
									+'</dd>');
						}else{
							$("#stock").append('<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />'
									+'<input id="text_box" name="" type="text" value="1" style="width:30px;" />'
									+'<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />'
									+'<span id="Stock" class="tb-hidden">库存<span class="stock">'+ details.stock +'</span>件</span>');
							$("#current_price").append('<dt>促销价</dt>'
									+'<dd>'
									+'<em>¥</em><b class="sys_item_price" id="comPrice">'+ details.current_price +'</b>'
									+'</dd>');
						}
						
					}
					
					if(details.hasOwnProperty("params")){
						var paramArray = details.params;
						for(var index in paramArray){
							$("#J_AttrUL").append('<li title="">'+ paramArray[index]["label"] +':&nbsp;'+ paramArray[index]["value"] +'</li>');
						}
					}
					
					if(details.hasOwnProperty("detail")){
						$("#goodsDetail").append(details.detail);
					}
				}else{
					alert("查询不到该商品！");
				}
			},
			error:function(){		
   				alert("链接接口失败！");
   			}
		})
	}
</script>

<script type="text/javascript">
	$(function(){
		$("#LikBasket").click(function(){
			var comId = $("#goodsId").html();
		    var comPrice = $("#comPrice").html();
			var comName = $("#comName").html();
			var comNum = $("#text_box").val();
			var comImg = $('#firstImage img').attr("src");
			var comRank = $("#comRank").html();
			console.log(comId+","+comPrice+","+comName+","+comNum+","+comImg+","+comRank);
			var commodity = {
					"comid":comId,
					"comprice": comPrice,
					"comname": comName,
					"comnum": comNum,
					"comimg":comImg,
					"comrank":comRank,
					"userId":${sessionScope.member.memberId}
			};
			$.ajax({
				url:"${pageContext.request.contextPath}/commodity/addCommodity",
				data:commodity,
				type:"post",
				async:false,
				success:function(data){
					if(data==true){
						window.location.href="pay.jsp";
					}else{
						alert("添加商品失败~");
					}
				}
			});
			
		});
	})

</script>

<script type="text/javascript">
	function ajax(commodity){
		console.log("添加商品成功~");
		var userorder = {
				"orderName": commodity.comname,
				"orderPrice": commodity.comprice,
				"orderCount": commodity.comnum,
				"orderRank": commodity.comrank,
				"userId":${sessionScope.member.memberId}
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/commodity/addToOrder",
			data:userorder,
			type:"post",
			async:false,
			success: function(data){
				if(data==true){
					
				}
			}
		});
	}

</script>

	

</body>



</html>