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
 * File Name			:	PostponeReason.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.bo
 * Date of creation		:	May 25, 2017  4:00:38 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.bo;

/**
 * @author Bhabesh
 *
 */
public class PostponeReason
{
	private	String	siscodecd;
	private	String	reasonName;
	/**
	 * Getter Method	: getSiscodecd
	 * @return the siscodecd
	 * 
	 * Date				: May 25, 2017
	 */
	public String getSiscodecd()
	{
		return this.siscodecd;
	}
	/**
	 * Setter method : setSiscodecd
	 * @param siscodecd the siscodecd to set
	 * 
	 * Date          : May 25, 2017 4:00:53 PM
	 */
	public void setSiscodecd(String siscodecd)
	{
		this.siscodecd = siscodecd;
	}
	/**
	 * Getter Method	: getReasonName
	 * @return the reasonName
	 * 
	 * Date				: May 25, 2017
	 */
	public String getReasonName()
	{
		return this.reasonName;
	}
	/**
	 * Setter method : setReasonName
	 * @param reasonName the reasonName to set
	 * 
	 * Date          : May 25, 2017 4:00:53 PM
	 */
	public void setReasonName(String reasonName)
	{
		this.reasonName = reasonName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PostponeReason [siscodecd=" + this.siscodecd + ", reasonName="
				+ this.reasonName + "]";
	}
	
	
}
