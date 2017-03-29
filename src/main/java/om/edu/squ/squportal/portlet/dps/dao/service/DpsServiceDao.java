/**
 * Project				:	prjLibrary
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	DpsServiceDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.service
 * Date of creation		:	May 20, 2015  1:21:28 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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

import java.util.Locale;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;

/**
 * @author Bhabesh
 *
 */
public interface DpsServiceDao
{

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
	public YearSemester	getCurrentYearSemester(Locale locale);
	
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
	public YearSemester		getNextYearSemester (Locale locale);
	
	
	/**
	 * 
	 * method name  : getStudentPersonalDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * DpsServiceDao
	 * return type  : PersonalDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:55:56 AM
	 */
	public PersonalDetail	getStudentPersonalDetail(String studentId, Locale locale );
	
	/**
	 * 
	 * method name  : getStudentAcademicDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * DpsServiceDao
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:56:00 AM
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, Locale locale );
	
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
	public User getUser(PortletRequest request);
	
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
	public Student	getStudent(String studentId,  Locale locale);
	
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
	//public Employee	getEmployee(String empNumber, Locale locale) throws ExceptionEmptyResultset;
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
	 * purpose		: Get Employee Details with Roles
	 *
	 * Date    		:	Mar 27, 2017 4:24:34 PM
	 */
	public Employee getEmployee(PortletRequest request, Locale locale) throws ExceptionEmptyResultset;
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param extensionDTO
	 * @param employee
	 * @return
	 * DpsServiceDao
	 * return type  : ApprovalDTO
	 * 
	 * purpose		: add a record in transaction table for approver status for a particular form and authorized employee
	 *
	 * Date    		:	Mar 1, 2017 5:45:32 PM
	 */
	public ApprovalDTO setRoleTransaction(ExtensionDTO extensionDTO, Employee employee);
}
