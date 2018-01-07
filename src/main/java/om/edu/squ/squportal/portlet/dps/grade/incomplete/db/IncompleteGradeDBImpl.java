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
 * File Name			:	IncompleteGradeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.db
 * Date of creation		:	Jan 3, 2018  9:23:12 AM
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteBo;
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
public class IncompleteGradeDBImpl implements IncompleteGradeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private		Properties					queryProps;
	private		Properties					queryIncompleteGrade;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsIncompleteGrade;
	
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryIncompleteGrade
	 * @param queryIncompleteGrade the queryIncompleteGrade to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setQueryIncompleteGrade(Properties queryIncompleteGrade)
	{
		this.queryIncompleteGrade = queryIncompleteGrade;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsIncompleteGrade
	 * @param nPJdbcTemplDpsIncompleteGrade the nPJdbcTemplDpsIncompleteGrade to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setnPJdbcTemplDpsIncompleteGrade(
			NamedParameterJdbcTemplate nPJdbcTemplDpsIncompleteGrade)
	{
		this.nPJdbcTemplDpsIncompleteGrade = nPJdbcTemplDpsIncompleteGrade;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.db.IncompleteGradeDBDao#getCourseList(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteBo> getCourseList( boolean isRuleGradeChangeTimingFollowed, String employeeNo, Locale	locale)
	{
		String			SQL_GRADE_SELECT_COURSE_LIST		=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_SELECT_COURSE_LIST);
		YearSemester	yearSemester						=	null;
		
		RowMapper<GradeIncompleteBo> 	rowMapper	=	new RowMapper<GradeIncompleteBo>()
		{
			
			@Override
			public GradeIncompleteBo mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeIncompleteBo gradeDTO	=	new GradeIncompleteBo();
					Course	course	=	new Course();
					course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
					course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
					course.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
					
					gradeDTO.setCourse(course);
					
					
				return gradeDTO;
			}
		};
		
		yearSemester	= (isRuleGradeChangeTimingFollowed) ? getRuleYearSem() : getCurrentYearSem();
			
			Map<String,String> namedParameterMap	=	new HashMap<String,String>();
			
			namedParameterMap.put("paramLocale", locale.getLanguage());
			namedParameterMap.put("paramYear", String.valueOf(yearSemester.getYear()));
			namedParameterMap.put("paramSemester", String.valueOf(yearSemester.getSemester()));			
			namedParameterMap.put("paramEmpNo", employeeNo);
			
			
			return nPJdbcTemplDpsIncompleteGrade.query(SQL_GRADE_SELECT_COURSE_LIST, namedParameterMap, rowMapper);
	}
	
	
	
	
	public YearSemester		getCurrentYearSem()
	{
		String	SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM	=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM);
		RowMapper<YearSemester> 	rowMapper	=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester yearSemester	=	new	YearSemester(); 
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		return nPJdbcTemplDpsIncompleteGrade.queryForObject(SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM, namedParameterMap, rowMapper);
	}
	
	
	
	public YearSemester		getRuleYearSem()
	{
		String	SQL_GRADE_SELECT_RULE_YEAR_SEM	=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_SELECT_RULE_YEAR_SEM);
		RowMapper<YearSemester> 	rowMapper	=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester yearSemester	=	new	YearSemester(); 
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		return nPJdbcTemplDpsIncompleteGrade.queryForObject(SQL_GRADE_SELECT_RULE_YEAR_SEM, namedParameterMap, rowMapper);
	}
	
	
	
		
	}
	
	
	

