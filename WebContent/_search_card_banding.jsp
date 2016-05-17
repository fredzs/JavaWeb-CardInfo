<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<div class="divpage">
			<s:include value="/template/_pager.jsp">
				<s:param name="url">
					searchCardByCondition?index=card&searchValue=<s:property value="card_num"/>&
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
										<td width="50" style="font-weight:bold;">姓名</td>
										<td width="100"><s:property value="#ulist.userName" /></td>
										<td width="50" style="font-weight:bold;">电话</td>
										<td width="60"><s:property value="#ulist.telephone" /></td>
									</tr>
									<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
										<td style="font-weight:bold;">京医通卡号</td>
										<td><s:property value="#ulist.cardNum" /></td>
										<td style="font-weight:bold;">卡状态</td>
										<td><s:if test="#ulist.cardStatus==0">正常</s:if><s:elseif test="#ulist.cardStatus==1"><font color="red">临时挂失</font></s:elseif><s:else><font color="red">冻结</font></s:else></td>
									</tr>
									<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
										<td style="font-weight:bold;">证件类型</td>
										<td><s:if test="#ulist.idType==0">居民身份证</s:if><s:elseif test="#ulist.idType==1">护照</s:elseif><s:else>户口簿</s:else></td>
										<td style="font-weight:bold;">使用情况</td>
										<td><s:if test="#ulist.cardCondition==1">使用中</s:if><s:else>未使用</s:else></td>
									</tr>
									<tr class="alt1 text_center" onmouseover="highlight(this,'alt1');">
										<td style="font-weight:bold;">证件号</td>
										<td><s:property value="#ulist.idNum" /></td>
										<td style="font-weight:bold;">操作</td>
										<td><a href="getOldCard?id=<s:property value="#ulist.id"/>" rel="facebox" title="修改京医通卡用户" size="s">修改</a>
                           					<a href="javascript:remove(<s:property value="#ulist.id" />)">删除</a>
                           				</td>
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
					searchCardByCondition?index=card&searchValue=<s:property value="card_num"/>&
				</s:param>	
			</s:include>
		</div>
	</body>
</html>