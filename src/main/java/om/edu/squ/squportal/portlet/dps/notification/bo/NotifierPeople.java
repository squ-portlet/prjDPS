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
package om.edu.squ.squportal.portlet.dps.notification.bo;

import java.util.List;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import om.edu.squ.squportal.notification.service.core.NotificationServiceCore;
import om.edu.squ.squportal.portlet.dps.bo.Approver;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.role.bo.RoleNameValue;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

/**
 * @author Bhabesh
 *
 */
public class NotifierPeople
{
	private	Student					student;
	private Approver				approver;
	private	Approver				approverHigher;
	private	List<RoleNameValue>		roles;
	private	String					statusDescEng;
	private	String					statusDescAr;
	private	String					formNameEng;
	private	String					formNameAr;
	private	String					serviceUrl;
	private	boolean					pending;
	private	boolean					progress;
	private	boolean					reject;
	private	boolean					accept;

	
	
	
	
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
	
	
	
	/**
	 * Getter Method	: getStatusDescEng
	 * @return the statusDescEng
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusDescEng()
	{
		return this.statusDescEng;
	}
	/**
	 * Setter method : setStatusDescEng
	 * @param statusDescEng the statusDescEng to set
	 * 
	 * Date          : Jul 18, 2017 3:58:14 PM
	 */
	public void setStatusDescEng(String statusDescEng)
	{
		this.statusDescEng = statusDescEng;
	}
	/**
	 * Getter Method	: getStatusDescAr
	 * @return the statusDescAr
	 * 
	 * Date				: Jul 18, 2017
	 */
	public String getStatusDescAr()
	{
		return this.statusDescAr;
	}
	/**
	 * Setter method : setStatusDescAr
	 * @param statusDescAr the statusDescAr to set
	 * 
	 * Date          : Jul 18, 2017 3:58:14 PM
	 */
	public void setStatusDescAr(String statusDescAr)
	{
		this.statusDescAr = statusDescAr;
	}
	
	/**
	 * Getter Method	: getFormNameEng
	 * @return the formNameEng
	 * 
	 * Date				: Jul 27, 2017
	 */
	public String getFormNameEng()
	{
		return this.formNameEng;
	}
	/**
	 * Setter method : setFormNameEng
	 * @param formNameEng the formNameEng to set
	 * 
	 * Date          : Jul 27, 2017 3:00:12 PM
	 */
	public void setFormNameEng(String formNameEng)
	{
		this.formNameEng = formNameEng;
	}
	/**
	 * Getter Method	: getFormNameAr
	 * @return the formNameAr
	 * 
	 * Date				: Jul 27, 2017
	 */
	public String getFormNameAr()
	{
		return this.formNameAr;
	}
	/**
	 * Setter method : setFormNameAr
	 * @param formNameAr the formNameAr to set
	 * 
	 * Date          : Jul 27, 2017 3:00:12 PM
	 */
	public void setFormNameAr(String formNameAr)
	{
		this.formNameAr = formNameAr;
	}
	
	
	/**
	 * Getter Method	: getServiceUrl
	 * @return the serviceUrl
	 * 
	 * Date				: Jul 27, 2017
	 */
	public String getServiceUrl()
	{
		return this.serviceUrl;
	}
	/**
	 * Setter method : setServiceUrl
	 * @param serviceUrl the serviceUrl to set
	 * 
	 * Date          : Jul 27, 2017 3:56:40 PM
	 */
	public void setServiceUrl(String serviceUrl)
	{
		this.serviceUrl = serviceUrl;
	}
	
	/**
	 * Getter Method	: isPending
	 * @return the pending
	 * 
	 * Date				: Jul 27, 2017
	 */
	public boolean isPending()
	{
		return this.pending;
	}
	/**
	 * Setter method : setPending
	 * @param pending the pending to set
	 * 
	 * Date          : Jul 27, 2017 5:27:19 PM
	 */
	public void setPending(boolean pending)
	{
		this.pending = pending;
	}
	/**
	 * Getter Method	: isProgress
	 * @return the progress
	 * 
	 * Date				: Jul 27, 2017
	 */
	public boolean isProgress()
	{
		return this.progress;
	}
	/**
	 * Setter method : setProgress
	 * @param progress the progress to set
	 * 
	 * Date          : Jul 27, 2017 5:27:19 PM
	 */
	public void setProgress(boolean progress)
	{
		this.progress = progress;
	}
	/**
	 * Getter Method	: isReject
	 * @return the reject
	 * 
	 * Date				: Jul 27, 2017
	 */
	public boolean isReject()
	{
		return this.reject;
	}
	/**
	 * Setter method : setReject
	 * @param reject the reject to set
	 * 
	 * Date          : Jul 27, 2017 5:27:19 PM
	 */
	public void setReject(boolean reject)
	{
		this.reject = reject;
	}
	
	/**
	 * Getter Method	: isAccept
	 * @return the accept
	 * 
	 * Date				: Jul 28, 2017
	 */
	public boolean isAccept()
	{
		return this.accept;
	}
	/**
	 * Setter method : setAccept
	 * @param accept the accept to set
	 * 
	 * Date          : Jul 28, 2017 12:13:42 AM
	 */
	public void setAccept(boolean accept)
	{
		this.accept = accept;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "NotifierPeople [student=" + this.student + ", approver="
				+ this.approver + ", approverHigher=" + this.approverHigher
				+ ", roles=" + this.roles + ", statusDescEng="
				+ this.statusDescEng + ", statusDescAr=" + this.statusDescAr
				+ ", formNameEng=" + this.formNameEng + ", formNameAr="
				+ this.formNameAr + ", serviceUrl=" + this.serviceUrl
				+ ", pending=" + this.pending + ", progress=" + this.progress
				+ ", reject=" + this.reject + ", accept=" + this.accept + "]";
	}
	
	

}
