<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">
	$(function(){
	
		var oTable;
		var rowData;
		var varRoleName;
		var btnRadio;
		
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
			varRoleName	=	'${myRole.roleName}';
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
							rowId: 'studentId',
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
												return ' <div class="col-xs-10"><div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio1" value="${appApprove}" data-toggle="modal" data-target="#modalApprovForm"><spring:message code="prop.dps.role.approve.text"/></label> </div>  \
																				<div class="col-xs-2"><label><input type="radio" class ="clsAppAction" name="appAction" id="appRadio2" value="${appRecect}" data-toggle="modal" data-target="#modalApprovForm"> <spring:message code="prop.dps.role.reject.text"/> </label></div> </div> ';
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
		
		


		$("#tblExtension").on('click', '.clsAppAction', function(event) {
					event.preventDefault();
  					btnRadio = $(this);
				    $(this).prop("checked", true);
				    $('#txtModalAppFormStatus').val($(this).val());
				    if($(this).val()=='${appApprove}')
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
					rowData =	tdata.table(0).row( this ).data(); 
		    
		});
		
		
		//start
		
		
						    $('#linkSubmitApprove').click(function(event) {
				    	event.preventDefault();

				    	var extensionDTO	= {
								studentNo 		: rowData.studentNo,
								stdStatCode		: rowData.stdStatCode,
								statusCode		: $('#txtModalAppFormStatus').val(),
								roleName		: varRoleName
								
							};
						var requestSent = false;
						if(!requestSent) {
							requestSent = true;
								$.ajax({
										url:	"${urlAjaxExtensionDataApprove}",
										type:	'POST',
										cache:	false,
										data:	extensionDTO,
										success:function(data)
										{
											//alert("ajax success");
											$(btnRadio).prop("checked", true);
										},
										erorr:
											{
												//alert("ajax failure");
											},
										complete:function()
										{
											requestSent = false;
											
										}
										
									
								});
						}
						
						extensionDTO = null;
						
				    });
		
		
		
		//finish
		
		
		
	});

	$(function(){
		$("#modalApprovForm").on('hidden.bs.modal', function () {
		    $(this).data('bs.modal', null);
		});
		
		
	});
	

</script>