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
 * File Name			:	PostponeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.db
 * Date of creation		:	May 25, 2017  1:50:58 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeDTO;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.tags.RoleTagGlyphicon;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bhabesh
 *
 */
public class PostponeDBImpl implements PostponeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private		Properties					queryProps;
	private		Properties					queryPostpone;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsPostpone;

	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : May 25, 2017 2:20:08 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryPostpone
	 * @param queryPostpone the queryPostpone to set
	 * 
	 * Date          : May 25, 2017 2:20:08 PM
	 */
	public void setQueryPostpone(Properties queryPostpone)
	{
		this.queryPostpone = queryPostpone;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsPostpone
	 * @param nPJdbcTemplDpsPostpone the nPJdbcTemplDpsPostpone to set
	 * 
	 * Date          : May 25, 2017 4:14:10 PM
	 */
	public void setnPJdbcTemplDpsPostpone(
			NamedParameterJdbcTemplate nPJdbcTemplDpsPostpone)
	{
		this.nPJdbcTemplDpsPostpone = nPJdbcTemplDpsPostpone;
	}
	
	/**
	 * 
	 * method name  : getPostponeReasons
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeReason>
	 * 
	 * purpose		: Get list of default reasons for postpone 
	 *
	 * Date    		:	May 25, 2017 4:15:05 PM
	 */
	public List<PostponeReason> getPostponeReasons(Locale locale)
	{
		String	SQL_POSTPONE_REASONS		=	queryPostpone.getProperty(Constants.CONST_SQL_POSTPONE_REASONS);
		
		RowMapper<PostponeReason> rowMapper	=	new RowMapper<PostponeReason>()
		{
			
			@Override
			public PostponeReason mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				PostponeReason	postponeReason	=	new PostponeReason();
				postponeReason.setSiscodecd(rs.getString(Constants.CONST_COLMN_SISCODECD));
				postponeReason.setReasonName(rs.getString(Constants.CONST_COLMN_POSTPONE_REASON_NAME));
				return postponeReason;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsPostpone.query(SQL_POSTPONE_REASONS,namedParameterMap,rowMapper);
	}
	
	/**
	 * 
	 * method name  : getPostponesForStudents
	 * @param studentNo
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: List of postponed studies requested by a particular student
	 *
	 * Date    		:	Aug 10, 2017 9:40:55 AM
	 */
	public List<PostponeDTO> getPostponesForStudents(String studentNo, Locale locale)
	{
		String	SQL_POSTPONE_SELECT_RECORDS_BY_STUDENT		=	queryPostpone.getProperty(Constants.CONST_SQL_POSTPONE_SELECT_RECORDS_BY_STUDENT);
		RowMapper<PostponeDTO> rowMapper	=	new RowMapper<PostponeDTO>()
		{
			
			@Override
			public PostponeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				PostponeDTO	dto			=	new PostponeDTO();
				Advisor		advisor		=	new Advisor();
				Supervisor	supervisor	=	new Supervisor();
				CollegeDean	collegeDean	=	new CollegeDean();
				DpsDean		dpsDean		=	new DpsDean();
				
				dto.setActivityDate(rs.getString(Constants.COST_COL_DPS_CREATE_DATE));
				dto.setToCcYearCode(rs.getString(Constants.COST_COL_DPS_TO_COURSE_YEAR_CODE));
				dto.setToSemCode(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
				dto.setToSemName(rs.getString(Constants.COST_COL_DPS_SEMESTER_NAME));
				if(null != rs.getString(Constants.CONST_COLMN_POSTPONE_OTHER_REASON) )
				{
					dto.setReasonDesc(rs.getString(Constants.CONST_COLMN_POSTPONE_OTHER_REASON));
				}
				else
				{
					dto.setReasonDesc(rs.getString(Constants.CONST_COLMN_POSTPONE_REASON_NAME));
				}
				advisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_ADVISOR));
				advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
				advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS)));
				
				supervisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_SUPERVISOR));
				supervisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS));
				supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS)));
				
				collegeDean.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_COLLEGE_DEAN));
				collegeDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS));
				collegeDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS)));				

				dpsDean.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_DPS_DEAN));
				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));
				dpsDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS)));					
				
				dto.setAdvisor(advisor);
				dto.setSupervisor(supervisor);
				dto.setCollegeDean(collegeDean);
				dto.setDpsDean(dpsDean);
				
				dto.setStatusCode(rs.getString(Constants.CONST_COLMN_STATUS_CODE));
				dto.setStatusCodeName(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME));
				if(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME).equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
				{
					dto.setStatusReject(true);
				}
				dto.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				
				dto.setCommentEng(rs.getString(Constants.CONST_COLMN_COMMENT));
				
				return dto;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramAdvisorRoleName", Constants.CONST_SQL_ROLE_NAME_ADVISOR);
		namedParameterMap.put("paramSupervisorRoleName", Constants.CONST_SQL_ROLE_NAME_SUPERVISOR);
		namedParameterMap.put("paramColDeanRoleName", Constants.CONST_SQL_ROLE_NAME_COL_DEAN);
		namedParameterMap.put("paramDpsDeanRoleName", Constants.CONST_SQL_ROLE_NAME_DPS_DEAN);
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_POSTPONE_STUDY);
		
		
		return nPJdbcTemplDpsPostpone.query(SQL_POSTPONE_SELECT_RECORDS_BY_STUDENT, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : setPostponeByStudent
	 * @param dto
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Insert to postpone as student
	 *
	 * Date    		:	Aug 7, 2017 5:00:53 PM
	 */
	public int setPostponeByStudent(PostponeDTO dto)
	{
		String	SQL_POSTPONE_INSERT_STUDENT		=	queryPostpone.getProperty(Constants.CONST_SQL_POSTPONE_INSERT_STUDENT);
	
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo",dto.getStudentNo() );
		namedParameterMap.put("paramStdStatCode", dto.getStudentStatCode());
		namedParameterMap.put("paramFromYearCode", dto.getFromCcYearCode());
		namedParameterMap.put("paramFromSemCode", dto.getFromSemCode());
		namedParameterMap.put("paramToYearCode", dto.getToCcYearCode());
		namedParameterMap.put("paramToSemCode", dto.getToSemCode());
		namedParameterMap.put("paramPostponeReasonCode", dto.getReasonCode());
		namedParameterMap.put("paramPostponeReasonOther", dto.getReasonOther());
		namedParameterMap.put("paramPostponeStatusCode", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		namedParameterMap.put("paramUserCode", dto.getUserName());

		try
		{
			return nPJdbcTemplDpsPostpone.update(SQL_POSTPONE_INSERT_STUDENT, namedParameterMap);
		}
		catch(BadSqlGrammarException sqlEx)
		{
			logger.error("Error in Database record insert :: details : {}",sqlEx.getMessage());
			return 0;
		}
		
		
	}
	
	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @param studentNo
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeDTO>
	 * 
	 * purpose		: List of student's postpone details using employee role
	 *
	 * Date    		:	Sep 13, 2017 4:48:56 PM
	 */
	public List<PostponeDTO> getPostponeForApprovers(String roleType, Employee employee, Locale locale, String studentNo)
	{
		String SQL_POSTPONE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE		=	queryPostpone.getProperty(Constants.CONST_SQL_POSTPONE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE);
		RowMapper<PostponeDTO> rowMapper	=	new RowMapper<PostponeDTO>()
		{
			
			@Override
			public PostponeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				PostponeDTO	dto	=	new PostponeDTO();
				Advisor			advisor			=	new Advisor();
				Supervisor		supervisor		=	new Supervisor(); 
				CollegeDean		collegeDean		=	new CollegeDean();
				DpsDean			dpsDean			=	new DpsDean();
				
				dto.setStudentId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				dto.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				dto.setStudentStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				dto.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				dto.setCohort(rs.getString(Constants.CONST_COLMN_COHORT));
				dto.setCollegeName(rs.getString(Constants.CONST_COLMN_COLLEGE_NAME));
				dto.setDegreeName(rs.getString(Constants.CONST_COLMN_DEGREE_NAME));
				
				collegeDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS));
				collegeDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS)));
				
				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));
				dpsDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS)));	
				
				if(rs.getString(Constants.CONST_COLMN_ROLE_IS_APPROVER).equals(Constants.CONST_YES))
				{
					dto.setApprover(true);
				}
				else
				{
					dto.setApprover(false);
				}
				
				if(rs.getString(Constants.CONST_COLMN_STUDENT_HAS_THESIS).equals(Constants.CONST_YES))
				{
					supervisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS));
					supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS)));
					advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
					advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS)));
					
				}
				else
				{
					advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
					advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS)));
					supervisor.setRoleStatus(Constants.CONST_NOT_USED);
					supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(Constants.CONST_NOT_USED));
				}
				dto.setAdvisor(advisor);
				dto.setSupervisor(supervisor);
				dto.setCollegeDean(collegeDean);
				dto.setDpsDean(dpsDean);
				
				return dto;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocal", locale.getLanguage());
		namedParameterMap.put("paramStdNo", null);
		namedParameterMap.put("paramColCode", null);
		namedParameterMap.put("paramAdvisor", null);
		namedParameterMap.put("paramSupervisor", null);
		namedParameterMap.put("paramDeptCode", null);
		namedParameterMap.put("paramRoleName", roleType);
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY);
		namedParameterMap.put("paramEmpNo", employee.getEmpNumber());
		
		namedParameterMap.put("paramAdvisorRoleName", Constants.CONST_SQL_ROLE_NAME_ADVISOR);
		namedParameterMap.put("paramSupervisorRoleName", Constants.CONST_SQL_ROLE_NAME_SUPERVISOR);
		namedParameterMap.put("paramColDeanRoleName", Constants.CONST_SQL_ROLE_NAME_COL_DEAN);
		namedParameterMap.put("paramDpsDeanRoleName", Constants.CONST_SQL_ROLE_NAME_DPS_DEAN);
		
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY);
		
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
		
		
		return nPJdbcTemplDpsPostpone.query(SQL_POSTPONE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : setPostponeStatusOfStudent
	 * @param dto
	 * @return
	 * PostponeDBImpl
	 * return type  : int
	 * 
	 * purpose		: Update status of postpone
	 *
	 * Date    		:	Nov 7, 2017 5:51:48 PM
	 */
	@Transactional
	public int setPostponeStatusOfStudent(PostponeDTO dto)
	{
		String	SQL_POSTPONE_UPDATE_STATUS_STUDENT			=	queryPostpone.getProperty(Constants.CONST_SQL_POSTPONE_UPDATE_STATUS_STUDENT);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", dto.getStudentNo());
		namedParameterMap.put("paramStdStatCode", dto.getStudentStatCode());
		namedParameterMap.put("paramComment", dto.getCommentEng());
		namedParameterMap.put("paramStatusCodeName", dto.getStatusCodeName());
		namedParameterMap.put("paramUserName", dto.getUserName());
		
		return nPJdbcTemplDpsPostpone.update(SQL_POSTPONE_UPDATE_STATUS_STUDENT, namedParameterMap);
		
	}
}
