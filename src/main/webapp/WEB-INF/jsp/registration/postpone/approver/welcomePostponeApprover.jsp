<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/postpone/jsPostpone.jsp" %>

<!-- Role based tabs -->	
		<ul class="nav nav-tabs">
			<li role="presentation" id="idNav-home" class="clsNavRole active"><a href="#">Home</a></li>
			<c:if test="${(not empty employee) }">
				<c:forEach items="${employee.myRoles}" var="myRole">
					<li class="clsNavRole" id="idNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
				</c:forEach>
			</c:if>
		</ul>

<!-- Ajax Image Loader -->		
			<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
			<div class="row" id="divImgAjaxLoading" style="display: none;">
				<div class="col-sm-5"></div>
				<div class="col-sm-1">
					<img alt="Loading ...." src="${imgAjaxLoader}">
				</div>
			</div>
			
			
			<div id="divPostponeApprover"></div>
			
<!--  Alert message -->			
			<div id="divAlertData" class="alert alert-warning" role="alert" ><spring:message code="prop.dps.role.home"/></div>
			
			
			
<!-- Handlebar template for Postpone data for Approvers -->			
	<script id="hbPostponeApprover" type="text/x-handlebars-template">	
    <div class="section">
      	<div class="container-fluid">		
			 <table id="tblPostponeApprover" class="table table-striped table-bordered dt-responsive nowrap collapsed">
              <thead>
                <tr>
                  <th ><spring:message code="prop.dps.student.student.id"/></th>
                  <th ><spring:message code="prop.dps.student.student.name"/></th>
                  <th ><spring:message code="prop.dps.student.student.cohort"/></th>
                  <th ><spring:message code="prop.dps.student.student.college"/></th>
                  <th ><spring:message code="prop.dps.student.student.program"/></th>

                  <th><spring:message code="prop.dps.role.advisor.text"/></th>
                  <th><spring:message code="prop.dps.role.supervisor.text"/></th>
                  <th><spring:message code="prop.dps.role.college.dean"/></th>
                  <th><spring:message code="prop.dps.role.dps.dean"/></th>
                  <th ><spring:message code="prop.dps.role.link.approve"/></th>
                </tr>

              </thead>
              <tbody>
                {{#each .}}
	                <tr>
						<td>{{studentId}}</td>
						<td>{{studentName}}</td>
						<td>{{cohort}}</td>
						<td>{{collegeName}}</td>
						<td>{{degreeName}}</td>
						
						<td>{{{advisor.roleStausIkon}}}</td>
						<td>{{{supervisor.roleStausIkon}}}</td>
						<td>{{{collegeDean.roleStausIkon}}}</td>
						<td>{{{dpsDean.roleStausIkon}}}</td>
						<td></td>	                
	                </tr>
                {{/each}}
              </tbody>
            </table>
		</div>
	</div>
	</script>			