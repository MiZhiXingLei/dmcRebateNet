<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>购物车页面</title>
<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
						target="_top">免费注册</a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="#" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="#" target="_top"><i
						class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h">0</strong></a>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
				</div>
		</ul>
	</div>

	<!--悬浮搜索框-->

	<div class="nav white">
		<div class="logo">
			<img src="../images/logo.png" />
		</div>
		<div class="logoBig">
			<li><img src="../images/logobig.png" /></li>
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit">
			</form>
		</div>
	</div>

	<div class="clear"></div>

	<!--购物车 -->
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
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
					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>

			<tr class="item-list">
				<div class="bundle  bundle-last ">
					<div id="mainlist" class="bundle-main">
						
					</div>
				</div>
			</tr>
		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
			<div id="J_SelectAll2" class="select-all J_SelectAll">
				<div class="cart-checkbox">
					<input class="check-all check" id="J_SelectAllCbx2"
						name="allSel" value="" type="checkbox"> <label
						for="J_SelectAllCbx2"></label>
				</div>
				<span>全选</span>
			</div>
			<div class="operations">
				<a href="javascript:" onclick="shops_del()" name="" hidefocus="true" class="deleteAll">批量删除</a> <a href="#"
					hidefocus="true" class="J_BatchFav">移入收藏夹</a>
			</div>
			<div class="float-bar-right">
				<div class="amount-sum">
					<span class="txt">已选商品</span> <em id="J_SelectedItemsCount"></em><span
						class="txt">件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span> <span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span> <strong class="price">¥<em
						id="J_Total"></em></strong>
				</div>
				<div class="btn-area">
					<a href="pay.html" id="J_Go" class="submit-btn submit-btn-disabled"
						aria-label="请注意如果没有选择宝贝，将无法结算"> <span>结&nbsp;算</span></a>
				</div>
			</div>

		</div>

		<div class="footer">
			<div class="footer-hd">
				<p>
					<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
						href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
				</p>
			</div>
			<div class="footer-bd">
				<p>
					<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
						href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
						href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a></em>
				</p>
			</div>
		</div>

	</div>

	<!--操作页面-->

	<div class="theme-popover-mask"></div>

	<div class="theme-popover">
		<div class="theme-span"></div>
		<div class="theme-poptit h-title">
			<a href="javascript:;" title="关闭" class="close">×</a>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin" id="forms" name="loginform" method="post">

				<div class="theme-signin-left">

					<li class="theme-options">
						<div class="cart-title">规格：</div>
						<ul id="options">
						
						</ul>
					</li>
					<div class="theme-options">
						<div class="cart-title number">数量</div>
						<dd>
							<input class="min am-btn am-btn-default" type="button" value="-" />
							<input class="text_box" id="Qty" name="Qty" onchange="getSum()" type="text" value="1" style="width: 30px;" />
							<input class="add am-btn am-btn-default" type="button" value="+" />
						</dd>

					</div>
					<div class="clear"></div>
					<div class="btn-op">
						<div onclick="updShops()" class="btn am-btn am-btn-warning">确认</div>
						<div class="btn close am-btn am-btn-warning">取消</div>
					</div>

				</div>
				<div class="theme-signin-right">
					<div class="img-info">
						<img id="img" src="../images/kouhong.jpg_80x80.jpg" />
					</div>
					<div class="text-info">
						<span id="comDisPrice" class="J_Price price-now">¥39.00</span> <span id="Stock"
							class="tb-hidden">库存<span id="comNum" class="stock">1000</span>件
						</span>
					</div>
				</div>
				<input id="shopsId" name="shopsId" type="hidden">
				<input id="prodId" name="prodId" type="hidden">
				<input id="protoTamt" name="protoTamt" type="hidden">
			</form>
		</div>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>
	</div>
</body>
<script type="text/javascript" src="../layer/layer.js"></script>
<script type="text/javascript">
window.onload = function(){
	pages(10010); //${sessionScope.members.memberId}
	//选择产品的类型
	$("#options li").each(function() {
		$(this).click(function() {
			var Irank = $(this).text();
			var prodId = Irank.substring(0,4);
			var comRank = Irank.substring(5,Irank.length);
			$("#prodId").val(prodId);
			$.ajax({
			    url:"../../com/queryComsById",
		        type:"GET",
		        data:{'prodId':prodId},
		        dataType:"json",
		        success :function (result){
		        	var data = JSON.parse(result);
		        	$("#comDisPrice").html(data.comdisprice);
		        	$("#comNum").html(data.comnum);
		        	/* document.getElementById('img').src = data.comImg; */
		        },
		        error:function (){
		    	    layer.msg('服务器连接失败!',{icon: 1});
			    }
			});
		});
	});
	setInterval("getAllSum()",500);
	$("[name='allSel']").click(function(){
		if($(this).is(":checked")){
			$("[name='select']").prop('checked',true);
		}else{
			$("[name='select']").prop('checked',false);
		}
	});
}

