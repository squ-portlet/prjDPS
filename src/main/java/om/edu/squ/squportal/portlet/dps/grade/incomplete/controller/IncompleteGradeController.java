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
 * File Name			:	IncompleteGradeController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.controller
 * Date of creation		:	Jan 3, 2018  9:15:06 AM
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.controller;

import java.util.Locale;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

/**
 * @author Bhabesh
 *
 */
@Controller
@RequestMapping("VIEW")
public class IncompleteGradeController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	IncompleteGradeService	incompleteGradeService;
	
	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * IncompleteGradeController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 3, 2018 10:25:56 AM
	 */
	@RequestMapping
	private	String welcome(PortletRequest request, Model model, Locale locale)
	{
		User	user	=	dpsServiceDao.getUser(request);
		if(user.getUserType().equals(Constants.USER_TYPE_STUDENT))
		{
			return null;
		}
		else
		{
			return approverWelcome(request,model,locale);
		}
	}
	
	
	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * IncompleteGradeController
	 * return type  : String
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Jan 3, 2018 10:25:52 AM
	 */
	private String approverWelcome(PortletRequest request, Model model, Locale locale)
	{
		Employee employee	=	null;
		String	employeeNumber	=	null;
		Gson	gson			=	new Gson();
		
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale);
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("No records available. Probably user doesnot logged in ");
		}
		
		boolean booRule = incompleteGradeService.isRuleComplete();
		
		if(null == employee)
		{
			model.addAttribute("empSISValid", false);
		}
		else
		{
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employeeNumber	=	employee.getEmpNumber().substring(1);
			}
			logger.info("courseList : "+gson.toJson(incompleteGradeService.getCourseList(employeeNumber, locale)));
			model.addAttribute("empSISValid", true);
			model.addAttribute("courseList", incompleteGradeService.getCourseList(employeeNumber, locale));
			model.addAttribute("employee", employee);
			model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
			model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
			model.addAttribute("roleDpsStaff", Constants.CONST_SQL_ROLE_NAME_DPS_STAFF);
		}
		return "/grade/incomplete/approver/welcomeIncompleteGradeApprover";
	}
	
}
