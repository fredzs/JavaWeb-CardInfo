<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<dl class="left">
	<dt class="${param.index==''?'selected':''}">
		<a href="index" ><img src="imgs/left_user_info.png" border="0"></a>
	</dt>
	<dt class="${param.index=='card'?'selected':''}">
		<a href="javascript:void(0)" ><img src="imgs/left_show_users.png" border="0"></a>
	</dt>
	<dd class="${param.index=='card'?'':'close'}">
		<ul>
			<li class="padding5 ${param.cardEnv=='0'&&param.index=='card'?'selected':''}"><a href="cardIndex?index=card&cardEnv=0"><img src="imgs/left_test01.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='1'&&param.index=='card'?'selected':''}"><a href="cardIndex?index=card&cardEnv=1"><img src="imgs/left_test02.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='2'&&param.index=='card'?'selected':''}"><a href="cardIndex?index=card&cardEnv=2"><img src="imgs/left_test03.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='3'&&param.index=='card'?'selected':''}"><a href="cardIndex?index=card&cardEnv=3"><img src="imgs/left_test04.png" ></a></li>
		</ul>
	</dd>
	<dt class="${param.index=='env'?'selected':''}">
		<a href="javascript:void(0)" ><img src="imgs/left_show_envs.png" border="0"></a>
	</dt>
	<dd class="${param.index=='env'?'':'close'}">
		<ul>
			<li class="padding5 ${param.cardEnv=='0'&&param.index=='env'?'selected':''}"><a href="showAllEnvUserInfo?index=env&cardEnv=0"><img src="imgs/left_test01.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='1'&&param.index=='env'?'selected':''}"><a href="showAllEnvUserInfo?index=env&cardEnv=1"><img src="imgs/left_test02.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='2'&&param.index=='env'?'selected':''}"><a href="showAllEnvUserInfo?index=env&cardEnv=2"><img src="imgs/left_test03.png" ></a></li>
			<li class="padding5 ${param.cardEnv=='3'&&param.index=='env'?'selected':''}"><a href="showAllEnvUserInfo?index=env&cardEnv=3"><img src="imgs/left_test04.png" ></a></li>
		</ul>
	</dd>
</dl>