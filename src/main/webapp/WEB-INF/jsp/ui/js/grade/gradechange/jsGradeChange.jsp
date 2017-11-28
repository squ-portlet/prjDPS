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
		
		$('#tblGradeListApproval').DataTable({
			
		});
		

	*/
		$('#bttnGradeSearch').click(function(){
			
			$('#idAlert').removeClass('alert in');
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
							 var tablGradeList = $('#tblGradeList').DataTable({
								 select: true,
								 "sDom":  '<t><"col-sm-5"i><"col-sm-12"p><"clearfix">'
							 });
							
							 $('#tblGradeList tbody').on( 'click', 'tr .linkGradeChange', function () {
								 
								
								 var rowIndex=tablGradeList.row( this ).index();
								 var cell = tablGradeList.cell({ row: rowIndex, column: 3 }).node();
								 
								 	
								 	
									instructorApplyForGradeChange(this, cell);

									tablGradeList.row(rowIndex).remove().draw();
									
									
									
									
							});
							 
						},
						error	:	function(xhr, status,  error)
						{
							var alertText = {
									alertTxt: xhr.responseText
							}
							
							hbDataLoadAction(alertText, '#hbAlert', '#divAlertGradeList');
							$('#divGradeList').html('');
							$('#divGradeChangeHistory').html('');
						}
						
						
					
				});
		
				viewInstructorGradeChangeHistory(gradeChangeModel);
			
			
			
			
		});


		function viewInstructorGradeChangeHistory(gradeChangeModel)
		{
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
		}
	
	
	
	
	/* Filling data using handlebar template*/	
		function instructorApplyForGradeChange(data, cell)
		{
		//$(data).closest('tr').find('.gradeValNew').val()
		
		

	 		var crStudentId =	aesUtil.encrypt(salt, four, passphrase, $('#studentId').val());
			var newGradeCode	=	aesUtil.encrypt(salt, four, passphrase, $('select', cell).val());
			var gradeChangeModel = {
					studentId		:	crStudentId,
					studentNo		:	data.getAttribute("stdno"),
					stdStatCode		:	data.getAttribute("stdstatcode"), 
					courseYear		:	data.getAttribute("courseyear"),
					semCode			:	data.getAttribute("semester"),
					sectionNo		:	data.getAttribute("sectionno"),
					courseCode		:	data.getAttribute("courseno"),
					lAbrCrsNo		:	data.getAttribute("labrcourseno"),
					gradeCodeOld	:	data.getAttribute("gradecodeold"),
					gradeCodeNew	:	newGradeCode,
					comments		:	$(data).closest('tr').find('.txtComments').val(),
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
					
					viewInstructorGradeChangeHistory(gradeChangeModel);
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