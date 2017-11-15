<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">

	$(function() {
		$('#tblGradeList').DataTable({
			
		});
		
		$('#tblGradeListApproval').DataTable({
			
		});
			var crStudentId =	aesUtil.encrypt(salt, four, passphrase, $('#studentId').val());
			
	});
</script>