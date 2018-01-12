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

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
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
	public List<GradeIncompleteDTO> getCourseList( boolean isRuleGradeChangeTimingFollowed, String employeeNo, Locale	locale)
	{
		String			SQL_GRADE_SELECT_COURSE_LIST		=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_SELECT_COURSE_LIST);
		YearSemester	yearSemester						=	null;
		
		RowMapper<GradeIncompleteDTO> 	rowMapper	=	new RowMapper<GradeIncompleteDTO>()
		{
			
			@Override
			public GradeIncompleteDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeIncompleteDTO gradeDTO	=	new GradeIncompleteDTO();
					Course	course	=	new Course();
					course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
					course.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
					course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
					course.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
					course.setSectCode(rs.getString(Constants.CONST_COLMN_SECT_CODE));
					course.setCourseYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
					course.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
					
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
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.db.IncompleteGradeDBDao#getStudentList(boolean, java.lang.String, java.lang.String, java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getStudentList(boolean isRuleGradeChangeTimingFollowed, String employeeNo,String lAbrCourseNo, String sectionNo, Locale	locale)
	{
		YearSemester	yearSemester						=	null;
		String	SQL_INCOMPLETE_GRADE_SELECT_STUDENT_LIST	=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_SELECT_STUDENT_LIST);
		RowMapper<GradeIncompleteDTO> 	rowMapper	=	new RowMapper<GradeIncompleteDTO>()
		{
			
			@Override
			public GradeIncompleteDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeIncompleteDTO	dto				=	new GradeIncompleteDTO();
				
				Student				student			=	new Student();
				AcademicDetail		academicDetail	=	new AcademicDetail();
				PersonalDetail		personalDetail	=	new PersonalDetail();
				Grade				grade			=	new Grade();
				
				academicDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				academicDetail.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				academicDetail.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				academicDetail.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				
				personalDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				personalDetail.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				personalDetail.setName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				personalDetail.setGender(rs.getString(Constants.CONST_COLMN_STUDENT_GENDER));
				
				student.setAcademicDetail(academicDetail);
				student.setPersonalDetail(personalDetail);
				
				grade.setGradeCode(rs.getString(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));

				dto.setStudent(student);
				dto.setGrade(grade);
				
				return dto;
				
			}
		};
		
		yearSemester	=	getCurrentYearSem();
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramEmpNo",employeeNo);
		namedParameterMap.put("paramYear", String.valueOf(yearSemester.getYear()));
		namedParameterMap.put("paramSem", String.valueOf(yearSemester.getSemester()));	
		namedParameterMap.put("paramLAbrCourseNo",lAbrCourseNo);
		namedParameterMap.put("paramSectionNo",sectionNo);
		
		
		
		return nPJdbcTemplDpsIncompleteGrade.query(SQL_INCOMPLETE_GRADE_SELECT_STUDENT_LIST, namedParameterMap, rowMapper);
	}

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.db.IncompleteGradeDBDao#setInstructorNotifyForIncompleteGrade(om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO)
	 */
	@Override
	public int setInstructorNotifyForIncompleteGrade(GradeIncompleteDTO dto ) throws NotCorrectDBRecordException
	{
		String SQL_INCOMPLETE_GRADE_INSERT_NOTIFY_INSTRUCTOR	=	queryIncompleteGrade.getProperty(Constants.CONST_SQL_INCOMPLETE_GRADE_INSERT_NOTIFY_INSTRUCTOR);
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo",dto.getStudent().getAcademicDetail().getStudentNo());
		namedParameterMap.put("paramStdStatCode",dto.getStudent().getAcademicDetail().getStdStatCode());
		namedParameterMap.put("paramYear",String.valueOf(dto.getCourse().getCourseYear()));
		namedParameterMap.put("paramSem",String.valueOf(dto.getCourse().getSemester()));
		namedParameterMap.put("paramSectCode",dto.getCourse().getSectCode());
		namedParameterMap.put("paramCourseLAbrCode",dto.getCourse().getlAbrCourseNo());
		namedParameterMap.put("paramCourseNo",dto.getCourse().getCourseNo());
		namedParameterMap.put("paramSectNo",dto.getCourse().getSectionNo());
		namedParameterMap.put("paramStatusCode",Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		namedParameterMap.put("paramUserName",dto.getUserName());
		namedParameterMap.put("paramComment", dto.getComments());
		

		
		try
		{
			return nPJdbcTemplDpsIncompleteGrade.update(SQL_INCOMPLETE_GRADE_INSERT_NOTIFY_INSTRUCTOR, namedParameterMap);
		}
		catch(DuplicateKeyException sqlEx)
		{
			logger.error("Violation of primary key. Details : {}",sqlEx.getMessage());
			throw new NotCorrectDBRecordException(sqlEx.getMessage());
		}
		
		
		
	}
	
	
		
	}
	
	
	

