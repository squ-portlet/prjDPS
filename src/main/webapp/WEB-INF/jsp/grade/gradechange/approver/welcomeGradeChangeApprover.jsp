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
								<a class="linkGradeChange" href="#" stdno="{{encryptStr studentNo}}" stdstatcode="{{encryptStr stdStatCode}}" courseyear="{{courseYear}}" semester="{{semester}}" courseno="{{course.courseNo}}" labrcourseno="{{course.lAbrCourseNo}}" sectionno="{{sectionNo}}"  gradecodeold="{{{encryptStr grade.gradeCode}}}" ><spring:message code="prop.dps.gradechange.link.update"/></a>
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

