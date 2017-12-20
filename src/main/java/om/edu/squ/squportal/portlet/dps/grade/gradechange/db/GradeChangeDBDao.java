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
 * File Name			:	GradeChangeDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.db
 * Date of creation		:	Nov 13, 2017  3:42:02 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.db;

import java.util.List;
import java.util.Locale;

import org.springframework.transaction.annotation.Transactional;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;

/**
 * @author Bhabesh
 *
 */
public interface GradeChangeDBDao
{
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param isRuleGradeChangeTimingFollowed TODO
	 * @param gradeDTO TODO
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO>	getStudentGrades(boolean isRuleGradeChangeTimingFollowed, GradeDTO gradeDTO, String employeeNo, Locale locale) throws NoDBRecordException;
	
	
	/**
	 * 
	 * method name  : getGrades
	 * @param lAbrCourseNo TODO
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Grade>
	 * 
	 * purpose		: list of all grade values
	 *
	 * Date    		:	Nov 19, 2017 1:44:54 PM
	 */
	public List<Grade> getGrades(String lAbrCourseNo, Locale locale);
	
	/**
	 * 
	 * method name  : getGradeHistory
	 * @param isRuleGradeChangeTimingFollowed TODO
	 * @param dto
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:36:02 PM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO> getGradeHistory(boolean isRuleGradeChangeTimingFollowed, GradeDTO dto, Locale locale) throws NoDBRecordException;
	
	/**
	 * 
	 * method name  : setInstructorApplyForGradeChange
	 * @param dto
	 * @return
	 * GradeChangeDBImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 12:32:15 PM
	 * @throws NotCorrectDBRecordException 
	 */
	public int setInstructorApplyForGradeChange(GradeDTO dto) throws NotCorrectDBRecordException;
	
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBDao
	 * return type  : List<Student>
	 * 
	 * purpose		: Get list of Students details who applied for grade change
	 *
	 * Date    		:	Dec 5, 2017 8:03:58 PM
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
	 * purpose		: List 
	 *
	 * Date    		:	Dec 6, 2017 8:26:06 PM
	 */
	public List<GradeDTO> getCourseListForGradeChange(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : setGradeChangeApproval
	 * @param gradeDTO
	 * @return
	 * GradeChangeDBImpl
	 * return type  : int
	 * 
	 * purpose		: update the status / comment for approval process
	 *
	 * Date    		:	Dec 11, 2017 8:27:04 AM
	 */
	@Transactional
	public int setGradeChangeApproval(GradeDTO gradeDTO);

	/**
	 * 
	 * method name  : getCourseList
	 * @param isRuleGradeChangeTimingFollowed
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
	public List<GradeDTO> getCourseList(boolean isRuleGradeChangeTimingFollowed, String employeeNo, Locale	locale);
	
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
	public List<Student> getStudentList(boolean isRuleGradeChangeTimingFollowed, String employeeNo,String lAbrCourseNo,  Locale	locale);
	
}
