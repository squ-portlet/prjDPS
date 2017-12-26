
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentSubmit" var="varAjaxResourceStudentSubmit"></portlet:resourceURL>
<portlet:resourceURL id="resourcePostponeDataByRole" var="varAjaxResourcePostponeDataByRole"></portlet:resourceURL>
<portlet:resourceURL id="resourcePostponeDataApprove" var="varAjaxResourcePostponeDataApprove"></portlet:resourceURL>

<script type="text/javascript">

$('#divImgAjaxLoading').hide(); //initially hide the divImgAjaxLoading icon

$(document).ajaxStart(function(){
    $('#divImgAjaxLoading').show();
});
$(document).ajaxStop(function(){
    $('#divImgAjaxLoading').hide();
});


	$(function(){
		var varRoleName;
		
		var studentModel = {
				yearSem		: 	''

		};
		
/* Default screen with postpone data for student*/
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
		
		
		
/* Submit by student*/
		$('#bttnCompetentSubmit').click(function(){
			$('#modalPostponeForm').modal('toggle');
			var studentModel = {
					yearSem		: 	$('input[name=yearSem]').val(),
					reasonCode	:	$('#reasonCode').val(),
					reasonOther	:	$('#reasonOther').val()
			};
			
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
						dataLoad(postponeDTOs, '#hbPostponeStudies', '#tblPostponeStudies');
						
					},
					error	:	function(xhr, status, error)
					{
						$('#modalAlertErrMsg').html(xhr.responseText);
						$('#alertModal').modal('toggle');
						$('#divImgAjaxLoading').hide();
					}
			});
			
		});
	


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
				
				$("#divImgAjaxLoading").show();
				
				$.ajax({
						url		:	"${varAjaxResourcePostponeDataByRole}",
						type	:	'POST',
						cache	:	false,
						data	:	roleNameValue,
						success	:	function(data)
						{
							$("#divImgAjaxLoading").hide();
							var postpone=JSON.parse(data);
							if($.trim(postpone))
								{
									dataLoad(postpone,'#hbPostponeApprover','#divPostponeApprover');
									$('#tblPostponeApprover').DataTable({
											"sDom":  '<f><t><"col-sm-5"i><"col-sm-2"l><"col-sm-12"p><"clearfix">', 
											"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
											/*
											"oLanguage": {
												  "sUrl": "${urlCdn}/DataTables/language/lang_${rc.locale.language}.txt"
												},
												*/
											"order": []
										
										});
								}
							else
								{
									$('#divPostponeApprover').html('');
								}
						},
						error	:	function(xhr, status)
						{
							$("#divImgAjaxLoading").hide();
						}
				});
				
				
			});
		</c:forEach>


		/* click event on approve/reject radio button */		
		$(document).on("click", ".clsAppAction", function(event){
			event.preventDefault();
			$(this).prop("checked", true);
			$('#txtModalAppFormStatus').val($(this).val());
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
		});
		

		
		$('#linkSubmitApprove').click(function(event) {
			
			if ($('#formModalApprover').valid()) {
		    	var postponeDTO	= {
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
		
		
		
	});
</script>