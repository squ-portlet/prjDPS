<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/grade/gradechange/jsGradeChange.jsp" %>


<c:set var="varRoleName"/>
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

<c:if test="${varRoleName ne roleDpsStaff }">
<div id="idDivInstructor" class="section container-fluid">
	<div class="row">
		
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="modelGrade" name="modelGrade" method="post" >
						<div class="form-group">
							<label for="studentId"><spring:message code="prop.dps.gradechange.student.id"/></label>	
							<input type="text" class="form-control" id="studentId" placeholder="Enter Student Id">		
						</div>
						<div class="form-group">
							<label for="courseYear"><spring:message code="prop.dps.gradechange.course.year"/></label>	
							<input type="text" class="form-control" id="courseYear" placeholder="Enter Year of the Course">		
						</div>
						<div class="form-group">
							<label for="semCode"><spring:message code="prop.dps.gradechange.semCode"/></label>	
							<select id="semCode">
								<option value=''><spring:message code="prop.dps.gradechange.select"/></option>
								<option value='<spring:message code="prop.dps.gradechange.semCode.02"/>' ><spring:message code="prop.dps.gradechange.semCode.02.spring"/></option>
								<option value='<spring:message code="prop.dps.gradechange.semCode.03"/>' > <spring:message code="prop.dps.gradechange.semCode.03.summer"/> </option>
								<option value='<spring:message code="prop.dps.gradechange.semCode.04"/>' > <spring:message code="prop.dps.gradechange.semCode.04.fall"/> </option>
								
							</select>		
						</div>
						<div class="form-group">
							<label for="lAbrCrsNo"><spring:message code="prop.dps.gradechange.course.code"/></label>	
							<input type="text" class="form-control" id="lAbrCrsNo" placeholder="Enter CourseNo">		
						</div>
						<div>
							<button type="button" id="bttnGradeSearch" class="btn btn-default" ">
		  						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> <spring:message code="prop.dps.gradechange.button.search"/>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<div id="divGradeList"></div>
			<div id="divAlertGradeList"></div>
		</div>
	</div>
	
	<div class="row">
		<div id="divGradeChangeHistory">
		
		</div>
	</div>
</div>	
</c:if>	
	
<!--  Approver -- list of approved students for grade change -->
	
<div class="section container-fluid">
	<div class="row" id="divGradeStudentsList"></div>
	<div class="row" id="divStudentGradesForApprove"></div>
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


<!--  Modal dialogue for approve/reject -->
	<div class="modal fade" id="modalApprovForm" role="dialog" aria-labelledby="myModalLabelForm" aria-hidden="true" >
      <div class="modal-dialog">
        <div class="modal-content">
        	<input type="hidden" id="txtModalAppFormStatus" >
        	<input type="hidden" id="recordSequence">
        	<input type="hidden" id="studentNo">
        	<input type="hidden" id="stdStatCode">
        	<input type="hidden" id="sectcode">
        	<input type="hidden" id="courseCode">
        	<input type="hidden" id="lAbrCourseNo2">
        	<input type="hidden" id="sectionNo">
        	<input type="hidden" id="courseYear2">
        	<input type="hidden" id="semester">
        	<input type="hidden" id="statusApprove">
        	<input type="hidden" id="roleName">
        	
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&nbsp;</button>
            <h4 class="modal-title"><spring:message code="prop.dps.approver.modal.title.text"/> </h4>
          </div>
          <form id="formModalApprover" name="formModalApprover">
          <div class="modal-body">
          	<div id="idApprovalMsg"></div>
            <div id="idComment">
            	<div class="col-sm-2"><spring:message code="prop.dps.approver.modal.body.approve.comment.text"></spring:message></div>
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


