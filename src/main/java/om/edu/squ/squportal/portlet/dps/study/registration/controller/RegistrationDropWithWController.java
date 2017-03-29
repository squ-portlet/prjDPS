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
 * File Name			:	RegistrationDropWithWController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.registration.controller
 * Date of creation		:	Mar 27, 2017  4:09:21 PM
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
package om.edu.squ.squportal.portlet.dps.study.registration.controller;

import java.util.Locale;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bhabesh
 *
 */
@Controller
@RequestMapping("VIEW")
public class RegistrationDropWithWController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao	dpsServiceDao;

	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * RegistrationDropWithWController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 27, 2017 4:30:05 PM
	 */
	@RequestMapping
	private	String welcome(PortletRequest request, Model model, Locale locale)
	{
		User	user	=	dpsServiceDao.getUser(request);



		if(user.getUserType().equals(Constants.USER_TYPE_STUDENT))
		{
			
			return studentWelcome(request,model,locale);
		}
		else
		{
			return approverWelcome(request,model,locale);
		} 
	}

	/**
	 * 
	 * method name  : studentWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * RegistrationDropWithWController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 27, 2017 4:29:58 PM
	 */
	private String studentWelcome(PortletRequest request, Model model, Locale locale)
	{
		String userName	=	request.getRemoteUser();
		User	user	=	dpsServiceDao.getUser(request);
		Student student	= dpsServiceDao.getStudent(user.getUserId(), new Locale("en"));
		
		return "/registration/dropWithW/student/welcomeDropWithWStudent";
	}

	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * RegistrationDropWithWController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 27, 2017 4:29:52 PM
	 */
	private String approverWelcome(PortletRequest request, Model model, Locale locale)
	{
		
		Employee employee	=	null;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale);
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("No records available. Probably user doesnot logged in ");
		}
		
		return "/registration/dropWithW/approver/welcomeDropWithWApprover";
	}
}
