<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<html>
<head>
	<title>用户信息查询</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<s:include value="/template/_head.jsp" />
</head>
<body>
	<div id="container">
		<div id="inner">
			<s:include value="/template/_banner.jsp?menu=1" />
			<s:include value="/template/_left.jsp" />
			<div class="right" id="right">
				<div class="divline">
					用户信息查询
				</div>
				<div class="contentline">
					<s:form theme="simple" method="post">  
					    <table class="datatable">  
					        <tr>  
					            <td style="text-align: right">所在环境:</td>  
					            <td><s:select id="card_env" name="card_env" list="#{'0':'测试机01','1':'测试机02','2':'测试机03','3':'开发'}" label="环境" value="0"></s:select></td>
					        </tr>  
					        <tr>  
					            <td style="text-align: right">卡种类:</td>  
					            <td><s:select id="card_type" name="card_type" list="#{'0':'京医通卡','1':'社保卡'}" label="卡种" value="0"></s:select></td>
					        </tr>  
					        <tr>  
					            <td style="text-align: right">卡号: </td>  
					            <td><s:textfield id="card_id" name="card_id" label="卡号"/></td> 
					        </tr>  
					    </table>  
					</s:form>
					<div class="contentline">
						<input type="button" value="提交" class="button leftmargin_10" onclick="show()">
					</div>
				</div><!--contentline-->
				<div id = "query" class="contentline">
					
				</div><!--"query"-->
			</div>  
		</div>  
		<s:include value="/template/_footer.jsp" />
	</div>  
	<s:include value="/template/_common_js.jsp" />
</body>

<script type="text/javascript">
	function show()
	{
		$.ajax
		({
			url : 'search',
			type : 'post',
			data : 
			{
				card_env : $('#card_env').val(),
				card_type : $('#card_type').val(),
				card_id : $('#card_id').val(),
			},
			success : function(data) 
			{
				$('#query').html(data);
			},
			error : function() 
			{
				$('#query').html();
			}
		});
	}
</script>
</html>