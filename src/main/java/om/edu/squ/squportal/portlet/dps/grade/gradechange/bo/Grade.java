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
 * File Name			:	Grade.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.bo
 * Date of creation		:	Nov 15, 2017  9:33:28 AM
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
public class Grade
{
	private	int		gradeCode;
	private	String	gradeVal;
	/**
	 * Getter Method	: getGradeCode
	 * @return the gradeCode
	 * 
	 * Date				: Nov 15, 2017
	 */
	public int getGradeCode()
	{
		return this.gradeCode;
	}
	/**
	 * Setter method : setGradeCode
	 * @param gradeCode the gradeCode to set
	 * 
	 * Date          : Nov 15, 2017 9:34:34 AM
	 */
	public void setGradeCode(int gradeCode)
	{
		this.gradeCode = gradeCode;
	}
	/**
	 * Getter Method	: getGradeVal
	 * @return the gradeVal
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getGradeVal()
	{
		return this.gradeVal;
	}
	/**
	 * Setter method : setGradeVal
	 * @param gradeVal the gradeVal to set
	 * 
	 * Date          : Nov 15, 2017 9:34:34 AM
	 */
	public void setGradeVal(String gradeVal)
	{
		this.gradeVal = gradeVal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Grade [gradeCode=" + this.gradeCode + ", gradeVal="
				+ this.gradeVal + "]";
	}
	
	
}
