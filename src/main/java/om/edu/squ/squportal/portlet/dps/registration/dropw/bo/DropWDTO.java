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
 * File Name			:	DropWDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.dropw.bo
 * Date of creation		:	Mar 29, 2017  6:59:43 PM
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
package om.edu.squ.squportal.portlet.dps.registration.dropw.bo;

import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;

/**
 * @author Bhabesh
 *
 */
public class DropWDTO extends Course implements Cloneable
{
	private	String	studentNo;
	private	String	studentStatCode;
	private	String	userName;
	private	String	empNumber;
	private	String	firstWithDrawDate;
	private	String	secondWithDrawDate;
	private	float	tutionFees;
	private	String	statusCodeName;
	private	String	statusDesc;
	private	Advisor	advisor;
	private	Student	student;
	private	boolean	approver;
	private	boolean	statusPending;
	private	boolean	statusReject;
	private	String	statusApprove;
	private	String	remarks;
	private	String	roleName;
	
	
	public DropWDTO()
	{
		super();
	}
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}
	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Apr 10, 2017 6:59:54 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * Getter Method	: getEmpNumber
	 * @return the empNumber
	 * 
	 * Date				: Aug 1, 2017
	 */
	public String getEmpNumber()
	{
		return this.empNumber;
	}
	/**
	 * Setter method : setEmpNumber
	 * @param empNumber the empNumber to set
	 * 
	 * Date          : Aug 1, 2017 4:17:14 PM
	 */
	public void setEmpNumber(String empNumber)
	{
		this.empNumber = empNumber;
	}
	/**
	 * Getter Method	: getFirstWithDrawDate
	 * @return the firstWithDrawDate
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getFirstWithDrawDate()
	{
		return this.firstWithDrawDate;
	}
	/**
	 * Setter method : setFirstWithDrawDate
	 * @param firstWithDrawDate the firstWithDrawDate to set
	 * 
	 * Date          : Mar 29, 2017 7:02:20 PM
	 */
	public void setFirstWithDrawDate(String firstWithDrawDate)
	{
		this.firstWithDrawDate = firstWithDrawDate;
	}
	/**
	 * Getter Method	: getSecondWithDrawDate
	 * @return the secondWithDrawDate
	 * 
	 * Date				: Mar 29, 2017
	 */
	public String getSecondWithDrawDate()
	{
		return this.secondWithDrawDate;
	}
	/**
	 * Setter method : setSecondWithDrawDate
	 * @param secondWithDrawDate the secondWithDrawDate to set
	 * 
	 * Date          : Mar 29, 2017 7:02:20 PM
	 */
	public void setSecondWithDrawDate(String secondWithDrawDate)
	{
		this.secondWithDrawDate = secondWithDrawDate;
	}
	
	/**
	 * Getter Method	: getTutionFees
	 * @return the tutionFees
	 * 
	 * Date				: Mar 30, 2017
	 */
	public float getTutionFees()
	{
		return this.tutionFees;
	}
	/**
	 * Setter method : setTutionFees
	 * @param tutionFees the tutionFees to set
	 * 
	 * Date          : Mar 30, 2017 8:20:02 AM
	 */
	public void setTutionFees(float tutionFees)
	{
		this.tutionFees = tutionFees;
	}
	
	/**
	 * Getter Method	: getStatusCodeName
	 * @return the statusCodeName
	 * 
	 * Date				: May 10, 2017
	 */
	public String getStatusCodeName()
	{
		return this.statusCodeName;
	}
	/**
	 * Setter method : setStatusCodeName
	 * @param statusCodeName the statusCodeName to set
	 * 
	 * Date          : May 10, 2017 3:52:21 PM
	 */
	public void setStatusCodeName(String statusCodeName)
	{
		this.statusCodeName = statusCodeName;
	}
	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Apr 11, 2017
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}
	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Apr 11, 2017 4:01:19 PM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
	
	/**
	 * Getter Method	: getAdvisor
	 * @return the advisor
	 * 
	 * Date				: Apr 17, 2017
	 */
	public Advisor getAdvisor()
	{
		return this.advisor;
	}
	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Apr 17, 2017 8:16:46 PM
	 */
	public void setAdvisor(Advisor advisor)
	{
		this.advisor = advisor;
	}
	/**
	 * Getter Method	: getStudent
	 * @return the student
	 * 
	 * Date				: Apr 17, 2017
	 */
	public Student getStudent()
	{
		return this.student;
	}
	/**
	 * Setter method : setStudent
	 * @param student the student to set
	 * 
	 * Date          : Apr 17, 2017 8:16:46 PM
	 */
	public void setStudent(Student student)
	{
		this.student = student;
	}
	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Apr 17, 2017
	 */
	public boolean isApprover()
	{
		return this.approver;
	}
	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Apr 17, 2017 7:50:55 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}
	
	/**
	 * Getter Method	: isStatusPending
	 * @return the statusPending
	 * 
	 * Date				: Apr 21, 2017
	 */
	public boolean isStatusPending()
	{
		return this.statusPending;
	}
	/**
	 * Setter method : setStatusPending
	 * @param statusPending the statusPending to set
	 * 
	 * Date          : Apr 21, 2017 11:35:18 PM
	 */
	public void setStatusPending(boolean statusPending)
	{
		this.statusPending = statusPending;
	}
	
	/**
	 * Getter Method	: isStatusReject
	 * @return the statusReject
	 * 
	 * Date				: May 10, 2017
	 */
	public boolean isStatusReject()
	{
		return this.statusReject;
	}
	/**
	 * Setter method : setStatusReject
	 * @param statusReject the statusReject to set
	 * 
	 * Date          : May 10, 2017 4:20:37 PM
	 */
	public void setStatusReject(boolean statusReject)
	{
		this.statusReject = statusReject;
	}
	/**
	 * Getter Method	: getStatusApprove
	 * @return the statusApprove
	 * 
	 * Date				: Apr 25, 2017
	 */
	public String getStatusApprove()
	{
		return this.statusApprove;
	}
	/**
	 * Setter method : setStatusApprove
	 * @param statusApprove the statusApprove to set
	 * 
	 * Date          : Apr 25, 2017 5:54:30 PM
	 */
	public void setStatusApprove(String statusApprove)
	{
		this.statusApprove = statusApprove;
	}
	
	
	/**
	 * Getter Method	: getRemarks
	 * @return the remarks
	 * 
	 * Date				: May 3, 2017
	 */
	public String getRemarks()
	{
		return this.remarks;
	}
	/**
	 * Setter method : setRemarks
	 * @param remarks the remarks to set
	 * 
	 * Date          : May 3, 2017 3:01:20 PM
	 */
	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	
	/**
	 * Getter Method	: getRoleName
	 * @return the roleName
	 * 
	 * Date				: Aug 1, 2017
	 */
	public String getRoleName()
	{
		return this.roleName;
	}
	/**
	 * Setter method : setRoleName
	 * @param roleName the roleName to set
	 * 
	 * Date          : Aug 1, 2017 5:17:43 PM
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DropWDTO [studentNo=" + this.studentNo + ", studentStatCode="
				+ this.studentStatCode + ", userName=" + this.userName
				+ ", empNumber=" + this.empNumber + ", firstWithDrawDate="
				+ this.firstWithDrawDate + ", secondWithDrawDate="
				+ this.secondWithDrawDate + ", tutionFees=" + this.tutionFees
				+ ", statusCodeName=" + this.statusCodeName + ", statusDesc="
				+ this.statusDesc + ", advisor=" + this.advisor + ", student="
				+ this.student + ", approver=" + this.approver
				+ ", statusPending=" + this.statusPending + ", statusReject="
				+ this.statusReject + ", statusApprove=" + this.statusApprove
				+ ", remarks=" + this.remarks + ", roleName=" + this.roleName
				+ "]";
	}
	
	
}
