<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../../../ui/cssWelcome.jsp" %>	
<%@include file="../../../ui/js/grade/incomplete/jsIncompleteGrade.js" %>

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
			 <spring:message code="prop.dps.incomplete.grade.notify.readonly.view"/>
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
									 				<th><spring:message code="prop.dps.incomplete.grade.notify.course.name"/></th>
									 			</tr>
									 		</thead>
									 		<tbody>
									 				 <c:forEach items="${courseList}" var="courseList">
									 				 	<tr>	
									 				 		<td>
									 				 			<a href="#" class="clsLinkCourseNo" 
									 				 			lAbrCourseNo='${courseList.course.lAbrCourseNo}' 
									 				 			courseNo='${courseList.course.courseNo}'
									 				 			sectionNo='${courseList.course.sectionNo}'
									 				 			sectCode='${courseList.course.sectCode}'
									 				 			courseYear='${courseList.course.courseYear}'
									 				 			semester='${courseList.course.semester}'
									 				 			>
									 				 				${courseList.course.lAbrCourseNo}/${courseList.course.sectionNo}
									 				 			</a>
									 				 		</td>
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
				  			<spring:message code="error.dps.incomplete.grade.notify.error.valid.course.required"/>
						</div>
					 </c:otherwise>
				</c:choose>			
				</div>
				
				<div class="col-sm-5">
					<div id="divStudentList"></div>
				</div>
				
				<div class="col-sm-3">
					<div id="divIncompleteGradeNotifyHistory">
				</div>
		</div>
		
		</div>
	</div>
</c:if>		



<!--  Approver -- list of approved students for grade change -->
	
<div class="section container-fluid">
	<div class="row" id="divStudentsListForApprovers"></div>
 	<div class="row" id="divStudentNotificationDetailsForApprove"></div> 
</div>



	   <!-- Modal HTML -->
    <div id="alertModal" class="modal" style="width: 20%;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><font color="red"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></font> <spring:message code="prop.dps.alert.text"/></h4>
                </div>
                <div class="modal-body" id="modalAlertErrMsg">
                    <p><spring:message code="prop.dps.incomplete.grade.notify.alert.warning"/></p>
                    <p>
                    <label for="txtComments"><spring:message code="prop.dps.approver.modal.body.approve.comment.text"/></label>
                    <textarea  id="txtComments" rows="" cols="">
                    
                    </textarea>
                    
                    </p>
                </div>
                <div class="modal-footer">
                	<button type="button" class="btn btn-primary" id="btnSubmitNotification"><spring:message code="prop.dps.role.submit.yes.text"/></button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></button>
                </div>
            </div>
        </div>
    </div>


