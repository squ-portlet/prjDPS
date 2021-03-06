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
 * File Name			:	IncompleteGradeService.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.service
 * Date of creation		:	Jan 3, 2018  9:18:51 AM
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

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.model.IncompleteGradeModel;

/**
 * @author Bhabesh
 *
 */
public interface IncompleteGradeService
{
	/**
	 * 
	 * method name  : getCourseList
	 * @param employeeNo
	 * @param locale
	 * @return
	 * IncompleteGradeService
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 3, 2018 3:22:51 PM
	 */
	public List<GradeIncompleteDTO> getCourseList( String employeeNo, Locale	locale);
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param employeeNo
	 * @param lAbrCourseNo
	 * @param sectionNo
	 * @param locale
	 * @return
	 * IncompleteGradeService
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: Get Student List
	 *
	 * Date    		:	Jan 8, 2018 6:34:47 PM
	 */
	public List<GradeIncompleteDTO> getStudentList(String employeeNo, String lAbrCourseNo,String sectionNo, Locale	locale);
	
	/**
	 * 
	 * method name  : setInstructorNotifyForIncompleteGrade
	 * @param dto
	 * @param locale TODO
	 * @return
	 * @throws NotCorrectDBRecordException
	 * IncompleteGradeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert Notification applied by Instructor 
	 *
	 * Date    		:	Jan 11, 2018 4:57:17 PM
	 */
	public GradeIncompleteDTO setInstructorNotifyForIncompleteGrade(GradeIncompleteDTO dto, Locale locale ) throws NotCorrectDBRecordException;

	/**
	 * 
	 * method name  : getIncompleteNotifyHistory
	 * @param recordSequence
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * IncompleteGradeService
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: Incomplete History requested by Instructor
	 *
	 * Date    		:	Jan 15, 2018 12:42:54 PM
	 */
	public List<GradeIncompleteDTO>  getIncompleteNotifyHistory(String recordSequence,  Locale locale) throws NoDBRecordException;

	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * IncompleteGradeService
	 * return type  : List<Student>
	 * 
	 * purpose		: Get related students for specific approvers 
	 *
	 * Date    		:	Jan 17, 2018 11:23:26 AM
	 */
	public List<Student> getStudentDetailsForApprovers(String roleType,  Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : getCourseListForNotify
	 * @param studentNo
	 * @param studentStatCode
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * IncompleteGradeService
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 18, 2018 3:20:03 PM
	 */
	public List<GradeIncompleteDTO> getCourseListForNotify(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : setIncompleteGradeNotifyApproval
	 * @param incompleteGradeModel
	 * @param employee
	 * @param request
	 * @param locale
	 * @return
	 * IncompleteGradeService
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 23, 2018 3:02:09 PM
	 */
	public List<GradeIncompleteDTO> setIncompleteGradeNotifyApproval(IncompleteGradeModel incompleteGradeModel, Employee employee, PortletRequest request, Locale locale);
	
	/**
	 * 
	 * method name  : isRuleComplete
	 * @return
	 * IncompleteGradeService
	 * return type  : boolean
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 4, 2018 8:56:08 AM
	 */
	public boolean isRuleComplete();
	
	
}
