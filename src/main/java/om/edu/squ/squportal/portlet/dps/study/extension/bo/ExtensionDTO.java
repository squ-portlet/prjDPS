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
 * File Name			:	ExtensionDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.study.extension.bo
 * Date of creation		:	Jan 23, 2017  5:26:14 PM
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

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;
import om.edu.squ.squportal.portlet.dps.study.extension.model.ExtensionStudentDataModel;

/**
 * @author Bhabesh
 *
 */
public class ExtensionDTO
{
	private	String		studentNo;
	private	String		studentId;
	private	String		stdStatCode;
	private	String		studentName;
	private	String		cohort;
	private	String		collegeName;
	private	String		degreeName;
	private	String		fromCcYrCode;
	private	String		fromSemCode;
	private	String		fromSemName;
	private	String		toCcYrCode;
	private	String		toSemCode;
	private	String		toSemName;
	private	String		toYearSemester;
	private	String		commentEng;
	private	String		commentArb;
	private	String		userCode;									// User to insert/ update the record
	private	String		userName;
	private	String		activitiDate;
	private	String		reasonCode;
	private	String		reasonDesc;
	private	String		reasonOther;
	private	String		statusCode;
	private	String		statusCodeName;
	private	String		statusDesc;
	
	private	Advisor		advisor;
	private	Supervisor	supervisor;
	private	CollegeDean	collegeDean;
	private	DpsDean		dpsDean;
	private	boolean		approver;
	private	boolean		approverApplicable ;
	private	String		roleName;
	private	String		approvalCode;
	private	boolean 	applyDelegation;
	
	
	
	
	
	public ExtensionDTO(){}
	public ExtensionDTO(Student	student, ExtensionStudentDataModel extensionStudentDataModel, String userName )
	{
		this.studentNo		=	student.getAcademicDetail().getStudentNo();
		this.stdStatCode	=	student.getAcademicDetail().getStdStatCode();
		this.fromCcYrCode	=	extensionStudentDataModel.getYearSem().split("-")[0];
		this.toCcYrCode		=	extensionStudentDataModel.getYearSem().split("-")[0];
		this.fromSemCode	=	extensionStudentDataModel.getYearSem().split("-")[1];
		this.toSemCode		=	extensionStudentDataModel.getYearSem().split("-")[1];
		this.userCode		=	userName;
		this.reasonCode		=	extensionStudentDataModel.getReasonCode();
		this.reasonOther	=	extensionStudentDataModel.getReasonOther();
	}
	

	
	public ExtensionDTO(String studentNo, String stdStatCode, String statusCodeName, String userName)
	{
		this.studentNo		=	studentNo;
		this.stdStatCode	=	stdStatCode;
		this.statusCodeName	=	statusCodeName;
		this.userName		=	userName;
	}
	
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Feb 19, 2017
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Feb 19, 2017 9:56:17 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Feb 15, 2017
	 */
	public String getStudentName()
	{
		return this.studentName;
	}
	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Feb 15, 2017 9:51:59 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	/**
	 * Getter Method	: getCohort
	 * @return the cohort
	 * 
	 * Date				: Feb 15, 2017
	 */
	public String getCohort()
	{
		return this.cohort;
	}
	/**
	 * Setter method : setCohort
	 * @param cohort the cohort to set
	 * 
	 * Date          : Feb 15, 2017 9:55:05 PM
	 */
	public void setCohort(String cohort)
	{
		this.cohort = cohort;
	}
	
