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

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.dao.db.DpsDbDao;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.role.service.Role;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
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
	public PersonalDetail	getStudentPersonalDetail(String studentId, Locale locale ) 
	{
		PersonalDetail		personalDetail		=	null;
		try
		{
			personalDetail	=	 dpsDbDao.getStudentPersonalDetail(studentId, locale);
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
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:22:11 AM
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, Locale locale )
	{
		AcademicDetail	academicDetail	=	null;
		try
		{
			academicDetail	=	dpsDbDao.getStudentAcademicDetail(studentId, locale);
		}
		catch (NoDBRecordException ex)
		{
			 logger.error("Error to get Student academic Detail : {}",ex.getMessage());
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
	 */
	public Student	getStudent(String studentId,  Locale locale)
	{
		Student			student			=	new	Student();
		PersonalDetail	personalDetail	=	getStudentPersonalDetail(studentId, locale);
		AcademicDetail	academicDetail	=	getStudentAcademicDetail(studentId, locale);
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
	public Employee	getEmployee(String empNumber, Locale locale) throws ExceptionEmptyResultset
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


	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao#setRoleTransaction(om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO, om.edu.squ.squportal.portlet.dps.bo.Employee)
	 */
	public ApprovalDTO setRoleTransaction(ExtensionDTO extensionDTO, Employee employee)
	{
		ApprovalTransactionDTO	transactionDTO	=	new ApprovalTransactionDTO();
		ApprovalDTO	approvalDTO		=	roleService.getApprovalCode(Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY,extensionDTO.getRoleName());
		String	statusCode			=	roleService.getStatusCode(extensionDTO.getStatusCodeName());
		
		transactionDTO.setStudentNo(extensionDTO.getStudentNo());
		transactionDTO.setStdStatCode(extensionDTO.getStdStatCode());
		transactionDTO.setApprovalCode(approvalDTO.getApprovalCode());
		transactionDTO.setStatusCode(statusCode);
		transactionDTO.setAppEmpNo(employee.getEmpNumber());
		transactionDTO.setAppEmpName(employee.getUserName());
		transactionDTO.setComments(extensionDTO.getCommentEng());
		
		int	result	=	roleService.setRoleTransaction(transactionDTO);
		
		
		return approvalDTO;
	}
	
	
}
