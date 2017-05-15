<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceAjaxDropWithW" var="varResourceAjaxDropWithW">

</portlet:resourceURL>



<script type="text/javascript">
	/*Student*/
	$(function() {
	<c:if test="${not empty dropWDTOs}">		
				var courses = ${dropWDTOs};
				dropDataLoad(courses);
				
				$('.clsCourse').click(function(){
					$('#sectCode').val(this.getAttribute("sectCode"));
					$('#sectNo').val(this.getAttribute("sectionNo"));
					$('#courseNo').val(this.getAttribute("courseNo"));
					  var context={
							    "lAbrCourseNo": this.getAttribute("lAbrCourseNo"),
							    "courseName": this.getAttribute("courseName")
							  };
					var theAlertTemplate=$("#hbCourseData").html();
					var template = Handlebars.compile(theAlertTemplate);
					
					$('.content-placeholder').html(template(context));
				});
				
				
				/* Action performed by student on available records*/
				$('#bttnSubmitDrop').click(function(){
					
					$('#modalDropWForm').modal('toggle');
					
					var dropCourseModel = {
							courseNo : $('#courseNo').val(),
							sectCode : $('#sectCode').val(),
							sectNo : $('#sectNo').val()
					};
					
					$.ajax ({
							url : "${varResourceAjaxDropWithW}",
							type : 'POST',
							cache : false,
							data : dropCourseModel,
							success : function(data)
							{
	
								$('#status-'+dropCourseModel.sectCode).html('<span class="glyphicon glyphicon-ban-circle" ></span>');
								
								var courses	=	JSON.parse(data);
								
								dropDataLoad(courses);
								
							},
							error : function(xhr, status)
							{
								
							}
						
					});
					
				});
				
				/* Filling data using handlebar template*/
				function dropDataLoad(courses)
				{
					if ($.trim(courses))
					{
						var theAlertTemplate=$("#hbDropCourses").html();
						var template = Handlebars.compile(theAlertTemplate);
						$('#tblDropCourses').html(template(courses));
					}
					return true;
					
				}
		
	</c:if>	
		
	
	$(document).on("click", ".clsMsgErr", function(){
		var message = {};
		message.messageAlert = $(this).attr('msg');
		dropDataLoadActionStudent(message, '#hbDropStatAlert', '#divDropStatAlert');
		
	});
	
	function dropDataLoadActionStudent(dataJson, hbTemplateId, tableId)
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
	
	
	/*Approver*/
	$(function() {
		var varStudentNo;
		var	varStdStatCode;
		var	approver;
		var idRadioBttn;
		
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
				
				
				$("#tblApprover").hide();
				$('#tblApprover').parents('div.dataTables_wrapper').first().hide();
				
				$("#imgAjaxLoading").show();
				
				$.ajax({
						url		:	"${urlAjaxDropWDataByRole}",
						type	:	'POST',
						cache	:	false,
						data	:	roleNameValue,
						success	:	function(data)
						{
							$("#imgAjaxLoading").hide();
							var students=JSON.parse(data);
							dropDataLoad(students);
						},
						error	:	function(xhr, status)
						{
							$("#imgAjaxLoading").hide();
						}
				});
				
				
			});
		</c:forEach>
		
		
		$(document).on("click", ".clsStudentCourse", function(){
				var academicDetail = {
						studentNo : this.getAttribute("studentNo"),
						stdStatCode : this.getAttribute("stdStatCode")
				};
				varStudentNo	=	this.getAttribute("studentNo");
				varStdStatCode	=	this.getAttribute("stdStatCode");
				var studentId	=	this.getAttribute("studentId");
				var	studentName	=	this.getAttribute("studentName");
				
				
				approver 		= this.getAttribute("approver");
				$("#imgAjaxLoading").show();
				
				$.ajax({
						url 	:	"${urlAjaxCoursesToBeDropped}",
						type	:	'POST',
						cache	:	false,
						data	:	academicDetail,
						success	:	function(data)
						{
							console.log("data : "+data);
							$("#imgAjaxLoading").hide();
							var courses = JSON.parse(data);
								courses.approverMain=approver;
								courses.studentId=studentId;
								courses.studentName=studentName;
								data.approverMain=approver;
							if($.trim(courses))
							{
								
								dropDataLoadAction(courses, '#hbDropCoursesAction', '#dropwCoursesAction');
							}
							else
							{
								courses.approverMain=false;
								$('#modalAlertErrMsg').html("<spring:message code='prop.dps.dropw.warn.approver.no.courses.found'/>");
								$('#alertModal').modal('toggle');
								
								dropDataLoadAction(courses, '#hbDropCoursesAction', '#dropwCoursesAction');
							}
						},
						error	:	function(xhr, status)
						{
							$("#imgAjaxLoading").hide();
							dropDataLoadAction({}, '#hbDropCoursesAction', '#dropwCoursesAction');
						}
				});
			});
		
		/* click event on approve/reject radio button */		
		$(document).on("click", ".clsAppAction", function(event){
			event.preventDefault();
			
			//$('#modalApprovForm').modal('toggle');
			
			$('#studentNo').val(varStudentNo);
			$('#studentStatCode').val(varStdStatCode);
			$('#courseNo').val(this.getAttribute("courseNo"));
			$('#lAbrCourseNo').val(this.getAttribute("lAbrCourseNo"));
			$('#sectionNo').val(this.getAttribute("sectionNo"));
			$('#sectCode').val(this.getAttribute("sectCode"));
			$('#statusApprove').val($(this).val());
			
			if($(this).val() == 'ACCPT')
			{
				$('#idComment').hide();
				$('#idCommentTxtArea').html('');
				$('#idApprovalMsg').html("<spring:message code='prop.dps.dropw.approver.approve.text'/>");
				$('#linkSubmitApprove').addClass('btn-success').removeClass('btn-danger');
			}
			else
			{
				$('#idComment').show();
				$('#idCommentTxtArea').html('<textarea id="txtMessage" name="txtMessage" rows="" cols="" required></textarea>');
				$('#idApprovalMsg').html("<spring:message code='prop.dps.dropw.approver.reject.text'/>");
				$('#linkSubmitApprove').addClass('btn-danger').removeClass('btn-success');
			}
			
			//idRadioBttn	=	$(this).attr('id');
			
	
		});
		
		/* click event on submit button of modal-form from approver for approve/reject */
		$('#linkSubmitApprove').click(function(event){
			
			if ($('#formModalApprover').valid()) {
				
					$('#modalApprovForm').modal('toggle');
					var dropWDTO = {
							studentNo			:	varStudentNo,
							studentStatCode		:	varStdStatCode,
							courseNo			:	$('#courseNo').val(),
							lAbrCourseNo		:	$('#lAbrCourseNo').val(),
							sectionNo			:	$('#sectionNo').val(),
							sectCode			:	$('#sectCode').val(),
							statusApprove		:	$('#statusApprove').val(),
							remarks				:	$('#txtMessage').val()
					};
					
					
					
					$("#imgAjaxLoading").show();
					$.ajax({
								url 	:	 "${urlAjaxApproverAction}",
								type	:	'POST',
								data	:	dropWDTO,
								success	:	function(data)
								{
									$("#imgAjaxLoading").hide();
									var courses = JSON.parse(data);
									courses.approverMain=approver;
									dropDataLoadAction(courses, '#hbDropCoursesAction', '#dropwCoursesAction');
								},
								error	:	function(xhr, status, error)
								{
									$("#imgAjaxLoading").hide();
									//console.log("error : xhr.responseText : "+xhr.responseText+" -- status : "+status+ " == error :"+error);
									$("input:radio").attr("checked", false);
									
									$('#modalAlertErrMsg').html(xhr.responseText);
									$('#alertModal').modal('toggle');
									
								}
						
					});
			};
			
			
		});
		

		/* Click event on reset button */
		$('#linkBtnReset').click(function(){
			$("input:radio").attr("checked", false);
		});
		
		
		
		
		$("#idNav-home").click(function(){
			$(".clsNavRole").removeClass("active");
			$("#idNav-home").addClass("active");
			
			$("#tblApprover").hide();
			$('#tblApprover').parents('div.dataTables_wrapper').first().hide();
			
			
			$('#divAlertData').show();
			$('#divAlertData').html('<spring:message code="prop.dps.role.home"/>');
		});
		
		
		
		/* Filling data using handlebar template*/
		function dropDataLoad(courses)
		{
			if ($.trim(courses))
			{
				var theAlertTemplate=$("#hbDropCourses").html();
				var template = Handlebars.compile(theAlertTemplate);
				$('#dropwCourses').html(template(courses));
			}
			return true;
			
		}
		
		function dropDataLoadAction(dataJson, hbTemplateId, tableId)
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