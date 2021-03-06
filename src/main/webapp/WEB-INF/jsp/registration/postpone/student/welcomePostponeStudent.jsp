<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/postpone/jsPostpone.jsp" %>
	<%@include file="../../../ui/js/registration/postpone/jsValidationPostpone.jsp" %>

		<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
		<div class="row" id="divImgAjaxLoading" style="display: none;">
			<div class="col-sm-5"></div>
			<div class="col-sm-1">
				<img alt="Loading ...." src="${imgAjaxLoader}">
			</div>
		</div>


      <div class="row">
      		<div class="col-sm-9"></div>
      		<div class="col-sm-2">
      				<a href='<spring:message code="prop.dps.postpone.link.help.user.manual"/>'>
      					<spring:message code="prop.dps.link.help.text"/> <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
      				</a>
      		</div>
      </div>


		
 	<!-- Alert for any issues -->
     <div  id="alertPostponeStudies"></div>
     <br>
 
<!-- Applying rules -->	
<c:choose> 
  <c:when test="${isRuleStudentComplete}">   
		   <c:choose>
		   		<c:when test="${not empty existingGrades}">
		   			<div class="alert alert-warning">
		   				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		   				<spring:message code="prop.dps.postpone.error.student.existing.grades"/>
		   			</div>
		   			
		   			<div class="panel panel-default">
					  <div class="panel-heading">
					    <h4 class="panel-title alert alert-warning"><spring:message code="prop.dps.postpone.student.course.existing.grades"/></h4>
					  </div>
					  <div class="panel-body">
					    
		   				<table class="table table-bordered">
		   					<thead>
		   						<tr>
		   							<th><spring:message code="prop.dps.postpone.student.course.labrno"/></th>
		   							<th><spring:message code="prop.dps.postpone.student.course.name"/></th>
		   							<th><spring:message code="prop.dps.postpone.student.course.grade.value"/></th>
		   						</tr>
		   					</thead>
		   					<tbody>
		   						<c:forEach items="${existingGrades}" var="course">
		   							<tr>
		   								<td>${course.lAbrCourseNo}</td>
		   								<td>${course.courseName}</td>
		   								<td>${course.gradeValue}</td>
		   							</tr>
		   						</c:forEach>
		   					</tbody>
		   				</table>			    
					    
					  </div>
					</div>
		   		</c:when>
		   		<c:otherwise>
				    <div class="section">
				      <div class="container-fluid">
					      <div class="row" id="rowButtonAddPostpone">
								<c:if test="${not isSemesterPostponed }">
									<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalPostponeForm"><spring:message code="prop.dps.postpone.student.apply"/></button>
								</c:if>	      
					      </div>
				      </div>
				    </div>
			    </c:otherwise>
		   </c:choose>
   </c:when>
	<c:otherwise>
<!-- 			Rule does not satisfy -->
			<center>
				<div class="alert alert-warning alert-dismissible fade in" role="alert">
						<font color="red"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span></font>
						 <spring:message code="err.dps.service.not.available.text"/>
						 	<br>
							<br>	<spring:message code="prop.dps.postpone.rule.text"/>
							<br>	<spring:message code="prop.dps.postpone.rule.01"/>
							<br>	<spring:message code="prop.dps.postpone.rule.02"/>
							<br>	<spring:message code="prop.dps.postpone.rule.03"/> 
				</div>
			</center>	
	</c:otherwise>
</c:choose>
	
 	<!-- Postpone data -->
    <div  id="tblPostponeStudies" ></div>
	 <div  id="divAlertApprover" ></div>
    
    

    
    
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

     
		 
			      <div class="modal-body">
						    <div class="section">
						<form:form    modelAttribute="postponeStudentDataModel" >						    
						      <div class="container">
						        <div class="row">
