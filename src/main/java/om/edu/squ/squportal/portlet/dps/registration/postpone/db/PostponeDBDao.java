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
 * File Name			:	PostponeDBDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.db
 * Date of creation		:	May 25, 2017  2:04:05 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.db;

import java.util.List;
import java.util.Locale;

import om.edu.squ.squportal.portlet.dps.registration.postpone.bo.PostponeReason;

/**
 * @author Bhabesh
 *
 */
public interface PostponeDBDao 
{
	/**
	 * 
	 * method name  : getPostponeReasons
	 * @param locale
	 * @return
	 * PostponeDBImpl
	 * return type  : List<PostponeReason>
	 * 
	 * purpose		: Get list of default reasons for postpone 
	 *
	 * Date    		:	May 25, 2017 4:15:05 PM
	 */
	public List<PostponeReason> getPostponeReasons(Locale locale);
}
