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
 * File Name			:	DpsDbDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.db
 * Date of creation		:	May 20, 2015  12:50:54 PM
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
package om.edu.squ.squportal.portlet.dps.dao.db;

import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;

/**
 * @author Bhabesh
 *
 */
public interface DpsDbDao
{
	
	/**
	 * 
	 * method name  : getEmployee
	 * @param empNumber
	 * @return
	 * DpsDbImpl
	 * return type  : Employee
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 8, 2017 3:42:44 PM
	 * @throws ExceptionEmptyResultset 
	 */
	public Employee getEmployee(String empNumber) throws ExceptionEmptyResultset;
	
	/**
	 * 
	 * method name  : getCurrentYearSemester
	 * @param locale
	 * @return
	 * DpsDbDao
	 * return type  : YearSemester
	 * 
	 * purpose		: Get Current Year Semester
	 *
	 * Date    		:	Jan 16, 2017 11:10:49 AM
	 */
	public YearSemester		getCurrentYearSemester (Locale locale);
	

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
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : PersonalDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:21:56 AM
	 */
	public PersonalDetail	getStudentPersonalDetail(String studentId, String studentNo, Locale locale ) throws NoDBRecordException;
	
	/**
	 * 
	 * method name  : getStudentAcademicDetail
	 * @param studentId
	 * @param studentNo TODO
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:22:11 AM
	 * @throws NotCorrectDBRecordException 
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, String studentNo, Locale locale ) throws NoDBRecordException, NotCorrectDBRecordException;
	
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
	 * method name  : getHigherApprover
	 * @param studentNo
	 * @param formName
	 * @param roleName
	 * @param isSequenceRequired
	 * @return
	 * DpsDbImpl
	 * return type  : Approver
	 * 
	 * purpose		: Get higher approver (at intial and final case it's same approver)
	 *
	 * Date    		:	Jul 16, 2017 11:59:33 AM
	 */
	public Approver getHigherApprover(String studentNo, String formName, String roleName, String isSequenceRequired);
	
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
}
