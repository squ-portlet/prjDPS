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
import om.edu.squ.squportal.portlet.dps.rule.bo.WithdrawPeriod;
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
	 * method name  : myYearSemester
	 * @param NumberOfDaysAdjust
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		: Decide to get the year semester based on current date 
	 *               (if 0 then last semester if 1 then current semester - 
	 *               Here current semester means extension semester already over and might be in grace period in current semester)
	 *
	 * Date    		:	Jan 21, 2019 5:02:22 PM
	 */
	private	int isMySemester(String NumberOfDaysAdjust)
	{
		String CONST_PROP_SQL_RULE_DECIDE_YEAR_SEMESTER		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_DECIDE_YEAR_SEMESTER);
		Map<String, String> mapParamsRule			=	new HashMap<String, String>();
		mapParamsRule.put("paramNumberDays", NumberOfDaysAdjust);
		return nPJdbcTemplDps.queryForInt(CONST_PROP_SQL_RULE_DECIDE_YEAR_SEMESTER, mapParamsRule);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#getRuleLastYearSemester(java.lang.String)
	 */
	public YearSemester	getRuleLastYearSemester(String NumberOfDaysAdjust)
	{
		if (isMySemester(NumberOfDaysAdjust)==0)
		{
			return getLastYearSemester(NumberOfDaysAdjust);
		}
		else
		{
			return getCurrentYearSemester();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#getLastYearSemester()
	 */
	public YearSemester getLastYearSemester()
	{
		String	SQL_VIEW_RULE_LAST_YEAR_SEMESTER		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_VIEW_RULE_LAST_YEAR_SEMESTER);
		RowMapper<YearSemester> 	rowMapper		=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester	yearSemester	=	new YearSemester();
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String, String> mapParamsRule			=	new HashMap<String, String>();
		
		return nPJdbcTemplDps.queryForObject(SQL_VIEW_RULE_LAST_YEAR_SEMESTER, mapParamsRule, rowMapper);
	}
	

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#getLastYearSemester(java.lang.String)
	 */
	public YearSemester getLastYearSemester(String numberOfDays)
	{
		String	SQL_VIEW_RULE_LAST_YEAR_SEMESTER_PARAMETER		=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_VIEW_RULE_LAST_YEAR_SEMESTER_PARAMETER);
		RowMapper<YearSemester> 	rowMapper		=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester	yearSemester	=	new YearSemester();
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String, String> mapParamsRule			=	new HashMap<String, String>();
		mapParamsRule.put("paramNumberDays", numberOfDays);
		
		return nPJdbcTemplDps.queryForObject(SQL_VIEW_RULE_LAST_YEAR_SEMESTER_PARAMETER, mapParamsRule, rowMapper);
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
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#getCurrentDateInSpecificWeek(java.lang.String, java.lang.String)
	 */
	public int getCurrentDateInSpecificWeek(String weekNumber, String numberOfDaysAdjust)
	{
		if (isMySemester(numberOfDaysAdjust)==0)
		{
			return 1; /* 
							no record found in current semester means number of adjust days applied 
						and extension rule to get extension for extended days are respected 
					*/  
					/* TODO -- old way to connect last semester */ //getCurrentDateInSpecificWeekLastSem(weekNumber);
		}
		else
		{
			return getCurrentDateInSpecificWeekCurrentSem(weekNumber);
		}

	}
	
	/**
	 * 
	 * method name  : getCurrentDateInSpecificWeekCurrentSem
	 * @param weekNumber
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 22, 2019 8:52:18 AM
	 */
	public int getCurrentDateInSpecificWeekCurrentSem(String weekNumber)
	{
		String	SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("param_week", weekNumber);
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK, mapParamsRule);
	}
	
	/**
	 * 
	 * method name  : getCurrentDateInSpecificWeekLastSem
	 * @param weekNumber
	 * @return
	 * RuleDbImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 22, 2019 8:52:26 AM
	 */
	public int getCurrentDateInSpecificWeekLastSem(String weekNumber)
	{
		String	SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK_LAST_SEM	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK_LAST_SEM);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("param_week", weekNumber);
		
		return nPJdbcTemplDps.queryForInt(SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK_LAST_SEM, mapParamsRule);
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
	 * @return
	 * RuleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: whether the period is within drop w period 
	 *
	 * Date    		:	Aug 20, 2017 4:46:22 PM
	 */
	public boolean isDropWPeriod()
	{
		boolean result	= false;
		String	SQL_RULE_STUDENT_DROP_W_PERIOD	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_DROP_W_PERIOD);
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		if(nPJdbcTemplDps.queryForObject(SQL_RULE_STUDENT_DROP_W_PERIOD, mapParamsRule, String.class).equals(Constants.CONST_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
/*
 * (non-Javadoc)
 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#getWithdrawPeriod(java.lang.String, java.lang.String)
 */
	public WithdrawPeriod	getWithdrawPeriod(String studentNo, String stdStatCode)
	{
		String	SQL_RULE_STUDENT_DROP_W_DATE	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_STUDENT_DROP_W_DATE);
		
		RowMapper<WithdrawPeriod> rowMapper		=	new RowMapper<WithdrawPeriod>()
		{
			
			@Override
			public WithdrawPeriod mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				WithdrawPeriod	withdrawPeriod	=	new WithdrawPeriod();
				withdrawPeriod.setFirstWithDrawDate(rs.getString(Constants.CONST_COLMN_FIRST_WITHDRAW_DATE));
				withdrawPeriod.setSecondWithDrawDate(rs.getString(Constants.CONST_COLMN_SECOND_WITHDRAW_DATE));
				
				return withdrawPeriod;
			}
		};	
		
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramStdStatCode", stdStatCode);
		return nPJdbcTemplDps.queryForObject(SQL_RULE_STUDENT_DROP_W_DATE, mapParamsRule, rowMapper);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#isCourseThesis(java.lang.String, java.lang.String)
	 */
	public boolean isCourseThesis(String studentNo, String courseNo)
	{
		boolean result	=	false;
		String	SQL_IS_THESIS_COURSE	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_IS_THESIS_COURSE);
		
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
		mapParamsRule.put("paramStdNo", studentNo);
		mapParamsRule.put("paramCourseNo", courseNo);
		
			if(nPJdbcTemplDps.queryForObject(SQL_IS_THESIS_COURSE, mapParamsRule,String.class).equals(Constants.CONST_YES))
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#isSemesterExtended(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean isSemesterExtended(String stdStatCode, String courseYear, String semester)
	{
		String	SQL_RULE_IS_SEMESTER_EXTENDED	=	queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_IS_SEMESTER_EXTENDED);
		
		Map<String, String> mapParamsRule	=	new HashMap<String, String>();
							mapParamsRule.put("paramStdStatCode", stdStatCode);
							mapParamsRule.put("paramCCYrCode", courseYear);
							mapParamsRule.put("paramSemCode", semester);
		

			if(nPJdbcTemplDps.queryForObject(SQL_RULE_IS_SEMESTER_EXTENDED, mapParamsRule,String.class).equals(Constants.CONST_YES))
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.rule.db.RuleDbDao#isSemesterPostponed(java.lang.String)
	 */
	public boolean isSemesterPostponed(String stdStatCode)
	{
		String SQL_RULE_IS_SEMESTER_POSTPONED = queryPropsCommonRule.getProperty(Constants.CONST_PROP_SQL_RULE_IS_SEMESTER_POSTPONED);
		
		Map<String, String> mapParamRule	= new HashMap<String,String>();
							mapParamRule.put("paramStdStatCode", stdStatCode);

		if(nPJdbcTemplDps.queryForObject(SQL_RULE_IS_SEMESTER_POSTPONED, mapParamRule,String.class).equals(Constants.CONST_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
