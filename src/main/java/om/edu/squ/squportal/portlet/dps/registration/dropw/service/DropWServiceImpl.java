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
 * File Name			:	DropWServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.service
 * Date of creation		:	Mar 30, 2017  8:57:49 AM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.service;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotSuccessFulDBUpdate;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.db.DropWDBDao;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

/**
 * @author Bhabesh
 *
 */
public class DropWServiceImpl implements DropWService
{
	private final Logger 	logger 						= 	LoggerFactory.getLogger(this.getClass());
	private		  boolean	stdModeCreditApplied		=	false;  
	
	private		  String	dropWTimeApplied			=	Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED;
	
	@Autowired
	DropWDBDao	dropWDBDao;
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	Rule					ruleService;
	@Autowired
	DPSNotification			dpsNotification;
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param student
	 * @param locale
	 * @return 
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	@Override
	public List<DropWDTO> getCourseList(Student student, Locale locale)
	{
		String studentMode	=	null;
		if(stdModeCreditApplied)
		{
			studentMode = dpsServiceDao.getStudentMode(
							student.getAcademicDetail().getStudentNo(), 
							student.getAcademicDetail().getStdStatCode()
						);
		}
		else
		{
			studentMode = Constants.CONST_RULE_DROP_W_STUDENT_MODE_NOT_APPLIED;
		}
		
		 
		return dropWDBDao.getCourseList(student, locale, studentMode, this.dropWTimeApplied);
		
	}

