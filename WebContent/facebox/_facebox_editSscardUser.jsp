<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="/template/_head.jsp" />
		<title>修改社保卡用户</title>
	</head>
	<body>
	    <table class="datatable">
	        <tr>
	           <td width="58"><div align="left">用户姓名<span class="redletter">*</span></div></td>
	           <td width="241"><input id="newUserName" type="text" value="<s:property value="result.userName" />" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">身份证号<span class="redletter">*</span></div></td>
	           <td><input id="newIdNum" type="text" value="<s:property value="result.idNum"/>" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">社保卡号<span class="redletter">*</span></div></td>
	           <td><input id="newSscardNum" type="text" value="<s:property value="result.sscardNum"/>" class="editline" /></td>
	        </tr>
	        <tr>
	           <td><div align="left">使用状态<span class="redletter">*</span></div></td>
	           <td><s:if test="result.sscardCondition==0">		<s:select theme="simple" id="newSscardCondition" name="newSscardCondition" list="#{'0':'未使用','1':'使用中'}" value='0'></s:select></s:if>
	           	<s:else>							<s:select theme="simple" id="newSscardCondition" name="newSscardCondition" list="#{'0':'未使用','1':'使用中'}" value='1'></s:select></s:else></td>
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
				if($('#newSscardNum').val()!="")
				{
					if($('#newIdNum').val()!="")
					{
						$.ajax
						({
							url : 'editSscardUser',
							type : 'post',
							data : 
							{
								id : <s:property value="result.id"/>,
								userName : $('#newUserName').val(),
								idNum : $('#newIdNum').val(),
								sscardNum : $('#newSscardNum').val(),
								sscardCondition : $('#newSscardCondition').val()
							},
							success : function(data) 
							{
								$(document).trigger('close.facebox');
								location.reload();
							}
						});
					}
					else
						alert("身份证号号码不能为空！");
				}
				else
					alert("社保卡卡号码不能为空！");
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