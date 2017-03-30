<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	
	
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
						<th></th>
					</tr>
					<c:forEach items="${courseList}" var="course" > 
						<tr>
							<td></td>
							<td>${course.courseNo}</td>
							<td>${course.courseName }</td>
							<td>${course.sectionNo}</td>
							<td>${course.credits }</td>
							<td>${course.tutionFees}</td>
							<td></td>
						</tr>											
					
					</c:forEach>
			</table>
		
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	
 -- This is Drop with W student page --