<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>全部预订信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="/template/_head.jsp" />
		<link href="css/main.css" rel="stylesheet" type="text/css" />
		
	</head>
	<body>
		<div class="divline">
			查询结果列表
		</div>
		<div class="contentline">
			<table border="1" class="list_style table_fixed" id="main_list">
				<colgroup><col><col><col><col>
				<thead>
					<tr class="tcat text_center">
						<td width="60">序号</td>
						<td width="60">姓名</td>
						<td width="120">手机号码</td>
	                  	<td width="60">实名制</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="show_result_list" id="ulist" status="re">
						<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
							<td><s:property value="%{#re.getIndex()+1}"/></td>
							<td><s:property value="#ulist.name" /></td>
							<td><s:property value="#ulist.phone" /></td>
							<td><s:property value="#ulist.authentication" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<script type="text/javascript" src="js/tablesort.js"></script>
	</body>
</html>