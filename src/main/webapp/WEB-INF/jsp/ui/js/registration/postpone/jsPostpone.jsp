
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentSubmit" var="varAjaxResourceStudentSubmit"></portlet:resourceURL>
<portlet:resourceURL id="resourcePostponeDataByRole" var="varAjaxResourcePostponeDataByRole"></portlet:resourceURL>


<script type="text/javascript">
	$(function(){
	
		
		
		$('#divImgAjaxLoading').hide(); //initially hide the divImgAjaxLoading icon
		 
        $('#divImgAjaxLoading').ajaxStart(function(){
            $(this).show();
            console.log('shown');
        });
        $("#divImgAjaxLoading").ajaxStop(function(){
            $(this).hide();
              console.log('hidden');
        }); 
        
		
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
				dataLoad(postponeDTOs, '#hbPostponeStudies', '#tblPostponeStudies');
			},
			error	:	function(xhr, status, error)
			{
				$('#modalAlertErrMsg').html(xhr.responseText);
				$('#alertModal').modal('toggle');
				$('#divImgAjaxLoading').hide();
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