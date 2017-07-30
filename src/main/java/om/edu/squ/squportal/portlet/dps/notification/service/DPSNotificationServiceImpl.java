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
 * File Name			:	DPSNotificationServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.notification
 * Date of creation		:	Jul 26, 2017  7:00:01 PM
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
package om.edu.squ.squportal.portlet.dps.notification.service;

import java.util.Map;

import om.edu.squ.squportal.notification.service.core.NotificationServiceCore;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class DPSNotificationServiceImpl implements DPSNotification
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NotificationServiceCore	notificationService;
	
	
	private StringTemplateGroup stringTemplateGroup;
	private	Map<String, String> emailTemplateMap;
	private	Map<String,String>	smsTemplateMap;
	

	
	/**
	 * Setter method : setStringTemplateGroup
	 * @param stringTemplateGroup the stringTemplateGroup to set
	 * 
	 * Date          : Jul 27, 2017 8:56:21 AM
	 */
	public void setStringTemplateGroup(StringTemplateGroup stringTemplateGroup)
	{
		this.stringTemplateGroup = stringTemplateGroup;
	}
	/**
	 * Setter method : setEmailTemplateMap
	 * @param emailTemplateMap the emailTemplateMap to set
	 * 
	 * Date          : Jul 26, 2017 4:13:23 PM
	 */
	public void setEmailTemplateMap(Map<String, String> emailTemplateMap)
	{
		this.emailTemplateMap = emailTemplateMap;
	}

	
	
	/**
	 * Setter method : setSmsTemplateMap
	 * @param smsTemplateMap the smsTemplateMap to set
	 * 
	 * Date          : Jul 30, 2017 3:20:49 PM
	 */
	public void setSmsTemplateMap(Map<String, String> smsTemplateMap)
	{
		this.smsTemplateMap = smsTemplateMap;
	}
	/**
	 * 
	 */
	public String sendNotification( String emailSubject, NotifierPeople notifierPeople,   String formType, boolean isTest) throws Exception
	{
		String[] 			toSenderEmail				= 	null;
		String				toSenderSMS					=	null;
		String 				emailBodyStudent			=	null;
		String				emailBodyApprover			=	null;
		String				emailBodyHigherApprover		=	null;
		String				smsTextStudent				=	null;
		
		
		
		StringTemplate		stringEmailTemplateStudent			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_STUDENT_EMAIL));
		StringTemplate		stringEmailTemplateApprover			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_APPROVER_EMAIL));
		StringTemplate		stringEmailTemplateHigherApprover	=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_HIGHER_APPROVER_EMAIL));
		StringTemplate		stringSMSTemplateStudent			=	stringTemplateGroup.getInstanceOf(smsTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_STUDENT_SMS));
		
							stringEmailTemplateStudent.setAttribute("data", notifierPeople);
							stringEmailTemplateApprover.setAttribute("data", notifierPeople);
							stringEmailTemplateHigherApprover.setAttribute("data", notifierPeople);
							stringSMSTemplateStudent.setAttribute("data", notifierPeople);
							
							
							
							emailBodyStudent			=	stringEmailTemplateStudent.toString();
							emailBodyApprover			=	stringEmailTemplateApprover.toString();
							emailBodyHigherApprover		=	stringEmailTemplateHigherApprover.toString();
							smsTextStudent				=	stringSMSTemplateStudent.toString();
		

			/* Mail sending to Student */
			toSenderEmail 	= 	(isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getStudent().getPersonalDetail().getEmail()};
			toSenderSMS		=	(isTest)? Constants.CONST_DUMMY_USER_SMS_TO:notifierPeople.getStudent().getPersonalDetail().getPhone();
			notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyStudent, null);
			notificationService.sendSingleSMS(toSenderSMS, smsTextStudent, "e", null, null);

			/* Mail sending to Approver */
			toSenderEmail = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApprover().getEmail()};
			notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyApprover, null);

			
			if(null !=notifierPeople.getApproverHigher() && !(notifierPeople.isAccept()))
			{
				/* Mail sending to Higher Approver */
				toSenderEmail = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApproverHigher().getEmail()};
				notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyHigherApprover, null);
			}
		
		return null;
	}
	
}
