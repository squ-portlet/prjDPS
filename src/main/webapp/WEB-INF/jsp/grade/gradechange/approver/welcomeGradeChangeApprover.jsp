<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/grade/gradechange/jsGradeChange.jsp" %>

<div class="section container-fluid">
	<div class="row">
		
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<form>
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
								<option></option>
							</select>		
						</div>
						<div class="form-group">
							<label for="lAbrCrsNo"><spring:message code="prop.dps.gradechange.course.code"/></label>	
							<input type="text" class="form-control" id="lAbrCrsNo" placeholder="Enter CourseNo">		
						</div>
						<div>
							<button type="button" class="btn btn-default" ">
		  						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> <spring:message code="prop.dps.gradechange.button.search"/>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6">
			<table id="tblGradeList" class="table table-striped table-bordered dt-responsive collapsed dataTable">
				<tr>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.existing"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.new"/></th>
					<th><spring:message code="prop.dps.gradechange.action"/></th>
				</tr>
			</table>			
		</div>
	</div>
	
	<div class="row">
		<table id="tblGradeListApproval" class="table table-striped table-bordered dt-responsive collapsed dataTable">
				<tr>
					<th><spring:message code="prop.dps.gradechange.course.code"/></th>
					<th><spring:message code="prop.dps.gradechange.section"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.existing"/></th>
					<th><spring:message code="prop.dps.gradechange.grade.code.new"/></th>
					<th><spring:message code="prop.dps.gradechange.hod"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.asst"/></th>
					<th><spring:message code="prop.dps.gradechange.dean.dps"/></th>
				</tr>
		</table>
	
	
	</div>
	
</div>


