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

import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

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
	
}
