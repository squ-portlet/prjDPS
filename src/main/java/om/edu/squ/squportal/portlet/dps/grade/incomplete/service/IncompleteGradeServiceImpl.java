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
 * File Name			:	IncompleteGradeServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.service
 * Date of creation		:	Jan 3, 2018  9:17:07 AM
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.db.IncompleteGradeDBDao;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.security.Crypto;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

/**
 * @author Bhabesh
 *
 */
public class IncompleteGradeServiceImpl implements IncompleteGradeService
{
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	Crypto				crypto;
	@Autowired
	IncompleteGradeDBDao	incompleteGradeDBDao;
	@Autowired
	DPSNotification			dpsNotification;
	
	private boolean isRuleGradeChangeTimingFollowed;
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getCourseList(java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getCourseList( String employeeNo, Locale	locale)
	{
		return incompleteGradeDBDao.getCourseList(isRuleGradeChangeTimingFollowed, employeeNo, locale);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#getStudentList(java.lang.String, java.lang.String, java.lang.String, java.util.Locale)
	 */
	@Override
	public List<GradeIncompleteDTO> getStudentList(String employeeNo, String lAbrCourseNo,String sectionNo, Locale	locale)
	{
		return incompleteGradeDBDao.getStudentList(isRuleGradeChangeTimingFollowed, employeeNo, lAbrCourseNo, sectionNo, locale);
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#setInstructorNotifyForIncompleteGrade(java.lang.String, om.edu.squ.squportal.portlet.dps.grade.incomplete.bo.GradeIncompleteDTO)
	 */
	@Override
	public String setInstructorNotifyForIncompleteGrade(GradeIncompleteDTO dto ) throws NotCorrectDBRecordException
	{
		double	sequenceNumber =	dpsServiceDao.getSequenceNumber();
		return (incompleteGradeDBDao.setInstructorNotifyForIncompleteGrade(sequenceNumber, dto)>0)?String.format("%.0f",sequenceNumber):null;
	}


	public List<GradeIncompleteDTO>  getIncompleteNotifyHistory(String recordSequence,  Locale locale) throws NoDBRecordException
	{
		return incompleteGradeDBDao.getIncompleteNotifyHistory( recordSequence, locale);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.grade.incomplete.service.IncompleteGradeService#isRuleComplete()
	 */
	@Override
	public boolean isRuleComplete()
	{
		/*
		 * Rule 1 : Grade Change is allowed within one month after final exam
		 * */
		
		if(Constants.CONST_TEST_ENVIRONMENT)
		{
			
			this.isRuleGradeChangeTimingFollowed	=	false;
		}
		else
		{
			/*Rule 1*/
			this.isRuleGradeChangeTimingFollowed	=	true;
		}
		
		return true;
	}
	


	
}
