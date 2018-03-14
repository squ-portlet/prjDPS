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
 * File Name			:	UniversityWithdrawDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db
 * Date of creation		:	Feb 4, 2018  8:48:14 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.CodeValue;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;
import om.edu.squ.squportal.portlet.dps.tags.RoleTagGlyphicon;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class UniversityWithdrawDBImpl implements UniversityWithdrawDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private		Properties					queryProps;
	private		Properties					queryUniversityWithdraw;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsUniversityWithdraw;
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Feb 4, 2018 12:52:31 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryUniversityWithdraw
	 * @param queryUniversityWithdraw the queryUniversityWithdraw to set
	 * 
	 * Date          : Feb 4, 2018 12:52:31 PM
	 */
	public void setQueryUniversityWithdraw(Properties queryUniversityWithdraw)
	{
		this.queryUniversityWithdraw = queryUniversityWithdraw;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsUniversityWithdraw
	 * @param nPJdbcTemplDpsUniversityWithdraw the nPJdbcTemplDpsUniversityWithdraw to set
	 * 
	 * Date          : Feb 4, 2018 12:52:31 PM
	 */
	public void setnPJdbcTemplDpsUniversityWithdraw(
			NamedParameterJdbcTemplate nPJdbcTemplDpsUniversityWithdraw)
	{
		this.nPJdbcTemplDpsUniversityWithdraw = nPJdbcTemplDpsUniversityWithdraw;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao#canStudentApply()
	 */
	@Override
	public boolean canStudentApply()
	{
		int 	countRecord								=	0;
		int 	countReject								=	0;
		String	SQL_UNIVERSITY_WITHDRAW_COUNT_REC		=	queryUniversityWithdraw.getProperty(Constants.CONST_SQL_UNIVERSITY_WITHDRAW_COUNT_REC);
		String	SQL_UNIVERSITY_WITHDRAW_COUNT_REJECT	=	queryUniversityWithdraw.getProperty(Constants.CONST_SQL_UNIVERSITY_WITHDRAW_COUNT_REJECT);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		countRecord	=	nPJdbcTemplDpsUniversityWithdraw.queryForInt(SQL_UNIVERSITY_WITHDRAW_COUNT_REC, namedParameterMap);
		
		namedParameterMap.put("paramRejectStatusCode", Constants.CONST_SQL_STATUS_CODE_REJCT);
		countReject = nPJdbcTemplDpsUniversityWithdraw.queryForInt(SQL_UNIVERSITY_WITHDRAW_COUNT_REJECT, namedParameterMap);
		
		if(countRecord==0)
		{
			return true;
		}
		else
		{
			if(countReject == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao#getReasons(boolean, java.util.Locale)
	 */
	@Override
	public List<CodeValue>  getReasons(boolean isStudent, Locale locale )
	{
		String	SQL_UNIVERSITY_WITHDRAW_REASON_LIST_STUDENT	=	queryUniversityWithdraw.getProperty(Constants.CONST_SQL_UNIVERSITY_WITHDRAW_REASON_LIST_STUDENT);
		
		RowMapper<CodeValue> rowMapper	=	new RowMapper<CodeValue>()
		{
			
			@Override
			public CodeValue mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				CodeValue	codeValue	=	 new CodeValue();
				codeValue.setCode(rs.getString(Constants.CONST_COLMN_SISCODECD));
				codeValue.setValue(rs.getString(Constants.CONST_COLMN_SISCODENAME));

				return codeValue;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsUniversityWithdraw.query(SQL_UNIVERSITY_WITHDRAW_REASON_LIST_STUDENT, namedParameterMap, rowMapper);
		
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao#setUniversityWithdrawByStudent(java.lang.Double, om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO)
	 */
	@Override
	public int setUniversityWithdrawByStudent(Double sequenceNumber, UniversityWithdrawDTO dto)
	{
		String SQL_UNIVERSITY_WITHDRAW_INSERT_APPLY_BY_STUDENT	=	queryUniversityWithdraw.getProperty(Constants.CONST_SQL_UNIVERSITY_WITHDRAW_INSERT_APPLY_BY_STUDENT);
		
		Map<String, String> 	namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramSeqenceNum",String.valueOf(sequenceNumber));
		namedParameterMap.put("paramStdStatCode",dto.getStudentStatCode() );
		namedParameterMap.put("paramStdNo",dto.getStudentNo() );
		namedParameterMap.put("paramReasonCode",dto.getReasonCode() );
		namedParameterMap.put("paramYear",dto.getToCCYearCode() );
		namedParameterMap.put("paramSem",dto.getToSemCode());
		namedParameterMap.put("paramStatusCode",Constants.CONST_SQL_STATUS_CODE_NAME_PENDING );
		namedParameterMap.put("paramUserName",dto.getUserName());
		
		logger.info("namedParameterMap : "+namedParameterMap);
		try
		{
			return nPJdbcTemplDpsUniversityWithdraw.update(SQL_UNIVERSITY_WITHDRAW_INSERT_APPLY_BY_STUDENT, namedParameterMap);
		}
		catch(BadSqlGrammarException sqlEx)
		{
			logger.error("Error in Database record insert :: details : {}",sqlEx.getMessage());
			return 0;
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao#getUniversityWithdrawDataForStudent(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<UniversityWithdrawDTO> getUniversityWithdrawDataForStudent(String studentNo, Locale locale)
	{
		String	SQL_UNIVERSITY_WITHDRAW_SELECT_RECORDS_BY_STUDENT	=	queryUniversityWithdraw.getProperty(Constants.CONST_SQL_UNIVERSITY_WITHDRAW_SELECT_RECORDS_BY_STUDENT);
		
		RowMapper<UniversityWithdrawDTO> rowMapper	=	new RowMapper<UniversityWithdrawDTO>()
		{
			
			@Override
			public UniversityWithdrawDTO mapRow(ResultSet rs, int rowNum)
					throws SQLException
			{
				UniversityWithdrawDTO	dto	=	new UniversityWithdrawDTO();
				Advisor		advisor		=	new Advisor();
				Supervisor	supervisor	=	new Supervisor();
				CollegeDean	collegeDean	=	new CollegeDean();
				DpsDean		dpsDean		=	new DpsDean();
				
					dto.setApplyDate(rs.getString(Constants.COST_COL_DPS_CREATE_DATE));
					dto.setToCCYearCode(rs.getString(Constants.COST_COL_DPS_COURSE_YEAR));
					dto.setToSemCode(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
					dto.setToSemName(rs.getString(Constants.COST_COL_DPS_SEMESTER_NAME));
					dto.setReason(rs.getString(Constants.CONST_COLMN_REASON));
					dto.setStatusDescription(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
					dto.setComments(rs.getString(Constants.CONST_COLMN_COMMENT));

					if(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME).equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
					{
						dto.setStatusReject(true);
					}					
					
					if(rs.getString(Constants.CONST_COLMN_STUDENT_HAS_THESIS).equals(Constants.CONST_YES))
					{
						supervisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_SUPERVISOR));
						supervisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS));
						supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS)));
						
						advisor.setRoleStatus(Constants.CONST_NOT_USED);
						advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(Constants.CONST_NOT_USED));
					}
					else
					{
						advisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_ADVISOR));
						advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
						advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS)));
						
						supervisor.setRoleStatus(Constants.CONST_NOT_USED);
						supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(Constants.CONST_NOT_USED));					
					}
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
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_UNIVERSITY_WITHDRAWAL);
		
		
		return nPJdbcTemplDpsUniversityWithdraw.query(SQL_UNIVERSITY_WITHDRAW_SELECT_RECORDS_BY_STUDENT, namedParameterMap, rowMapper);
	}
	
}
