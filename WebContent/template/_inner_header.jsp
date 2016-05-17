<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="divline">
	<s:if test="cardEnv==0">测试01</s:if><s:elseif test="cardEnv==1">测试02</s:elseif><s:elseif test="cardEnv==2">测试03</s:elseif><s:else>开发</s:else>
	环境中用户信息一览
</div>
<div class="divline_inner">
	<a class="bigbluebutton" href="showAllCardBandingInfo?index=card&cardEnv=<s:property value="cardEnv" />"><img src="imgs/ChaPsw.png" >全部京医通卡</a>
	<a class="bigbluebutton" href="showAllSscardBandingInfo?index=card&cardEnv=<s:property value="cardEnv" />"><img src="imgs/ChaPsw.png">全部社保卡</a>
	<a class="button rightfloat" href="facebox/_facebox_addSscardUser.jsp" rel="facebox" title="增加社保卡用户" size="s">增加社保卡用户</a>
	<a class="button rightfloat" href="facebox/_facebox_addCardUser.jsp" rel="facebox" title="添加京医通卡用户" size="s">增加京医通用户</a>
</div>
<div class="contentline">
	<s:form theme="simple" method="post">  
	    <table class="datatable">  
	        <tr><td>查找京医通卡</td	>	<td>(批量查询，每行一个)</td>	<td></td>	<td></td>	<td>(批量查询，每行一个)</td>	<td></td></tr>  
	        <tr>  
	            <td style="text-align: right">卡号: </td>  
	            <td style="width:120px;"><s:textarea id="cardNum" name="cardNum" label="卡号"/></td>
	            <td><div class="contentline"><input type="button" value="提交" class="button leftmargin_10" onclick="findCard('cardNum')">	</div></td> 
	            <td style="text-align: right">姓名: </td>  
	            <td style="width:120px;"><s:textarea id="userName" name="userName" label="姓名"/></td>
	            <td><div class="contentline"><input type="button" value="提交" class="button leftmargin_10" onclick="findCard('userName')">	</div></td> 
	        </tr>  
	        <tr><td>查找社保卡</td>		<td>(批量查询，每行一个)</td>	<td></td>	<td></td>	<td>(批量查询，每行一个)</td>	<td></td></tr>  
	        <tr>  
	            <td style="text-align: right">卡号: </td>  
	            <td style="width:120px;"><s:textarea id="sscardNum" name="sscardNum" label="卡号"/></td>
	            <td><div class="contentline"><input type="button" value="提交" class="button leftmargin_10" onclick="findSscard('sscardNum', 'sscardNum')">	</div></td> 
	            <td style="text-align: right">姓名: </td>  
	            <td style="width:120px;"><s:textarea id="ssuserName" name="ssuserName" label="姓名"/></td>
	            <td><div class="contentline"><input type="button" value="提交" class="button leftmargin_10" onclick="findSscard('userName', 'ssuserName')">	</div></td> 
	        </tr>  
	    </table>  
	</s:form>
</div><!--contentline-->
