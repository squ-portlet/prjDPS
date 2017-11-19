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
 * File Name			:	GradeChangeModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.model
 * Date of creation		:	Nov 13, 2017  3:40:47 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.model;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeModel
{
	private	String	studentId;
	private	String	courseYear;
	private	String	semCode;
	private	String	lAbrCrsNo;
	private	String	gradeValNew;

	/* Security cipher */
	private	String	salt;
	private	String	four;
	
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	/**
	 * Getter Method	: getCourseYear
	 * @return the courseYear
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getCourseYear()
	{
		return this.courseYear;
	}
	/**
	 * Setter method : setCourseYear
	 * @param courseYear the courseYear to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setCourseYear(String courseYear)
	{
		this.courseYear = courseYear;
	}
	/**
	 * Getter Method	: getSemCode
	 * @return the semCode
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSemCode()
	{
		return this.semCode;
	}
	/**
	 * Setter method : setSemCode
	 * @param semCode the semCode to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setSemCode(String semCode)
	{
		this.semCode = semCode;
	}
	
	/**
	 * Getter Method	: getlAbrCrsNo
	 * @return the lAbrCrsNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getlAbrCrsNo()
	{
		return this.lAbrCrsNo;
	}
	/**
	 * Setter method : setlAbrCrsNo
	 * @param lAbrCrsNo the lAbrCrsNo to set
	 * 
	 * Date          : Nov 15, 2017 2:48:18 PM
	 */
	public void setlAbrCrsNo(String lAbrCrsNo)
	{
		this.lAbrCrsNo = lAbrCrsNo;
	}
	
	/**
	 * Getter Method	: getGradeValNew
	 * @return the gradeValNew
	 * 
	 * Date				: Nov 19, 2017
	 */
	public String getGradeValNew()
	{
		return this.gradeValNew;
	}
	/**
	 * Setter method : setGradeValNew
	 * @param gradeValNew the gradeValNew to set
	 * 
	 * Date          : Nov 19, 2017 1:49:31 PM
	 */
	public void setGradeValNew(String gradeValNew)
	{
		this.gradeValNew = gradeValNew;
	}
	/**
	 * Getter Method	: getSalt
	 * @return the salt
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSalt()
	{
		return this.salt;
	}
	/**
	 * Setter method : setSalt
	 * @param salt the salt to set
	 * 
	 * Date          : Nov 15, 2017 6:56:03 PM
	 */
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	/**
	 * Getter Method	: getFour
	 * @return the four
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getFour()
	{
		return this.four;
	}
	/**
	 * Setter method : setFour
	 * @param four the four to set
	 * 
	 * Date          : Nov 15, 2017 6:56:03 PM
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
		return "GradeChangeModel [studentId=" + this.studentId
				+ ", courseYear=" + this.courseYear + ", semCode="
				+ this.semCode + ", lAbrCrsNo=" + this.lAbrCrsNo
				+ ", gradeValNew=" + this.gradeValNew + ", salt=" + this.salt
				+ ", four=" + this.four + "]";
	}
	
	

	
}
