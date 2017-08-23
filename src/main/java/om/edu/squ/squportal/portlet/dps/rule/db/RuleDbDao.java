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
 * File Name			:	RuleDbDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.db
 * Date of creation		:	Mar 13, 2017  4:19:39 PM
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
package om.edu.squ.squportal.portlet.dps.rule.db;

import om.edu.squ.squportal.portlet.dps.rule.bo.StudentCompletionAndJoinTime;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;

/**
 * @author Bhabesh
 *
 */
public interface RuleDbDao
{
	/**
	 * 
	 * method name  : getJoinAndCloseTime
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleDbImpl
	 * return type  : StudentCompletionAndJoinTime
	 * 
	 * purpose		: Get Joining and estimated total number of semester to completion of the course
	 *
	 * Date    		:	Mar 13, 2017 4:15:07 PM
	 */
	public StudentCompletionAndJoinTime getJoinAndCloseTime(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : countPostpone
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Count number of records (semesters) in postpone
	 *
	 * Date    		:	Mar 13, 2017 6:30:31 PM
	 */
	public int countPostpone(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : getCurrentYearSemester
	 * @return
	 * RuleDbImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get Current year sem
	 *
	 * Date    		:	Mar 14, 2017 12:51:58 PM
	 */
	public YearSemester	getCurrentYearSemester();
	
	/**
	 * 
	 * method name  : getThesisCode
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Get thesis code (0 for none)
	 *
	 * Date    		:	Mar 15, 2017 9:15:15 AM
	 */
	public int getThesisCode(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : getSeminarCount
	 * @param studentNo
	 * @param thesisCode
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Get number of records for available particular seminar in thesis
	 *
	 * Date    		:	Mar 15, 2017 9:38:18 AM
	 */
	public int getSeminarCount(String studentNo, int thesisCode, String seminarCodeName);
	
	/**
	 * 
	 * method name  : getCurrentDateInSpecificWeek
	 * @param weekNumber
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Find whether the date is within specified week 
	 *
	 * Date    		:	Mar 15, 2017 4:41:48 PM
	 */
	public int getCurrentDateInSpecificWeek(String weekNumber);
	
	/**
	 * *********** Specific service related query which affects rules ************************ 
	 */
	
	/**
	 * 
	 * method name  : extensionRecordAlreadyExist
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Find student records which already accepted, modified/in progress/ or in pending status
	 *                if such records available, students might not get an opportunity to apply for extension again
	 *
	 * Date    		:	Mar 15, 2017 6:51:07 PM
	 */
	public int extensionRecordAlreadyExist(String studentNo, String stdStatCode);
	
	
	/**
	 * 
	 * method name  : isDropWPeriod
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: whether the period is within drop w period 
	 *
	 * Date    		:	Aug 20, 2017 4:46:22 PM
	 */
	public boolean isDropWPeriod(String studentNo, String stdStatCode);
	
}
