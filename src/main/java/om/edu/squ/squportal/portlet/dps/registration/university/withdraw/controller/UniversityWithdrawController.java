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
 * File Name			:	UniversityWithdrawController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.controller
 * Date of creation		:	Feb 4, 2018  10:25:47 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import om.edu.squ.squportal.portlet.dps.bo.CodeValue;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
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
public class UniversityWithdrawController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	UniversityWithdrawService universityWithdrawService;
	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * UniversityWithdrawController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 4, 2018 1:38:32 PM
	 */
	@RequestMapping
	private String welcome(PortletRequest request, Model model,Locale locale)
	{
		User	user	=	dpsServiceDao.getUser(request);
		
		/**** Security - data encryption keys *****/
		model.addAttribute("cryptoIterationCount", Crypto.CRYPTO_ITERATION_COUNT);
		model.addAttribute("cryptoKeySize", Crypto.CRYPTO_KEY_SIZE);
		model.addAttribute("cryptoPassPhrase", Crypto.CRYPTO_PASSCODE);
		/* ************************************* */
		
		model.addAttribute("statusProgress", Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
		model.addAttribute("statusPending", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		model.addAttribute("isUserTypeStudent", user.getUserType().equals(Constants.USER_TYPE_STUDENT));		
		
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
	 * UniversityWithdrawController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 4, 2018 1:38:37 PM
	 */
	private	String studentWelcome(PortletRequest request, Model model, Locale locale)
	{
		
		//model.addAttribute("lstReasonStudents", lstReasonStudents);
		model.addAttribute("isStudent", true);
		
		return "/registration/universityWithdraw/student/welcomeUniversityWithdrawStudent";
	}

	/**
	 * 
	 * method name  : resourceStudentWelcome
	 * @param request
	 * @param response
	 * @param locale
	 * UniversityWithdrawController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 6, 2018 10:46:33 AM
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourceStudentReasons")
	private	void resourceStudentReasons(
									ResourceRequest		request
								,	ResourceResponse	response
								,	Locale				locale		
							) throws IOException
	{
		Gson			gson				=	new Gson();
		try
			{	List<CodeValue> lstReasonStudents	=	universityWithdrawService.getReasons(true, locale);
				response.getWriter().print(gson.toJson(lstReasonStudents));
			}
		catch(Exception ex)
		{
			response.setProperty(response.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
		}
	}
	
	
	
	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * UniversityWithdrawController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Feb 4, 2018 1:38:42 PM
	 */
	private	String approverWelcome(PortletRequest request, Model model, Locale locale)
	{
		return "/registration/universityWithdraw/approver/welcomeUniversityWithdrawApprover";
	}
}
