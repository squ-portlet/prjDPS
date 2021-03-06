<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://squ.dps/roleGlyph" prefix="dps" %>

<%@include file="../../../ui/cssWelcome.jsp" %>
<%@include file="../../../ui/js/study/extension/jsExtension.jsp" %>
<%@include file="../../../ui/js/study/extension/jsValidationExtension.jsp" %>

<portlet:renderURL var="varExtensionForm">
	<portlet:param name="action" value="studentExtensionForm"/>
</portlet:renderURL>

    <div class="section">
      <div class="container-fluid">
      <div class="row">
      		<div class="col-sm-9"></div>
      		<div class="col-sm-2">
      				
      				<a href='<spring:message code="prop.dps.extension.link.help.user.manual"/>'>
      					<spring:message code="prop.dps.link.help.text"/> <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
      				</a>
      		</div>
      </div>
        <div class="row">
          <div class="">
          		<c:choose>
          			<c:when test="${isRuleStudentComplete}">
          				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#modalExtensionForm"><spring:message code="prop.dps.extension.student.apply"/></button>
          			</c:when>
          			<c:otherwise>
          				<center>
	          				<div class="alert alert-warning">
	          							<spring:message code="prop.dps.extension.rule.text"/>
								<br>	<spring:message code="prop.dps.extension.rule.01"/>
								<br>	<spring:message code="prop.dps.extension.rule.02"/>
								<br>	<spring:message code="prop.dps.extension.rule.03"/>
								<br>	<spring:message code="prop.dps.extension.rule.04"/>									          				
	          				</div>
          				</center>
          				
 <!-- RULE Text --  Display Fulfillment of rules to Student -->

						<div class="row">
				
						<div class="col-sm-3 col-md-2">&nbsp;</div>
				
						  <div class="col-sm-7 col-md-5">
						    <div class="thumbnail">
						      <div class="caption">
						        <h4><spring:message code="prop.dps.present.situation"/></h4>
						        <p>
			          				<dl>
				          				<c:forEach items="${myRules}" var="mapRule">
			      								<c:if test="${mapRule.key ==  'isAlreadyExtensionExist'}">
			      									<dt>
			      										${mapRule.value.name} : ${mapRule.value.value}
			      									</dt>
			      								</c:if>
			          							<c:choose>
				          							<c:when test="${mapRule.key == 'hasThesis'}">
				          								<dt>${mapRule.value.name} : ${mapRule.value.value}</dt>
				          									<c:forEach items="${myRules}" var="mapRule02">
						          								<c:if test="${mapRule02.key ==  'isFirstSeminarCompletedApplicable'}">
						          									<dd>
						          										${mapRule02.value.name} : ${mapRule02.value.value}
						          									</dd>
						          								</c:if>	
					          								</c:forEach>
				          							</c:when>
				          							<c:otherwise>
				          								
				          							</c:otherwise>
			          							</c:choose>
					          			</c:forEach>
			   							<c:forEach items="${myRules}" var="mapRule">
			      								<c:if test="${mapRule.key ==  'isLastSemester'}">
			      									<dt>
			      										${mapRule.value.name} : ${mapRule.value.value}
			      									</dt>
			      								</c:if>
			        								<c:if test="${mapRule.key ==  'curYearSemester'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>
			        								<c:if test="${mapRule.key ==  'studentMode'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>
			        								<c:if test="${mapRule.key ==  'degreeStartTime'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>
			        								<c:if test="${mapRule.key ==  'totalSem'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>
			        								<c:if test="${mapRule.key ==  'postponeCount'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>
			        								<c:if test="${mapRule.key ==  'isLangCourse'}">
			        									<dd>
			        										${mapRule.value.name} : ${mapRule.value.value}
			        									</dd>
			        								</c:if>        								        								
			      								<c:if test="${mapRule.key ==  'isWeekSpecifiedAvailable'}">
			      									<dt>
			      										${mapRule.value.name} : ${mapRule.value.value}
			      									</dt>
			      								</c:if>			          							
			   							</c:forEach>
			          				</dl>
						        </p>
						
						      </div>
						    </div>
						  </div>
						</div>
 
 <!-- End of Rule Text  -->
 
           			</c:otherwise>
          		</c:choose>
          </div>
        </div>
      </div>
      <div class="row">
        <div >
          <div class="container-fluid">
				<c:if test="${not empty extenstions}">          	
		            <table class="table table-striped table-bordered dt-responsive nowrap collapsed">
		              <thead>
		                <tr>
		                  <th><spring:message code="prop.dps.extension.student.applications.head.column.request.date"/></th>
		                  <th><spring:message code="prop.dps.extension.student.applications.head.column.year.sem"/></th>
		                 <th><spring:message code="prop.dps.extension.student.applications.head.column.reason"/></th>
		                  <th colspan="3"><spring:message code="prop.dps.extension.student.applications.head.column.approver"/></th>
						  <th><spring:message code="prop.dps.extension.student.applications.head.column.action"/></th>
		                </tr>
		                <tr>
		                  <th colspan="3"></th>

		                  <th>
			                  <c:choose>
			                  		<c:when test="${hasSuperVisor}">
			                  			<spring:message code="prop.dps.extension.student.applications.head.column.approver.suerpervisor"/>
			                  		</c:when>
			                  		<c:otherwise>
			                  			<spring:message code="prop.dps.extension.student.applications.head.column.approver.advisor"/>
			                  		</c:otherwise>
			                  </c:choose>
		                  </th>
		                  <th><spring:message code="prop.dps.extension.student.applications.head.column.approver.col.dean"/></th>
		                  <th><spring:message code="prop.dps.extension.student.applications.head.column.approver.dps.dean"/></th>
		                  <th></th>
		                </tr>
		              </thead>
		              <tbody>
		              	<c:forEach items="${extenstions}" var="ext">
		              		
		              		<tr>
		              			<td>${ext.activitiDate}</td>
		              			<td>${ext.toCcYrCode}-${ext.toSemName}</td>
		              			<td>${ext.reasonDesc}</td>
		              			<td>
			              			<c:choose>
				                  		<c:when test="${hasSuperVisor}">
				                  			${ext.supervisor.roleStausIkon}
				                  		</c:when>
				                  		<c:otherwise>
				                  			${ext.advisor.roleStausIkon}
				                  		</c:otherwise>
				                  	</c:choose>		              			
		              			</td>
		              			<td>${ext.collegeDean.roleStausIkon}</td>
		              			<td>${ext.dpsDean.roleStausIkon}</td>
		              			
		              			<td>${ext.statusDesc} &nbsp;
		              					<c:if test="${ext.statusCodeName eq 'REJCT'}">
		              						<a href="#" class="clsMsgErr" msg='${ext.commentEng}'>
				              						<font color="default">
				              							<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
				              						</font>
		              						</a>
		              					</c:if>
		              			
		              			
		              			</td>
		              		</tr>
		              	</c:forEach>
		              </tbody>
		            </table>
		        </c:if>
          </div>
        </div>
      </div>
      
      <div class="row container-fluid" id="idRowMsg">

      </div>
    </div>
    
    
    


