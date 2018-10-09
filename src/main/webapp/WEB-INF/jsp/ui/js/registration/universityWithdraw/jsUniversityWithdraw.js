<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<portlet:resourceURL id="resourceStudentApplications" var="varResourceStudentApplications"></portlet:resourceURL>
<portlet:resourceURL id="resourceStudentReasons" var="varResourceStudentReasons"></portlet:resourceURL>
<portlet:resourceURL id="resourceStudentSubmit" var="varResourceStudentSubmit"></portlet:resourceURL>

<script type="text/javascript">

	$(document).ajaxStart(function(){
	    $('#divImgAjaxLoading').show();
	});

	$(document).ajaxStop(function(){
	    $('#divImgAjaxLoading').hide();
	});


$(function(){
	<c:choose>
		<c:when test="${canStudentApply}">				
				/* Default load of Student UI */
				var testData  	= {test : ''}; 
				
				$.ajax({
						url 	: 	"${varResourceStudentReasons}",
						type	:	'POST',
						cache	:	false,
						data	:	testData,
						success	:	function(data)
						{
							var reasons	=	JSON.parse(data);
							dataLoad(reasons, '#hbStudentWelcome', '#divStudentWelcome');
						},
						error	:	function(xhr, status, error)
						{
		
						}
				});
		</c:when>
		<c:otherwise>
				var testData  	= {test : ''}; 
					$.ajax({
							url		: "${varResourceStudentApplications}",
							type	: 'POST',
							cache	:	false,
							data	:	testData,
							success	:	function(data)
							{
								var dtos	=	JSON.parse(data);
								
								dataLoad(dtos, '#hbUnivWithDrawStdRecord', '#divUnivWithDrawStdRecord');
								$('#divStudentWelcome').remove();
							},
							error	:	function(xhr, status, error)
							{
				
							}
						});
		</c:otherwise>
	</c:choose>
		
		/* Submit by student */
		$(document).on("click", "#btnStudentSubmit", function(event){
			var universityWithdrawModel = {
					reasonCode	:	$('#reason').val()
			};
			
			$.ajax({
						url		: "${varResourceStudentSubmit}",
						type	: 'POST',
						cache	:	false,
						data	:	universityWithdrawModel,
						success	:	function(data)
						{
							var dtos	=	JSON.parse(data);
							
							dataLoad(dtos, '#hbUnivWithDrawStdRecord', '#divUnivWithDrawStdRecord');
							$('#divStudentWelcome').remove();
						},
						error	:	function(xhr, status, error)
						{

						}
			});
			
		});
		
		
		

		
/* Handlebar data load */		
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