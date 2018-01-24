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
 * File Name			:	IncompleteGradeServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.service
 * Date of creation		:	Jan 3, 2018  9:17:07 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.service;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.db.IncompleteGradeDBDao;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.model.IncompleteGradeModel;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

/**
 * @author Bhabesh
 *
 */
public class IncompleteGradeServiceImpl implements IncompleteGradeService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	Crypto				crypto;
	@Autowired
	IncompleteGradeDBDao	incompleteGradeDBDao;
	@Autowired
	DPSNotification			dpsNotification;
	
	private boolean isRuleGradeChangeTimingFollowed;
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getCourseList(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getCourseList( String employeeNo, Locale	locale)
	{
		return incompleteGradeDBDao.getCourseList(isRuleGradeChangeTimingFollowed, employeeNo, locale);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getStudentList(java.lang.String, java.lang.String, java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getStudentList(String employeeNo, String lAbrCourseNo,String sectionNo, Locale	locale)
	{
		return incompleteGradeDBDao.getStudentList(isRuleGradeChangeTimingFollowed, employeeNo, lAbrCourseNo, sectionNo, locale);
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#setInstructorNotifyForIncompleteGrade(om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO, java.util.Locale)
	 */
	@Override
	public String setInstructorNotifyForIncompleteGrade(GradeIncompleteDTO dto, Locale locale ) throws NotCorrectDBRecordException
	{
		double	sequenceNumber =	dpsServiceDao.getSequenceNumber();
		int result	=	incompleteGradeDBDao.setInstructorNotifyForIncompleteGrade(sequenceNumber, dto);
		/* -- Notification -- Start --*/ 
		if(result > 0)
		{
			try
			{
			NotifierPeople	notifierPeople	=	dpsServiceDao.getNotifierPeople(
																						dto.getStudent().getAcademicDetail().getStudentNo()
																					, 	dto.getStudent().getAcademicDetail().getStdStatCode()
																					, 	Constants.CONST_FORM_NAME_DPS_INCOMPLETE_GRADE_NOTIFY
																					, 	Constants.CONST_SQL_ROLE_NAME_HOD
																					, 	false
																					, 	locale
																				);
			
			notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.incomplete.grade.notify.change", null));
			notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.incomplete.grade.notify.change", null, new Locale("ar")));
			notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.incomplete.grade.notify.change", null));
			
			dpsNotification.sendNotification(
					UtilProperty.getMessage("prop.dps.incomplete.grade.notify.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
				, 	notifierPeople
				, 	"null"
				, 	Constants.CONST_TEST_ENVIRONMENT
			);
			}
			catch (NotCorrectDBRecordException ex)
			{
				logger.error("Error in Notification : "+ex.getMessage());
			}
			 catch(Exception ex)
			 {
				 logger.error("Error in  notification for Instructor submit at Incomplete Grade Notification Service : {}",ex.getMessage());
			 }
				
			
		}
		 /* -- Notification -- end --*/
		return (result>0)?String.format("%.0f",sequenceNumber):null;
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getIncompleteNotifyHistory(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO>  getIncompleteNotifyHistory(String recordSequence,  Locale locale) throws NoDBRecordException
	{
		return incompleteGradeDBDao.getIncompleteNotifyHistory( recordSequence, locale);
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getStudentDetailsForApprovers(java.lang.String, om.edu.squ.squportal.portlet.dps.bo.Employee, java.util.Locale)
	 */
	@Override
	public List<Student> getStudentDetailsForApprovers(String roleType,  Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		return incompleteGradeDBDao.getStudentDetailsForApprovers(roleType, employee, locale);
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getCourseListForNotify(java.lang.String, java.lang.String, java.lang.String, om.edu.squ.squportal.portlet.dps.bo.Employee, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getCourseListForNotify(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return incompleteGradeDBDao.getCourseListForNotify(studentNo, studentStatCode, roleType, employee, locale);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#setIncompleteGradeNotifyApproval(om.edu.squ.squportal.portlet.dps.grade.incomplete.model.IncompleteGradeModel, om.edu.squ.squportal.portlet.dps.bo.Employee, javax.portlet.PortletRequest, java.util.Locale)
	 */
	public List<GradeIncompleteDTO> setIncompleteGradeNotifyApproval(IncompleteGradeModel incompleteGradeModel, Employee employee, PortletRequest request, Locale locale)
	{

		GradeIncompleteDTO			incompleteDTO			=	new GradeIncompleteDTO(incompleteGradeModel);
		incompleteDTO.setUserName(request.getRemoteUser());
		
		return setRoleTransaction(incompleteDTO,employee,locale);
	}
	
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param gradeIncompleteDTO
	 * @param employee
	 * @param locale
	 * @return
	 * IncompleteGradeServiceImpl
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 23, 2018 2:35:53 PM
	 */
	public List<GradeIncompleteDTO> setRoleTransaction(GradeIncompleteDTO gradeIncompleteDTO, Employee employee, Locale locale)
	{
		int 						resultTr					=	0;
		List<GradeIncompleteDTO>	listTransactionResult		=	null;
		String						roleName					=	gradeIncompleteDTO.getRoleType();
		
		ApprovalTransactionDTO	transactionDTO		=	new ApprovalTransactionDTO();
		transactionDTO.setStudentNo(gradeIncompleteDTO.getStudent().getAcademicDetail().getStudentNo());
		transactionDTO.setStdStatCode(gradeIncompleteDTO.getStudent().getAcademicDetail().getStdStatCode());
		transactionDTO.setAppEmpNo(employee.getEmpNumber());
		transactionDTO.setAppEmpName(gradeIncompleteDTO.getUserName());
		transactionDTO.setComments(gradeIncompleteDTO.getComments());
		transactionDTO.setRequestCode(gradeIncompleteDTO.getRecordSequence());
		
		
		ApprovalDTO		approvalDTO		=	dpsServiceDao.setRoleTransaction(
																				transactionDTO
																			, 	Constants.CONST_FORM_NAME_DPS_INCOMPLETE_GRADE_NOTIFY
																			, 	gradeIncompleteDTO.getRoleType()
																			, 	gradeIncompleteDTO.getlAbrStatusCode()
																		);
		
		

		if(gradeIncompleteDTO.getlAbrStatusCode().equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
		{
			
		}
		else
		{
			if(approvalDTO.getApprovalSequenceNo()==approvalDTO.getApprovalMaxSequenceNo())
			{
				
			}
			else
			{
				gradeIncompleteDTO.setlAbrStatusCode(Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
			}
		}
		
		resultTr	=	incompleteGradeDBDao.setIncompleteGradeNotifyApproval(gradeIncompleteDTO);
		
		if(resultTr > 0)
		{
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employee.setEmpNumber(employee.getEmpNumber().substring(1));
			}
			
			listTransactionResult =	incompleteGradeDBDao.getCourseListForNotify(
																						gradeIncompleteDTO.getStudent().getAcademicDetail().getStudentNo()
																					, 	gradeIncompleteDTO.getStudent().getAcademicDetail().getStdStatCode()
																					, 	roleName
																					, 	employee
																					, 	locale
																				);
			
				try
				{
					/* -- Notification -- Start --*/
					NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																							gradeIncompleteDTO.getStudent().getAcademicDetail().getStudentNo()
																						, 	gradeIncompleteDTO.getStudent().getAcademicDetail().getStdStatCode()
																						, 	Constants.CONST_FORM_NAME_DPS_INCOMPLETE_GRADE_NOTIFY
																						, 	roleName
																						, 	true, locale
																					);
					
					notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.incomplete.grade.notify.change", null));
					notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.incomplete.grade.notify.change", null, new Locale("ar")));
					notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.incomplete.grade.notify.change", null));
					
					dpsNotification.sendNotification(
														UtilProperty.getMessage("prop.dps.incomplete.grade.notify.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()}, locale)
														, notifierPeople
														, "null"
														, Constants.CONST_TEST_ENVIRONMENT
													);
					/* -- Notification -- end --*/
				}
				catch (NotCorrectDBRecordException ex)
				{
					logger.error("Error in Notification : "+ex.getMessage());
				}
				catch(NotificationException exNotification)
				{
					logger.error("Error in  notification for approving at Incomplete Grade Notification of Service 1 : {}",exNotification.getMessage());
				}				
			
			
		}
		
		
		return listTransactionResult;
	}
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#isRuleComplete()
	 */
	@Override
	public boolean isRuleComplete()
	{
		/*
		 * Rule 1 : Grade Change is allowed within one month after final exam
		 * */
		
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			
			this.isRuleGradeChangeTimingFollowed	=	false;
		}
		else
		{
			/*Rule 1*/
			this.isRuleGradeChangeTimingFollowed	=	true;
		}
		
		return true;
	}
	


	
}
