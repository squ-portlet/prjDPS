<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentList" var="varResourceStudentList"/>
<portlet:resourceURL id="resourceAjaxNotify" var="varResourceAjaxNotify"/>
<portlet:resourceURL id="resourceHistory" var="varResourceHistory"/>
<portlet:resourceURL id="resoureAjaxStudentDataForApproversByRole" var="varAjaxStudentDataForApproversByRole"/>
<portlet:resourceURL id="resourceAjaxCourseListForNotify" var="varAjaxCourseListForNotify"/>
<portlet:resourceURL id="resourceIncompleteGradeNotificationApproval" var="varIncompleteGradeNotificationApproval"/>

<script type="text/javascript">

	$( document ).ajaxStart(function() {
		$('#imgAjaxLoading').show();
	});
	
	$( document ).ajaxStop(function() {
		$('#imgAjaxLoading').hide();
	});
	
	$(function(){
		/* Datatable for students */
		var tablStudentList;
		var tablApprover;
		var tablStudentNotificationDetailsForApprove;
		
		var	rowRApprover;
		var rowDataApprover;

/* -- Instructor part ***/
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
				$('#divStudentList').html('');
				$('#divStudentsListForApprovers').html('');
				
				
				$.ajax({
					url		:	"${varAjaxStudentDataForApproversByRole}",
					type	: 	"POST",
					cache	: 	false,
					data	: 	roleNameValue,
					success : 	function(data)
					{
						var students=JSON.parse(data);
						if($.trim(students))
						{
						var studentsJson={'students':students,'roleType':'${myRole.roleName}'};
						hbDataLoadAction(studentsJson, '#hbStudentsListForApprovers', '#divStudentsListForApprovers');
						}
						
						tablApprover = $('#tblApprover').DataTable({
							"order": [],
							 select: true,
							 "sDom":  '<f><t><"col-sm-5"i><"col-sm-12"p><"clearfix">',
							 columns: [
					                     { "data": "roleType" },
					                     { "data": "studentNo" },
			                             { "data": "stdStatCode"},
			                             { "data": "stdId" },
			                             { "data": "id" },
			                             { "data": "studentName" },
			                             { "data" : "cohort"},
			                             { "data" : "college"},
			                             { "data" : "degree"}
			                           ],
                           columnDefs: [
							               {
							                   "targets": [ 0 ],
							                   "visible": false
							               },

							               {
							                   "targets": [ 1 ],
							                   "visible": false
							               },
							               
							               {
							                   "targets": [ 2 ],
							                   "visible": false
							               },
							               {
							                   "targets": [ 3 ],
							                   "visible": false
							               }							               
							              ]
						 });
						
					},
					error	:	function(xhr, status)
					{
						
					}
					
				});
				
			});
		</c:forEach>
		
		
		
		
		$(document).on("click", ".clsLinkCourseNo", function(event){
			event.preventDefault();
			var courseModel	=	{
					lAbrCourseNo	:	this.getAttribute("lAbrCourseNo"),
					sectionNo		:	this.getAttribute("sectionNo"),

			};
			
			var lAbrCourseNo	=	this.getAttribute("lAbrCourseNo");
			var	courseNo		=	this.getAttribute("courseNo");
			var sectionNo		=	this.getAttribute("sectionNo");
			var sectCode		=	this.getAttribute("sectCode");
			var courseYear		=	this.getAttribute("courseYear");
			var semester		=	this.getAttribute("semester");
			
				
			
			$.ajax({
					url		:	"${varResourceStudentList}",
					data	:	courseModel,
					cache	: false,
					type	: 'POST',
					success	: function(data)
					{
						var students	=	JSON.parse(data); 
						var studentsJson = {'students':students, 'lAbrCourseNo':lAbrCourseNo, 'courseNo' : courseNo,  'sectionNo':sectionNo, 'sectCode':sectCode, 'courseYear':courseYear,'semester':semester };
						 hbDataLoadAction(studentsJson, '#hbStudentList', '#divStudentList');
						 
						 tablStudentList = $('#tblStudentList').DataTable({
							 select: true,
							 "order": [],
							 "sDom":  '<f><t><"col-sm-5"i><"col-sm-12"p><"clearfix">',
							 "columnDefs": [
								               {
								                   "targets": [ 0 ],
								                   "visible": false
								               },

								               {
								                   "targets": [ 1 ],
								                   "visible": false
								               },
								               
								               {
								                   "targets": [ 2 ],
								                   "visible": false
								               },
								               {
								                   "targets": [ 3 ],
								                   "visible": false
								               },
								               {
								                   "targets": [ 4 ],
								                   "visible": false
								               },
								               {
								                   "targets": [ 5 ],
								                   "visible": false
								               },

								               {
								                   "targets": [ 6 ],
								                   "visible": false
								               },							               
								               {
								                   "targets": [ 7 ],
								                   "visible": false
								               },							               
								               {
								                   "targets": [ 8 ],
								                   "visible": false
								               }								               
								               /*								               
								               ,{ "name": "studentNo",   "targets": 0 },
								               { "name": "stdStatCode",  "targets": 1 },
								               { "name": "courseYear", "targets": 2 },
								               { "name": "semester",  "targets": 3 },
								               { "name": "sectCode",    "targets": 4 }
*/								               								               
							               ],
							               columns: [
							                     { "data": "sequenceNum" },
							                     { "data": "studentNo" },
					                             { "data": "stdStatCode"},
					                             { "data": "courseYear" },
					                             { "data": "semester" },
					                             { "data": "sectCode" },
					                             { "data": "lAbrCourseNo"},
					                             { "data": "courseNo"},
					                             { "data": "sectionNo"},
					                             { "data": "id"},
					                             { "data": "name"},
					                             { "data": "grade"},
					                             { "data": "action"}
							                   
							               ]
						 
							 
						 });
					},
					error	: function(xhr, status,  error)
					{
						
					}
			});
			
		});
		
		/* onClick notify link */
		$(document).on('click', '.clsLinkStudentNo', function(){	
			$('#txtComments').val('');
			$('#alertModal').modal('toggle');

		});
		
		
		/* onClick the 'Yes'/Submit button of the modal form for notify */
				$(document).on("click", "#btnSubmitNotification", function(event){	
					
					$('#alertModal').modal('toggle');
					
					var row  = $(this).parents('tr')[0];	
					var rowData	=	tablStudentList.row($(this).parents('tr')[0]).data();
					// var rowData = tablStudentList.row($(this).closest('tr')[0]).data();   // changing parents to closest also works
					
					var incompleteGradeNotifyModel = {
							studentNo 		:	rowData.studentNo,
							stdStatCode		:	rowData.stdStatCode,
							courseYear		:	rowData.courseYear,
							semester		:	rowData.semester,
							sectCode		:	rowData.sectCode,
							lAbrCourseNo	:	rowData.lAbrCourseNo,
							courseNo		:	rowData.courseNo,
							sectionNo		:	rowData.sectionNo,
							comment			:  $('#txtComments').val(),
							salt			:	salt,
							four			:	four
					};
					
		
					$.ajax({
								url		: 	'${varResourceAjaxNotify}',
								type	:	'POST',
								cache	:	false,
								data	:	incompleteGradeNotifyModel,
								success	:	function(data)
								{
											var seqNo				=	JSON.parse(data);
											var cellDataAction 		= 	'<span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>';
												rowData.sequenceNum	=	seqNo;
												rowData.id 			= 	'<a class="clsNotifyHistory" href="#">'+rowData.id+'</a>';
												rowData.action		=	cellDataAction;
		
												tablStudentList
														        .row( row)
														        .data( rowData )
														        .draw();
										
								},
								error	:  function(xhr, status,  error)
								{
									
								}
									
					});
					
					
		
				});

