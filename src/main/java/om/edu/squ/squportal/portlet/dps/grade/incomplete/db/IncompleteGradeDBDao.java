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
 * File Name			:	IncompleteGradeDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.db
 * Date of creation		:	Jan 3, 2018  9:23:55 AM
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.db;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;

/**
 * @author Bhabesh
 *
 */
public interface IncompleteGradeDBDao
{
	/**
	 * 
	 * method name  : getCourseList
	 * @param isRuleGradeChangeTimingFollowed TODO
	 * @param employeeNo
	 * @param locale
	 * @return
	 * IncompleteGradeDBDao
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: Fetch Course List
	 *
	 * Date    		:	Jan 3, 2018 3:11:15 PM
	 */
	public List<GradeIncompleteDTO> getCourseList( boolean isRuleGradeChangeTimingFollowed, String employeeNo, Locale	locale);
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param isRuleGradeChangeTimingFollowed
	 * @param employeeNo
	 * @param lAbrCourseNo
	 * @param sectionNo
	 * @param locale
	 * @return
	 * IncompleteGradeDBDao
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: Get Student List
	 *
	 * Date    		:	Jan 8, 2018 6:31:43 PM
	 */
	public List<GradeIncompleteDTO> getStudentList(boolean isRuleGradeChangeTimingFollowed, String employeeNo,String lAbrCourseNo, String sectionNo, Locale	locale);
	
	/**
	 * 
	 * method name  : setInstructorNotifyForIncompleteGrade
	 * @param sequenceNo TODO
	 * @param dto
	 * @return
	 * @throws NotCorrectDBRecordException
	 * IncompleteGradeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert Notification applied by Instructor 
	 *
	 * Date    		:	Jan 11, 2018 4:57:17 PM
	 */
	public int setInstructorNotifyForIncompleteGrade(double sequenceNo, GradeIncompleteDTO dto ) throws NotCorrectDBRecordException;
	
	/**
	 * 
	 * method name  : getInstructorComments
	 * @param sequenceNo
	 * @return
	 * IncompleteGradeDBDao
	 * return type  : String
	 * 
	 * purpose		:	Get Instructor's comments
	 *
	 * Date    		:	Jan 28, 2018 4:12:40 PM
	 */
	public String getInstructorComments(double sequenceNo);
	
	/**
	 * 
	 * method name  : getIncompleteNotifyHistory
	 * @param recordSequence TODO
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * IncompleteGradeDBDao
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Jan 15, 2018 9:07:52 AM
	 */
	public List<GradeIncompleteDTO>  getIncompleteNotifyHistory(String recordSequence, Locale locale) throws NoDBRecordException;
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * IncompleteGradeDBDao
	 * return type  : List<Student>
	 * 
	 * purpose		:	Get related students for specific approvers 
	 *
	 * Date    		:	Jan 17, 2018 11:11:03 AM
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
	 * IncompleteGradeDBDao
	 * return type  : List<GradeIncompleteDTO>
	 * 
	 * purpose		: course/s for notification of particualr student
	 *
	 * Date    		:	Jan 18, 2018 3:02:01 PM
	 */
	public List<GradeIncompleteDTO> getCourseListForNotify(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : setIncompleteGradeNotifyApproval
	 * @param gradeIncompleteDTO
	 * @return
	 * IncompleteGradeDBDao
	 * return type  : int
	 * 
	 * purpose		:  updation of status of approve/reject by approval 
	 *
	 * Date    		:	Jan 23, 2018 1:23:43 PM
	 */
	public int setIncompleteGradeNotifyApproval(GradeIncompleteDTO gradeIncompleteDTO);
}
