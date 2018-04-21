<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../../../ui/cssWelcome.jsp" %>	
	<%@include file="../../../ui/js/registration/universityWithdraw/approver/jsUniversityWithdraw.approver.hb.js" %>
	<%@include file="../../../ui/js/registration/universityWithdraw/approver/jsUniversityWithdraw.approver.js" %>
	
	<c:url value="/ui/ajax-loader.gif" var="imgAjaxLoader"/>	

	<div class="row" id="divImgAjaxLoading" style="display: none;">
		<div class="col-sm-5"></div>
		<div class="col-sm-1">
			<img alt="Loading ...." src="${imgAjaxLoader}">
		</div>
	</div>
	


	
<!-- Role based tabs -->	
		<ul class="nav nav-tabs">
			<li role="presentation" id="idNav-home" class="clsNavRole active"><a href="#">Home</a></li>
			<c:if test="${(not empty employee) }">
				<c:forEach items="${employee.myRoles}" var="myRole">
					<li class="clsNavRole" id="idNav-${myRole.roleName}" role="presentation"><a id="role-${myRole.roleName}" href="#">${myRole.roleValue}</a></li>
				</c:forEach>
			</c:if>
		</ul>

	
		<div id="divUnivWithdrawList"></div>		


<!--  Modal approver form -->			
    <div class="modal fade" id="modalApprovForm" role="dialog" aria-labelledby="myModalLabelPostponeForm" aria-hidden="true" >
     
      <div class="modal-dialog">
        <div class="modal-content">
        	<input type="hidden" id="txtModalAppFormStatus" >
        	<input type="hidden" id="recordSequence">
        	<input type="hidden" id="studentno">
        	<input type="hidden" id="studentstatCode">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&nbsp;</button>
            <h4 class="modal-title"><spring:message code="prop.dps.postpone.approver.modal.title.text"/> </h4>
          </div>
          <form id="formModalApprover" name="formModalApprover">
          <div class="modal-body">
          		<div id="idApprovalMsg"></div>
				<div id="idComment">
		            	<div col="col-sm-2"><spring:message code="prop.dps.postpone.approver.modal.body.approve.comment.text"></spring:message></div>
		            	<div class="col-sm-8" id="idCommentTxtArea"></div>
            	</div>
          </div>
          </form>
          <div class="modal-footer">
            <a class="btn btn-default"  data-dismiss="modal"><spring:message code="prop.dps.role.submit.no.text"/></a>
            <button id="linkSubmitApprove" name="linkSubmitApprove" type="button" class="btn"><spring:message code="prop.dps.role.submit.yes.text"/></button>
          </div>
          
        </div>
      </div>
    </div>		
		