function selects(){
	var allSel = false;
	$("[name='select']").each(function(){
		if(!$(this).is(":checked")){
			allSel = true;
		}
	})
	var countsCheckBox = $("input[type='checkbox']");
	if(countsCheckBox.length > 1){
	    if(allSel){
		    $("[name='allSel']").prop('checked',false);
	    }else{
		    $("[name='allSel']").prop('checked',true);
	    }
	}
}

function pages(shopsid){	
	$.ajax({
        url:"../../shops/queryShops",
        type:"GET",
        dataType:"json",
        data:{"shopId":shopsid},
        success :function (result){
        	     if(result != null){
        	    	 $("#mainlist ul").each(function(index,element){
			             element.remove();
		             });
		             $.each(result,function(index,type){
					 var box ='<ul class="item-content clearfix"><li class="td td-chk"><div class="cart-checkbox "><input name="select" onclick="selects()" class="check" value="'+type.prodid+'" type="checkbox"></div></li>'
		             +'<li class="td td-item"><div class="item-pic"><a href="introduction.html" target="_blank" data-title="'+type.comoditys.comname+'" class="J_MakePoint"data-point="tbcart.8.12"> <img src="../images/browse1.jpg"itempicJ_ItemImg"></a></div><div class="item-info"><div class="item-basic-info"><a href="introduction.html" target="_blank" title="'+type.comoditys.comname+'" class="item-title J_MakePoint" data-point="tbcart.8.11">'+type.comoditys.comname+'</a></div></div></li>'
		             +'<li class="td td-info"><div class="item-props item-props-can"><span class="sku-line">'+type.prodid+type.comoditys.comrank+'</span> <span tabindex="0" onclick="save('+type.shopid+','+type.prodid+',\''+type.comoditys.comname+'\','+type.qty+',\''+type.comoditys.comimg+'\','+type.comoditys.comnum+','+type.comoditys.comdisprice+')" class="btn-edit-sku theme-login">修改</span> <i class="theme-login am-icon-sort-desc"></i></div></li>'
		             +'<li class="td td-price"><div class="item-price price-promo-promo"><div class="price-content"><div class="price-line"><em class="price-original">'+type.comoditys.comprice+'</em></div><div class="price-line"><em class="J_Price price-now" tabindex="0">'+type.comoditys.comdisprice+'</em></div></div></div></li>'
		             +'<li class="td td-amount"><div class="amount-wrapper "><div class="item-amount "><div class="sl"><input class="min am-btn" onclick="upd('+type.shopid+','+type.prodid+','+type.comoditys.comdisprice+','+(type.qty-1)+')" type="button" value="-" /><input class="text_box" onchange="upd('+type.shopid+','+type.prodid+','+type.comoditys.comdisprice+',$(this).val())" type="text" value="'+type.qty+'" style="width: 30px;" /><input class="add am-btn" onclick="upd('+type.shopid+','+type.prodid+','+type.comoditys.comdisprice+','+(type.qty+1)+')" type="button" value="+" /></div></div></div></li>'
		             +'<li class="td td-sum"><div class="td-inner"><em tabindex="0" name="sum" class="J_ItemSum number">'+type.prototamt+'</em></div></li>'
		             +'<li class="td td-op"><div class="td-inner"><a title="移入收藏夹" class="btn-fav" href="#"> 移入收藏夹</a> <a href="javascript:;" onclick="delCom('+type.shopid+','+type.prodid+')" data-point-url="#" class="delete"> 删除</a></div></li></ul>';
		             
		             $("#mainlist").append(box); 
		             });
        	     }
        },
		error:function (){
        	layer.msg('服务器连接失败!',{icon: 1});
		}
	});
}

/* 保存商品信息  */
function save(shopId,prodId,comName,qty,comImg,comNum,comDisPrice){
	$("#shopId").val(shopId);
	$("#prodId").val(prodId);
	$("#qty").val(qty);
	$("#comNum").html(comNum);
	$("#comDisPrice").html(comDisPrice);
	/* document.getElementById('img').src = comImg; */
	$.ajax({
	    url:"../../com/queryComsByName",
        type:"GET",
        data:{'comName':comName},
        dataType:"json",
        success :function (result){
        	$.each(result.data,function(index,type){
        		$("#options").append('<li class="sku-line">'+type.comoditys.comid+'/"'+type.comoditys.comrank+'/"</li>');
        	});
        },
        error:function (){
    	    layer.msg('服务器连接失败!',{icon: 1});
	    }
	});
}

