<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentList" var="varResourceStudentList"/>

<script type="text/javascript">

	$( document ).ajaxStart(function() {
		$('#imgAjaxLoading').show();
	});
	
	$( document ).ajaxStop(function() {
		$('#imgAjaxLoading').hide();
	});
	
	$(function(){
		<c:forEach items="${employee.myRoles}" var="myRole">
		// Clicking on tabs to make it active (other than Home tab)
			$("#role-${myRole.roleName}").click(function(){
				$(".clsNavRole").removeClass("active");
				$("#idNav-${myRole.roleName}").addClass("active");
				
				
				var roleNameValue = {
						roleName:'testRole',
						roleValue:'${myRole.roleName}'
				};

				
				$.ajax({
					url		:	"${varResourceStudentList}",
					type	: 	"POST",
					cache	: 	false,
					data	: 	roleNameValue,
					success : 	function(data)
					{
						//TODO
						
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
						var studentsJson = {'students':students, 'lAbrCourseNo':lAbrCourseNo, 'sectionNo':sectionNo, 'sectCode':sectCode, 'courseYear':courseYear,'semester':semester };
						 hbDataLoadAction(studentsJson, '#hbStudentList', '#divStudentList');
						 var tablStudentList = $('#tblStudentList').DataTable({
							 select: true,
							 "order": [],
							 "sDom":  '<f><t><"col-sm-5"i><"col-sm-12"p><"clearfix">'
						 });
					},
					error	: function(xhr, status,  error)
					{
						
					}
			});
			
		});
		
		/* onClick notify link */
		$(document).on("click", ".clsLinkStudentNo", function(event){	
		
			var incompleteGradeNotifyModel = {
					studentNo 		:	this.getAttribute("studentNo"),
					stdStatCode		:	this.getAttribute("stdStatCode"),
					courseYear		:	this.getAttribute("courseYear"),
					semester		:	this.getAttribute("semester"),
					sectCode		:	this.getAttribute("sectCode"),
					lAbrCourseNo	:	this.getAttribute("lAbrCourseNo"),
					sectionNo		:	this.getAttribute("sectionNo")
			};
			
			//TODO - evoke a modal to confirm and submit
			
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