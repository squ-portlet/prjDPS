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
 * File Name			:	YearSemester.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.bo
 * Date of creation		:	Mar 14, 2017  10:40:27 AM
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
package om.edu.squ.squportal.portlet.dps.rule.bo;

/**
 * @author Bhabesh
 *
 */
public class YearSemester
{
	private	int year;
	private	int	semester;
	/**
	 * Getter Method	: getYear
	 * @return the year
	 * 
	 * Date				: Mar 14, 2017
	 */
	public int getYear()
	{
		return this.year;
	}
	/**
	 * Setter method : setYear
	 * @param year the year to set
	 * 
	 * Date          : Mar 14, 2017 10:41:10 AM
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	/**
	 * Getter Method	: getSemester
	 * @return the semester
	 * 
	 * Date				: Mar 14, 2017
	 */
	public int getSemester()
	{
		return this.semester;
	}
	/**
	 * Setter method : setSemester
	 * @param semester the semester to set
	 * 
	 * Date          : Mar 14, 2017 10:41:10 AM
	 */
	public void setSemester(int semester)
	{
		this.semester = semester;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "YearSemester [year=" + this.year + ", semester="
				+ this.semester + "]";
	}
	
	
}
