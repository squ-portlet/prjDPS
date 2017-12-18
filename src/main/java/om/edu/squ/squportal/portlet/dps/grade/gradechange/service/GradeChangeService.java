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
 * File Name			:	GradeChangeService.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.service
 * Date of creation		:	Nov 13, 2017  3:37:46 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.service;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;

/**
 * @author Bhabesh
 *
 */
public interface GradeChangeService
{
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param employeeNo
	 * @param locale
	 * @param gradeChangeModel TODO
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO>	getStudentGrades(String employeeNo, Locale locale, GradeChangeModel gradeChangeModel) throws NoDBRecordException;
	
	
	/**
	 * 
	 * method name  : getGrades
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Grade>
	 * 
	 * purpose		: list of all grade values
	 *
	 * Date    		:	Nov 19, 2017 1:44:54 PM
	 */
	public List<Grade> getGrades(Locale locale);
	
	/**
	 * 
	 * method name  : getGradeHistory
	 * @param gradeChangeModelHistory
	 * @param locale
	 * @return
	 * GradeChangeService
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:53:00 PM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO> getGradeHistory(GradeChangeModel gradeChangeModelHistory, Locale locale) throws NoDBRecordException;


	/**
	 * 
	 * method name  : instructorApplyForGradeChange
	 * @param gradeChangeModel
	 * @param request
	 * GradeChangeService
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 1:59:05 PM
	 * @param locale TODO
	 * @return 
	 */
	public List<GradeDTO> instructorApplyForGradeChange(GradeChangeModel gradeChangeModel, ResourceRequest request, Locale locale);
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param gradeDTO
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: Get list of Students details who applied for grade change
	 *
	 * Date    		:	Dec 5, 2017 1:06:57 AM
	 */
	public List<Student> getStudentDetailsForApprovers(String roleType,  Employee employee, Locale locale);
	
	/**
	 * 	
	 * method name  : getCourseListForGradeChange
	 * @param studentNo
	 * @param studentStatCode
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: List of courses with grade change request and their approval details 
	 *
	 * Date    		:	Dec 6, 2017 8:26:06 PM
	 */
	public List<GradeDTO> getCourseListForGradeChange(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : setGradeChangeApproval
	 * @param gradeChangeModel
	 * @param employee
	 * @param portletRequest
	 * @param locale
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: update the status / comment for approval process and fetch data to populate
	 *
	 * Date    		:	Dec 11, 2017 11:04:47 PM
	 */
	public List<GradeDTO> setGradeChangeApproval(GradeChangeModel gradeChangeModel, Employee employee, PortletRequest portletRequest, Locale locale );
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: Get List of Courses of a faculty
	 *
	 * Date    		:	Dec 14, 2017 1:10:14 PM
	 */
	public List<GradeDTO> getCourseList(String employeeNo, Locale	locale);
	/**
	 * 
	 * method name  : getStudentList
	 * @param isRuleGradeChangeTimingFollowed
	 * @param employeeNo
	 * @param lAbrCourseNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Student>
	 * 
	 * purpose		: List of Students teached by a faculty for a particular course at particular time
	 *
	 * Date    		:	Dec 14, 2017 3:39:51 PM
	 */
	public List<Student> getStudentList( String employeeNo,String lAbrCourseNo,  Locale	locale);
	
	/**
	 * 
	 * method name  : isRuleComplete
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rule for Grade Change
	 *
	 * Date    		:	Dec 14, 2017 1:11:15 PM
	 */
	public boolean isRuleComplete();
}
