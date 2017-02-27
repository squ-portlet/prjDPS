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
 * File Name			:	ExtensionReason.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.bo
 * Date of creation		:	Jan 16, 2017  4:34:39 PM
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
package om.edu.squ.squportal.portlet.dps.study.extension.bo;

/**
 * @author Bhabesh
 *
 */
public class ExtensionReason
{
	private	String	siscodecd;
	private	String	reasonName;
	/**
	 * Getter Method	: getSiscodecd
	 * @return the siscodecd
	 * 
	 * Date				: Jan 16, 2017
	 */
	public String getSiscodecd()
	{
		return this.siscodecd;
	}
	/**
	 * Setter method : setSiscodecd
	 * @param siscodecd the siscodecd to set
	 * 
	 * Date          : Jan 16, 2017 4:40:39 PM
	 */
	public void setSiscodecd(String siscodecd)
	{
		this.siscodecd = siscodecd;
	}
	/**
	 * Getter Method	: getReasonName
	 * @return the reasonName
	 * 
	 * Date				: Jan 16, 2017
	 */
	public String getReasonName()
	{
		return this.reasonName;
	}
	/**
	 * Setter method : setReasonName
	 * @param reasonName the reasonName to set
	 * 
	 * Date          : Jan 16, 2017 4:40:39 PM
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
		return "ExtensionReason [siscodecd=" + this.siscodecd + ", reasonName="
				+ this.reasonName + "]";
	}
	
	
}
