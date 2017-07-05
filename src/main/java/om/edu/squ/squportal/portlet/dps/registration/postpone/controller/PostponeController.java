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
 * File Name			:	PostponeController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.controller
 * Date of creation		:	May 22, 2017  4:14:33 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.controller;

import java.util.Locale;

import javax.portlet.PortletRequest;

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentDataModel;
import om.edu.squ.squportal.portlet.dps.registration.postpone.service.PostponeService;

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
public class PostponeController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	PostponeService	postponeService;
	
	@RequestMapping
	private	String studentWelcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		User	user	=	dpsServiceDao.getUser(request);
		Student student	= dpsServiceDao.getStudent(user.getUserId(), new Locale("en"));
		
		if(!model.containsAttribute("postponeStudentDataModel"))
		{
			PostponeStudentDataModel	postponeStudentDataModel	=	new PostponeStudentDataModel();
			model.addAttribute("postponeStudentDataModel", postponeStudentDataModel);
		}
		
		model.addAttribute("student", student);
		model.addAttribute("currYearSem", dpsServiceDao.getCurrentYearSemester(locale));
		model.addAttribute("nextYearSemester", dpsServiceDao.getNextYearSemester(locale));
		model.addAttribute("reasonList", postponeService.getPostponeReasons(locale));
		
		return "/registration/postpone/student/welcomePostponeStudent";
	}
}
