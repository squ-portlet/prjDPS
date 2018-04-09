/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	Employee.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	Jan 5, 2017  3:13:34 PM
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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;

/**
 * @author Bhabesh
 *
 */
public class Employee
{
	private String				empNumber;					/* -- Might be delegated - Check empNumberDelegatee to find who delegates --*/
	private String				userName;					/* -- Might be delegated - Check empNumberDelegatee to find who delegates --*/
	private	String				empNumberDelegated;			/* -- empNumber of person who is delegated, In case of delegation, empNumber == empNumberDelegated -- */
	private	String				empNumberDelegatee;			/* -- empNumber of person who delegates other -- */
	private	Date				delegatedFromDate;
	private	Date				delegatedToDate;
	private Branch				branch;
	private Department			department;
	private String				email;
	private	List<RoleNameValue>	myRoles;
	private	boolean				advisor;
	private	boolean				supervisor;
	private	boolean				hod;
	private	boolean				collegeAsstDeanP;
	private	boolean				collegeDean;
	private	boolean				dpsDean;
	private	boolean				dpsStaff;

	public void setEmployeeRole(Employee employee)
	{
		
		this.advisor			=	employee.isAdvisor();
		this.supervisor			=	employee.isSupervisor();
		this.hod				=	employee.isHod();
		this.collegeAsstDeanP	=	employee.isCollegeAsstDeanP();
		this.collegeDean		=	employee.isCollegeDean();
		this.dpsDean			=	employee.isDpsDean();
		this.dpsStaff			=	employee.isDpsStaff();
		
	}
	
	/**
	 * Getter Method : getEmpNumber
	 * 
	 * @return the empNumber
	 * 
	 *         Date : Jan 5, 2017
	 */
	public String getEmpNumber()
	{
		return this.empNumber;
	}
	
	/**
	 * Setter method : setEmpNumber
	 * 
	 * @param empNumber
	 *            the empNumber to set
	 * 
	 *            Date : Jan 5, 2017 5:02:01 PM
	 */
	public void setEmpNumber(String empNumber)
	{
		this.empNumber = empNumber;
	}
	
	/**
	 * Getter Method : getUserName
	 * 
	 * @return the userName
	 * 
	 *         Date : Jan 8, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	
	/**
	 * Setter method : setUserName
	 * 
	 * @param userName
	 *            the userName to set
	 * 
	 *            Date : Jan 8, 2017 4:42:41 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * Getter Method	: getEmpNumberDelegated
	 * @return the empNumberDelegated
	 * 
	 * Date				: Apr 9, 2018
	 */
	public String getEmpNumberDelegated()
	{
		return this.empNumberDelegated;
	}

	/**
	 * Setter method : setEmpNumberDelegated
	 * @param empNumberDelegated the empNumberDelegated to set
	 * 
	 * Date          : Apr 9, 2018 7:35:16 PM
	 */
	public void setEmpNumberDelegated(String empNumberDelegated)
	{
		this.empNumberDelegated = empNumberDelegated;
	}

	/**
	 * Getter Method	: getEmpNumberDelegatee
	 * @return the empNumberDelegatee
	 * 
	 * Date				: Apr 9, 2018
	 */
	public String getEmpNumberDelegatee()
	{
		return this.empNumberDelegatee;
	}

	/**
	 * Setter method : setEmpNumberDelegatee
	 * @param empNumberDelegatee the empNumberDelegatee to set
	 * 
	 * Date          : Apr 9, 2018 7:35:16 PM
	 */
	public void setEmpNumberDelegatee(String empNumberDelegatee)
	{
		this.empNumberDelegatee = empNumberDelegatee;
	}

	/**
	 * Getter Method	: getDelegatedFromDate
	 * @return the delegatedFromDate
	 * 
	 * Date				: Apr 9, 2018
	 */
	public Date getDelegatedFromDate()
	{
		return this.delegatedFromDate;
	}

	/**
	 * Setter method : setDelegatedFromDate
	 * @param delegatedFromDate the delegatedFromDate to set
	 * 
	 * Date          : Apr 9, 2018 7:35:16 PM
	 */
	public void setDelegatedFromDate(Date delegatedFromDate)
	{
		this.delegatedFromDate = delegatedFromDate;
	}

	/**
	 * Getter Method	: getDelegatedToDate
	 * @return the delegatedToDate
	 * 
	 * Date				: Apr 9, 2018
	 */
	public Date getDelegatedToDate()
	{
		return this.delegatedToDate;
	}

	/**
	 * Setter method : setDelegatedToDate
	 * @param delegatedToDate the delegatedToDate to set
	 * 
	 * Date          : Apr 9, 2018 7:35:16 PM
	 */
	public void setDelegatedToDate(Date delegatedToDate)
	{
		this.delegatedToDate = delegatedToDate;
	}

	/**
	 * Getter Method : getBranch
	 * 
	 * @return the branch
	 * 
	 *         Date : Jan 5, 2017
	 */
	public Branch getBranch()
	{
		return this.branch;
	}
	
