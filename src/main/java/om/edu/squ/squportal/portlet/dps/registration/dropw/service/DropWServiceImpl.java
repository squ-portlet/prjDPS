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

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.db.DropWDBDao;
import om.edu.squ.squportal.portlet.dps.registration.dropw.model.DropCourseModel;

/**
 * @author Bhabesh
 *
 */
public class DropWServiceImpl implements DropWService
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DropWDBDao	dropWDBDao;
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param studentId
	 * @param locale
	 * @return
	 * DropWDBImpl
	 * return type  : List<DropWDTO>
	 * 
	 * purpose		: Get list of courses for drop
	 *
	 * Date    		:	Mar 30, 2017 8:20:37 AM
	 */
	public List<DropWDTO> getCourseList(String studentId, Locale locale)
	{
		return dropWDBDao.getCourseList(studentId, locale);
		
	}
	

	public List<DropWDTO> setDropWCourse(Student student, DropCourseModel dropCourseModel, Locale locale)
	{
		int 			resultSetDropW 	= 	setTempDropWCourse( student,  dropCourseModel);
		if(resultSetDropW > 0)
		{
			List<DropWDTO>	dropWDTOs		=	dropWDBDao.getCourseList(
																			student.getAcademicDetail().getStudentNo(), 
																			student.getAcademicDetail().getStdStatCode(), 
																			locale
																		);
			return dropWDTOs;
		}
		else
		{
			logger.error("Database Insert is not successful at temporary/helper table for student no {}.",student.getAcademicDetail().getStudentNo());
			return null;
		}
	}
	

	public int setTempDropWCourse(Student student, DropCourseModel dropCourseModel)
	{
		DropWDTO	dropWDTO	=	new DropWDTO();
		dropWDTO.setStudentNo(student.getAcademicDetail().getStudentNo());
		dropWDTO.setStudentStatCode(student.getAcademicDetail().getStdStatCode());
		
		
		dropWDTO.setCourseNo(dropCourseModel.getCourseNo());
		dropWDTO.setSectCode(dropCourseModel.getSectCode());
		dropWDTO.setSectionNo(dropCourseModel.getSectNo());
		dropWDTO.setUserName(student.getAcademicDetail().getStudentUserName());
		
		
		return dropWDBDao.setTempDropWCourse(dropWDTO);
	}


	
}
