/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	DpsServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.service
 * Date of creation		:	Jan 08, 2017 
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
package om.edu.squ.squportal.portlet.dps.dao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import om.edu.squ.portal.common.EmpCommon;
import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.dao.db.DpsDbDao;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalStatus;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.role.service.Role;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UserIdUtil;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Bhabesh
 *
 */

public class DpsServiceImpl implements DpsServiceDao
{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsDbDao	dpsDbDao;
	@Autowired
	UserIdUtil	userIdUtil;
	@Autowired	
	Role	roleService;
	@Autowired
	Rule	ruleService;



	/**
	 * 
	 * method name  : getCurrentYearSemester
	 * @param locale
	 * @return
	 * DpsServiceImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: get current year semester
	 *
	 * Date    		:	Jan 16, 2017 12:05:52 PM
	 */
	public YearSemester	getCurrentYearSemester(Locale locale)
	{
		return dpsDbDao.getCurrentYearSemester(locale);
	}
	

	/**
	 * 
	 * method name  : getNextYearSemester
	 * @param locale
	 * @return
	 * DpsDbImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get next year semester
	 *
	 * Date    		:	Jan 16, 2017 3:02:26 PM
	 */
	public YearSemester		getNextYearSemester (Locale locale)
	{
		YearSemester	currYearSemester	=	dpsDbDao.getCurrentYearSemester(locale);
		YearSemester 	nextYearSemester	=	dpsDbDao.getNextYearSemester(locale);
		
		if(nextYearSemester.equals(currYearSemester))
		{ 
			return null;
		}
		else
		{
			return nextYearSemester;
		}
		
	}
	
	
	/**
	 * 
	 * method name  : getStudentPersonalDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : PersonalDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:21:56 AM
	 */
	public PersonalDetail	getStudentPersonalDetail(String studentId, String studentNo, Locale locale ) 
	{
		PersonalDetail		personalDetail		=	null;
		try
		{
			personalDetail	=	 dpsDbDao.getStudentPersonalDetail(studentId, studentNo, locale);
		}
		catch (NoDBRecordException ex)
		{
			logger.error("Error to get Student Personal Detail : {}",ex.getMessage());
		}
		
		return personalDetail;
		
	}
	
	/**
	 * 
	 * method name  : getStudentAcademicDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * @throws NotCorrectDBRecordException 
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:22:11 AM
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, String studentNo, Locale locale )  
	{
		AcademicDetail	academicDetail	=	null;
		try
		{
			academicDetail	=	dpsDbDao.getStudentAcademicDetail(studentId, studentNo, locale);
		}
		catch (NoDBRecordException ex)
		{
			 logger.error("Error to get Student academic Detail : {}",ex.getMessage());
		}
		catch(NotCorrectDBRecordException exNotCorrectRs)
		{
			logger.error("Error to get Student academic Detail : {}",exNotCorrectRs.getMessage());
		}
		return academicDetail;
	}
	
	/**
	 * 
	 * method name  : getUser
	 * @param request
	 * @return
	 * DpsServiceImpl
	 * return type  : User
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 12:40:50 PM
	 */
	public User getUser(PortletRequest request)
	{
		return userIdUtil.getUser(request.getRemoteUser());
	}
	
	
	
	/**
	 * 
	 * method name  : getStudent
	 * @param studentId
	 * @param locale
	 * @return
	 * DpsServiceImpl
	 * return type  : Student
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 12:12:47 PM
	 * @throws NotCorrectDBRecordException 
	 */
	public Student	getStudent(String studentId,  String studentNo, Locale locale) throws NotCorrectDBRecordException
	{
		Student			student			=	new	Student();
		PersonalDetail	personalDetail	=	getStudentPersonalDetail(studentId, studentNo, locale);
		AcademicDetail	academicDetail	=	getStudentAcademicDetail(studentId, studentNo, locale);
		student.setPersonalDetail(personalDetail);
		student.setAcademicDetail(academicDetail);
		return student;
	}
	