/* 获取所有商品的总价 */
function getAllSum(){
	selects();
	var countsCheckBox = $("input[type='checkbox']:checked");
    var prodsid = []; 
    if(countsCheckBox.length != 0){ 
    	if(countsCheckBox[countsCheckBox.length-1].value != ""){
   	        $("#J_SelectedItemsCount").html(countsCheckBox.length);
   	        for(var i=0;i<countsCheckBox.length;i++){ 
                sendprod_id = {}; 
                sendprod_id['prod_id'] = countsCheckBox[i].value; 
                prodsid[i] = sendprod_id; 
            } 
   	    }else{
   	        $("#J_SelectedItemsCount").html(countsCheckBox.length-1);
   	        for(var i=0;i<countsCheckBox.length-1;i++){ 
                sendprod_id = {}; 
                sendprod_id['prod_id'] = countsCheckBox[i].value; 
                prodsid[i] = sendprod_id; 
            } 
   	    }
        $.ajax({ 
            url:'../../shops/queryAllSum/'+10010, //${sessionScope.shops.shopid}
            data:JSON.stringify(prodsid), 
            type:'PUT', 
            dataType: 'json',
            success:function(data){
            	$("#J_Total").html(data);
            } 
        }); 
    }else{
    	$("#J_SelectedItemsCount").html(0);
    	$("#J_Total").html(0);
    }
}

/* 修改商品信息 */
function updShops(){
	$("#forms").ajaxSubmit({
		type: 'PUT',
		url: "../../shops/updShops", 
		dataType : "json",
	    success: function(result) {
	    	if(true == result){
        	    pages(10010); //${sessionScope.members.memberId}
        	}
	    }
	});
}

/* 删除购物车中的商品 */
function delCom(shopsId,prodId){
	$.ajax({
	    url:"../../shops/delShop/"+shopsId+"/"+prodId,
        type:"DELETE",
        dataType:"json",
        success :function (result){
        	if(true == result){
        	    pages(10010);  //${sessionScope.members.memberId}
        	}
        },
        error:function (){
    	    layer.msg('服务器连接失败!',{icon: 1});
	    }
	});
}

/*用于批量删除的方法*/
function shops_del(){
    var countsCheckBox = $("input[type='checkbox']:checked"); 
    var prodsid = []; 
    if(countsCheckBox.length != 0){ 
    	if(countsCheckBox[countsCheckBox.length-1].value != ""){
   	        for(var i=0;i<countsCheckBox.length;i++){ 
                sendprod_id = {}; 
                sendprod_id['prod_id'] = countsCheckBox[i].value; 
                prodsid[i] = sendprod_id; 
            } 
   	    }else{
   	        for(var i=0;i<countsCheckBox.length-1;i++){ 
                sendprod_id = {}; 
                sendprod_id['prod_id'] = countsCheckBox[i].value; 
                prodsid[i] = sendprod_id; 
            } 
   	    }
        layer.confirm('确认要删除吗？',function(index){ 
            //开始请求删除 
            $.ajax({ 
                 url:'../../shops/delShops/'+10010, //${sessionScope.shops.shopid}
                 data:JSON.stringify(prodsid), 
                 type:'DELETE', 
                 dataType: 'json',
                 success:function(data){
                	 layer.msg("删除成功！",{icon: 5,time:1000});
                	 pages(10010);   //${sessionScope.members.memberId}
                 } 
            }); 
        });
    }else{
    	layer.msg('请勾选目标对象!',{icon:1,btn:['OK']});
    }
}
/* 清空购物车中的商品 */
function delComs(){
	$.ajax({
	    url:"../../shops/delAll/"+10010, //${sessionScope.members.memberId}
        type:"DELETE",
        dataType:"json",
        success :function (result){
        	if(true == result){
        	    pages(10010);  //${sessionScope.members.memberId}
        	}
        },
        error:function (){
    	    layer.msg('服务器连接失败!',{icon: 1});
	    }
	});
}

/* 修改商品信息 */
function upd(shopid, prodid, comdisprice, num){
	if(num<1){
		num = 1;
	}
	var prototamt = comdisprice*num;
	$.ajax({
	    url:"../../shops/updShops/"+shopid+"/"+prodid+"/"+num+"/"+prototamt,
        type:"PUT",
        dataType:"json",
        success :function (result){
        	if(true == result){
        	     pages(10010);  //${sessionScope.members.memberId}
        	}
        },
        error:function (){
    	    layer.msg('服务器连接失败!',{icon: 1});
	    }
	});
}
</script>
</html>