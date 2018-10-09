<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<script type="text/javascript">
		$(function(){

			$('#formAlert').validate({
				rules : {
					txtComments	:	{
						required : true
					}
				},
				messages:
					{
					txtComments : '<spring:message code="error.dps.incomplete.grade.notify.validation.reason.empty" />'
					}
			});
			
			
			
			$('#formApprove').validate({
				rules : {
					txtMessage	:	{
						required : true
					}
				},
				messages:
					{
					txtMessage : '<spring:message code="error.dps.incomplete.grade.notify.validation.reason.empty" />'
					}
			});
			
		});
</script>