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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.DelegateEmployee;
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
	
	private final 	Logger 					logger = LoggerFactory.getLogger(this.getClass());
	
	private			Map<String, Object> 	myRules;
	
	@Autowired
					DpsDbDao				dpsDbDao;
	@Autowired
					UserIdUtil				userIdUtil;
	@Autowired	
					Role					roleService;
	@Autowired
					Rule					ruleService;



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
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getEmployee(java.lang.String, java.lang.String, java.util.Locale, boolean)
	 */
	public Employee	getEmployee(String empNumber, String empUserName, Locale locale, boolean applyDelegation) throws ExceptionEmptyResultset
	{
		List<RoleNameValue> 	roleNameValues	=	new ArrayList<RoleNameValue>();
		Employee				employee		=	dpsDbDao.getEmployee(empNumber, empUserName, applyDelegation);
		Employee				roleOfEmployee	=	null;

		/**** Delegation ****/
		if(applyDelegation)
		{
			if(empNumber.equals(employee.getEmpNumberDelegated()))
			{
				roleOfEmployee	=	roleService.getEmployeeRole(employee.getEmpNumberDelegatee());	// Get Role of Delegatee
			}
			else
			{
				roleOfEmployee	=	roleService.getEmployeeRole(employee.getEmpNumberDelegated());	// Get Role of Delegated -- might be self empNumber
			}
			
		}
		else
		{
			roleOfEmployee	=	roleService.getEmployeeRole(empNumber);	
		}
		
		employee.setEmployeeRole(roleOfEmployee);
		employee.setUserName(empUserName);
		
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
		if (employee.isCollegeAsstDeanP()) 
		{
						roleNameValues.add(new RoleNameValue(Constants.CONST_ROLE_NAME_ASST_DEAN_P, UtilProperty.getMessage("prop.dps.role.asst.dean.text", null, locale)));
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
	public Employee getEmployee(PortletRequest request, Locale locale, boolean applyDelegation) throws ExceptionEmptyResultset
	{
		String 		empNumber	=	getEmpNumber(request);	
		return 		getEmployee(empNumber, request.getRemoteUser(), locale, applyDelegation);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getEmployee(java.lang.String, java.lang.String, boolean)
	 */
	public Employee getEmployee(String empNumber, String empUserName, boolean applyDelegation) throws ExceptionEmptyResultset
	{
		return dpsDbDao.getEmployee(empNumber, empUserName, applyDelegation);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getDelegatedEmployee(om.edu.squ.squportal.portlet.dps.bo.Employee, om.edu.squ.squportal.portlet.dps.bo.Employee)
	 */
	public	Employee	getDelegatedEmployee(Employee delegatedEmployee, Employee employee)
	{
		delegatedEmployee.setEmpNumber(delegatedEmployee.getEmpNumber().substring(1));
		delegatedEmployee.setUserNameDelegated(employee.getUserNameDelegated());
		delegatedEmployee.setEmpNumberDelegated(employee.getEmpNumberDelegated());
		delegatedEmployee.setUserNameDelegatee(employee.getUserNameDelegatee());
		delegatedEmployee.setEmpNumberDelegatee(employee.getEmpNumberDelegatee());
		
		return delegatedEmployee;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getDelegateeEmployee(om.edu.squ.squportal.portlet.dps.bo.Employee, om.edu.squ.squportal.portlet.dps.bo.Employee)
	 */
	public Employee	getDelegateeEmployee(Employee delegateeEmployee, Employee employee)
	{
		delegateeEmployee.setEmpNumber(delegateeEmployee.getEmpNumber().substring(1));
		
		delegateeEmployee.setUserNameDelegated(employee.getUserNameDelegated());
		delegateeEmployee.setEmpNumberDelegated(employee.getEmpNumberDelegated());									
		delegateeEmployee.setUserNameDelegatee(employee.getUserNameDelegatee());
		delegateeEmployee.setEmpNumberDelegatee(employee.getEmpNumberDelegatee());
		
		return delegateeEmployee;
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
	public int getSelectedRegisteredCourseCredit(String studentNo, String stdStatCode, String courseNo, String sectNo)
	{
		return dpsDbDao.getSelectedRegisteredCourseCredit(studentNo, stdStatCode, courseNo, sectNo);
	}
	
	
	/**
	 * 
	 * method name  : getNotifierPeople
	 * @param studentNo
	 * @param studentStatCode
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
												String studentStatCode, 
												String formName, 
												String roleName,
												boolean isHigherApproverRequired, Locale locale 
											) throws NotCorrectDBRecordException
	{
		NotifierPeople	notifierPeople	=	new NotifierPeople();
		
		Student				student				=	getStudent(null, studentNo, locale);
		Approver			approver			=	null;
		Approver			approverHigher		=	null;
		List<RoleNameValue> roleList			=	null;
		String				statusDescriptionEng=	null;
		String				statusDescriptionAr	=	null;
		boolean				isSupervisor		=	false;
		

		
		if(isHigherApproverRequired)
		{
					approverHigher	=	dpsDbDao.getHigherApprover(studentNo, formName, roleName, Constants.CONST_YES);
		}
					approver		=	dpsDbDao.getHigherApprover(studentNo, formName, roleName, Constants.CONST_NO);

		roleList	=	roleService.getRoles(formName, locale);
		
		if(null != studentStatCode)
		{
			isSupervisor		=	isSupervisorAvailable(studentNo, studentStatCode);
			if(isSupervisor)
			{
				switch (formName)
				{
					case Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY:
						 roleList.remove(getRoleObjectFromList(Constants.CONST_SQL_ROLE_NAME_ADVISOR, roleList));
						break;
					case Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY:
						 roleList.remove(getRoleObjectFromList(Constants.CONST_SQL_ROLE_NAME_ADVISOR, roleList));
						break;
					
					default:
						break;
				}
			}
			else
			{
				switch (formName)
				{
					case Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY:
						 roleList.remove(getRoleObjectFromList(Constants.CONST_SQL_ROLE_NAME_SUPERVISOR, roleList));
						break;
					case Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY:
						 roleList.remove(getRoleObjectFromList(Constants.CONST_SQL_ROLE_NAME_SUPERVISOR, roleList));
						break;
					
					default:
						break;
				}
			}
		}
		
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

			strEmpNumber	=	String.valueOf(userIdUtil.getEmpNumber(request.getRemoteUser()));
			if(strEmpNumber==null || strEmpNumber=="")
			{
				return null;	
			}
			else return strEmpNumber;
			    
	    }
	    
	}
  
  

	/**
	 * 
	 * method name  : isSupervisorAvailable
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Find out whether the student has supervisor or not
	 *                Indirectly -- whether the student has thesis or not.
	 *                that means whether the student has any entry at thesis table.
	 *
	 * Date    		:	Aug 28, 2017 4:52:06 PM
	 */
	public boolean isSupervisorAvailable(String studentNo, String stdStatCode){
		return dpsDbDao.isSupervisorAvailable(studentNo, stdStatCode);
	}
	
	
	/**** POSTPONE RULE ****/
	
	/**
	 * 
	 * method name  : isPostponeCountWithinLimit
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Find whether the max limit of postpone reached
	 *
	 * Date    		:	Dec 26, 2017 1:57:12 PM
	 */
	public boolean isPostponeCountWithinLimit(String studentNo, String stdStatCode)
	{
		boolean	postponeLimit	=	false;
		int resultLimit	=	ruleService.countPostpone(studentNo, stdStatCode);
		postponeLimit	=	(resultLimit<=Constants.CONST_RULE_POSTPONE_STUDENT_MAXIMUM_ALLOWED)?true:false;
		if(!postponeLimit)
		{
			logger.error(
							"Student:: student no : {}, statcode : {}, already reached allowed number of postpone : {}"
							,studentNo,stdStatCode,Constants.CONST_RULE_POSTPONE_STUDENT_MAXIMUM_ALLOWED
						);
		}
		return (postponeLimit);
				
	}
	
	/**
	 * 
	 * method name  : getRoleObjectFromList
	 * @param roleName
	 * @param roleNameValues
	 * @return
	 * DpsServiceImpl
	 * return type  : RoleNameValue
	 * 
	 * purpose		:  Get particular Object from list
	 *
	 * Date    		:	Dec 31, 2017 1:08:53 PM
	 */
	private	RoleNameValue	getRoleObjectFromList(String roleName, List<RoleNameValue> roleNameValues)
	{
		RoleNameValue	result	=	null;
		Iterator<RoleNameValue> 	iterator	=	roleNameValues.iterator();
		while(iterator.hasNext())
		{
			RoleNameValue	roleNameValue	=	iterator.next();
			if(roleNameValue.getRoleName().equals(roleName))
			{
				result	=	roleNameValue;
				break;
			}
		}
		
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getSequenceNumber()
	 */
	@Override
	public double getSequenceNumber()
	{
		return dpsDbDao.getSequenceNumber();
	}
	

	/*
	 * Delegation
	 */
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#getDelegatedEmployee(java.lang.String)
	 */
	public	DelegateEmployee getDelegatedEmployee(String empUserName)
	{
		return dpsDbDao.getDelegatedEmployee(empUserName);
	}


	/**
	 * Getter Method	: getMyRules
	 * @return the myRules
	 * 
	 * Date				: Jan 14, 2019
	 */
	public Map<String, Object> getMyRules()
	{
		return this.myRules;
	}


	/**
	 * Setter method : setMyRules
	 * @param myRules the myRules to set
	 * 
	 * Date          : Jan 14, 2019 1:46:41 PM
	 */
	public void setMyRules(Map<String, Object> myRules)
	{
		this.myRules = myRules;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#booToString(boolean, java.util.Locale)
	 */
	public	String booToString(boolean booVal, Locale locale )
	{
		return 
				(booVal)
						?	UtilProperty.getMessage("prop.dps.role.submit.yes.text", null, locale)
						:	UtilProperty.getMessage("prop.dps.role.submit.no.text", null, locale);
	}
	
}
