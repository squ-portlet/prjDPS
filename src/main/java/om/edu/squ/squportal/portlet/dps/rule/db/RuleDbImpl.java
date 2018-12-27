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
 * File Name			:	RuleDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.db
 * Date of creation		:	Mar 13, 2017  2:52:04 PM
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.rule.bo.StudentCompletionAndJoinTime;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class RuleDbImpl implements RuleDbDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	NamedParameterJdbcTemplate	nPJdbcTemplDps;
	private	Properties					queryPropsCommonRule;
	/**
	 * Setter method : setnPJdbcTemplDps
	 * @param nPJdbcTemplDps the nPJdbcTemplDps to set
	 * 
	 * Date          : Mar 13, 2017 3:13:34 PM
	 */
	public void setnPJdbcTemplDps(NamedParameterJdbcTemplate nPJdbcTemplDps)
	{
		this.nPJdbcTemplDps = nPJdbcTemplDps;
	}
	/**
	 * Setter method : setQueryPropsCommonRule
	 * @param queryPropsCommonRule the queryPropsCommonRule to set
	 * 
	 * Date          : Mar 13, 2017 3:13:34 PM
	 */
	public void setQueryPropsCommonRule(Properties queryPropsCommonRule)
	{
		this.queryPropsCommonRule = queryPropsCommonRule;
	}
	
	
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
	public StudentCompletionAndJoinTime getJoinAndCloseTime(String studentNo, String stdStatCode)
	{

		String	SQL_RULE_STUDENT_JOIN_CLOSE_TIME		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_JOIN_CLOSE_TIME);
		RowMapper<StudentCompletionAndJoinTime> mapper	= new RowMapper<StudentCompletionAndJoinTime>()
		{
			
			@Override
			public StudentCompletionAndJoinTime mapRow(ResultSet rs, int rowNum)
					throws SQLException
			{
				StudentCompletionAndJoinTime	studentCompletionAndJoinTime	=	new StudentCompletionAndJoinTime();
				studentCompletionAndJoinTime.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				studentCompletionAndJoinTime.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				studentCompletionAndJoinTime.setEstimatedSemesters(rs.getInt(Constants.CONST_COLMN_DGR_GRAD_ESTIMATE_SEM_COUNT));
				studentCompletionAndJoinTime.setMaximumSemesters(rs.getInt(Constants.CONST_COLMN_DGR_GRAD_MAXIMUM_SEM_COUNT));
				studentCompletionAndJoinTime.setFromCCYrCode(rs.getInt(Constants.COST_COL_DPS_FROM_COURSE_YEAR_CODE));
				studentCompletionAndJoinTime.setFromSemCode(rs.getInt(Constants.COST_COL_DPS_FROM_SEMESTER_CODE));
				studentCompletionAndJoinTime.setCurrentYear(rs.getInt(Constants.COST_COL_DPS_CURRENT_YEAR));
				return studentCompletionAndJoinTime;
			}
		};
		
		
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		return nPJdbcTemplDps.queryForObject(SQL_RULE_STUDENT_JOIN_CLOSE_TIME, mapParamsRule, mapper);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#isLanguageCourseTaken(java.lang.String, int, int, int)
	 */
	public boolean isLanguageCourseTaken(String studentNo, int currentYear, int courseStartYear, int courseStartSemester )
	{
		String	SQL_RULE_STUDENT_LANGUAGE_COURSE_TAKEN		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_LANGUAGE_COURSE_TAKEN);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramCurrentYear", String.valueOf(currentYear));
		mapParamsRule.put("paramFromCourseYear", String.valueOf(courseStartYear));
		mapParamsRule.put("paramFromSemester", String.valueOf(courseStartSemester));
		
		return (nPJdbcTemplDps.queryForInt(SQL_RULE_STUDENT_LANGUAGE_COURSE_TAKEN, mapParamsRule)>0)?true:false;
	}
	
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
	public int countPostpone(String studentNo, String stdStatCode)
	{
		String	SQL_RULE_STUDENT_POSTPONE_COUNT		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_POSTPONE_COUNT);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_STUDENT_POSTPONE_COUNT, mapParamsRule);
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
	public YearSemester	getCurrentYearSemester()
	{
		String	SQL_RULE_CURRENT_YEAR_SEMESTER		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_CURRENT_YEAR_SEMESTER);
		
		RowMapper<YearSemester> 	rowMapper		=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester	yearSemester	=	new YearSemester();
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_CURRENT_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String, String> mapParamsRule			=	new HashMap<String, String>();
		
		
		return nPJdbcTemplDps.queryForObject(SQL_RULE_CURRENT_YEAR_SEMESTER, mapParamsRule, rowMapper);
	}
	

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
	public int getThesisCode(String studentNo, String stdStatCode)
	{
		String	SQL_RULE_THESIS_CODE		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_THESIS_CODE);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_THESIS_CODE, mapParamsRule);
	}
	
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
	public int getSeminarCount(String studentNo, int thesisCode, String seminarCodeName)
	{
		String	SQL_RULE_SEMINAR_RECORD_COUNT	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_SEMINAR_RECORD_COUNT);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramSeminarAbrCode", seminarCodeName);
		mapParamsRule.put("paramThesisCode", String.valueOf(thesisCode));
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_SEMINAR_RECORD_COUNT, mapParamsRule);
	}
	
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
	public int getCurrentDateInSpecificWeek(String weekNumber)
	{
		String	SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("param_week", weekNumber);
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK, mapParamsRule);
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
	public int extensionRecordAlreadyExist(String studentNo, String stdStatCode)
	{
		String	SQL_RULE_STUDENT_EXTENSION_COUNT	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_EXTENSION_COUNT);
		
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_STUDENT_EXTENSION_COUNT, mapParamsRule);
	}
	
	
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
	public boolean isDropWPeriod(String studentNo, String stdStatCode)
	{
		boolean result	= false;
		String	SQL_RULE_STUDENT_DROP_W_PERIOD	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_DROP_W_PERIOD);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		if(nPJdbcTemplDps.queryForObject(SQL_RULE_STUDENT_DROP_W_PERIOD, mapParamsRule, String.class).equals(Constants.CONST_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
