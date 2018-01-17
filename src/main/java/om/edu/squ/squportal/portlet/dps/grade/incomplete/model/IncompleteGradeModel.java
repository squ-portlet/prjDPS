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
 * File Name			:	IncompleteGradeModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.model
 * Date of creation		:	Jan 3, 2018  9:20:50 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.model;

import om.edu.squ.squportal.portlet.dps.security.Crypto;

/**
 * @author Bhabesh
 *
 */
public class IncompleteGradeModel
{
	private	String	id;
	private	String	studentNo;
	private	String	stdStatCode;
	private	String	courseYear;
	private	String	semester;
	private	String	sectCode;
	private	String	lAbrCourseNo;
	private	String	courseNo;
	private	String	sectionNo;
	private	String	comment;
	
	/* Security cipher */
	private	String	salt;
	private	String	four;
	
	
	public void decrypt(Crypto crypto, String salt, String four, Object object)
	{
		IncompleteGradeModel	incompleteGradeModel	=	(IncompleteGradeModel) object;
				if(null != salt && null != four)
				{
					this.id					=		incompleteGradeModel.getId();
					this.studentNo			=		(null==incompleteGradeModel.getStudentNo() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getStudentNo());
					this.stdStatCode		=		(null==incompleteGradeModel.getStdStatCode() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getStdStatCode());
					this.courseYear			=		(null==incompleteGradeModel.getCourseYear() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getCourseYear());
					this.semester			=		(null==incompleteGradeModel.getSemester() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getSemester());
					this.sectCode			=		(null==incompleteGradeModel.getSectCode() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getSectCode());
					this.lAbrCourseNo		=		(null==incompleteGradeModel.getlAbrCourseNo() ) ?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getlAbrCourseNo());
					this.courseNo			=		(null==incompleteGradeModel.getCourseNo() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getCourseNo());
					this.sectionNo			=		(null==incompleteGradeModel.getSectionNo() ) 	?  null	:	crypto.decrypt(salt,four,incompleteGradeModel.getSectionNo());
					this.comment			=		incompleteGradeModel.getComment();
				}
	}
	
	/**
	 * Getter Method	: getId
	 * @return the id
	 * 
	 * Date				: Jan 16, 2018
	 */
	public String getId()
	{
		return this.id;
	}

	/**
	 * Setter method : setId
	 * @param id the id to set
	 * 
	 * Date          : Jan 16, 2018 8:57:37 AM
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getCourseYear
	 * @return the courseYear
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getCourseYear()
	{
		return this.courseYear;
	}
	/**
	 * Setter method : setCourseYear
	 * @param courseYear the courseYear to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setCourseYear(String courseYear)
	{
		this.courseYear = courseYear;
	}
	/**
	 * Getter Method	: getSemester
	 * @return the semester
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getSemester()
	{
		return this.semester;
	}
	/**
	 * Setter method : setSemester
	 * @param semester the semester to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	/**
	 * Getter Method	: getSectCode
	 * @return the sectCode
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getSectCode()
	{
		return this.sectCode;
	}
	/**
	 * Setter method : setSectCode
	 * @param sectCode the sectCode to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setSectCode(String sectCode)
	{
		this.sectCode = sectCode;
	}
	/**
	 * Getter Method	: getlAbrCourseNo
	 * @return the lAbrCourseNo
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getlAbrCourseNo()
	{
		return this.lAbrCourseNo;
	}
	/**
	 * Setter method : setlAbrCourseNo
	 * @param lAbrCourseNo the lAbrCourseNo to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setlAbrCourseNo(String lAbrCourseNo)
	{
		this.lAbrCourseNo = lAbrCourseNo;
	}
	/**
	 * Getter Method	: getCourseNo
	 * @return the courseNo
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getCourseNo()
	{
		return this.courseNo;
	}

	/**
	 * Setter method : setCourseNo
	 * @param courseNo the courseNo to set
	 * 
	 * Date          : Jan 11, 2018 4:01:38 PM
	 */
	public void setCourseNo(String courseNo)
	{
		this.courseNo = courseNo;
	}

	/**
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	/**
	 * Getter Method	: getComment
	 * @return the comment
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getComment()
	{
		return this.comment;
	}
	/**
	 * Setter method : setComment
	 * @param comment the comment to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	/**
	 * Getter Method	: getSalt
	 * @return the salt
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getSalt()
	{
		return this.salt;
	}
	/**
	 * Setter method : setSalt
	 * @param salt the salt to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	/**
	 * Getter Method	: getFour
	 * @return the four
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getFour()
	{
		return this.four;
	}
	/**
	 * Setter method : setFour
	 * @param four the four to set
	 * 
	 * Date          : Jan 11, 2018 12:21:33 PM
	 */
	public void setFour(String four)
	{
		this.four = four;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "IncompleteGradeModel [id=" + this.id + ", studentNo="
				+ this.studentNo + ", stdStatCode=" + this.stdStatCode
				+ ", courseYear=" + this.courseYear + ", semester="
				+ this.semester + ", sectCode=" + this.sectCode
				+ ", lAbrCourseNo=" + this.lAbrCourseNo + ", courseNo="
				+ this.courseNo + ", sectionNo=" + this.sectionNo
				+ ", comment=" + this.comment + ", salt=" + this.salt
				+ ", four=" + this.four + "]";
	}
	
	
	
}
