<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceAjaxGetStudentGrades" var="varResourceAjaxGetStudentGrades"/>
<portlet:resourceURL id="resourceAjaxGetStudentGradesChangeHistory" var="varResourceAjaxGetStudentGradesChangeHistory"/>
<portlet:resourceURL id="resourceAjaxGradeChangeApply" var="varResourceAjaxGradeChangeApply"/>
<portlet:resourceURL id="resoureAjaxGradeChangeDataByRole" var="varResoureAjaxGradeChangeDataByRole"/>
<portlet:resourceURL id="resoureAjaxCourseListForGradeChange" var="varResoureAjaxCourseListForGradeChange"/>
<portlet:resourceURL id="resourceAjaxGradeChangeApproval" var="varResourceAjaxGradeChangeApproval"/>
<portlet:resourceURL id="resourceStudentList" var="varResourceStudentList"/>


<script type="text/javascript">
	$( document ).ajaxStart(function() {
		$('#imgAjaxLoading').show();
	});
	
	$( document ).ajaxStop(function() {
		$('#imgAjaxLoading').hide();
	});


	$(function() {
		
	/*
		
		$('#tblGradeListApproval').DataTable({
			
		});
		

	*/
	
	<c:forEach items="${employee.myRoles}" var="myRole">
	// Clicking on tabs to make it active (other than Home tab)
	$("#role-${myRole.roleName}").click(function(){
		$(".clsNavRole").removeClass("active");
		$("#idNav-${myRole.roleName}").addClass("active");
		
		var roleNameValue = {
				roleName:'testRole',
				roleValue:'${myRole.roleName}'
		};
		
		$('#idDivInstructor').hide();
		$('#divStudentGradesForApprove').html('');
		

		$.ajax({
			url		:	"${varResoureAjaxGradeChangeDataByRole}",
			type	:	'POST',
			cache	:	false,
			data	:	roleNameValue,
			success	:	function(data)
			{
				var students=JSON.parse(data);
				var studentsJson={'students':students,'roleType':'${myRole.roleName}'};
				hbDataLoadAction(studentsJson, '#hbGradeStudentsList', '#divGradeStudentsList');
				
				var tablApprover = $('#tblApprover').DataTable({
					 select: true,
					 "sDom":  '<f><t><"col-sm-5"i><"col-sm-12"p><"clearfix">'
				 });
			},
			error	:	function(xhr, status)
			{
				$("#imgAjaxLoading").hide();
			}
	});
		
	});	
	</c:forEach>
	
	$("#idNav-home").click(function(){
		$(".clsNavRole").removeClass("active");
		$("#idNav-home").addClass("active");
	
		$('#idDivInstructor').show();
		$('#divGradeStudentsList').html('');
		
	});
	
	
	$(document).on("click", ".clsLinkCourseNo", function(event){
		event.preventDefault();
		$('#divStudentList').html('');
		$('#divGradeList').html('');
		$('#divGradeChangeHistory').html('');
		var lAbrCourseNoModel	=	{
				lAbrCourseNo	:	this.getAttribute("lAbrCourseNo")
		};
		
		var lAbrCourseNo	=	this.getAttribute("lAbrCourseNo");
		var sectionNo		=	this.getAttribute("sectionNo");
		
		$.ajax({
			url 	:	"${varResourceStudentList}", 
			data 	:	lAbrCourseNoModel,
			cache	: false,
			type	: 'POST',
			success	: function(data)
			{

				var students	=	JSON.parse(data); 
				var studentsJson = {'students':students, 'lAbrCourseNo':lAbrCourseNo, 'sectionNo':sectionNo};
				 hbDataLoadAction(studentsJson, '#hbStudentList', '#divStudentList');
				 var tablStudentList = $('#tblStudentList').DataTable({
					 select: true,
					 "sDom":  '<f><t><"col-sm-5"i><"col-sm-12"p><"clearfix">'
				 });
				 
			},
			error	:	function(xhr, status,  error)
			{
				
			}
			
		});
		
		
	})

	/* onClick student id */
	$(document).on("click", ".clsLinkStudentNo", function(event){
		event.preventDefault();
		$('#divGradeList').html('');
		$('#divGradeChangeHistory').html('');
		
		var gradeChangeModel	=	{
				studentId	:	this.getAttribute("studentId"),
				lAbrCrsNo	:	this.getAttribute("lAbrCourseNo"),
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
	
	
	$(document).on("click", ".linkGradeChange", function(event){
		if ($('#formGradeList').valid()) {
			var gradeChangeModel	=	{
					studentId	:	$("#studentId").val(),
					lAbrCrsNo	:	this.getAttribute("lAbrCourseNo"),
					salt		:	salt,
					four		:	four
			};
			
			instructorApplyForGradeChange(this, null);
			$('.divClsGradeListData').html('');
			viewInstructorGradeChangeHistory(gradeChangeModel);
		}
	})
	
	
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
					 var tablGradeChangeHistory = $('#tblGradeChangeHistory').DataTable({
						 select: true,
						 "sDom":  ''
					 });
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
					sectCode		:	data.getAttribute("sectCode"),
					courseYear		:	data.getAttribute("courseyear"),
					semCode			:	data.getAttribute("semester"),
					sectionNo		:	data.getAttribute("sectionno"),
					courseCode		:	data.getAttribute("courseno"),
					lAbrCrsNo		:	data.getAttribute("labrcourseno"),
					gradeCodeOld	:	data.getAttribute("gradecodeold"),
					gradeCodeNew	:	newGradeCode,
					comments		:	$('.txtComments').val(),
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
	
		/* popover for Instructor comments*/
		$(document).on("click",".classPopMsgInstructor",function(event){
			event.preventDefault();
			$('.classPopMsgInstructor').popover({
				html: true,
				title: '<spring:message code="prop.dps.gradechange.popover.title.instructor.message"/>',
				placement: 'top',
				container: 'body',
				content : function()
				{
					return this.getAttribute("comments")
				}
			});
		});
	
	
	
		/* Load and display course data with grade for approver */
		$(document).on("click", ".clsLinkStudentGrades", function(event){
			var roleType	=	this.getAttribute("roleType");
			var gradeChangeModel = {
					studentNo		:	this.getAttribute("studentNo"),
					stdStatCode		:	this.getAttribute("stdstatcode"), 
					roleName		:	this.getAttribute("roleType"),
					salt			:	salt,
					four			:	four
			};
			
			$.ajax({
				url			:	"${varResoureAjaxCourseListForGradeChange}",
				type		:	'POST',
				cache		:	false,
				data		:	gradeChangeModel,
				success		:	function(data)
				{
							var	courseGrade	=	JSON.parse(data);
							var courseGradeJson = {'courseGrade':courseGrade, 'roleName': roleType};
							hbDataLoadAction(courseGradeJson, '#hbStudentGradesForApprove', '#divStudentGradesForApprove');
							var tablGradeChangeHistory02 = $('#tblGradeChangeHistory02').DataTable({
								 select: true,
								 "sDom":  ''
							 });
				}
			});
			
		});
	

		/* click event on approve/reject radio button */		
		$(document).on("click", ".clsAppAction", function(event){
			event.preventDefault();
			//$('#modalApprovForm').modal('toggle');
			$(this).prop("checked", true);
			$('#recordSequence').val(this.getAttribute("recno"))
			$('#studentNo').val(this.getAttribute("studentNo"));
			$('#stdStatCode').val(this.getAttribute("stdStatCode"));
			$('#sectcode').val(this.getAttribute("sectcode"));
			$('#courseCode').val(this.getAttribute("courseNo"));
			$('#lAbrCourseNo2').val(this.getAttribute("lAbrCourseNo2"));
			$('#sectionNo').val(this.getAttribute("sectionNo"));
			$('#courseYear2').val(this.getAttribute("courseYear2"));
			$('#semester').val(this.getAttribute("semester"));
			$('#roleName').val(this.getAttribute("roleName"));
			
			$('#statusApprove').val(aesUtil.encrypt(salt, four, passphrase, $(this).val())); 
			
			if($(this).val() == 'ACCPT')
			{
				
				$('#idComment').hide();
				$('#idCommentTxtArea').html('');
				$('#idApprovalMsg').html("<spring:message code='prop.dps.gradechange.approver.approve.text'/>");
				$('#linkSubmitApprove').addClass('btn-success').removeClass('btn-danger');
			}
			else
			{
				
				$('#idComment').show();
				$('#idCommentTxtArea').html('<textarea id="txtMessage" name="txtMessage" rows="" cols="" required></textarea>');
				$('#idApprovalMsg').html("<spring:message code='prop.dps.gradechange.approver.reject.text'/>");
				$('#linkSubmitApprove').addClass('btn-danger').removeClass('btn-success');
			}
			
			//idRadioBttn	=	$(this).attr('id');
			
	
		});

		
	/* Submit button of modal form to approve or reject */
		$(document).on("click", "#linkSubmitApprove", function(event){
			event.preventDefault();
			if ($('#formModalApprover').valid()) {
			var gradeChangeModel = {
					recordSequence	:	$('#recordSequence').val(),
					studentNo		:	$('#studentNo').val(),
					stdStatCode		:	$('#stdStatCode').val(), 
					roleName		:	$('#roleName').val(),
					sectCode		:	$('#sectcode').val(),
					courseCode		:	$('#courseCode').val(),
					lAbrCrsNo		:	$('#lAbrCourseNo2').val(),
					sectionNo		:	$('#sectionNo').val(),
					courseYear		:	$('#courseYear2').val(),
					semCode			:	$('#semester').val(),
					statusCode		:	$('#statusApprove').val(),
					comments		:	$('#txtMessage').val(),
					salt			:	salt,
					four			:	four
			};
			
			var roleType=$('#roleName').val();
			
			$('#modalApprovForm').modal('toggle');
			
			$.ajax({
				url			:	"${varResourceAjaxGradeChangeApproval}",
				type		:	'POST',
				cache		:	false,
				data		:	gradeChangeModel,
				success		:	function(data)
				{
							var	courseGrade	=	JSON.parse(data);
							var courseGradeJson = {'courseGrade':courseGrade, 'roleName': roleType};
							hbDataLoadAction(courseGradeJson, '#hbStudentGradesForApprove', '#divStudentGradesForApprove');
				}
			});
			
		}	
			
		})
		
	

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