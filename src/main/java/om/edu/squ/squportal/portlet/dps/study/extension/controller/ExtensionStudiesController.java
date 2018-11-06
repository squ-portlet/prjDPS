/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	ExtensionStudiesController.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.controller
 * Date of creation		:	Dec 28, 2016  3:09:44 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2016 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.study.extension.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;










import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.portal.common.EmpCommon;
import om.edu.squ.squportal.portlet.dps.activiti.dao.db.ActivitiDbImpl;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.bo.User;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleExtension;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.role.service.Role;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.study.extension.bo.ExtensionDTO;
import om.edu.squ.squportal.portlet.dps.study.extension.model.ExtensionStudentDataModel;
import om.edu.squ.squportal.portlet.dps.study.extension.service.ExtensionServiceDao;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class ExtensionStudiesController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DpsServiceDao	dpsServiceDao;
	@Autowired
	ExtensionServiceDao		extensionServiceDao;
	@Autowired
	Role	role;
	
	
	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param model
	 * @return
	 * ExtensionStudiesController
	 * return type  : String
	 * 
	 * purpose		: Default render method
	 *
	 * Date    		:	Jan 2, 2017 11:15:24 AM
	 * @throws IOException 
	 * @throws NotCorrectDBRecordException 
	 */
	@RequestMapping
	private String welcome(PortletRequest request, Model model, Locale locale) throws IOException, NotCorrectDBRecordException
	{
		
		

		RoleExtension	roleextension	=	(RoleExtension)role.getXmlToRoleObject(Constants.CONST_FILE_ROLE_EXTENTION);
		//logger.info(" roleExtension 2 : "+roleextension.toString());
		
		/*
		ActivitiDbImpl	activitiDbImpl	=	new ActivitiDbImpl();
		activitiDbImpl.getProcessInstance("test");
		*/
		
		/**** Security - data encryption keys *****/
		model.addAttribute("cryptoIterationCount", Crypto.CRYPTO_ITERATION_COUNT);
		model.addAttribute("cryptoKeySize", Crypto.CRYPTO_KEY_SIZE);
		model.addAttribute("cryptoPassPhrase", Crypto.CRYPTO_PASSCODE);
		/* ************************************* */
		
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
	 * ExtensionStudiesController
	 * return type  : String
	 * 
	 * purpose		: Student Welcome
	 *
	 * Date    		:	Jan 12, 2017 3:03:12 PM
	 * @throws NotCorrectDBRecordException 
	 */
	private String studentWelcome(PortletRequest request, Model model, Locale locale) throws NotCorrectDBRecordException
	{
		String	studentNumber	=	null;
		String	studentStatCode	=	null;
		
		String 	userName		=	request.getRemoteUser();
		User   	user			=	dpsServiceDao.getUser(request);
		Student student			= dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
		
				studentNumber	=	student.getAcademicDetail().getStudentNo();
				studentStatCode	=	student.getAcademicDetail().getStdStatCode();
		
		List<ExtensionDTO>	extensions = null;
		if(
				null == extensionServiceDao.getExtensionsForStudents(
																			studentNumber
																		, 	studentStatCode
																		, 	locale
																	)
		  )
		{ 
			
		}
		else
		{
			extensions = extensionServiceDao.getExtensionsForStudents(
																			studentNumber
																		, 	studentStatCode
																		, 	locale
																	);
		}
		
		if(!model.containsAttribute("extensionStudentDataModel"))
		{
			ExtensionStudentDataModel	extensionStudentDataModel	=	new ExtensionStudentDataModel();
			model.addAttribute("extensionStudentDataModel", extensionStudentDataModel);
		}

		model.addAttribute(
								"hasSuperVisor", dpsServiceDao.isSupervisorAvailable(
																							studentNumber
																						, 	studentStatCode
																			  		)
						  );
		model.addAttribute("student", student);
		model.addAttribute("currYearSem", dpsServiceDao.getCurrentYearSemester(locale));
		model.addAttribute("nextYearSemester", dpsServiceDao.getNextYearSemester(locale));
		model.addAttribute("reasonList", extensionServiceDao.getExtensionReasons(locale));
		
		model.addAttribute("extenstions",extensions);
		/* TODO for Apply RULE uncomment the following statement */
		//model.addAttribute("isRuleStudentComplete", true);
		model.addAttribute("isRuleStudentComplete", extensionServiceDao.isRuleStudentComplete(student.getAcademicDetail().getStudentNo(),student.getAcademicDetail().getStdStatCode()));
		
		return "study/extension/student/welcomeExtensionStudent";
	}

	

	/**
	 * 
	 * method name  : approverWelcome
	 * @param request
	 * @param model
	 * @param locale
	 * @return
	 * ExtensionStudiesController
	 * return type  : String
	 * 
	 * purpose		: Approver Welcome
	 *
	 * Date    		:	Jan 12, 2017 3:03:20 PM
	 */
	private String approverWelcome(PortletRequest request, Model model, Locale locale)
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
		
		return "study/extension/approver/welcomeExtensionApprover";
	}
	
	/**
	 * 
	 * method name  : submitStudentExtension
	 * @param request
	 * @param response
	 * @param extensionStudentDataModel
	 * @param result
	 * @param locale
	 * @param model
	 * ExtensionStudiesController
	 * return type  : void
	 * 
	 * purpose		: Add a record in extension table as student
	 *
	 * Date    		:	Jan 24, 2017 3:30:43 PM
	 * @throws NotCorrectDBRecordException 
	 */
	@RequestMapping(params="action=studentFormAction")
	private	void submitStudentExtension(ActionRequest request, ActionResponse response,
			@ModelAttribute("extensionStudentDataModel")ExtensionStudentDataModel extensionStudentDataModel,
			BindingResult result,Locale locale,Model model) throws NotCorrectDBRecordException
	{
		String userName	=	request.getRemoteUser();
		User	user	=	dpsServiceDao.getUser(request);
		Student student	= dpsServiceDao.getStudent(user.getUserId(), null, new Locale("en"));
		
		extensionServiceDao.setExtensionByStudent(student, extensionStudentDataModel, userName, locale);
	}
	

	/**
	 * 
	 * method name  : getResourceDataEmpByRole
	 * @param roleNameValue
	 * @param request
	 * @param response
	 * @param locale
	 * @throws IOException
	 * ExtensionStudiesController
	 * return type  : void
	 * 
	 * purpose		: Ajax Resource Mapping to fetch student data by Employee Role
	 *
	 * Date    		:	Feb 21, 2017 9:30:42 AM
	 */
	@ResourceMapping(value="ajaxStudentExtensionDataByRole")
	private	void getResourceDataEmpByRole(
											@ModelAttribute("roleNameValue") RoleNameValue roleNameValue,
											ResourceRequest request, ResourceResponse response,Locale locale
										) throws IOException
	{
		Gson	gson	=	new Gson();
		Employee employee;
		try
		{
			employee = dpsServiceDao.getEmployee(request,locale, true);
			List<ExtensionDTO> dtos	=	extensionServiceDao.getExtensionsForApprovers(roleNameValue.getRoleValue(), employee, locale);
			response.getWriter().print(gson.toJson(dtos));
		}
		catch (ExceptionEmptyResultset ex)
		{
			response.getWriter().print(gson.toJson(""));
		}
		
	}
	
	
	/**
	 * 
	 * method name  : getResourceDataForApprove
	 * @param extensionDTO
	 * @param request
	 * @param response
	 * @param locale
	 * @throws Exception 
	 */
	@ResourceMapping(value="ajaxExtensionDataApprove")
	private	void getResourceDataForApprove(
			@ModelAttribute("extensionDTO") ExtensionDTO extensionDTO,
			ResourceRequest request, ResourceResponse response,Locale locale
		) throws Exception
		{
			Gson			gson					=	new Gson();
			Employee		employee;
			ExtensionDTO	extensionDTOResult		=	null;	
			try
			{
				employee = dpsServiceDao.getEmployee(request,locale, Constants.CONST_IS_DELEGATION);
				employee.setUserName(request.getRemoteUser());
				
				extensionDTOResult = extensionServiceDao.setRoleTransaction(extensionDTO, employee, locale);
				response.getWriter().print(gson.toJson(extensionDTOResult));
				
			}
			catch (ExceptionEmptyResultset ex)
			{
				logger.error("Error in Data generation. Actual error :  "+ex.getMessage());
				response.getWriter().print(gson.toJson(""));
			}

		}
	
}