	/**
	 * Getter Method	: getCollegeName
	 * @return the collegeName
	 * 
	 * Date				: Feb 15, 2017
	 */
	public String getCollegeName()
	{
		return this.collegeName;
	}
	/**
	 * Setter method : setCollegeName
	 * @param collegeName the collegeName to set
	 * 
	 * Date          : Feb 15, 2017 9:57:48 PM
	 */
	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}
	/**
	 * Getter Method	: getDegreeName
	 * @return the degreeName
	 * 
	 * Date				: Feb 15, 2017
	 */
	public String getDegreeName()
	{
		return this.degreeName;
	}
	/**
	 * Setter method : setDegreeName
	 * @param degreeName the degreeName to set
	 * 
	 * Date          : Feb 15, 2017 10:02:12 PM
	 */
	public void setDegreeName(String degreeName)
	{
		this.degreeName = degreeName;
	}
	/**
	 * Getter Method	: getFromCcYrCode
	 * @return the fromCcYrCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getFromCcYrCode()
	{
		return this.fromCcYrCode;
	}
	/**
	 * Setter method : setFromCcYrCode
	 * @param fromCcYrCode the fromCcYrCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setFromCcYrCode(String fromCcYrCode)
	{
		this.fromCcYrCode = fromCcYrCode;
	}
	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getFromSemCode()
	{
		return this.fromSemCode;
	}
	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setFromSemCode(String fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}
	/**
	 * Getter Method	: getFromSemName
	 * @return the fromSemName
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getFromSemName()
	{
		return this.fromSemName;
	}
	/**
	 * Setter method : setFromSemName
	 * @param fromSemName the fromSemName to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setFromSemName(String fromSemName)
	{
		this.fromSemName = fromSemName;
	}
	/**
	 * Getter Method	: getToCcYrCode
	 * @return the toCcYrCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getToCcYrCode()
	{
		return this.toCcYrCode;
	}
	/**
	 * Setter method : setToCcYrCode
	 * @param toCcYrCode the toCcYrCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setToCcYrCode(String toCcYrCode)
	{
		this.toCcYrCode = toCcYrCode;
	}
	/**
	 * Getter Method	: getToSemCode
	 * @return the toSemCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getToSemCode()
	{
		return this.toSemCode;
	}
	/**
	 * Setter method : setToSemCode
	 * @param toSemCode the toSemCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setToSemCode(String toSemCode)
	{
		this.toSemCode = toSemCode;
	}
	/**
	 * Getter Method	: getToSemName
	 * @return the toSemName
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getToSemName()
	{
		return this.toSemName;
	}
	/**
	 * Setter method : setToSemName
	 * @param toSemName the toSemName to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setToSemName(String toSemName)
	{
		this.toSemName = toSemName;
	}
	
	/**
	 * Getter Method	: getToYearSemester
	 * @return the toYearSemester
	 * 
	 * Date				: May 5, 2019
	 */
	public String getToYearSemester()
	{
		return this.toYearSemester;
	}
	/**
	 * Setter method : setToYearSemester
	 * @param toYearSemester the toYearSemester to set
	 * 
	 * Date          : May 5, 2019 2:08:28 PM
	 */
	public void setToYearSemester(String toYearSemester)
	{
		this.toYearSemester = toYearSemester;
	}
	/**
	 * Getter Method	: getCommentEng
	 * @return the commentEng
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getCommentEng()
	{
		return this.commentEng;
	}
	/**
	 * Setter method : setCommentEng
	 * @param commentEng the commentEng to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setCommentEng(String commentEng)
	{
		this.commentEng = commentEng;
	}
	/**
	 * Getter Method	: getCommentArb
	 * @return the commentArb
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getCommentArb()
	{
		return this.commentArb;
	}
	/**
	 * Setter method : setCommentArb
	 * @param commentArb the commentArb to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setCommentArb(String commentArb)
	{
		this.commentArb = commentArb;
	}
	/**
	 * Getter Method	: getUserCode
	 * @return the userCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getUserCode()
	{
		return this.userCode;
	}
	/**
	 * Setter method : setUserCode
	 * @param userCode the userCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}
	
	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Feb 23, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}
	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Feb 23, 2017 2:23:52 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * Getter Method	: getActivitiDate
	 * @return the activitiDate
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getActivitiDate()
	{
		return this.activitiDate;
	}
	/**
	 * Setter method : setActivitiDate
	 * @param activitiDate the activitiDate to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setActivitiDate(String activitiDate)
	{
		this.activitiDate = activitiDate;
	}
	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}
	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}
	/**
	 * Getter Method	: getReasonDesc
	 * @return the reasonDesc
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getReasonDesc()
	{
		return this.reasonDesc;
	}
	/**
	 * Setter method : setReasonDesc
	 * @param reasonDesc the reasonDesc to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setReasonDesc(String reasonDesc)
	{
		this.reasonDesc = reasonDesc;
	}
	/**
	 * Getter Method	: getReasonOther
	 * @return the reasonOther
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getReasonOther()
	{
		return this.reasonOther;
	}
	/**
	 * Setter method : setReasonOther
	 * @param reasonOther the reasonOther to set
	 * 
	 * Date          : Feb 7, 2017 3:11:19 PM
	 */
	public void setReasonOther(String reasonOther)
	{
		this.reasonOther = reasonOther;
	}
	
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Feb 7, 2017 3:33:54 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	
	/**
	 * Getter Method	: getStatusCodeName
	 * @return the statusCodeName
	 * 
	 * Date				: Feb 28, 2017
	 */
	public String getStatusCodeName()
	{
		return this.statusCodeName;
	}
	/**
	 * Setter method : setStatusCodeName
	 * @param statusCodeName the statusCodeName to set
	 * 
	 * Date          : Feb 28, 2017 8:38:13 AM
	 */
	public void setStatusCodeName(String statusCodeName)
	{
		this.statusCodeName = statusCodeName;
	}
	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Feb 7, 2017
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}
	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Feb 7, 2017 3:33:54 PM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}
	

	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Feb 21, 2017
	 */
	public boolean isApprover()
	{
		return this.approver;
	}
	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Feb 21, 2017 2:09:33 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}
	
	
	/**
	 * Getter Method	: isApproverApplicable
	 * @return the approverApplicable
	 * 
	 * Date				: Jul 22, 2018
	 */
	public boolean isApproverApplicable()
	{
		return this.approverApplicable;
	}
	/**
	 * Setter method : setApproverApplicable
	 * @param approverApplicable the approverApplicable to set
	 * 
	 * Date          : Jul 22, 2018 12:29:40 PM
	 */
	public void setApproverApplicable(boolean approverApplicable)
	{
		this.approverApplicable = approverApplicable;
	}
	/**
	 * Getter Method	: getRoleName
	 * @return the roleName
	 * 
	 * Date				: Feb 21, 2017
	 */
	public String getRoleName()
	{
		return this.roleName;
	}
	/**
	 * Setter method : setRoleName
	 * @param roleName the roleName to set
	 * 
	 * Date          : Feb 21, 2017 4:43:01 PM
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	
	/**
	 * Getter Method	: getApprovalCode
	 * @return the approvalCode
	 * 
	 * Date				: Feb 23, 2017
	 */
	public String getApprovalCode()
	{
		return this.approvalCode;
	}
	/**
	 * Setter method : setApprovalCode
	 * @param approvalCode the approvalCode to set
	 * 
	 * Date          : Feb 23, 2017 2:25:21 PM
	 */
	public void setApprovalCode(String approvalCode)
	{
		this.approvalCode = approvalCode;
	}
	
	
	/**
	 * Getter Method	: getAdvisor
	 * @return the advisor
	 * 
	 * Date				: Aug 28, 2017
	 */
	public Advisor getAdvisor()
	{
		return this.advisor;
	}
	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Aug 28, 2017 5:57:45 PM
	 */
	public void setAdvisor(Advisor advisor)
	{
		this.advisor = advisor;
	}
	/**
	 * Getter Method	: getSupervisor
	 * @return the supervisor
	 * 
	 * Date				: Mar 6, 2017
	 */
	public Supervisor getSupervisor()
	{
		return this.supervisor;
	}
	/**
	 * Setter method : setSupervisor
	 * @param supervisor the supervisor to set
	 * 
	 * Date          : Mar 6, 2017 7:43:44 PM
	 */
	public void setSupervisor(Supervisor supervisor)
	{
		this.supervisor = supervisor;
	}
	/**
	 * Getter Method	: getCollegeDean
	 * @return the collegeDean
	 * 
	 * Date				: Mar 6, 2017
	 */
	public CollegeDean getCollegeDean()
	{
		return this.collegeDean;
	}
	/**
	 * Setter method : setCollegeDean
	 * @param collegeDean the collegeDean to set
	 * 
	 * Date          : Mar 6, 2017 7:43:44 PM
	 */
	public void setCollegeDean(CollegeDean collegeDean)
	{
		this.collegeDean = collegeDean;
	}
	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Mar 6, 2017
	 */
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}
	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Mar 6, 2017 7:43:44 PM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}
	
	/**
	 * Getter Method	: isApplyDelegation
	 * @return the applyDelegation
	 * 
	 * Date				: May 10, 2018
	 */
	public boolean isApplyDelegation()
	{
		return this.applyDelegation;
	}
	/**
	 * Setter method : setApplyDelegation
	 * @param applyDelegation the applyDelegation to set
	 * 
	 * Date          : May 10, 2018 2:32:44 PM
	 */
	public void setApplyDelegation(boolean applyDelegation)
	{
		this.applyDelegation = applyDelegation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ExtensionDTO [studentNo=" + this.studentNo + ", studentId="
				+ this.studentId + ", stdStatCode=" + this.stdStatCode
				+ ", studentName=" + this.studentName + ", cohort="
				+ this.cohort + ", collegeName=" + this.collegeName
				+ ", degreeName=" + this.degreeName + ", fromCcYrCode="
				+ this.fromCcYrCode + ", fromSemCode=" + this.fromSemCode
				+ ", fromSemName=" + this.fromSemName + ", toCcYrCode="
				+ this.toCcYrCode + ", toSemCode=" + this.toSemCode
				+ ", toSemName=" + this.toSemName + ", toYearSemester="
				+ this.toYearSemester + ", commentEng=" + this.commentEng
				+ ", commentArb=" + this.commentArb + ", userCode="
				+ this.userCode + ", userName=" + this.userName
				+ ", activitiDate=" + this.activitiDate + ", reasonCode="
				+ this.reasonCode + ", reasonDesc=" + this.reasonDesc
				+ ", reasonOther=" + this.reasonOther + ", statusCode="
				+ this.statusCode + ", statusCodeName=" + this.statusCodeName
				+ ", statusDesc=" + this.statusDesc + ", advisor="
				+ this.advisor + ", supervisor=" + this.supervisor
				+ ", collegeDean=" + this.collegeDean + ", dpsDean="
				+ this.dpsDean + ", approver=" + this.approver
				+ ", approverApplicable=" + this.approverApplicable
				+ ", roleName=" + this.roleName + ", approvalCode="
				+ this.approvalCode + ", applyDelegation="
				+ this.applyDelegation + "]";
	}
	
	
	
}
