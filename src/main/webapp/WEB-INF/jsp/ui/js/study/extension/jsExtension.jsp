<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">
	$(function(){
	
		var oTable;
		$("#reasonCode").change(function(){

			if($("#reasonCode").val()=='5301')
			{
				$("#divExtReasonOther").show();
				$("#divExtReasonOther").show();
			}
			else
			{
				$("#divExtReasonOther").hide();
				$("#divExtReasonOther").hide();
			}
			
	});
		
		
		<c:forEach items="${employee.myRoles}" var="myRole">
		$("#role-${myRole.roleName}").click(function(){
			$(".clsExtNavRole").removeClass("active");
			$("#idExtNav-${myRole.roleName}").addClass("active");
			var roleNameValue = {
					roleName:'testRole',
					roleValue:'${myRole.roleName}'
			};
			$("#divAlertData").hide();
			
			$("#tblExtension").hide();
			$('#tblExtension').parents('div.dataTables_wrapper').first().hide();
			
			$("#imgAjaxLoading").show();
			$.ajax({
				url:  "${urlAjaxStudentExtensionDataByRole}",
				type:'POST',
				cache:false,
				data:roleNameValue,
				success:function(data)
				{
					$("#imgAjaxLoading").hide();
					var jsonReqBO=JSON.parse(data);
					if($.trim(jsonReqBO))
					{
						loadMytable(jsonReqBO);
					}
					else
					{
						hideMytable();
					}
				},
				error:function(xhr, status)
				{
					$("#imgAjaxLoading").hide();
					$('#divAlertData').show();
					$('#divAlertData').html('<spring:message code="prop.dps.role.no.records.error"/>');
					
				}
			});

				function loadMytable(data)
				{
						$("#tblExtension").show();
						
						 oTable=$('#tblExtension').DataTable( {
							"aaData" : data,
							"aoColumns" : 
								[
									{ "mData": "studentId" },
									{ "mData": "studentName" },
									{ "mData": "cohort" },
									{ "mData": "collegeName" },
									{ "mData": "degreeName" },
									{ "mData": "roleStatusSupervisor" },
									{ "mData": "roleStatusCollegeDean" },
									{ "mData": "roleStatusDpsDean" },
									{ "mData": "approver",
										"render": function(data, type, full, meta) {
											if(data){
												return ' <div class="col-xs-10"><div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio1" value="A"><spring:message code="prop.dps.role.approve.text"/></label> </div>  \
																				<div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio2" value="R"> <spring:message code="prop.dps.role.reject.text"/> </label></div> </div> ';
													}
											else
											{
													 return '';
											}
							            }									
									}
								 ],
							"iDisplayLength": 10,
							destroy: true,
							"bJQueryUI": true
							});
				}
				
				function hideMytable()
				{
					$('#divAlertData').show();
					$('#divAlertData').html('<spring:message code="prop.dps.role.no.records"/>');
					$("#tblExtension").hide();
					$('#tblExtension').parents('div.dataTables_wrapper').first().hide();
				}

		});	
		</c:forEach>
		
		$("#idExtNav-home").click(function(){
			$(".clsExtNavRole").removeClass("active");
			$("#idExtNav-home").addClass("active");
			
			$("#tblExtension").hide();
			$('#tblExtension').parents('div.dataTables_wrapper').first().hide();
			
			
			$('#divAlertData').show();
			$('#divAlertData').html('<spring:message code="prop.dps.role.home"/>');
		});
		
		

		
		$("#tblExtension").on('click', '.clsAppAction', function() {
		    //ar ID = $(this).closest('tr').find('td').eq(0).text();
		   
		    $(this).prop("checked", true);
		    if($(this).val()=='A')
		    {
		    	<spring:message code="prop.dps.role.approve.text" var="txtRole"/>
		    	$('.modal-body').html('<spring:message code="prop.dps.extension.approver.modal.body.confirmation.text" arguments="${txtRole}"/>');
		    }
		    else
		    {
		    	<spring:message code="prop.dps.role.reject.text" var="txtRole"/>
		    	$('.modal-body').html('<spring:message code="prop.dps.extension.approver.modal.body.confirmation.text" arguments="${txtRole}"/>');
		    }
		    
		    var tdata=oTable;
		    var tableData = tdata.table( this.parentNode.parentNode );
			var rowData =	tdata.table(0).row( this ).data(); 
		    
			
		    $('#modalApprovForm').modal({
				  keyboard: false
			});
		    
		    $('#linkSubmitApprove').click(function(event) {
				alert("submit button clicked");	
		    });
		    //alert(ID);
		});
		
		
		
	});

	$(function(){
		
		
		
	});
	

</script>