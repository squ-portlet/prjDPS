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
 * File Name			:	ExtensionStudentDataModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.model
 * Date of creation		:	Jan 12, 2017  1:39:41 PM
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
package om.edu.squ.squportal.portlet.dps.study.extension.model;

/**
 * @author Bhabesh
 *
 */
public class ExtensionStudentDataModel
{
	private	String	studentNo;
	private	String	studentStatCode;
	private	String	fromCcYrCode;
	private	String	fromSemCode;
	private	String	toCcYrCode;
	private	String	toSemCode;
	private	String	reasonCode;
	private	String	reasonOther;
	private	String	commentEng;
	private	String	commentArb;
	private	String	yearSem;
	
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}
	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}
	/**
	 * Getter Method	: getFromCcYrCode
	 * @return the fromCcYrCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getFromCcYrCode()
	{
		return this.fromCcYrCode;
	}
	/**
	 * Setter method : setFromCcYrCode
	 * @param fromCcYrCode the fromCcYrCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setFromCcYrCode(String fromCcYrCode)
	{
		this.fromCcYrCode = fromCcYrCode;
	}
	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getFromSemCode()
	{
		return this.fromSemCode;
	}
	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setFromSemCode(String fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}
	/**
	 * Getter Method	: getToCcYrCode
	 * @return the toCcYrCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getToCcYrCode()
	{
		return this.toCcYrCode;
	}
	/**
	 * Setter method : setToCcYrCode
	 * @param toCcYrCode the toCcYrCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setToCcYrCode(String toCcYrCode)
	{
		this.toCcYrCode = toCcYrCode;
	}
	/**
	 * Getter Method	: getToSemCode
	 * @return the toSemCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getToSemCode()
	{
		return this.toSemCode;
	}
	/**
	 * Setter method : setToSemCode
	 * @param toSemCode the toSemCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setToSemCode(String toSemCode)
	{
		this.toSemCode = toSemCode;
	}
	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}
	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}
	
	/**
	 * Getter Method	: getReasonOther
	 * @return the reasonOther
	 * 
	 * Date				: Feb 5, 2017
	 */
	public String getReasonOther()
	{
		return this.reasonOther;
	}
	/**
	 * Setter method : setReasonOther
	 * @param reasonOther the reasonOther to set
	 * 
	 * Date          : Feb 5, 2017 5:17:08 PM
	 */
	public void setReasonOther(String reasonOther)
	{
		this.reasonOther = reasonOther;
	}
	/**
	 * Getter Method	: getCommentEng
	 * @return the commentEng
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getCommentEng()
	{
		return this.commentEng;
	}
	/**
	 * Setter method : setCommentEng
	 * @param commentEng the commentEng to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setCommentEng(String commentEng)
	{
		this.commentEng = commentEng;
	}
	/**
	 * Getter Method	: getCommentArb
	 * @return the commentArb
	 * 
	 * Date				: Jan 12, 2017
	 */
	public String getCommentArb()
	{
		return this.commentArb;
	}
	/**
	 * Setter method : setCommentArb
	 * @param commentArb the commentArb to set
	 * 
	 * Date          : Jan 12, 2017 2:56:15 PM
	 */
	public void setCommentArb(String commentArb)
	{
		this.commentArb = commentArb;
	}
	/**
	 * Getter Method	: getYearSem
	 * @return the yearSem
	 * 
	 * Date				: Jan 23, 2017
	 */
	public String getYearSem()
	{
		return this.yearSem;
	}
	/**
	 * Setter method : setYearSem
	 * @param yearSem the yearSem to set
	 * 
	 * Date          : Jan 23, 2017 3:22:03 PM
	 */
	public void setYearSem(String yearSem)
	{
		this.yearSem = yearSem;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ExtensionStudentDataModel [studentNo=" + this.studentNo
				+ ", studentStatCode=" + this.studentStatCode
				+ ", fromCcYrCode=" + this.fromCcYrCode + ", fromSemCode="
				+ this.fromSemCode + ", toCcYrCode=" + this.toCcYrCode
				+ ", toSemCode=" + this.toSemCode + ", reasonCode="
				+ this.reasonCode + ", reasonOther=" + this.reasonOther
				+ ", commentEng=" + this.commentEng + ", commentArb="
				+ this.commentArb + ", yearSem=" + this.yearSem + "]";
	}
	
	
	
}
