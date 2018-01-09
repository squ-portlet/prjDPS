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
				
				<div class="col-sm-6">
					<div id="divStudentList"></div>
				</div>
		</div>
		
		</div>
	</div>
</c:if>		

	   <!-- Modal HTML -->
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


<script id="hbStudentList" type="text/x-handlebars-template">
			<table id="tblStudentList" class="table table-condensed table-bordered dt-responsive">
				<thead>
					<tr>
						<th><spring:message code="prop.dps.incomplete.grade.notify.student.id"/></th>
						<th>
							<spring:message code="prop.dps.incomplete.grade.notify.students"/>  
								<span class="label label-default">{{lAbrCourseNo}}</span>
								<span class="badge">{{sectionNo}}</span>
						</th>
						<th><spring:message code="prop.dps.incomplete.grade.notify.grade.name"/></th>
						<th><spring:message code="prop.dps.incomplete.grade.notify.action"/></th>

					</tr>
				</thead>
					{{#each students}}
					<tr>
						<td>
								{{student.personalDetail.id}}
						</td>
						<td>{{student.personalDetail.name}}</td>
						<td>{{grade.gradeVal}}</td>
						<td>
								{{#unless  grade.gradeCode}}
									<a class="clsLinkStudentNo"  href="#" 
														lAbrCourseNo="{{encryptStr ../lAbrCourseNo}}" 
														studentNo="{{encryptStr student.personalDetail.studentNo}}"
														stdStatCode="{{encryptStr student.academicDetail.stdStatCode}}"
														sectionNo="{{encryptStr ../sectionNo}}"
														sectCode="{{encryptStr ../sectCode}}"
														courseYear="{{encryptStr ../courseYear}}"
														semester="{{encryptStr ../semester}}"
									>
										<spring:message code="prop.dps.incomplete.grade.notify.text.notify" /> 
										<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
									</a>
								{{/unless}}
						</td>
					</tr>
					{{/each}}
				<tbody>
				
				</tbody>				
			</table>
</script>

