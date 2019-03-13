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
 * File Name			:	GradeIncompleteDTO.java
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

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Course;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.grade.incomplete.model.IncompleteGradeModel;
import om.edu.squ.squportal.portlet.dps.role.bo.DPSAsstDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.HOD;

/**
 * @author Bhabesh
 *
 */
public class GradeIncompleteDTO
{
	private		Course			course;
	private		Student			student;
	private		Grade			grade;
	private		String			comments;
	private		String			userName;
	private		boolean			historyAvailable;
	private		String			sequenceNum;
	
	private		String			lAbrStatusCode;
	private		String			statusDesc;
	private		boolean			approver;
	private		String			recordSequence;
	
	private		String			roleType;
	
	private		HOD				hod;
	private		DPSAsstDean		dpsAsstDean;
	private		DpsDean			dpsDean;
	

	public GradeIncompleteDTO(){}
	
	public GradeIncompleteDTO(IncompleteGradeModel incompleteGradeModel )
	{
		Course			course			=	new Course();
		Student			student			=	new Student();
		AcademicDetail	academicDetail	=	new AcademicDetail();
		
		academicDetail.setId(incompleteGradeModel.getId());
		academicDetail.setStudentNo(incompleteGradeModel.getStudentNo());
		academicDetail.setStdStatCode(incompleteGradeModel.getStdStatCode());
		student.setAcademicDetail(academicDetail);
		
		course.setCourseYear(Integer.parseInt(incompleteGradeModel.getCourseYear()));
		course.setSemester(Integer.parseInt(incompleteGradeModel.getSemester()));
		course.setSectCode(incompleteGradeModel.getSectCode());
		course.setlAbrCourseNo(incompleteGradeModel.getlAbrCourseNo());
		course.setCourseNo(incompleteGradeModel.getCourseNo());
		course.setSectionNo(incompleteGradeModel.getSectionNo());
		
		this.course 		=	course;
		this.student		=	student;
		
		this.recordSequence	=	incompleteGradeModel.getRecordSequence();
		this.comments		=	incompleteGradeModel.getComment();
		this.lAbrStatusCode	=	incompleteGradeModel.getlAbrStatusCode();
		this.roleType		=	incompleteGradeModel.getRoleName();
	}
	
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

	/**
	 * Getter Method	: getStudent
	 * @return the student
	 * 
	 * Date				: Jan 8, 2018
	 */
	public Student getStudent()
	{
		return this.student;
	}

	/**
	 * Setter method : setStudent
	 * @param student the student to set
	 * 
	 * Date          : Jan 8, 2018 5:39:27 PM
	 */
	public void setStudent(Student student)
	{
		this.student = student;
	}

	/**
	 * Getter Method	: getGrade
	 * @return the grade
	 * 
	 * Date				: Jan 8, 2018
	 */
	public Grade getGrade()
	{
		return this.grade;
	}

	/**
	 * Setter method : setGrade
	 * @param grade the grade to set
	 * 
	 * Date          : Jan 8, 2018 5:39:27 PM
	 */
	public void setGrade(Grade grade)
	{
		this.grade = grade;
	}

	/**
	 * Getter Method	: getComments
	 * @return the comments
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getComments()
	{
		return this.comments;
	}

	/**
	 * Setter method : setComments
	 * @param comments the comments to set
	 * 
	 * Date          : Jan 11, 2018 3:23:43 PM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}

	/**
	 * Getter Method	: getUserName
	 * @return the userName
	 * 
	 * Date				: Jan 11, 2018
	 */
	public String getUserName()
	{
		return this.userName;
	}

	/**
	 * Setter method : setUserName
	 * @param userName the userName to set
	 * 
	 * Date          : Jan 11, 2018 4:33:03 PM
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * Getter Method	: isHistoryAvailable
	 * @return the historyAvailable
	 * 
	 * Date				: Jan 14, 2018
	 */
	public boolean isHistoryAvailable()
	{
		return this.historyAvailable;
	}

	/**
	 * Setter method : setHistoryAvailable
	 * @param historyAvailable the historyAvailable to set
	 * 
	 * Date          : Jan 14, 2018 10:51:56 AM
	 */
	public void setHistoryAvailable(boolean historyAvailable)
	{
		this.historyAvailable = historyAvailable;
	}

	/**
	 * Getter Method	: getSequenceNum
	 * @return the sequenceNum
	 * 
	 * Date				: Jan 14, 2018
	 */
	public String getSequenceNum()
	{
		return this.sequenceNum;
	}

	/**
	 * Setter method : setSequenceNum
	 * @param sequenceNum the sequenceNum to set
	 * 
	 * Date          : Jan 14, 2018 11:46:53 AM
	 */
	public void setSequenceNum(String sequenceNum)
	{
		this.sequenceNum = sequenceNum;
	}

	
	/**
	 * Getter Method	: getlAbrStatusCode
	 * @return the lAbrStatusCode
	 * 
	 * Date				: Jan 23, 2018
	 */
	public String getlAbrStatusCode()
	{
		return this.lAbrStatusCode;
	}

