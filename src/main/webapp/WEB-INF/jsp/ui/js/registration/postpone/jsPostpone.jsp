
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentSubmit" var="varAjaxResourceStudentSubmit"></portlet:resourceURL>
<portlet:resourceURL id="resourcePostponeDataByRole" var="varAjaxResourcePostponeDataByRole"></portlet:resourceURL>
<portlet:resourceURL id="resourcePostponeDataApprove" var="varAjaxResourcePostponeDataApprove"></portlet:resourceURL>

<script type="text/javascript">

$(document).ajaxStart(function(){
    $('#divImgAjaxLoading').show();
});
$(document).ajaxStop(function(){
    $('#divImgAjaxLoading').hide();
});


	$(function(){
		var varRoleName;
		var	tblPostponeApprover;
		var	tblRowIndexApprover;
		var	tblRowDataApprover;
		
		var studentModel = {
				yearSem		: 	''

		};
		
		$('#alertPostponeStudies').html('');
		
/* Default screen with postpone data for student*/

 	<c:if test="${isUserTypeStudent}">
		$.ajax({
			url		:	"${varAjaxResourceStudentSubmit}",
			type	:	'POST',
			cache	:	false,
			data	:	studentModel,
			success	:	function(data)
			{
				var	postponeDTOs = JSON.parse(data);
				if(postponeDTOs.length == ${postponeLimit})
					{
						$('#rowButtonAddPostpone').html('');
						var alertText = {'alertText':'<spring:message code="error.dps.postpone.student.maximum.number.of.postpone.rached"/>'};
						dataLoad(alertText, '#hbAlertPostponeStudies', '#alertPostponeStudies');
					}
				
				if(removePostponeSubmit(postponeDTOs))
				{
					$('#rowButtonAddPostpone').html('');
				}
				
				dataLoad(postponeDTOs, '#hbPostponeStudies', '#tblPostponeStudies');
				
			},
			error	:	function(xhr, status, error)
			{
				var alertText = {'alertText':xhr.responseText};

				<c:if test="${empty existingGrades}">
					dataLoad(alertText, '#hbAlertPostponeStudies', '#alertPostponeStudies');
				</c:if>
				
			}
		});
	</c:if>	
	
	/* Show the other reason text */
		$("#reasonCode").change(function(){
	
			if($("#reasonCode").val()=='4533')
			{
				$("#divPostponeReasonOther").show();
				$("#divReasonOtherTxt").html('<textarea  id="reasonOther" name="reasonOther" required/>');
			}
			else
			{
				$("#divPostponeReasonOther").hide();
				$("#divExtReasonOther").hide();
				$("#divReasonOtherTxt").html('');
			}
			
		});
	
	
		
/* Submit by student*/
		$('#bttnCompetentSubmit').click(function(event){
		if ($('#postponeStudentDataModel').valid()) {
			$('#modalPostponeForm').modal('toggle');
			var studentModel = {
					yearSem		: 	$('input[name=yearSem]').val(),
					reasonCode	:	$('#reasonCode').val(),
					reasonOther	:	$('#reasonOther').val()
			};
			
			$('#alertPostponeStudies').html('');
			
			$.ajax({
					url		:	"${varAjaxResourceStudentSubmit}",
					type	:	'POST',
					cache	:	false,
					data	:	studentModel,
					success	:	function(data)
					{
						var	postponeDTOs = JSON.parse(data);
						if(postponeDTOs.length == ${postponeLimit})
						{
							$('#rowButtonAddPostpone').html('');
							var alertText = {'alertText':'<spring:message code="error.dps.postpone.student.maximum.number.of.postpone.rached"/>'};
							dataLoad(alertText, '#hbAlertPostponeStudies', '#alertPostponeStudies');
						}
						
						if(removePostponeSubmit(postponeDTOs))
						{
							$('#rowButtonAddPostpone').html('');
						}
						
						dataLoad(postponeDTOs, '#hbPostponeStudies', '#tblPostponeStudies');
						
					},
					error	:	function(xhr, status, error)
					{
				
						var alertText = {'alertText':xhr.responseText};

						<c:if test="${empty existingGrades}">
							dataLoad(alertText, '#hbAlertPostponeStudies', '#alertPostponeStudies');
						</c:if>
					}
			});
		}	
		});

		/* Alert messages for mainly rejection cases */
		$(document).on("click", ".clsMsgErrStudent", function(event){
			event.preventDefault();
			var alertMsg	=	this.getAttribute("msg");

			var alertMsgJson = {'appAlertMsg': alertMsg};
			dataLoad(alertMsgJson, '#hbAlert', '#divAlertApprover');
		});

		
		
		$(document).on("click", ".clsMsgErrApprover", function(event){
			event.preventDefault();
			var alertMsg	=	this.getAttribute("msg");
			
			var alertMsgJson = {'appAlertMsg': alertMsg};
			dataLoad(alertMsgJson, '#hbAlert', '#divAlertApprover');
		});		
		
	/* Findout for any existing progress/pending postpone  */
		function removePostponeSubmit(data)
		{
			var status_progress_pending=false;
			
			for(var i = 0; i < data.length; i++) {
			    var postpone = data[i];
					if((postpone.statusCodeName === '${statusProgress}') ||
							(postpone.statusCodeName === '${statusPending}')
					 )
					{
						status_progress_pending = true;
					}
			}
			
			return status_progress_pending;
		}



/* Approver */
 
 /* Populate students postpone data based on clicking appropriate role tab */	

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
				$("#divAlertData").hide();
				

				
				$.ajax({
						url		:	"${varAjaxResourcePostponeDataByRole}",
						type	:	'POST',
						cache	:	false,
						data	:	roleNameValue,
						success	:	function(data)
						{
							var postpone=JSON.parse(data);
							if($.trim(postpone))
								{
								
									dataLoad(postpone,'#hbPostponeApprover','#divPostponeApprover');
									
									tblPostponeApprover = $('#tblPostponeApprover').DataTable({
											"sDom":  '<f><t><"col-sm-5"i><"col-sm-2"l><"col-sm-12"p><"clearfix">', 
											"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
									
											
											/*
											"oLanguage": {
												  "sUrl": "${urlCdn}/DataTables/language/lang_${rc.locale.language}.txt"
												},
												*/
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
												 {'data':'reasonDesc'},
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
									$('#divPostponeApprover').html('');
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
				$('#idApprovalMsg').html("<spring:message code='prop.dps.postpone.approver.approve.text'/>");
				$('#linkSubmitApprove').addClass('btn-success').removeClass('btn-danger');
			}
			else
			{
				$('#idComment').show();
				$('#idCommentTxtArea').html('<textarea id="txtMessage" name="txtMessage" rows="" cols="" required></textarea>');
				$('#idApprovalMsg').html("<spring:message code='prop.dps.postpone.approver.reject.text'/>");
				$('#linkSubmitApprove').addClass('btn-danger').removeClass('btn-success');
			}
			tblRowDataApprover 	= 	tblPostponeApprover.table(0).row( this ).data();
			tblRowIndexApprover	=	tblPostponeApprover.row(this).index();
			
			
		});
		

		
		$('#linkSubmitApprove').click(function(event) {
			
			if ($('#formModalApprover').valid()) {
		    	var postponeDTO	= {
		    			recordSequence	: $('#recordSequence').val(),
		    			studentNo 		: $('#studentno').val(),
						studentStatCode		: $('#studentstatCode').val(),
						statusCodeName	: $('#txtModalAppFormStatus').val(),
						roleName		: varRoleName,
						commentEng		: $('#txtMessage').val()
						
					};
		    	$('#modalApprovForm').modal('toggle');
		    	
		    	$.ajax({
		    			url 		:	"${varAjaxResourcePostponeDataApprove}",
		    			type		:	'POST',
		    			data		:	postponeDTO,
		    			success		:	function(data)
		    			{
		    				var postpone = JSON.parse(data);
		    				tblRowDataApprover.recordSequence=postpone.recordSequence;
		    				tblRowDataApprover.studentId=postpone.studentId;
		    				tblRowDataApprover.advisor.roleStausIkon=postpone.advisor.roleStausIkon;
		    				tblRowDataApprover.supervisor.roleStausIkon=postpone.supervisor.roleStausIkon;
		    				tblRowDataApprover.collegeDean.roleStausIkon=postpone.collegeDean.roleStausIkon;
		    				tblRowDataApprover.dpsDean.roleStausIkon=postpone.dpsDean.roleStausIkon;
		    				tblRowDataApprover.approver=postpone.statusDesc;
		    				tblPostponeApprover.row( tblRowIndexApprover ).data(tblRowDataApprover).draw();
		    				
		    			},
		    			error	:	function(xhr, status, error)
		    			{
		    				
		    			}
		    	});
		    	
			}
			
		});
		
		
		
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
		
		Handlebars.registerHelper('ifCond', function(v1, v2, options) {
			  if(v1 === v2) {
			    return options.fn(this);
			  }
			  return options.inverse(this);
			});
		
		
		Handlebars.registerHelper('ifNotCond', function(v1, v2, options) {
			  if(v1 !== v2) {
			    return options.fn(this);
			  }
			  return options.inverse(this);
			});
		
	});
</script>