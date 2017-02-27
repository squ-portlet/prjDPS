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

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * @author Bhabesh
 *
 */
public class RoleDbImpl implements RoleDbDao
{
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
	
	
	
}
