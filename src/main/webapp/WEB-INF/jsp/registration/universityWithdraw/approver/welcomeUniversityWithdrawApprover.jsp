<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/universityWithdraw/approver/jsUniversityWithdraw.approver.hb.js" %>
	<%@include file="../../../ui/js/registration/universityWithdraw/approver/jsUniversityWithdraw.approver.js" %>
	
	<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>	

	<div class="row" id="divImgAjaxLoading" style="display: none;">
		<div class="col-sm-5"></div>
		<div class="col-sm-1">
			<img alt="Loading ...." src="${imgAjaxLoader}">
		</div>
	</div>
	
	
<!-- Role based tabs -->	
		<ul class="nav nav-tabs">
			<li role="presentation" id="idNav-home" class="clsNavRole active"><a href="#">Home</a></li>
			<c:if test="${(not empty employee) }">
				<c:forEach items="${employee.myRoles}" var="myRole">
					<li class="clsNavRole" id="idNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
				</c:forEach>
			</c:if>
		</ul>

	
		<div id="divUnivWithdrawList"></div>		