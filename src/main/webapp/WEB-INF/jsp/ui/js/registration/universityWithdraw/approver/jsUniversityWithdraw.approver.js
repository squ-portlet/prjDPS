<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<portlet:resourceURL id="resourceUniversityWithdrawByRole" var="varResourceUniversityWithdrawByRole"></portlet:resourceURL>

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