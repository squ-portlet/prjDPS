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
 * File Name			:	UniversityWithdrawDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db
 * Date of creation		:	Feb 4, 2018  8:49:19 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.CodeValue;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO;

/**
 * @author Bhabesh
 *
 */
public interface UniversityWithdrawDBDao
{
	
	/**
	 * 
	 * method name  : canStudentApply
	 * @return
	 * UniversityWithdrawDBDao
	 * return type  : boolean
	 * 
	 * purpose		: If some one rejects the application then student is eligible to apply again;
	 *
	 * Date    		:	Mar 8, 2018 2:57:25 PM
	 */
	public boolean canStudentApply();
	
	/**
	 * 
	 * method name  : getReasons
	 * @param isStudent
	 * @param locale
	 * @return
	 * UniversityWithdrawDBDao
	 * return type  : List<CodeValue>
	 * 
	 * purpose		: List of reasons
	 *
	 * Date    		:	Feb 5, 2018 11:55:47 AM
	 */
	public List<CodeValue>  getReasons(boolean isStudent, Locale locale );
	

	/**
	 * 
	 * method name  : setUniversityWithdrawByStudent
	 * @param sequenceNumber TODO
	 * @param dto
	 * @return
	 * UniversityWithdrawDBDao
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 12, 2018 2:15:55 PM
	 */
	int setUniversityWithdrawByStudent(Double sequenceNumber, UniversityWithdrawDTO dto);
	

	/**
	 * 
	 * method name  : getUniversityWithdrawDataForStudent
	 * @param studentNo
	 * @param locale
	 * @return
	 * UniversityWithdrawDBDao
	 * return type  : List<UniversityWithdrawDTO>
	 * 
	 * purpose		: Get records related with status of an individual student's withdrawal from University
	 *
	 * Date    		:	Mar 6, 2018 12:18:09 PM
	 */
	public List<UniversityWithdrawDTO> getUniversityWithdrawDataForStudent(String studentNo, Locale locale);
}
