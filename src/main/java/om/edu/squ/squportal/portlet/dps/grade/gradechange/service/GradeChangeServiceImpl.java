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
 * File Name			:	GradeChangeServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.service
 * Date of creation		:	Nov 13, 2017  3:37:08 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.db.GradeChangeDBDao;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.ApprovalTransactionDTO;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UtilProperty;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeServiceImpl implements GradeChangeService
{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DpsServiceDao		dpsServiceDao;
	@Autowired
	GradeChangeDBDao	gradeChangeDBDao;
	@Autowired
	Crypto				crypto;
	@Autowired
	Rule					ruleService;
	@Autowired
	DPSNotification			dpsNotification;
	
	private boolean isRuleGradeChangeTimingFollowed;
	
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO>	getStudentGrades(String employeeNo, Locale locale, GradeChangeModel gradeChangeModel) throws NoDBRecordException
	{

		GradeDTO	dto		=	new GradeDTO();
		Course		course	=	new Course();
		
		dto.setStudentId(gradeChangeModel.getStudentId());
		
		course.setlAbrCourseNo(gradeChangeModel.getlAbrCrsNo());
		dto.setCourse(course);
		dto.setSectionNo(gradeChangeModel.getSectionNo());
		
		return gradeChangeDBDao.getStudentGrades(isRuleGradeChangeTimingFollowed, dto, employeeNo, locale);
	}
	
	
	
	/**
	 * 
	 * method name  : getGrades
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Grade>
	 * 
	 * purpose		: list of all grade values
	 *
	 * Date    		:	Nov 19, 2017 1:44:54 PM
	 */
	public List<Grade> getGrades(Locale locale)
	{
		return gradeChangeDBDao.getGrades(null, locale);
	}
	
	/**
	 * 
	 * method name  : getGradeHistory
	 * @param gradeChangeModelHistory
	 * @param locale
	 * @return
	 * GradeChangeService
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:53:00 PM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO> getGradeHistory(GradeChangeModel gradeChangeModelHistory, Locale locale) throws NoDBRecordException
	{
		
		GradeDTO	dto		=	new GradeDTO();
		Course		course	=	new Course();
		dto.setStudentId(gradeChangeModelHistory.getStudentId());
		course.setlAbrCourseNo(gradeChangeModelHistory.getlAbrCrsNo());
		dto.setCourse(course);

		return gradeChangeDBDao.getGradeHistory(isRuleGradeChangeTimingFollowed, dto, locale);
	}
	
	/**
	 * 
	 * method name  : instructorApplyForGradeChange
	 * @param gradeChangeModel
	 * @param request
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 11:36:38 AM
	 */
	public List<GradeDTO> instructorApplyForGradeChange(GradeChangeModel gradeChangeModel, ResourceRequest request, Locale locale)
	{
		GradeDTO	gradeDTO	=	new GradeDTO();
		Course		course		=	new Course();
		Grade		grade		=	new	Grade();
		int			result		=	0;
	
		
					gradeDTO.setStudentNo(gradeChangeModel.getStudentNo());
					gradeDTO.setStdStatCode(gradeChangeModel.getStdStatCode()); 
					gradeDTO.setCourseYear(gradeChangeModel.getCourseYear());
					gradeDTO.setSemester(gradeChangeModel.getSemCode());
					gradeDTO.setSectionNo(gradeChangeModel.getSectionNo());

					gradeDTO.setSectCode(gradeChangeModel.getSectCode());
					course.setCourseNo(gradeChangeModel.getCourseCode());
					course.setlAbrCourseNo(gradeChangeModel.getlAbrCrsNo());
					
					grade.setGradeCodeOld(Integer.parseInt(gradeChangeModel.getGradeCodeOld()));
					grade.setGradeCodeNew(Integer.parseInt(gradeChangeModel.getGradeCodeNew()));
					
					gradeDTO.setCourse(course);
					gradeDTO.setGrade(grade);
					gradeDTO.setUserName(request.getRemoteUser());
					
					gradeDTO.setComments(gradeChangeModel.getComments());
					
			 try
			{
				result =	gradeChangeDBDao.setInstructorApplyForGradeChange(gradeDTO);
			}
			catch (NotCorrectDBRecordException ex)
			{
				logger.error("Duplicate key error for user: {}, studentNo :{}, courseNo: {}, semesterNo: {}, sectionNo: {}",
									request.getRemoteUser()
								,	gradeChangeModel.getStudentNo(),gradeChangeModel.getCourseCode()
								,	gradeChangeModel.getSemCode()
								,	gradeChangeModel.getSectionNo() 
						);
			}
			 
			 /* -- Notification -- Start --*/ 
			 if(result >0 )
			 {
				 
				 try
				{
					NotifierPeople	notifierPeople	=	dpsServiceDao.getNotifierPeople(
							 																gradeChangeModel.getStudentNo()
							 															, 	null
							 															, 	Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE
							 															, 	Constants.CONST_SQL_ROLE_NAME_HOD
							 															, 	false, locale
							 															);
					
					notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.grade.change", null));
					notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.grade.change", null, new Locale("ar")));
					notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.grade.change", null));
					
					dpsNotification.sendNotification(
							UtilProperty.getMessage("prop.dps.grade.change.notification.subject", new String[]{notifierPeople.getStudent().getPersonalDetail().getId()})
						, 	notifierPeople
						, 	"null"
						, 	Constants.CONST_TEST_ENVIRONMENT
					);
					
				}
				catch (NotCorrectDBRecordException ex)
				{
					logger.error("Error in Notification : "+ex.getMessage());
				}
				 catch(Exception ex)
				 {
					 logger.error("Error in  notification for Instructor submit at Grade change Service : {}",ex.getMessage());
				 }
					
				 /* -- Notification -- end --*/
			 }
			 
			 
			 

			 return null;
					
	}

	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBDao
	 * return type  : List<Student>
	 * 
	 * purpose		: Get list of Students details who applied for grade change
	 *
	 * Date    		:	Dec 5, 2017 8:03:58 PM
	 */
	public List<Student> getStudentDetailsForApprovers(String roleType,  Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return gradeChangeDBDao.getStudentDetailsForApprovers(roleType, employee, locale);
	}
	
	/**
	 * 	
	 * method name  : getCourseListForGradeChange
	 * @param studentNo
	 * @param studentStatCode
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: List of courses with grade change request and their approval details 
	 *
	 * Date    		:	Dec 6, 2017 8:26:06 PM
	 */
	public List<GradeDTO> getCourseListForGradeChange(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		return gradeChangeDBDao.getCourseListForGradeChange(studentNo, studentStatCode, roleType, employee, locale);
	}
	
	

	/**
	 * 
	 * method name  : setGradeChangeApproval
	 * @param gradeChangeModel
	 * @param employee
	 * @param portletRequest
	 * @param locale
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: update the status / comment for approval process and fetch data to populate
	 *
	 * Date    		:	Dec 11, 2017 11:04:47 PM
	 */
	public List<GradeDTO> setGradeChangeApproval(GradeChangeModel gradeChangeModel, Employee employee, PortletRequest portletRequest, Locale locale )
	{
		List<GradeDTO>	courseListWithGradeChange=null;
		
		GradeDTO	gradeDTO	=	new GradeDTO();
		Course		course		=	new Course();

		gradeDTO.setSectCode(gradeChangeModel.getSectCode());
		course.setCourseNo(gradeChangeModel.getCourseCode());
		course.setlAbrCourseNo(gradeChangeModel.getlAbrCrsNo());
		
		gradeDTO.setCourse(course);
		
		gradeDTO.setStatusCode(gradeChangeModel.getStatusCode());
		gradeDTO.setUserName(portletRequest.getRemoteUser());
		gradeDTO.setComments(gradeChangeModel.getComments());
		gradeDTO.setStudentNo(gradeChangeModel.getStudentNo());
		gradeDTO.setStdStatCode(gradeChangeModel.getStdStatCode());
		gradeDTO.setCourseYear(gradeChangeModel.getCourseYear());
		gradeDTO.setSemester(gradeChangeModel.getSemCode());
		gradeDTO.setRecordSequence(gradeChangeModel.getRecordSequence());
		gradeDTO.setRoleType(gradeChangeModel.getRoleName());
		
		courseListWithGradeChange = setRoleTransaction( gradeDTO,  employee,  locale);
		
		return courseListWithGradeChange;
	}
	
	/**
	 * 
	 * method name  : setRoleTransaction
	 * @param gradeDTO
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Dec 13, 2017 1:04:25 PM
	 */
	public List<GradeDTO> setRoleTransaction(GradeDTO gradeDTO, Employee employee, Locale locale)
	{
		int 			resultTr				=	0;
		List<GradeDTO>	listTransactionResult	=	null;
		String			roleName				=	gradeDTO.getRoleType();
		
		ApprovalTransactionDTO	transactionDTO		=	new ApprovalTransactionDTO();
		transactionDTO.setStudentNo(gradeDTO.getStudentNo());
		transactionDTO.setStdStatCode(gradeDTO.getStdStatCode());
		transactionDTO.setAppEmpNo(employee.getEmpNumber());
		transactionDTO.setAppEmpName(gradeDTO.getUserName());
		transactionDTO.setComments(gradeDTO.getComments());
		transactionDTO.setRequestCode(gradeDTO.getRecordSequence());
		
		
		ApprovalDTO		approvalDTO		=	dpsServiceDao.setRoleTransaction(
																					transactionDTO
																				, 	Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE
																				, 	gradeDTO.getRoleType()
																				, 	gradeDTO.getStatusCode()
																			);
		
		
		if(gradeDTO.getStatusCode().equals(Constants.CONST_SQL_STATUS_CODE_REJCT))
		{
			
		}
		else
		{
			if(approvalDTO.getApprovalSequenceNo()==approvalDTO.getApprovalMaxSequenceNo())
			{
				
			}
			else
			{
				gradeDTO.setStatusCode(Constants.CONST_SQL_STATUS_CODE_NAME_PROGRESS);
			}
		}
		
		resultTr	=	gradeChangeDBDao.setGradeChangeApproval(gradeDTO);
		
		
		if(resultTr > 0)
		{
			if(employee.getEmpNumber().substring(0,1).equals("e"))
			{
				employee.setEmpNumber(employee.getEmpNumber().substring(1));
			}
			
			listTransactionResult =	gradeChangeDBDao.getCourseListForGradeChange(
																						gradeDTO.getStudentNo()
																					, 	gradeDTO.getStdStatCode()
																					, 	roleName
																					, 	employee
																					, 	locale
																				);
			
				try
				{
					/* -- Notification -- Start --*/
					NotifierPeople notifierPeople = dpsServiceDao.getNotifierPeople(
																							gradeDTO.getStudentNo()
																						, 	null
																						, 	Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE
																						, 	roleName
																						, 	true, locale
																					);
					
					notifierPeople.setFormNameEng(UtilProperty.getMessage("prop.dps.form.name.grade.change", null));
					notifierPeople.setFormNameAr(UtilProperty.getMessage("prop.dps.form.name.grade.change", null, new Locale("ar")));
					notifierPeople.setServiceUrl(UtilProperty.getMessage("prop.dps.url.grade.change", null));
					
					dpsNotification.sendNotification(
														UtilProperty.getMessage("prop.dps.grade.change.notification.subject", null, locale)
														, notifierPeople
														, "null"
														, Constants.CONST_TEST_ENVIRONMENT
													);
					/* -- Notification -- end --*/
				}
				catch (NotCorrectDBRecordException ex)
				{
					logger.error("Error in Notification : "+ex.getMessage());
				}
				catch(NotificationException exNotification)
				{
					logger.error("Error in  notification for approving at Grade Change of Service 1 : {}",exNotification.getMessage());
				}				
			
			
		}
		
		return listTransactionResult;
	}
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: Get List of Courses of a faculty
	 *
	 * Date    		:	Dec 14, 2017 1:10:14 PM
	 */
	public List<GradeDTO> getCourseList(String employeeNo, Locale	locale)
	{
		return gradeChangeDBDao.getCourseList(isRuleGradeChangeTimingFollowed, employeeNo, locale);
	}
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param employeeNo
	 * @param lAbrCourseNo
	 * @param locale
	 * @param isRuleGradeChangeTimingFollowed
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Student>
	 * 
	 * purpose		: List of Students teached by a faculty for a particular course at particular time
	 *
	 * Date    		:	Dec 14, 2017 3:39:51 PM
	 */
	public List<Student> getStudentList( String employeeNo,String lAbrCourseNo,  Locale	locale, String sectionNo)
	{
		return gradeChangeDBDao.getStudentList(isRuleGradeChangeTimingFollowed, employeeNo, lAbrCourseNo, sectionNo, locale);
	}
	
	
	/**
	 * 
	 * method name  : isRuleComplete
	 * @return
	 * GradeChangeServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rule for Grade Change
	 *
	 * Date    		:	Dec 14, 2017 1:11:15 PM
	 */
	public boolean isRuleComplete()
	{
		/*
		 * Rule 1 : Grade Change is allowed within one month after final exam
		 * */
		
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			
			isRuleGradeChangeTimingFollowed	=	false;
		}
		else
		{
			/*Rule 1*/
			isRuleGradeChangeTimingFollowed	=	true;
		}
		
		return true;
	}
	
	
}
