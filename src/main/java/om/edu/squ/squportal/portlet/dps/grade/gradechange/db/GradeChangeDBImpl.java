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
 * File Name			:	GradeChangeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.db
 * Date of creation		:	Nov 13, 2017  3:41:32 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeDBImpl implements GradeChangeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private		Properties					queryProps;
	private		Properties					queryGradeChange;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsGradeChange;
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Nov 13, 2017 3:51:24 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryGradeChange
	 * @param queryGradeChange the queryGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setQueryGradeChange(Properties queryGradeChange)
	{
		this.queryGradeChange = queryGradeChange;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsGradeChange
	 * @param nPJdbcTemplDpsGradeChange the nPJdbcTemplDpsGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setnPJdbcTemplDpsGradeChange(
			NamedParameterJdbcTemplate nPJdbcTemplDpsGradeChange)
	{
		this.nPJdbcTemplDpsGradeChange = nPJdbcTemplDpsGradeChange;
	}
	
	
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 */
	public List<GradeDTO>	getStudentGrades(GradeDTO gradeDTO, String employeeNo, Locale locale) throws NoDBRecordException
	{

		String	SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE);
		
		RowMapper<GradeDTO> rowMapper	=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDTO	=	new GradeDTO();
				Course		course		=	new Course();
				Grade		grade		=	new Grade();
				
				course.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
				
				grade.setGradeCode(rs.getInt(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));
				
				gradeDTO.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				gradeDTO.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				gradeDTO.setCourseYear(rs.getString(Constants.COST_COL_DPS_COURSE_YEAR));
				gradeDTO.setSemester(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
				
				gradeDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				
				gradeDTO.setCourse(course);
				gradeDTO.setGrade(grade);
				
				return gradeDTO;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdId", gradeDTO.getStudentId());
		namedParameterMap.put("paramYear", gradeDTO.getCourseYear());
		namedParameterMap.put("paramSem", gradeDTO.getSemester());
		namedParameterMap.put("paramEmpNo", employeeNo);
		if(null == gradeDTO.getCourse().getlAbrCourseNo() || gradeDTO.getCourse().getlAbrCourseNo().trim().equals(""))
		{
			namedParameterMap.put("paramLAbrCrsNo",null);
		}
		else
		{
			namedParameterMap.put("paramLAbrCrsNo", gradeDTO.getCourse().getlAbrCourseNo());
		}
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		logger.info("namedParameterMap : "+namedParameterMap);
		logger.info("result : "+nPJdbcTemplDpsGradeChange.query(SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE, namedParameterMap, rowMapper));
		
		try
		{
			return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE, namedParameterMap, rowMapper);
		}
		catch(UncategorizedSQLException sqlEx)
		{
			logger.error("Error occur to find to find grade records for student id:  {} and instructor: {} ",gradeDTO.getStudentId(), employeeNo);
			throw new NoDBRecordException(sqlEx.getMessage());
		}
		
	}
	
	/**
	 * 
	 * method name  : getGrades
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Grade>
	 * 
	 * purpose		: list of all grade values
	 *
	 * Date    		:	Nov 19, 2017 1:44:54 PM
	 */
	public List<Grade> getGrades(Locale locale)
	{
		String	SQL_GRADE_VALUE_LIST		=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_VALUE_LIST);
		RowMapper<Grade> rowMapper			=	new RowMapper<Grade>()
		{
			
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Grade	grade	=	new Grade();
				grade.setGradeCode(rs.getInt(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));
				return grade;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_VALUE_LIST, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : getGradeHistory
	 * @param dto
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:36:02 PM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO> getGradeHistory(GradeDTO dto, Locale locale) throws NoDBRecordException
	{
		String					SQL_GRADE_SELECT_HISORY	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_HISORY);
		RowMapper<GradeDTO> 	rowMapper				=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDto	=	new GradeDTO();
				Course		course		=	new Course();
				Grade		grade		=	new Grade();
				
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				
				grade.setGradeValOld(rs.getString(Constants.CONST_COLMN_GRADE_VAL_OLD));
				grade.setGradeValNew(rs.getString(Constants.CONST_COLMN_GRADE_VAL_NEW));
				
				gradeDto.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				gradeDto.setCourse(course);
				
				gradeDto.setGrade(grade);
				
				return gradeDto;
			}
		};	
	
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdId", dto.getStudentId());
		namedParameterMap.put("paramYear", dto.getCourseYear());
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		
		try
		{
			return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_SELECT_HISORY, namedParameterMap, rowMapper);
		}
		catch(UncategorizedSQLException sqlEx)
		{
			logger.error("Error occur to find to find grade change history records for student id:  {} ",dto.getStudentId());
			throw new NoDBRecordException(sqlEx.getMessage());
		}
	}
	
	/**
	 * 
	 * method name  : setInstructorApplyForGradeChange
	 * @param dto
	 * @return
	 * GradeChangeDBImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 12:32:15 PM
	 */
	public int setInstructorApplyForGradeChange(GradeDTO dto) throws NotCorrectDBRecordException
	{
		String	SQL_GRADE_INSERT_APPLY_INSTRUCTOR	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_INSERT_APPLY_INSTRUCTOR);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", dto.getStudentNo());
		namedParameterMap.put("paramStdStatCode", dto.getStdStatCode());
		namedParameterMap.put("paramYear", dto.getCourseYear());
		namedParameterMap.put("paramSem", dto.getSemester());
		namedParameterMap.put("paramCourseLAbrCode", dto.getCourse().getlAbrCourseNo());
		namedParameterMap.put("paramCourseNo", dto.getCourse().getCourseNo());
		namedParameterMap.put("paramSectNo", dto.getSectionNo());
		namedParameterMap.put("paramGradeCodeOld", String.valueOf(dto.getGrade().getGradeCodeOld()));
		namedParameterMap.put("paramGradeCodeNew", String.valueOf(dto.getGrade().getGradeCodeNew()));
		namedParameterMap.put("paramStatusCode", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		namedParameterMap.put("paramUserName", dto.getUserName());
		
		logger.info("namedParameterMap : "+namedParameterMap);
		logger.info("SQL_GRADE_INSERT_APPLY_INSTRUCTOR : "+SQL_GRADE_INSERT_APPLY_INSTRUCTOR);
		
		try
			{
				return nPJdbcTemplDpsGradeChange.update(SQL_GRADE_INSERT_APPLY_INSTRUCTOR, namedParameterMap);
			}
		catch(DuplicateKeyException sqlEx)
		{
			logger.error("Violation of primary key. Details : {}",sqlEx.getMessage());
			throw new NotCorrectDBRecordException(sqlEx.getMessage());
		}
	}
	
	
}