<script id="hbGradeList" type="text/x-handlebars-template">
			<table id="tblGradeList" class="table table-striped table-bordered dt-responsive collapsed ">
				<thead>
				<tr>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.existing"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.new"/></th>
					<th><spring:message code="prop.dps.gradechange.comments"/></th>					
					<th><spring:message code="prop.dps.gradechange.action"/></th>
					
				</tr>
				</thead>
				<tbody>
				{{#each .}}
					{{#if updatable}}
						<tr>
							<td>{{course.lAbrCourseNo}}</td>
							<td>{{sectionNo}}</td>
							<td>{{grade.gradeVal}}</td>
							<td>
								<select class="gradeValNew input-small" >
									<option value=""><spring:message code="prop.dps.gradechange.select"/><option>
									<c:forEach items="${grades}" var="grade">
										<option value="${grade.gradeCode}">${grade.gradeVal}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea class="txtComments" rows="2" cols="20"></textarea>
							</td>
							<td>
								<a class="linkGradeChange" href="#" stdno="{{encryptStr studentNo}}" stdstatcode="{{encryptStr stdStatCode}}" courseyear="{{courseYear}}" semester="{{semester}}" sectCode="{{sectCode}}" courseno="{{course.courseNo}}" labrcourseno="{{course.lAbrCourseNo}}" sectionno="{{sectionNo}}"  gradecodeold="{{{encryptStr grade.gradeCode}}}" ><spring:message code="prop.dps.gradechange.link.update"/></a>
							</td>
						</tr>
					{{/if}}
				{{/each}}
				</tbody>
			</table>
</script>


<script id="hbGradeChangeHistory" type="text/x-handlebars-template">
		<table id="tblGradeChangeHistory" class="table table-striped table-bordered dt-responsive  collapsed ">
				<tr>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.existing"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.new"/></th>
					<th><spring:message code="prop.dps.gradechange.status"/></th>
					<th><spring:message code="prop.dps.gradechange.hod"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.asst"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.dps"/></th>
				</tr>
			{{#each .}}
					<tr>
						<td>{{course.lAbrCourseNo}}</td>
						<td><center>{{sectionNo}}</center></td>
						<td><center>{{grade.gradeValOld}}</center></td>
						<td><center>{{grade.gradeValNew}}</center></td>
						<td><center>{{statusDesc}}</center></td>
						<td><center>{{{hod.roleStausIkon}}}</center></td>
						<td><center>{{{dpsAsstDean.roleStausIkon}}}</center></td>
						<td><center>{{{dpsDean.roleStausIkon}}}</center></td>
					</tr>
			{{/each}}
		</table>
</script>

<script id="hbAlert" type="text/x-handlebars-template">
	<div id="idAlert" class="alert alert-danger alert-dismissible fade in" role="alert"> 
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">×</span></button> <h4><spring:message code="err.dps.gradechange.alert"/></h4> 
				<p id="idAlertText">{{alertTxt}}</p> 
	</div> 
</script>

<script id="hbGradeStudentsList" type="text/x-handlebars-template">
	<table id="tblApprover" class="table table-striped table-bordered dt-responsive nowrap collapsed">
		<tr>
			<th><spring:message code="prop.dps.student.student.id"/></th>
			<th><spring:message code="prop.dps.student.student.name"/></th>
			<th><spring:message code="prop.dps.student.student.cohort"/></th>
			<th><spring:message code="prop.dps.student.student.college"/></th>
			<th><spring:message code="prop.dps.student.student.program"/></th>
		</tr>
		
		{{#each students}}
			<tr>
				<td><a class="clsLinkStudentGrades" href="#" roleType="{{encryptStr ../roleType}}"  studentNo="{{encryptStr academicDetail.studentNo}}" stdStatCode="{{encryptStr academicDetail.stdStatCode}}" studentId="{{academicDetail.id}}" studentName="{{academicDetail.studentName}}">{{academicDetail.id}}</a></td>
				<td>{{academicDetail.studentName}}</td>
				<td>{{academicDetail.cohort}}</td>
				<td>{{academicDetail.college}}</td>
				<td>{{academicDetail.degree}}</td>
			</tr>
		{{/each}}
	</table>
</script>

<script id="hbStudentGradesForApprove" type="text/x-handlebars-template">
		<table id="tblGradeChangeHistory" class="table table-striped table-bordered dt-responsive  collapsed ">
				<tr>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.existing"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.new"/></th>
					<th><spring:message code="prop.dps.gradechange.status"/></th>
					<th><spring:message code="prop.dps.gradechange.hod"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.asst"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.dps"/></th>
					<th></th>
				</tr>
			{{#each courseGrade}}
					<tr>
						<td>{{course.lAbrCourseNo}}</td>
						<td><center>{{sectionNo}}</center></td>
						<td><center>{{grade.gradeValOld}}</center></td>
						<td><center>{{grade.gradeValNew}}</center></td>
						<td><center>{{statusDesc}}</center></td>
						<td><center>{{{hod.roleStausIkon}}}</center></td>
						<td><center>{{{dpsAsstDean.roleStausIkon}}}</center></td>
						<td><center>{{{dpsDean.roleStausIkon}}}</center></td>
						<td>
						{{#if approver}}
									<div class="col-xs-4"><label><input type="radio" studentNo="{{encryptStr studentNo}}" stdStatCode="{{encryptStr stdStatCode}}" recno="{{encryptStr recordSequence}}" sectCode="{{encryptStr sectCode}}" courseNo="{{encryptStr course.courseNo}}" lAbrCourseNo2="{{encryptStr course.lAbrCourseNo}}"  sectionNo="{{encryptStr sectionNo}}"  courseYear2="{{encryptStr courseYear}}" semester="{{encryptStr semester}}" roleName="{{../roleName}}" class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm"><spring:message code="prop.dps.role.approve.text"/></label> </div> 
									<div class="col-xs-2"><label><input type="radio" studentNo="{{encryptStr studentNo}}" stdStatCode="{{encryptStr stdStatCode}}" recno="{{encryptStr recordSequence}}" sectCode="{{encryptStr sectCode}}" courseNo="{{encryptStr course.courseNo}}" lAbrCourseNo2="{{encryptStr course.lAbrCourseNo}}" sectionNo="{{encryptStr sectionNo}}"  courseYear2="{{encryptStr courseYear}}" semester="{{encryptStr semester}}" roleName="{{../roleName}}" class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm"> <spring:message code="prop.dps.role.reject.text"/> </label></div> 
						{{/if}}
						</td>
					</tr>
			{{/each}}
		</table>
</script>