/* Approver - part */				
				
		/* Upon click of NotifyHistory by Instructor */		
				$(document).on("click", ".clsNotifyHistory", function(event){
					var row  = $(this).parents('tr')[0];	
					var rowData	=	tablStudentList.row($(this).parents('tr')[0]).data();
					
					var incompleteGradeNotifyModel = {
							recordSequence 		:	rowData.sequenceNum
					};
					
					$.ajax({
							url		:	'${varResourceHistory}',
							type	:	'GET',
							cache	:	false,
							data	:	incompleteGradeNotifyModel,
							success	:	function(data)
							{
								var incompleteNotifyHistory = JSON.parse(data);
								//$('#divIncompleteGradeNotifyHistory').html('');
								 hbDataLoadAction(incompleteNotifyHistory, '#hbIncompleteGradeNotifyHistory', '#divIncompleteGradeNotifyHistory');
							},
							error	:	function(xhr, status,  error)
							{
								
							}
					});
					
					
				});
		
		/* Upon clicking particular student number to get notification details*/
				$(document).on("click", ".clsLinkStudentWithNotification", function(event){	
					rowRApprover  = $(this).parents('tr')[0];	
					rowDataApprover	=	tablApprover.row(rowRApprover).data();
					
					var incompleteGradeNotifyModel = {
							studentNo 		:	rowDataApprover.studentNo,
							stdStatCode		:	rowDataApprover.stdStatCode,
							roleName		:	rowDataApprover.roleType,
							salt			:	salt,
							four			:	four
					}
					var roleType	=	rowDataApprover.roleType;
					var studentId	=	rowDataApprover.stdId;
					var studentName	=	rowDataApprover.studentName;
					
					$.ajax({
								url 	:	'${varAjaxCourseListForNotify}',
								type	:	'GET',
								cache	:	false,
								data	:	incompleteGradeNotifyModel,
								success	:	function(data)
								{
									var notifyList =	JSON.parse(data);
									var	notifyListJSON = {'notifyList':notifyList, 'roleName':roleType, 'studentId':studentId,'studentName':studentName};
									hbDataLoadAction(notifyListJSON, '#hbStudentNotificationDetailsForApprove', '#divStudentNotificationDetailsForApprove');
									tablStudentNotificationDetailsForApprove = $('#tblStudentNotificationDetailsForApprove').DataTable({
														 select: true,
														 "order": [],
														 "sDom":  '',
														 "columnDefs": [ 
															               {
															                   "targets": [ 0 ],
															                   "visible": false
															               },
															               {
															                   "targets": [ 1 ],
															                   "visible": false
															               },
															               
															               {
															                   "targets": [ 2 ],
															                   "visible": false
															               },
															               {
															                   "targets": [ 3 ],
															                   "visible": false
															               },
															               {
															                   "targets": [ 4 ],
															                   "visible": false
															               },
															               {
															                   "targets": [ 5 ],
															                   "visible": false
															               },
			
															               {
															                   "targets": [ 6 ],
															                   "visible": false
															               },							               
															               {
															                   "targets": [ 7 ],
															                   "visible": false
															               },
															               {
															                   "targets": [ 16 ],
															                   "visible": false
															               }
															       ],
														 columns: [
															 			{ "data": "recno" },
															 			{ "data": "studentNo" },
															 			{ "data": "stdStatCode" },
															 			{ "data": "sectCode" },
															 			{ "data": "courseNo" },
															 			{ "data": "courseYear" },
															 			{ "data": "semester" },
															 			{ "data": "roleName" },
															 			
															 			{ "data": "recno2"},
															 			{ "data": "lAbrCourseNo"},
															 			{ "data": "sectionNo"},
															 			{ "data": "statusDesc"},
															 			{ "data": "hod"},
															 			{ "data": "asstDean"},
															 			{ "data": "dpsDean"},
															 			{ "data": "action"},
															 			{ "data": "actionResult"}
															 		]
														});

								},
								error	:	function(xhr, status,  error)
								{

								}
								
								
					
						});
					
					
					
			});	

	/* click event on approve/reject radio button */		
			$(document).on("click", ".clsAppAction", function(event){	
				event.preventDefault();
				var row  = $(this).parents('tr')[0];	
				var rowData	=	tablStudentNotificationDetailsForApprove.row(row).data();
				rowData.actionResult=aesUtil.encrypt(salt, four, passphrase, $(this).val());

				tablStudentNotificationDetailsForApprove
													        .row( row)
													        .data( rowData )
													        .draw();
															
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
			});
				

	/* Submit button of modal form to approve or reject */			
			$(document).on("click", "#linkSubmitApprove", function(event){	
				$('#modalApprovForm').modal('toggle');
				
				var row  = $(this).parents('tr')[0];	
				var rowData	=	tablStudentNotificationDetailsForApprove.row(row).data();
				
				var incompleteGradeNotifyModel = {
						recordSequence	:	rowData.recno,
						studentNo 		:	rowData.studentNo,
						stdStatCode		:	rowData.stdStatCode,
						courseYear		:	rowData.courseYear,
						semester		:	rowData.semester,
						sectCode		:	rowData.sectCode,
						lAbrCourseNo	:	aesUtil.encrypt(salt, four, passphrase, rowData.lAbrCourseNo),
						courseNo		:	rowData.courseNo,
						sectionNo		:	aesUtil.encrypt(salt, four, passphrase, rowData.sectionNo),
						roleName		:	rowData.roleName,
						lAbrStatusCode	:	rowData.actionResult,
						comment			:  $('#txtMessage').val(),
						salt			:	salt,
						four			:	four												
				}

				$.ajax({
						url 	:	"${varIncompleteGradeNotificationApproval}",
						type	:	'POST',
						cache	:	false,
						data	:	incompleteGradeNotifyModel,
						success	:	function(data)
						{
								var dto = JSON.parse(data);
								rowData.recno2=dto[0].recordSequence;
								rowData.statusDesc=dto[0].statusDesc;
								rowData.hod=dto[0].hod.roleStausIkon;
								rowData.asstDean=dto[0].dpsAsstDean.roleStausIkon;
								rowData.dpsDean=dto[0].dpsDean.roleStausIkon;
								rowData.action='';
								
								tablStudentNotificationDetailsForApprove
																	        .row( row)
																	        .data( rowData )
																	        .draw();
								
								rowDataApprover.id=rowDataApprover.stdId;
								tablApprover.row(rowRApprover).data(rowDataApprover).draw();
								
						},
						error	:	function(xhr, status,  error)
						{
							
						}
				
						
						
				});
				
				
			});

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