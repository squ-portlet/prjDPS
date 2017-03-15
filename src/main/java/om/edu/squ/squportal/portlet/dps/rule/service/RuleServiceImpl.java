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
 * File Name			:	RuleServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.service
 * Date of creation		:	Mar 13, 2017  4:43:38 PM
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
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class RuleServiceImpl implements Rule
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RuleDbDao	ruleDbDao;
	
	/**
	 * 
	 * method name  : lastSemester
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is student is in Last semester 
	 *
	 * Date    		:	Mar 13, 2017 7:49:10 PM
	 */
	public boolean lastSemester(String studentNo, String stdStatCode)
	{
		StudentCompletionAndJoinTime	completionAndJoinTime	=	ruleDbDao.getJoinAndCloseTime(studentNo, stdStatCode);
		YearSemester					yearSemester			=	getCurrentYearSemester();
		int 	totalSem		=	completionAndJoinTime.getEstimatedSemesters();
		int		fromStartYear	=	completionAndJoinTime.getFromCCYrCode();
		int		fromStartSem	=	completionAndJoinTime.getFromSemCode();
		int		currYear		=	yearSemester.getYear();
		int		currSemester	=	yearSemester.getSemester();
		
		int 	countSem		=	0;
		int		countTotal		=	0;
		int		countPostpone	=	countPostpone(studentNo, stdStatCode);

		int s =0;
		
		for(int x=fromStartYear; x<currYear; x++)
		{
			int p = 0;
			
			if(x==fromStartYear)
			{
				p = fromStartSem;
			}
			else
			{
				p = 2;
			}

			for(int y=p; y<=4; y++)
			{
				s++;
				if(s==10) break;
				
				if(y!=3)
				{
					countSem++;
				}
			}
		}
		
		if(currSemester==2)
		{
			countSem++;
		}
		else if (currSemester==4) {
			countSem = countSem + 2;
		}
		
		countTotal	=	countSem - countPostpone;

		return (totalSem==countTotal)?true:false;
	}

	
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
	public boolean isStudentHasThesis(String studentNo, String stdStatCode)
	{
		 return (ruleDbDao.getThesisCode(studentNo, stdStatCode)==0)?false:true;
	}
	
	
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
	public boolean isSemesterCompleted(String studentNo, String stdStatCode, String seminarAbrCode)
	{
		int thesisCode = getThesisCode(studentNo, stdStatCode);
		return (ruleDbDao.getSeminarCount(studentNo, thesisCode, seminarAbrCode)==0?false:true);
	}

	/**
	 * 
	 * method name  : isCurrentDateInSpecificWeek
	 * @param weekNumber
	 * @return
	 * RuleServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Find whether the current date is within specified week
	 *
	 * Date    		:	Mar 15, 2017 4:53:42 PM
	 */
	public boolean isCurrentDateInSpecificWeek(String weekNumber)
	{
		return (ruleDbDao.getCurrentDateInSpecificWeek(weekNumber) == 0) ?false:true;
	}
	
	/**
	 * 
	 * method name  : getThesisCode
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * RuleServiceImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 15, 2017 12:15:34 PM
	 */
	private	int getThesisCode(String studentNo, String stdStatCode)
	{
		return ruleDbDao.getThesisCode(studentNo, stdStatCode);
	}
	
	
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
	private int countPostpone(String studentNo, String stdStatCode)
	{
		return ruleDbDao.countPostpone(studentNo, stdStatCode);
	}
	
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
	private YearSemester	getCurrentYearSemester()
	{
		return ruleDbDao.getCurrentYearSemester();
	}
	
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
	public boolean isExtensionRecordAlreadyExist(String studentNo, String stdStatCode)
	{
		return (ruleDbDao.extensionRecordAlreadyExist(studentNo, stdStatCode)!=0?true:false);
	}
	
	
}
