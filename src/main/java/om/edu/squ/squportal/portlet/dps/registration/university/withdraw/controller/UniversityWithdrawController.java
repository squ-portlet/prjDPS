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
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.model.UniversityWithdrawModel;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
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
	 * @throws NotCorrectDBRecordException 
	 */
	@RequestMapping
	private String welcome(PortletRequest request, Model model,Locale locale) throws NotCorrectDBRecordException
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
	 * @throws NotCorrectDBRecordException 
	 */
	private	String studentWelcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		model.addAttribute("isStudent", true);
		model.addAttribute("canStudentApply", universityWithdrawService.canStudentApply());
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
	 * method name  : resourceGetUniversityWithdrawDataForStudent
	 * @param request
	 * @param response
	 * @param locale
	 * UniversityWithdrawController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 14, 2018 9:13:30 AM
	 */
	@ResourceMapping(value="resourceStudentApplications")
	private void resourceGetUniversityWithdrawDataForStudent
															(
																		ResourceRequest		request
																	,	ResourceResponse	response
																	,	Locale				locale	
															)
	{
		Gson								gson			=	new Gson();
		try
		{
			User							user			=	dpsServiceDao.getUser(request);
			Student 						student			= 	dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
			List<UniversityWithdrawDTO>		dtos			=	universityWithdrawService.getUniversityWithdrawDataForStudent(student.getAcademicDetail().getStudentNo(), locale);
			response.getWriter().print(gson.toJson(dtos));
		}
		catch (Exception ex)
		{
			logger.error("error : "+ex.getMessage());
			response.setProperty(response.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
		}
	}
	
	  
	
	
	
	/**
	 * 
	 * method name  : resourceSetUniversityWithdrawByStudent
	 * @param model
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * UniversityWithdrawController
	 * return type  : void
	 * 
	 * purpose		: Request submitted by student for withdrawal from university
	 *
	 * Date    		:	Feb 18, 2018 1:37:32 PM
	 */
	@ResourceMapping(value="resourceStudentSubmit")
	private	void resourceSetUniversityWithdrawByStudent
														(		@ModelAttribute ("universityWithdrawModel") UniversityWithdrawModel model
																,	ResourceRequest		request
																,	ResourceResponse	response
																,	Locale				locale		
														) throws IOException
	{
		Gson			gson					=	new Gson();
		try
		{
			List<UniversityWithdrawDTO>	dtoResult	=	null;
			User					user			=	dpsServiceDao.getUser(request);
			Student 				student			= 	dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
			UniversityWithdrawDTO 	dto				=	new UniversityWithdrawDTO();
			dto.setReasonCode(model.getReasonCode());
			dto.setStudentNo(student.getAcademicDetail().getStudentNo());
			dto.setStudentStatCode(student.getAcademicDetail().getStdStatCode());
			dto.setUserName(request.getRemoteUser());
			dtoResult	=	universityWithdrawService.setUniversityWithdrawByStudent(dto, locale);
			response.getWriter().print(gson.toJson(dtoResult));
		}
		catch(Exception ex)
		{
			logger.error("error : "+ex.getMessage());
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
		
		return "/registration/universityWithdraw/approver/welcomeUniversityWithdrawApprover";
	}
	
	
	/**
	 * 
	 * method name  : getResourceDataforUnivWithdraw
	 * @param roleNameValue
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * UniversityWithdrawController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 26, 2018 2:19:46 PM
	 */
	@ResourceMapping(value="resourceUniversityWithdrawByRole")
	private void getResourceDataforUnivWithdraw(
													@ModelAttribute("roleNameValue") RoleNameValue roleNameValue,
													ResourceRequest request, ResourceResponse response, Locale locale
												) throws IOException
	{
		Gson		gson		=	new Gson();
		Employee 	employee	=	null;
		
		
		try{
			employee	=	dpsServiceDao.getEmployee(request,locale);
			List<UniversityWithdrawDTO>		dtos	=	universityWithdrawService.getUniversityWithdrawRecordsForApprover(roleNameValue.getRoleValue(), employee, locale);
			response.getWriter().print(gson.toJson(dtos));
		}
		catch(ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		
	}
	
}
