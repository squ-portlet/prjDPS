<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<portlet:resourceURL id="ajaxDropWDataByRole" var="urlAjaxDropWDataByRole"></portlet:resourceURL>
	<portlet:resourceURL id="ajaxCoursesToBeDropped" var="urlAjaxCoursesToBeDropped"></portlet:resourceURL>
	<portlet:resourceURL id="ajaxApproverAction" var="urlAjaxApproverAction"></portlet:resourceURL>

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
	<%@include file="../../../ui/js/registration/dropw/jsValidationDropW.jsp" %>


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

	
	
	<div class="modal fade" id="modalApprovForm" role="dialog" aria-labelledby="myModalLabelDropWForm" aria-hidden="true" >
      <div class="modal-dialog">
        <div class="modal-content">
        	<input type="hidden" id="txtModalAppFormStatus" >
        	
        	<input type="hidden" id="studentNo">
        	<input type="hidden" id="studentStatCode">
        	<input type="hidden" id="courseNo">
        	<input type="hidden" id="lAbrCourseNo">
        	<input type="hidden" id="sectionNo">
        	<input type="hidden" id="sectCode">
        	<input type="hidden" id="statusApprove">
        	
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&nbsp;</button>
            <h4 class="modal-title"><spring:message code="prop.dps.dropw.approver.modal.title.text"/> </h4>
          </div>
          <form id="formModalApprover" name="formModalApprover">
          <div class="modal-body">
          	<div id="idApprovalMsg"></div>
            <div id="idComment">
            	<div class="col-sm-2"><spring:message code="prop.dps.dropw.approver.modal.body.approve.comment.text"></spring:message></div>
            	<div class="col-sm-8" id="idCommentTxtArea"><textarea id="txtMessage" name="txtMessage" rows="" cols=""></textarea></div>
            </div>
          </div>
          </form>
          <div class="modal-footer">
            <button id="linkBtnReset" class="btn btn-default"  data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></button>
            <button id="linkSubmitApprove" name="linkSubmitApprove" type="button" class="btn "><spring:message code="prop.dps.role.submit.yes.text"/></button>
          </div>
          
        </div>
      </div>
    </div>
	
	
	
	   <!-- Error Modal HTML -->
    <div id="alertModal" class="modal" style="width: 20%;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><font color="red"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></font> <spring:message code="prop.dps.alert.text"/></h4>
                </div>
                <div class="modal-body" id="modalAlertErrMsg">
                    <p></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><spring:message code="prop.dps.modal.form.button.close.text"/></button>
                </div>
            </div>
        </div>
    </div>
	
	

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
				<td><a class="clsStudentCourse" href="#" approver={{approver}} studentNo={{student.academicDetail.studentNo}} stdStatCode={{student.academicDetail.stdStatCode}} studentId={{student.academicDetail.id}} studentName="{{student.academicDetail.studentName}}">{{student.academicDetail.id}}</a></td>
				<td>{{student.academicDetail.studentName}}</td>
				<td>{{student.academicDetail.cohort}}</td>
				<td>{{student.academicDetail.college}}</td>
				<td>{{student.academicDetail.degree}}</td>
			</tr>
		{{/each}}
	</table>
	</script>
	<script id="hbDropCoursesAction" type="text/x-handlebars-template">	
		
	{{#if approverMain}}
		<p>
				<ol class="breadcrumb">
					<li><center><spring:message code="prop.dps.dropw.approver.breadcrumb.student"/> (<b>{{studentName}} / {{studentId}}</b>) </center></li>
				</ol>
		</p>

			<table id="tblCoursesAction" class="table table-striped table-bordered dt-responsive nowrap collapsed">
				<tr>
					<th><spring:message code="prop.dps.course.code"/></th>
					<th><spring:message code="prop.dps.course.title"/></th>
					<th><spring:message code="prop.dps.course.section"/></th>
					<th><spring:message code="prop.dps.course.credits"/></th>
					<th><spring:message code="prop.dps.course.action"/></th>									
				</tr>

				{{#each .}}
					<tr>
	    				<td>{{lAbrCourseNo}}</td>
	    				<td>{{courseName}}</td>
	    				<td>{{sectionNo}}</td>
	    				<td>{{credits}}</td>
	    				<td>
							{{#if statusPending}}
								  	<div class="col-xs-4"><label><input type="radio" courseNo={{courseNo}} lAbrCourseNo={{lAbrCourseNo}} sectionNo={{sectionNo}} sectCode={{sectCode}} class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm"><spring:message code="prop.dps.role.approve.text"/></label> </div> 
									<div class="col-xs-2"><label><input type="radio" courseNo={{courseNo}} lAbrCourseNo={{lAbrCourseNo}} sectionNo={{sectionNo}} sectCode={{sectCode}} class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm"> <spring:message code="prop.dps.role.reject.text"/> </label></div> 
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
	
			</table>
	{{/if}}
	</script>
