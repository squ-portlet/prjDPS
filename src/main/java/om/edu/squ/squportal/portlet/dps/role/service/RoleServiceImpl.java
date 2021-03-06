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
import java.util.List;
import java.util.Locale;

import javax.xml.transform.stream.StreamSource;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalStatus;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
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
	 * method name  : getRoles
	 * @param formName
	 * @return
	 * RoleDbImpl
	 * return type  : List<RoleNameValue>
	 * 
	 * purpose		: Get list of Roles for a particular form
	 *
	 * Date    		:	Jul 16, 2017 3:24:28 PM
	 */
	public List<RoleNameValue> getRoles(String formName, Locale locale)
	{
		return roleDbDao.getRoles(formName, locale);
	}
	
	/**
	 * 
	 * method name  : getApprovalStatus
	 * @param studentNo
	 * @param formName
	 * @param roleName
	 * @param locale
	 * @return
	 * RoleDbImpl
	 * return type  : ApprovalStatus
	 * 
	 * purpose		: Get Approval Status Description 
	 * 				  of a particular student 
	 * 				  for a particular form 
	 * 				  and a particular role of an approver
	 *
	 * Date    		:	Jul 17, 2017 12:00:24 PM
	 * @throws NotCorrectDBRecordException 
	 */
	public ApprovalStatus	getApprovalStatus(String studentNo, String formName, String roleName, Locale locale) throws NotCorrectDBRecordException
	{
		return roleDbDao.getApprovalStatus(studentNo, formName, roleName, locale);
	}
	
	/**
	 * 
	 * method name  : getApprovalStatusDescription
	 * @param statusCodeName
	 * @return
	 * RoleDbImpl
	 * return type  : ApprovalStatus
	 * 
	 * purpose		: Get description of status with respective to status code name (Abbreviation)
	 *
	 * Date    		:	Jul 18, 2017 4:26:31 PM
	 */
	public ApprovalStatus	getApprovalStatusDescription(String statusCodeName)
	{
		return roleDbDao.getApprovalStatusDescription(statusCodeName);
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
					employee.setCollegeAsstDeanP(roleDbDao.isAsstDeanP(empNumber));
					employee.setCollegeDean(roleDbDao.isCollegeDean(empNumber));
					employee.setDpsDean(roleDbDao.isDpsDean(empNumber));
					employee.setDpsStaff(roleDbDao.isDpsAdminStaff(empNumber));
					
		return employee;
	}
	
	@Override
	public ApprovalDTO	getApprovalCode(String formName, String roleName)
	{
		return roleDbDao.getApprovalCode(formName, roleName);
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
		return roleDbDao.getStatusCode(statusCodeName);
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
	public int setRoleTransaction(ApprovalTransactionDTO transactionDTO)
	{
		return roleDbDao.setRoleTransaction(transactionDTO);
	}
	
}
