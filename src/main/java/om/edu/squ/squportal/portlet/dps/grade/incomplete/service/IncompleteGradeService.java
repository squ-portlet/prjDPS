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

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;

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
	 * @return
	 * @throws NotCorrectDBRecordException
	 * IncompleteGradeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert Notification applied by Instructor 
	 *
	 * Date    		:	Jan 11, 2018 4:57:17 PM
	 */
	public String setInstructorNotifyForIncompleteGrade(GradeIncompleteDTO dto ) throws NotCorrectDBRecordException;
	
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
