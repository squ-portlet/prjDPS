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
 * File Name			:	Rule.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.service
 * Date of creation		:	Mar 13, 2017  7:48:26 PM
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
package om.edu.squ.squportal.portlet.dps.rule.service;

import om.edu.squ.squportal.portlet.dps.rule.bo.StudentCompletionAndJoinTime;
import om.edu.squ.squportal.portlet.dps.rule.bo.WithdrawPeriod;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;

/**
 * @author Bhabesh
 *
 */
public interface Rule
{
	
	/**
	 * 
	 * method name  : getJoinAndCloseTime
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * Rule
	 * return type  : StudentCompletionAndJoinTime
	 * 
	 * purpose		: Get Joining and estimated total number of semester to completion of the course
	 *
	 * Date    		:	Jan 16, 2019 8:35:40 AM
	 */
	public StudentCompletionAndJoinTime getJoinAndCloseTime(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : isLanguageCourseTaken
	 * @param studentNo
	 * @param currentYear
	 * @param courseStartYear
	 * @param courseStartSemester
	 * @return
	 * RuleDbDao
	 * return type  : boolean
	 * 
	 * purpose		: find out possibility of have language course taken by student
	 *
	 * Date    		:	Dec 24, 2018 5:12:17 PM
	 */
	public boolean isLanguageCourseTaken(String studentNo, int currentYear, int courseStartYear, int courseStartSemester );
	
	/**
	 * 
	 * method name  : lastSemester
	 * @param studentNo
	 * @param stdStatCode
	 * @param NumberOfDaysAdjust
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is student is in Last semester 
	 *
	 * Date    		:	Mar 13, 2017 7:49:10 PM
	 */
	public boolean lastSemester(String studentNo, String stdStatCode, String NumberOfDaysAdjust);
	
	/**
	 * 
	 * method name  : isStudentHasThesis
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Mar 15, 2017 10:44:13 AM
	 */
	public boolean isStudentHasThesis(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : isSemesterCompleted
	 * @param studentNo
	 * @param stdStatCode
	 * @param seminarAbrCode
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: is particular seminar completed
	 *
	 * Date    		:	Mar 15, 2017 12:25:12 PM
	 */
	public boolean isSemesterCompleted(String studentNo, String stdStatCode, String seminarAbrCode);
	
	/**
	 * 
	 * method name  : isCurrentDateInSpecificWeek
	 * @param weekNumber
	 * @param numberOfDaysAdjust
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Find whether the current date is within specified week
	 *
	 * Date    		:	Mar 15, 2017 4:53:42 PM
	 */
	public boolean isCurrentDateInSpecificWeek(String weekNumber, String numberOfDaysAdjust);
	
	/**
	 * 
	 * method name  : getRuleLastYearSemester
	 * @param NumberOfDaysAdjust
	 * @return
	 * RuleServiceImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get the year semester based on sysdate 
	 * 					It helps when semester over but officially another semester doesn't start
	 *
	 * Date    		:	Jan 21, 2019 5:11:45 PM
	 */
	public YearSemester	getRuleLastYearSemester(String NumberOfDaysAdjust);

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
	 * method name  : countPostpone
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleServiceImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 14, 2017 1:08:11 PM
	 */
	public int countPostpone(String studentNo, String stdStatCode);
	
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
	public boolean isExtensionRecordAlreadyExist(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : isDropwTotalRegisteredCreditRuleExist
	 * @param totalRegisteredCredit
	 * @param selectedCourseCredit
	 * @param studyModeType
	 * @param sectNo TODO
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		:	Rule for number of total registered credits to be remain with students after drop with w
	 *
	 * Date    		:	Aug 16, 2017 4:00:37 PM
	 */
	public boolean isDropwTotalRegisteredCreditRuleExist(int totalRegisteredCredit,  int selectedCourseCredit, String studyModeType, String sectNo);
	
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
	
	/**
	 * 
	 * method name  : getWithdrawPeriod
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * Rule
	 * return type  : WithdrawPeriod
	 * 
	 * purpose		: Get first and second withdraw period
	 *
	 * Date    		:	Jan 31, 2019 5:08:48 PM
	 */
	public WithdrawPeriod	getWithdrawPeriod(String studentNo, String stdStatCode);
	
	/**
	 * 
	 * method name  : isCourseThesis
	 * @param studentNo
	 * @param courseNo
	 * @return
	 * RuleDbDao
	 * return type  : boolean
	 * 
	 * purpose		: Check the course is a thesis course or not
	 *
	 * Date    		:	Jan 30, 2019 2:34:48 PM
	 */
	public boolean isCourseThesis(String studentNo, String courseNo);
	
	/**
	 * 
	 * method name  : isSemesterExtended
	 * @param stdStatCode
	 * @param courseYear
	 * @param semester
	 * @return
	 * Rule
	 * return type  : boolean
	 * 
	 * purpose		: Check whether a particular semester of a given year extended by a student or not
	 *                  Normally this helps to decide one rule of postpone, whether a student is not allowed to postpone 
	 *                  a semester which he/she already extended
	 *
	 * Date    		:	Mar 3, 2019 12:03:22 PM
	 */
	public boolean isSemesterExtended(String stdStatCode, String courseYear, String semester);
}
