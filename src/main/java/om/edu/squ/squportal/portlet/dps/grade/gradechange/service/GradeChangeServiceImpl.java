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

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.db.GradeChangeDBDao;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeServiceImpl implements GradeChangeService
{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	GradeChangeDBDao	gradeChangeDBDao;
	
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
		dto.setCourseYear(gradeChangeModel.getCourseYear());
		dto.setSemester(gradeChangeModel.getSemCode());
		
		course.setlAbrCourseNo(gradeChangeModel.getlAbrCrsNo());
		dto.setCourse(course);
		
		return gradeChangeDBDao.getStudentGrades(dto, employeeNo, locale);
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
		return gradeChangeDBDao.getGrades(locale);
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
		dto.setStudentId(gradeChangeModelHistory.getStudentId());
		dto.setCourseYear(gradeChangeModelHistory.getCourseYear());
		return gradeChangeDBDao.getGradeHistory(dto, locale);
	}
	
}
