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
 * File Name			:	ApprovalTransactionDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Feb 28, 2017  9:34:19 AM
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

/**
 * @author Bhabesh
 *
 */
public class ApprovalTransactionDTO
{
	private	String	studentNo;
	private	String	stdStatCode;
	private	String	approvalCode;
	private	String	statusCode;
	private	String	appEmpNo;
	private	String	appEmpName;
	private	String  appDelegatedEmpNo;
	private	String	appDelegatedEmpUserName;
	private	String	appDelegateeEmpNo;
	private	String	appDelegateeEmpUserName;
	private	String	requestCode;
	private	String	comments;
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getApprovalCode
	 * @return the approvalCode
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getApprovalCode()
	{
		return this.approvalCode;
	}
	/**
	 * Setter method : setApprovalCode
	 * @param approvalCode the approvalCode to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setApprovalCode(String approvalCode)
	{
		this.approvalCode = approvalCode;
	}
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	/**
	 * Getter Method	: getAppEmpNo
	 * @return the appEmpNo
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getAppEmpNo()
	{
		return this.appEmpNo;
	}
	/**
	 * Setter method : setAppEmpNo
	 * @param appEmpNo the appEmpNo to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setAppEmpNo(String appEmpNo)
	{
		this.appEmpNo = appEmpNo;
	}
	/**
	 * Getter Method	: getAppEmpName
	 * @return the appEmpName
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getAppEmpName()
	{
		return this.appEmpName;
	}
	/**
	 * Setter method : setAppEmpName
	 * @param appEmpName the appEmpName to set
	 * 
	 * Date          : Feb 28, 2017 10:40:39 AM
	 */
	public void setAppEmpName(String appEmpName)
	{
		this.appEmpName = appEmpName;
	}
	
	/**
	 * Getter Method	: getAppDelegatedEmpNo
	 * @return the appDelegatedEmpNo
	 * 
	 * Date				: May 28, 2018
	 */
	public String getAppDelegatedEmpNo()
	{
		return this.appDelegatedEmpNo;
	}
	/**
	 * Setter method : setAppDelegatedEmpNo
	 * @param appDelegatedEmpNo the appDelegatedEmpNo to set
	 * 
	 * Date          : May 28, 2018 10:31:05 AM
	 */
	public void setAppDelegatedEmpNo(String appDelegatedEmpNo)
	{
		this.appDelegatedEmpNo = appDelegatedEmpNo;
	}
	/**
	 * Getter Method	: getAppDelegatedEmpUserName
	 * @return the appDelegatedEmpUserName
	 * 
	 * Date				: May 28, 2018
	 */
	public String getAppDelegatedEmpUserName()
	{
		return this.appDelegatedEmpUserName;
	}
	/**
	 * Setter method : setAppDelegatedEmpUserName
	 * @param appDelegatedEmpUserName the appDelegatedEmpUserName to set
	 * 
	 * Date          : May 28, 2018 10:31:05 AM
	 */
	public void setAppDelegatedEmpUserName(String appDelegatedEmpUserName)
	{
		this.appDelegatedEmpUserName = appDelegatedEmpUserName;
	}
	/**
	 * Getter Method	: getAppDelegateeEmpNo
	 * @return the appDelegateeEmpNo
	 * 
	 * Date				: May 28, 2018
	 */
	public String getAppDelegateeEmpNo()
	{
		return this.appDelegateeEmpNo;
	}
	/**
	 * Setter method : setAppDelegateeEmpNo
	 * @param appDelegateeEmpNo the appDelegateeEmpNo to set
	 * 
	 * Date          : May 28, 2018 10:31:05 AM
	 */
	public void setAppDelegateeEmpNo(String appDelegateeEmpNo)
	{
		this.appDelegateeEmpNo = appDelegateeEmpNo;
	}
	/**
	 * Getter Method	: getAppDelegateeEmpUserName
	 * @return the appDelegateeEmpUserName
	 * 
	 * Date				: May 28, 2018
	 */
	public String getAppDelegateeEmpUserName()
	{
		return this.appDelegateeEmpUserName;
	}
	/**
	 * Setter method : setAppDelegateeEmpUserName
	 * @param appDelegateeEmpUserName the appDelegateeEmpUserName to set
	 * 
	 * Date          : May 28, 2018 10:31:05 AM
	 */
	public void setAppDelegateeEmpUserName(String appDelegateeEmpUserName)
	{
		this.appDelegateeEmpUserName = appDelegateeEmpUserName;
	}
	/**
	 * Getter Method	: getComments
	 * @return the comments
	 * 
	 * Date				: Mar 6, 2017
	 */
	public String getComments()
	{
		return this.comments;
	}
	/**
	 * Setter method : setComments
	 * @param comments the comments to set
	 * 
	 * Date          : Mar 6, 2017 2:46:41 PM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	/**
	 * Getter Method	: getRequestCode
	 * @return the requestCode
	 * 
	 * Date				: May 9, 2017
	 */
	public String getRequestCode()
	{
		return this.requestCode;
	}
	/**
	 * Setter method : setRequestCode
	 * @param requestCode the requestCode to set
	 * 
	 * Date          : May 9, 2017 4:46:56 PM
	 */
	public void setRequestCode(String requestCode)
	{
		this.requestCode = requestCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ApprovalTransactionDTO [studentNo=" + this.studentNo
				+ ", stdStatCode=" + this.stdStatCode + ", approvalCode="
				+ this.approvalCode + ", statusCode=" + this.statusCode
				+ ", appEmpNo=" + this.appEmpNo + ", appEmpName="
				+ this.appEmpName + ", appDelegatedEmpNo="
				+ this.appDelegatedEmpNo + ", appDelegatedEmpUserName="
				+ this.appDelegatedEmpUserName + ", appDelegateeEmpNo="
				+ this.appDelegateeEmpNo + ", appDelegateeEmpUserName="
				+ this.appDelegateeEmpUserName + ", requestCode="
				+ this.requestCode + ", comments=" + this.comments + "]";
	}
	
	
	
	
}
