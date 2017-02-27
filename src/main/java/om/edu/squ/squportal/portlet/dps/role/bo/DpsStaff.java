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
 * File Name			:	DpsStaff.java
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
@XmlRootElement(name="dpsStaff")
public class DpsStaff
{
	private	String	access;
	private	String	sequence;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DpsStaff [access=" + this.access + ", sequence="
				+ this.sequence + "]";
	}
	
	
}
