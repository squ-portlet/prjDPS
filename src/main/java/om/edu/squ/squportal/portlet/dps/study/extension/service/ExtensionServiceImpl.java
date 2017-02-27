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
 * File Name			:	ExtensionServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.service
 * Date of creation		:	Jan 16, 2017  9:48:21 AM
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
package om.edu.squ.squportal.portlet.dps.study.extension.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionReason;
import om.edu.squ.squportal.portlet.dps.study.extension.db.ExtensionDbDao;
import om.edu.squ.squportal.portlet.dps.study.extension.model.ExtensionStudentDataModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class ExtensionServiceImpl implements ExtensionServiceDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	ExtensionDbDao		extensionDbDao;
	
	
	/**
	 * 
	 * method name  : getExtensionReasons
	 * @param locale
	 * @return
	 * ExtensionServiceImpl
	 * return type  : List<ExtensionReason>
	 * 
	 * purpose		: Get list of extensions
	 *
	 * Date    		:	Jan 16, 2017 4:55:44 PM
	 */
	public List<ExtensionReason>  getExtensionReasons(Locale locale)
	{
		return extensionDbDao.getExtensionReasons(locale);
	}
	
	
	/**
	 * 
	 */
	public int setExtensionByStudent(Student student, ExtensionStudentDataModel extensionStudentDataModel, String userName)
	{

		ExtensionDTO	extensionDTO	=	new ExtensionDTO(student, extensionStudentDataModel, userName);
		return extensionDbDao.setExtensionByStudent(extensionDTO);
	}


	/**
	 * 
	 * method name  : getExtensionsForStudents
	 * @param studentNo
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 7, 2017 3:51:38 PM
	 */
	public List<ExtensionDTO> getExtensionsForStudents(String studentNo, Locale locale)
	{
		return extensionDbDao.getExtensionsForStudents(studentNo, locale);
	}


	/**
	 * 
	 * method name  : getExtensionsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * ExtensionDbImpl
	 * return type  : List<ExtensionDTO>
	 * 
	 * purpose		: Get list of students for approvers
	 *
	 * Date    		:	Feb 15, 2017 10:09:55 PM
	 */
	public List<ExtensionDTO> getExtensionsForApprovers(String roleType, Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		return extensionDbDao.getExtensionsForApprovers(roleType, employee, locale);
	}


	
}
