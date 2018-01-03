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
 * File Name			:	IncompleteGradeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.db
 * Date of creation		:	Jan 3, 2018  9:23:12 AM
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.db;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class IncompleteGradeDBImpl implements IncompleteGradeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private		Properties					queryProps;
	private		Properties					queryIncompleteGrade;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsIncompleteGrade;
	
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryIncompleteGrade
	 * @param queryIncompleteGrade the queryIncompleteGrade to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setQueryIncompleteGrade(Properties queryIncompleteGrade)
	{
		this.queryIncompleteGrade = queryIncompleteGrade;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsIncompleteGrade
	 * @param nPJdbcTemplDpsIncompleteGrade the nPJdbcTemplDpsIncompleteGrade to set
	 * 
	 * Date          : Jan 3, 2018 10:13:01 AM
	 */
	public void setnPJdbcTemplDpsIncompleteGrade(
			NamedParameterJdbcTemplate nPJdbcTemplDpsIncompleteGrade)
	{
		this.nPJdbcTemplDpsIncompleteGrade = nPJdbcTemplDpsIncompleteGrade;
	}
	
	
	
	
	
}
