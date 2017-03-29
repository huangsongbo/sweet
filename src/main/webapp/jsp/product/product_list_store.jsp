<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/product/product_list_store.js"></script>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-4"><h2>商品 <a href = "#" onclick = "tableList('product')">列表</a>/<a href = "#" onclick = "tableList('productStore')">价目</a></h2></div>
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
				<c:forEach var="item" items="${storeNameList }">
					<th style="width: 100px">${item }</th>
				</c:forEach>
				<th style="width: 100px">操作</th>
			</tr>
		</thead>
		<tbody id="tableList" >
			<!-- 显示列表 -->
			<c:forEach var="item" items="${list }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${item.name }</td>
					<c:forEach var="itemPrice" items="${item.priceList }">
						<td>${itemPrice }</td>
					</c:forEach>
					<td>编辑</td>
				</tr>
			</c:forEach>
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
<!-- 编辑商品弹窗 -->
<div class="modal fade" id="product_edit_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<!-- 编辑商品页面 -->
		<%@ include file="../product/product_edit_store.jsp" %>
	</div>
</div>
<!-- 编辑商品弹窗->end -->