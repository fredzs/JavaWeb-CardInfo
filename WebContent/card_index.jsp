<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>京医通卡用户信息一览</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="/template/_head.jsp" />
		<link href="css/main.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/main.js"></script>
	</head>
	<body>
		<div id="container">
			<div id="inner">
				<s:include value="/template/_banner.jsp?menu=1" />
				<s:include value="/template/_left.jsp" />
				<div class="right" id="right">
					<s:include value="/template/_inner_header.jsp" />
					<div id = "default">
					</div>
				</div>
			</div>
			<s:include value="/template/_footer.jsp" />
		</div>
		<s:include value="/template/_common_js.jsp" />
		<script type="text/javascript" charset="gb2312">
		</script>
	</body>
</html>