<!-- 						          <div class="col-md-6"> -->
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="inputEmail3" class="control-label"><spring:message code="prop.dps.postpone.student.applications.form.semester.tobe.postpone" /></label>
						                </div>
						                <div class="col-sm-8">
						                  <label class="radio-inline">
						                   	<form:radiobutton path="yearSem" value="${currYearSem.year}-${currYearSem.semesterCode}"  />${currYearSem.year},${currYearSem.semesterName}
						                  </label>
										<c:if test="{{not empty nextYearSemester}" >
						                  <br>
						                  <label class="radio-inline">
					                    	<form:radiobutton path="yearSem" value="${nextYearSemester.year}-${nextYearSemester.semesterCode}"   />${nextYearSemester.year},${nextYearSemester.semesterName}
						                   </label>
						                 </c:if>
						                </div>
						              </div>
					           </div>   
						       <div class="row">						              
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="reasonCode" class="control-label"><spring:message code="prop.dps.postpone.student.applications.form.reason.for.not.completing"/></label>
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
						        <div class="row" id="divPostponeReasonOther" style="display: none;">
						        	<div class="form-group">
						        		<div class="col-sm-2">
						        			<label for="reasonOther" class="control-label"><spring:message code="prop.dps.postpone.select.reason.other.text"/></label>
						        		</div>
						        		<div class="col-sm-8" id="divReasonOtherTxt">
						        			
						        		</div>
						        	</div>
						        </div>
						       </div>
						    </form:form> 
						      </div>
						    </div>
			      </div>
			      <div class="modal-footer">
			      	<spring:message code="prop.dps.postpone.student.applications.form.submit.question.text"/>
			        <button type="button" id="bttnCompetentCancel" class="btn btn-default" data-dismiss="modal"><spring:message code="prop.dps.postpone.student.applications.form.submit.no"/></button>
			        <button  type="button" id="bttnCompetentSubmit" class="btn btn-primary"><spring:message code="prop.dps.postpone.student.applications.form.submit.yes"/></button>
			      </div>
	      
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
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

<script id="hbAlert" type="text/x-handlebars-template">
	<div id="idAlert" class="alert alert-warning alert-dismissible fade in" role="alert"> 
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
			<h4>
				<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> 
				 <spring:message code="prop.dps.postpone.alert"/>
			</h4>
			<hr>
				<p id="idAlertText">{{appAlertMsg}}</p> 
	</div> 
</script>

<script id="hbAlertPostponeStudies" type="text/x-handlebars-template" >
    <div class="alert alert-warning alert-dismissible" role="alert">
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  		<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> {{alertText}}
		<div id="alertPostponeStudiesMsgText"></div>
	</div>
</script>

<script id="hbPostponeStudies" type="text/x-handlebars-template" >
    <br>
	<div class="section">
      	<div class="container-fluid">
			<div class="row">
			       <table class="table table-striped table-bordered dt-responsive nowrap collapsed">
		              <thead>
		                <tr>
		                  <th><spring:message code="prop.dps.postpone.student.applications.head.column.request.date"/></th>
		                  <th><spring:message code="prop.dps.postpone.student.applications.head.column.year.sem"/></th>
		                 <th><spring:message code="prop.dps.postpone.student.applications.head.column.reason"/></th>
		                  <th colspan="4"><spring:message code="prop.dps.postpone.student.applications.head.column.approver"/></th>
						  <th><spring:message code="prop.dps.postpone.student.applications.head.column.action"/></th>
		                </tr>
		                <tr>
		                  <th colspan="3"></th>
						  <th><spring:message code="prop.dps.postpone.approver.advisor"/></th>
		                  <th><spring:message code="prop.dps.postpone.approver.suerpervisor"/></th>
		                  <th><spring:message code="prop.dps.postpone.approver.col.dean"/></th>
		                  <th><spring:message code="prop.dps.postpone.approver.dps.dean"/></th>
		                  <th></th>
		                </tr>
		              </thead>
		              <tbody>
		              	{{#each .}}
		              		
		              		<tr>
		              			<td>{{activityDate}}</td>
		              			<td>{{toCcYearCode}}-{{toSemName}}</td>
		              			<td>{{reasonDesc}}</td>
		              			
		              			<td>{{{advisor.roleStausIkon}}}</td>
								<td>{{{supervisor.roleStausIkon}}}</td>
		              			<td>{{{collegeDean.roleStausIkon}}}</td>
		              			<td>{{{dpsDean.roleStausIkon}}}</td>
		              			
		              			<td>{{statusDesc}} &nbsp;
		              					{{#if statusReject}}
		              						<a href="#" class="clsMsgErrStudent" msg='{{commentEng}}'>
				              						<font color="default">
				              							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
				              						</font>
		              						</a>
		              					{{/if}}
		              			
		              			
		              			</td>
		              		</tr>
		              	{{/each}}
		              </tbody>
		            </table>
			</div>
		</div>
	</div>
</script>    