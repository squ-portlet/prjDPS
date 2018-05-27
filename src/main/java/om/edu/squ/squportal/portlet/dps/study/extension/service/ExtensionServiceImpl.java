/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 4.0.8 (Annotation) Portlet
 * 
 * File Name			:	ExtensionServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.service
 * Date of creation		:	Jan 16, 2017  9:48:21 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2017 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.squportal.portlet.dps.study.extension.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.notification.service.NotificationService;
import om.edu.squ.squportal.notification.service.core.NotificationServiceCore;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionReason;
import om.edu.squ.squportal.portlet.dps.study.extension.db.ExtensionDbDao;
import om.edu.squ.squportal.portlet.dps.study.extension.model.ExtensionStudentDataModel;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class ExtensionServiceImpl implements ExtensionServiceDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	ExtensionDbDao			extensionDbDao;
	@Autowired
	Rule					ruleService;
	@Autowired
	DPSNotification			dpsNotification;
	
	/**
	 * 
	 * method name  : getExtensionReasons
	 * @param locale
	 * @return
	 * ExtensionServiceImpl
	 * return type  : List<ExtensionReason>
	 * 
	 * purpose		: Get list of extensions
	 *
	 * Date    		:	Jan 16, 2017 4:55:44 PM
	 */
	public List<ExtensionReason>  getExtensionReasons(Locale locale)
	{
		return extensionDbDao.getExtensionReasons(locale);
	}
	
	
	/**
	 * 
	 * method name  : setExtensionByStudent
	 * @param student
	 * @param extensionStudentDataModel
	 * @param userName
	 * @param locale
	 * @return
	 * ExtensionServiceDao
	 * return type  : int
	 * 
	 * purpose		: Insert to extension as student
	 *
	 * Date    		:	Jul 17, 2017 12:53:06 PM
	 */
	public int setExtensionByStudent(Student student, ExtensionStudentDataModel extensionStudentDataModel, String userName, Locale locale)
	{
		int 				result 			= 	0;
		String 				approverRole	=	null;
		ExtensionDTO	extensionDTO	=	new ExtensionDTO(student, extensionStudentDataModel, userName);
		result	=	extensionDbDao.setExtensionByStudent(extensionDTO);

		
		if(result > 0)
		{
			
			if(dpsServiceDao.isSupervisorAvailable(student.getAcademicDetail().getStudentNo(), student.getAcademicDetail().getStdStatCode()))
			{
				approverRole	=	Constants.CONST_SQL_ROLE_NAME_SUPERVISOR;
			}
			else
			{
				approverRole	=	Constants.CONST_SQL_ROLE_NAME_ADVISOR;
			}
			
				/* -- Notification -- Start --*/
				try
				{
					NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																						extensionDTO.getStudentNo(), 
																						student.getAcademicDetail().getStdStatCode(), 
																						Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY, 
																						approverRole, 
																						false, locale
																					);
		
					notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.extension", null));
					notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.extension", null, new Locale("ar")));
					notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.extension", null));
					
					dpsNotification.sendNotification(
															UtilProperty.getMessage("prop.dps.extension.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
														, 	notifierPeople
														, 	"null"
														, 	Constants.CONST_TEST_ENVIRONMENT
													);
				}
				catch (NotCorrectDBRecordException ex)
				{
		
					logger.error("Error in Notification : "+ex.getMessage());
				}
				
				catch (Exception ex)
				{
					logger.error("Error in  notification for student submit at Extension of Service : {}",ex.getMessage());
				}
				/* -- Notification -- end --*/
		}
		
		
		return result;
		
		
	}


	/**
	 * 
	 * method name  : getExtensionsForStudents
	 * @param studentNo
	 * @param studentStatCode 
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 7, 2017 3:51:38 PM
	 */
	public List<ExtensionDTO> getExtensionsForStudents(String studentNo, String studentStatCode, Locale locale)
	{
		return extensionDbDao.getExtensionsForStudents(studentNo, studentStatCode, locale);
	}


	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		: Get list of students for approvers
	 *
	 * Date    		:	Feb 15, 2017 10:09:55 PM
	 * Date (Modification) : 10-May-2018 - Delegation applied
	 * @throws ExceptionEmptyResultset 
	 */
	public List<ExtensionDTO> getExtensionsForApprovers(String roleType, Employee employee, Locale locale) throws ExceptionEmptyResultset
	{
		List<ExtensionDTO>	resultList	=	null;
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		

		/* Delegation considered*/
		if(null == employee.getEmpNumberDelegated())
		{
			resultList	=	extensionDbDao.getExtensionsForApprovers(roleType, employee, locale, null, false);
			return resultList;
		}
		else
		{
			List<ExtensionDTO>	listResultForDelegated	=	null;
			List<ExtensionDTO>	listResultForDelegatee	=	null;
			
			
			Employee			delegatedEmployee 		= 	dpsServiceDao.getEmployee(employee.getEmpNumberDelegated(), employee.getUserNameDelegated(), locale, false);
			
								if(delegatedEmployee.getEmpNumber().substring(0,1).equals("e"))
								{
									delegatedEmployee.setEmpNumber(delegatedEmployee.getEmpNumber().substring(1));
								}
								listResultForDelegated	=	extensionDbDao.getExtensionsForApprovers(roleType, delegatedEmployee, locale, null, false);
			
								
			Employee			delegateeEmployee		=	dpsServiceDao.getEmployee(employee.getEmpNumberDelegatee(), employee.getUserNameDelegatee(), locale, false);
			
								if(delegateeEmployee.getEmpNumber().substring(0,1).equals("e"))
								{
									delegateeEmployee.setEmpNumber(delegateeEmployee.getEmpNumber().substring(1));
								}
								listResultForDelegatee	= extensionDbDao.getExtensionsForApprovers(roleType, delegateeEmployee, locale, null, true);
								
								listResultForDelegated.addAll(listResultForDelegatee);
			return listResultForDelegated;
			
		}
		
	}

	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param studentNo
	 * @param locale
	 * @return
	 * ExtensionServiceImpl
	 * return type  : ExtensionDTO
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 4, 2017 1:00:05 AM
	 * @throws ExceptionEmptyResultset 
	 */
	private ExtensionDTO getExtensionsForApprovers(String roleType, Employee employee, String studentNo,Locale locale) throws ExceptionEmptyResultset
	{
		ExtensionDTO	resultBo	=	null;
		
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		resultBo	=	extensionDbDao.getExtensionsForApprovers(roleType, employee, locale, studentNo, false).get(0);
		
		if(null == employee.getEmpNumberDelegated())
		{
			return resultBo;
		}
		else
		{
			ExtensionDTO		resultForDelegated	=	null;
			Employee			delegatedEmployee 	= 	dpsServiceDao.getEmployee(employee.getEmpNumberDelegated(), employee.getUserName(), locale, false);
								resultForDelegated	=	extensionDbDao.getExtensionsForApprovers(roleType, delegatedEmployee, locale, studentNo, false).get(0);
			return resultForDelegated;
			
		}

	}
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param employee
	 * @param extensionDTOTr
	 * @return
	 * ExtensionServiceImpl
	 * return type  : int
	 * 
	 * purpose		: add record for approval / add record in approval transaction table
	 * Note			: This function relates with two different transactional statements
	 *
	 * Date    		:	Feb 28, 2017 11:32:46 AM
	 * @throws ExceptionEmptyResultset 
	 * @throws Exception 
	 */
	public ExtensionDTO setRoleTransaction(ExtensionDTO extensionDTOTr, Employee employee, Locale locale) throws ExceptionEmptyResultset 
	{
		int 					resultTr			=	0;		
		ExtensionDTO			extensionDTOStudent	=	new ExtensionDTO();
		ExtensionDTO			extensionDTOResult	=	null;
		ApprovalTransactionDTO	transactionDTO		=	new ApprovalTransactionDTO();
		
		transactionDTO.setStudentNo(extensionDTOTr.getStudentNo());
		transactionDTO.setStdStatCode(extensionDTOTr.getStdStatCode());
		transactionDTO.setAppEmpNo(employee.getEmpNumber());
		transactionDTO.setAppEmpName(employee.getUserName());
		transactionDTO.setComments(extensionDTOTr.getCommentEng());
		transactionDTO.setRequestCode(Constants.CONST_REQUEST_CODE_DEFAULT);
		
		
		ApprovalDTO	approvalDTO				= 	dpsServiceDao.setRoleTransaction(
																						transactionDTO
																					, 	Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY
																					, 	extensionDTOTr.getRoleName()
																					, 	extensionDTOTr.getStatusCodeName()
																				);

		if(extensionDTOTr.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
		{
			extensionDTOStudent.setStatusCodeName(extensionDTOTr.getStatusCodeName());
		}
		else
		{
			if(approvalDTO.getApprovalSequenceNo()==approvalDTO.getApprovalMaxSequenceNo())
			{
				extensionDTOStudent.setStatusCodeName(extensionDTOTr.getStatusCodeName());
			}
			else
			{
				extensionDTOStudent.setStatusCodeName(Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
			}
		}
		
		extensionDTOStudent.setStudentNo(extensionDTOTr.getStudentNo());
		extensionDTOStudent.setStdStatCode(extensionDTOTr.getStdStatCode());
		extensionDTOStudent.setUserName(employee.getUserName());
		extensionDTOStudent.setCommentEng(extensionDTOTr.getCommentEng());
		
		resultTr			=	extensionDbDao.setExtensionStatusOfStudent(extensionDTOStudent);
		try
		{
			if(resultTr>0)
							{
								extensionDTOResult	=	getExtensionsForApprovers(extensionDTOTr.getRoleName(),employee,extensionDTOTr.getStudentNo(),locale);
								/* -- Notification -- Start --*/

									NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																										extensionDTOTr.getStudentNo(), 
																										extensionDTOStudent.getStdStatCode(), 
																										Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY, 
																										extensionDTOTr.getRoleName(), 
																										true, locale
																									);
									notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.extension", null));
									notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.extension", null, new Locale("ar")));
									notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.extension", null));
									
									dpsNotification.sendNotification(
																			UtilProperty.getMessage("prop.dps.extension.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
																		, 	notifierPeople
																		, 	"null"
																		, 	Constants.CONST_TEST_ENVIRONMENT
																	);								
	
								/* -- Notification -- end --*/
							}
		}
		catch (NotCorrectDBRecordException ex)
		{
			logger.error("Error in Notification : "+ex.getMessage());
		}
		catch(NotificationException exNotification)
		{
			logger.error("Error in  notification for approving at Extension of Service 1 : {}",exNotification.getMessage());
		}
		
		
		
		return extensionDTOResult;
	}
	
	/**
	 * 
	 * method name  : isRuleStudentComplete
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * ExtensionServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rules of extension service for students
	 *
	 * Date    		:	Mar 13, 2017 8:58:51 PM
	 */
	/*Rule 1 -- Student need to be in last semester */
	/*Rule 2 -- first seminar completed if program option reqire thesis / If candidate doesn't have thesis then approver will be advisor*/ 
	/*Rule 3 -- Starting from week 10 */
	/*Rule 4 -- Student can apply only once for extension */
	public boolean isRuleStudentComplete(String studentNo, String stdStatCode)
	{
		boolean	result 								= 	false;

		boolean hasThesis 							= 	false;
		boolean	isLastSemester 						=	false;
		boolean isFirstSeminarCompletedApplicable	=	false;
		boolean	isWeekSpecifiedAvailable			=	false;
		boolean	isAlreadyExtensionApproved			=	false;
		
		hasThesis	=	ruleService.isStudentHasThesis(studentNo, stdStatCode);
		
		/*Rule 1*/
		isLastSemester	= ruleService.lastSemester(studentNo, stdStatCode);
		
		
		/*Rule 2*/
		if(hasThesis)
		{
			isFirstSeminarCompletedApplicable	=	ruleService.isSemesterCompleted(studentNo, stdStatCode, Constants.CONST_THESIS_SEMINAR_SEMINAR_01);
		}
		
		
		/*Rule 3*/
		isWeekSpecifiedAvailable	=	ruleService.isCurrentDateInSpecificWeek(Constants.CONST_WEEK_10);
		
		/*Rule 4  */
		isAlreadyExtensionApproved				=	ruleService.isExtensionRecordAlreadyExist(studentNo, stdStatCode);
		
		if(!isAlreadyExtensionApproved)
		{

			if(hasThesis)
			{
				
				/* Applicable to student with thesis */
				if(isLastSemester & isWeekSpecifiedAvailable & isFirstSeminarCompletedApplicable)
				{
					result = true;
				}
			}
			/* Applicable to student without thesis*/
			else if(isLastSemester & isWeekSpecifiedAvailable)
			{
				result = true;
			}
		}
		
		return result;
	}
	
}
