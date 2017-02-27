<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

			<portlet:resourceURL id="ajaxStudentExtensionDataByRole" var="urlAjaxStudentExtensionDataByRole">
			</portlet:resourceURL>

	<ul class="nav nav-tabs">
		<li role="presentation" id="idExtNav-home" class="clsExtNavRole active"><a href="#">Home</a></li>
		<c:if test="${(not empty employee) }">
			<c:forEach items="${employee.myRoles}" var="myRole">
				<li class="clsExtNavRole" id="idExtNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
			</c:forEach>
		</c:if>
	</ul>
	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/study/extension/jsExtension.jsp" %>

<script type="text/javascript">
<!--

//-->


	
</script>
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
                  <th rowspan="2">Student Id</th>
                  <th rowspan="2">Name</th>
                  <th rowspan="2">Cohort</th>
                  <th rowspan="2">College</th>
                  <th rowspan="2">Program</th>
                  <th colspan="3">Approver</th>
                  <th rowspan="2">Action</th>
                </tr>
                <tr>
                  <th>Supervisor</th>
                  <th>Col.Dean</th>
                  <th>DPS Dean</th>
                </tr>
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
        
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>
            <h4 class="modal-title"><spring:message code="prop.dps.extension.approver.modal.title.text"/> </h4>
          </div>
          <div class="modal-body">
            <p><!--  spring:message code="prop.dps.extension.approver.modal.body.confirmation.text"/--> </p>
          </div>
          <div class="modal-footer">
            <a class="btn btn-default"  data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></a>
            <a id="linkSubmitApprove" class="btn btn-primary"><spring:message code="prop.dps.role.submit.yes.text"/></a>
          </div>
          
        </div>
      </div>
    </div>
   
