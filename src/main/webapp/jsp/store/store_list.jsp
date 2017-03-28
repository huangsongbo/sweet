<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/store/store_list.js"></script>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-4"><h2>门店列表</h2></div>
	<div class="col-sm-4">
		<div class="dropdown">
			<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" style="margin-top:20px">功能区
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation">
			    	<a role="menuitem" tabindex="-1" data-toggle="modal" data-target="#store_add_model">新增</a>
			    </li>
			</ul>
		</div>
	</div>
</div>
		
<div class="table-responsive">
	<table class="table table-striped table-bordered">
		<thead>
			<!-- 标题 -->
			<tr>
				<th style="width: 50px">序号</th>
				<th style="width: 100px">门店名称</th>
				<th style="width: 100px">描述</th>
				<th style="width: 100px">操作</th>
			</tr>
		</thead>
		<tbody id="tableList" >
			<!-- 显示列表 -->
			<c:forEach var = "item" items = "${list }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${item.name }</td>
					<td>${item.description }</td>
					<td><a href = "#" onclick= "">编辑</a>&nbsp;&nbsp;</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id = "jspEnd"></div>
<!-- 新增商品弹窗 -->
<div class="modal fade" id="store_add_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
	<!-- 新增商品页面 -->
	<%@ include file="../store/store_add.jsp" %>
</div>
</div>
<!-- 新增商品弹窗->end -->
