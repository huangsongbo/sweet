<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/product/product_list.js"></script>
<div class="row">
	<div class="col-sm-4"><h2>商品列表</h2></div>
	<div class="col-sm-4">
	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" style="margin-top:20px">功能区
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
			<li role="presentation">
		    	<a role="menuitem" tabindex="-1" data-toggle="modal" data-target="#product_add_model">新增</a>
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
		</tbody>
	</table>
</div>
<!-- 新增商品弹窗 -->
<div class="modal fade" id="product_add_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
	<!-- 新增商品页面 -->
	<%@ include file="../product/product_add.jsp" %>
</div>
</div>
<!-- 新增商品弹窗->end -->