<script id="hbStudentList" type="text/x-handlebars-template">
			<table id="tblStudentList" class="table table-condensed table-bordered dt-responsive">
				<thead>
					<tr>
						<th>tno</th>
						<th>studentNo </th>
						<th>stdStatCode</th>
						<th>courseYear</th>
						<th>semester</th>
						<th>sectCode</th>
						<th>lAbrCourseNo</th>
						<th>courseNo</th>
						<th>sectionNo</th>
						<th><spring:message code="prop.dps.incomplete.grade.notify.student.id"/> </th>						
						<th>
							<spring:message code="prop.dps.incomplete.grade.notify.students"/>  
								<span class="label label-default">{{lAbrCourseNo}}</span>
								<span class="badge">{{sectionNo}}</span>
						</th>
						
						<th><spring:message code="prop.dps.incomplete.grade.notify.grade.name"/></th>
						<th><spring:message code="prop.dps.incomplete.grade.notify.action"/></th>

					</tr>
				</thead>
				<tbody>
					{{#each students}}
					<tr>
						<td>{{sequenceNum}}</td>
						<td>{{encryptStr student.personalDetail.studentNo}}</td>
						<td>{{encryptStr student.academicDetail.stdStatCode}}</td>
						<td>{{encryptStr ../courseYear}}</td>
						<td>{{encryptStr ../semester}}</td>
						<td>{{encryptStr ../sectCode}}</td>
						<td>{{encryptStr ../lAbrCourseNo}}</td>
						<td>{{encryptStr ../courseNo}}</td>
						<td>{{encryptStr ../sectionNo}}</td>
						<td>
							{{#if historyAvailable}}
								<a class="clsNotifyHistory" href="#">{{student.personalDetail.id}}</a>
							{{else}}
								{{student.personalDetail.id}}
							{{/if}}
						</td>
						<td>{{student.personalDetail.name}}</td>
						<td>{{grade.gradeVal}}</td>
						<td>
								{{#unless  grade.gradeCode}}
									{{#if historyAvailable}}
										<span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>
									{{else}}
										<a class="clsLinkStudentNo"  href="#" >
											<spring:message code="prop.dps.incomplete.grade.notify.text.notify" /> 
											<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										</a>
									{{/if}}
								{{/unless}}
						</td>
					</tr>
					{{/each}}
				</tbody>				
			</table>
</script>

<script id="hbIncompleteGradeNotifyHistory" type="text/x-handlebars-template">
	<table id="tblIncompleteGradeNotifyHistory" class="table table-striped table-bordered dt-responsive  collapsed ">
		<thead>
			<tr>
				<th><spring:message code="prop.dps.incomplete.grade.notify.status" /></th> 
				<th><spring:message code="prop.dps.incomplete.grade.notify.hod" /></th>
				<th><spring:message code="prop.dps.incomplete.grade.notify.dean.asst" /></th>
				<th><spring:message code="prop.dps.incomplete.grade.notify.dean.dps" /></th>
			</tr>
		</thead>
		<tbody>
			{{#each .}}
			<tr>
				<td>{{statusDesc}}</td>
				<td>
					{{{hod.roleStausIkon}}}
							
					{{#if hod.comments}}
						<a href="#" comments="{{hod.comments}}" class="classPopMsgHOD">
							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
						</a> 
					{{/if}}
				</td>
				<td>
					{{{dpsAsstDean.roleStausIkon}}}  
					{{#if dpsAsstDean.comments}}
						<a href="#" comments="{{dpsAsstDean.comments}}" class="classPopMsgAsstDeanP">
							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
						</a> 
					{{/if}}
				</td>
				<td>
					{{{dpsDean.roleStausIkon}}}  
					{{#if dpsDean.comments}}
						<a href="#" comments="{{dpsDean.comments}}" class="classPopMsgDeanP">
							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
						</a> 
					{{/if}}	
				</td>
			</tr>
			{{/each}}
		</tbody>
	</table>
</script>

<script id="hbStudentsListForApprovers" type="text/x-handlebars-template">
<table id="tblApprover" class="table table-striped table-bordered dt-responsive nowrap collapsed">
		<thead>
		<tr>
			<th>t1</th>
			<th>t2</th>
			<th>t3</th>
			<th><spring:message code="prop.dps.student.student.id"/></th>
			<th><spring:message code="prop.dps.student.student.name"/></th>
			<th><spring:message code="prop.dps.student.student.cohort"/></th>
			<th><spring:message code="prop.dps.student.student.college"/></th>
			<th><spring:message code="prop.dps.student.student.program"/></th>
		</tr>
		</thead>
		<tbody>
		{{#each students}}
			<tr>
				<td>{{encryptStr ../roleType}}</td>
				<td>{{encryptStr academicDetail.studentNo}}</td>
				<td>{{encryptStr academicDetail.stdStatCode}}</td>
				<td>
					<a class="clsLinkStudentWithNotification" href="#" >{{academicDetail.id}}</a>
					&nbsp; 
					{{#if academicDetail.recordApprove}}
						<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
					{{/if}}		
				</td>
				<td>{{academicDetail.studentName}}</td>
				<td>{{academicDetail.cohort}}</td>
				<td>{{academicDetail.college}}</td>
				<td>{{academicDetail.degree}}</td>
			</tr>
		{{/each}}
		</tbody>
	</table>

</script>


