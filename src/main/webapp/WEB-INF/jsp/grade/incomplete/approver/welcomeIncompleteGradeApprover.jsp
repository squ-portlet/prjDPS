<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<ul class="nav nav-tabs">
		
		<c:if test="${(not empty employee) }">
		<li role="presentation" id="idNav-home" class="clsNavRole active"><a href="#">Home</a></li>	
			<c:forEach items="${employee.myRoles}" var="myRole" varStatus="loop">
					<c:if test="${myRole.roleName eq roleDpsStaff }">
						<c:set var="varRoleName" value="${myRole.roleName}"/>
					</c:if>
						<li class="clsNavRole" id="idNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
			</c:forEach>
		</c:if>
	</ul>
	
    <div class="section">
      	<div class="container-fluid">
			<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
			<div class="row" id="imgAjaxLoading" style="display: none;">
				<div class="col-sm-5"></div>
				<div class="col-sm-1">
					<img alt="Loading ...." src="${imgAjaxLoader}">
				</div>
			</div>
		</div>
	</div>
	
<c:if test="${varRoleName eq roleDpsStaff }">
	<div id="idDivInstructor" class="section container-fluid">
		<div class="alert alert-warning">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			 <spring:message code="prop.dps.gradechange.dps.readonly.view"/>
		</div>
	</div>
</c:if>	

<c:if test="${(not empty employee) && varRoleName ne roleDpsStaff }">
	<div id="idDivInstructor" class="section container-fluid">
		<div class="row">

				<div class="col-sm-2">
				<c:choose>
					<c:when test="${not empty courseList}">			
						<div class="panel panel-default">
							<div class="panel-body">
									 <table class="table table-condensed dt-responsive collapsed ">
									 		<thead>
									 			<tr>
									 				<th><spring:message code="prop.dps.gradechange.course.name"/></th>
									 			</tr>
									 		</thead>
									 		<tbody>
									 				 <c:forEach items="${courseList}" var="courseList">
									 				 	<tr>	
									 				 		<td><a href="#" class="clsLinkCourseNo" lAbrCourseNo='${courseList.course.lAbrCourseNo}' sectionNo='${courseList.course.sectionNo}'>${courseList.course.lAbrCourseNo}/${courseList.course.sectionNo}</a></td>
									 				 	</tr>
									 				 </c:forEach>
									 		</tbody>
									 </table>
							</div>
						</div>
					</c:when>
				 	<c:otherwise>
						 <div class="alert alert-warning" role="alert">
				  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				  			&nbsp;
				  			<spring:message code="prop.dps.gradechange.error.valid.course.required"/>
						</div>
					 </c:otherwise>
				</c:choose>			
				</div>
		
		</div>
	</div>
</c:if>		