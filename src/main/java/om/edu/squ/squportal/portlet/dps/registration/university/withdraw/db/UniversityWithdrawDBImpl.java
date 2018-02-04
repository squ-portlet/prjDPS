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

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	
	
}
