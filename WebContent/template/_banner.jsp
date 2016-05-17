<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="banner">
	<div class="content">
	    <img id="logo" src="imgs/logo.gif" border="0"/>
	    <span class="nav">
	        <a href="index.jsp?menu=1" id="user"><img class='${ param.menu=="1"?"cur":"" }' src="imgs/banner_user.png" border="0" /></a>
	        <a href="index.jsp?menu=2" id="sys"><img class='${ param.menu=="2"?"cur":"" }' src="imgs/banner_sys.png" border="0" /></a>
	    </span>
    </div>
</div>