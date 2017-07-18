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
 * File Name			:	ApprovalStatus.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Jul 18, 2017  3:32:09 PM
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
package om.edu.squ.squportal.portlet.dps.role.bo;

/**
 * @author Bhabesh
 *
 */
public class ApprovalStatus
{
	private	String 	statusCode;
	private	String	statusCodeName;
	private	String	statusDescription;
	private	String	statusDescEng;
	private	String	statusDescAr;
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Jul 18, 2017 3:33:41 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	/**
	 * Getter Method	: getStatusCodeName
	 * @return the statusCodeName
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusCodeName()
	{
		return this.statusCodeName;
	}
	/**
	 * Setter method : setStatusCodeName
	 * @param statusCodeName the statusCodeName to set
	 * 
	 * Date          : Jul 18, 2017 3:33:41 PM
	 */
	public void setStatusCodeName(String statusCodeName)
	{
		this.statusCodeName = statusCodeName;
	}
	/**
	 * Getter Method	: getStatusDescription
	 * @return the statusDescription
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusDescription()
	{
		return this.statusDescription;
	}
	/**
	 * Setter method : setStatusDescription
	 * @param statusDescription the statusDescription to set
	 * 
	 * Date          : Jul 18, 2017 3:33:41 PM
	 */
	public void setStatusDescription(String statusDescription)
	{
		this.statusDescription = statusDescription;
	}
	/**
	 * Getter Method	: getStatusDescEng
	 * @return the statusDescEng
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusDescEng()
	{
		return this.statusDescEng;
	}
	/**
	 * Setter method : setStatusDescEng
	 * @param statusDescEng the statusDescEng to set
	 * 
	 * Date          : Jul 18, 2017 3:33:41 PM
	 */
	public void setStatusDescEng(String statusDescEng)
	{
		this.statusDescEng = statusDescEng;
	}
	/**
	 * Getter Method	: getStatusDescAr
	 * @return the statusDescAr
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusDescAr()
	{
		return this.statusDescAr;
	}
	/**
	 * Setter method : setStatusDescAr
	 * @param statusDescAr the statusDescAr to set
	 * 
	 * Date          : Jul 18, 2017 3:33:41 PM
	 */
	public void setStatusDescAr(String statusDescAr)
	{
		this.statusDescAr = statusDescAr;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ApprovalStatus [statusCode=" + this.statusCode
				+ ", statusCodeName=" + this.statusCodeName
				+ ", statusDescription=" + this.statusDescription
				+ ", statusDescEng=" + this.statusDescEng + ", statusDescAr="
				+ this.statusDescAr + "]";
	}
	
	
}
