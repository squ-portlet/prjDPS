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
 * File Name			:	DropCourseModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.model
 * Date of creation		:	Apr 5, 2017  4:36:20 PM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.model;

/**
 * @author Bhabesh
 *
 */
public class DropCourseModel
{
	private	String	studentNo;
	private	String	courseNo;
	private	String	sectCode;
	private	String	sectNo;
	private	String	userName;
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Apr 5, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Apr 5, 2017 4:38:08 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	/**
	 * Getter Method	: getCourseNo
	 * @return the courseNo
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getCourseNo()
	{
		return this.courseNo;
	}
	/**
	 * Setter method : setCourseNo
	 * @param courseNo the courseNo to set
	 * 
	 * Date          : Apr 10, 2017 7:06:30 PM
	 */
	public void setCourseNo(String courseNo)
	{
		this.courseNo = courseNo;
	}
	/**
	 * Getter Method	: getSectCode
	 * @return the sectCode
	 * 
	 * Date				: Apr 5, 2017
	 */
	public String getSectCode()
	{
		return this.sectCode;
	}
	/**
	 * Setter method : setSectCode
	 * @param sectCode the sectCode to set
	 * 
	 * Date          : Apr 5, 2017 4:38:08 PM
	 */
	public void setSectCode(String sectCode)
	{
		this.sectCode = sectCode;
	}
	/**
	 * Getter Method	: getSectNo
	 * @return the sectNo
	 * 
	 * Date				: Apr 5, 2017
	 */
	public String getSectNo()
	{
		return this.sectNo;
	}
	/**
	 * Setter method : setSectNo
	 * @param sectNo the sectNo to set
	 * 
	 * Date          : Apr 5, 2017 4:38:08 PM
	 */
	public void setSectNo(String sectNo)
	{
		this.sectNo = sectNo;
	}
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Apr 5, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Apr 5, 2017 4:38:08 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DropCourseModel [studentNo=" + this.studentNo + ", courseNo="
				+ this.courseNo + ", sectCode=" + this.sectCode + ", sectNo="
				+ this.sectNo + ", userName=" + this.userName + "]";
	}
	
	
}
