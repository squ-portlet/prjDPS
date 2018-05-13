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
 * File Name			:	ExtensionDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.db
 * Date of creation		:	Jan 12, 2017  1:36:47 PM
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
package om.edu.squ.squportal.portlet.dps.study.extension.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionReason;
import om.edu.squ.squportal.portlet.dps.tags.RoleTagGlyphicon;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bhabesh
 *
 */
public class ExtensionDbImpl implements ExtensionDbDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	NamedParameterJdbcTemplate	nPJdbcTemplDpsExtension;
	private	Properties					queryProps;
	private	Properties					queryExtensionProps;
	
	
	/**
	 * Setter method : setnPJdbcTemplDpsExtension
	 * @param nPJdbcTemplDpsExtension the nPJdbcTemplDpsExtension to set
	 * 
	 * Date          : Jan 16, 2017 4:50:20 PM
	 */
	public void setnPJdbcTemplDpsExtension(
			NamedParameterJdbcTemplate nPJdbcTemplDpsExtension)
	{
		this.nPJdbcTemplDpsExtension = nPJdbcTemplDpsExtension;
	}
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Jan 16, 2017 9:53:32 AM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryExtensionProps
	 * @param queryExtensionProps the queryExtensionProps to set
	 * 
	 * Date          : Jan 16, 2017 10:05:48 AM
	 */
	public void setQueryExtensionProps(Properties queryExtensionProps)
	{
		this.queryExtensionProps = queryExtensionProps;
	}
	
	
	/**
	 * 
	 * method name  : getExtensionReasons
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionReason>
	 * 
	 * purpose		: Get list of extensions
	 *
	 * Date    		:	Jan 16, 2017 4:52:14 PM
	 */
	public List<ExtensionReason>  getExtensionReasons(Locale locale)
	{
		String SQL_EXTENSION_REASONS		=	queryExtensionProps.getProperty(Constants.CONST_SQL_EXTENSION_REASONS);
		RowMapper<ExtensionReason> 	mapper	=	new RowMapper<ExtensionReason>()
		{
			
			public ExtensionReason mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				ExtensionReason	reason		=	new ExtensionReason();
				reason.setSiscodecd(rs.getString(Constants.CONST_COLMN_SISCODECD));
				reason.setReasonName(rs.getString(Constants.CONST_COLMN_EXTENSION_REASON_NAME));
				return reason;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsExtension.query(SQL_EXTENSION_REASONS, namedParameterMap, mapper);
		
	}
	
	
	/**
	 * 
	 * method name  : setExtensionByStudent
	 * @param extensionDTO
	 * @return
	 * ExtensionDbImpl
	 * return type  : int
	 * 
	 * purpose		:	Insert to extension as student
	 *
	 * Date    		:	Jan 24, 2017 2:02:28 PM
	 */
	public int setExtensionByStudent(ExtensionDTO extensionDTO )
	{
		String SQL_EXTENSION_INSERT_STUDENT		=	queryExtensionProps.getProperty(Constants.CONST_SQL_EXTENSION_INSERT_STUDENT);
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", extensionDTO.getStudentNo());
		namedParameterMap.put("paramStdStatCode", extensionDTO.getStdStatCode());
		namedParameterMap.put("paramFromYearCode", extensionDTO.getFromCcYrCode());
		namedParameterMap.put("paramFromSemCode", extensionDTO.getFromSemCode());
		namedParameterMap.put("paramToYearCode", extensionDTO.getToCcYrCode());
		namedParameterMap.put("paramToSemCode", extensionDTO.getToSemCode());
		namedParameterMap.put("paramUserCode", extensionDTO.getUserCode());
		namedParameterMap.put("paramExtReasonCode", extensionDTO.getReasonCode());
		namedParameterMap.put("paramExtReasonOther", extensionDTO.getReasonOther());
		namedParameterMap.put("paramExtStatusCode", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);

		try
		{
			return nPJdbcTemplDpsExtension.update(SQL_EXTENSION_INSERT_STUDENT, namedParameterMap);
		}
		catch(BadSqlGrammarException sqlEx)
		{
			logger.error("Error in Database record insert :: details : {}",sqlEx.getMessage());
			return 0;
		}
	}
	
	/**
	 * 
	 * method name  : setExtensionStatusOfStudent
	 * @param extensionDTO
	 * @return
	 * ExtensionDbImpl
	 * return type  : int
	 * 
	 * purpose		: Update the status of extension
	 *
	 * Date    		:	Mar 1, 2017 4:45:34 PM
	 */
	@Transactional
	public int setExtensionStatusOfStudent(ExtensionDTO extensionDTO)
	{
		String 	SQL_EXTENSION_UPDATE_STATUS_STUDENT	=	queryExtensionProps.getProperty(Constants.CONST_SQL_EXTENSION_UPDATE_STATUS_STUDENT);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", extensionDTO.getStudentNo());
		namedParameterMap.put("paramStdStatCode", extensionDTO.getStdStatCode());
		namedParameterMap.put("paramComment", extensionDTO.getCommentEng());
		namedParameterMap.put("paramStatusCodeName", extensionDTO.getStatusCodeName());
		namedParameterMap.put("paramUserName", extensionDTO.getUserName());
		
		return nPJdbcTemplDpsExtension.update(SQL_EXTENSION_UPDATE_STATUS_STUDENT, namedParameterMap);
	}
	
	/**
	 * 
	 * method name  : getExtensionsForStudents
	 * @param studentNo
	 * @param studentStatCode
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 7, 2017 3:51:38 PM
	 */
	public List<ExtensionDTO> getExtensionsForStudents(String studentNo, String studentStatCode, Locale locale)
	{
		String SQL_EXTENSION_SELECT_STUDENT_RECORDS		=	queryExtensionProps.getProperty(Constants.CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS);		
		
		RowMapper<ExtensionDTO> mapper	=	new RowMapper<ExtensionDTO>()
		{
			
			public ExtensionDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				ExtensionDTO	extensionDTO	=	new ExtensionDTO();
				Supervisor		supervisor		=	null;
				Advisor			advisor			=	null;			
				CollegeDean		collegeDean		=	new CollegeDean();
				DpsDean			dpsDean			=	new DpsDean();
				
				extensionDTO.setActivitiDate(rs.getString(Constants.COST_COL_DPS_CREATE_DATE));
				extensionDTO.setToCcYrCode(rs.getString(Constants.COST_COL_DPS_TO_COURSE_YEAR_CODE));
				extensionDTO.setToSemCode(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
				extensionDTO.setToSemName(rs.getString(Constants.COST_COL_DPS_SEMESTER_NAME));
				extensionDTO.setReasonCode(rs.getString(Constants.CONST_COLMN_EXTENSION_REASON_CODE));
				if(null != rs.getString(Constants.CONST_COLMN_EXTENSION_OTHER_REASON))
				{
					extensionDTO.setReasonDesc(rs.getString(Constants.CONST_COLMN_EXTENSION_OTHER_REASON));
				}
				else
				{
					extensionDTO.setReasonDesc(rs.getString(Constants.CONST_COLMN_EXTENSION_REASON_NAME));
				}
				
				if(rs.getString(Constants.CONST_COLMN_STUDENT_HAS_THESIS).equals(Constants.CONST_YES))
				{
					supervisor	=	new Supervisor();
					supervisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_SUPERVISOR));
					supervisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS));
					supervisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS)));
				}
				else
				{
					advisor		=	new Advisor();
					advisor.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_ADVISOR));
					advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
					advisor.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS)));

				}
				collegeDean.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_COLLEGE_DEAN));
				collegeDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS));
				collegeDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS)));
				
				dpsDean.setApprovalcode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE_DPS_DEAN));
				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));
				dpsDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS)));
				
				extensionDTO.setAdvisor(advisor);
				extensionDTO.setSupervisor(supervisor);
				extensionDTO.setCollegeDean(collegeDean);
				extensionDTO.setDpsDean(dpsDean);

				extensionDTO.setStatusCode(rs.getString(Constants.CONST_COLMN_STATUS_CODE));
				extensionDTO.setStatusCodeName(rs.getString(Constants.CONST_COLMN_STATUS_CODE_NAME));
				extensionDTO.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				
				extensionDTO.setCommentEng(rs.getString(Constants.CONST_COLMN_COMMENT));

				return extensionDTO;
			}
		};
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", studentNo);
		namedParameterMap.put("paramStdStatCode", studentStatCode);
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramAdvisorRoleName", Constants.CONST_SQL_ROLE_NAME_ADVISOR);
		namedParameterMap.put("paramSupervisorRoleName", Constants.CONST_SQL_ROLE_NAME_SUPERVISOR);
		namedParameterMap.put("paramColDeanRoleName", Constants.CONST_SQL_ROLE_NAME_COL_DEAN);
		namedParameterMap.put("paramDpsDeanRoleName", Constants.CONST_SQL_ROLE_NAME_DPS_DEAN);
				
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_EXTENSION_STUDY);
		
		return nPJdbcTemplDpsExtension.query(SQL_EXTENSION_SELECT_STUDENT_RECORDS, namedParameterMap, mapper);
	}

	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 15, 2017 10:09:55 PM
	 */
	public List<ExtensionDTO> getExtensionsForApprovers(String roleType, Employee employee, Locale locale, String studentNo, final boolean applyDelegation)
	{
		String SQL_EXTENSION_SELECT_STUDENT_RECORDS_BY_EMPLOYEE		=	queryExtensionProps.getProperty(Constants.CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS_BY_EMPLOYEE);	
		RowMapper<ExtensionDTO> 	mapper		=	new RowMapper<ExtensionDTO>()
		{
			
			@Override
			public ExtensionDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				ExtensionDTO	extensionDTO	=	new ExtensionDTO();
				Advisor			advisor			=	new Advisor();
				Supervisor		supervisor		=	new Supervisor(); 
				CollegeDean		collegeDean		=	new CollegeDean();
				DpsDean			dpsDean			=	new DpsDean();
				
				extensionDTO.setStudentId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				extensionDTO.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				//extensionDTO.setStatusCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				extensionDTO.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				extensionDTO.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				extensionDTO.setCohort(rs.getString(Constants.CONST_COLMN_COHORT));
				extensionDTO.setCollegeName(rs.getString(Constants.CONST_COLMN_COLLEGE_NAME));
				extensionDTO.setDegreeName(rs.getString(Constants.CONST_COLMN_DEGREE_NAME));
				
	
				
				
				collegeDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS));
				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));

				if(rs.getString(Constants.CONST_COLMN_ROLE_IS_APPROVER).equals(Constants.CONST_YES))
				{
					extensionDTO.setApprover(true);
				}
				else
				{
					extensionDTO.setApprover(false);
				}
				
				if(rs.getString(Constants.CONST_COLMN_STUDENT_HAS_THESIS).equals(Constants.CONST_YES))
				{
					
					supervisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_SUPERVISOR_STATUS));
					advisor.setRoleStatus(Constants.CONST_NOT_USED);
					
				}
				else
				{
					advisor.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_ADVISOR_STATUS));
					supervisor.setRoleStatus(Constants.CONST_NOT_USED);
					
				}
				extensionDTO.setAdvisor(advisor);
				extensionDTO.setSupervisor(supervisor);
				extensionDTO.setCollegeDean(collegeDean);
				extensionDTO.setDpsDean(dpsDean);
				extensionDTO.setApplyDelegation(applyDelegation);
				return extensionDTO;
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
		return nPJdbcTemplDpsExtension.query(SQL_EXTENSION_SELECT_STUDENT_RECORDS_BY_EMPLOYEE, namedParameterMap, mapper);
	}
	
}
