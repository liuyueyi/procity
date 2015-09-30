<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/components/common/taglib.jsp"%>
<%@ include file="/components/common/jscsslib.jsp"%>

<script type="text/javascript" src="${ctx}/pages/procity/procity.js"></script>

<select name="province_code" id="province_select">
	<c:forEach items="${provincials}" var="item">
		<option value="${item.procode}" cdata='${item.citys}'>${item.proname}</option>
	</c:forEach>
</select>
&nbsp;
<select name="city_code" id="city_select">
</select>
