<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../../../ui/cssWelcome.jsp" %>	
<%@include file="../../../ui/js/grade/incomplete/jsIncompleteGrade.js" %>
<%@include file="../../../ui/js/grade/incomplete/jsValidationIncompleteGrade.js" %>

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

	<div id="divAlertNotify"></div>
	
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
					<div id="divIncompleteGradeNotifyHistory"></div>
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
            <form id="formAlert" name="formAlert">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><font color="red"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></font> <spring:message code="prop.dps.alert.text"/></h4>
                </div>
                <div class="modal-body" id="modalAlertErrMsg">
                    <p><spring:message code="prop.dps.incomplete.grade.notify.alert.warning"/></p>
                    <p>
                    <label for="txtComments"><spring:message code="prop.dps.approver.modal.body.approve.comment.text"/></label>
                    <textarea  id="txtComments" name="txtComments" rows="" cols="" required>
                    
                    </textarea>
                    
                    </p>
                </div>
                <div class="modal-footer">
                	<button type="button" class="btn btn-primary" id="btnSubmitNotification" name="btnSubmitNotification"><spring:message code="prop.dps.role.submit.yes.text"/></button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></button>
                </div>
               </form>
            </div>
        </div>
    </div>

<!--  Modal dialogue for approve/reject -->
	<div class="modal fade" id="modalApprovForm" role="dialog" aria-labelledby="myModalLabelForm" aria-hidden="true" >
      <div class="modal-dialog">
        <div class="modal-content">
        	<form id="formApprove" name="formApprove">	
	          <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&nbsp;</button>
	            <h4 class="modal-title"><spring:message code="prop.dps.approver.modal.title.text"/> </h4>
	          </div>
	          <form id="formModalApprover" name="formModalApprover">
	          <div class="modal-body">
	          	<div id="idApprovalMsg"></div>
	            <div id="idComment">
	            	<div class="col-sm-2"><spring:message code="prop.dps.approver.modal.body.approve.comment.text"></spring:message></div>
	            	<div class="col-sm-8" id="idCommentTxtArea"></div>
	            </div>
	          </div>
	          </form>
	          <div class="modal-footer">
	            <button id="linkBtnReset" class="btn btn-default"  data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></button>
	            <button id="linkSubmitApprove" name="linkSubmitApprove" type="button" class="btn "><spring:message code="prop.dps.role.submit.yes.text"/></button>
	          </div>
			</form>
          
        </div>
      </div>
    </div>


<script id="hbAlert" type="text/x-handlebars-template">
	<div id="idAlert" class="alert alert-danger alert-dismissible fade in" role="alert"> 
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button> <h4><spring:message code="prop.dps.alert.text"/></h4> 
				<p id="idAlertText">{{alertTxt}}</p> 
	</div> 
</script>

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
										<a href="#" class="classPopMsgInstructor" comments="{{comments}}"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></a>
									{{else}}
										<a class="clsLinkStudentNo"  href="#"  data-toggle="modal" data-target="#alertModal">
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
			<th>t4</th>
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
				<td>{{../roleType}}</td>
				<td>{{encryptStr academicDetail.studentNo}}</td>
				<td>{{encryptStr academicDetail.stdStatCode}}</td>
				<td>{{academicDetail.id}}</td>
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

<script id="hbStudentNotificationDetailsForApprove" type="text/x-handlebars-template">
		<div>
				<ol class="breadcrumb">
					<li>
							<center>
									<span class="glyphicon glyphicon-education" aria-hidden="true"></span>  {{studentName}} <span class="badge"> {{studentId}} </span>
							</center>
					</li>
				</ol>
		</div>
		<table id="tblStudentNotificationDetailsForApprove" class="table table-striped table-bordered dt-responsive  collapsed ">
				<thead>
				<tr>
					<th>t0</th>
					<th>t1</th>
					<th>t2</th>
					<th>t3</th>
					<th>t4</th>
					<th>t5</th>
					<th>t6</th>
					<th>t7</th>
					<th><spring:message code="prop.dps.gradechange.seq.no"/></th>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.status"/></th>
					<th><spring:message code="prop.dps.incomplete.grade.notify.instructor"/></th>
					<th><spring:message code="prop.dps.gradechange.hod"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.asst"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.dps"/></th>
					<th></th>
					<th>t16</th>
				</tr>
				</thead>
				<tbody>
						{{#each notifyList}}
							<tr>
								<td>{{recordSequence}}</td>
								<td>{{encryptStr student.academicDetail.studentNo}}</td>
								<td>{{encryptStr student.academicDetail.stdStatCode}}</td>
								<td>{{encryptStr course.sectCode}}</td>
								<td>{{encryptStr course.courseNo}}</td>
								<td>{{encryptStr course.courseYear}}</td>
								<td>{{encryptStr course.semester}}</td>
								<td>{{../roleName}}</td>
								<td>
									{{recordSequence}}
									{{#if approver}}<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>{{/if}}
								</td>
								<td>{{course.lAbrCourseNo}}</td>
								<td>{{course.sectionNo}}</td>
								<td><center>{{statusDesc}}</center></td>
								<td>
									<center>
										<a href="#" comments="{{comments}}" class="classPopMsgInstructor">
												<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
										</a>
									</center>
								</td>
								<td>
									<center>
										{{{hod.roleStausIkon}}} &nbsp;
										{{#if hod.comments}}
											<a href="#" comments="{{hod.comments}}" class="classPopMsgHOD">
												<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
											</a> 
										{{/if}}
									</center>
								</td>
								<td>
									<center>
										{{{dpsAsstDean.roleStausIkon}}} &nbsp;
										{{#if dpsAsstDean.comments}}
											<a href="#" comments="{{dpsAsstDean.comments}}" class="classPopMsgAsstDeanP">
												<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
											</a> 
										{{/if}}
									</center>								
								</td>
								<td>
									<center>
										{{{dpsDean.roleStausIkon}}} &nbsp;
										{{#if dpsDean.comments}}
												<a href="#" comments="{{dpsDean.comments}}" class="classPopMsgDeanP">
													<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
												</a> 
										{{/if}}	
									</center>
								</td>
								<td>
									{{#if approver}}
												<div class="col-xs-4"><label><input type="radio"  class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm"><spring:message code="prop.dps.role.approve.text"/></label> </div> 
												<div class="col-xs-2"><label><input type="radio"  class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm"> <spring:message code="prop.dps.role.reject.text"/> </label></div> 
									{{/if}}
								</td>	
								<td></td>	
							</tr>
						{{/each}}
				</tbody>
			</table>
		
</script>



