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
 * File Name			:	GradeIncompleteBo.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.incomplete.bo
 * Date of creation		:	Jan 3, 2018  2:58:34 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.grade.incomplete.bo;

import om.edu.squ.squportal.portlet.dps.bo.Course;

/**
 * @author Bhabesh
 *
 */
public class GradeIncompleteBo
{
	private	Course	course;

	/**
	 * Getter Method	: getCourse
	 * @return the course
	 * 
	 * Date				: Jan 3, 2018
	 */
	public Course getCourse()
	{
		return this.course;
	}

	/**
	 * Setter method : setCourse
	 * @param course the course to set
	 * 
	 * Date          : Jan 3, 2018 2:59:14 PM
	 */
	public void setCourse(Course course)
	{
		this.course = course;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeIncompleteBo [course=" + this.course + "]";
	}
	
	
}
