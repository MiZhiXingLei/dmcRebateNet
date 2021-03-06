<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="../css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="../js/address.js"></script>

	</script>

<script type="text/javascript">
	$(function(){
		query();
	})
	
	function query(){
		$.ajax({
			url:"${pageContext.request.contextPath}/userOrder/showOrder",
			data:{"userId":${sessionScope.member.memberId}}, 
			success :function (result){
        	     if(result != null){
        	    	 console.log(result);
        	    	 $("#mainlist ul").each(function(index,element){
			             element.remove();
		             });
		             $.each(result,function(index,type){
					 var box ='<ul class="item-content clearfix"><div class="pay-phone"><li class="td td-item"><div class="item-info"><div class="item-basic-info"><a href="introduction.html" class="item-title J_MakePoint" data-point="tbcart.8.11">'+type.ordername+'</a>'
					 +'</div></div></li><li class="td td-info"><div class="item-props"><span class="sku-line">'+type.orderrank+'</span></div></li><li class="td td-price"><div class="item-price price-promo-promo"><div class="price-content"><em class="J_Price price-now">'+type.orderprice+'</em>'
					 +'</div></div></li></div><li class="td td-amount"><div class="amount-wrapper "><div class="item-amount "><span class="phone-title">购买数量</span><div class="sl"><input class="min am-btn" onclick="upd('+type.orderid+','+type.orderprice+','+(type.ordercount-1)+')" type="button" value="-" /><input class="text_box" onchange="upd('+type.orderid+','+type.orderprice+',$(this).val())" type="text" value="'+type.ordercount+'" style="width:30px;" /><input class="add am-btn" onclick="upd('+type.orderid+','+type.orderprice+','+(type.ordercount+1)+')" type="button" value="+" />'
					 +'</div></div></div></li><li class="td td-sum"><div class="td-inner"><em tabindex="0" class="J_ItemSum number">'+type.orderprototamt+'</em></div></li><li class="td td-oplist"><div class="td-inner"><span class="phone-title">配送方式</span><div class="pay-logis">'
					 +'快递<b class="sys_item_freprice">10</b>元</div></div></li></ul>';
		             $("#mainlist").append(box); 
		             getAllSum();
		             });
        	     }
	        },
	        error:function (){
	    	    layer.msg('服务器连接失败!',{icon: 1});
		    }
		});
	}
 
	/* 修改商品信息 */
	function upd(orderid, orderprice, ordercount){
		if(ordercount<1){
			ordercount = 1;
		}
		var prototamt = orderprice*ordercount;
		$.ajax({
		    url:"${pageContext.request.contextPath}/userOrder/updateNum/"+orderid+"/"+ordercount+"/"+prototamt,
	        type:"PUT",
	        dataType:"json",
	        success :function (result){
	        	if(true == result){
	        		query();
	        	}
	        },
	        error:function (){
	    	    layer.msg('服务器连接失败!',{icon: 1});
		    }
		});
	}
	
	function getAllSum(){
		$.ajax({
			url:"${pageContext.request.contextPath}/userOrder/queryAllSum",
			data:{"userId":${sessionScope.member.memberId}}, 
			success :function (result){
				$("#J_ActualFee").html(result);
				$("#J_ActualFee2").html(result);
			}
		});
	}
