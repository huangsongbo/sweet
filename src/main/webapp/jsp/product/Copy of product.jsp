<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>商品列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript">
    	var cPath="<%=request.getContextPath()%>";
    </script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/product/product.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.min.js"></script>
    <link>
</head>
<body>
	<div class="container">
		<!-- 菜单区 -->
	  	<div class="jumbotron">
			<%@ include file="../base/menu.jsp" %>
  		</div>
  		<!-- 菜单区->end -->
  		<!-- 列表区 -->
  		<div>
  		
  			<div class="row">
  				<div class="col-sm-4"><h2>商品列表</h2></div>
  				<div class="col-sm-4">
					<div class="dropdown">
					    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" style="margin-top:20px">功能区
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					        <li role="presentation">
					            <a role="menuitem" tabindex="-1" data-toggle="modal" data-target="#myModal">新增</a>
					        </li>
					    </ul>
					</div>		
  				</div>
  			</div>
  			
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th style="width: 50px">序号</th>
							<th style="width: 100px">商品名称</th>
							<th style="width: 100px">品牌</th>
							<th style="width: 100px">港币</th>
							<th style="width: 100px">描述</th>
							<th style="width: 100px">操作</th>
						</tr>
					</thead>
					<tbody id="tableList" >
						<!-- 显示列表 -->
						<tr><td><a href="#"></a></td></tr>
					</tbody>
				</table>
			</div>
			
		</div>
		<!-- 列表区->end -->
	</div>
	<!-- 新增商品弹窗 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<!-- 新增商品页面 -->
		<%@ include file="../product/product_add.jsp" %>
	</div>
	</div>
	<!-- 新增商品弹窗->end -->
</body>
</html>