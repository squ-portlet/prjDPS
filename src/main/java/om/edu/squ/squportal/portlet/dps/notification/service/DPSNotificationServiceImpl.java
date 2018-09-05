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

import java.util.Locale;
import java.util.Map;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.notification.service.core.NotificationServiceCore;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.DelegateEmployee;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.dao.service.DpsServiceDao;
import om.edu.squ.squportal.portlet.dps.exception.ExceptionEmptyResultset;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;
import om.edu.squ.squportal.portlet.dps.utility.Constants;
import om.edu.squ.squportal.portlet.dps.utility.UserIdUtil;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.sun.mail.smtp.SMTPSendFailedException;

/**
 * @author Bhabesh
 *
 */
@Async
public class DPSNotificationServiceImpl implements DPSNotification
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NotificationServiceCore	notificationService;
	@Autowired
	DpsServiceDao			dpsServiceDao;
	@Autowired
	UserIdUtil				userIdUtil;
	
	
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
	 * method name  : sendNotification
	 * @param emailSubject
	 * @param notifierPeople
	 * @param formType
	 * @param isTest
	 * @return
	 * @throws CloneNotSupportedException 
	 * @throws ExceptionEmptyResultset 
	 * @throws Exception
	 * DPSNotification
	 * return type  : String
	 * 
	 * purpose		: Send notification (SMS & E-mail to student and approvers)
	 *
	 * Date    		:	Jul 27, 2017 9:20:09 AM
	 */
	public String sendNotification( String emailSubject, NotifierPeople notifierPeople,   String formType, boolean isTest)  throws NotificationException
	{
		String[] 			toSenderEmail				= 	null;
		String				toSenderSMS					=	null;
		String 				emailBodyStudent			=	null;
		String				emailBodyApprover			=	null;
		String				emailBodyHigherApprover		=	null;
		String				smsTextStudent				=	null;
		
		
		
		StringTemplate		stringEmailTemplateStudent			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_STUDENT_EMAIL));
		StringTemplate		stringSMSTemplateStudent			=	stringTemplateGroup.getInstanceOf(smsTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_STUDENT_SMS));
		StringTemplate		stringEmailTemplateApprover			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_APPROVER_EMAIL));
		StringTemplate		stringEmailTemplateHigherApprover	=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_HIGHER_APPROVER_EMAIL));
		
		
		
		
							/* Student Template */
							stringSMSTemplateStudent.setAttribute("data", notifierPeople);					
							stringEmailTemplateStudent.setAttribute("data", notifierPeople);
							
							smsTextStudent				=	stringSMSTemplateStudent.toString();
							emailBodyStudent			=	stringEmailTemplateStudent.toString();

							/* Mail / SMS sending to Student */
							
							toSenderEmail 	= 	(isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getStudent().getPersonalDetail().getEmail()};
							toSenderSMS		=	(isTest)? Constants.CONST_DUMMY_USER_SMS_TO:notifierPeople.getStudent().getPersonalDetail().getPhone();

							notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyStudent, null);
							notificationService.sendSingleSMS(toSenderSMS, smsTextStudent, "e", null, null);
							
							
							
							/* Approver Template */
							stringEmailTemplateApprover.setAttribute("data", notifierPeople);
							stringEmailTemplateHigherApprover.setAttribute("data", notifierPeople);
							
							emailBodyApprover			=	stringEmailTemplateApprover.toString();
							emailBodyHigherApprover		=	stringEmailTemplateHigherApprover.toString();
							
							
							NotifierPeople resultNotifierPeople	=	null;
							try
							{
								resultNotifierPeople = getDelegatedApprover(notifierPeople);
							}
							catch (CloneNotSupportedException ex)
							{
								logger.error("Error for object cloning from notification. Details : "+ex.getMessage() );
							}
							

							if(
										null 	==	 	resultNotifierPeople
							  )
							{
								sendNotificationToApprovers(
																	emailSubject
																,	notifierPeople
																,	isTest
															);

							}
							else
							{
								sendNotificationToApprovers(
																	emailSubject
																,	notifierPeople
																,	isTest
															);
								
								sendNotificationToApprovers(
																	emailSubject
																,	resultNotifierPeople
																,	isTest
															);
								

								
							}
							
		
		return null;
	}
	

	/**
	 * 
	 * method name  : sendNotificationToApprovers
	 * @param emailSubject
	 * @param notifierPeople
	 * @param isTest
	 * @throws NotificationException
	 * DPSNotificationServiceImpl
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 30, 2018 8:48:43 AM
	 */
	private void sendNotificationToApprovers(		String emailSubject
												,	NotifierPeople 		notifierPeople
												,	boolean isTest
											) throws NotificationException
	{
		
		String[] 			toSenderEmail				= 	null;
		String				emailBodyApprover			=	null;
		String				emailBodyHigherApprover		=	null;
		
		StringTemplate		stringEmailTemplateApprover			=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_APPROVER_EMAIL));
		StringTemplate		stringEmailTemplateHigherApprover	=	stringTemplateGroup.getInstanceOf(emailTemplateMap.get(Constants.TEMPLATE_NOTIFICATION_HIGHER_APPROVER_EMAIL));
		
				/* Approver Template */
				stringEmailTemplateApprover.setAttribute("data", notifierPeople);
				stringEmailTemplateHigherApprover.setAttribute("data", notifierPeople);
				
				emailBodyApprover			=	stringEmailTemplateApprover.toString();
				emailBodyHigherApprover		=	stringEmailTemplateHigherApprover.toString();
				
		
		/* Mail sending to Approver */
		toSenderEmail = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApprover().getEmail()};
		notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyApprover, null);
		
		
		
		/* Mail sending to Higher Approver */		
		if(!(notifierPeople.isReject()) && ( null !=notifierPeople.getApproverHigher() && !(notifierPeople.isAccept())))
		{
		toSenderEmail = (isTest)? new String[]{Constants.CONST_DUMMY_USER_EMAIL_TO}:new String[]{notifierPeople.getApproverHigher().getEmail()};
		notificationService.sendEMail(Constants.CONST_EMAIL_FROM, toSenderEmail, null, emailSubject, emailBodyHigherApprover, null);

		}
		

		
		
	}
	
	
	
	/**
	 * 
	 * method name  : getDelegatedApprover
	 * @param notifierPeople
	 * @return
	 * DPSNotificationServiceImpl
	 * return type  : NotifierPeople
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 28, 2018 2:37:53 PM
	 * @throws CloneNotSupportedException 
	 */
	private NotifierPeople getDelegatedApprover(NotifierPeople delNotifierPeople) throws CloneNotSupportedException 
	{
		NotifierPeople		notifierPeople				=	(NotifierPeople) delNotifierPeople.clone();
		
		String 				approverUserName			=	delNotifierPeople.getApprover().getEmail().substring(0,delNotifierPeople.getApprover().getEmail().indexOf("@"));
		String 				higherApproverUserName		=	delNotifierPeople.getApproverHigher().getEmail().substring(0,delNotifierPeople.getApproverHigher().getEmail().indexOf("@"));

		
		DelegateEmployee	empApprover					= 	dpsServiceDao.getDelegatedEmployee(approverUserName);
		DelegateEmployee	empHigherApprover			= 	dpsServiceDao.getDelegatedEmployee(higherApproverUserName);

		
		if(null == empApprover.getUserNameDelegated() || empApprover.getUserNameDelegated().equals(Constants.CONST_NOT_AVAILABLE) )
		{
			notifierPeople.setApprover(null);
		}
		else
		{
			Employee employee	=	null;
			try
			{
				employee = dpsServiceDao.getEmployee(empApprover.getEmpNumberDelegated(), empApprover.getUserNameDelegated(), false);
			}
			catch (ExceptionEmptyResultset ex)
			{
				logger.error("Error fetching delegated data for approver for notification ");
			}
			Approver	approver	=	new Approver();
						approver.setNameEng(employee.getEmpNameEn());
						approver.setNameAr(employee.getEmpNameAr());
						approver.setEmail(employee.getEmail());
						
						notifierPeople.setApprover(approver);
						notifierPeople.setDelegateeNameEn(delNotifierPeople.getApprover().getNameEng());
						notifierPeople.setDelegateeNameAr(delNotifierPeople.getApprover().getNameAr());
		}
		
		
		if(null == empHigherApprover.getUserNameDelegated() || empHigherApprover.getUserNameDelegated().equals(Constants.CONST_NOT_AVAILABLE) )
		{
			notifierPeople.setApproverHigher(null);
		}
		else
		{
			Employee employee = null;
			try
			{
				employee = dpsServiceDao.getEmployee(empHigherApprover.getEmpNumberDelegated(), empHigherApprover.getUserNameDelegated(), false);
			}
			catch (ExceptionEmptyResultset ex)
			{
				logger.error("Error fetching delegated data for higher approver for notification ");
			}
			Approver	approverHigher	=	new Approver();
						approverHigher.setNameEng(employee.getEmpNameEn());
						approverHigher.setNameAr(employee.getEmpNameAr());
						approverHigher.setEmail(employee.getEmail());
						
						notifierPeople.setApproverHigher(approverHigher);
						notifierPeople.setDelegateeNameEn(delNotifierPeople.getApproverHigher().getNameEng());
						notifierPeople.setDelegateeNameAr(delNotifierPeople.getApproverHigher().getNameAr());
		}
		
		
		if(
			( null == empApprover.getUserNameDelegated() || empApprover.getUserNameDelegated().equals(Constants.CONST_NOT_AVAILABLE) )
			&&
			( null == empHigherApprover.getUserNameDelegated() || empHigherApprover.getUserNameDelegated().equals(Constants.CONST_NOT_AVAILABLE) )
			)
			{
				notifierPeople = null;
			}
		
		return notifierPeople;
	}
	
	
	
	
	
}