	/**
	 * Setter method : setBranch
	 * 
	 * @param branch
	 *            the branch to set
	 * 
	 *            Date : Jan 5, 2017 5:02:01 PM
	 */
	public void setBranch(Branch branch)
	{
		this.branch = branch;
	}
	
	/**
	 * Getter Method : getDepartment
	 * 
	 * @return the department
	 * 
	 *         Date : Jan 5, 2017
	 */
	public Department getDepartment()
	{
		return this.department;
	}
	
	/**
	 * Setter method : setDepartment
	 * 
	 * @param department
	 *            the department to set
	 * 
	 *            Date : Jan 5, 2017 5:02:01 PM
	 */
	public void setDepartment(Department department)
	{
		this.department = department;
	}
	
	/**
	 * Getter Method	: getEmail
	 * @return the email
	 * 
	 * Date				: Feb 10, 2017
	 */
	public String getEmail()
	{
		return this.email;
	}

	/**
	 * Setter method : setEmail
	 * @param email the email to set
	 * 
	 * Date          : Feb 10, 2017 11:39:13 AM
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
		
	/**
	 * Getter Method	: getMyRoles
	 * @return the myRoles
	 * 
	 * Date				: Feb 13, 2017
	 */
	public List<RoleNameValue> getMyRoles()
	{
		return this.myRoles;
	}

	/**
	 * Setter method : setMyRoles
	 * @param myRoles the myRoles to set
	 * 
	 * Date          : Feb 13, 2017 9:38:18 PM
	 */
	public void setMyRoles(List<RoleNameValue> myRoles)
	{
		this.myRoles = myRoles;
	}

	/**
	 * Getter Method	: isAdvisor
	 * @return the advisor
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isAdvisor()
	{
		return this.advisor;
	}

	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setAdvisor(boolean advisor)
	{
		this.advisor = advisor;
	}

	/**
	 * Getter Method	: isSupervisor
	 * @return the supervisor
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isSupervisor()
	{
		return this.supervisor;
	}

	/**
	 * Setter method : setSupervisor
	 * @param supervisor the supervisor to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setSupervisor(boolean supervisor)
	{
		this.supervisor = supervisor;
	}

	/**
	 * Getter Method	: isHod
	 * @return the hod
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isHod()
	{
		return this.hod;
	}

	/**
	 * Setter method : setHod
	 * @param hod the hod to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setHod(boolean hod)
	{
		this.hod = hod;
	}

	/**
	 * Getter Method	: isCollegeAsstDeanP
	 * @return the collegeAsstDeanP
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isCollegeAsstDeanP()
	{
		return this.collegeAsstDeanP;
	}

	/**
	 * Setter method : setCollegeAsstDeanP
	 * @param collegeAsstDeanP the collegeAsstDeanP to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setCollegeAsstDeanP(boolean collegeAsstDeanP)
	{
		this.collegeAsstDeanP = collegeAsstDeanP;
	}

	/**
	 * Getter Method	: isCollegeDean
	 * @return the collegeDean
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isCollegeDean()
	{
		return this.collegeDean;
	}

	/**
	 * Setter method : setCollegeDean
	 * @param collegeDean the collegeDean to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setCollegeDean(boolean collegeDean)
	{
		this.collegeDean = collegeDean;
	}

	/**
	 * Getter Method	: isDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isDpsDean()
	{
		return this.dpsDean;
	}

	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setDpsDean(boolean dpsDean)
	{
		this.dpsDean = dpsDean;
	}

	/**
	 * Getter Method	: isDpsStaff
	 * @return the dpsStaff
	 * 
	 * Date				: Feb 13, 2017
	 */
	public boolean isDpsStaff()
	{
		return this.dpsStaff;
	}

	/**
	 * Setter method : setDpsStaff
	 * @param dpsStaff the dpsStaff to set
	 * 
	 * Date          : Feb 13, 2017 3:36:46 PM
	 */
	public void setDpsStaff(boolean dpsStaff)
	{
		this.dpsStaff = dpsStaff;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Employee [empNumber=" + this.empNumber + ", userName="
				+ this.userName + ", empNumberDelegated="
				+ this.empNumberDelegated + ", empNumberDelegatee="
				+ this.empNumberDelegatee + ", delegatedFromDate="
				+ this.delegatedFromDate + ", delegatedToDate="
				+ this.delegatedToDate + ", branch=" + this.branch
				+ ", department=" + this.department + ", email=" + this.email
				+ ", myRoles=" + this.myRoles + ", advisor=" + this.advisor
				+ ", supervisor=" + this.supervisor + ", hod=" + this.hod
				+ ", collegeAsstDeanP=" + this.collegeAsstDeanP
				+ ", collegeDean=" + this.collegeDean + ", dpsDean="
				+ this.dpsDean + ", dpsStaff=" + this.dpsStaff + "]";
	}
	
}
