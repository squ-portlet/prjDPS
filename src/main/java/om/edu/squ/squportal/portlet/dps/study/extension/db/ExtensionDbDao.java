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
 * File Name			:	ExtensionDbDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.db
 * Date of creation		:	Jan 16, 2017  9:55:24 AM
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
package om.edu.squ.squportal.portlet.dps.study.extension.db;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionReason;

/**
 * @author Bhabesh
 *
 */
public interface ExtensionDbDao
{
	/**
	 * 
	 * method name  : getExtensionReasons
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionReason>
	 * 
	 * purpose		: Get list of extensions
	 *
	 * Date    		:	Jan 16, 2017 4:52:14 PM
	 */
	public List<ExtensionReason>  getExtensionReasons(Locale locale);
	
	
	
	/**
	 * 
	 * method name  : setExtensionByStudent
	 * @param extensionDTO
	 * @return
	 * ExtensionDbImpl
	 * return type  : int
	 * 
	 * purpose		:	Insert to extension as student
	 *
	 * Date    		:	Jan 24, 2017 2:02:28 PM
	 */
	public int setExtensionByStudent(ExtensionDTO extensionDTO );

	/**
	 * 
	 * method name  : setExtensionStatusOfStudent
	 * @param extensionDTO
	 * @return
	 * ExtensionDbImpl
	 * return type  : int
	 * 
	 * purpose		: Update the status of extension
	 *
	 * Date    		:	Mar 1, 2017 4:45:34 PM
	 */
	public int setExtensionStatusOfStudent(ExtensionDTO extensionDTO);
	
	/**
	 * 
	 * method name  : getExtensionsForStudents
	 * @param studentNo
	 * @param studentStatCode 
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 7, 2017 3:51:38 PM
	 */
	public List<ExtensionDTO> getExtensionsForStudents(String studentNo, String studentStatCode, Locale locale);
	
	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @param studentNo TODO
	 * @param applyDelegation TODO
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		: Get list of students for approvers
	 *
	 * Date    		:	Feb 15, 2017 10:09:55 PM
	 */
	public List<ExtensionDTO> getExtensionsForApprovers(String roleType, Employee employee, Locale locale, String studentNo, boolean applyDelegation);
}
