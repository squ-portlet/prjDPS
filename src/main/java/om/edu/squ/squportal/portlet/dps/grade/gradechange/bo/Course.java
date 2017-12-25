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
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.bo
 * Date of creation		:	Nov 15, 2017  9:31:56 AM
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
public class Course
{
	private	String	courseNo;
	private	String	lAbrCourseNo;
	private	String	courseName;
	/**
	 * Getter Method	: getCourseNo
	 * @return the courseNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getCourseNo()
	{
		return this.courseNo;
	}
	/**
	 * Setter method : setCourseNo
	 * @param courseNo the courseNo to set
	 * 
	 * Date          : Nov 15, 2017 9:32:53 AM
	 */
	public void setCourseNo(String courseNo)
	{
		this.courseNo = courseNo;
	}
	/**
	 * Getter Method	: getlAbrCourseNo
	 * @return the lAbrCourseNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getlAbrCourseNo()
	{
		return this.lAbrCourseNo;
	}
	/**
	 * Setter method : setlAbrCourseNo
	 * @param lAbrCourseNo the lAbrCourseNo to set
	 * 
	 * Date          : Nov 15, 2017 9:32:53 AM
	 */
	public void setlAbrCourseNo(String lAbrCourseNo)
	{
		this.lAbrCourseNo = lAbrCourseNo;
	}
	/**
	 * Getter Method	: getCourseName
	 * @return the courseName
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getCourseName()
	{
		return this.courseName;
	}
	/**
	 * Setter method : setCourseName
	 * @param courseName the courseName to set
	 * 
	 * Date          : Nov 15, 2017 9:32:53 AM
	 */
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Course [courseNo=" + this.courseNo + ", lAbrCourseNo="
				+ this.lAbrCourseNo + ", courseName=" + this.courseName + "]";
	}
	
}
