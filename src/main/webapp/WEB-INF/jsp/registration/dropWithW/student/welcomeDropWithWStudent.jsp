<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/dropw/jsDropW.jsp" %>
			
			<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
			<div class="row" id="imgAjaxLoading" style="display: none;">
				<div class="col-sm-5"></div>
				<div class="col-sm-1">
					<img alt="Loading ...." src="${imgAjaxLoader}">
				</div>
			</div>


      <div class="row">
      		<div class="col-sm-9"></div>
      		<div class="col-sm-2">
      				<a href='<spring:message code="prop.dps.dropw.link.help.user.manual"/>'>
      					<spring:message code="prop.dps.link.help.text"/> <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
      				</a>
      		</div>
      </div>

				
<c:choose>
		<c:when test="${isRuleStudentComplete}">	
			<c:choose>
				<c:when test="${not empty courseList}">
					<table class="table table-bordered">
							<tr>
								<th><spring:message code="prop.dps.course.code"/></th>
								<th><spring:message code="prop.dps.course.title"/></th>
								<th><spring:message code="prop.dps.course.section"/></th>
								<th><spring:message code="prop.dps.course.credits"/></th>
								<th><spring:message code="prop.dps.course.tution.fees"/></th>
								<th><spring:message code="prop.dps.course.action"/></th>
							</tr>
							<c:forEach items="${courseList}" var="course" > 
								<tr>
									<td>${course.lAbrCourseNo}</td>
									<td>${course.courseName}</td>
									<td>${course.sectionNo}</td>
									<td>${course.credits}</td>
									<td>${course.tutionFees}</td>
									<td id='status-${course.sectCode}-${course.sectionNo}'>
										<c:choose>
											<c:when test="${empty course.statusDesc}">
												<a class="clsCourse" href="#" lAbrCourseNo=${course.lAbrCourseNo} courseNo=${course.courseNo} courseName="${course.courseName}" sectCode=${course.sectCode} sectionNo=${course.sectionNo} aria-hidden="true" data-toggle="modal" data-target="#modalDropWForm">
													<span class="glyphicon glyphicon-pencil"  ></span>
												</a>
											</c:when>
											<c:otherwise>
													<span class="glyphicon glyphicon-ban-circle" ></span>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>											
							
							</c:forEach>
					</table>
				
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning">
							<spring:message code="prop.dps.dropw.warn.approver.no.courses.found"/>
					</div>
					<hr>
					    <center>
	          				<div class="alert alert-warning">
	          							<spring:message code="prop.dps.dropw.rule.text"/>
								<br>	<spring:message code="prop.dps.dropw.rule.01"/>
								<br>	<spring:message code="prop.dps.dropw.rule.02"/>
								<br>	<spring:message code="prop.dps.dropw.rule.03"/>
	          				</div>
          				</center>
				
				</c:otherwise>
			</c:choose>
		
		
			
			<div id="tblDropCourses"></div>
			<div id="divDropStatAlert"></div>
		</c:when>
		<c:otherwise>

				<center>
       				<div class="alert alert-warning">
		       					<spring:message code="prop.dps.dropw.rule.text"/>
						<br>	<spring:message code="prop.dps.dropw.rule.01"/>
						<br>	<spring:message code="prop.dps.dropw.rule.02"/>
						<br>	<spring:message code="prop.dps.dropw.rule.03"/>
       				</div>
          	</center>

		</c:otherwise>
		
