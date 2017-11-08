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
 * File Name			:	PostponeDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.db
 * Date of creation		:	May 25, 2017  2:04:05 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.db;

import java.util.List;
import java.util.Locale;

import org.springframework.transaction.annotation.Transactional;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeDTO;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;

/**
 * @author Bhabesh
 *
 */
public interface PostponeDBDao 
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
	 * @param dto
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert to postpone as student
	 *
	 * Date    		:	Aug 7, 2017 5:00:53 PM
	 */
	public int setPostponeByStudent(PostponeDTO dto);
	
	/**
	 * 
	 * method name  : getPostponesForStudents
	 * @param studentNo
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: List of postponed studies requested by a particular student
	 *
	 * Date    		:	Aug 10, 2017 9:40:55 AM
	 */
	public List<PostponeDTO> getPostponesForStudents(String studentNo, Locale locale);
	
	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @param studentNo
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: List of student's postpone details using employee role
	 *
	 * Date    		:	Sep 13, 2017 4:48:56 PM
	 */
	public List<PostponeDTO> getPostponeForApprovers(String roleType, Employee employee, Locale locale, String studentNo);
	
	/**
	 * 
	 * method name  : setPostponeStatusOfStudent
	 * @param dto
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Update status of postpone
	 *
	 * Date    		:	Nov 7, 2017 5:51:48 PM
	 */
	public int setPostponeStatusOfStudent(PostponeDTO dto);
}