<portlet:actionURL var="varStudentFormAction">
	<portlet:param name="action" value="studentFormAction"/>
</portlet:actionURL>

<div id="modalContainerExtensionForm" class="container-fluid">
	<div class="modal fade" id="modalExtensionForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabelExtensionForm" aria-hidden="true" >
	  <div class="modal-dialog  modal-sm" style='width:100%; height:100%'>
	    <div class="modal-content">
	      <div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        	<h4 class="modal-title" id="extensionFormHeader">
	        			<spring:message code="prop.dps.extension.student.applications.form.title"/>
	        	</h4>
	      </div>

		 <form:form modelAttribute="extensionStudentDataModel" action="${varStudentFormAction}"  method="post" htmlEscape="false">
			      <div class="modal-body">
						    <div class="section">
						      <div class="container">
						        <div class="row">
<!-- 						          <div class="col-md-6"> -->
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="inputEmail3" class="control-label"><spring:message code="prop.dps.extension.student.applications.form.semester.tobe.extended"/></label>
						                </div>
						                <div class="col-sm-8">
											<c:choose>
												<c:when test="${weekSpecified}">
								                  <label class="radio-inline">
								                  	<c:choose>
								                  		<c:when test="${empty  nextYearSemester.year && empty nextYearSemester.semesterCode }">
								                  			<form:radiobutton path="yearSem" value="${currYearSem.year}-${currYearSem.semesterCode}"/>${currYearSem.year},${currYearSem.semesterName}
								                  		</c:when>
								                  		<c:otherwise>
															<form:radiobutton path="yearSem" value="${nextYearSemester.year}-${nextYearSemester.semesterCode}"/>${nextYearSemester.year},${nextYearSemester.semesterName}								                  			
								                  		</c:otherwise>
								                  	</c:choose>
								                  </label>
												</c:when>
												<c:otherwise>
								                  <label class="radio-inline">
							                    	<form:radiobutton path="yearSem" value="${currYearSem.year}-${currYearSem.semesterCode}"/>${currYearSem.year},${currYearSem.semesterName}
								                   </label>
												</c:otherwise>
											</c:choose>
						                </div>
						              </div>
					           </div>   
						       <div class="row">						              
						              <div class="form-group">
						                <div class="col-sm-2">
						                  <label for="inputPassword3" class="control-label"><spring:message code="prop.dps.extension.student.applications.form.reason.for.not.completing"/></label>
						                </div>
						                <div class="col-sm-8">
						                  <form:select path="reasonCode">
						                  		<form:option value=""><spring:message code="prop.dps.extension.select.reason.text"/></form:option>
						                  		<form:options items="${reasonList}" itemLabel="reasonName" itemValue="siscodecd"/>
						                  </form:select>
						                </div>
						              </div>
<!-- 						          </div> -->
						        </div>
						        <div class="row" id="divExtReasonOther" style="display: none;">
						        	<div class="form-group">
						        		<div class="col-sm-2">
						        			<label for="inputEmail3" class="control-label"><spring:message code="prop.dps.extension.select.reason.other.text"/></label>
						        		</div>
						        		<div class="col-sm-8">
						        			<form:textarea path="reasonOther" />
						        		</div>
						        	</div>
						        </div>
						      </div>
						    </div>
			      </div>
			      <div class="modal-footer">
			      	<spring:message code="prop.dps.extension.student.applications.form.submit.question.text"/>
			        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="prop.dps.extension.student.applications.form.submit.no"/></button>
			        <button id="bttnCompetentCancel" type="submit" class="btn btn-primary"><spring:message code="prop.dps.extension.student.applications.form.submit.yes"/></button>
			      </div>
	      </form:form>
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</div>    
  

