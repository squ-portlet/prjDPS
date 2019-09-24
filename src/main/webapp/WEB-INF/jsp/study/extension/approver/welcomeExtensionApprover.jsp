<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

			<portlet:resourceURL id="ajaxStudentExtensionDataByRole" var="urlAjaxStudentExtensionDataByRole">
			</portlet:resourceURL>
			
			<portlet:resourceURL id="ajaxExtensionDataApprove" var="urlAjaxExtensionDataApprove"></portlet:resourceURL>
			


      <div class="row">
      		<div class="col-sm-9"></div>
      		<div class="col-sm-2">
      				<a href='<spring:message code="prop.dps.extension.link.help.user.manual"/>'>
      					 <spring:message code="prop.dps.link.help.text"/> <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
      				</a>
      		</div>
      </div>


	<ul class="nav nav-tabs">
		<li role="presentation" id="idExtNav-home" class="clsExtNavRole active"><a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
		<c:if test="${(not empty employee) }">
			<c:forEach items="${employee.myRoles}" var="myRole">
				<li class="clsExtNavRole" id="idExtNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
			</c:forEach>
		</c:if>
	</ul>
	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/study/extension/jsExtension.jsp" %>
	<%@include file="../../../ui/js/study/extension/jsValidationExtension.jsp" %>


    <div class="section">
      <div class="container-fluid">
			<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>		
			<div class="row" id="imgAjaxLoading" style="display: none;">
				<div class="col-sm-5"></div>
				<div class="col-sm-1">
					<img alt="Loading ...." src="${imgAjaxLoader}">
				</div>
			</div>
            <table id="tblExtension" class="table table-striped table-bordered dt-responsive nowrap collapsed"  width="100%" style="display: none;">
              <thead>
                <tr>
                  <th ><spring:message code="prop.dps.student.student.id"/></th>
                  <th ><spring:message code="prop.dps.student.student.name"/></th>
                  <th ><spring:message code="prop.dps.student.student.cohort"/></th>
                  <th ><spring:message code="prop.dps.student.student.college"/></th>
                  <th ><spring:message code="prop.dps.student.student.program"/></th>
                  <th ><spring:message code="prop.dps.student.student.sem"/></th>
<!--                   <th colspan="3">Approver</th> -->
                  <th><spring:message code="prop.dps.role.advisor.text"/></th>
                  <th><spring:message code="prop.dps.role.supervisor.text"/></th>
                  <th><spring:message code="prop.dps.role.college.dean"/></th>
                  <th><spring:message code="prop.dps.role.dps.dean"/></th>
                  <th ><spring:message code="prop.dps.role.link.approve"/></th>
                </tr>
<!--                 <tr>
                  <th>Supervisor</th>
                  <th>Col.Dean</th>
                  <th>DPS Dean</th>
                </tr> -->
              </thead>
              <tbody>
                <tr></tr>
              </tbody>
            </table>


      </div>
    </div>
    
    <div id="divAlertData" class="alert alert-warning" role="alert" ><spring:message code="prop.dps.role.home"/></div>
    
    <div class="modal fade" id="modalApprovForm" role="dialog" aria-labelledby="myModalLabelExtensionForm" aria-hidden="true" >
      <div class="modal-dialog">
        <div class="modal-content">
        	<input type="hidden" id="txtModalAppFormStatus" >
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&nbsp;</button>
            <h4 class="modal-title"><spring:message code="prop.dps.extension.approver.modal.title.text"/> </h4>
          </div>
          <form id="formModalApprover" name="formModalApprover">
          <div class="modal-body">
            <p><!--  spring:message code="prop.dps.extension.approver.modal.body.confirmation.text"/--> </p>
            <p>
            	<div col="col-sm-2"><spring:message code="prop.dps.extension.approver.modal.body.approve.comment.text"></spring:message></div>
            	<div col="col-sm-8"><textarea id="txtMessage" rows="" cols=""></textarea></div>
            </p>
          </div>
          </form>
          <div class="modal-footer">
            <a class="btn btn-default"  data-dismiss="modal"><spring:message code="prop.dps.role.reject.text"/></a>
            <button id="linkSubmitApprove" name="linkSubmitApprove" type="button" class="btn btn-primary"><spring:message code="prop.dps.role.approve.text"/></button>
          </div>
          
        </div>
      </div>
    </div>
   
