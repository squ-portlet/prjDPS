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
 * File Name			:	PostponeDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.registration.postpone.bo
 * Date of creation		:	Aug 7, 2017  3:54:56 PM
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
package om.edu.squ.squportal.portlet.dps.registration.postpone.bo;

import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.registration.postpone.model.PostponeStudentModel;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.CollegeDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.Supervisor;

/**
 * @author Bhabesh
 *
 */
public class PostponeDTO
{
	private String		studentNo;
	private	String		studentId;
	private	String		studentStatCode;
	private	String		studentName;
	private	String		cohort;
	private	String		collegeName;
	private	String		degreeName;	
	private	String		fromCcYearCode;
	private	String		fromSemCode;
	private	String		toCcYearCode;
	private	String		toSemCode;
	private	String		toSemName;
	private	String		reasonCode;
	private	String		reasonName;
	private	String		reasonOther;
	private	String		reasonDesc;
	private	String		commentEng;
	private	String		commentArb;
	private	String		yearSem;
	private	String		userName;
	private	String		statusCode;
	private	String		statusCodeName;
	private	String		statusDesc;
	private	Advisor		advisor;	
	private	Supervisor	supervisor;
	private	CollegeDean	collegeDean;
	private	DpsDean		dpsDean;
	private	boolean		approver;
	private	String		roleName;
	private	String		approvalCode;
	private	String		activityDate;
	private	boolean		statusReject;
	
	
	
	/**
	 * 
	 * Constructor
	 *
	 */
	public PostponeDTO(){}
	
	/**
	 * 
	 * Constructor
	 * @param model
	 *
	 */
	public PostponeDTO(PostponeStudentModel model)
	{
		this.studentNo			=	model.getStudentNo();
		this.studentStatCode	=	model.getStudentStatCode();
		this.fromCcYearCode		=	model.getFromCcYearCode();
		this.fromSemCode		=	model.getFromSemCode();
		this.toCcYearCode		=	model.getToCcYearCode();
		this.toSemCode			=	model.getToSemCode();
		this.reasonCode			=	model.getReasonCode();
		this.reasonOther		=	model.getReasonOther();
		this.commentEng			=	model.getCommentEng();
		this.commentArb			=	model.getCommentArb();
		this.yearSem			=	model.getYearSem();
	}

