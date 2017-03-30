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
 * File Name			:	Course.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Mar 29, 2017  6:56:48 PM
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
public class Course
{
	private	String	courseNo;
	private	String	courseName;
	private	String	sectionNo;
	private	String	yearSemester;
	private	int		credits;
	/**
	 * Getter Method	: getCourseNo
	 * @return the courseNo
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getCourseNo()
	{
		return this.courseNo;
	}
	/**
	 * Setter method : setCourseNo
	 * @param courseNo the courseNo to set
	 * 
	 * Date          : Mar 29, 2017 6:58:54 PM
	 */
	public void setCourseNo(String courseNo)
	{
		this.courseNo = courseNo;
	}
	/**
	 * Getter Method	: getCourseName
	 * @return the courseName
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getCourseName()
	{
		return this.courseName;
	}
	/**
	 * Setter method : setCourseName
	 * @param courseName the courseName to set
	 * 
	 * Date          : Mar 29, 2017 6:58:54 PM
	 */
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	/**
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Mar 29, 2017 6:58:54 PM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	/**
	 * Getter Method	: getYearSemester
	 * @return the yearSemester
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getYearSemester()
	{
		return this.yearSemester;
	}
	/**
	 * Setter method : setYearSemester
	 * @param yearSemester the yearSemester to set
	 * 
	 * Date          : Mar 29, 2017 6:58:54 PM
	 */
	public void setYearSemester(String yearSemester)
	{
		this.yearSemester = yearSemester;
	}
	/**
	 * Getter Method	: getCredits
	 * @return the credits
	 * 
	 * Date				: Mar 29, 2017
	 */
	public int getCredits()
	{
		return this.credits;
	}
	/**
	 * Setter method : setCredits
	 * @param credits the credits to set
	 * 
	 * Date          : Mar 29, 2017 6:58:54 PM
	 */
	public void setCredits(int credits)
	{
		this.credits = credits;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Course [courseNo=" + this.courseNo + ", courseName="
				+ this.courseName + ", sectionNo=" + this.sectionNo
				+ ", yearSemester=" + this.yearSemester + ", credits="
				+ this.credits + "]";
	}
	
	
	
}
