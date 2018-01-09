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
import java.sql.Types;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
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
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
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
	public PersonalDetail	getStudentPersonalDetail(String studentId, String studentNo, Locale locale ) throws NoDBRecordException
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
		namedParameterMap.put("paramStudentNo", studentNo);
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
	public AcademicDetail	getStudentAcademicDetail(String studentId, String studentNo, Locale locale ) throws NoDBRecordException, NotCorrectDBRecordException
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
		namedParameterMap.put("paramStudentNo", studentNo);

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
	
	
	/**
	 * 
	 * method name  : getHigherApprover
	 * @param studentNo
	 * @param formName
	 * @param roleName
	 * @param isSequenceRequired
	 * @return
	 * DpsDbImpl
	 * return type  : Approver
	 * 
	 * purpose		: Get higher approver (at intial and final case it's same approver)
	 *
	 * Date    		:	Jul 16, 2017 11:59:33 AM
	 */
	public Approver getHigherApprover(String studentNo, String formName, String roleName, String isSequenceRequired)
	{
		String 		SP_APPROVER_NEXT				=	queryProps.getProperty(Constants.CONST_SP_APPROVER_NEXT);
		Map			resultProc						=	null;
		Approver	approver						=	new Approver();
		
		simpleJdbcCallDps.withProcedureName(SP_APPROVER_NEXT);
		simpleJdbcCallDps.withoutProcedureColumnMetaDataAccess();
		simpleJdbcCallDps.useInParameterNames(
													Constants.CONST_PARAM_NAME_STUDENT_NO
												,	Constants.CONST_PARAM_NAME_FORM_NAME
												,	Constants.CONST_PARAM_NAME_ROLE_NAME
												,	Constants.CONST_PARAM_NAME_IS_SEQUENCE_REQUIRED
											  );
		simpleJdbcCallDps.declareParameters(
													new SqlParameter(Constants.CONST_PARAM_NAME_STUDENT_NO,Types.VARCHAR)
												,	new SqlParameter(Constants.CONST_PARAM_NAME_FORM_NAME,Types.VARCHAR)
												,	new SqlParameter(Constants.CONST_PARAM_NAME_ROLE_NAME,Types.VARCHAR)
												,	new SqlParameter(Constants.CONST_PARAM_NAME_IS_SEQUENCE_REQUIRED,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_APPROVER_NAME_ENG,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_APPROVER_NAME_AR,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_APPROVER_EMAIL,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_APPROVER_PHONE,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_ROLE_NAME_ENG,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_ROLE_NAME_AR,Types.VARCHAR)
												,	new SqlOutParameter(Constants.CONST_PARAM_NAME_IS_HIGHER_APPROVER,Types.VARCHAR)
											);
		
		Map<String,String>	paramIn		=	new HashMap<String, String>();
							paramIn.put(Constants.CONST_PARAM_NAME_STUDENT_NO, studentNo);
							paramIn.put(Constants.CONST_PARAM_NAME_FORM_NAME, formName);
							paramIn.put(Constants.CONST_PARAM_NAME_ROLE_NAME, roleName);
							paramIn.put(Constants.CONST_PARAM_NAME_IS_SEQUENCE_REQUIRED, isSequenceRequired);
							
							resultProc	=	simpleJdbcCallDps.execute(paramIn);
							
							
							approver.setNameEng((String)resultProc.get(Constants.CONST_PARAM_NAME_APPROVER_NAME_ENG));
							approver.setNameAr((String)resultProc.get(Constants.CONST_PARAM_NAME_APPROVER_NAME_AR));
							approver.setEmail((String)resultProc.get(Constants.CONST_PARAM_NAME_APPROVER_EMAIL));
							approver.setRoleNameEng((String)resultProc.get(Constants.CONST_PARAM_NAME_ROLE_NAME_ENG));
							approver.setRoleNameAr((String)resultProc.get(Constants.CONST_PARAM_NAME_ROLE_NAME_AR));
							if(((String)resultProc.get(Constants.CONST_PARAM_NAME_IS_HIGHER_APPROVER)).equals(Constants.CONST_YES))
							{
								approver.setHigherSequence(true);
							}
							else
							{
								approver.setHigherSequence(false);
							}
							
							resultProc = null;
		
		return approver;
	}
	
	/**
	 * 
	 * method name  : getTotalRegisteredCredit
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : int
	 * 
	 * purpose		: Total registered credit of a student at current semester 
	 *
	 * Date    		:	Aug 16, 2017 2:35:44 PM
	 */
	public int getTotalRegisteredCredit(String studentNo, String stdStatCode)
	{
		String 		SQL_STUDENT_TOTAL_CREDIT				=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_TOTAL_CREDIT);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramStdStatCode", stdStatCode);
		
		return nPJdbcTemplDps.queryForInt(SQL_STUDENT_TOTAL_CREDIT, namedParameterMap);

	}
	
	/**
	 * 
	 * method name  : getSelectedRegisteredCourseCredit
	 * @param studentNo
	 * @param stdStatCode
	 * @param courseNo
	 * @return
	 * DpsDbImpl
	 * return type  : int
	 * 
	 * purpose		:	Get course credit for individual selected registered course
	 *
	 * Date    		:	Aug 17, 2017 5:05:04 PM
	 */
	public int getSelectedRegisteredCourseCredit(String studentNo, String stdStatCode, String courseNo, String sectNo)
	{
		String 		SQL_STUDENT_SELECTED_COURSE_CREDIT				=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_SELECTED_COURSE_CREDIT);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramStdStatCode", stdStatCode);
		namedParameterMap.put("paramCourseNo", courseNo);
		if(null == sectNo)
		{
			namedParameterMap.put("paramSectNo", null);
		}
		else
		{
			namedParameterMap.put("paramSectNo", sectNo);
		}
			
		
		return nPJdbcTemplDps.queryForInt(SQL_STUDENT_SELECTED_COURSE_CREDIT, namedParameterMap);
	}
	
	/**
	 * 
	 * method name  : isSupervisorAvailable
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DpsDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Find out whether the student has supervisor or not
	 *                Indirectly -- whether the student has thesis or not.
	 *                that means whether the student has any entry at thesis table.
	 *
	 * Date    		:	Aug 28, 2017 4:52:06 PM
	 */
	public boolean isSupervisorAvailable(String studentNo, String stdStatCode)
	{
		String	SQL_FUNC_IS_SUPERVISOR_AVAILABLE				=	queryProps.getProperty(Constants.CONST_SQL_FUNC_IS_SUPERVISOR_AVAILABLE);
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramStdStatCode", stdStatCode);
		
		if(
				nPJdbcTemplDps.queryForObject(
												SQL_FUNC_IS_SUPERVISOR_AVAILABLE, 
												namedParameterMap, 
												String.class
										 	).equals(Constants.CONST_YES)
			)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}