	/**
	 * 
	 * Constructor
	 * @param student
	 * @param studentModel
	 * @param userName
	 *
	 */
	public PostponeDTO(Student student, PostponeStudentModel studentModel, String userName)
	{
		this.userName			=	userName;
		
		this.studentNo			=	student.getAcademicDetail().getStudentNo();
		this.studentStatCode	=	student.getAcademicDetail().getStdStatCode();
		
		this.fromCcYearCode		=	studentModel.getYearSem().split("-")[0];
		this.toCcYearCode		=	studentModel.getYearSem().split("-")[0];
		this.fromSemCode		=	studentModel.getYearSem().split("-")[1];
		this.toSemCode			=	studentModel.getYearSem().split("-")[1];
		
		this.reasonCode			=	studentModel.getReasonCode();
		this.reasonOther		=	studentModel.getReasonOther();
		
	}
	
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}


	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}

	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Sep 12, 2017
	 */
	public String getStudentId()
	{
		return this.studentId;
	}

	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Sep 12, 2017 5:40:10 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}

	/**
	 * Getter Method	: getStudentStatCode
	 * @return the studentStatCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getStudentStatCode()
	{
		return this.studentStatCode;
	}


	/**
	 * Setter method : setStudentStatCode
	 * @param studentStatCode the studentStatCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setStudentStatCode(String studentStatCode)
	{
		this.studentStatCode = studentStatCode;
	}

	

	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Sep 12, 2017
	 */
	public String getStudentName()
	{
		return this.studentName;
	}

	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Sep 12, 2017 5:45:00 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}

	/**
	 * Getter Method	: getCohort
	 * @return the cohort
	 * 
	 * Date				: Sep 12, 2017
	 */
	public String getCohort()
	{
		return this.cohort;
	}

	/**
	 * Setter method : setCohort
	 * @param cohort the cohort to set
	 * 
	 * Date          : Sep 12, 2017 5:48:39 PM
	 */
	public void setCohort(String cohort)
	{
		this.cohort = cohort;
	}

	/**
	 * Getter Method	: getCollegeName
	 * @return the collegeName
	 * 
	 * Date				: Sep 12, 2017
	 */
	public String getCollegeName()
	{
		return this.collegeName;
	}

	/**
	 * Setter method : setCollegeName
	 * @param collegeName the collegeName to set
	 * 
	 * Date          : Sep 12, 2017 5:51:28 PM
	 */
	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}

	/**
	 * Getter Method	: getDegreeName
	 * @return the degreeName
	 * 
	 * Date				: Sep 12, 2017
	 */
	public String getDegreeName()
	{
		return this.degreeName;
	}

	/**
	 * Setter method : setDegreeName
	 * @param degreeName the degreeName to set
	 * 
	 * Date          : Sep 12, 2017 5:51:28 PM
	 */
	public void setDegreeName(String degreeName)
	{
		this.degreeName = degreeName;
	}

	/**
	 * Getter Method	: getFromCcYearCode
	 * @return the fromCcYearCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getFromCcYearCode()
	{
		return this.fromCcYearCode;
	}


	/**
	 * Setter method : setFromCcYearCode
	 * @param fromCcYearCode the fromCcYearCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setFromCcYearCode(String fromCcYearCode)
	{
		this.fromCcYearCode = fromCcYearCode;
	}


	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getFromSemCode()
	{
		return this.fromSemCode;
	}


	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setFromSemCode(String fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}


	/**
	 * Getter Method	: getToCcYearCode
	 * @return the toCcYearCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getToCcYearCode()
	{
		return this.toCcYearCode;
	}


	/**
	 * Setter method : setToCcYearCode
	 * @param toCcYearCode the toCcYearCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setToCcYearCode(String toCcYearCode)
	{
		this.toCcYearCode = toCcYearCode;
	}


	/**
	 * Getter Method	: getToSemCode
	 * @return the toSemCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getToSemCode()
	{
		return this.toSemCode;
	}


	/**
	 * Setter method : setToSemCode
	 * @param toSemCode the toSemCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setToSemCode(String toSemCode)
	{
		this.toSemCode = toSemCode;
	}

	
	/**
	 * Getter Method	: getToSemName
	 * @return the toSemName
	 * 
	 * Date				: Aug 10, 2017
	 */
	public String getToSemName()
	{
		return this.toSemName;
	}

	/**
	 * Setter method : setToSemName
	 * @param toSemName the toSemName to set
	 * 
	 * Date          : Aug 10, 2017 8:49:52 AM
	 */
	public void setToSemName(String toSemName)
	{
		this.toSemName = toSemName;
	}

	/**
	 * Getter Method	: getReasonCode
	 * @return the reasonCode
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getReasonCode()
	{
		return this.reasonCode;
	}


	/**
	 * Setter method : setReasonCode
	 * @param reasonCode the reasonCode to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setReasonCode(String reasonCode)
	{
		this.reasonCode = reasonCode;
	}


	/**
	 * Getter Method	: getReasonName
	 * @return the reasonName
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getReasonName()
	{
		return this.reasonName;
	}

	/**
	 * Setter method : setReasonName
	 * @param reasonName the reasonName to set
	 * 
	 * Date          : Aug 9, 2017 2:30:19 PM
	 */
	public void setReasonName(String reasonName)
	{
		this.reasonName = reasonName;
	}

	/**
	 * Getter Method	: getReasonOther
	 * @return the reasonOther
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getReasonOther()
	{
		return this.reasonOther;
	}


	/**
	 * Setter method : setReasonOther
	 * @param reasonOther the reasonOther to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setReasonOther(String reasonOther)
	{
		this.reasonOther = reasonOther;
	}

	

	/**
	 * Getter Method	: getReasonDesc
	 * @return the reasonDesc
	 * 
	 * Date				: Aug 10, 2017
	 */
	public String getReasonDesc()
	{
		return this.reasonDesc;
	}

	/**
	 * Setter method : setReasonDesc
	 * @param reasonDesc the reasonDesc to set
	 * 
	 * Date          : Aug 10, 2017 8:54:37 AM
	 */
	public void setReasonDesc(String reasonDesc)
	{
		this.reasonDesc = reasonDesc;
	}

	/**
	 * Getter Method	: getCommentEng
	 * @return the commentEng
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getCommentEng()
	{
		return this.commentEng;
	}


	/**
	 * Setter method : setCommentEng
	 * @param commentEng the commentEng to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setCommentEng(String commentEng)
	{
		this.commentEng = commentEng;
	}


	/**
	 * Getter Method	: getCommentArb
	 * @return the commentArb
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getCommentArb()
	{
		return this.commentArb;
	}


	/**
	 * Setter method : setCommentArb
	 * @param commentArb the commentArb to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setCommentArb(String commentArb)
	{
		this.commentArb = commentArb;
	}


	/**
	 * Getter Method	: getYearSem
	 * @return the yearSem
	 * 
	 * Date				: Aug 7, 2017
	 */
	public String getYearSem()
	{
		return this.yearSem;
	}


	/**
	 * Setter method : setYearSem
	 * @param yearSem the yearSem to set
	 * 
	 * Date          : Aug 7, 2017 4:53:55 PM
	 */
	public void setYearSem(String yearSem)
	{
		this.yearSem = yearSem;
	}
	

	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Aug 8, 2017
	 */
	public String getUserName()
	{
		return this.userName;
	}

	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Aug 8, 2017 9:58:12 AM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}

	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}

	/**
	 * Getter Method	: getStatusCodeName
	 * @return the statusCodeName
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getStatusCodeName()
	{
		return this.statusCodeName;
	}

	/**
	 * Setter method : setStatusCodeName
	 * @param statusCodeName the statusCodeName to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setStatusCodeName(String statusCodeName)
	{
		this.statusCodeName = statusCodeName;
	}

	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}

	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	/**
	 * Getter Method	: getAdvisor
	 * @return the advisor
	 * 
	 * Date				: Aug 9, 2017
	 */
	public Advisor getAdvisor()
	{
		return this.advisor;
	}

	/**
	 * Setter method : setAdvisor
	 * @param advisor the advisor to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setAdvisor(Advisor advisor)
	{
		this.advisor = advisor;
	}

	/**
	 * Getter Method	: getSupervisor
	 * @return the supervisor
	 * 
	 * Date				: Aug 9, 2017
	 */
	public Supervisor getSupervisor()
	{
		return this.supervisor;
	}

	/**
	 * Setter method : setSupervisor
	 * @param supervisor the supervisor to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setSupervisor(Supervisor supervisor)
	{
		this.supervisor = supervisor;
	}

	/**
	 * Getter Method	: getCollegeDean
	 * @return the collegeDean
	 * 
	 * Date				: Aug 9, 2017
	 */
	public CollegeDean getCollegeDean()
	{
		return this.collegeDean;
	}

	/**
	 * Setter method : setCollegeDean
	 * @param collegeDean the collegeDean to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setCollegeDean(CollegeDean collegeDean)
	{
		this.collegeDean = collegeDean;
	}

	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Aug 9, 2017
	 */
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}

	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Aug 9, 2017 2:59:24 PM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}

	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Aug 9, 2017
	 */
	public boolean isApprover()
	{
		return this.approver;
	}

	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Aug 9, 2017 2:59:25 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}

	/**
	 * Getter Method	: getRoleName
	 * @return the roleName
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getRoleName()
	{
		return this.roleName;
	}

	/**
	 * Setter method : setRoleName
	 * @param roleName the roleName to set
	 * 
	 * Date          : Aug 9, 2017 2:59:25 PM
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	/**
	 * Getter Method	: getApprovalCode
	 * @return the approvalCode
	 * 
	 * Date				: Aug 9, 2017
	 */
	public String getApprovalCode()
	{
		return this.approvalCode;
	}

	/**
	 * Setter method : setApprovalCode
	 * @param approvalCode the approvalCode to set
	 * 
	 * Date          : Aug 9, 2017 2:59:25 PM
	 */
	public void setApprovalCode(String approvalCode)
	{
		this.approvalCode = approvalCode;
	}
	

	/**
	 * Getter Method	: getActivityDate
	 * @return the activityDate
	 * 
	 * Date				: Aug 10, 2017
	 */
	public String getActivityDate()
	{
		return this.activityDate;
	}

	/**
	 * Setter method : setActivityDate
	 * @param activityDate the activityDate to set
	 * 
	 * Date          : Aug 10, 2017 8:43:39 AM
	 */
	public void setActivityDate(String activityDate)
	{
		this.activityDate = activityDate;
	}
	

	/**
	 * Getter Method	: isStatusReject
	 * @return the statusReject
	 * 
	 * Date				: Aug 10, 2017
	 */
	public boolean isStatusReject()
	{
		return this.statusReject;
	}

	/**
	 * Setter method : setStatusReject
	 * @param statusReject the statusReject to set
	 * 
	 * Date          : Aug 10, 2017 2:51:17 PM
	 */
	public void setStatusReject(boolean statusReject)
	{
		this.statusReject = statusReject;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PostponeDTO [studentNo=" + this.studentNo + ", studentId="
				+ this.studentId + ", studentStatCode=" + this.studentStatCode
				+ ", studentName=" + this.studentName + ", cohort="
				+ this.cohort + ", collegeName=" + this.collegeName
				+ ", degreeName=" + this.degreeName + ", fromCcYearCode="
				+ this.fromCcYearCode + ", fromSemCode=" + this.fromSemCode
				+ ", toCcYearCode=" + this.toCcYearCode + ", toSemCode="
				+ this.toSemCode + ", toSemName=" + this.toSemName
				+ ", reasonCode=" + this.reasonCode + ", reasonName="
				+ this.reasonName + ", reasonOther=" + this.reasonOther
				+ ", reasonDesc=" + this.reasonDesc + ", commentEng="
				+ this.commentEng + ", commentArb=" + this.commentArb
				+ ", yearSem=" + this.yearSem + ", userName=" + this.userName
				+ ", statusCode=" + this.statusCode + ", statusCodeName="
				+ this.statusCodeName + ", statusDesc=" + this.statusDesc
				+ ", advisor=" + this.advisor + ", supervisor="
				+ this.supervisor + ", collegeDean=" + this.collegeDean
				+ ", dpsDean=" + this.dpsDean + ", approver=" + this.approver
				+ ", roleName=" + this.roleName + ", approvalCode="
				+ this.approvalCode + ", activityDate=" + this.activityDate
				+ ", statusReject=" + this.statusReject + "]";
	}
	
	
	
}
