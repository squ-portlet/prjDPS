<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<script type="text/javascript">
	$(function(){

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
				txtMessage: '<spring:message code="prop.dps.postpone.error.approver.comment.required"/>'
			}

		});
		
		/*
			If other reason selected, student must provide the reason
		*/	
		
		$('#postponeStudentDataModel').validate({
			rules: {
				yearSem : {
					required : true
				},
				reasonCode : {
						required : true
					},
				reasonOther: {
					required : "#reasonCode:filled"
				}
			},
			messages:
			{
				yearSem: '<spring:message code="error.dps.postpone.student.semester.empty"/>',
				reasonCode: '<spring:message code="error.dps.postpone.student.reason.empty"/>',
				reasonOther: '<spring:message code="error.dps.postpone.student.other.reason.empty"/>'
			}
		});
		
		
	function validatePostponeStudentDataModel ()	{	
		$('#postponeStudentDataModel').validate({
			rules: {
				yearSem : {
					required : true
				},
				reasonCode : {
					required : true
				},
				reasonOther: {
					required : "#reasonCode:filled"
				}
			},
			messages:
			{
				yearSem: '<spring:message code="error.dps.postpone.student.semester.empty"/>',
				reasonCode: '<spring:message code="error.dps.postpone.student.reason.empty"/>',
				reasonOther: '<spring:message code="error.dps.postpone.student.other.reason.empty"/>'
			}
		});
		
	}
		
	});
</script>