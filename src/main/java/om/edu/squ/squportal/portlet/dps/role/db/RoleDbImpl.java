/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	RoleDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.db
 * Date of creation		:	Jan 5, 2017  5:25:28 PM
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
package om.edu.squ.squportal.portlet.dps.role.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.utility.Constants;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author Bhabesh
 *
 */
public class RoleDbImpl implements RoleDbDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	NamedParameterJdbcTemplate	nPJdbcTemplDps;
	private	SimpleJdbcCall				simpleJdbcCallDps;
	private	Properties					queryPropsCommonRole;
	/**
	 * Setter method : setnPJdbcTemplDps
	 * @param nPJdbcTemplDps the nPJdbcTemplDps to set
	 * 
	 * Date          : Feb 13, 2017 3:58:47 PM
	 */
	public void setnPJdbcTemplDps(NamedParameterJdbcTemplate nPJdbcTemplDps)
	{
		this.nPJdbcTemplDps = nPJdbcTemplDps;
	}
	/**
	 * Setter method : setSimpleJdbcCallDps
	 * @param simpleJdbcCallDps the simpleJdbcCallDps to set
	 * 
	 * Date          : Feb 13, 2017 3:58:47 PM
	 */
	public void setSimpleJdbcCallDps(SimpleJdbcCall simpleJdbcCallDps)
	{
		this.simpleJdbcCallDps = simpleJdbcCallDps;
	}
	/**
	 * Setter method : setQueryPropsCommonRole
	 * @param queryPropsCommonRole the queryPropsCommonRole to set
	 * 
	 * Date          : Feb 13, 2017 3:58:47 PM
	 */
	public void setQueryPropsCommonRole(Properties queryPropsCommonRole)
	{
		this.queryPropsCommonRole = queryPropsCommonRole;
	}
	
	
	/**
	 * 
	 * method name  : isSupervisor
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee Supervisor
	 *
	 * Date    		:	Feb 13, 2017 4:44:45 PM
	 */
	public boolean isSupervisor(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_SUPERVISOR		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_SUPERVISOR);
		String	result							=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_SUPERVISOR, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
		
	}
	
	/**
	 * 
	 * method name  : isAdvisor
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee advisor
	 *
	 * Date    		:	Feb 13, 2017 4:54:38 PM
	 */
	public boolean isAdvisor(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_ADVISOR		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_ADVISOR);
		String	result							=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_ADVISOR, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
	}
	
	/**
	 * 
	 * method name  : isHod
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee HOD
	 *
	 * Date    		:	Feb 13, 2017 4:58:18 PM
	 */
	public boolean isHod(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_HOD		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_HOD);
		String	result							=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_HOD, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
	}
	
	/**
	 * 
	 * method name  : isAsstDeanP
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee Assistant Dean for Post Graduates
	 *
	 * Date    		:	Feb 13, 2017 5:09:36 PM
	 */
	public boolean isAsstDeanP(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_POST_GRAD_ASST_DEAN		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_POST_GRAD_ASST_DEAN);
		String	result										=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_POST_GRAD_ASST_DEAN, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
	}

	/**
	 * 
	 * method name  : isCollegeDean
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee College Dean
	 *
	 * Date    		:	Feb 13, 2017 5:23:58 PM
	 */
	public boolean isCollegeDean(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_COLLEGE_DEAN		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_COLLEGE_DEAN);
		String	result										=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_COLLEGE_DEAN, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
	}

	/**
	 * 
	 * method name  : isDpsDean
	 * @param empNumber
	 * @return
	 * RoleDbImpl
	 * return type  : boolean
	 * 
	 * purpose		: Is Employee DPS Dean
	 *
	 * Date    		:	Feb 13, 2017 5:28:49 PM
	 */
	public boolean isDpsDean(String empNumber)
	{
		String	PROP_SQL_ROLE_IS_DPS_DEAN		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_IS_DPS_DEAN);
		String	result										=	null;;
		
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramEmpNo", empNumber);
		
		result	=	nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_IS_DPS_DEAN, mapParamsRole, String.class);
		
		return result.equals("Y") ? true : false;
	}
	

	@Override
	public ApprovalDTO	getApprovalCode(String formName, String roleName)
	{
		String	PROP_SQL_ROLE_APPROVAL_CODE		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_APPROVAL_CODE);
		RowMapper<ApprovalDTO> 	mapper			=	new RowMapper<ApprovalDTO>()
		{
			
			@Override
			public ApprovalDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				ApprovalDTO	approvalDTO	=	new ApprovalDTO();
				approvalDTO.setApprovalCode(rs.getString(Constants.CONST_COLMN_APPROVAL_CODE));
				approvalDTO.setApprovalSequenceNo(rs.getInt(Constants.CONST_COLMN_APPROVAL_SEQUENCE));
				approvalDTO.setApprovalMaxSequenceNo(rs.getInt(Constants.CONST_COLMN_APPROVAL_MAX_SEQUENCE));
				return approvalDTO;
			}
		};
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramFormName", formName);
		mapParamsRole.put("paramRoleName", roleName);
		
		return nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_APPROVAL_CODE, mapParamsRole, mapper);
	}
	
	/**
	 * 
	 * method name  : getStatusCode
	 * @param statusCodeName
	 * @return
	 * RoleDbImpl
	 * return type  : String
	 * 
	 * purpose		: Get Status Code
	 *
	 * Date    		:	Feb 27, 2017 9:49:45 PM
	 */
	public String	getStatusCode(String statusCodeName)
	{
		String	PROP_SQL_ROLE_STATUS_CODE		=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_STATUS_CODE);
		Map<String, String> mapParamsRole	=	new HashMap<String, String>();
		mapParamsRole.put("paramStatusCodeName", statusCodeName);
		return nPJdbcTemplDps.queryForObject(PROP_SQL_ROLE_STATUS_CODE, mapParamsRole, String.class);
	}
	

	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param transactionDTO
	 * @return
	 * RoleDbImpl
	 * return type  : int
	 * 
	 * purpose		: add a record in transaction table for approver status for a particular form and authorized employee
	 *
	 * Date    		:	Feb 28, 2017 10:47:05 AM
	 */
	@Transactional
	public int setRoleTransaction(ApprovalTransactionDTO transactionDTO)
	{
		String	PROP_SQL_ROLE_APPROVAL_TRANSACTION	=	queryPropsCommonRole.getProperty(Constants.CONST_PROP_SQL_ROLE_APPROVAL_TRANSACTION);
		
		Map<String, String> mapParamsTransaction	=	new HashMap<String, String>();
		mapParamsTransaction.put("paramStdNo", transactionDTO.getStudentNo() );
		mapParamsTransaction.put("paramStdStatCode", transactionDTO.getStdStatCode() );
		mapParamsTransaction.put("paramApprovalCode", transactionDTO.getApprovalCode());
		mapParamsTransaction.put("paramStatusCode", transactionDTO.getStatusCode());
		mapParamsTransaction.put("paramEmpNo", transactionDTO.getAppEmpNo().substring(1));
		mapParamsTransaction.put("paramUserName",transactionDTO.getAppEmpName() );
		mapParamsTransaction.put("paramComments",transactionDTO.getComments() );
		
		return nPJdbcTemplDps.update(PROP_SQL_ROLE_APPROVAL_TRANSACTION, mapParamsTransaction);
	}
	
}
