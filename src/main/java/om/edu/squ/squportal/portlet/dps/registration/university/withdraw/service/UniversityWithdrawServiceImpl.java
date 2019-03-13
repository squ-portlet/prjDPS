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
 * File Name			:	UniversityWithdrawServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service
 * Date of creation		:	Feb 4, 2018  8:50:28 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.bo.CodeValue;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class UniversityWithdrawServiceImpl implements UniversityWithdrawService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UniversityWithdrawDBDao universityWithdrawDBDao;
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	DPSNotification			dpsNotification;
	@Autowired
	Rule					ruleService;


	public boolean canStudentApply()
	{
		return universityWithdrawDBDao.canStudentApply();
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService#getReasons(boolean, java.util.Locale)
	 */
	@Override
	public List<CodeValue> getReasons(boolean isStudent, Locale locale)
	{
		
		return universityWithdrawDBDao.getReasons(isStudent, locale);
	}

	

	
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService#setUniversityWithdrawByStudent(om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo.UniversityWithdrawDTO, java.util.Locale)
	 */
	@Override
	public List<UniversityWithdrawDTO> setUniversityWithdrawByStudent(UniversityWithdrawDTO dto, Locale locale )
	{
		String 					approverRole				=	null;
		List<UniversityWithdrawDTO>	universityWithdrawDTOs	=	null;
		
		dto.setToCCYearCode(String.valueOf(dpsServiceDao.getCurrentYearSemester(locale).getYear()));
		dto.setToSemCode(String.valueOf(dpsServiceDao.getCurrentYearSemester(locale).getSemesterCode()));
		
		double		sequenceNumber 		=	dpsServiceDao.getSequenceNumber();
		int 		result				=	universityWithdrawDBDao.setUniversityWithdrawByStudent(sequenceNumber, dto);
		
		if(result > 0)
		{
			/* -- Notification -- Start --*/
				try{
					if(dpsServiceDao.isSupervisorAvailable(dto.getStudentNo(), dto.getStudentStatCode()))
					{
						approverRole	=	Constants.CONST_SQL_ROLE_NAME_SUPERVISOR;
					}
					else
					{
						approverRole	=	Constants.CONST_SQL_ROLE_NAME_ADVISOR;
					}
					
					NotifierPeople	notifierPeople	=	dpsServiceDao.getNotifierPeople(
																								dto.getStudentNo()
																							, 	dto.getStudentStatCode()
																							, 	Constants.CONST_FORM_NAME_DPS_UNIVERSITY_WITHDRAWAL
																							, 	approverRole
																							, 	false
																							, 	locale
																																								);
					dpsNotification.sendNotification(
															UtilProperty.getMessage("prop.dps.university.withdraw.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
														, 	notifierPeople
														, 	null
														, 	Constants.CONST_TEST_ENVIRONMENT
													);
					
				}
				catch(NotCorrectDBRecordException ex)
				{
					logger.error("Error in Notification : "+ex.getMessage());
				}
				catch(Exception ex)
				{
					logger.error("Error in  notification for student submit at Withdraw from University Service : {}",ex.getMessage());
				}
			/* -- Notification -- end --*/
			
		}
		
		universityWithdrawDTOs	=	universityWithdrawDBDao.getUniversityWithdrawDataForStudent(dto.getStudentNo(), locale);
		
		return universityWithdrawDTOs;
	}

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService#getUniversityWithdrawDataForStudent(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<UniversityWithdrawDTO> getUniversityWithdrawDataForStudent(String studentNo, Locale locale)
	{
		return universityWithdrawDBDao.getUniversityWithdrawDataForStudent(studentNo, locale);
	}

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService#getUniversityWithdrawRecordsForApprover(java.lang.String, om.edu.squ.squportal.portlet.dps.bo.Employee, java.util.Locale)
	 */
	public List<UniversityWithdrawDTO> getUniversityWithdrawRecordsForApprover(final String roleType, Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return universityWithdrawDBDao.getUniversityWithdrawRecordsForApprover(roleType, employee, null, locale);
		
	}
	
	/**
	 * 
	 * method name  : getUniversityWithdrawRecordsForApprover
	 * @param roleType
	 * @param employee
	 * @param studentNo
	 * @param locale
	 * @return
	 * UniversityWithdrawServiceImpl
	 * return type  : UniversityWithdrawDTO
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 26, 2018 1:58:20 PM
	 */
	private UniversityWithdrawDTO getUniversityWithdrawRecordsForApprover(final String roleType, Employee employee,  String studentNo, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return universityWithdrawDBDao.getUniversityWithdrawRecordsForApprover(roleType, employee, studentNo, locale).get(0);
		
	}
	
	
}
