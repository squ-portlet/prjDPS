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
 * File Name			:	DropWServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.service
 * Date of creation		:	Mar 30, 2017  8:57:49 AM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.service;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotSuccessFulDBUpdate;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.db.DropWDBDao;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

/**
 * @author Bhabesh
 *
 */
public class DropWServiceImpl implements DropWService
{
	private final Logger 	logger 						= 	LoggerFactory.getLogger(this.getClass());
	private		  boolean	stdModeCreditApplied		=	false;  
	
	private		  String	dropWTimeApplied			=	Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED;
	
	@Autowired
	DropWDBDao	dropWDBDao;
	@Autowired
	DpsServiceDao	dpsServiceDao;
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param student
	 * @param locale
	 * @return 
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	@Override
	public List<DropWDTO> getCourseList(Student student, Locale locale)
	{
		String studentMode	=	null;
		if(stdModeCreditApplied)
		{
			studentMode = dpsServiceDao.getStudentMode(
							student.getAcademicDetail().getStudentNo(), 
							student.getAcademicDetail().getStdStatCode()
						);
		}
		else
		{
			studentMode = Constants.CONST_RULE_DROP_W_STUDENT_MODE_NOT_APPLIED;
		}
		
		 
		return dropWDBDao.getCourseList(student, locale, studentMode, this.dropWTimeApplied);
		
	}

	/**
	 * 
	 */
	@Override
	public List<DropWDTO> setDropWCourseAdd(Student student, DropCourseModel dropCourseModel, Locale locale)
	{
		int 			resultSetDropW 	= 	setTempDropWCourseAdd( student,  dropCourseModel);
		if(resultSetDropW > 0)
		{
			List<DropWDTO>	dropWDTOs		=	getDropWCourses(student,locale);
			return dropWDTOs;
		}
		else
		{
			logger.error("Database Insert is not successful at temporary/helper table for student no {}.",student.getAcademicDetail().getStudentNo());
			return null;
		}
	}
	
	/**
	 * 
	 * method name  : getDropWCourses
	 * @param student
	 * @param locale
	 * @return
	 * DropWServiceImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: get details of the courses opt to be dropped
	 *
	 * Date    		:	Apr 12, 2017 4:50:19 PM
	 */
	public List<DropWDTO>  getDropWCourses(Student student, Locale locale)
	{
		List<DropWDTO>	dropWDTOs	=	null;
						dropWDTOs	=	dropWDBDao.getCourseList(
																	student.getAcademicDetail().getStudentNo(), 
																	student.getAcademicDetail().getStdStatCode(), 
																	locale
																);
		return dropWDTOs;
	}
	

	/**
	 * 
	 * method name  : setTempDropWCourseAdd
	 * @param student
	 * @param dropCourseModel
	 * @return
	 * DropWServiceImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Apr 12, 2017 3:26:06 PM
	 */
	private int setTempDropWCourseAdd(Student student, DropCourseModel dropCourseModel)
	{
		DropWDTO	dropWDTO	=	new DropWDTO();
		dropWDTO.setStudentNo(student.getAcademicDetail().getStudentNo());
		dropWDTO.setStudentStatCode(student.getAcademicDetail().getStdStatCode());
		
		
		dropWDTO.setCourseNo(dropCourseModel.getCourseNo());
		dropWDTO.setSectCode(dropCourseModel.getSectCode());
		dropWDTO.setSectionNo(dropCourseModel.getSectNo());
		dropWDTO.setUserName(student.getAcademicDetail().getStudentUserName());
		
		
		return dropWDBDao.setTempDropWCourseAdd(dropWDTO);
	}


	/**
	 * 
	 * method name  : getDropWForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get List of student records for courses to be dropped 
	 *
	 * Date    		:	Apr 17, 2017 8:24:28 PM
	 */
	public List<DropWDTO> getDropWForApprovers(String roleType, Employee employee, Locale locale)
	{
		if(employee.getEmpNumber().substring(0,1).equals("e"))
		{
			employee.setEmpNumber(employee.getEmpNumber().substring(1));
		}
		
		return dropWDBDao.getDropWForApprovers(roleType, employee, locale, null);
	}
	
	
	/**
	 * 
	 * method name  : setDropWCourseUpdate
	 * @param dropWDTO
	 * @return
	 * DropWDBImpl
	 * return type  : int
	 * 
	 * purpose		: update approver's action in drop w
	 *
	 * Date    		:	May 2, 2017 10:59:22 AM
	 * @throws NotSuccessFulDBUpdate 
	 */
	public List<DropWDTO> setDropWCourseUpdate(DropWDTO dropWDTO, Locale locale) throws NotSuccessFulDBUpdate
	{
		int				resultUpdate	=	0;
		AcademicDetail	academicDetail	=	new AcademicDetail();
		Student			student			=	new Student();
		academicDetail.setStudentNo(dropWDTO.getStudentNo());
		academicDetail.setStdStatCode(dropWDTO.getStudentStatCode());
		student.setAcademicDetail(academicDetail);
		
		resultUpdate	=	dropWDBDao.setDropWCourseUpdate(dropWDTO);
		if(resultUpdate >  0)
		{
			return getDropWCourses(student,locale);
		}
		else
		{
			return null;
		}
	}

	
	/**
	 * 
	 * method name  : isRuleStudentComplete
	 * @param studentNo
	 * @param stdStatCode
	 * @return
	 * DropWServiceImpl
	 * return type  : boolean
	 * 
	 * purpose		: Rule for Droping the course with W
	 *
	 * Date    		:	May 17, 2017 3:11:11 PM
	 */
	public boolean isRuleStudentComplete(String studentNo, String stdStatCode)
	{
		/*Rule 1 : 	Full Time need 12 Credit
		 * 			Part Time need 3 Credit
		 * Rule 2 : Period within Drop W Period 
		 * */
		
		/*Rule 1 */
		this.stdModeCreditApplied	=	true;
		/*Rule 2 */
		//TODO
		//this.dropWTimeApplied		= 	Constants.CONST_RULE_DROP_W_PERIOD_APPLIED; // Rule - Drop W period applied -- APPLIED DROP 'W' TIME - PRODUCTION USE
		
		this.dropWTimeApplied		=	Constants.CONST_RULE_DROP_W_PERIOD_NOT_APPLIED; // Rule - Drop W period not applied  -- This statement for tesing only

		//TODO : Do not change result of the rule
		return true;
	}
	
}
