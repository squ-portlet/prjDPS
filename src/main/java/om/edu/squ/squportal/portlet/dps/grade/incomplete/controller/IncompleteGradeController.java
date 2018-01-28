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

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.model.IncompleteGradeModel;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

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
	@Autowired
	Crypto			crypto;
	
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
	 * IncompleteGradeController
	 * return type  : String
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Jan 3, 2018 10:25:52 AM
	 */
	private String approverWelcome(PortletRequest request, Model model, Locale locale)
	{
		Employee employee		=	null;
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
			model.addAttribute("empSISValid", true);
			model.addAttribute("courseList", incompleteGradeService.getCourseList(employeeNumber, locale));
			model.addAttribute("employee", employee);
			model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
			model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
			model.addAttribute("roleDpsStaff", Constants.CONST_SQL_ROLE_NAME_DPS_STAFF);
		}
		return "/grade/incomplete/approver/welcomeIncompleteGradeApprover";
	}
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param lAbrCourseNo
	 * @param sectionNo
	 * @param response
	 * @param locale
	 * @throws IOException
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		: provide list of students as json
	 *
	 * Date    		:	Jan 8, 2018 6:48:20 PM
	 */
	@ResourceMapping(value="resourceStudentList")
	private	void getStudentList(@RequestParam("lAbrCourseNo") String lAbrCourseNo, @RequestParam("sectionNo") String sectionNo, ResourceRequest request,ResourceResponse response, Locale locale ) throws IOException
	{
		Employee 	employee		=	null;
		String		employeeNumber	=	null;
		Gson		gson			=	new Gson();
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale);
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("No records available. Probably user doesnot logged in ");
		}
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employeeNumber	=	employee.getEmpNumber().substring(1);
		}
		List<GradeIncompleteDTO> studentList	=	incompleteGradeService.getStudentList(employeeNumber, lAbrCourseNo, sectionNo, locale);
		
		response.getWriter().print(gson.toJson(studentList));
	}
	
	/**
	 * 
	 * method name  : getIncompleteGradeNotification
	 * @param incompleteGradeModel
	 * @param request
	 * @param response
	 * @param locale
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		: Send the incompleted grade notification to approvers and show the details to instructor
	 *
	 * Date    		:	Jan 11, 2018 12:49:44 PM
	 * @throws NotCorrectDBRecordException 
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourceAjaxNotify")
	private void getIncompleteGradeNotification(
													@ModelAttribute("incompleteGradeNotifyModel") IncompleteGradeModel incompleteGradeModel
												, 	ResourceRequest 	request
												,	ResourceResponse	response
												,	Locale				locale
												) throws NotCorrectDBRecordException, IOException
	{
		Gson				gson		= 	new Gson();
		GradeIncompleteDTO	dtoResult	=	null;
		
		incompleteGradeModel.decrypt(crypto, incompleteGradeModel.getSalt(), incompleteGradeModel.getFour(), incompleteGradeModel);
		GradeIncompleteDTO	dto	= new GradeIncompleteDTO(incompleteGradeModel);
		dto.setUserName(dpsServiceDao.getEmpNumber(request));

		dtoResult = incompleteGradeService.setInstructorNotifyForIncompleteGrade(dto, locale);
		
		if(null==dtoResult)
		{
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			
		}
		else
		{
			response.getWriter().print(gson.toJson(dtoResult)); 
		}

	}
	
	/**
	 * 
	 * method name  : getIncompleteGradeNotifyHistory
	 * @param recordSequence
	 * @param request
	 * @param response
	 * @param locale
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		: History of the notification details of a student
	 *
	 * Date    		:	Jan 15, 2018 12:48:19 PM
	 * @throws IOException 
	 * @throws NoDBRecordException 
	 */
	@ResourceMapping(value="resourceHistory")
	private void getIncompleteGradeNotifyHistory(	
														@RequestParam("recordSequence") String recordSequence
													, 	ResourceRequest 	request
													,	ResourceResponse	response
													,	Locale				locale
												) throws IOException  
	{
		Gson						gson	=	new Gson();	
		
		
		try
		{
			List<GradeIncompleteDTO> 	dtos	=	incompleteGradeService.getIncompleteNotifyHistory(recordSequence, locale);
			response.getWriter().print(gson.toJson(dtos));
		}
		catch(NoDBRecordException exRec)
		{
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
		}
		
		
	}
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleNameValue
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * @throws NoDBRecordException
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		:Get list of Students details to approvers who applied for grade change
	 *
	 * Date    		:	Jan 17, 2018 11:33:10 AM
	 */
	@ResourceMapping(value="resoureAjaxStudentDataForApproversByRole")
	public void getStudentDetailsForApprovers(@ModelAttribute("roleNameValue") RoleNameValue roleNameValue,
			ResourceRequest request, ResourceResponse response, Locale locale
			) throws IOException, NoDBRecordException
	{
		Gson		gson		= 	new Gson();
		Employee	employee	=	null;
		
		try
		{
			employee					=	dpsServiceDao.getEmployee(request,locale);
			List<Student> 	students	=	incompleteGradeService.getStudentDetailsForApprovers(roleNameValue.getRoleValue(), employee, locale);
			response.getWriter().print(gson.toJson(students));
		}
		catch(ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		
		
	}
	
	
	
	/**
	 * 
	 * method name  : getCourseListForNotify
	 * @param incompleteGradeModel
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		: List of courses with notification for incomple grade request and their approval details
	 *
	 * Date    		:	Jan 18, 2018 3:38:50 PM
	 */
	@ResourceMapping("resourceAjaxCourseListForNotify")
	public void  getCourseListForNotify(
										@ModelAttribute("incompleteGradeNotifyModel") IncompleteGradeModel incompleteGradeModel
										, 	ResourceRequest 	request
										,	ResourceResponse	response
										,	Locale				locale
									) throws IOException
	{
		Gson		gson		= 	new Gson();
		Employee	employee	=	null;
		incompleteGradeModel.decrypt(crypto, incompleteGradeModel.getSalt(), incompleteGradeModel.getFour(), incompleteGradeModel);
		try
		{
										employee		=	dpsServiceDao.getEmployee(request,locale);
			List<GradeIncompleteDTO> 	dtos			=	incompleteGradeService.getCourseListForNotify( 
																											incompleteGradeModel.getStudentNo()
																										, 	incompleteGradeModel.getStdStatCode()
																										, 	incompleteGradeModel.getRoleName()
																										, 	employee
																										, 	locale
																										);
			response.getWriter().print(gson.toJson(dtos));
		}
		catch(ExceptionEmptyResultset ex)
		{
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			response.getWriter().print(gson.toJson(""));
		}
		
	}
	
	/**
	 * 
	 * method name  : incompleteGradeNotificationApproval
	 * @param incompleteGradeModel
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * IncompleteGradeController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 23, 2018 3:30:26 PM
	 */
	@ResourceMapping(value="resourceIncompleteGradeNotificationApproval")
	public void incompleteGradeNotificationApproval(
														@ModelAttribute("incompleteGradeNotifyModel") IncompleteGradeModel incompleteGradeModel
														, 	ResourceRequest 	request
														,	ResourceResponse	response
														,	Locale				locale
													) throws IOException
	{
		Gson		gson		= 	new Gson();
		Employee	employee	=	null;
		
		incompleteGradeModel.decrypt(crypto, incompleteGradeModel.getSalt(), incompleteGradeModel.getFour(), incompleteGradeModel);

		
		try
		{
										employee			=	dpsServiceDao.getEmployee(request,locale);
			List<GradeIncompleteDTO>	gradeIncompleteDTOs	=	incompleteGradeService.setIncompleteGradeNotifyApproval(incompleteGradeModel, employee, request, locale);
			response.getWriter().print(gson.toJson(gradeIncompleteDTOs));
		}
		catch (ExceptionEmptyResultset ex)
		{
			response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			response.getWriter().print(gson.toJson(""));
		}
		
		
	}
	
}
