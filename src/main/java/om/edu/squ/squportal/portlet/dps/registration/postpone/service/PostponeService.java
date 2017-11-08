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
 * File Name			:	PostponeService.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.service
 * Date of creation		:	May 25, 2017  2:24:24 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeDTO;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;

/**
 * @author Bhabesh
 *
 */
public interface PostponeService
{
	/**
	 * 
	 * method name  : getPostponeReasons
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeReason>
	 * 
	 * purpose		: Get list of default reasons for postpone 
	 *
	 * Date    		:	May 25, 2017 4:15:05 PM
	 */
	public List<PostponeReason> getPostponeReasons(Locale locale);
	
	/**
	 * 
	 * method name  : setPostponeByStudent
	 * @param student 
	 * @param studentModel
	 * @param userName
	 * @param locale 
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert to postpone as student
	 *
	 * Date    		:	Aug 7, 2017 5:00:53 PM
	 */
	public List<PostponeDTO> setPostponeByStudent(Student student, PostponeStudentModel studentModel, String userName, Locale locale);
	
	
	/**
	 * 
	 * method name  : getPostponeForAprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * PostponeServiceImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: Get List of student postpone data for approver role
	 *
	 * Date    		:	Sep 13, 2017 5:13:02 PM
	 */
	public List<PostponeDTO> getPostponeForAprovers(String roleType, Employee employee, Locale locale);
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param dto
	 * @param employee
	 * @param locale
	 * @return
	 * PostponeServiceImpl
	 * return type  : PostponeDTO
	 * 
	 * purpose		: add record for approval / add record in approval transaction table
	 * Note			: This function relates with two different transactional statements
	 *
	 * Date    		:	Nov 7, 2017 5:55:12 PM
	 */
	public PostponeDTO setRoleTransaction(PostponeDTO dto, Employee employee, Locale locale);
}
