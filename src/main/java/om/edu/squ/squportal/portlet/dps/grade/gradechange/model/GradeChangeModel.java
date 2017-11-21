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
	private	String	studentNo;
	private	String	courseYear;
	private	String	semCode;
	private	String	sectionNo;
	private	String	courseCode;
	private	String	lAbrCrsNo;
	private	String	gradeCodeOld;
	private	String	gradeCodeNew;
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
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Nov 20, 2017 11:58:36 AM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
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
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Nov 20, 2017 11:58:55 AM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	
	/**
	 * Getter Method	: getCourseCode
	 * @return the courseCode
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getCourseCode()
	{
		return this.courseCode;
	}
	/**
	 * Setter method : setCourseCode
	 * @param courseCode the courseCode to set
	 * 
	 * Date          : Nov 20, 2017 11:59:19 AM
	 */
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
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
	 * Getter Method	: getGradeCodeOld
	 * @return the gradeCodeOld
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getGradeCodeOld()
	{
		return this.gradeCodeOld;
	}
	/**
	 * Setter method : setGradeCodeOld
	 * @param gradeCodeOld the gradeCodeOld to set
	 * 
	 * Date          : Nov 20, 2017 11:59:36 AM
	 */
	public void setGradeCodeOld(String gradeCodeOld)
	{
		this.gradeCodeOld = gradeCodeOld;
	}
	/**
	 * Getter Method	: getGradeCodeNew
	 * @return the gradeCodeNew
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getGradeCodeNew()
	{
		return this.gradeCodeNew;
	}
	/**
	 * Setter method : setGradeCodeNew
	 * @param gradeCodeNew the gradeCodeNew to set
	 * 
	 * Date          : Nov 20, 2017 11:59:36 AM
	 */
	public void setGradeCodeNew(String gradeCodeNew)
	{
		this.gradeCodeNew = gradeCodeNew;
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
		return "GradeChangeModel [studentId=" + this.studentId + ", studentNo="
				+ this.studentNo + ", courseYear=" + this.courseYear
				+ ", semCode=" + this.semCode + ", sectionNo=" + this.sectionNo
				+ ", courseCode=" + this.courseCode + ", lAbrCrsNo="
				+ this.lAbrCrsNo + ", gradeCodeOld=" + this.gradeCodeOld
				+ ", gradeCodeNew=" + this.gradeCodeNew + ", gradeValNew="
				+ this.gradeValNew + ", salt=" + this.salt + ", four="
				+ this.four + "]";
	}
	
	

	
}
