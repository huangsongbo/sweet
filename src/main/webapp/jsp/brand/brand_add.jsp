<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/brand/brand_add.js"></script>
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
			&times;
		</button>
		<h4 class="modal-title" id="myModalLabel">
			新增产品
		</h4>
	</div>
	<form id="brand_add_form">
	<div class="modal-body">
		<table>
			<tr style="height: 50px">
				<td style="width: 100px">品牌名称:</td><td style="width: 100px"><input type="text" name="name" /></td>
			</tr>
			<tr style="height: 50px">
				<td style="width: 100px">描述:</td><td style="width: 100px"><input type="text" name="description"/></td>
			</tr>
		</table>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭
		</button>
		<button type="submit" class="btn btn-primary">
			提交
		</button>
	</div>
	</form>
</div>