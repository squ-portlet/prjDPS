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
import javax.servlet.http.HttpServletResponse;

import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.service.GradeChangeService;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.security.CryptoAES;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

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
		String	employeeNumber	=	null;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, false);
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("No records available. Probably user doesnot logged in ");
		}

		boolean booRule = gradeChangeService.isRuleComplete();
		
		if(null == employee)
		{
			model.addAttribute("empSISValid", false);
		}
		else
		{
			model.addAttribute("empSISValid", true);
			
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employeeNumber	=	employee.getEmpNumber().substring(1);
			}
			Gson	gson	=	new Gson();
			model.addAttribute("courseList", gradeChangeService.getCourseList(employeeNumber, locale));
			model.addAttribute("employee", employee);
			model.addAttribute("appApprove", Constants.CONST_SQL_STATUS_CODE_ACCPT);
			model.addAttribute("appRecect", Constants.CONST_SQL_STATUS_CODE_REJCT);
			model.addAttribute("roleDpsStaff", Constants.CONST_SQL_ROLE_NAME_DPS_STAFF);
		}
		return "/grade/gradechange/approver/welcomeGradeChangeApprover";
	}
	
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param lAbrCourseNo
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * GradeChangeController
	 * return type  : void
	 * 
	 * purpose		: List of students as resource
	 *
	 * Date    		:	Dec 14, 2017 4:08:54 PM
	 */
	@ResourceMapping(value="resourceStudentList")
	private	void getStudentList(@RequestParam("lAbrCourseNo") String lAbrCourseNo, @RequestParam("sectionNo") String sectionNo, ResourceRequest request, ResourceResponse response, Locale locale ) throws IOException
	{
		Gson		gson		= 	new Gson();
		String	employeeNumber	=	null;
		
		Employee employee 		=	null;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, Constants.CONST_IS_DELEGATION);		/* Delegation enabled */
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employeeNumber	=	employee.getEmpNumber().substring(1);
			}
			List<Student> students	=	gradeChangeService.getStudentList(employeeNumber, lAbrCourseNo, locale, sectionNo);
			
			response.getWriter().print(gson.toJson(students));
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("Error fetching student list "+ex.getMessage());
			response.getWriter().print("");
		}
		
		
		
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
		Gson		gson			= 	new Gson();
		Employee 	employee 		=	null;
		String		employeeNumber	=	null;
					
		gradeChangeModel.decrypt(crypto, gradeChangeModel.getSalt(), gradeChangeModel.getFour(), gradeChangeModel);
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, Constants.CONST_IS_DELEGATION);		/* Delegation enabled */
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employeeNumber	=	employee.getEmpNumber().substring(1);
			}
			
			List<GradeDTO> 	gradeList		=	gradeChangeService.getStudentGrades(employeeNumber, locale, gradeChangeModel);	

			if( (null == gradeList) || gradeList.size()==0)
			{
				response.setProperty(ResourceResponse.HTTP_STATUS_CODE, Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
				response.getWriter().print(UtilProperty.getMessage("err.dps.service.not.available.text", null, locale));
			}
			else
			{
				response.getWriter().print(gson.toJson(gradeList));
			}
		}
		catch(NoDBRecordException ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		catch (ExceptionEmptyResultset ex)
		{
			logger.error("Error get employee :  "+ex.getMessage());
			response.getWriter().print("");
		}
	}
	
	/**
	 * 
	 * method name  : getStudentGradeChangeHistory
	 * @param gradeChangeModelHistory
	 * @param request
	 * @param response
	 * @param locale
	 * GradeChangeController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:46:59 PM
	 * @throws IOException 
	 */
	@ResourceMapping(value="resourceAjaxGetStudentGradesChangeHistory")	
	private void getStudentGradeChangeHistory
											(
													@ModelAttribute("gradeChangeModelHistory") GradeChangeModel gradeChangeModelHistory
												,	ResourceRequest request
												, 	ResourceResponse response
												, 	Locale locale
											) throws IOException
	{
		Gson		gson		= 	new Gson();

		gradeChangeModelHistory.decrypt(crypto, gradeChangeModelHistory.getSalt(), gradeChangeModelHistory.getFour(), gradeChangeModelHistory);

		try
		{
			List<GradeDTO> 	gradeChangeList		=	gradeChangeService.getGradeHistory(gradeChangeModelHistory, locale);	
			
			response.getWriter().print(gson.toJson(gradeChangeList));
		}
		catch(NoDBRecordException ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		
	}
	
	/**
	 * 
	 * method name  : instructorApplyForGradeChange
	 * @param gradeChangeModel
	 * @param request
	 * @param response
	 * @param locale
	 * GradeChangeController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 11:35:12 AM
	 */
	@ResourceMapping(value="resourceAjaxGradeChangeApply")
	private	void instructorApplyForGradeChange(
			@ModelAttribute("gradeChangeModel") GradeChangeModel gradeChangeModel
			,	ResourceRequest request
			, 	ResourceResponse response
			, 	Locale locale)
	{	
		gradeChangeModel.decrypt(crypto, gradeChangeModel.getSalt(), gradeChangeModel.getFour(), gradeChangeModel);
		gradeChangeService.instructorApplyForGradeChange(gradeChangeModel,request, locale);
	}
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param gradeDTO
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: Get list of Students details who applied for grade change
	 *
	 * Date    		:	Dec 5, 2017 1:06:57 AM
	 */
	@ResourceMapping(value="resoureAjaxGradeChangeDataByRole")
	public void getStudentDetailsForApprovers(@ModelAttribute("roleNameValue") RoleNameValue roleNameValue,
			ResourceRequest request, ResourceResponse response, Locale locale
			) throws IOException, NoDBRecordException
	{
		Gson		gson		= 	new Gson();
		Employee	employee	=	null;
		
		try
		{
			employee					=	dpsServiceDao.getEmployee(request,locale, Constants.CONST_IS_DELEGATION);	/* Delegation enabled */
		
			List<Student> students	=	gradeChangeService.getStudentDetailsForApprovers(roleNameValue.getRoleValue(), employee, locale);
			
			response.getWriter().print(gson.toJson(students));

		}
		catch(ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
	}
	
	/**
	 * 
	 * method name  : getCourseListForGradeChange
	 * @param gradeChangeModel
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * GradeChangeController
	 * return type  : void
	 * 
	 * purpose		: List of courses with grade change request and their approval details  
	 *
	 * Date    		:	Dec 7, 2017 1:46:27 PM
	 */
	@ResourceMapping(value="resoureAjaxCourseListForGradeChange")
	public void getCourseListForGradeChange(
												@ModelAttribute ("gradeChangeModel") GradeChangeModel gradeChangeModel
											, 	ResourceRequest request
											, 	ResourceResponse response
											,	Locale locale
											) throws IOException
	{
		Gson		gson		= 	new Gson();
		Employee	employee	=	null;
		
		gradeChangeModel.decrypt(crypto, gradeChangeModel.getSalt(), gradeChangeModel.getFour(), gradeChangeModel);
			
		try
		{
			employee					=	dpsServiceDao.getEmployee(request,locale, false);
			
			List<GradeDTO>	gradeDTOs	=	gradeChangeService.getCourseListForGradeChange(
					gradeChangeModel.getStudentNo(), 
					gradeChangeModel.getStdStatCode(), 
					gradeChangeModel.getRoleName(), 
					employee, 
					locale
					);	
			response.getWriter().print(gson.toJson(gradeDTOs));
			
		}
		catch (ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		
	}
	
	/**
	 * 
	 * method name  : gradeChangeApproval
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
	 * Date    		:	Dec 11, 2017 11:24:21 PM
	 */
	@ResourceMapping(value="resourceAjaxGradeChangeApproval")
	public void gradeChangeApproval(
									@ModelAttribute ("gradeChangeModel") GradeChangeModel gradeChangeModel
									, 	ResourceRequest request
									, 	ResourceResponse response
									,	Locale locale									
								) throws IOException
	{

			Employee	employee	=	null;
			Gson		gson		= 	new Gson();
			gradeChangeModel.decrypt(crypto, gradeChangeModel.getSalt(), gradeChangeModel.getFour(), gradeChangeModel);
			try
			{
								employee	=	dpsServiceDao.getEmployee(request,locale, false);
				List<GradeDTO>	gradeDTOs	=	gradeChangeService.setGradeChangeApproval(gradeChangeModel, employee, request, locale);
				response.getWriter().print(gson.toJson(gradeDTOs));
			}
			catch (ExceptionEmptyResultset ex)
			{
				response.getWriter().print(gson.toJson(""));
			}
	}
	
	
	
}
