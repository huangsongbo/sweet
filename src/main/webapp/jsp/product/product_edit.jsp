<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/product/product_edit.js"></script>
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
			&times;
		</button>
		<h4 class="modal-title" id="myModalLabel">
			编辑产品
		</h4>
	</div>
	<form id="product_edit_form">
		<!-- 产品id -->
		<input type = "hidden" id = "product_edit_id" name = "id">
		<div class="modal-body">
			<table>
				<tr style="height: 50px">
					<td style="width: 100px">名称:</td>
					<td style="width: 100px"><input type="text" id="product_edit_name" name="name"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 100px">品牌:</td>
					<td style="width: 100px">
						<!-- 隐藏属性:该产品选择的品牌id -->
						<!-- <input type = "hidden" id = "product_edit_form_brand_id"/> -->
						<select class="form-control" id="product_edit_form_brand_select" name="brandId">
						<!-- <option>test1</option><option>test2</option> -->
						</select>
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 100px">港币($):</td>
					<td style="width: 100px"><input type="text" id="product_eidt_hkd" name="hkd"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 100px">描述:</td>
					<td style="width: 100px"><input type="text" id="product_eidt_description" name="description"/></td>
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