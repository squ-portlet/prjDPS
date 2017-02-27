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
 * File Name			:	Department.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 5, 2017  4:58:07 PM
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
public class Department
{
	private	String	deptCode;
	private	String	deptName;
	/**
	 * Getter Method	: getDeptCode
	 * @return the deptCode
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getDeptCode()
	{
		return this.deptCode;
	}
	/**
	 * Setter method : setDeptCode
	 * @param deptCode the deptCode to set
	 * 
	 * Date          : Jan 5, 2017 4:58:33 PM
	 */
	public void setDeptCode(String deptCode)
	{
		this.deptCode = deptCode;
	}
	/**
	 * Getter Method	: getDeptName
	 * @return the deptName
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getDeptName()
	{
		return this.deptName;
	}
	/**
	 * Setter method : setDeptName
	 * @param deptName the deptName to set
	 * 
	 * Date          : Jan 5, 2017 4:58:33 PM
	 */
	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Department [deptCode=" + this.deptCode + ", deptName="
				+ this.deptName + "]";
	}
	
	
}
