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
package om.edu.squ.squportal.portlet.dps.notification;

import java.util.Map;

import om.edu.squ.squportal.notification.service.core.NotificationServiceCore;
import om.edu.squ.squportal.portlet.dps.bo.NotifierPeople;
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

		
	public String sendNotification( String emailSubject, NotifierPeople notifierPeople,   String formType, boolean isTest) throws Exception
	{
		String[] 			toSender 					= 	null;
		String 				emailBodyStudent			=	null;
		String				emailBodyApprover			=	null;
		String				emailBodyHigherApprover		=	null;
		
		
		
		StringTemplate		stringTemplateStudent			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_STUDENT_EMAIL));
		StringTemplate		stringTemplateApprover			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_APPROVER_EMAIL));
		StringTemplate		stringTemplateHigherApprover	=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_HIGHER_APPROVER_EMAIL));
		
		
							stringTemplateStudent.setAttribute("data", notifierPeople);
							stringTemplateApprover.setAttribute("data", notifierPeople);
							stringTemplateHigherApprover.setAttribute("data", notifierPeople);
							
							
							
							emailBodyStudent			=	stringTemplateStudent.toString();
							emailBodyApprover			=	stringTemplateApprover.toString();
							emailBodyHigherApprover		=	stringTemplateHigherApprover.toString();
		

			/* Mail sending to Student */
			toSender = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getStudent().getPersonalDetail().getEmail()};
			notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSender, null, emailSubject, emailBodyStudent, null);

			/* Mail sending to Approver */
			toSender = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApprover().getEmail()};
			notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSender, null, emailSubject, emailBodyApprover, null);
			//notificationService.sendEMail(fromAddress, toAddress, ccAddress, txtMailSubject, txtMailBody, multipartFile)

			
			if(null !=notifierPeople.getApproverHigher() && !(notifierPeople.isAccept()))
			{
				/* Mail sending to Higher Approver */
				toSender = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApproverHigher().getEmail()};
				notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSender, null, emailSubject, emailBodyHigherApprover, null);
			}
		
		return null;
	}
	
}
