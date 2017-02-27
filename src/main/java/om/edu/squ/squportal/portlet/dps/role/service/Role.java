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
 * File Name			:	Role.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.service
 * Date of creation		:	Feb 8, 2017  2:26:24 PM
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
package om.edu.squ.squportal.portlet.dps.role.service;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import om.edu.squ.squportal.portlet.dps.bo.Employee;

/**
 * @author Bhabesh
 *
 */
public interface Role
{
	/**
	 * 
	 * method name  : getRuleXmlToRoleObject
	 * @param xmlFile
	 * @return
	 * @throws IOException
	 * RoleServiceImpl
	 * return type  : Object
	 * 
	 * purpose		: Convert XML to Object (Unmarshalling)
	 *
	 * Date    		:	Feb 8, 2017 2:17:51 PM
	 */
	public Object getXmlToRoleObject(String xmlFile) throws IOException;
	
	/**
	 * 
	 * method name  : getEmployeeRole
	 * @param empNumber
	 * @return
	 * RoleServiceImpl
	 * return type  : Employee
	 * 
	 * purpose		: Get individual employee role
	 *
	 * Date    		:	Feb 13, 2017 5:51:43 PM
	 */
	public Employee getEmployeeRole(String empNumber);
}