</script>
	
	</head>
	

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="login.html" target="_top" class="h">亲，请登录</a>
						<a href="register.html" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="home1.html" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="shopcart.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						<ul>
							<div class="per-border"></div>
							<c:forEach items="${addlist}" var="add" varStatus="co" >
							<c:choose>
							 <c:when test="${co.count==1}">
							 <li class="user-addresslist defaultAddr">

								<div class="address-left">
									<div class="user DefaultAddr">

										<span class="buy-address-detail">   
                   <span class="buy-user">${add.recivername} </span>
										<span class="buy-phone">${add.reciverphone}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								   <span class="province">
								        <span>${add.uadd}</span>
										<span class="street">${add.detailadd}</span>
										</span>

										</span>
									</div>
									<c:if test="${co.count == 1}">
									<ins class="deftip">默认地址</ins>
									</c:if>
								</div>
								<div class="address-right">
									<a href="../person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<a href="#" class="hidden">设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(${add.addid});">删除</a>
								</div>

							</li>
							
							 </c:when>
							 <c:otherwise>
							 <li class="user-addresslist ">

								<div class="address-left">
									<div class="user DefaultAddr">

										<span class="buy-address-detail">   
                   <span class="buy-user">${add.recivername} </span>
										<span class="buy-phone">${add.reciverphone}</span>
										</span>
									</div>
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span>
										<span class="buy--address-detail">
								   <span class="province">
								        <span>${add.uadd}</span>
										<span class="street">${add.detailadd}</span>
										</span>

										</span>
									</div>
									<c:if test="${co.count == 1}">
									<ins class="deftip">默认地址</ins>
									</c:if>
								</div>
								<div class="address-right">
									<a href="../person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>

								<div class="new-addr-btn">
									<a href="#" class="hidden">设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(${add.addid});">删除</a>
								</div>

							</li>
							 </c:otherwise>
							</c:choose>
							</c:forEach>
							<div class="per-border"></div>
						</ul>

						<div class="clear"></div>
					</div>
					<!--物流 -->
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
							<li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
							<li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="../images/wangyin.jpg" />银联<span></span></li>
							<li class="pay qq"><img src="../images/weizhifu.jpg" />微信<span></span></li>
							<li class="pay taobao"><img src="../images/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

									<div class="th th-item">
										<div class="td-inner">商品信息</div>
									</div>
									<div class="th th-price">
										<div class="td-inner">单价</div>
									</div>
									<div class="th th-amount">
										<div class="td-inner">数量</div>
									</div>
									<div class="th th-sum">
										<div class="td-inner">金额</div>
									</div>
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>

								</div>
							</div>
							<div class="clear"></div>

							<tr class="item-list">
								<div class="bundle  bundle-last">
									<div id="mainlist" class="bundle-main">
						
									</div>
							</tr>
							<div class="clear"></div>
							</div>

						
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>

							</div>
							<!--优惠券 -->
							<div class="buy-agio">
								<li class="td td-coupon">

									<span class="coupon-title">优惠券</span>
									<select data-am-selected>
										<option value="a">
											<div class="c-price">
												<strong>￥500</strong>
											</div>
											<div class="c-limit">
												【消费满1元可用】
											</div>
										</option>
										<option value="b" selected>
											<div class="c-price">
												<strong>￥100</strong>
											</div>
											<div class="c-limit">
												【无使用门槛】
											</div>
										</option>
									</select>
								</li>

								<li class="td td-bonus">

									<span class="bonus-title">红包</span>
									<select data-am-selected>
										<option value="a">
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>10.40<span>元</span>
											</div>
										</option>
										<option value="b" selected>
											<div class="item-info">
												¥50.00<span>元</span>
											</div>
											<div class="item-remainderprice">
												<span>还剩</span>50.00<span>元</span>
											</div>
										</option>
									</select>

								</li>

							</div>
							<div class="clear"></div>
							</div>
							<!--含运费小计 -->
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计（含运费） <span>¥</span><em id="J_ActualFee2" class="pay-sum">244.00</em>
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">244.00</em>
											</span>
										</div>

										<div id="holyshit268" class="pay-address">

											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
								   <span class="province">福建</span>省
												<span class="city">厦门</span>市
												<span class="dist">湖里</span>区
												<span class="street">观日路2号楼</span>
												</span>
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail">   
                                         <span class="buy-user">阿瓜 </span>
												<span class="buy-phone">15871145629</span>
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<a id="J_Go" href="success.html" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
				<div class="footer">
					<div class="footer-hd">
						<p>
							<a href="#">恒望科技</a>
							<b>|</b>
							<a href="#">商城首页</a>
							<b>|</b>
							<a href="#">支付宝</a>
							<b>|</b>
							<a href="#">物流</a>
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
							<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
						</p>
					</div>
				</div>
			</div>
			<div class="theme-popover-mask"></div>
			<div class="theme-popover">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
					<form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/add/location" method="post">

						<div class="am-form-group">
							<label for="user-name" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="user-name" name="recivername" placeholder="收货人">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="user-phone" placeholder="手机号必填" name="reciverphone" type="tel">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">所在地</label>
							<div class="am-form-content address">
								<select data-am-selected id="s_province" name="s_province"></select><select data-am-selected id="s_city" name="s_city" ></select><select data-am-selected  id="s_county" name="s_county"></select>
                                 <script class="resources library" src="../js/area.js" type="text/javascript"></script>
                                <script type="text/javascript">_init_area();</script>
							</div>
							<div id="show"></div>
						</div>
                        
						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" rows="3" id="user-intro" name="detailadd" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
							    <input type="submit" class="am-btn am-btn-danger" value="保存"/>
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				</div>

			</div>

			<div class="clear"></div>
			
			
			<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
			<script type="text/javascript">
			
			$(function(){
				
				var Gid  = document.getElementById ;
				var showArea = function(){
					Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +Gid('s_city').value + " - 县/区" +Gid('s_county').value + "</h3>"
					}
				    Gid('s_county').setAttribute('onchange','showArea()');
			
				   
			});
			function delClick(id){
				   location.href="${pageContext.request.contextPath}/add/dele?addid="+id;
			   }
			<script type="text/javascript" src="../js/address.js"></script>

</script>
	</body>

</html>