	/**
	 * 
	 * method name  : getEmployee
	 * @param empNumber
	 * @param locale
	 * @return
	 * DpsServiceImpl
	 * return type  : Employee
	 * 
	 * purpose		: Get Employee Details with Roles
	 *
	 * Date    		:	Feb 13, 2017 9:50:17 PM
	 * @throws ExceptionEmptyResultset 
	 */
	private Employee	getEmployee(String empNumber, Locale locale) throws ExceptionEmptyResultset
	{
		List<RoleNameValue> 	roleNameValues	=	new ArrayList<RoleNameValue>();
		Employee				employee		=	dpsDbDao.getEmployee(empNumber);
		Employee				roleOfEmployee	=	roleService.getEmployeeRole(empNumber);
		employee.setEmployeeRole(roleOfEmployee);
		
		if (employee.isAdvisor()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_ADVISOR, UtilProperty.getMessage("prop.dps.role.advisor.text", null, locale)));
		}
		if (employee.isSupervisor()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_SUPERVISOR, UtilProperty.getMessage("prop.dps.role.supervisor.text", null, locale)));
		}
		if (employee.isHod()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_HOD, UtilProperty.getMessage("prop.dps.role.hod.text", null, locale)));
		}
		if (employee.isCollegeAsstDean()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_ASST_DEAN, UtilProperty.getMessage("prop.dps.role.asst.dean.text", null, locale)));
		}
		if (employee.isCollegeDean()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_COL_DEAN, UtilProperty.getMessage("prop.dps.role.college.dean", null, locale)));
		}
		if (employee.isDpsDean()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_DPS_DEAN, UtilProperty.getMessage("prop.dps.role.dps.dean", null, locale)));
		}
		if (employee.isDpsStaff()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_DPS_STAFF, UtilProperty.getMessage("prop.dps.role.dps.staff", null, locale)));
		}

		employee.setMyRoles(roleNameValues);
		
		return employee;
	}

	/**
	 * 
	 * method name  : getEmployee
	 * @param request
	 * @param locale
	 * @return
	 * @throws ExceptionEmptyResultset
	 * DpsServiceImpl
	 * return type  : Employee
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Mar 27, 2017 4:24:34 PM
	 */
	public Employee getEmployee(PortletRequest request, Locale locale) throws ExceptionEmptyResultset
	{
		String 		empNumber	=	getEmpNumber(request);	
		return 		getEmployee(empNumber, locale);
	}
	

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#setRoleTransaction(om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO, om.edu.squ.squportal.portlet.dps.bo.Employee)
	 */
	public ApprovalDTO setRoleTransaction(ApprovalTransactionDTO transactionDTO, String formName, String roleName, String statusCodeName)
	{
		
		ApprovalDTO	approvalDTO		=	roleService.getApprovalCode(formName,roleName);
		String	statusCode			=	roleService.getStatusCode(statusCodeName);

		transactionDTO.setApprovalCode(approvalDTO.getApprovalCode());
		transactionDTO.setStatusCode(statusCode);

		int	result	=	roleService.setRoleTransaction(transactionDTO);
		
		return approvalDTO;
	}

	
	/**
	 * 
	 * method name  : getStudentMode
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : String
	 * 
	 * purpose		: Get Study mode of the student (Full Time/Part Time) etc.
	 *
	 * Date    		:	May 16, 2017 11:06:05 PM
	 */
	public String	getStudentMode(String studentNo, String stdStatCode)
	{
		return dpsDbDao.getStudentMode(studentNo, stdStatCode);
	}

    
	/**
	 * 
	 * method name  : getTotalRegisteredCredit
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : int
	 * 
	 * purpose		: Total registered credit of a student at current semester 
	 *
	 * Date    		:	Aug 16, 2017 2:35:44 PM
	 */
	public int getTotalRegisteredCredit(String studentNo, String stdStatCode)
	{
		return dpsDbDao.getTotalRegisteredCredit(studentNo, stdStatCode);
	}
	
	/**
	 * 
	 * method name  : getSelectedRegisteredCourseCredit
	 * @param studentNo
	 * @param stdStatCode
	 * @param courseNo
	 * @return
	 * DpsDbImpl
	 * return type  : int
	 * 
	 * purpose		:	Get course credit for individual selected registered course
	 *
	 * Date    		:	Aug 17, 2017 5:05:04 PM
	 */
	public int getSelectedRegisteredCourseCredit(String studentNo, String stdStatCode, String courseNo)
	{
		return dpsDbDao.getSelectedRegisteredCourseCredit(studentNo, stdStatCode, courseNo);
	}
	
	
	/**
	 * 
	 * method name  : getNotifierPeople
	 * @param studentNo
	 * @param formName
	 * @param roleName
	 * @param isHigherApproverRequired
	 * @param locale
	 * @return
	 * @throws NotCorrectDBRecordException
	 * DpsServiceImpl
	 * return type  : NotifierPeople
	 * 
	 * purpose		: Get list of people to notify
	 *
	 * Date    		:	Jul 16, 2017 2:08:56 PM
	 */
	public NotifierPeople getNotifierPeople(
												String studentNo, 
												String formName, 
												String roleName, 
												boolean isHigherApproverRequired,
												Locale locale 
											) throws NotCorrectDBRecordException
	{
		NotifierPeople	notifierPeople	=	new NotifierPeople();
		
		Student				student				=	getStudent(null, studentNo, locale);
		Approver			approver			=	null;
		Approver			approverHigher		=	null;
		List<RoleNameValue> roleList			=	null;
		String				statusDescriptionEng=	null;
		String				statusDescriptionAr	=	null;
		
		
		if(isHigherApproverRequired)
		{
					approverHigher	=	dpsDbDao.getHigherApprover(studentNo, formName, roleName, Constants.CONST_YES);
		}
					approver		=	dpsDbDao.getHigherApprover(studentNo, formName, roleName, Constants.CONST_NO);

		roleList	=	roleService.getRoles(formName, locale);
		notifierPeople.setStudent(student);
		notifierPeople.setApprover(approver);
		notifierPeople.setApproverHigher(approverHigher);
		notifierPeople.setRoles(roleList);
		
		
		int count = 0;
		for(RoleNameValue role : roleList)
		{
			count++;
			
			ApprovalStatus approvalStatus = roleService.getApprovalStatus(studentNo, formName, role.getRoleName(), locale);
			
			if(
					approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_NAME_PENDING) ||
					approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_REJCT)
			)
			{
				notifierPeople.setPending((approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_NAME_PENDING)?true:false));
				notifierPeople.setReject((approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_REJCT)?true:false));
				
				statusDescriptionEng 	= approvalStatus.getStatusDescEng();
				statusDescriptionAr		=	approvalStatus.getStatusDescAr();
				break;
			} else
			{
				if(count == roleList.size())
				{
					if(approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_ACCPT))
					{
						notifierPeople.setAccept(approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_ACCPT)?true:false);
						statusDescriptionEng 	= approvalStatus.getStatusDescEng();
						statusDescriptionAr		=	approvalStatus.getStatusDescAr();
					}
					
				}
				else
				{
					if(approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_ACCPT))
					{
						notifierPeople.setProgress(approvalStatus.getStatusCodeName().equals(Constants.CONST_SQL_STATUS_CODE_ACCPT)?true:false);
						ApprovalStatus 	approvalStatusDesc		=	roleService.getApprovalStatusDescription(Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
										statusDescriptionEng	=	approvalStatusDesc.getStatusDescEng();
										statusDescriptionAr		=	approvalStatusDesc.getStatusDescAr();
						
					}
				}
			
			}
			
			if(roleName.equals(role.getRoleName()))
			{
				break;
			}
			
		}
		
		
		
		notifierPeople.setStatusDescEng(statusDescriptionEng);
		notifierPeople.setStatusDescAr(statusDescriptionAr);
		
		return notifierPeople;
	}
	
	
	/**
	 * 
	 * method name  : getEmpNumber
	 * @param request
	 * @return
	 * DpsServiceImpl
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 27, 2017 4:20:42 PM
	 */
    public  String getEmpNumber(PortletRequest request)
	{

	    if(request.getRemoteUser()==null || request.getRemoteUser()=="")
	    {		    return null;
	    }
	    else 
	    {
			String strEmpNumber=null;
			try
			{
				EmpCommon	empCommon	=	new EmpCommon();
						strEmpNumber 	= 	empCommon.getEmployeeNumber(request.getRemoteUser());
			}
			catch(Exception ex)
			{
				logger.info("******* exception while getting emp no: " + ex.getMessage());
			}
			if(strEmpNumber==null || strEmpNumber=="")
			{
				return null;	
			}
			else return strEmpNumber;
			    
	    }
	    
	}
    

	
	
}
