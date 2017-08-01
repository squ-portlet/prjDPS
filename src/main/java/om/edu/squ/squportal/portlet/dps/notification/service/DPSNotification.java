package om.edu.squ.squportal.portlet.dps.notification.service;

import om.edu.squ.squportal.notification.exception.NotificationException;
import om.edu.squ.squportal.portlet.dps.notification.bo.NotifierPeople;

public interface DPSNotification
{
	/**
	 * 
	 * method name  : sendNotification
	 * @param emailSubject
	 * @param notifierPeople
	 * @param formType
	 * @param isTest
	 * @return
	 * @throws Exception
	 * DPSNotification
	 * return type  : String
	 * 
	 * purpose		: Send notification (SMS & E-mail to student and approvers)
	 *
	 * Date    		:	Jul 27, 2017 9:20:09 AM
	 */
	public String sendNotification( String emailSubject, NotifierPeople notifierPeople,   String formType, boolean isTest)  throws NotificationException;
}
