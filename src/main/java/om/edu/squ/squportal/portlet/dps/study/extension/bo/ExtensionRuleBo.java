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
 * File Name			:	ExtensionRuleBo.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.bo
 * Date of creation		:	Mar 13, 2017  8:45:40 PM
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
package om.edu.squ.squportal.portlet.dps.study.extension.bo;

/**
 * @author Bhabesh
 *
 */
public class ExtensionRuleBo
{
	private	boolean isLastSemester;

	/**
	 * Getter Method	: isLastSemester
	 * @return the isLastSemester
	 * 
	 * Date				: Mar 13, 2017
	 */
	public boolean isLastSemester()
	{
		return this.isLastSemester;
	}

	/**
	 * Setter method : setLastSemester
	 * @param isLastSemester the isLastSemester to set
	 * 
	 * Date          : Mar 13, 2017 8:46:22 PM
	 */
	public void setLastSemester(boolean isLastSemester)
	{
		this.isLastSemester = isLastSemester;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ExtensionRuleBo [isLastSemester=" + this.isLastSemester + "]";
	}
	
	
}
