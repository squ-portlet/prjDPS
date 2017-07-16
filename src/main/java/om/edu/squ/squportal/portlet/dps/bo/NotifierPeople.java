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
 * File Name			:	NotifierPeople.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jul 16, 2017  1:35:08 PM
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

import java.util.List;

import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;

/**
 * @author Bhabesh
 *
 */
public class NotifierPeople
{
	private	Student				student;
	private Approver			approver;
	private	Approver			approverHigher;
	private	List<RoleNameValue>	roles;
	
	
	/**
	 * Getter Method	: getStudent
	 * @return the student
	 * 
	 * Date				: Jul 16, 2017
	 */
	public Student getStudent()
	{
		return this.student;
	}
	/**
	 * Setter method : setStudent
	 * @param student the student to set
	 * 
	 * Date          : Jul 16, 2017 1:58:20 PM
	 */
	public void setStudent(Student student)
	{
		this.student = student;
	}
	/**
	 * Getter Method	: getApprover
	 * @return the approver
	 * 
	 * Date				: Jul 16, 2017
	 */
	public Approver getApprover()
	{
		return this.approver;
	}
	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Jul 16, 2017 1:58:20 PM
	 */
	public void setApprover(Approver approver)
	{
		this.approver = approver;
	}
	/**
	 * Getter Method	: getApproverHigher
	 * @return the approverHigher
	 * 
	 * Date				: Jul 16, 2017
	 */
	public Approver getApproverHigher()
	{
		return this.approverHigher;
	}
	/**
	 * Setter method : setApproverHigher
	 * @param approverHigher the approverHigher to set
	 * 
	 * Date          : Jul 16, 2017 1:58:20 PM
	 */
	public void setApproverHigher(Approver approverHigher)
	{
		this.approverHigher = approverHigher;
	}
	
	/**
	 * Getter Method	: getRoles
	 * @return the roles
	 * 
	 * Date				: Jul 16, 2017
	 */
	public List<RoleNameValue> getRoles()
	{
		return this.roles;
	}
	/**
	 * Setter method : setRoles
	 * @param roles the roles to set
	 * 
	 * Date          : Jul 16, 2017 3:29:32 PM
	 */
	public void setRoles(List<RoleNameValue> roles)
	{
		this.roles = roles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "NotifierPeople [student=" + this.student + ", approver="
				+ this.approver + ", approverHigher=" + this.approverHigher
				+ ", roles=" + this.roles + "]";
	}
	
	

}
