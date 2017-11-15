<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceAjaxGetStudentGrades" var="varResourceAjaxGetStudentGrades"/>

<script type="text/javascript">
	$(function() {

	/*		
		$('#tblGradeList').DataTable({
			
		});
		

		
		$('#tblGradeListApproval').DataTable({
			
		});
		

	*/
		$('#bttnGradeSearch').click(function(){

			
			//Encrypt Student Id
			var crStudentId =	aesUtil.encrypt(salt, four, passphrase, $('#studentId').val());
			
			var gradeChangeModel	=	{
					studentId	:	crStudentId,
					courseYear	:	$('#courseYear').val(),
					semCode		:	$('#semCode').val(),
					lAbrCrsNo	:	$('#lAbrCrsNo').val(),
					salt		:	salt,
					four		:	four
			};
			
			$.ajax({
						url		:	"${varResourceAjaxGetStudentGrades}",
						type	:	'POST',
						cache	:	false,
						data	:	gradeChangeModel,
						success	:	function(data)
						{
							
						},
						error	:	function(xhr, status,  error)
						{
							
						}
					
				});
			
		});
		
		
	});
</script>