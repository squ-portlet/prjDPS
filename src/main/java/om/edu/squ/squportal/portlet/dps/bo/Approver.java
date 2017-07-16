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
 * File Name			:	Approver.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jul 16, 2017  9:32:13 AM
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
public class Approver
{
	private	String	nameEng;
	private	String	nameAr;
	private	String	email;
	private	String	phone;
	private	String	roleNameEng;
	private	String	roleNameAr;
	private	boolean	higherSequence;
	/**
	 * Getter Method	: getNameEng
	 * @return the nameEng
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getNameEng()
	{
		return this.nameEng;
	}
	/**
	 * Setter method : setNameEng
	 * @param nameEng the nameEng to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setNameEng(String nameEng)
	{
		this.nameEng = nameEng;
	}
	/**
	 * Getter Method	: getNameAr
	 * @return the nameAr
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getNameAr()
	{
		return this.nameAr;
	}
	/**
	 * Setter method : setNameAr
	 * @param nameAr the nameAr to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setNameAr(String nameAr)
	{
		this.nameAr = nameAr;
	}
	/**
	 * Getter Method	: getEmail
	 * @return the email
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getEmail()
	{
		return this.email;
	}
	/**
	 * Setter method : setEmail
	 * @param email the email to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	/**
	 * Getter Method	: getPhone
	 * @return the phone
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getPhone()
	{
		return this.phone;
	}
	/**
	 * Setter method : setPhone
	 * @param phone the phone to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	/**
	 * Getter Method	: getRoleNameEng
	 * @return the roleNameEng
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getRoleNameEng()
	{
		return this.roleNameEng;
	}
	/**
	 * Setter method : setRoleNameEng
	 * @param roleNameEng the roleNameEng to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setRoleNameEng(String roleNameEng)
	{
		this.roleNameEng = roleNameEng;
	}
	/**
	 * Getter Method	: getRoleNameAr
	 * @return the roleNameAr
	 * 
	 * Date				: Jul 16, 2017
	 */
	public String getRoleNameAr()
	{
		return this.roleNameAr;
	}
	/**
	 * Setter method : setRoleNameAr
	 * @param roleNameAr the roleNameAr to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setRoleNameAr(String roleNameAr)
	{
		this.roleNameAr = roleNameAr;
	}
	/**
	 * Getter Method	: isHigherSequence
	 * @return the higherSequence
	 * 
	 * Date				: Jul 16, 2017
	 */
	public boolean isHigherSequence()
	{
		return this.higherSequence;
	}
	/**
	 * Setter method : setHigherSequence
	 * @param higherSequence the higherSequence to set
	 * 
	 * Date          : Jul 16, 2017 9:32:51 AM
	 */
	public void setHigherSequence(boolean higherSequence)
	{
		this.higherSequence = higherSequence;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Approver [nameEng=" + this.nameEng + ", nameAr=" + this.nameAr
				+ ", email=" + this.email + ", phone=" + this.phone
				+ ", roleNameEng=" + this.roleNameEng + ", roleNameAr="
				+ this.roleNameAr + ", higherSequence=" + this.higherSequence
				+ "]";
	}
	
	
	
}
