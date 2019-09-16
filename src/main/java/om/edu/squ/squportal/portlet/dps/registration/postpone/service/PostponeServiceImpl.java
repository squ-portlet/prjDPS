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
 * File Name			:	PostponeServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.service
 * Date of creation		:	May 25, 2017  2:27:04 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.service;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionDropDownPeriod;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionExtensionExists;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeDTO;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;
import om.edu.squ.squportal.portlet.dps.registration.postpone.db.PostponeDBDao;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsStaff;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

/**
 * @author Bhabesh
 *
 */
public class PostponeServiceImpl implements PostponeService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	PostponeDBDao	postponeDBDao;
	@Autowired
	DPSNotification	dpsNotification;
	@Autowired
	Rule					ruleService;

	
	private	boolean		rulePostponeCountWithinLimit	=	false;
	
	private	boolean		dropWTimeApplied;


	/**
	 * 
	 * method name  : getPostponeReasons
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeReason>
	 * 
	 * purpose		: Get list of default reasons for postpone 
	 *
	 * Date    		:	May 25, 2017 4:15:05 PM
	 */
	public List<PostponeReason> getPostponeReasons(Locale locale)
	{
		return postponeDBDao.getPostponeReasons(locale);
	}
	
	/**
	 * 
	 * method name  : getExistingGrades
	 * @param studentNo
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<Course>
	 * 
	 * purpose		: Get existing grades
	 *
	 * Date    		:	Dec 25, 2017 10:44:04 PM
	 */
	public List<Course> getExistingGrades(String studentNo, Locale locale)
	{
		return postponeDBDao.getExistingGrades(studentNo, locale);
	}
	
	/**
	 * 
	 * method name  : setPostponeByStudent
	 * @param student 
	 * @param studentModel
	 * @param userName
	 * @param locale 
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert to postpone as student
	 *
	 * Date    		:	Aug 7, 2017 5:00:53 PM
	 * @throws ExceptionExtensionExists 
	 */
	public List<PostponeDTO> setPostponeByStudent(Student student, PostponeStudentModel studentModel, String userName, Locale locale) throws ExceptionDropDownPeriod, ExceptionExtensionExists
	{
		int 				result			=	0;
		List<PostponeDTO>	postponeDTOs	=	null;
		String 				approverRole	=	null;
		String				courseYear		=	null;
		String				semester		=	null;
		String				stdStatCode		=	student.getAcademicDetail().getStdStatCode();
		
		isRuleComplete( student.getAcademicDetail().getStudentNo(), student.getAcademicDetail().getStdStatCode());
		
		
		if(null != studentModel.getYearSem() && ! studentModel.getYearSem().trim().equals(""))
		{
			courseYear		=	studentModel.getYearSem().split("-")[0];
			semester		=	studentModel.getYearSem().split("-")[1];

			if( dpsServiceDao.isSemesterExtended(stdStatCode, courseYear, semester))
			{
				throw new ExceptionExtensionExists("year : "+courseYear+ " semester : "+semester + " already extended for student stdStatCode : "+stdStatCode);
			}
		}
		
		if(!this.dropWTimeApplied)
		{
			logger.error("Attempt of postpone beyond drop with w period");
			throw new ExceptionDropDownPeriod("Drop with W period not covered.");
		}
		
		if(!studentModel.getYearSem().equals(""))
		{
			PostponeDTO			dto				=	new PostponeDTO(student,studentModel,userName);
								result 			=  	(rulePostponeCountWithinLimit)?postponeDBDao.setPostponeByStudent(dto):0;
		}
		if(result>0)
		{
			
			/* -- Notification -- Start --*/

			try
			{
				if(dpsServiceDao.isSupervisorAvailable(student.getAcademicDetail().getStudentNo(), student.getAcademicDetail().getStdStatCode()))
				{
					approverRole	=	Constants.CONST_SQL_ROLE_NAME_SUPERVISOR;
				}
				else
				{
					approverRole	=	Constants.CONST_SQL_ROLE_NAME_ADVISOR;
				}
				
				NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																					student.getAcademicDetail().getStudentNo(), 
																					student.getAcademicDetail().getStdStatCode(), 
																					Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY, 
																					approverRole, 
																					false, locale
																				);
	
				notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.postpone", null));
				notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.postpone", null, new Locale("ar")));
				notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.postpone", null));
				
				dpsNotification.sendNotification(
														UtilProperty.getMessage("prop.dps.postpone.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
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
				logger.error("Error in  notification for student submit at Postponement of Service : {}",ex.getMessage());
			}
			
			/* -- Notification -- end --*/
		}
		postponeDTOs	=	postponeDBDao.getPostponesForStudents(student.getAcademicDetail().getStudentNo(), locale);

		
		return postponeDTOs;
	}
	

	/**
	 * 
	 * method name  : getPostponeForAprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * PostponeServiceImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: Get List of student postpone data for approver role
	 *
	 * Date    		:	Sep 13, 2017 5:13:02 PM
	 * @throws NoDBRecordException 
	 * @throws ExceptionEmptyResultset 
	 */
	public List<PostponeDTO> getPostponeForAprovers(String roleType, Employee employee, Locale locale, String studentNo) throws NoDBRecordException, ExceptionEmptyResultset
	{
		List<PostponeDTO> 	resultList	=	null;
		
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		/* Delegation Enabled */
		if(null == employee.getEmpNumberDelegated())
		{
			resultList	=	postponeDBDao.getPostponeForApprovers(
																		roleType
																	, 	employee
																	, 	locale
																	, 	studentNo
																	, 	false
																	, 	false
																	, 	false
																	, 	false
																	);
		}
		else
		{
			List<PostponeDTO> 	listResultForDelegated	=	null;
			List<PostponeDTO> 	listResultForDelegatee	=	null;
			
			Gson				gson					=	new	Gson();
			Employee			delegatedEmployee		=	dpsServiceDao.getEmployee(employee.getEmpNumberDelegated(), employee.getUserNameDelegated(), locale, false);
			Employee			delegateeEmployee		=	dpsServiceDao.getEmployee(employee.getEmpNumberDelegatee(), employee.getUserNameDelegatee(), locale, false);
			
			if(delegatedEmployee.getEmpNumber().substring(0,1).equals("e"))
			{
				delegatedEmployee = dpsServiceDao.getDelegatedEmployee(delegatedEmployee, employee);
			}
			if(delegateeEmployee.getEmpNumber().substring(0,1).equals("e"))
			{
				delegateeEmployee	=	dpsServiceDao.getDelegateeEmployee(delegateeEmployee, employee);
			}
			
			/* Delegatee employee not required to view records of delegated */
			if(employee.getUserName().equals(employee.getUserNameDelegatee()))
			{
			
				listResultForDelegatee	=	postponeDBDao.getPostponeForApprovers
																					(
																							roleType
																						, 	delegateeEmployee
																						, 	locale
																						, 	studentNo
																						, 	Constants.CONST_IS_DELEGATION
																						, 	true
																						, 	Constants.CONST_DELEGATED_APPROVER_DEFAULT_ELIGIBLE
																						, 	Constants.CONST_DELEGATION_APPROVE_NOT_ELIGIBLE
																					);
				resultList				=	listResultForDelegatee;
			}
			else
			{
				listResultForDelegatee	=	postponeDBDao.getPostponeForApprovers
																				(
																							roleType
																						, 	delegateeEmployee
																						, 	locale
																						, 	studentNo
																						, 	Constants.CONST_IS_DELEGATION
																						, 	true
																						, 	Constants.CONST_DELEGATED_APPROVER_DEFAULT_ELIGIBLE
																						, 	Constants.CONST_DELEGATION_APPROVE_ELIGIBLE
																				);
				listResultForDelegated	= 	postponeDBDao.getPostponeForApprovers 
																				(
																						roleType
																					, 	delegatedEmployee
																					, 	locale
																					, 	studentNo
																					, 	Constants.CONST_IS_DELEGATION
																					, 	false
																					, 	Constants.CONST_DELEGATED_APPROVER_DEFAULT_ELIGIBLE
																					, 	Constants.CONST_DELEGATION_APPROVE_ELIGIBLE
																				);	

				listResultForDelegated.addAll(listResultForDelegatee);
				resultList				=	listResultForDelegated;
			}
			
			
		}
		
		return resultList;
	}

	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param dto
	 * @param employee
	 * @param locale
	 * @return
	 * PostponeServiceImpl
	 * return type  : PostponeDTO
	 * 
	 * purpose		: add record for approval / add record in approval transaction table
	 * Note			: This function relates with two different transactional statements
	 *
	 * Date    		:	Nov 7, 2017 5:55:12 PM
	 * @throws NoDBRecordException 
	 * @throws ExceptionEmptyResultset 
	 */
	public PostponeDTO setRoleTransaction(PostponeDTO dto, Employee employee, Locale locale) throws NoDBRecordException, ExceptionEmptyResultset
	{
		int						resultTr				=	0;
		PostponeDTO				dtoStudent				=	new PostponeDTO();
		PostponeDTO				dtoResult				=	null;
		
		ApprovalTransactionDTO	transactionDTO			=	new ApprovalTransactionDTO();
								transactionDTO.setStudentNo(dto.getStudentNo());
								transactionDTO.setStdStatCode(dto.getStudentStatCode());
								transactionDTO.setAppEmpNo(employee.getEmpNumber());
								transactionDTO.setAppEmpName(employee.getUserName());
								transactionDTO.setComments(dto.getCommentEng());
								transactionDTO.setRequestCode(dto.getRecordSequence());
																												/* Delegation Entry */
								transactionDTO.setAppDelegatedEmpNo(employee.getEmpNumberDelegated());
								transactionDTO.setAppDelegatedEmpUserName(employee.getUserNameDelegated());
								transactionDTO.setAppDelegateeEmpNo(employee.getEmpNumberDelegatee());
								transactionDTO.setAppDelegateeEmpUserName(employee.getUserNameDelegatee());
		
		ApprovalDTO				approvalDTO				=	dpsServiceDao.setRoleTransaction(
																									transactionDTO
																								, 	Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY
																								, 	dto.getRoleName()
																								, 	dto.getStatusCodeName()
																							);	
		if(dto.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
		{
			dtoStudent.setStatusCodeName(dto.getStatusCodeName());
		}
		else
		{
			if(approvalDTO.getApprovalSequenceNo() == approvalDTO.getApprovalMaxSequenceNo())
			{
				dtoStudent.setStatusCodeName(dto.getStatusCodeName());
			}
			else
			{
				dtoStudent.setStatusCodeName(Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
			}
		}
		
							dtoStudent.setStudentNo(dto.getStudentNo());
							dtoStudent.setStudentStatCode(dto.getStudentStatCode());
							dtoStudent.setUserName(employee.getUserName());
							dtoStudent.setCommentEng(dto.getCommentEng());
		
							resultTr					=	postponeDBDao.setPostponeStatusOfStudent(dtoStudent);	

		try
		{
			if(resultTr > 0)
			{
				/** Get postpone details for particular student **/				
				dtoResult	=	getPostponeForAprovers(dto.getRoleName(), employee, locale, dto.getStudentNo()).get(0); 
				/* -- Notification -- Start --*/
					NotifierPeople	notifierPeople	=	dpsServiceDao.getNotifierPeople(
																							dto.getStudentNo()
																						, 	dto.getStudentStatCode()
																						, 	Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY
																						, 	dto.getRoleName()
																						, true, locale
																						);
					notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.postpone", null));
					notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.postpone", null, new Locale("ar")));
					notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.postpone", null));					
					
					dpsNotification.sendNotification(
															UtilProperty.getMessage("prop.dps.postpone.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
														, 	notifierPeople
														, 	"null"
														, 	Constants.CONST_TEST_ENVIRONMENT
													);
					
				/* -- Notification -- end --*/
			}
		}
		catch(NotCorrectDBRecordException ex)
		{
			logger.error("Error in Notification : "+ex.getMessage());
		}
		catch(NotificationException exNotification)
		{
			logger.error("Error in  notification for approving at Postpone of Service  : {}",exNotification.getMessage());
		}
		
		return dtoResult;
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.postpone.service.PostponeService#isSemesterPostponed(java.lang.String)
	 */
	public boolean isSemesterPostponed(String stdStatCode)
	{
		return dpsServiceDao.isSemesterPostponed(stdStatCode);
	}
	
	/**
	 * 
	 * method name  : isRuleComplete
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * PostponeServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		:
	 *
	 * Date    		:	Dec 26, 2017 2:05:05 PM
	 */
	public boolean isRuleComplete(String studentNo, String stdStatCode)
	{
		boolean result	= false;
		/*
		 * Rule 1 : Allowed for Maximum two semester
		 * */
		rulePostponeCountWithinLimit	=	dpsServiceDao.isPostponeCountWithinLimit(studentNo, stdStatCode);
		
		/*
		 * Rule 2 : Drop with W period
		 */
		/* Following rules not applied at test environment */
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			this.dropWTimeApplied	=	true;
		}
		else
		{
			if(ruleService.isDropWPeriod())
			{
				this.dropWTimeApplied	=	true;
			}
			else
			{
				this.dropWTimeApplied	=	false;
			}
		}

		/**** Applying rules ****/
		if(rulePostponeCountWithinLimit && dropWTimeApplied)
		{
			result = true;
		}
		else
		{
			result	= false;
		}
		
		return result;
	}
	
	
}
