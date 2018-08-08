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
 * File Name			:	UniversityWithdrawDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo
 * Date of creation		:	Feb 12, 2018  10:38:31 AM
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
package om.edu.squ.squportal.portlet.dps.registration.university.withdraw.bo;

import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;

/**
 * @author Bhabesh
 *
 */
public class UniversityWithdrawDTO
{
	private	String		recordSequence;
	private	String		studentId;
	private	String		studentNo;
	private	String		studentStatCode;
	private	String		studentName;
	private	String		cohort;
	private	String		firstStatusCode;
	private	String		toCCYearCode;
	private	String		toSemCode;
	private	String		toSemName;
	private	String		collegeName;
	private	String		degreeName;
	private	String		statusCode;
	private	String		statusCodeName;
	private	String		statusDescription;
	private	String		reasonCodeStd;
	private	String		reasonStd;
	private	String		reason;
	private	String		reasonCode;
	private	String		userName;
	private	String		applyDate;
	private	String		activityDate;
	private	Advisor		advisor;	
	private	Supervisor	supervisor;
	private	CollegeDean	collegeDean;
	private	DpsDean		dpsDean;
	private	String		comments;
	private	boolean		statusReject;
	private	boolean		approver;
	private	boolean		approverApplicable;
	
	
	/**
	 * Getter Method	: getRecordSequenec
	 * @return the recordSequence
	 * 
	 * Date				: Feb 14, 2018
	 */
	public String getRecordSequence()
	{
		return this.recordSequence;
	}
	/**
	 * Setter method : setRecordSequenec
	 * @param recordSequence the recordSequence to set
	 * 
	 * Date          : Feb 14, 2018 10:02:25 AM
	 */
	public void setRecordSequence(String recordSequenec)
	{
		this.recordSequence = recordSequenec;
	}
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Mar 26, 2018 12:33:18 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}
	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}
	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getStudentName()
	{
		return this.studentName;
	}
	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Mar 26, 2018 12:35:32 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	/**
	 * Getter Method	: getCohort
	 * @return the cohort
	 * 
	 * Date				: Mar 27, 2018
	 */
	public String getCohort()
	{
		return this.cohort;
	}
	/**
	 * Setter method : setCohort
	 * @param cohort the cohort to set
	 * 
	 * Date          : Mar 27, 2018 8:39:32 AM
	 */
	public void setCohort(String cohort)
	{
		this.cohort = cohort;
	}
	/**
	 * Getter Method	: getFirstStatusCode
	 * @return the firstStatusCode
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getFirstStatusCode()
	{
		return this.firstStatusCode;
	}
	/**
	 * Setter method : setFirstStatusCode
	 * @param firstStatusCode the firstStatusCode to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setFirstStatusCode(String firstStatusCode)
	{
		this.firstStatusCode = firstStatusCode;
	}
	/**
	 * Getter Method	: getToCCYearCode
	 * @return the toCCYearCode
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getToCCYearCode()
	{
		return this.toCCYearCode;
	}
	/**
	 * Setter method : setToCCYearCode
	 * @param toCCYearCode the toCCYearCode to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setToCCYearCode(String toCCYearCode)
	{
		this.toCCYearCode = toCCYearCode;
	}
	/**
	 * Getter Method	: getToSemCode
	 * @return the toSemCode
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getToSemCode()
	{
		return this.toSemCode;
	}
	/**
	 * Setter method : setToSemCode
	 * @param toSemCode the toSemCode to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setToSemCode(String toSemCode)
	{
		this.toSemCode = toSemCode;
	}
	
	/**
	 * Getter Method	: getToSemName
	 * @return the toSemName
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getToSemName()
	{
		return this.toSemName;
	}
	/**
	 * Setter method : setToSemName
	 * @param toSemName the toSemName to set
	 * 
	 * Date          : Mar 6, 2018 10:07:50 AM
	 */
	public void setToSemName(String toSemName)
	{
		this.toSemName = toSemName;
	}
	/**
	 * Getter Method	: getCollegeName
	 * @return the collegeName
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getCollegeName()
	{
		return this.collegeName;
	}
	/**
	 * Setter method : setCollegeName
	 * @param collegeName the collegeName to set
	 * 
	 * Date          : Mar 26, 2018 12:39:21 PM
	 */
	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}
	/**
	 * Getter Method	: getDegreeName
	 * @return the degreeName
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getDegreeName()
	{
		return this.degreeName;
	}
	/**
	 * Setter method : setDegreeName
	 * @param degreeName the degreeName to set
	 * 
	 * Date          : Mar 26, 2018 12:39:21 PM
	 */
	public void setDegreeName(String degreeName)
	{
		this.degreeName = degreeName;
	}
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Feb 12, 2018
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Feb 12, 2018 12:15:44 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	
	/**
	 * Getter Method	: getStatusCodeName
	 * @return the statusCodeName
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getStatusCodeName()
	{
		return this.statusCodeName;
	}
	/**
	 * Setter method : setStatusCodeName
	 * @param statusCodeName the statusCodeName to set
	 * 
	 * Date          : Mar 6, 2018 10:11:05 AM
	 */
	public void setStatusCodeName(String statusCodeName)
	{
		this.statusCodeName = statusCodeName;
	}
	/**
	 * Getter Method	: getStatusDescription
	 * @return the statusDescription
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getStatusDescription()
	{
		return this.statusDescription;
	}
	/**
	 * Setter method : setStatusDescription
	 * @param statusDescription the statusDescription to set
	 * 
	 * Date          : Mar 6, 2018 10:11:49 AM
	 */
	public void setStatusDescription(String statusDescription)
	{
		this.statusDescription = statusDescription;
	}
	/**
	 * Getter Method	: getReasonCodeStd
	 * @return the reasonCodeStd
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getReasonCodeStd()
	{
		return this.reasonCodeStd;
	}
	/**
	 * Setter method : setReasonCodeStd
	 * @param reasonCodeStd the reasonCodeStd to set
	 * 
	 * Date          : Mar 26, 2018 12:44:51 PM
	 */
	public void setReasonCodeStd(String reasonCodeStd)
	{
		this.reasonCodeStd = reasonCodeStd;
	}
	/**
	 * Getter Method	: getReasonStd
	 * @return the reasonStd
	 * 
	 * Date				: Mar 26, 2018
	 */
	public String getReasonStd()
	{
		return this.reasonStd;
	}
	/**
	 * Setter method : setReasonStd
	 * @param reasonStd the reasonStd to set
	 * 
	 * Date          : Mar 26, 2018 12:44:51 PM
	 */
	public void setReasonStd(String reasonStd)
	{
		this.reasonStd = reasonStd;
	}
	/**
	 * Getter Method	: getReason
	 * @return the reason
	 * 
	 * Date				: Feb 14, 2018
	 */
	public String getReason()
	{
		return this.reason;
	}
	/**
	 * Setter method : setReason
	 * @param reason the reason to set
	 * 
	 * Date          : Feb 14, 2018 2:31:21 PM
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Feb 18, 2018
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}
	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Feb 18, 2018 3:03:11 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Feb 18, 2018
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Feb 18, 2018 3:09:12 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * Getter Method	: getApplyDate
	 * @return the applyDate
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getApplyDate()
	{
		return this.applyDate;
	}
	/**
	 * Setter method : setApplyDate
	 * @param applyDate the applyDate to set
	 * 
	 * Date          : Mar 6, 2018 11:19:30 AM
	 */
	public void setApplyDate(String applyDate)
	{
		this.applyDate = applyDate;
	}
	/**
	 * Getter Method	: getActivityDate
	 * @return the activityDate
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getActivityDate()
	{
		return this.activityDate;
	}
	/**
	 * Setter method : setActivityDate
	 * @param activityDate the activityDate to set
	 * 
	 * Date          : Mar 6, 2018 11:19:30 AM
	 */
	public void setActivityDate(String activityDate)
	{
		this.activityDate = activityDate;
	}
	/**
	 * Getter Method	: getAdvisor
	 * @return the advisor
	 * 
	 * Date				: Mar 6, 2018
	 */
	public Advisor getAdvisor()
	{
		return this.advisor;
	}
	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Mar 6, 2018 10:18:48 AM
	 */
	public void setAdvisor(Advisor advisor)
	{
		this.advisor = advisor;
	}
	/**
	 * Getter Method	: getSupervisor
	 * @return the supervisor
	 * 
	 * Date				: Mar 6, 2018
	 */
	public Supervisor getSupervisor()
	{
		return this.supervisor;
	}
	/**
	 * Setter method : setSupervisor
	 * @param supervisor the supervisor to set
	 * 
	 * Date          : Mar 6, 2018 10:18:48 AM
	 */
	public void setSupervisor(Supervisor supervisor)
	{
		this.supervisor = supervisor;
	}
	/**
	 * Getter Method	: getCollegeDean
	 * @return the collegeDean
	 * 
	 * Date				: Mar 6, 2018
	 */
	public CollegeDean getCollegeDean()
	{
		return this.collegeDean;
	}
	/**
	 * Setter method : setCollegeDean
	 * @param collegeDean the collegeDean to set
	 * 
	 * Date          : Mar 6, 2018 10:18:48 AM
	 */
	public void setCollegeDean(CollegeDean collegeDean)
	{
		this.collegeDean = collegeDean;
	}
	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Mar 6, 2018
	 */
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}
	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Mar 6, 2018 10:18:48 AM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}
	/**
	 * Getter Method	: getComments
	 * @return the comments
	 * 
	 * Date				: Mar 6, 2018
	 */
	public String getComments()
	{
		return this.comments;
	}
	/**
	 * Setter method : setComments
	 * @param comments the comments to set
	 * 
	 * Date          : Mar 6, 2018 10:21:28 AM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	/**
	 * Getter Method	: isStatusReject
	 * @return the statusReject
	 * 
	 * Date				: Mar 7, 2018
	 */
	public boolean isStatusReject()
	{
		return this.statusReject;
	}
	/**
	 * Setter method : setStatusReject
	 * @param statusReject the statusReject to set
	 * 
	 * Date          : Mar 7, 2018 3:32:04 PM
	 */
	public void setStatusReject(boolean statusReject)
	{
		this.statusReject = statusReject;
	}
	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Mar 26, 2018
	 */
	public boolean isApprover()
	{
		return this.approver;
	}
	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Mar 26, 2018 12:58:00 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}
	/**
	 * Getter Method	: isApproverApplicable
	 * @return the approverApplicable
	 * 
	 * Date				: Mar 26, 2018
	 */
	public boolean isApproverApplicable()
	{
		return this.approverApplicable;
	}
	/**
	 * Setter method : setApproverApplicable
	 * @param approverApplicable the approverApplicable to set
	 * 
	 * Date          : Mar 26, 2018 12:56:13 PM
	 */
	public void setApproverApplicable(boolean approverApplicable)
	{
		this.approverApplicable = approverApplicable;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UniversityWithdrawDTO [recordSequence=" + this.recordSequence
				+ ", studentId=" + this.studentId + ", studentNo="
				+ this.studentNo + ", studentStatCode=" + this.studentStatCode
				+ ", studentName=" + this.studentName + ", cohort="
				+ this.cohort + ", firstStatusCode=" + this.firstStatusCode
				+ ", toCCYearCode=" + this.toCCYearCode + ", toSemCode="
				+ this.toSemCode + ", toSemName=" + this.toSemName
				+ ", collegeName=" + this.collegeName + ", degreeName="
				+ this.degreeName + ", statusCode=" + this.statusCode
				+ ", statusCodeName=" + this.statusCodeName
				+ ", statusDescription=" + this.statusDescription
				+ ", reasonCodeStd=" + this.reasonCodeStd + ", reasonStd="
				+ this.reasonStd + ", reason=" + this.reason + ", reasonCode="
				+ this.reasonCode + ", userName=" + this.userName
				+ ", applyDate=" + this.applyDate + ", activityDate="
				+ this.activityDate + ", advisor=" + this.advisor
				+ ", supervisor=" + this.supervisor + ", collegeDean="
				+ this.collegeDean + ", dpsDean=" + this.dpsDean
				+ ", comments=" + this.comments + ", statusReject="
				+ this.statusReject + ", approver=" + this.approver
				+ ", approverApplicable=" + this.approverApplicable + "]";
	}

	
	
	
}
