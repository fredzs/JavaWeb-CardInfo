<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<div class="divpage">
			<s:include value="/template/_pager.jsp">
				<s:param name="url">
					searchSsardByCondition?index=card&searchValue=<s:property value="card_num"/>&
				</s:param>	
			</s:include>
		</div>
		<div class="contentline">
			<table border="1" class="list_style table_fixed" id="main_list">
				<colgroup><col><col><col>
				<thead>
					<tr class="tcat text_center">
						<td width="5" style="font-weight:bold;">序号</td>
						<td width="150" style="font-weight:bold;">卡信息</td>
						<td width="120" style="font-weight:bold;">绑定信息</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="result" id="ulist" status="re">
						<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
							<td >
								<table border="0" class="list_style" id="main_list">
									<tbody>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td><s:property value="%{#re.getIndex()+1}"/></td>
										</tr>
									</tbody>
								</table>
							</td>
							<td>
								<table border="1" class="list_style table_fixed" id="main_list">
									<tbody>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td width="30" style="font-weight:bold;">姓名</td>
											<td width="60"><s:property value="#ulist.userName" /></td>
											<td width="30" style="font-weight:bold;">身份证号</td>
											<td width="80"><s:property value="#ulist.idNum" /></td>
										</tr>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td style="font-weight:bold;">社保号码</td>
											<td><s:property value="#ulist.sscardNum" /></td>
											<td style="font-weight:bold;">使用情况</td>
											<td><s:if test="#ulist.cardCondition==1">使用中</s:if><s:else>未使用</s:else></td>
										</tr>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td>  </td>
											<td>  </td>
											<td style="font-weight:bold;">操作</td>
											<td><a href="getOldSscard?id=<s:property value="#ulist.id"/>" rel="facebox" title="修改社保卡用户" size="s">修改</a>
			                            		<a href="javascript:remove(<s:property value="#ulist.id" />)">删除</a></td>
										</tr>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td>
								<table border="1" class="list_style table_fixed" id="main_list">
									<tbody>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td width="60" style="font-weight:bold;">app_userid</td>
											<td width="210"><s:property value="%{banding_list[#re.index].id}"/></td>
										</tr>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td style="font-weight:bold;">绑定姓名</td>
											<td><s:property value="%{banding_list[#re.index].name}"/></td>
										</tr>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td style="font-weight:bold;">绑定手机</td>
											<td><s:property value="%{banding_list[#re.index].phone}"/></td>
										<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
											<td style="font-weight:bold;">绑定密码</td>
											<td><s:property value="%{banding_list[#re.index].password}"/></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div class="divpage">
			<s:include value="/template/_pager.jsp">
				<s:param name="url">
					searchSsardByCondition?index=card&searchValue=<s:property value="card_num"/>&
				</s:param>	
			</s:include>
		</div>
	</body>
</html>