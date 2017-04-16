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
								console.log('success');
								$('#status-'+dropCourseModel.sectCode).html('<span class="glyphicon glyphicon-ban-circle" ></span>');
								
								var courses	=	JSON.parse(data);
								
								dropDataLoad(courses)
								
							},
							error : function(xhr, status)
							{
								console.log('error');
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
		
	});
	
	/*Approver*/
	$(function() {
		
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
				
			});
		</c:forEach>
		
		
		
		
		$("#idNav-home").click(function(){
			$(".clsNavRole").removeClass("active");
			$("#idNav-home").addClass("active");
			
			$("#tblApprover").hide();
			$('#tblApprover').parents('div.dataTables_wrapper').first().hide();
			
			
			$('#divAlertData').show();
			$('#divAlertData').html('<spring:message code="prop.dps.role.home"/>');
		});
		
		
		
	});
	
	
</script>