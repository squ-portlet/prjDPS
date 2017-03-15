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
 * File Name			:	StudentCompletionAndJoinTime.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.rule.bo
 * Date of creation		:	Mar 13, 2017  3:47:09 PM
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
public class StudentCompletionAndJoinTime
{
	private	String	studentNo;
	private	String 	stdStatCode;
	private	int		estimatedSemesters;
	private	int		fromCCYrCode;
	private	int		fromSemCode;
	private	int		currentYear;
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Mar 13, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Mar 13, 2017 3:53:03 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Mar 13, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Mar 13, 2017 3:53:03 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getEstimatedSemesters
	 * @return the estimatedSemesters
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getEstimatedSemesters()
	{
		return this.estimatedSemesters;
	}
	/**
	 * Setter method : setEstimatedSemesters
	 * @param estimatedSemesters the estimatedSemesters to set
	 * 
	 * Date          : Mar 13, 2017 3:53:03 PM
	 */
	public void setEstimatedSemesters(int estimatedSemesters)
	{
		this.estimatedSemesters = estimatedSemesters;
	}
	/**
	 * Getter Method	: getFromCCYrCode
	 * @return the fromCCYrCode
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getFromCCYrCode()
	{
		return this.fromCCYrCode;
	}
	/**
	 * Setter method : setFromCCYrCode
	 * @param fromCCYrCode the fromCCYrCode to set
	 * 
	 * Date          : Mar 13, 2017 3:53:03 PM
	 */
	public void setFromCCYrCode(int fromCCYrCode)
	{
		this.fromCCYrCode = fromCCYrCode;
	}
	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getFromSemCode()
	{
		return this.fromSemCode;
	}
	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Mar 13, 2017 3:53:03 PM
	 */
	public void setFromSemCode(int fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}
	
	/**
	 * Getter Method	: getCurrentYear
	 * @return the currentYear
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getCurrentYear()
	{
		return this.currentYear;
	}
	/**
	 * Setter method : setCurrentYear
	 * @param currentYear the currentYear to set
	 * 
	 * Date          : Mar 13, 2017 5:09:46 PM
	 */
	public void setCurrentYear(int currentYear)
	{
		this.currentYear = currentYear;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "StudentCompletionAndJoinTime [studentNo=" + this.studentNo
				+ ", stdStatCode=" + this.stdStatCode + ", estimatedSemesters="
				+ this.estimatedSemesters + ", fromCCYrCode="
				+ this.fromCCYrCode + ", fromSemCode=" + this.fromSemCode
				+ ", currentYear=" + this.currentYear + "]";
	}
	
	
}
