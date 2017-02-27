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
 * File Name			:	RoleNameValue.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Feb 13, 2017  9:25:24 PM
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
public class RoleNameValue
{
	private		String	roleName;
	private		String	roleValue;
	
	public RoleNameValue()	{}
	
	public RoleNameValue(String roleName, String roleVale)
	{
		this.roleName	=	roleName;
		this.roleValue	=	roleVale;
	}
	/**
	 * Getter Method	: getRoleName
	 * @return the roleName
	 * 
	 * Date				: Feb 13, 2017
	 */
	public String getRoleName()
	{
		return this.roleName;
	}
	/**
	 * Setter method : setRoleName
	 * @param roleName the roleName to set
	 * 
	 * Date          : Feb 13, 2017 9:27:46 PM
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	/**
	 * Getter Method	: getRoleValue
	 * @return the roleValue
	 * 
	 * Date				: Feb 13, 2017
	 */
	public String getRoleValue()
	{
		return this.roleValue;
	}
	/**
	 * Setter method : setRoleValue
	 * @param roleValue the roleValue to set
	 * 
	 * Date          : Feb 13, 2017 9:27:46 PM
	 */
	public void setRoleValue(String roleValue)
	{
		this.roleValue = roleValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RoleNameValue [roleName=" + this.roleName + ", roleValue="
				+ this.roleValue + "]";
	}
	
	
	
	
}
