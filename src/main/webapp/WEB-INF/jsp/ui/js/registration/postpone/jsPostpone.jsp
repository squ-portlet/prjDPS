<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentSubmit" var="varAjaxResourceStudentSubmit"></portlet:resourceURL>

<script type="text/javascript">
	$(function(){
		
		/* Submit by student*/
		$('#bttnCompetentSubmit').click(function(){
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
						console.log('success data transfer');
					},
					error	:	function(xhr, status)
					{
						console.log('Error in  data transfer');
					}
			});
			
		});
		
		
	});
</script>