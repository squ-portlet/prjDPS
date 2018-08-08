<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/universityWithdraw/jsUniversityWithdraw.hb.js" %>
	<%@include file="../../../ui/js/registration/universityWithdraw/jsUniversityWithdraw.js" %>

	<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>	

	<div class="row" id="divImgAjaxLoading" style="display: none;">
		<div class="col-sm-5"></div>
		<div class="col-sm-1">
			<img alt="Loading ...." src="${imgAjaxLoader}">
		</div>
	</div>
	
 <div class="section">
    <div class="container-fluid">

	     <div class="row">
			<div id="divStudentWelcome"></div>
	     </div>

	      <div class="row">
	      	<div id="divUnivWithDrawStdRecord"></div>
	      </div>
      
    </div>
</div>
