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
 * File Name			:	GradeDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.bo
 * Date of creation		:	Nov 15, 2017  9:28:42 AM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.bo;

/**
 * @author Bhabesh
 *
 */
public class GradeDTO
{
	private		Course	course;
	private		String	sectionNo;
	private		Grade	grade;
	/**
	 * Getter Method	: getCourse
	 * @return the course
	 * 
	 * Date				: Nov 15, 2017
	 */
	public Course getCourse()
	{
		return this.course;
	}
	/**
	 * Setter method : setCourse
	 * @param course the course to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setCourse(Course course)
	{
		this.course = course;
	}
	/**
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	/**
	 * Getter Method	: getGrade
	 * @return the grade
	 * 
	 * Date				: Nov 15, 2017
	 */
	public Grade getGrade()
	{
		return this.grade;
	}
	/**
	 * Setter method : setGrade
	 * @param grade the grade to set
	 * 
	 * Date          : Nov 15, 2017 9:35:47 AM
	 */
	public void setGrade(Grade grade)
	{
		this.grade = grade;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeDTO [course=" + this.course + ", sectionNo="
				+ this.sectionNo + ", grade=" + this.grade + "]";
	}
	
	
	
	
}
