/**
 * Project				:	prjLibrary
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	DpsDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.dao.db
 * Date of creation		:	May 20, 2015  12:49:49 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Branch;
import om.edu.squ.squportal.portlet.dps.bo.Department;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


/**
 * @author Bhabesh
 *
 */
public class DpsDbImpl implements DpsDbDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	private	NamedParameterJdbcTemplate	nPJdbcTemplHrms;
	private	NamedParameterJdbcTemplate	nPJdbcTemplDps;
//	private	SimpleJdbcCall				simpleJdbcCallHrms;
	private	SimpleJdbcCall				simpleJdbcCallDps;
	private	Properties					queryProps;

	/**
	 * Setter method : setnPJdbcTemplDps
	 * @param nPJdbcTemplDps the nPJdbcTemplDps to set
	 * 
	 * Date          : Jan 5, 2017 4:46:41 PM
	 */
	public void setnPJdbcTemplDps(NamedParameterJdbcTemplate nPJdbcTemplDps)
	{
		this.nPJdbcTemplDps = nPJdbcTemplDps;
	}

	/**
	 * Setter method : setSimpleJdbcCallDps
	 * @param simpleJdbcCallDps the simpleJdbcCallDps to set
	 * 
	 * Date          : Jan 5, 2017 4:46:41 PM
	 */
	public void setSimpleJdbcCallDps(SimpleJdbcCall simpleJdbcCallDps)
	{
		this.simpleJdbcCallDps = simpleJdbcCallDps;
	}
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Jan 5, 2017 4:46:41 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	
	
	/**
	 * 
	 * method name  : getEmployee
	 * @param empNumber
	 * @return
	 * DpsDbImpl
	 * return type  : Employee
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 8, 2017 3:42:44 PM
	 * @throws ExceptionEmptyResultset 
	 */
	public Employee getEmployee(String empNumber) throws ExceptionEmptyResultset
	{
		String	SQL_DPS_EMPLOYEE_DETAIL	=	queryProps.getProperty(Constants.COST_SQL_DPS_EMPLOYEE_DETAIL);
		
		RowMapper<Employee> 	mapper	= new RowMapper<Employee>()
		{
			
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Employee	employee	=	new Employee();
				Branch		branch		=	new Branch();
				Department	department	=	new Department();
				
				employee.setEmpNumber(rs.getString(Constants.COST_COL_DPS_EMP_NO));
				department.setDeptCode(rs.getString(Constants.COST_COL_DPS_DEPT_CODE));
				branch.setBranchCode(rs.getString(Constants.COST_COL_DPS_BRANCH_CODE));
				employee.setDepartment(department);
				employee.setBranch(branch);
				employee.setEmail(Constants.COST_COL_DPS_EMP_EMAIL);

				return employee;
			}
		};
		
		Map<String, String> mapParamsDPS	=	new HashMap<String, String>();
		mapParamsDPS.put("paramEmpNumber", empNumber);
		
		try
			{
				return nPJdbcTemplDps.queryForObject(SQL_DPS_EMPLOYEE_DETAIL, mapParamsDPS, mapper);
			}
		catch(EmptyResultDataAccessException ex)
		{
			logger.error("Empty resultset error. Details : "+ex.getMessage());
			throw new ExceptionEmptyResultset(ex.getMessage());
		}

		
	}
	
	
	/**
	 * 
	 * method name  : getStudentPersonalDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : PersonalDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:21:56 AM
	 */
	public PersonalDetail	getStudentPersonalDetail(String studentId, Locale locale ) throws NoDBRecordException
	{
	
		String SQL_PERSONAL_DETAIL_STUDENT		=	queryProps.getProperty(Constants.SQL_PERSONAL_DETAIL_STUDENT);
		
		RowMapper<PersonalDetail> mapper	=	new RowMapper<PersonalDetail>() {
			
			public PersonalDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
					PersonalDetail	personalDetail	=	new PersonalDetail();
					
					personalDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
					personalDetail.setName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
					personalDetail.setPhone(rs.getString(Constants.CONST_COLMN_STUDENT_PHONE));
					personalDetail.setEmail(rs.getString(Constants.CONST_COLMN_STUDENT_EMAIL));
					personalDetail.setRegion(rs.getString(Constants.CONST_COLMN_STUDENT_HOME_REGION));
					personalDetail.setWillayat(rs.getString(Constants.CONST_COLMN_STUDENT_HOME_WILAYAT));
					personalDetail.setTown(rs.getString(Constants.CONST_COLMN_STUDENT_TOWN_VILLAGE));
					personalDetail.setPoBox(rs.getString(Constants.CONST_COLMN_STUDENT_HOME_POBOX));
					personalDetail.setPostalCode(rs.getString(Constants.CONST_COLMN_STUDENT_HOME_POSTALCD));

				return personalDetail;
			}
		};
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramStudentId", studentId);
		try
		{
			return nPJdbcTemplDps.queryForObject(SQL_PERSONAL_DETAIL_STUDENT, namedParameterMap, mapper);
		}
		catch (EmptyResultDataAccessException ex)
		{
			
			throw new NoDBRecordException(ex.getMessage());
		}
		
		
	}
	
	/**
	 * 
	 * method name  : getStudentAcademicDetail
	 * @param studentId
	 * @param locale
	 * @return
	 * @throws NoDBRecordException
	 * DpsDbImpl
	 * return type  : AcademicDetail
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 9, 2017 11:22:11 AM
	 */
	public AcademicDetail	getStudentAcademicDetail(String studentId, Locale locale ) throws NoDBRecordException, NotCorrectDBRecordException
	{
		String SQL_ACADEMIC_DETAIL_STUDENT		=	queryProps.getProperty(Constants.SQL_ACADEMIC_DETAIL_STUDENT);
		RowMapper<AcademicDetail> mapper	=	new RowMapper<AcademicDetail>() {
			
			
			public AcademicDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
					AcademicDetail	academicDetail	=	new AcademicDetail();
					academicDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
					academicDetail.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
					academicDetail.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
					academicDetail.setCollege(rs.getString(Constants.CONST_COLMN_COLLEGE_NAME));
					academicDetail.setMajor(rs.getString(Constants.CONST_COLMN_MAJOR_NAME));
					academicDetail.setAdvisorId(rs.getString(Constants.CONST_COLMN_ADVISOR_ID));
					academicDetail.setSupervisorId(rs.getString(Constants.CONST_COLMN_SUPERVISOR_ID));
					academicDetail.setDegree(rs.getString(Constants.CONST_COLMN_DEGREE_NAME));
					academicDetail.setStatus(rs.getString(Constants.CONST_COLMN_STATUS_NAME));
				
				return academicDetail;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramStudentId", studentId);
		try
			{
				return nPJdbcTemplDps.queryForObject(SQL_ACADEMIC_DETAIL_STUDENT, namedParameterMap, mapper);
			}
		catch(EmptyResultDataAccessException ex)
		{
			throw new NoDBRecordException(ex.getMessage()); 
		}
		catch(IncorrectResultSizeDataAccessException exNotCorrectResultSize)
		{
			logger.error("DB Error : Error Thrown and to be catched in Service layer");
			throw new NotCorrectDBRecordException(exNotCorrectResultSize.getMessage());
		}
	}
	
	
	/**
	 * 
	 * method name  : getCurrentYearSemester
	 * @param locale
	 * @return
	 * DpsDbImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get Current Year Semester
	 *
	 * Date    		:	Jan 16, 2017 11:10:09 AM
	 */
	public YearSemester		getCurrentYearSemester (Locale locale)
	{
		String SQL_DPS_CURRENT_YR_SEM		=	queryProps.getProperty(Constants.CONST_SQL_DPS_CURRENT_YR_SEM);
		
		RowMapper<YearSemester> 	mapper		=	new RowMapper<YearSemester>()
		{
			
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester	yearSemester	=	new YearSemester();
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemesterCode(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				yearSemester.setSemesterAbbr(rs.getString(Constants.COST_COL_DPS_ABR_SEM));
				yearSemester.setSemesterName(rs.getString(Constants.COST_COL_DPS_SEMESTER_NAME));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		return  nPJdbcTemplDps.queryForObject(SQL_DPS_CURRENT_YR_SEM, namedParameterMap, mapper);
	}

	
	/**
	 * 
	 * method name  : getNextYearSemester
	 * @param locale
	 * @return
	 * DpsDbImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get next year semester
	 *
	 * Date    		:	Jan 16, 2017 3:02:26 PM
	 */
	public YearSemester		getNextYearSemester (Locale locale)
	{
		String SQL_DPS_NEXT_YR_SEM		=	queryProps.getProperty(Constants.CONST_SQL_DPS_NEXT_YR_SEM);
		
		RowMapper<YearSemester> 	mapper		=	new RowMapper<YearSemester>()
		{
			
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester	yearSemester	=	new YearSemester();
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemesterCode(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				yearSemester.setSemesterAbbr(rs.getString(Constants.COST_COL_DPS_ABR_SEM));
				yearSemester.setSemesterName(rs.getString(Constants.COST_COL_DPS_SEMESTER_NAME));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		return  nPJdbcTemplDps.queryForObject(SQL_DPS_NEXT_YR_SEM, namedParameterMap, mapper);
	}	
	
	/**
	 * 
	 * method name  : getStudentMode
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : String
	 * 
	 * purpose		: Get Study mode of the student (Full Time/Part Time) etc.
	 *
	 * Date    		:	May 16, 2017 11:06:05 PM
	 */
	public String	getStudentMode(String studentNo, String stdStatCode)
	{
		String	SQL_STUDENT_MODE	=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_MODE);
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramStdStatCode", stdStatCode);
		
		return nPJdbcTemplDps.queryForObject(SQL_STUDENT_MODE, namedParameterMap, String.class);
		
	}
	
}

