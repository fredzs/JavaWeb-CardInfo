<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="js/public.js"></script>
<!-- <script src="js/public.js"></script> -->
<script type="text/javascript" charset="gb2312">
	function findCard(Condition)
	{
		var searchValue = $('#'+Condition+'').val();
		var valueArray= new Array();
		valueArray = searchValue.split('\n');
		$.ajax({
			url : "searchCardByCondition?index=card"+"&cardEnv=" + <s:property value="cardEnv"/>,
			type : "post",
			traditional : true,
			data : {
				"searchCondition" : Condition,
				"searchValue" : $('#'+Condition+'').val(),
				"searchList" : valueArray
			},
			success : function(data) {
				$("#default").html(data);
			}
		});
	}
	function findSscard(Condition,value)
	{
		var searchValue = $('#'+value+'').val();
		var valueArray= new Array();
		valueArray = searchValue.split('\n');
		$.ajax({
			url : "searchSscardByCondition?index=card"+"&cardEnv=" + <s:property value="cardEnv"/>,
			type : "post",
			traditional : true,
			data : {
				"searchCondition" : Condition,
				"searchValue" : $('#'+value+'').val(),
				"searchList" : valueArray
			},
			success : function(data) {
				$("#default").html(data);
			}
		});
	}
	function removeCard(id){
		if(confirm("确认删除该京医通卡信息?")){
			$.ajax({
				url : 'removeCardUser',
				type : 'post',
				data : {
					id : id
				},
				success : function() {
					location.reload();
				}
			});
		}
	}
	function removeSscard( id ) 
	{
		if(confirm("确认删除该社保卡信息?")){
			$.ajax({
				url : 'removeSscardUser',
				type : 'post',
				data : {
					id : id
				},
				success : function() {
					location.reload();
				}
			});
		}
	}
</script>