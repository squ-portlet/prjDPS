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
 * File Name			:	DpsDean.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Feb 8, 2017  10:12:58 AM
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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bhabesh
 *
 */
@XmlRootElement(name="dpsDean")
public class DpsDean
{
	private	String	access;
	private	String	sequence;
	private	String	rolecode;
	private	String	approvalcode;
	/**
	 * Getter Method	: getAccess
	 * @return the access
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlAttribute(name="access")
	public String getAccess()
	{
		return this.access;
	}
	/**
	 * Setter method : setAccess
	 * @param access the access to set
	 * 
	 * Date          : Feb 8, 2017 10:15:53 AM
	 */
	public void setAccess(String access)
	{
		this.access = access;
	}
	/**
	 * Getter Method	: getSequence
	 * @return the sequence
	 * 
	 * Date				: Feb 8, 2017
	 */
	@XmlAttribute(name="sequence")
	public String getSequence()
	{
		return this.sequence;
	}
	/**
	 * Setter method : setSequence
	 * @param sequence the sequence to set
	 * 
	 * Date          : Feb 8, 2017 10:15:53 AM
	 */
	public void setSequence(String sequence)
	{
		this.sequence = sequence;
	}
	
	/**
	 * Getter Method	: getRolecode
	 * @return the rolecode
	 * 
	 * Date				: Feb 10, 2017
	 */
	@XmlAttribute(name="rolecode")
	public String getRolecode()
	{
		return this.rolecode;
	}
	/**
	 * Setter method : setRolecode
	 * @param rolecode the rolecode to set
	 * 
	 * Date          : Feb 10, 2017 9:28:35 PM
	 */
	public void setRolecode(String rolecode)
	{
		this.rolecode = rolecode;
	}
	
	/**
	 * Getter Method	: getApprovalcode
	 * @return the approvalcode
	 * 
	 * Date				: Feb 10, 2017
	 */
	public String getApprovalcode()
	{
		return this.approvalcode;
	}
	/**
	 * Setter method : setApprovalcode
	 * @param approvalcode the approvalcode to set
	 * 
	 * Date          : Feb 10, 2017 10:15:29 PM
	 */
	public void setApprovalcode(String approvalcode)
	{
		this.approvalcode = approvalcode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DpsDean [access=" + this.access + ", sequence=" + this.sequence
				+ ", rolecode=" + this.rolecode + ", approvalcode="
				+ this.approvalcode + "]";
	}


	
}
