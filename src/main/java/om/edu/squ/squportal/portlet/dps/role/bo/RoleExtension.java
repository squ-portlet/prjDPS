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
 * File Name			:	RoleExtension.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Feb 8, 2017  10:24:19 AM
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
package om.edu.squ.squportal.portlet.dps.role.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bhabesh
 *
 */
@XmlRootElement(name="roleExtension")
public class RoleExtension
{
	private		Advisor			advisor;
	private		Supervisor		supervisor;
	private		HOD				hod;
	private		CollegeAsstDean	collegeAsstDean;
	private		CollegeDean		collegeDean;
	private		DpsDean			dpsDean;
	private		DpsStaff		dpsStaff;
	
	/**
	 * Getter Method	: getAdvisor
	 * @return the advisor
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="advisor")
	public Advisor getAdvisor()
	{
		return this.advisor;
	}
	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Feb 8, 2017 6:00:19 PM
	 */
	public void setAdvisor(Advisor advisor)
	{
		this.advisor = advisor;
	}
	/**
	 * Getter Method	: getSupervisor
	 * @return the supervisor
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="supervisor")
	public Supervisor getSupervisor()
	{
		return this.supervisor;
	}
	/**
	 * Setter method : setSupervisor
	 * @param supervisor the supervisor to set
	 * 
	 * Date          : Feb 8, 2017 4:29:49 PM
	 */
	public void setSupervisor(Supervisor supervisor)
	{
		this.supervisor = supervisor;
	}
	
	/**
	 * Getter Method	: getHod
	 * @return the hod
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="hod")
	public HOD getHod()
	{
		return this.hod;
	}
	/**
	 * Setter method : setHod
	 * @param hod the hod to set
	 * 
	 * Date          : Feb 8, 2017 6:03:29 PM
	 */
	public void setHod(HOD hod)
	{
		this.hod = hod;
	}
	/**
	 * Getter Method	: getCollegeAsstDean
	 * @return the collegeAsstDean
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="collegeAsstDean")
	public CollegeAsstDean getCollegeAsstDean()
	{
		return this.collegeAsstDean;
	}
	/**
	 * Setter method : setCollegeAsstDean
	 * @param collegeAsstDean the collegeAsstDean to set
	 * 
	 * Date          : Feb 8, 2017 6:11:37 PM
	 */
	public void setCollegeAsstDean(CollegeAsstDean collegeAsstDean)
	{
		this.collegeAsstDean = collegeAsstDean;
	}
	/**
	 * Getter Method	: getCollegeDean
	 * @return the collegeDean
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="collegeDean")
	public CollegeDean getCollegeDean()
	{
		return this.collegeDean;
	}
	/**
	 * Setter method : setCollegeDean
	 * @param collegeDean the collegeDean to set
	 * 
	 * Date          : Feb 8, 2017 4:29:49 PM
	 */
	public void setCollegeDean(CollegeDean collegeDean)
	{
		this.collegeDean = collegeDean;
	}
	
	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="dpsDean")
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}
	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Feb 8, 2017 6:18:48 PM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}
	/**
	 * Getter Method	: getDpsStaff
	 * @return the dpsStaff
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlElement(name="dpsStaff")
	public DpsStaff getDpsStaff()
	{
		return this.dpsStaff;
	}
	/**
	 * Setter method : setDpsStaff
	 * @param dpsStaff the dpsStaff to set
	 * 
	 * Date          : Feb 8, 2017 6:22:26 PM
	 */
	public void setDpsStaff(DpsStaff dpsStaff)
	{
		this.dpsStaff = dpsStaff;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RoleExtension [advisor=" + this.advisor + ", supervisor="
				+ this.supervisor + ", hod=" + this.hod + ", collegeAsstDean="
				+ this.collegeAsstDean + ", collegeDean=" + this.collegeDean
				+ ", dpsDean=" + this.dpsDean + ", dpsStaff=" + this.dpsStaff
				+ "]";
	}
	
	
}
