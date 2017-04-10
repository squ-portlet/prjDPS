<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/dropw/jsDropW.jsp" %>
	


	
	<c:choose>
		<c:when test="${not empty courseList}">
			<table class="table table-bordered">
					<tr>
						<th>Seq. NO.</th>
						<th>Course Code</th>
						<th>Course Title</th>
						<th>Section No</th>
						<th>Credits</th>
						<th>Tution Fees</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${courseList}" var="course" > 
						<tr>
							<td></td>
							<td>${course.lAbrCourseNo}</td>
							<td>${course.courseName}</td>
							<td>${course.sectionNo}</td>
							<td>${course.credits }</td>
							<td>${course.tutionFees}</td>
							<td><a class="clsCourse" href="#" lAbrCourseNo=${course.lAbrCourseNo} courseNo=${course.courseNo} courseName="${course.courseName}" sectCode=${course.sectCode} sectionNo=${course.sectionNo} aria-hidden="true" data-toggle="modal" data-target="#modalDropWForm"><span class="glyphicon glyphicon-pencil"  ></span></a></td>
						</tr>											
					
					</c:forEach>
			</table>
		
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	
    <div class="modal fade" id="modalDropWForm" tabindex="-1" role="dialog" aria-labelledby="myModalStudentConsentForm" aria-hidden="true" >
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
					  	<button type="button" id="bttnSubmitConsent" class="btn btn-default">Submit Button</button>
					  </div>
				  </form:form>
			</div>
          </div>

        </div>
      </div>
    </div>	
	
	<script id="hbCourseData" type="text/x-handlebars-template">
			<div class="alert alert-warning">
				Do you want to drop the course {{lAbrCourseNo}} / {{courseName}} ?
			</div>	
	</script>
	
 -- This is Drop with W student page --