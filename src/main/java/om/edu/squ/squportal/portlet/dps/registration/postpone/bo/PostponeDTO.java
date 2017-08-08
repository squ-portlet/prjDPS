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
 * File Name			:	PostponeDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.bo
 * Date of creation		:	Aug 7, 2017  3:54:56 PM
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

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;

/**
 * @author Bhabesh
 *
 */
public class PostponeDTO
{
	private String	studentNo;
	private	String	studentStatCode;
	private	String	fromCcYearCode;
	private	String	fromSemCode;
	private	String	toCcYearCode;
	private	String	toSemCode;
	private	String	reasonCode;
	private	String	reasonOther;
	private	String	commentEng;
	private	String	commentArb;
	private	String	yearSem;
	private	String	userName;
	
	/**
	 * 
	 * Constructor
	 *
	 */
	public PostponeDTO(){}
	
	/**
	 * 
	 * Constructor
	 * @param model
	 *
	 */
	public PostponeDTO(PostponeStudentModel model)
	{
		this.studentNo			=	model.getStudentNo();
		this.studentStatCode	=	model.getStudentStatCode();
		this.fromCcYearCode		=	model.getFromCcYearCode();
		this.fromSemCode		=	model.getFromSemCode();
		this.toCcYearCode		=	model.getToCcYearCode();
		this.toSemCode			=	model.getToSemCode();
		this.reasonCode			=	model.getReasonCode();
		this.reasonOther		=	model.getReasonOther();
		this.commentEng			=	model.getCommentEng();
		this.commentArb			=	model.getCommentArb();
		this.yearSem			=	model.getYearSem();
	}

	/**
	 * 
	 * Constructor
	 * @param student
	 * @param studentModel
	 * @param userName
	 *
	 */
	public PostponeDTO(Student student, PostponeStudentModel studentModel, String userName)
	{
		this.userName			=	userName;
		
		this.studentNo			=	student.getAcademicDetail().getStudentNo();
		this.studentStatCode	=	student.getAcademicDetail().getStdStatCode();
		
		this.fromCcYearCode		=	studentModel.getYearSem().split("-")[0];
		this.toCcYearCode		=	studentModel.getYearSem().split("-")[0];
		this.fromSemCode		=	studentModel.getYearSem().split("-")[1];
		this.toSemCode			=	studentModel.getYearSem().split("-")[1];
		
		this.reasonCode			=	studentModel.getReasonCode();
		this.reasonOther		=	studentModel.getReasonOther();
		
	}
	
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}


	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}


	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}


	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}


	/**
	 * Getter Method	: getFromCcYearCode
	 * @return the fromCcYearCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getFromCcYearCode()
	{
		return this.fromCcYearCode;
	}


	/**
	 * Setter method : setFromCcYearCode
	 * @param fromCcYearCode the fromCcYearCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setFromCcYearCode(String fromCcYearCode)
	{
		this.fromCcYearCode = fromCcYearCode;
	}


	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getFromSemCode()
	{
		return this.fromSemCode;
	}


	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setFromSemCode(String fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}


	/**
	 * Getter Method	: getToCcYearCode
	 * @return the toCcYearCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getToCcYearCode()
	{
		return this.toCcYearCode;
	}


	/**
	 * Setter method : setToCcYearCode
	 * @param toCcYearCode the toCcYearCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setToCcYearCode(String toCcYearCode)
	{
		this.toCcYearCode = toCcYearCode;
	}


	/**
	 * Getter Method	: getToSemCode
	 * @return the toSemCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getToSemCode()
	{
		return this.toSemCode;
	}


	/**
	 * Setter method : setToSemCode
	 * @param toSemCode the toSemCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setToSemCode(String toSemCode)
	{
		this.toSemCode = toSemCode;
	}


	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}


	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}


	/**
	 * Getter Method	: getReasonOther
	 * @return the reasonOther
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getReasonOther()
	{
		return this.reasonOther;
	}


	/**
	 * Setter method : setReasonOther
	 * @param reasonOther the reasonOther to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setReasonOther(String reasonOther)
	{
		this.reasonOther = reasonOther;
	}


	/**
	 * Getter Method	: getCommentEng
	 * @return the commentEng
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getCommentEng()
	{
		return this.commentEng;
	}


	/**
	 * Setter method : setCommentEng
	 * @param commentEng the commentEng to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setCommentEng(String commentEng)
	{
		this.commentEng = commentEng;
	}


	/**
	 * Getter Method	: getCommentArb
	 * @return the commentArb
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getCommentArb()
	{
		return this.commentArb;
	}


	/**
	 * Setter method : setCommentArb
	 * @param commentArb the commentArb to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setCommentArb(String commentArb)
	{
		this.commentArb = commentArb;
	}


	/**
	 * Getter Method	: getYearSem
	 * @return the yearSem
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getYearSem()
	{
		return this.yearSem;
	}


	/**
	 * Setter method : setYearSem
	 * @param yearSem the yearSem to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setYearSem(String yearSem)
	{
		this.yearSem = yearSem;
	}
	

	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Aug 8, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}

	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Aug 8, 2017 9:58:12 AM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PostponeDTO [studentNo=" + this.studentNo
				+ ", studentStatCode=" + this.studentStatCode
				+ ", fromCcYearCode=" + this.fromCcYearCode + ", fromSemCode="
				+ this.fromSemCode + ", toCcYearCode=" + this.toCcYearCode
				+ ", toSemCode=" + this.toSemCode + ", reasonCode="
				+ this.reasonCode + ", reasonOther=" + this.reasonOther
				+ ", commentEng=" + this.commentEng + ", commentArb="
				+ this.commentArb + ", yearSem=" + this.yearSem + ", userName="
				+ this.userName + "]";
	}
	
	
	
}
