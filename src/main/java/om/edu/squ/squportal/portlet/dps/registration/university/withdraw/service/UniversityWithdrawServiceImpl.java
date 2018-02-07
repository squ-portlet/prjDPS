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
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.notification.service.DPSNotification;
import om.edu.squ.squportal.portlet.dps.registration.university.withdraw.db.UniversityWithdrawDBDao;
import om.edu.squ.squportal.portlet.dps.rule.service.Rule;

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

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.dps.registration.university.withdraw.service.UniversityWithdrawService#getReasons(boolean, java.util.Locale)
	 */
	@Override
	public List<CodeValue> getReasons(boolean isStudent, Locale locale)
	{
		
		return universityWithdrawDBDao.getReasons(isStudent, locale);
	}

	
}
