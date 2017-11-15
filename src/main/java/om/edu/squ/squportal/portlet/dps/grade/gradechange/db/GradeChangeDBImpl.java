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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * @param studentNo
	 * @param gradeYear
	 * @param semester
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
	public List<GradeDTO>	getStudentGrades(String studentNo, String gradeYear, String semester, String employeeNo, Locale locale)
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
				
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
				
				grade.setGradeCode(rs.getInt(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));
				
				gradeDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				
				gradeDTO.setCourse(course);
				gradeDTO.setCourse(course);
				
				return gradeDTO;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramYear", gradeYear);
		namedParameterMap.put("paramSem", semester);
		namedParameterMap.put("paramEmpNo", employeeNo);
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE, namedParameterMap, rowMapper);
		
	}
	
	
	
	
}
