<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceAjaxGetStudentGrades" var="varResourceAjaxGetStudentGrades"/>
<portlet:resourceURL id="resourceAjaxGetStudentGradesChangeHistory" var="varResourceAjaxGetStudentGradesChangeHistory"/>
<portlet:resourceURL id="resourceAjaxGradeChangeApply" var="varResourceAjaxGradeChangeApply"/>

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
							var gradeDTOs	=	JSON.parse(data); 
	
							 hbDataLoadAction(gradeDTOs, '#hbGradeList', '#divGradeList');
							 
								$('.linkGradeChange').on('click',function (e){
									instructorApplyForGradeChange(this)
								});
						},
						error	:	function(xhr, status,  error)
						{
							
						}
					
				});
		
			
			$.ajax({
				url		:	"${varResourceAjaxGetStudentGradesChangeHistory}",
				type	:	'POST',
				cache	:	false,
				data	:	gradeChangeModel,
				success	:	function(data)
				{
					var gradeDTOs	=	JSON.parse(data); 
					 hbDataLoadAction(gradeDTOs, '#hbGradeChangeHistory', '#divGradeChangeHistory');
				},
				error	:	function(xhr, status,  error)
				{
					
				}
			
			});
			
			
			
		});
	
	/* Filling data using handlebar template*/	
		function instructorApplyForGradeChange(data)
		{
			var newGradeCode	=	aesUtil.encrypt(salt, four, passphrase, $(data).closest('tr').find('.gradeValNew').val());
			var gradeChangeModel = {
					studentNo		:	data.getAttribute("stdno"),
					stdStatCode		:	data.getAttribute("stdstatcode"),
					courseYear		:	data.getAttribute("courseyear"),
					semCode			:	data.getAttribute("semester"),
					sectionNo		:	data.getAttribute("sectionno"),
					courseCode		:	data.getAttribute("courseno"),
					lAbrCrsNo		:	data.getAttribute("labrcourseno"),
					gradeCodeOld	:	data.getAttribute("gradecodeold"),
					gradeCodeNew	:	newGradeCode,
					salt			:	salt,
					four			:	four
			};
			
			$.ajax({
				url		:	"${varResourceAjaxGradeChangeApply}",
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
			
			
		}
	


	

	/* Filling data using handlebar template*/
	function hbDataLoadAction(dataJson, hbTemplateId, divId)
	{
		if ($.trim(dataJson))
			{
			var theAlertTemplate=$(hbTemplateId).html();
			var template = Handlebars.compile(theAlertTemplate);
			$(divId).html(template(dataJson));
			}
		return true;
	}
	

	/* Call back function for encryption */
	Handlebars.registerHelper("encryptStr", function(item) {
		  var html = '';
		    html = html + aesUtil.encrypt(salt, four, passphrase, item.toString()); 
		  return html;
		});
	
		
	});
</script>