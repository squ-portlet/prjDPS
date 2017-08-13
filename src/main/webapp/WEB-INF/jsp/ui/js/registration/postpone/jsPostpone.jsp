
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentSubmit" var="varAjaxResourceStudentSubmit"></portlet:resourceURL>

<script type="text/javascript">
	$(function(){
		
		
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
					}
			});
			
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