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
 * File Name			:	DropWDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.db
 * Date of creation		:	Mar 29, 2017  7:07:25 PM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class DropWDBImpl implements DropWDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private		Properties					queryProps;
	private		Properties					queryDropWProps;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsDropW;
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Mar 29, 2017 7:30:51 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryDropWProps
	 * @param queryDropWProps the queryDropWProps to set
	 * 
	 * Date          : Mar 29, 2017 7:30:51 PM
	 */
	public void setQueryDropWProps(Properties queryDropWProps)
	{
		this.queryDropWProps = queryDropWProps;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsDropW
	 * @param nPJdbcTemplDpsDropW the nPJdbcTemplDpsDropW to set
	 * 
	 * Date          : Mar 29, 2017 7:30:51 PM
	 */
	public void setnPJdbcTemplDpsDropW(
			NamedParameterJdbcTemplate nPJdbcTemplDpsDropW)
	{
		this.nPJdbcTemplDpsDropW = nPJdbcTemplDpsDropW;
	}
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param studentId
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(String studentId, Locale locale)
	{
		String	SQL_DROPW_SELECT_COURSE_DETAILS		=	queryDropWProps.getProperty(Constants.CONST_SQL_DROPW_SELECT_COURSE_DETAILS);
		
		RowMapper<DropWDTO> rowMapper		=	new RowMapper<DropWDTO>()
		{
			
			@Override
			public DropWDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				DropWDTO	dropWDTO	=	new DropWDTO();
				dropWDTO.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				dropWDTO.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
				dropWDTO.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
				dropWDTO.setSectCode(rs.getString(Constants.CONST_COLMN_SECT_CODE));
				dropWDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				dropWDTO.setYearSemester(rs.getString(Constants.CONST_COLMN_YEAR_SEM));
				dropWDTO.setCredits(rs.getInt(Constants.CONST_COLMN_CREDITS));
				dropWDTO.setTutionFees(rs.getFloat(Constants.CONST_COLMN_TUTION_FEE));
				dropWDTO.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				return dropWDTO;
			}
		};
		
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramStdId", studentId);
		paramMap.put("paramLocale", locale.getLanguage());
		
		
		return nPJdbcTemplDpsDropW.query(SQL_DROPW_SELECT_COURSE_DETAILS, paramMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param studentNo
	 * @param studentStatCode
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses relates with drop with w from temp/helper table
	 *
	 * Date    		:	Apr 11, 2017 5:33:34 PM
	 */
	public List<DropWDTO> getCourseList(String studentNo, String studentStatCode, Locale locale)
	{
		String	SQL_DROPW_SELECT_COURSE_TEMP	=	queryDropWProps.getProperty(Constants.CONST_SQL_DROPW_SELECT_COURSE_TEMP);
		RowMapper<DropWDTO> rowMapper			=	new RowMapper<DropWDTO>()
		{
			
			@Override
			public DropWDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				DropWDTO	dropWDTO	=	new DropWDTO();
				dropWDTO.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				dropWDTO.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
				dropWDTO.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
				dropWDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				dropWDTO.setCredits(rs.getInt(Constants.CONST_COLMN_CREDITS));
				dropWDTO.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				return dropWDTO;
			}
		};
		
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramStdNo",studentNo);
		paramMap.put("paramStdStatCode",studentStatCode);
		paramMap.put("paramLocale", locale.getLanguage());
		return nPJdbcTemplDpsDropW.query(SQL_DROPW_SELECT_COURSE_TEMP, paramMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : setTempDropWCourse
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: Add a record in temporary table for further progress to drop the course 
	 *
	 * Date    		:	Apr 10, 2017 7:13:47 PM
	 */
	public int setTempDropWCourse(DropWDTO dropWDTO)
	{
		String	SQL_DROPW_INSERT_COURSE_TEMP		=	queryDropWProps.getProperty(Constants.CONST_SQL_DROPW_INSERT_COURSE_TEMP);
		
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramStdNo", dropWDTO.getStudentNo());
		paramMap.put("paramStdStatCode", dropWDTO.getStudentStatCode());
		paramMap.put("paramCourseNo", dropWDTO.getCourseNo());
		paramMap.put("paramStdSectCode", dropWDTO.getSectCode());
		paramMap.put("paramStdSectNo", dropWDTO.getSectionNo());
		paramMap.put("paramStatusCode", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		paramMap.put("paramUserCode", dropWDTO.getUserName());
		return nPJdbcTemplDpsDropW.update(SQL_DROPW_INSERT_COURSE_TEMP, paramMap);
	}
	
	
	
}
