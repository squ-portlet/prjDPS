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

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import javax.crypto.NoSuchPaddingException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.service.GradeChangeService;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.security.CryptoAES;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;

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
	DpsServiceDao		dpsServiceDao;
	@Autowired
	GradeChangeService	gradeChangeService;
	@Autowired
	Crypto			crypto;
	
	@RequestMapping
	private	String welcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		User	user	=	dpsServiceDao.getUser(request);
		
		/**** Security - data encryption keys *****/
		model.addAttribute("cryptoIterationCount", Crypto.CRYPTO_ITERATION_COUNT);
		model.addAttribute("cryptoKeySize", Crypto.CRYPTO_KEY_SIZE);
		model.addAttribute("cryptoPassPhrase", Crypto.CRYPTO_PASSCODE);
		/* ************************************* */

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
	 * GradeChangeController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 15, 2017 10:26:16 AM
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
		
		return "/grade/gradechange/approver/welcomeGradeChangeApprover";
	}
	
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param gradeChangeModel
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * GradeChangeController
	 * return type  : void
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Nov 16, 2017 4:23:46 PM
	 */
	@ResourceMapping(value="resourceAjaxGetStudentGrades")
	private	void getStudentGrades(@ModelAttribute("gradeChangeModel") GradeChangeModel gradeChangeModel, ResourceRequest request, ResourceResponse response, Locale locale) throws IOException 
	{
		Gson		gson		= 	new Gson();
		String 			studentId		=	crypto.decrypt(gradeChangeModel.getSalt(), gradeChangeModel.getFour(),  gradeChangeModel.getStudentId());
		gradeChangeModel.setStudentId(studentId);
		try
		{
			List<GradeDTO> 	gradeList		=	gradeChangeService.getStudentGrades(dpsServiceDao.getEmpNumber(request), locale, gradeChangeModel);	
			
			response.getWriter().print(gson.toJson(gradeList));
		}
		catch(NoDBRecordException ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
	}
	
	
}
