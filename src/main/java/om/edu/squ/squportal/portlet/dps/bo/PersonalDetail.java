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
 * File Name			:	PersonalDetail.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	09-January-2017
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
public class PersonalDetail
{
	private	String	id;
	private	String	studentNo;
	private	String	studentUserName;
	private	String	name;
	private	String	phone;
	private	String	email;
	private	String	region;
	private	String	willayat;
	private	String	town;
	private	String	poBox;
	private	String	postalCode;
	/**
	 * Getter Method	: getId
	 * @return the id
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getId()
	{
		return this.id;
	}
	/**
	 * Setter method : setId
	 * @param id the id to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Jan 23, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Jan 23, 2017 5:38:28 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	/**
	 * Getter Method	: getStudentUserName
	 * @return the studentUserName
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentUserName()
	{
		return this.studentUserName;
	}
	/**
	 * Setter method : setStudentUserName
	 * @param studentUserName the studentUserName to set
	 * 
	 * Date          : Apr 10, 2017 6:42:20 PM
	 */
	public void setStudentUserName(String studentUserName)
	{
		this.studentUserName = studentUserName;
	}
	/**
	 * Getter Method	: getName
	 * @return the name
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getName()
	{
		return this.name;
	}
	/**
	 * Setter method : setName
	 * @param name the name to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Getter Method	: getPhone
	 * @return the phone
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getPhone()
	{
		return this.phone;
	}
	/**
	 * Setter method : setPhone
	 * @param phone the phone to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	/**
	 * Getter Method	: getEmail
	 * @return the email
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getEmail()
	{
		return this.email;
	}
	/**
	 * Setter method : setEmail
	 * @param email the email to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	/**
	 * Getter Method	: getRegion
	 * @return the region
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getRegion()
	{
		return this.region;
	}
	/**
	 * Setter method : setRegion
	 * @param region the region to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setRegion(String region)
	{
		this.region = region;
	}
	/**
	 * Getter Method	: getWillayat
	 * @return the willayat
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getWillayat()
	{
		return this.willayat;
	}
	/**
	 * Setter method : setWillayat
	 * @param willayat the willayat to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setWillayat(String willayat)
	{
		this.willayat = willayat;
	}
	/**
	 * Getter Method	: getTown
	 * @return the town
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getTown()
	{
		return this.town;
	}
	/**
	 * Setter method : setTown
	 * @param town the town to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setTown(String town)
	{
		this.town = town;
	}
	/**
	 * Getter Method	: getPoBox
	 * @return the poBox
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getPoBox()
	{
		return this.poBox;
	}
	/**
	 * Setter method : setPoBox
	 * @param poBox the poBox to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setPoBox(String poBox)
	{
		this.poBox = poBox;
	}
	/**
	 * Getter Method	: getPostalCode
	 * @return the postalCode
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getPostalCode()
	{
		return this.postalCode;
	}
	/**
	 * Setter method : setPostalCode
	 * @param postalCode the postalCode to set
	 * 
	 * Date          : Jan 9, 2017 10:33:50 AM
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PersonalDetail [id=" + this.id + ", studentNo="
				+ this.studentNo + ", studentUserName=" + this.studentUserName
				+ ", name=" + this.name + ", phone=" + this.phone + ", email="
				+ this.email + ", region=" + this.region + ", willayat="
				+ this.willayat + ", town=" + this.town + ", poBox="
				+ this.poBox + ", postalCode=" + this.postalCode + "]";
	}

	
	
}
