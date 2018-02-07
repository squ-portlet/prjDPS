<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:resourceURL id="resourceStudentReasons" var="varResourceStudentReasons"></portlet:resourceURL>

<script type="text/javascript">

	$(document).ajaxStart(function(){
	    $('#divImgAjaxLoading').show();
	});

	$(document).ajaxStop(function(){
	    $('#divImgAjaxLoading').hide();
	});


	$(function(){
		console.log('inside on body load');
		var testData  	= {test : ''}; 
		$.ajax({
				url 	: 	"${varResourceStudentReasons}",
				type	:	'POST',
				cache	:	false,
				data	:	testData,
				success	:	function(data)
				{
					var reasons	=	JSON.parse(data);
					dataLoad(reasons, '#hbStudentWelcome', '#divStudentWelcome');
				},
				error	:	function(xhr, status, error)
				{

				}
		});

		
		
		
		

		
/* Handlebar data load */		
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