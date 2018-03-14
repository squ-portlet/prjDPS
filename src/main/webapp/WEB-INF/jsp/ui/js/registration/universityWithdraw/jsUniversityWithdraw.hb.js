<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script id="hbStudentWelcome" type="text/x-handlebars-template">
<div class="col-md-10">
<div class="panel panel-primary">

  <div class="panel-body">
    <form class="form-horizontal" role="form">
      <div class="form-group">
        <div class="col-sm-2">
          <label for="reason" class="control-label"><spring:message code="prop.dps.university.withdraw.reason.select"/></label>
        </div>
        <div class="col-sm-8">
          
          <select id="reason" class="form-control">
          	<option ><spring:message code="prop.dps.university.withdraw.dropdown"/></option>
          	{{#each .}}
          		<option value='{{code}}'>{{value}}</option>
          	{{/each}}
          </select>
          
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="button" class="btn btn-default" id="btnStudentSubmit"><spring:message code="prop.dps.university.withdraw.button.submit"/></button>
        </div>
      </div>
    </form>
  </div>
  <div class="panel-footer"><spring:message code="prop.dps.university.withdraw.note"/></div>
</div>
</div>
</script>

<!-- University Withdraw Records -->
<script id="hbUnivWithDrawStdRecord" type="text/x-handlebars-template">
			<table class="table table-striped table-bordered dt-responsive nowrap collapsed">
				<thead>
					<tr>
						<th><spring:message code="prop.dps.university.withdraw.student.applications.head.column.request.date"/></th>
						<th><spring:message code="prop.dps.university.withdraw.student.applications.head.column.year.sem"/></th>
						<th><spring:message code="prop.dps.university.withdraw.student.applications.head.column.reason"/></th>
						<th colspan="4"><spring:message code="prop.dps.university.withdraw.student.applications.head.column.approver"/></th>
						<th><spring:message code="prop.dps.university.withdraw.student.applications.head.column.action"/></th>
					</tr>
					 <tr>
			             <th colspan="3"></th>
						 <th><spring:message code="prop.dps.university.withdraw.approver.advisor"/></th>
			             <th><spring:message code="prop.dps.university.withdraw.approver.suerpervisor"/></th>
			             <th><spring:message code="prop.dps.university.withdraw.approver.col.dean"/></th>
			             <th><spring:message code="prop.dps.university.withdraw.approver.dps.dean"/></th>
			             <th></th>
		           </tr>
				</thead>
				<tbody>
					{{#each .}}
						<tr>
						<td>{{applyDate}}</td>
		      			<td>{{toCCYearCode}}-{{toSemName}}</td>
		      			<td>{{reason}}</td>
		      			
		      			<td>{{{advisor.roleStausIkon}}}</td>
						<td>{{{supervisor.roleStausIkon}}}</td>
		      			<td>{{{collegeDean.roleStausIkon}}}</td>
		      			<td>{{{dpsDean.roleStausIkon}}}</td>
		      			
		      			<td>{{statusDescription}} &nbsp;
		      					{{#if statusReject}}
		      						<a href="#" class="clsMsgErrStudent" msg='{{comments}}'>
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
</script>

