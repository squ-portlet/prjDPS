<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<script type="text/javascript">
	$(function(){
		$('#formGradeList').validate({
			rules: {
				selectGradeValNew:{
					required : true
				},
				txtMessage: {
					required : true
				}
				
			},
			messages:
			{
				selectGradeValNew: '<spring:message code="prop.dps.gradechange.error.new.grade.required"/>',
				txtMessage: '<spring:message code="prop.dps.gradechange.error.comment.required"/>'
					
			}

		});
		
		
		
		/*********
		* Approver should can not reject without specifying reasons
		*/
		$('#formModalApprover').validate({
			rules: {
				txtMessage: {
					required : true
				}
			},
			messages:
			{
				txtMessage: '<spring:message code="prop.dps.gradechange.error.comment.required"/>'
			}

		});

		
		
	});
</script>