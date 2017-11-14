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
 * File Name			:	GradeChangeController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.controller
 * Date of creation		:	Nov 13, 2017  3:31:20 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.controller;

import java.util.Locale;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
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
public class GradeChangeController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao	dpsServiceDao;
	
	@RequestMapping
	private	String welcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
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
		
		model.addAttribute("employee", employee);
		model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
		model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
		
		return "/grade/gradechange/approver/welcomeGradeChangeApprover";
	}
}
