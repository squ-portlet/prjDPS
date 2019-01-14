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
import java.util.Map;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.DelegateEmployee;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;

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
	 * @param studentNo TODO
	 * @param locale
	 * @return
	 * DpsServiceDao
	 * return type  : PersonalDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:55:56 AM
	 */
	public PersonalDetail	getStudentPersonalDetail(String studentId, String studentNo, Locale locale );
	
	/**
	 * 
	 * method name  : getStudentAcademicDetail
	 * @param studentId
	 * @param studentNo TODO
	 * @param locale
	 * @return
	 * DpsServiceDao
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:56:00 AM
	 * @throws NotCorrectDBRecordException 
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, String studentNo, Locale locale ) throws NotCorrectDBRecordException;
	
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
	 * method name  : getEmployee
	 * @param empNumber
	 * @param empUserName TODO
	 * @param locale
	 * @param applyDelegation TODO
	 * @return
	 * @throws ExceptionEmptyResultset
	 * DpsServiceDao
	 * return type  : Employee
	 * 
	 * purpose		:	get employee by employee number
	 *
	 * Date    		:	May 9, 2018 10:24:03 PM
	 */
	public Employee	getEmployee(String empNumber, String empUserName, Locale locale, boolean applyDelegation) throws ExceptionEmptyResultset;
	
	/**
	 * 
	 * method name  : getEmployee
	 * @param empNumber
	 * @param empUserName
	 * @param applyDelegation
	 * @return
	 * @throws ExceptionEmptyResultset
	 * DpsServiceDao
	 * return type  : Employee
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 28, 2018 2:16:43 PM
	 */
	public Employee getEmployee(String empNumber, String empUserName, boolean applyDelegation) throws ExceptionEmptyResultset;
	
	/**
	 * 
	 * method name  : getStudent
	 * @param studentId
	 * @param studentNo TODO
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
	public Student	getStudent(String studentId,  String studentNo, Locale locale) throws NotCorrectDBRecordException;
	
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
	 * @param applyDelegation TODO
	 * @return
	 * @throws ExceptionEmptyResultset
	 * DpsServiceImpl
	 * return type  : Employee
	 * 
	 * purpose		: Get Employee Details with Roles
	 *
	 * Date    		:	Mar 27, 2017 4:24:34 PM
	 */
	public Employee getEmployee(PortletRequest request, Locale locale, boolean applyDelegation) throws ExceptionEmptyResultset;
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param transactionDTO
	 * @param formName TODO
	 * @param roleName TODO
	 * @param statusCodeName TODO
	 * @return
	 * DpsServiceDao
	 * return type  : ApprovalDTO
	 * 
	 * purpose		: add a record in transaction table for approver status for a particular form and authorized employee
	 *
	 * Date    		:	Mar 1, 2017 5:45:32 PM
	 */
	public ApprovalDTO setRoleTransaction(ApprovalTransactionDTO transactionDTO, String formName, String roleName, String statusCodeName);
	
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
	public String	getStudentMode(String studentNo, String stdStatCode);
	
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
	public int getTotalRegisteredCredit(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : getSelectedRegisteredCourseCredit
	 * @param studentNo
	 * @param stdStatCode
	 * @param courseNo
	 * @param sectNo TODO
	 * @return
	 * DpsDbImpl
	 * return type  : int
	 * 
	 * purpose		:	Get course credit for individual selected registered course
	 *
	 * Date    		:	Aug 17, 2017 5:05:04 PM
	 */
	public int getSelectedRegisteredCourseCredit(String studentNo, String stdStatCode, String courseNo, String sectNo);
	
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
    public  String getEmpNumber(PortletRequest request);


	
	/**
	 * 
	 * method name  : getNotifierPeople
	 * @param studentNo
	 * @param studentStatCode TODO
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
											) throws NotCorrectDBRecordException;
	
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
	public boolean isSupervisorAvailable(String studentNo, String stdStatCode);
	
	
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
	public boolean isPostponeCountWithinLimit(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : getSequenceNumber
	 * @return
	 * DpsDbDao
	 * return type  : int
	 * 
	 * purpose		: Get Squence number
	 *
	 * Date    		:	Jan 14, 2018 12:40:56 PM
	 */
	public double getSequenceNumber();
	
	/*
	 * Delegation
	 */
	/**
	 * 
	 * method name  : getDelegatedEmployee
	 * @param empUserName
	 * @return
	 * DpsServiceDao
	 * return type  : DelegateEmployee
	 * 
	 * purpose		: Get delegatee (person who delegates) and delegated user with username, from and to date
	 *
	 * Date    		:	Aug 26, 2018 2:42:55 PM
	 */
	public	DelegateEmployee getDelegatedEmployee(String empUserName);
	
	/**
	 * 
	 * method name  : getMyRules
	 * @return
	 * DpsServiceDao
	 * return type  : Map<String,Object>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 14, 2019 1:48:36 PM
	 */
	public Map<String, Object> getMyRules();
	
	/**
	 * 
	 * method name  : setMyRules
	 * @param myRules
	 * DpsServiceDao
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 14, 2019 1:48:47 PM
	 */
	public void setMyRules(Map<String, Object> myRules);
}
