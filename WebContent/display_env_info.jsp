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
					<div class="divline">
						<s:if test="cardEnv==0">测试01</s:if><s:elseif test="cardEnv==1">测试02</s:elseif><s:elseif test="cardEnv==2">测试03</s:elseif><s:else>开发</s:else>
						环境中用户信息一览
					</div>
					<div class="divpage">
						<s:include value="/template/_pager.jsp">
							<s:param name="url">
								showAllEnvUserInfo?index=env&
							</s:param>	
						</s:include>
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
				</div>
			</div>
			<s:include value="/template/_footer.jsp" />
		</div>
		<s:include value="/template/_common_js.jsp" />
	</body>
</html>