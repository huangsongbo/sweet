<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>首页</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery.validate.js"></script>
    <script type="text/javascript">
    	var cPath="<%=request.getContextPath()%>";
    </script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/base/home.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/jquery.bootstrap.teninedialog.v3.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<!-- 菜单区 -->
	  	<div class="jumbotron">
			<%@ include file="../base/menu.jsp" %>
  		</div>
  		<!-- 菜单区->end -->
  		<!-- 列表区 -->
  		<div id="mainTable">
			<%@ include file="../product/product_list.jsp" %>
		</div>
		<!-- 列表区->end -->
	</div>
</body>
</html>