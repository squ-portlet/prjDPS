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
 * File Name			:	ActivitiDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.activiti.dao.db
 * Date of creation		:	Jan 3, 2017  11:25:04 AM
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
package om.edu.squ.squportal.portlet.dps.activiti.dao.db;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Bhabesh
 *
 */
public class ActivitiDbImpl
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
/*	
	
	public ProcessEngine getProcessEngine()
	{
		logger.info ("driver class name : "+PropsUtil.get("jdbc.default.driverClassName"));
		
		ProcessEngine		processEngine		=	ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration()
				.setJdbcDriver(PropsUtil.get("jdbc.default.driverClassName"))
				.setJdbcUrl(PropsUtil.get("jdbc.default.url"))
				.setJdbcUsername(PropsUtil.get("jdbc.default.username"))
				.setJdbcPassword(PropsUtil.get("jdbc.default.password"))
				.setDatabaseSchemaUpdate("true")
				.buildProcessEngine();
		return processEngine;
	}
	
	
	public ProcessInstance getProcessInstance(String strProcessName)
	{
		ProcessEngine processEngine	=	getProcessEngine();
		
		return null;
	}
*/	
}
