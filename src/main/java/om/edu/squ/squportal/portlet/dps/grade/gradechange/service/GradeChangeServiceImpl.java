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

import javax.portlet.ResourceRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.db.GradeChangeDBDao;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;
import om.edu.squ.squportal.portlet.dps.security.Crypto;

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
	public List<GradeDTO> instructorApplyForGradeChange(GradeChangeModel gradeChangeModel, ResourceRequest request)
	{
		GradeDTO	gradeDTO	=	new GradeDTO();
		Course		course		=	new Course();
		Grade		grade		=	new	Grade();
		int			result		=	0;
		
		
		String		studentNo			=	crypto.decrypt(gradeChangeModel.getSalt(), gradeChangeModel.getFour(),  gradeChangeModel.getStudentNo());
		String		stdStatCode			=	crypto.decrypt(gradeChangeModel.getSalt(), gradeChangeModel.getFour(),  gradeChangeModel.getStdStatCode());
		String		gradeChangeCodeOld	=	crypto.decrypt(gradeChangeModel.getSalt(), gradeChangeModel.getFour(),  gradeChangeModel.getGradeCodeOld());
		String		gradeChangeCodeNew	=	crypto.decrypt(gradeChangeModel.getSalt(), gradeChangeModel.getFour(),  gradeChangeModel.getGradeCodeNew());
		
					gradeDTO.setStudentNo(studentNo);
					gradeDTO.setStdStatCode(stdStatCode);
					gradeDTO.setCourseYear(gradeChangeModel.getCourseYear());
					gradeDTO.setSemester(gradeChangeModel.getSemCode());
					gradeDTO.setSectionNo(gradeChangeModel.getSectionNo());
					
					course.setCourseNo(gradeChangeModel.getCourseCode());
					course.setlAbrCourseNo(gradeChangeModel.getlAbrCrsNo());
					
					grade.setGradeCodeOld(Integer.parseInt(gradeChangeCodeOld));
					grade.setGradeCodeNew(Integer.parseInt(gradeChangeCodeNew));
					
					gradeDTO.setCourse(course);
					gradeDTO.setGrade(grade);
					gradeDTO.setUserName(request.getRemoteUser());
					
			 try
			{
				result =	gradeChangeDBDao.setInstructorApplyForGradeChange(gradeDTO);
			}
			catch (NotCorrectDBRecordException ex)
			{
				logger.error("Duplicate key error for user: {}, studentNo :{}, courseNo: {}, semesterNo: {}, sectionNo: {}",
									request.getRemoteUser()
								,	studentNo,gradeChangeModel.getCourseCode()
								,	gradeChangeModel.getSemCode()
								,	gradeChangeModel.getSectionNo() 
						);
			}
			 logger.info("result of insert : "+result);
			 return null;
					
	}
	
}
