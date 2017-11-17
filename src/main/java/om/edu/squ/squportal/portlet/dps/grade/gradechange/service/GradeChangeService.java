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
 * File Name			:	GradeChangeService.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.service
 * Date of creation		:	Nov 13, 2017  3:37:46 PM
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

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.model.GradeChangeModel;

/**
 * @author Bhabesh
 *
 */
public interface GradeChangeService
{
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param employeeNo
	 * @param locale
	 * @param gradeChangeModel TODO
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO>	getStudentGrades(String employeeNo, Locale locale, GradeChangeModel gradeChangeModel) throws NoDBRecordException;
}
