<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="/template/_head.jsp" />
		<title>添加社保卡用户</title>
	</head>
	<body>
	    <table class="datatable">
			<tr>
				<td width="58"><div align="left">用户姓名<span class="redletter">*</span></div></td>
			    <td width="241"><input id="newUserName" type="text" value="" class="editline" /></td>
			</tr>
			<tr>
			    <td><div align="left">身份证号<span class="redletter">*</span></div></td>
			   	<td><input id="newIdNum" type="text" value="" class="editline" /></td>
			</tr>
			<tr>
			   	<td><div align="left">社保卡号<span class="redletter">*</span></div></td>
			   	<td><input id="newSscardNum" type="text" value="" class="editline" /></td>
			</tr>
			<tr>
	            <td><div align="left">使用状态<span class="redletter">*</span></div></td>
	            <td><s:select theme="simple" id="newSscardCondition" name="newSscardCondition" list="#{'0':'未使用','1':'使用中'}" value="1"></s:select></td>
         	</tr>
			<tr>
			   	<td><div align="left"></div></td>
			   	<td><input type="button" class="button" value="添加" onClick="submit()"/>
			  	  	<input type="button" class="button" value="取消" onClick="cancle()"/></td>
			</tr>
		</table>
		
		<script type="text/javascript" charset="gb2312">
			function submit( ) 
			{
				if($('#newUserName').val()!="")
				{
					if($('#newIdNum').val()!="")
					{
						if($('#newSscardNum').val()!="")
						{
							$.ajax
							({
								url : 'addSscardUser',
								type : 'post',
								data : 
								{
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
							alert("社保卡号码不能为空！");
					}
					else
						alert("身份证号码不能为空！");
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