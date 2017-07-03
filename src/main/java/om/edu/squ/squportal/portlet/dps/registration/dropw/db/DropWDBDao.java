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
 * File Name			:	DropWDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.db
 * Date of creation		:	Mar 30, 2017  8:51:08 AM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.db;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotSuccessFulDBUpdate;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;

/**
 * @author Bhabesh
 *
 */
public interface DropWDBDao
{
	/**
	 * 
	 * method name  : getCourseList
	 * @param student
	 * @param locale
	 * @param studentMode TODO
	 * @param isWithdrawPeriodRule TODO
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(Student student, Locale locale, String studentMode, String isWithdrawPeriodRule);
	/**
	 * 
	 * method name  : getCourseList
	 * @param studentNo
	 * @param studentStatCode
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses relates with drop with w from temp/helper table
	 *
	 * Date    		:	Apr 11, 2017 5:33:34 PM
	 */
	public List<DropWDTO> getCourseList(String studentNo, String studentStatCode, Locale locale);
	/**
	 * 
	 * method name  : setTempDropWCourse
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: Add a record in temporary table for further progress to drop the course 
	 *
	 * Date    		:	Apr 10, 2017 7:13:47 PM
	 */
	public int setTempDropWCourseAdd(DropWDTO dropWDTO);
	
	/**
	 * 
	 * method name  : getDropWForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @param studentNo
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get List of student records for courses to be dropped 
	 *
	 * Date    		:	Apr 17, 2017 8:24:28 PM
	 * @throws NoDBRecordException 
	 */
	public List<DropWDTO> getDropWForApprovers(String roleType, Employee employee, Locale locale, String studentNo) throws NoDBRecordException;
	
	/**
	 * 
	 * method name  : setDropWCourseUpdate
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in drop w
	 *
	 * Date    		:	May 2, 2017 10:59:22 AM
	 * @throws NotSuccessFulDBUpdate 
	 */
	public int setDropWCourseUpdate(DropWDTO dropWDTO) throws NotSuccessFulDBUpdate;
}