	/**
	 * Setter method : setlAbrStatusCode
	 * @param lAbrStatusCode the lAbrStatusCode to set
	 * 
	 * Date          : Jan 23, 2018 1:09:07 PM
	 */
	public void setlAbrStatusCode(String lAbrStatusCode)
	{
		this.lAbrStatusCode = lAbrStatusCode;
	}

	/**
	 * Getter Method	: getStatusDesc
	 * @return the statusDesc
	 * 
	 * Date				: Jan 15, 2018
	 */
	public String getStatusDesc()
	{
		return this.statusDesc;
	}

	/**
	 * Setter method : setStatusDesc
	 * @param statusDesc the statusDesc to set
	 * 
	 * Date          : Jan 15, 2018 8:36:20 AM
	 */
	public void setStatusDesc(String statusDesc)
	{
		this.statusDesc = statusDesc;
	}

	/**
	 * Getter Method	: isApprover
	 * @return the approver
	 * 
	 * Date				: Jan 18, 2018
	 */
	public boolean isApprover()
	{
		return this.approver;
	}

	/**
	 * Setter method : setApprover
	 * @param approver the approver to set
	 * 
	 * Date          : Jan 18, 2018 2:43:14 PM
	 */
	public void setApprover(boolean approver)
	{
		this.approver = approver;
	}

	/**
	 * Getter Method	: getRecordSequence
	 * @return the recordSequence
	 * 
	 * Date				: Jan 18, 2018
	 */
	public String getRecordSequence()
	{
		return this.recordSequence;
	}

	/**
	 * Setter method : setRecordSequence
	 * @param recordSequence the recordSequence to set
	 * 
	 * Date          : Jan 18, 2018 2:35:20 PM
	 */
	public void setRecordSequence(String recordSequence)
	{
		this.recordSequence = recordSequence;
	}

	/**
	 * Getter Method	: getRoleType
	 * @return the roleType
	 * 
	 * Date				: Jan 23, 2018
	 */
	public String getRoleType()
	{
		return this.roleType;
	}

	/**
	 * Setter method : setRoleType
	 * @param roleType the roleType to set
	 * 
	 * Date          : Jan 23, 2018 1:39:57 PM
	 */
	public void setRoleType(String roleType)
	{
		this.roleType = roleType;
	}

	/**
	 * Getter Method	: getHod
	 * @return the hod
	 * 
	 * Date				: Jan 15, 2018
	 */
	public HOD getHod()
	{
		return this.hod;
	}

	/**
	 * Setter method : setHod
	 * @param hod the hod to set
	 * 
	 * Date          : Jan 15, 2018 8:22:42 AM
	 */
	public void setHod(HOD hod)
	{
		this.hod = hod;
	}

	/**
	 * Getter Method	: getDpsAsstDean
	 * @return the dpsAsstDean
	 * 
	 * Date				: Jan 15, 2018
	 */
	public DPSAsstDean getDpsAsstDean()
	{
		return this.dpsAsstDean;
	}

	/**
	 * Setter method : setDpsAsstDean
	 * @param dpsAsstDean the dpsAsstDean to set
	 * 
	 * Date          : Jan 15, 2018 8:22:42 AM
	 */
	public void setDpsAsstDean(DPSAsstDean dpsAsstDean)
	{
		this.dpsAsstDean = dpsAsstDean;
	}

	/**
	 * Getter Method	: getDpsDean
	 * @return the dpsDean
	 * 
	 * Date				: Jan 15, 2018
	 */
	public DpsDean getDpsDean()
	{
		return this.dpsDean;
	}

	/**
	 * Setter method : setDpsDean
	 * @param dpsDean the dpsDean to set
	 * 
	 * Date          : Jan 15, 2018 8:22:42 AM
	 */
	public void setDpsDean(DpsDean dpsDean)
	{
		this.dpsDean = dpsDean;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeIncompleteDTO [course=" + this.course + ", student="
				+ this.student + ", grade=" + this.grade + ", comments="
				+ this.comments + ", userName=" + this.userName
				+ ", historyAvailable=" + this.historyAvailable
				+ ", sequenceNum=" + this.sequenceNum + ", lAbrStatusCode="
				+ this.lAbrStatusCode + ", statusDesc=" + this.statusDesc
				+ ", approver=" + this.approver + ", recordSequence="
				+ this.recordSequence + ", roleType=" + this.roleType
				+ ", hod=" + this.hod + ", dpsAsstDean=" + this.dpsAsstDean
				+ ", dpsDean=" + this.dpsDean + "]";
	}
	
}