	/**
	 * 
	 */
	@Override
	public List<DropWDTO> setDropWCourseAdd(Student student, DropCourseModel dropCourseModel, Locale locale)
	{
		int 			resultSetDropW 	= 	setTempDropWCourseAdd( student,  dropCourseModel);
		if(resultSetDropW > 0)
		{
			List<DropWDTO>	dropWDTOs		=	getDropWCourses(student,locale);
			/* -- Notification -- Start --*/
			try
			{
				NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																					student.getAcademicDetail().getStudentNo(), 
																					null, 
																					Constants.CONST_FORM_NAME_DPS_DROP_W, 
																					Constants.CONST_SQL_ROLE_NAME_ADVISOR, 
																					false, locale
																				);
	
				notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.dropw", null));
				notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.dropw", null, new Locale("ar")));
				notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.dropw", null));
				
				dpsNotification.sendNotification(
														UtilProperty.getMessage("prop.dps.dropw.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
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
				logger.error("Error in  notification for student submit at Drop with W Service : {}",ex.getMessage());
			}
			/* -- Notification -- end --*/
			
			
			return dropWDTOs;
		}
		else
		{
			logger.error("Database Insert is not successful at temporary/helper table for student no {}.",student.getAcademicDetail().getStudentNo());
			return null;
		}
	}
	
	/**
	 * 
	 * method name  : getDropWCourses
	 * @param student
	 * @param locale
	 * @return
	 * DropWServiceImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: get details of the courses opt to be dropped
	 *
	 * Date    		:	Apr 12, 2017 4:50:19 PM
	 */
	public List<DropWDTO>  getDropWCourses(Student student, Locale locale)
	{
		List<DropWDTO>	dropWDTOs	=	null;
						dropWDTOs	=	dropWDBDao.getCourseList(
																	student.getAcademicDetail().getStudentNo(), 
																	student.getAcademicDetail().getStdStatCode(), 
																	locale
																);
		return dropWDTOs;
	}
	

	/**
	 * 
	 * method name  : setTempDropWCourseAdd
	 * @param student
	 * @param dropCourseModel
	 * @return
	 * DropWServiceImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Apr 12, 2017 3:26:06 PM
	 */
	private int setTempDropWCourseAdd(Student student, DropCourseModel dropCourseModel)
	{
		DropWDTO	dropWDTO	=	new DropWDTO();
		dropWDTO.setStudentNo(student.getAcademicDetail().getStudentNo());
		dropWDTO.setStudentStatCode(student.getAcademicDetail().getStdStatCode());
		
		
		dropWDTO.setCourseNo(dropCourseModel.getCourseNo());
		dropWDTO.setSectCode(dropCourseModel.getSectCode());
		dropWDTO.setSectionNo(dropCourseModel.getSectNo());
		dropWDTO.setUserName(student.getAcademicDetail().getStudentUserName());
		
		
		return dropWDBDao.setTempDropWCourseAdd(dropWDTO);
	}


	/**
	 * 
	 * method name  : getDropWForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get List of student records for courses to be dropped 
	 *
	 * Date    		:	Apr 17, 2017 8:24:28 PM
	 */
	public List<DropWDTO> getDropWForApprovers(String roleType, Employee employee, Locale locale) throws NoDBRecordException
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return dropWDBDao.getDropWForApprovers(roleType, employee, locale, null);
	}
	
	
	/**
	 * 
	 * method name  : setDropWCourseUpdate
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in drop w
	 *
	 * Date    		:	May 2, 2017 10:59:22 AM
	 * @throws NotSuccessFulDBUpdate 
	 */
	public List<DropWDTO> setDropWCourseUpdate(DropWDTO dropWDTO, Locale locale) throws NotSuccessFulDBUpdate
	{
		int						resultUpdate		=	0;
		AcademicDetail			academicDetail		=	new AcademicDetail();
		Student					student				=	new Student();
		ApprovalDTO				approvalDTO			=	null;
		
		DropWDTO				dropWDTOTransaction	=	null;
		
		
		try
		{
			dropWDTOTransaction	=	(DropWDTO)dropWDTO.clone();
		}
		catch (CloneNotSupportedException ex)
		{
			logger.error("Error in Object cloning. Details {}",ex.getMessage());
		}
		
		
		academicDetail.setStudentNo(dropWDTO.getStudentNo());
		academicDetail.setStdStatCode(dropWDTO.getStudentStatCode());
		student.setAcademicDetail(academicDetail);
	
		resultUpdate	=	dropWDBDao.setDropWCourseUpdate(dropWDTO);
	
		if(resultUpdate >  0)
		{
			approvalDTO		=	setRoleTransaction(dropWDTOTransaction, locale);
			return getDropWCourses(student,locale);
		}
		else
		{
			return null;
		}
	}

	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param dropWDTO
	 * @return
	 * DropWServiceImpl
	 * return type  : ApprovalDTO
	 * 
	 * purpose		: Add records to approval transaction table
	 *
	 * Date    		:	Aug 1, 2017 5:40:55 PM
	 */
	public ApprovalDTO setRoleTransaction(DropWDTO dropWDTO, Locale locale)
	{
		ApprovalTransactionDTO	transactionDTO		=	new ApprovalTransactionDTO();
		
		transactionDTO.setStudentNo(dropWDTO.getStudentNo());
		transactionDTO.setStdStatCode(dropWDTO.getStudentStatCode());
		transactionDTO.setAppEmpNo(dropWDTO.getEmpNumber());
		transactionDTO.setAppEmpName(dropWDTO.getUserName());
		transactionDTO.setComments(dropWDTO.getRemarks());
		transactionDTO.setRequestCode(Constants.CONST_REQUEST_CODE_DEFAULT);
		
		ApprovalDTO	approvalDTO				= 	dpsServiceDao.setRoleTransaction(
																						transactionDTO
																					, 	Constants.CONST_FORM_NAME_DPS_DROP_W
																					, 	dropWDTO.getRoleName()
																					, 	dropWDTO.getStatusApprove()
																				);
		
		
		
		/* -- Notification -- Start --*/
		
			try
			{

				NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																					dropWDTO.getStudentNo(), 
																					null, 
																					Constants.CONST_FORM_NAME_DPS_DROP_W, 
																					Constants.CONST_SQL_ROLE_NAME_ADVISOR, 
																					true, locale
																				);
	
				
				
				notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.dropw", null));
				notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.dropw", null, new Locale("ar")));
				notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.dropw", null));
				
				dpsNotification.sendNotification(
														UtilProperty.getMessage("prop.dps.dropw.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
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
				logger.error("Error in  notification for student submit at Drop with W Service : {}",ex.getMessage());

			}
			
		/* -- Notification -- end --*/
		
		
		return approvalDTO;
	}
	
	
	/**
	 * 
	 * method name  : isRuleStudentComplete
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DropWServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rule for Droping the course with W
	 *
	 * Date    		:	May 17, 2017 3:11:11 PM
	 */
	public boolean isRuleStudentComplete(String studentNo, String stdStatCode, String courseNo)
	{
		/*Rule 1 : 	Full Time need 9 Credit after drop
		 * 			Part Time need 3 Credit after drop
		 * Rule 2 : Period within Drop W Period 
		 * */
		
		
		/*Rule 1 */
		String studyModeType = dpsServiceDao.getStudentMode(studentNo,stdStatCode);
		int	totalCredit	=	dpsServiceDao.getTotalRegisteredCredit(studentNo, stdStatCode);
		if(null==courseNo)
		{
			
			this.stdModeCreditApplied	=	ruleService.isDropwTotalRegisteredCreditRuleExist(
																						totalCredit, 
																						0,
																						studyModeType
																					);
		}
		else
		{
			this.stdModeCreditApplied	=	ruleService.isDropwTotalRegisteredCreditRuleExist(
																						totalCredit, 
																						dpsServiceDao.getSelectedRegisteredCourseCredit(studentNo, stdStatCode, courseNo),
																						studyModeType
																					);
		}
		
		
		/*Rule 2 */
		
		if(ruleService.isDropWPeriod(studentNo, stdStatCode))
		{
			this.dropWTimeApplied		= 	Constants.CONST_RULE_DROP_W_PERIOD_APPLIED; 
		}
		else
		{
			this.dropWTimeApplied		=	Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED;
		}
		
		/* Following rules not applied at test environment
		 * 
		 * rule 2
		 * */
		
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			this.dropWTimeApplied		=	Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED;
		}

		//TODO : Do not change result of the rule
		return true;
	}
	
	/**
	 * 
	 * method name  : isRuleModeCreditApplied
	 * @return
	 * DropWServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: whether rule for credit mode (FULL Time -> 9 credits / PART Time -> 3 credits after drop) applied
	 *
	 * Date    		:	Aug 23, 2017 10:25:33 AM
	 */
	public boolean isRuleModeCreditApplied()
	{
		return this.stdModeCreditApplied;
	}
	
	/**
	 * 
	 * method name  : isDropWTimeApplied
	 * @return
	 * DropWServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: whether rule for drop with 'w' time frame applied
	 *
	 * Date    		:	Aug 23, 2017 10:26:47 AM
	 */
	public boolean isDropWTimeApplied()
	{
		if(this.dropWTimeApplied.equals(Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
}
