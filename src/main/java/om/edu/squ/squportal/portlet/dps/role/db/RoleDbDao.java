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
 * File Name			:	RoleDbDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.db
 * Date of creation		:	Jan 5, 2017  5:25:01 PM
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

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;


/**
 * @author Bhabesh
 *
 */
public interface RoleDbDao
{
	/**
	 * 
	 * method name  : getRoles
	 * @param formName
	 * @param locale TODO
	 * @return
	 * RoleDbImpl
	 * return type  : List<RoleNameValue>
	 * 
	 * purpose		: Get list of Roles for a particular form
	 *
	 * Date    		:	Jul 16, 2017 3:24:28 PM
	 */
	public List<RoleNameValue> getRoles(String formName, Locale locale);

	/**
	 * 
	 * method name  : getRoleStatus
	 * @param studentNo
	 * @param formName
	 * @param roleName
	 * @param locale
	 * @return
	 * RoleDbImpl
	 * return type  : String
	 * 
	 * purpose		: Get Role Status Description 
	 * 				  of a particular student 
	 * 				  for a particular form 
	 * 				  and a particular role of an approver
	 *
	 * Date    		:	Jul 17, 2017 12:00:24 PM
	 * @throws NotCorrectDBRecordException 
	 */
	public String	getRoleStatus(String studentNo, String formName, String roleName, Locale locale) throws NotCorrectDBRecordException;
	
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
	public boolean isSupervisor(String empNumber);
	
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
	public boolean isAdvisor(String empNumber);
	
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
	public boolean isHod(String empNumber);
	
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
	public boolean isAsstDeanP(String empNumber);
	
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
	public boolean isCollegeDean(String empNumber);
	
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
	public boolean isDpsDean(String empNumber);
	
	/**
	 * 
	 * method name  : getApprovalCode
	 * @param formName
	 * @param roleName
	 * @return
	 * RoleDbDao
	 * return type  : ApprovalDTO
	 * 
	 * purpose		: Get Approval details for a form and roleName
	 *
	 * Date    		:	Mar 1, 2017 5:30:35 PM
	 */
	public ApprovalDTO	getApprovalCode(String formName, String roleName);
	
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
	public String	getStatusCode(String statusCodeName);
	
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
	public int setRoleTransaction(ApprovalTransactionDTO transactionDTO);
	
}
