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
 * File Name			:	UniversityWithdrawService.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service
 * Date of creation		:	Feb 4, 2018  8:50:49 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.CodeValue;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO;

/**
 * @author Bhabesh
 *
 */
public interface UniversityWithdrawService 
{
	
	/**
	 * 
	 * method name  : canStudentApply
	 * @return
	 * UniversityWithdrawService
	 * return type  : boolean
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 13, 2018 1:21:34 PM
	 */
	public boolean canStudentApply();
	
	/**
	 * 
	 * method name  : getReasons
	 * @param isStudent
	 * @param locale
	 * @return
	 * UniversityWithdrawService
	 * return type  : List<CodeValue>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 5, 2018 11:57:26 AM
	 */
	public List<CodeValue>  getReasons(boolean isStudent, Locale locale );
	
	/**
	 * 
	 * method name  : setUniversityWithdrawByStudent
	 * @param dto
	 * @param locale
	 * @return
	 * UniversityWithdrawService
	 * return type  : UniversityWithdrawDTO
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 19, 2018 2:05:07 PM
	 */
	public List<UniversityWithdrawDTO> setUniversityWithdrawByStudent(UniversityWithdrawDTO dto, Locale locale );
	
	/**
	 * 
	 * method name  : getUniversityWithdrawDataForStudent
	 * @param studentNo
	 * @param locale
	 * @return
	 * UniversityWithdrawService
	 * return type  : List<UniversityWithdrawDTO>
	 * 
	 * purpose		: Get records related with status of an individual student's withdrawal from University
	 *
	 * Date    		:	Mar 6, 2018 12:26:59 PM
	 */
	public List<UniversityWithdrawDTO> getUniversityWithdrawDataForStudent(String studentNo, Locale locale);
}
