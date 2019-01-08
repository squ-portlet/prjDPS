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
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotSuccessFulDBUpdate;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.annotation.Transactional;

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
	private		SimpleJdbcCall				simpleJdbcCallDpsDropW;		
	
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
	 * Setter method : setSimpleJdbcCallDpsDropW
	 * @param simpleJdbcCallDpsDropW the simpleJdbcCallDpsDropW to set
	 * 
	 * Date          : May 7, 2017 11:35:09 AM
	 */
	public void setSimpleJdbcCallDpsDropW(SimpleJdbcCall simpleJdbcCallDpsDropW)
	{
		this.simpleJdbcCallDpsDropW = simpleJdbcCallDpsDropW;
	}
	/**
	 * 
	 * method name  : getCourseList
	 * @param student
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(Student student, Locale locale, String studentMode, String isWithdrawPeriodRule)
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
		paramMap.put("paramStdId", student.getAcademicDetail().getId());
		paramMap.put("paramLocale", locale.getLanguage());
		paramMap.put("paramMode", studentMode);
		paramMap.put("paramDropTimeApplied", isWithdrawPeriodRule);
		
		
		
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
				dropWDTO.setSectCode(rs.getString(Constants.CONST_COLMN_SECT_CODE));
				dropWDTO.setCredits(rs.getInt(Constants.CONST_COLMN_CREDITS));
				dropWDTO.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				if(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME).equals(Constants.CONST_SQL_STATUS_CODE_NAME_PENDING))
				{
					dropWDTO.setStatusPending(true);
				}
				else
				{
					dropWDTO.setStatusPending(false);
				}
				if(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME).equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
				{
					dropWDTO.setStatusReject(true);
				}
				else
				{
					dropWDTO.setStatusReject(false);
				}

				dropWDTO.setRemarks(rs.getString(Constants.CONST_COLMN_COMMENT));
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
	public int setTempDropWCourseAdd(DropWDTO dropWDTO)
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
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.dropw.db.DropWDBDao#getDropWForApprovers(java.lang.String, om.edu.squ.squportal.portlet.dps.bo.Employee, java.util.Locale, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	public List<DropWDTO> getDropWForApprovers(
															String 		roleType, 
															Employee 	employee, 
															Locale 		locale, 
															String 		studentNo, 
													final 	boolean 	isDelegation, 
													final 	boolean 	applyDelegation, 
													final 	boolean 	delegationDefaultApprove, 
													final 	boolean 	delegationApprove
												) throws NoDBRecordException
	{
		String	SQL_DROPW_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	queryDropWProps.getProperty
																					(
																							Constants.CONST_SQL_DROPW_SELECT_STUDENT_RECORDS_BY_EMPLOYEE
																					);
		
		RowMapper<DropWDTO> 	mapper		=	new RowMapper<DropWDTO>()
		{
			
			@Override
			public DropWDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				DropWDTO		dropWDTO		=	new DropWDTO();
				Advisor			advisor			=	new Advisor();
				Student			student			=	new Student();
				AcademicDetail	academicDetail	=	new AcademicDetail();
				
				academicDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				academicDetail.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				academicDetail.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				academicDetail.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				academicDetail.setCohort(rs.getInt(Constants.CONST_COLMN_COHORT));
				academicDetail.setCollege(rs.getString(Constants.CONST_COLMN_COLLEGE_NAME));
				academicDetail.setDegree(rs.getString(Constants.CONST_COLMN_DEGREE_NAME));
				
				advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
				
				if(rs.getString(Constants.CONST_COLMN_ROLE_IS_APPROVER).equals(Constants.CONST_YES))
				{
					dropWDTO.setApprover(true);
					dropWDTO.setApproverApplicable(true);
				}
				else
				{
					dropWDTO.setApprover(false);
					dropWDTO.setApproverApplicable(false);
				}
				
				student.setAcademicDetail(academicDetail);
				dropWDTO.setStudent(student);
				dropWDTO.setAdvisor(advisor);
				
				/* Delegation */
				if(isDelegation)
				{
					if(delegationDefaultApprove)
					{
						
					}
					else
					{
						if(!delegationApprove)
						{
							dropWDTO.setApprover(false);
							dropWDTO.setApproverApplicable(false);
						
						}
					}
					if(delegationApprove)
					{
						/* Glyphicon for delegation */
						dropWDTO.setApplyDelegation(applyDelegation);			
					}
					
				}
				
				
				return dropWDTO;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramStdNo", null);
		namedParameterMap.put("paramColCode", null);
		namedParameterMap.put("paramAdvisor", null);
		namedParameterMap.put("paramSupervisor", null);
		namedParameterMap.put("paramDeptCode", null);
		namedParameterMap.put("paramRoleName", roleType);
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY);
		namedParameterMap.put("paramEmpNo", employee.getEmpNumber());
		
		namedParameterMap.put("paramAdvisorRoleName", Constants.CONST_SQL_ROLE_NAME_ADVISOR);

		
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_DROP_W);
		
		switch (roleType)
		{
			case Constants.CONST_ROLE_NAME_ADVISOR:
				namedParameterMap.put("paramAdvisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_SUPERVISOR:
				namedParameterMap.put("paramSupervisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_HOD:
				namedParameterMap.put("paramDeptCode", employee.getDepartment().getDeptCode());
				break;
			case Constants.CONST_ROLE_NAME_ASST_DEAN_P:
				namedParameterMap.put("paramColCode", employee.getBranch().getBranchCode());
				break;
			case Constants.CONST_ROLE_NAME_COL_DEAN:
				namedParameterMap.put("paramColCode", employee.getBranch().getBranchCode());
				break;	
			default:
				break;
		}
		
		if(null != studentNo)
		{
			namedParameterMap.put("paramStdNo", studentNo);
		}
		
		try
		{
			return nPJdbcTemplDpsDropW.query(SQL_DROPW_SELECT_STUDENT_RECORDS_BY_EMPLOYEE, namedParameterMap, mapper);
		}
		catch(UncategorizedSQLException sqlEx)
		{
			logger.error("Error occur to find Approver");
			throw new NoDBRecordException(sqlEx.getMessage());
		}
		
	}


	/**
	 * 
	 * method name  : setDropWCourseUpdate
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in drop w
	 *
	 * Date    		:	May 2, 2017 10:59:22 AM
	 */
	@Transactional
	public int setDropWCourseUpdate(DropWDTO dropWDTO) throws NotSuccessFulDBUpdate
	{
		int resultTempDrop	=	0;
		Map	resultDropProc	=	null;
		
			if(dropWDTO.getStatusApprove().equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
			{
				resultTempDrop	=	setTempDropWCourseUpdate(dropWDTO);
			}
			else
			{
				try
				{
					resultDropProc	=	setDropWCourseWithdrawProc(dropWDTO);
				}
				catch(NotSuccessFulDBUpdate ex)
				{
					logger.error("Course can not be dropped, Exception raised");
					throw new NotSuccessFulDBUpdate(ex.getLocalizedMessage());
				}
				if(null != resultDropProc)
				{
					resultTempDrop	=	setTempDropWCourseUpdate(dropWDTO);
					 
				}
			}
		return resultTempDrop;
	}
	
	
	/**
	 * 
	 * method name  : setTempDropWCourseUpdate
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in temporary table
	 *
	 * Date    		:	May 2, 2017 9:35:38 AM
	 */
	@Transactional
	private int setTempDropWCourseUpdate(DropWDTO dropWDTO)
	{
		String	SQL_DROPW_UPDATE_COURSE_TEMP		=	queryDropWProps.getProperty(Constants.CONST_SQL_DROPW_UPDATE_COURSE_TEMP);
		
				
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramStdNo", dropWDTO.getStudentNo());
		paramMap.put("paramStdStatCode", dropWDTO.getStudentStatCode());
		paramMap.put("paramCourseNo", dropWDTO.getCourseNo());
		paramMap.put("paramSectCode", dropWDTO.getSectCode());
		paramMap.put("paramSectionNo", dropWDTO.getSectionNo());
		paramMap.put("paramStatusCode", dropWDTO.getStatusApprove());
		paramMap.put("paramUserCode", dropWDTO.getUserName());
		paramMap.put("paramRemarks", dropWDTO.getRemarks());


		
		return nPJdbcTemplDpsDropW.update(SQL_DROPW_UPDATE_COURSE_TEMP, paramMap);

	}

	
	/**
	 * 
	 * method name  : setDropWCourseWithdrawProc
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	May 7, 2017 10:36:17 AM
	 */
	@Transactional
	private	Map setDropWCourseWithdrawProc(DropWDTO dropWDTO) throws NotSuccessFulDBUpdate
	{
		Map		resultProc		=	null;
		
		simpleJdbcCallDpsDropW.withProcedureName(Constants.CONST_PROC_DROPW_WITHDRAW_COURSE);
		simpleJdbcCallDpsDropW.withoutProcedureColumnMetaDataAccess();
		simpleJdbcCallDpsDropW.useInParameterNames	(
												Constants.CONST_PROC_COL_NAME_P_STDNO,
												Constants.CONST_PROC_COL_NAME_P_SECTCD,
												Constants.CONST_PROC_COL_NAME_P_SECTNO,
												Constants.CONST_PROC_COL_NAME_P_USER
											);
		simpleJdbcCallDpsDropW.declareParameters(
												new SqlParameter(Constants.CONST_PROC_COL_NAME_P_STDNO, Types.NUMERIC),
												new SqlParameter(Constants.CONST_PROC_COL_NAME_P_SECTCD, Types.NUMERIC),
												new SqlParameter(Constants.CONST_PROC_COL_NAME_P_SECTNO, Types.NUMERIC),
												new SqlParameter(Constants.CONST_PROC_COL_NAME_P_USER, Types.VARCHAR)
												
										);
		Map<String, Object>		paramMap	=	new HashMap<String, Object>();
		paramMap.put(Constants.CONST_PROC_COL_NAME_P_STDNO, dropWDTO.getStudentNo());
		paramMap.put(Constants.CONST_PROC_COL_NAME_P_SECTCD, dropWDTO.getSectCode());
		paramMap.put(Constants.CONST_PROC_COL_NAME_P_SECTNO, dropWDTO.getSectionNo());
		paramMap.put(Constants.CONST_PROC_COL_NAME_P_USER, dropWDTO.getUserName());
		
		try
		{
			resultProc	=	simpleJdbcCallDpsDropW.execute(paramMap);
		}
		catch(BadSqlGrammarException badGrException)
		{
			logger.error("Might be a grammatical issue in stored procedure");
			throw new NotSuccessFulDBUpdate(badGrException.getMessage());
		}
		catch(UncategorizedSQLException exception)
		{
			logger.error("Course drop not successful for student no : {}, course no {} . Details : {} - {}",dropWDTO.getStudentNo(), dropWDTO.getCourseNo(),exception.getSQLException().getErrorCode(),exception.getSQLException().getMessage());
			throw new NotSuccessFulDBUpdate(exception.getMessage());
			
		}
		
		return resultProc;
	}
	
	
	
}
