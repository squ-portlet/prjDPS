/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	Branch.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 5, 2017  4:59:42 PM
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
package om.edu.squ.squportal.portlet.dps.bo;

/**
 * @author Bhabesh
 *
 */
public class Branch
{
	private	String	branchCode;
	private	String	branchName;
	/**
	 * Getter Method	: getBranchCode
	 * @return the branchCode
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getBranchCode()
	{
		return this.branchCode;
	}
	/**
	 * Setter method : setBranchCode
	 * @param branchCode the branchCode to set
	 * 
	 * Date          : Jan 5, 2017 5:00:51 PM
	 */
	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}
	/**
	 * Getter Method	: getBranchName
	 * @return the branchName
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getBranchName()
	{
		return this.branchName;
	}
	/**
	 * Setter method : setBranchName
	 * @param branchName the branchName to set
	 * 
	 * Date          : Jan 5, 2017 5:00:51 PM
	 */
	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Branch [branchCode=" + this.branchCode + ", branchName="
				+ this.branchName + "]";
	}
	
	
}
