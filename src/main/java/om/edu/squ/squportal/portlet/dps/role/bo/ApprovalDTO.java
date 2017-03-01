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
 * File Name			:	ApprovalDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.role.bo
 * Date of creation		:	Mar 1, 2017  5:01:17 PM
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
public class ApprovalDTO
{
	private	String	approvalCode;
	private	int		approvalSequenceNo;
	private	int		approvalMaxSequenceNo;
	/**
	 * Getter Method	: getApprovalCode
	 * @return the approvalCode
	 * 
	 * Date				: Mar 1, 2017
	 */
	public String getApprovalCode()
	{
		return this.approvalCode;
	}
	/**
	 * Setter method : setApprovalCode
	 * @param approvalCode the approvalCode to set
	 * 
	 * Date          : Mar 1, 2017 5:01:29 PM
	 */
	public void setApprovalCode(String approvalCode)
	{
		this.approvalCode = approvalCode;
	}
	/**
	 * Getter Method	: getApprovalSequenceNo
	 * @return the approvalSequenceNo
	 * 
	 * Date				: Mar 1, 2017
	 */
	public int getApprovalSequenceNo()
	{
		return this.approvalSequenceNo;
	}
	/**
	 * Setter method : setApprovalSequenceNo
	 * @param approvalSequenceNo the approvalSequenceNo to set
	 * 
	 * Date          : Mar 1, 2017 5:01:29 PM
	 */
	public void setApprovalSequenceNo(int approvalSequenceNo)
	{
		this.approvalSequenceNo = approvalSequenceNo;
	}
	/**
	 * Getter Method	: getApprovalMaxSequenceNo
	 * @return the approvalMaxSequenceNo
	 * 
	 * Date				: Mar 1, 2017
	 */
	public int getApprovalMaxSequenceNo()
	{
		return this.approvalMaxSequenceNo;
	}
	/**
	 * Setter method : setApprovalMaxSequenceNo
	 * @param approvalMaxSequenceNo the approvalMaxSequenceNo to set
	 * 
	 * Date          : Mar 1, 2017 5:01:29 PM
	 */
	public void setApprovalMaxSequenceNo(int approvalMaxSequenceNo)
	{
		this.approvalMaxSequenceNo = approvalMaxSequenceNo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ApprovalDTO [approvalCode=" + this.approvalCode
				+ ", approvalSequenceNo=" + this.approvalSequenceNo
				+ ", approvalMaxSequenceNo=" + this.approvalMaxSequenceNo + "]";
	}
	
	
}
