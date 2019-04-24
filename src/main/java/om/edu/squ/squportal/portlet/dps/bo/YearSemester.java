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
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 16, 2017  9:34:09 AM
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
public class YearSemester
{
	private		int		year;
	private		int		semesterCode;
	private		String	semesterAbbr;				//	Semester Appriviation (e.g. SP = Spring)
	private		String	semesterName;

	/**
	 * Getter Method	: getYear
	 * @return the year
	 * 
	 * Date				: Jan 16, 2017
	 */
	public int getYear()
	{
		return this.year;
	}
	/**
	 * Setter method : setYear
	 * @param year the year to set
	 * 
	 * Date          : Jan 16, 2017 9:35:44 AM
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	/**
	 * Getter Method	: getSemesterCode
	 * @return the semesterCode
	 * 
	 * Date				: Jan 16, 2017
	 */
	public int getSemesterCode()
	{
		return this.semesterCode;
	}
	/**
	 * Setter method : setSemesterCode
	 * @param semesterCode the semesterCode to set
	 * 
	 * Date          : Jan 16, 2017 9:35:44 AM
	 */
	public void setSemesterCode(int semesterCode)
	{
		this.semesterCode = semesterCode;
	}
	/**
	 * Getter Method	: getSemesterAbbr
	 * @return the semesterAbbr
	 * 
	 * Date				: Jan 16, 2017
	 */
	public String getSemesterAbbr()
	{
		return this.semesterAbbr;
	}
	/**
	 * Setter method : setSemesterAbbr
	 * @param semesterAbbr the semesterAbbr to set
	 * 
	 * Date          : Jan 16, 2017 9:35:44 AM
	 */
	public void setSemesterAbbr(String semesterAbbr)
	{
		this.semesterAbbr = semesterAbbr;
	}
	/**
	 * Getter Method	: getSemesterName
	 * @return the semesterName
	 * 
	 * Date				: Jan 16, 2017
	 */
	public String getSemesterName()
	{
		return this.semesterName;
	}
	/**
	 * Setter method : setSemesterName
	 * @param semesterName the semesterName to set
	 * 
	 * Date          : Jan 16, 2017 9:35:44 AM
	 */
	public void setSemesterName(String semesterName)
	{
		this.semesterName = semesterName;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.semesterCode + this.year;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		YearSemester other = (YearSemester) obj;
		if ((this.semesterCode == other.semesterCode) && (this.year == other.year))
			{
			return true;
			}
		else
		{
			return false;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "YearSemester [year=" + this.year + ", semesterCode="
				+ this.semesterCode + ", semesterAbbr=" + this.semesterAbbr
				+ ", semesterName=" + this.semesterName + "]";
	}
	
	
	
}
