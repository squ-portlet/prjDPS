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
 * File Name			:	DropWithWController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.controller
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;
import om.edu.squ.squportal.portlet.dps.registration.dropw.service.DropWService;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;

/**
 * @author Bhabesh
 *
 */
@Controller
@RequestMapping("VIEW")
public class DropWithWController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	DropWService	dropWService;

	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * DropWithWController
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
	 * DropWithWController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 27, 2017 4:29:58 PM
	 */
	private String studentWelcome(PortletRequest request, Model model, Locale locale)
	{
		DropCourseModel		dropCourseModel		=	null;
		List<DropWDTO>		dropWDTOs			=	null;
		Gson				gson				=	new Gson();
		
		User				user			=	dpsServiceDao.getUser(request);
		Student				student			=	dpsServiceDao.getStudent(user.getUserId(), locale);
		
		if(!model.containsAttribute("dropCourseModel"))
		{
				dropCourseModel	= new DropCourseModel();
		}
		
		model.addAttribute("dropCourseModel", dropCourseModel);
		model.addAttribute("courseList", dropWService.getCourseList(user.getUserId(), locale));
		model.addAttribute("dropWDTOs", gson.toJson(dropWService.getDropWCourses(student, locale)));
		return "/registration/dropWithW/student/welcomeDropWithWStudent";
	}

	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * DropWithWController
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
		
		model.addAttribute("employee", employee);
		model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
		model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
		
		return "/registration/dropWithW/approver/welcomeDropWithWApprover";
	}

	/**
	 * 
	 * method name  : dropWithWResource
	 * @param dropCourseModel
	 * @param request
	 * @param response
	 * DropWithWController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Apr 10, 2017 4:28:08 PM
	 */
	@ResourceMapping(value="resourceAjaxDropWithW")
	private void dropWithWResource(@ModelAttribute("dropCourseModel") DropCourseModel dropCourseModel, ResourceRequest request, ResourceResponse response, Locale locale)
	{
		Gson			gson			=	new Gson();
		List<DropWDTO>	dropWDTOs		=	null;
		User			user			=	dpsServiceDao.getUser(request);
		Student			student			=	dpsServiceDao.getStudent(user.getUserId(), locale);

		AcademicDetail	academicDetail	=	student.getAcademicDetail();
		academicDetail.setStudentUserName(request.getRemoteUser());
		student.setAcademicDetail(academicDetail);
	
		
		try
		{
			dropWDTOs	=	dropWService.setDropWCourse(student,dropCourseModel, locale);
			response.getWriter().print(gson.toJson(dropWDTOs));
		}
		catch (IOException ex)
		{
			logger.error("Issues with json data processing. details : {}",ex.getMessage());
		}

	}
}
