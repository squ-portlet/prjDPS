<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<portlet:resourceURL id="resourceUniversityWithdrawByRole" var="varResourceUniversityWithdrawByRole"></portlet:resourceURL>
<portlet:resourceURL id="resourceUniversityWithdrawDataApprove" var="varResourceUniversityWithdrawDataApprove"></portlet:resourceURL>

<script type="text/javascript">

$(document).ajaxStart(function(){
    $('#divImgAjaxLoading').show();
});
$(document).ajaxStop(function(){
    $('#divImgAjaxLoading').hide();
});

$(function(){
	var varRoleName;
	var tblUnivWithdrawList;
	var	tblRowIndexApprover;
	var	tblRowDataApprover;
	
 	<c:forEach items="${employee.myRoles}" var="myRole">
	// Clicking on tabs to make it active (other than Home tab)
	$("#role-${myRole.roleName}").click(function(){
		varRoleName	=	'${myRole.roleName}';
		$(".clsNavRole").removeClass("active");
		$("#idNav-${myRole.roleName}").addClass("active");
		
		var roleNameValue = {
				roleName:'testRole',
				roleValue:'${myRole.roleName}'
		};
		
		$.ajax({
					url		:	"${varResourceUniversityWithdrawByRole}",
					type	:	'POST',
					cache	:	false,
					data	:	roleNameValue,
					success	:	function(data)
					{
						var students = JSON.parse(data);
						if($.trim(students))
						{
							
							dataLoad(students, '#hbUnivWithdrawList', '#divUnivWithdrawList');
							tblUnivWithdrawList = $('#tblUnivWithdrawList').DataTable({
								"sDom":  '<f><t><"col-sm-5"i><"col-sm-2"l><"col-sm-12"p><"clearfix">', 
								"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
								"order": [],
								rowId: 'recordSequence',
								"columns" :
									[
									 {'data':null,
									  'defaultContent' : ''	 
									 },
									 {'data':'recordSequence'},
									 {'data':'studentId'},
									 {'data':'studentName'},
									 {'data':'cohort'},
									 {'data':'collegeName'},
									 {'data':'degreeName'},
									 {'data':'reasonCodeStd'},
									 {'data':'advisor.roleStausIkon'},
									 {'data':'supervisor.roleStausIkon'},
									 {'data':'collegeDean.roleStausIkon'},
									 {'data':'dpsDean.roleStausIkon'},
									 {'data':'approver'}
									]
							});
						}
						else
						{
							$('#divUnivWithdrawList').html('');
						}
					},
					error	:	function(xhr, status)
					{
						
					}
					
		});
		
	});
	
	</c:forEach>
	
	
	/* click event on approve/reject radio button */		
	$(document).on("click", ".clsAppAction", function(event){
		event.preventDefault();
		$(this).prop("checked", true);
		$('#txtModalAppFormStatus').val($(this).val());
		$('#recordSequence').val(this.getAttribute("recordSequence"));
		$('#studentno').val(this.getAttribute("studentno"));
		$('#studentstatCode').val(this.getAttribute("studentstatCode"));
		if($(this).val() == '${appApprove}')
		{
			
			$('#idComment').hide();
			$('#idCommentTxtArea').html('');
			$('#idApprovalMsg').html("<spring:message code='prop.dps.university.withdraw.approver.approve.text'/>");
			$('#linkSubmitApprove').addClass('btn-success').removeClass('btn-danger');
		}
		else
		{
			$('#idComment').show();
			$('#idCommentTxtArea').html('<textarea id="txtMessage" name="txtMessage" rows="" cols="" required></textarea>');
			$('#idApprovalMsg').html("<spring:message code='prop.dps.university.withdraw.approver.reject.text'/>");
			$('#linkSubmitApprove').addClass('btn-danger').removeClass('btn-success');
		}
		tblRowDataApprover 	= 	tblPostponeApprover.table(0).row( this ).data();
		tblRowIndexApprover	=	tblPostponeApprover.row(this).index();
		
		
	});

	
	$('#linkSubmitApprove').click(function(event) {
		
		//if ($('#formModalApprover').valid()) {
	    	var universityWithdrawDTO	= {
	    			recordSequence	: $('#recordSequence').val(),
	    			studentNo 		: $('#studentno').val(),
					studentStatCode		: $('#studentstatCode').val(),
					statusCodeName	: $('#txtModalAppFormStatus').val(),
					roleName		: varRoleName,
					comments		: $('#txtMessage').val()
					
				};
	    	$('#modalApprovForm').modal('toggle');
	    	
	    	$.ajax({
	    			url 		:	"${varResourceUniversityWithdrawDataApprove}",
	    			type		:	'POST',
	    			data		:	universityWithdrawDTO,
	    			success		:	function(data)
	    			{
	    				/*
	    				var postpone = JSON.parse(data);
	    				tblRowDataApprover.recordSequence=postpone.recordSequence;
	    				tblRowDataApprover.studentId=postpone.studentId;
	    				tblRowDataApprover.advisor.roleStausIkon=postpone.advisor.roleStausIkon;
	    				tblRowDataApprover.supervisor.roleStausIkon=postpone.supervisor.roleStausIkon;
	    				tblRowDataApprover.collegeDean.roleStausIkon=postpone.collegeDean.roleStausIkon;
	    				tblRowDataApprover.dpsDean.roleStausIkon=postpone.dpsDean.roleStausIkon;
	    				tblRowDataApprover.approver=postpone.statusDesc;
	    				tblPostponeApprover.row( tblRowIndexApprover ).data(tblRowDataApprover).draw();
	    				*/
	    				
	    			},
	    			error	:	function(xhr, status, error)
	    			{
	    				
	    			}
	    	});
	    	
		//}
		
	});
	 	
	
	
	
	/* Data load to handlebars template */
	function dataLoad(dataJson, hbTemplateId, tableId)
	{
		if ($.trim(dataJson))
		{
			var theAlertTemplate=$(hbTemplateId).html();
			var template = Handlebars.compile(theAlertTemplate);
			$(tableId).html(template(dataJson));
		}
		return true;
		
	}	
	
	
	
});

</script>