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
 * File Name			:	RoleServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role
 * Date of creation		:	Feb 8, 2017  10:57:09 AM
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
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.role.db.RoleDbDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

/**
 * @author Bhabesh
 *
 */
public class RoleServiceImpl implements Role
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	Unmarshaller	unmarshaller;

	@Autowired
	RoleDbDao	roleDbDao;

	
	
	/**
	 * Setter method : setUnmarshaller
	 * @param unmarshaller the unmarshaller to set
	 * 
	 * Date          : Feb 8, 2017 2:10:12 PM
	 */
	public void setUnmarshaller(Unmarshaller unmarshaller)
	{
		this.unmarshaller = unmarshaller;
	}
	
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
	public Object getXmlToRoleObject(String xmlFile) throws IOException
	{
			Resource 		resource 	= new ClassPathResource(xmlFile);

			InputStream 	inputStream	=resource.getInputStream();
			
			return unmarshaller.unmarshal(new StreamSource(inputStream));
	}
	
	
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
	public Employee getEmployeeRole(String empNumber)
	{
		Employee	employee	=	new Employee();
					employee.setAdvisor(roleDbDao.isAdvisor(empNumber));
					employee.setSupervisor(roleDbDao.isSupervisor(empNumber));
					employee.setHod(roleDbDao.isHod(empNumber));
					employee.setCollegeAsstDean(roleDbDao.isAsstDeanP(empNumber));
					employee.setCollegeDean(roleDbDao.isCollegeDean(empNumber));
					employee.setDpsDean(roleDbDao.isDpsDean(empNumber));
					
		return employee;
	}
	
	
	/**
	 * 
	 * method name  : getApprovalCode
	 * @param formName
	 * @param roleName
	 * @return
	 * RoleDbImpl
	 * return type  : String
	 * 
	 * purpose		: Get Approval Code
	 *
	 * Date    		:	Feb 27, 2017 9:01:03 PM
	 */
	public String	getApprovalCode(String formName, String roleName)
	{
		return roleDbDao.getApprovalCode(formName, roleName);
	}
	
	
}
