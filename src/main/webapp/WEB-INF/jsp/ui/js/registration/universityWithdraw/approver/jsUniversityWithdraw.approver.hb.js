<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Handlebar template for withdraw from university data for Approvers -->			
<script id="hbUnivWithdrawList" type="text/x-handlebars-template">	
<div class="section">
	<div class="container-fluid">		
	 <table id="tblUnivWithdrawList" class="table table-striped table-bordered dt-responsive nowrap collapsed">
      <thead>
        <tr>
		  <th></th>
		  <th ><spring:message code="prop.dps.sequence.number"/></th>
          <th ><spring:message code="prop.dps.student.student.id"/></th>
          <th ><spring:message code="prop.dps.student.student.name"/></th>
          <th ><spring:message code="prop.dps.student.student.cohort"/></th>
          <th ><spring:message code="prop.dps.student.student.college"/></th>
          <th ><spring:message code="prop.dps.student.student.program"/></th>
		  <th><spring:message code="prop.dps.reason"/></th>

          <th><spring:message code="prop.dps.role.advisor.text"/></th>
          <th><spring:message code="prop.dps.role.supervisor.text"/></th>
          <th><spring:message code="prop.dps.role.college.dean"/></th>
          <th><spring:message code="prop.dps.role.dps.dean"/></th>
          <th ><spring:message code="prop.dps.role.link.approve"/></th>
        </tr>
      </thead>
      <tbody>
	      {{#each .}}
	      	<tr>
	      			<td></td>
	      			<td>{{recordSequence}}</td>
					<td>
						{{studentId}}
			
						{{#if approver}}
								{{#if approverApplicable}}
									<span id="{{studentNo}}-approve" class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
								{{/if}}
						{{/if}}
					</td>
					<td>{{studentName}}</td>
					<td>{{cohort}}</td>
					<td>{{collegeName}}</td>
					<td>{{degreeName}}</td>
					<td>{{reasonStd}}</td>	
					
					<td>{{{advisor.roleStausIkon}}}</td>
					<td>{{{supervisor.roleStausIkon}}}</td>
					<td>{{{collegeDean.roleStausIkon}}}</td>
					<td>{{{dpsDean.roleStausIkon}}}</td>

					<td>
					{{#if approver}}
						{{#if approverApplicable}}
							<div class="col-xs-10">
									<div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm" recordSequence={{recordSequence}} studentno={{studentNo}} studentstatCode={{studentStatCode}}><spring:message code="prop.dps.role.approve.text"/></label> </div>
									<div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm" recordSequence={{recordSequence}} studentno={{studentNo}} studentstatCode={{studentStatCode}}> <spring:message code="prop.dps.role.reject.text"/> </label></div> 
							</div>
						{{else}}
							{{statusDesc}} &nbsp;
								{{#if statusReject}}
              						<a href="#" class="clsMsgErrApprover" msg='{{commentEng}}'>
		              						<font color="default">
		              							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
		              						</font>
              						</a>
              					{{/if}}
						{{/if}}
					{{else}}
						{{statusDesc}} &nbsp;

								{{#if statusReject}}
              						<a href="#" class="clsMsgErrApprover" msg='{{commentEng}}'>
		              						<font color="default">
		              							<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
		              						</font>
              						</a>
              					{{/if}}

					{{/if}}
				</td>	    

			</tr>
	      {{/each}}
      </tbody>
     </table>
   </div>
</div>
</script>