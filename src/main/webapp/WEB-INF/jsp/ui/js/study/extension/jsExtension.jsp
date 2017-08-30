<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<script type="text/javascript">
	$(function(){
		$('.clsMsgErr').click(function(){
			var messageAlert = $(this).attr('msg');
			var htmlMsg='\
						      <div class="alert alert-warning alert-dismissible" role="alert" id="msgAlert"> \
								  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> \
								 	<strong><spring:message code="prop.dps.extension.student.applications.head.column.action"/>!</strong>\
								  		<hr> \
						'+
							messageAlert
						 +'</div>';
							
						
			
			$('#idRowMsg').html(htmlMsg);
			$('#idRowMsg').addClass('container-fluid');
		});
		
	});
	$(function(){
	
		var oTable;
		var rowData;
		var rowId;
		var rowIndex;
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
							"pagingType": 'full_numbers',
							"aaData" : data,
							rowId: 'studentId',
							"aoColumns" : 
								[
									{ "mData": "studentId" },
									{ "mData": "studentName" },
									{ "mData": "cohort" },
									{ "mData": "collegeName" },
									{ "mData": "degreeName" },
									{ "mData": "advisor.roleStatus", 
										"render" : function(data, type, full, meta)	
										{
											return getStatusIcon(data);
										}
									},
									{ "mData": "supervisor.roleStatus", 
										"render" : function(data, type, full, meta)	
										{
											return getStatusIcon(data);
										}
									},
									{ "mData": "collegeDean.roleStatus" ,
										"render" : function(data, type, full, meta)	
										{
											return getStatusIcon(data);
										}	
									},
									{ "mData": "dpsDean.roleStatus",
										"render" : function(data, type, full, meta)	
										{
											return getStatusIcon(data);
										}	
									},
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
							"bJQueryUI": true,
							"sDom":  '<f><t><"col-sm-5"i><"col-sm-2"l><"clearfix"><"col-sm-10"p>', 
							"oLanguage": {
								  "sUrl": "${urlCdn}/DataTables/language/lang_${rc.locale.language}.txt"
								},
							"order": []							
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
				    	$('.modal-body').html('\
				    							<div col="col-sm-10"><spring:message code="prop.dps.extension.approver.modal.body.confirmation.text" arguments="${txtRole}"/></div> \
				    							<div col="clearfix"/>\
				    							<div col="col-sm-2"><spring:message code="prop.dps.extension.approver.modal.body.approve.comment.text"></spring:message></div> \
				    							<div col="col-sm-8"><textarea id="txtMessage" name="txtMessage" style="width: 90%;" required ></textarea></div> \
				    						');
				    }
				    
				    var tdata=oTable;
					rowData =	tdata.table(0).row( this ).data(); 
					rowIndex = tdata.row( this ).index();
		});
		
		
		//start

		
						    $('#linkSubmitApprove').click(function(event) {
						    	//event.preventDefault();
		
						    	if ($('#formModalApprover').valid()) {
									    	var extensionDTO	= {
													studentNo 		: rowData.studentNo,
													stdStatCode		: rowData.stdStatCode,
													statusCodeName	: $('#txtModalAppFormStatus').val(),
													roleName		: varRoleName,
													commentEng		: $('#txtMessage').val()
													
												};
									    	$('#modalApprovForm').modal('toggle');
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
																//$(btnRadio).prop("checked", true);
																var jsonReqBO=JSON.parse(data);
																rowData.approver='';
																rowData.advisor.roleStatus=jsonReqBO.advisor.roleStatus;
																rowData.supervisor.roleStatus=jsonReqBO.supervisor.roleStatus;
																rowData.collegeDean.roleStatus=jsonReqBO.collegeDean.roleStatus;
																rowData.dpsDean.roleStatus=jsonReqBO.dpsDean.roleStatus;
																oTable.row(rowIndex).data(rowData).draw();
															},
															erorr:
																{
			
																},
															complete:function()
															{
																requestSent = false;
																
															}
															
														
													});
											}
											
											extensionDTO = null;
				    	} 
				    });
		
		
		
		//finish
		
		

		
		function getStatusIcon(status)
		{
			if(status=='Y')
			{
				return '<font color="green"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></font>';
			}
			if(status=='N')
			{
				return '<font color="red"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></font>';
			}
			if(status=='NA')
			{
				return '<span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>';
			}
			if(status=='NU')
			{
				return '<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>';
			}
		}
		
		
		
	});

	$(function(){
		$("#modalApprovForm").on('hidden.bs.modal', function () {
		    $(this).data('bs.modal', null);
		});
		
		
	});
	

</script>