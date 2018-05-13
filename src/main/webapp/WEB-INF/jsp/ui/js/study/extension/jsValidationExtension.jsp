<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<script type="text/javascript">
	$(function(){

		//extensionStudentDataModel
		

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
				txtMessage: '<spring:message code="prop.dps.extension.error.approver.comment.required"/>'
			}

	});

		
		/************************************************** jqueryvalidation for New Request screen *******************************************/	
		$( "#extensionStudentDataModel" ).validate({
			  rules: {
				  yearSem: {
			      required: true
			    },
			    reasonCode: {
				      required: true
				    },
			    reasonOther: {
				      required: "#reasonCode:filled"
				}

			  },
			  errorPlacement: function(error, element) {

					  error.insertAfter(element);

			  },
			  messages: {
				  yearSem: '<spring:message code="prop.dps.extension.error.student.apply.form.yearSem"/>',
				  reasonCode: '<spring:message code="prop.dps.extension.error.student.apply.form.reasonCode"/>',
				  reasonOther: '<spring:message code="prop.dps.extension.error.student.apply.form.reasonOther"/>'
				  
			  }
			});

		
		
	});
</script>