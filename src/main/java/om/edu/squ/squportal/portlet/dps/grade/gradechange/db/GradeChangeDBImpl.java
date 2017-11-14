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
 * File Name			:	GradeChangeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.db
 * Date of creation		:	Nov 13, 2017  3:41:32 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.db;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeDBImpl implements GradeChangeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private		Properties					queryProps;
	private		Properties					queryGradeChange;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsGradeChange;
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Nov 13, 2017 3:51:24 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryGradeChange
	 * @param queryGradeChange the queryGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setQueryGradeChange(Properties queryGradeChange)
	{
		this.queryGradeChange = queryGradeChange;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsGradeChange
	 * @param nPJdbcTemplDpsGradeChange the nPJdbcTemplDpsGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setnPJdbcTemplDpsGradeChange(
			NamedParameterJdbcTemplate nPJdbcTemplDpsGradeChange)
	{
		this.nPJdbcTemplDpsGradeChange = nPJdbcTemplDpsGradeChange;
	}
	
	
}
