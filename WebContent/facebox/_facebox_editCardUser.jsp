<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="/template/_head.jsp" />
		<title>修改京医通卡用户</title>
	</head>
	<body>
	    <table class="datatable">
	        <tr>
	           <td width="58"><div align="left">用户姓名<span class="redletter">*</span></div></td>
	           <td width="241"><input id="newUserName" type="text" value="<s:property value="result.userName" />" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">证件类型<span class="redletter">*</span></div></td>
	           <td><s:if test="result.idType==0">		<s:select theme="simple" id="newIdType" name="newIdType" list="#{'0':'居民身份证','1':'护照','2':'户口簿'}" value='0'></s:select></s:if>
	           	<s:elseif test="result.idType==1">	<s:select theme="simple" id="newIdType" name="newIdType" list="#{'0':'居民身份证','1':'护照','2':'户口簿'}" value='1'></s:select></s:elseif>
	           	<s:else>							<s:select theme="simple" id="newIdType" name="newIdType" list="#{'0':'居民身份证','1':'护照','2':'户口簿'}" value='2'></s:select></s:else></td>
	        </tr>
	        <tr>
	           <td><div align="left">京医通卡号<span class="redletter">*</span></div></td>
	           <td><input id="newCardNum" type="text" value="<s:property value="result.cardNum"/>" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">证件号码<span class="redletter">*</span></div></td>
	           <td><input id="newIdNum" type="text" value="<s:property value="result.idNum"/>" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">联系人电话<span class="redletter">*</span></div></td>
	           <td><input id="newTelephone" type="text" value="<s:property value="result.telephone"/>" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">卡状态<span class="redletter">*</span></div></td>
	           <td><s:if test="result.cardStatus==0">		<s:select theme="simple" id="newCardStatus" name="newCardStatus" list="#{'0':'正常','1':'临时挂失','2':'冻结'}" value='0'></s:select></s:if>
	           	<s:elseif test="result.cardStatus==1">	<s:select theme="simple" id="newCardStatus" name="newCardStatus" list="#{'0':'正常','1':'临时挂失','2':'冻结'}" value='1'></s:select></s:elseif>
	           	<s:else>							<s:select theme="simple" id="newCardStatus" name="newCardStatus" list="#{'0':'正常','1':'临时挂失','2':'冻结'}" value='2'></s:select></s:else></td>
	        </tr>
	        <tr>
	           <td><div align="left">使用状态<span class="redletter">*</span></div></td>
	           <td><s:if test="result.cardCondition==0">		<s:select theme="simple" id="newCardCondition" name="newCardCondition" list="#{'0':'未使用','1':'使用中'}" value='0'></s:select></s:if>
	           	<s:else>							<s:select theme="simple" id="newCardCondition" name="newCardCondition" list="#{'0':'未使用','1':'使用中'}" value='1'></s:select></s:else></td>
	        </tr>
	        <tr>
	           <td><div align="left"></div></td>
	           <td><input type="button" class="button" value="修改" onClick="submit()" />
	          	  	<input type="button" class="button" value="取消" onClick="cancle()" /></td>
	        </tr>
	    </table>
	
		<script type="text/javascript" charset="gb2312">
		function submit( ) 
		{
			if($('#newUserName').val()!="")
			{
				if($('#newCardNum').val()!="")
				{
					if($('#newIdNum').val()!="")
					{
						if($('#newTelephone').val()!="")
						{
							$.ajax
							({
								url : 'editCardUser',
								type : 'post',
								data : 
								{
									id : <s:property value="result.id"/>,
									userName : $('#newUserName').val(),
									idType : $('#newIdType').val(),
									cardNum : $('#newCardNum').val(),
									idNum : $('#newIdNum').val(),
									telephone : $('#newTelephone').val(),
									cardStatus : $('#newCardStatus').val(),
									cardCondition : $('#newCardCondition').val()
								},
								success : function(data) 
								{
									$(document).trigger('close.facebox');
									location.reload();
								}
							});
						}
						else
							alert("联系人电话不能为空！");
					}
					else
						alert("证件号码不能为空！");
				}
				else
					alert("京医通卡号码不能为空！");
			}
			else
				alert("用户姓名不能为空！");
		}
		function cancle()
		{
			$(document).trigger('close.facebox');
		}
		</script>
	</body>
</html>