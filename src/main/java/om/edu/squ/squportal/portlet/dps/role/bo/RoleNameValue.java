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
	private		String	roleValueEng;
	private		String	roleValueAr;
	private		int		sequenceNo;
	
	public RoleNameValue()	{}
	
	public RoleNameValue(String roleName, String roleVale)
	{
		this.roleName	=	roleName;
		this.roleValue	=	roleVale;
	}
	public RoleNameValue(int sequenceNo, String roleName, String roleVale, String roleValueEng, String roleValueAr)
	{
		this.sequenceNo		=	sequenceNo;
		this.roleName		=	roleName;
		this.roleValue		=	roleVale;
		this.roleValueEng	=	roleValueEng;
		this.roleValueAr	=	roleValueAr;
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
	
	/**
	 * Getter Method	: getRoleValueEng
	 * @return the roleValueEng
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getRoleValueEng()
	{
		return this.roleValueEng;
	}

	/**
	 * Setter method : setRoleValueEng
	 * @param roleValueEng the roleValueEng to set
	 * 
	 * Date          : Oct 17, 2018 9:16:23 AM
	 */
	public void setRoleValueEng(String roleValueEng)
	{
		this.roleValueEng = roleValueEng;
	}

	/**
	 * Getter Method	: getRoleValueAr
	 * @return the roleValueAr
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getRoleValueAr()
	{
		return this.roleValueAr;
	}

	/**
	 * Setter method : setRoleValueAr
	 * @param roleValueAr the roleValueAr to set
	 * 
	 * Date          : Oct 17, 2018 9:16:23 AM
	 */
	public void setRoleValueAr(String roleValueAr)
	{
		this.roleValueAr = roleValueAr;
	}

	/**
	 * Getter Method	: getSequenceNo
	 * @return the sequenceNo
	 * 
	 * Date				: Jul 18, 2017
	 */
	public int getSequenceNo()
	{
		return this.sequenceNo;
	}

	/**
	 * Setter method : setSequenceNo
	 * @param sequenceNo the sequenceNo to set
	 * 
	 * Date          : Jul 18, 2017 2:16:21 PM
	 */
	public void setSequenceNo(int sequenceNo)
	{
		this.sequenceNo = sequenceNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RoleNameValue [roleName=" + this.roleName + ", roleValue="
				+ this.roleValue + ", roleValueEng=" + this.roleValueEng
				+ ", roleValueAr=" + this.roleValueAr + ", sequenceNo="
				+ this.sequenceNo + "]";
	}
	
	
	
	
}
