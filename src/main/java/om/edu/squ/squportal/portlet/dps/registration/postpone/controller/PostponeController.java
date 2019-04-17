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

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionDropDownPeriod;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionExtensionExists;
import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeDTO;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentDataModel;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;
import om.edu.squ.squportal.portlet.dps.registration.postpone.service.PostponeService;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

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
public class PostponeController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	PostponeService	postponeService;
	
	@RequestMapping
	private	String welcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		User	user	=	dpsServiceDao.getUser(request);

		/**** Security - data encryption keys *****/
		model.addAttribute("cryptoIterationCount", Crypto.CRYPTO_ITERATION_COUNT);
		model.addAttribute("cryptoKeySize", Crypto.CRYPTO_KEY_SIZE);
		model.addAttribute("cryptoPassPhrase", Crypto.CRYPTO_PASSCODE);
		/* ************************************* */
		
		model.addAttribute("postponeLimit", Constants.CONST_RULE_POSTPONE_STUDENT_MAXIMUM_ALLOWED);
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
	 * @throws NotCorrectDBRecordException
	 * PostponeController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Sep 10, 2017 4:15:57 PM
	 */
	private	String studentWelcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		User			user	=	dpsServiceDao.getUser(request);
		Student 		student	= 	dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
		List<Course> 	courses	=	postponeService.getExistingGrades(student.getAcademicDetail().getStudentNo(), locale);
		
		
		/* Rule applied*/
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			/* test environment only */
			model.addAttribute("isRuleStudentComplete",  true);
		}
		else
		{
			/* Implementing rules */
			model.addAttribute("isRuleStudentComplete",postponeService.isRuleComplete(student.getAcademicDetail().getStudentNo(), student.getAcademicDetail().getStdStatCode()));
			
		}
		
		if(!model.containsAttribute("postponeStudentDataModel"))
		{
			PostponeStudentDataModel	postponeStudentDataModel	=	new PostponeStudentDataModel();
			model.addAttribute("postponeStudentDataModel", postponeStudentDataModel);
		}
		
		if(null == courses || courses.size() == 0)
		{
			model.addAttribute("student", student);
			model.addAttribute("currYearSem", dpsServiceDao.getCurrentYearSemester(locale));
			model.addAttribute("nextYearSemester", dpsServiceDao.getNextYearSemester(locale));
			model.addAttribute("reasonList", postponeService.getPostponeReasons(locale));
		}
		else
		{
			model.addAttribute("existingGrades", courses);
		}
		
		model.addAttribute("isSemesterPostponed", postponeService.isSemesterPostponed(student.getAcademicDetail().getStdStatCode()));
		
		return "/registration/postpone/student/welcomePostponeStudent";
	}


	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * @throws NotCorrectDBRecordException
	 * PostponeController
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Sep 10, 2017 4:16:05 PM
	 */
	private	String approverWelcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		Employee employee	=	null;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, false);
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("No records available. Probably user doesnot logged in ");
		}
		
		model.addAttribute("employee", employee);
		model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
		model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
		
		return "/registration/postpone/approver/welcomePostponeApprover";
	}	
	
	
	/**
	 * 
	 * method name  : resourceSubmitByStudent
	 * @param studentModel
	 * @param request
	 * @param response
	 * @param locale
	 * PostponeController
	 * return type  : void
	 * 
	 * purpose		: Resource mapping for student submit
	 *
	 * Date    		:	Aug 8, 2017 9:02:13 AM
	 * @throws NotCorrectDBRecordException 
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourceStudentSubmit")
	private	void resourceSubmitByStudent(
														@ModelAttribute("studentModel") PostponeStudentModel studentModel
													,	ResourceRequest		request
													,	ResourceResponse	response
													,	Locale				locale				
													
												) 
	{
		Gson				gson				=	new Gson();
		List<PostponeDTO>	postponeDTOs		=	null;
		User				user				=	dpsServiceDao.getUser(request);
		Student 			student				= 	null;
		String				strJson				=	null;
		boolean				isError				=	false;
		boolean				errDropWPeriod		=	false;
		boolean				errExtensionExists	=	false;
		

		
		try
		{
			student			=	dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
			if(null == student || null == student.getAcademicDetail())
			{
				/* Service enquired by staff and not student */
			}
			else
			{
					postponeDTOs = postponeService.setPostponeByStudent(student, studentModel,request.getRemoteUser(), locale);
			}
		}
		catch (NotCorrectDBRecordException ex)
		{
			isError	=	true;
		}
		catch(ExceptionDropDownPeriod exDropPeriod)
		{
			isError			=	true;
			errDropWPeriod 	= 	true;
			logger.error("Exception exDropPeriod : "+exDropPeriod.getMessage());
		}
		catch(ExceptionExtensionExists exExtExists)
		{
			isError				=	true;
			errExtensionExists 	= true;
			logger.error("Postpone not possible. Concerned semester already extended for student Id : {} "+user.getUserId());
		}
		
		
		if(errDropWPeriod )
		{
			strJson = UtilProperty.getMessage("err.dps.service.dropw.period.not.correct", null, locale);
		}
		else 	if(errExtensionExists)
					{
						strJson = UtilProperty.getMessage("err.dps.service.postpone.semester.already.extended", null, locale);
					}
				else
					{
						if((null != postponeDTOs) && (postponeDTOs.size() != 0) )
							{
								strJson	=	gson.toJson(postponeDTOs);
							}
							else
							{
								isError	=	true;
								strJson = UtilProperty.getMessage("err.dps.service.postpone.student.no.postpone.records", null, locale);
							}
					}

		try
		{

			if(isError)
			{
				response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			}

			response.getWriter().print(strJson);


		}
		catch(IOException exIO)
		{
			logger.error("Error in response generation using json at postponement by student, Details {} ",exIO.getMessage());
		}
		

	}
	
	/**
	 * 
	 * method name  : getResourceCoursesforPostpone
	 * @param request
	 * @param response
	 * @param locale
	 * PostponeController
	 * return type  : void
	 * 
	 * purpose		: For Approvers : List of courses for postpone 
	 *
	 * Date    		:	Sep 12, 2017 4:20:21 PM
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourcePostponeDataByRole")
	private void getResourceCoursesforPostpone(
													@ModelAttribute("roleNameValue") RoleNameValue roleNameValue,
													ResourceRequest request, ResourceResponse response, Locale locale
												) throws IOException
	{
		Gson	gson	=	new Gson();
		
		Employee employee	=	null;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, true);
			List<PostponeDTO> dtos	=	postponeService.getPostponeForAprovers(roleNameValue.getRoleValue(), employee, locale, null);
			response.getWriter().print(gson.toJson(dtos));

		}
		catch (ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		catch (NoDBRecordException ex)
		{
			logger.error("DB records not found for employee : {} of role : {}. Details : {}",employee.getEmpNumber(), roleNameValue.getRoleValue(), ex.getMessage());
			
		}
		
		
	}
	
	/**
	 * 
	 * method name  : getResourceDataForApprove
	 * @param postponeDTO
	 * @param request
	 * @param response
	 * @param locale
	 * PostponeController
	 * return type  : void
	 * 
	 * purpose		: Set approver in transaction table
	 *
	 * Date    		:	Nov 6, 2017 6:01:44 PM
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourcePostponeDataApprove")
	private	void getResourceDataForApprove(
												@ModelAttribute ("postponeDTO") PostponeDTO postponeDTO,
												ResourceRequest request, ResourceResponse response,Locale locale
											) throws IOException
	{
				
				Gson		gson		=	new Gson();
				Employee	employee	=	null;
				PostponeDTO	dtoResult	=	null;
				try
				{
					employee		=	dpsServiceDao.getEmployee(request,locale, Constants.CONST_IS_DELEGATION);		
					employee.setUserName(request.getRemoteUser());
					postponeDTO.setUserName(request.getRemoteUser());
					
					dtoResult	=	postponeService.setRoleTransaction(postponeDTO, employee, locale);
					response.getWriter().print(gson.toJson(dtoResult));
					
				}
				catch(Exception ex)
				{
					logger.error("Error in Data generation. Actual error :  "+ex.getMessage());
					response.getWriter().print(gson.toJson(""));
				}
				
				
	}
			
	
}
