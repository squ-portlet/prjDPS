<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<portlet:resourceURL id="ajaxDropWDataByRole" var="urlAjaxDropWDataByRole"></portlet:resourceURL>
	<portlet:resourceURL id="ajaxCoursesToBeDropped" var="urlAjaxCoursesToBeDropped"></portlet:resourceURL>

	<ul class="nav nav-tabs">
		<li role="presentation" id="idNav-home" class="clsNavRole active"><a href="#">Home</a></li>
		<c:if test="${(not empty employee) }">
			<c:forEach items="${employee.myRoles}" var="myRole">
				<li class="clsNavRole" id="idNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
			</c:forEach>
		</c:if>
	</ul>
	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/dropw/jsDropW.jsp" %>


    <div class="section">
      	<div class="container-fluid">
			<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
			<div class="row" id="imgAjaxLoading" style="display: none;">
				<div class="col-sm-5"></div>
				<div class="col-sm-1">
					<img alt="Loading ...." src="${imgAjaxLoader}">
				</div>
			</div>

            <table id="tblApprover" class="table table-striped table-bordered dt-responsive nowrap collapsed"  width="100%" style="display: none;">
              <thead>
                <tr>
                  <th ><spring:message code="prop.dps.student.student.id"/></th>
                  <th ><spring:message code="prop.dps.student.student.name"/></th>
                  <th ><spring:message code="prop.dps.student.student.cohort"/></th>
                  <th ><spring:message code="prop.dps.student.student.college"/></th>
                  <th ><spring:message code="prop.dps.student.student.program"/></th>
<!--                   <th colspan="3">Approver</th> -->
                  <th><spring:message code="prop.dps.role.advisor.text"/></th>
                  <th ><spring:message code="prop.dps.role.link.approve"/></th>
                </tr>
                <tr>
					
                </tr>
              </thead>
              <tbody>
                <tr></tr>
              </tbody>
            </table>			
			
			
		</div>
	</div>

	<div id="dropwCourses"></div>
	<div id="dropwCoursesAction"></div>
    <div id="divAlertData" class="alert alert-warning" role="alert" ><spring:message code="prop.dps.role.home"/></div>

	
	

	<script id="hbDropCourses" type="text/x-handlebars-template">
	<table id="tblApprover" class="table table-striped table-bordered dt-responsive nowrap collapsed">
		<tr>
			<th><spring:message code="prop.dps.student.student.id"/></th>
			<th><spring:message code="prop.dps.student.student.name"/></th>
			<th><spring:message code="prop.dps.student.student.cohort"/></th>
			<th><spring:message code="prop.dps.student.student.college"/></th>
			<th><spring:message code="prop.dps.student.student.program"/></th>
		</tr>
		
		{{#each .}}
			<tr>
				<td><a class="clsStudentCourse" href="#" approver={{approver}} studentNo={{student.academicDetail.studentNo}} stdStatCode={{student.academicDetail.stdStatCode}}>{{student.academicDetail.id}}</a></td>
				<td>{{student.academicDetail.studentName}}</td>
				<td>{{student.academicDetail.cohort}}</td>
				<td>{{student.academicDetail.college}}</td>
				<td>{{student.academicDetail.degree}}</td>
			</tr>
		{{/each}}
	</table>
	</script>
	<script id="hbDropCoursesAction" type="text/x-handlebars-template">	

			<table id="tblCoursesAction" class="table table-striped table-bordered dt-responsive nowrap collapsed">
				<tr>
					<th><spring:message code="prop.dps.course.code"/></th>
					<th><spring:message code="prop.dps.course.title"/></th>
					<th><spring:message code="prop.dps.course.section"/></th>
					<th><spring:message code="prop.dps.course.credits"/></th>
					<th><spring:message code="prop.dps.course.action"/></th>									
				</tr>
			{{#if approverMain}}
				{{#each .}}
					<tr>
	    				<td>{{lAbrCourseNo}}</td>
	    				<td>{{courseName}}</td>
	    				<td>{{sectionNo}}</td>
	    				<td>{{credits}}</td>
	    				<td>
							{{#if statusPending}}
								  	<div class="col-xs-4"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm"><spring:message code="prop.dps.role.approve.text"/></label> </div> 
									<div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm"> <spring:message code="prop.dps.role.reject.text"/> </label></div> 
							{{else}}
								{{statusDesc}}
							{{/if}}
						</td>
					</tr>
			{{/each}} 
			{{else}}
					{{#each .}}
						<tr>
	    					<td>{{lAbrCourseNo}}</td>
	    					<td>{{courseName}}</td>
	    					<td>{{sectionNo}}</td>
	    					<td>{{credits}}</td>
	    					<td>
								{{statusDesc}}
							</td>
						</tr>
					{{/each}}
			{{/if}}

	
			</table>
	</script>