</c:choose>

	
    <div class="modal fade" id="modalDropWForm" tabindex="-1" role="dialog" aria-labelledby="myModalStudentDropWForm" aria-hidden="true" >
      <div class="modal-dialog modal-sm modal-xs">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">&nbsp;</h4>
          </div>
          <div class="modal-body">
            
            <div class="panel panel-default">
				  <form:form modelAttribute="dropCourseModel" >
				  		<form:hidden path="courseNo"/>
				  		<form:hidden path="sectCode"/>
				  		<form:hidden path="sectNo"/>

					  <div class="panel-body">
					      	<div class="col-sm-10">
        						<div class="content-placeholder"></div>
							</div>
					  </div>
					  <div class="panel-footer">
					  	<button type="button" id="bttnSubmitDrop" class="btn btn-default"><spring:message code="prop.dps.button.submit"/></button>
					  </div>
				  </form:form>
			</div>
          </div>

        </div>
      </div>
    </div>	
	
	<script id="hbCourseData" type="text/x-handlebars-template">
			<div class="alert alert-warning">
				<spring:message code="prop.dps.dropw.student.want.to.drop"/> {{lAbrCourseNo}} / {{courseName}} ?
			</div>	
	</script>
	
	<script id="hbDropCourses" type="text/x-handlebars-template">

		<p>
			<ol class="breadcrumb">
				<li><center><spring:message code="prop.dps.dropw.list.dropped.courses"/></center></li>
			</ol>
		</p>
	<table class="table table-bordered">
	  <tr>
	    <th><spring:message code="prop.dps.course.code"/></th>
	    <th><spring:message code="prop.dps.course.title"/></th>
	    <th><spring:message code="prop.dps.course.section"/></th>
	    <th><spring:message code="prop.dps.course.credits"/></th>
	    <th<spring:message code="prop.dps.course.tution.fees"/>(<spring:message code="prop.dps.role.supervisor.text"/>)</th>
	  </tr>
	{{#each .}}
	  <tr>
	    <td>{{lAbrCourseNo}}</td>
	    <td>{{courseName}}</td>
	    <td>{{sectionNo}}</td>
	    <td>{{credits}}</td>
	    <td>
			{{statusDesc}}
			{{#if statusReject}}
					<a href="#" class="clsMsgErr" msg='{{remarks}}'>
				         <font color="default">
				           	<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
				         </font>
		           </a>
			{{/if}}
		</td>
	  </tr>
	{{/each}}
	</table>
	</script>
	
	<script id="hbDropStatAlert" type="text/x-handlebars-template">
	<div class="alert alert-warning alert-dismissible" role="alert" id="msgAlert"> 
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> 
	 	<strong><spring:message code="prop.dps.extension.student.applications.head.column.action"/>!</strong>
		<br>
				<font color="red"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font> 
						<spring:message code="err.dps.dropw.withdraw.not.possible.text"/>
	  		<hr> 
 			<div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
					<div class="caption">
						<h4><spring:message code="prop.dps.present.situation"/></h4>

						<dl>
							{{#each .}}
									<dt> {{hasThesis.name}} :  {{hasThesis.value}} </dt>
										<dd> {{isThesisCourse.name}} : {{isThesisCourse.value}}</dd>
									<dt> {{studyModeType.name}} : {{studyModeType.value}}  </dt>
										<dd>{{totalCredit.name}} : {{totalCredit.value}}</dd>
										<dd>{{courseCredit.name}} : {{courseCredit.value}}</dd>
									<dt> {{isDropWPeriod.name}}	: {{isDropWPeriod.value}} </dt>
										<dd>{{dropWPeriod.name}} : {{dropWPeriod.value}}</dd>
							{{/each}}
						</dl>
					</div>
				</div>
			</div>

 			<div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
					<div class="caption">
						<h4><spring:message code="prop.dps.dropw.rule.text"/></h4>
						<dl>
							<dd>	<spring:message code="prop.dps.dropw.rule.01"/>	</dd>
							<dd>	<spring:message code="prop.dps.dropw.rule.02"/>	</dd>
							<dd>	<spring:message code="prop.dps.dropw.rule.03"/>	</dd>
							<dd>	<spring:message code="prop.dps.dropw.rule.04"/>	</dd>
						</dl>
					</div>
				</div>
			</div>


	</div>	
	
	</script>
