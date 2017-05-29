<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	
    <div class="section">
      <div class="container-fluid">
	      <div class="row">
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalPostponeForm"><spring:message code="prop.dps.postpone.student.apply"/></button>	      
	      </div>
      </div>
    </div>
    
    
    
<div id="modalContainerPostponeForm" class="container-fluid">
	<div class="modal fade" id="modalPostponeForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPostponeForm" aria-hidden="true" >
	  <div class="modal-dialog  modal-sm" style='width:100%; height:100%'>
	    <div class="modal-content">
	      <div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="PostponeFormHeader">
	        			<spring:message code="prop.dps.postpone.student.applications.form.title"/>
	        	</h4>
	      </div>

     
		 <form:form   method="post" modelAttribute="postponeStudentDataModel" htmlEscape="false">
			      <div class="modal-body">
						    <div class="section">
						      <div class="container">
						        <div class="row">
<!-- 						          <div class="col-md-6"> -->
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="inputEmail3" class="control-label"><spring:message code="prop.dps.postpone.student.applications.form.semester.tobe.postpone" /></label>
						                </div>
						                <div class="col-sm-8">
						                  <label class="radio-inline">
						                   	<form:radiobutton path="yearSem" value="${currYearSem.year}-${currYearSem.semesterCode}"/>${currYearSem.year},${currYearSem.semesterName}
						                  </label>
										<c:if test="${not empty nextYearSemester}" >
						                  <br>
						                  <label class="radio-inline">
					                    	<form:radiobutton path="yearSem" value="${nextYearSemester.year}-${nextYearSemester.semesterCode}"/>${nextYearSemester.year},${nextYearSemester.semesterName}
						                   </label>
						                 </c:if>
						                </div>
						              </div>
					           </div>   
						       <div class="row">						              
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="inputPassword3" class="control-label"><spring:message code="prop.dps.postpone.student.applications.form.reason.for.not.completing"/></label>
						                </div>
						                <div class="col-sm-8">
						                
						                  <form:select path="reasonCode">
						                  		<form:option value=""><spring:message code="prop.dps.postpone.select.reason.text"/></form:option>
						                  		<form:options items="${reasonList}" itemLabel="reasonName" itemValue="siscodecd"/>
						                  </form:select>
						                </div>
						              </div>
<!-- 						          </div> -->
						        </div>
						        <div class="row" id="divExtReasonOther" style="display: none;">
						        	<div class="form-group">
						        		<div class="col-sm-2">
						        			<label for="inputEmail3" class="control-label"><spring:message code="prop.dps.postpone.select.reason.other.text"/></label>
						        		</div>
						        		<div class="col-sm-8">
						        			<form:textarea path="reasonOther"/>
						        		</div>
						        	</div>
						        </div>
						      </div>
						    </div>
			      </div>
			      <div class="modal-footer">
			      	<spring:message code="prop.dps.postpone.student.applications.form.submit.question.text"/>
			        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="prop.dps.postpone.student.applications.form.submit.no"/></button>
			        <button id="bttnCompetentCancel" type="submit" class="btn btn-primary"><spring:message code="prop.dps.postpone.student.applications.form.submit.yes"/></button>
			      </div>
	      </form:form>
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</div>      