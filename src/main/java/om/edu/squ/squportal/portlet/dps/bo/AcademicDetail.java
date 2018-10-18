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
 * File Name			:	AcademicDetail.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.bo
 * Date of creation		:	09-January-2017
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
package om.edu.squ.squportal.portlet.dps.bo;

/**
 * @author Bhabesh
 *
 */
public class AcademicDetail
{
	private	String	id;
	private	String	studentNo;
	private	String	studentName;
	private	String	studentUserName;
	private	String	college;
	private	String	collegeEng;
	private	String	collegeAr;
	private	String	major;
	private	String	majorEng;
	private	String	majorAr;
	private	String	supervisorId;
	private	String	advisorId;
	private	String	degree;
	private	String	degreeEng;
	private	String	degreeAr;
	private	String	stdStatCode;
	private	String	status;
	private	int		estimatedSemesters;
	private	int		fromCCYrCode;						// Course Start year code
	private	int		fromSemCode;						// Course Start semester
	private	int		cohort;
	private	boolean	recordApprove;
	
	/**
	 * Getter Method	: getId
	 * @return the id
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getId()
	{
		return this.id;
	}
	/**
	 * Setter method : setId
	 * @param id the id to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Jan 23, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Jan 23, 2017 5:37:32 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	
	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Apr 17, 2017
	 */
	public String getStudentName()
	{
		return this.studentName;
	}
	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Apr 17, 2017 8:29:46 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	/**
	 * Getter Method	: getStudentUserName
	 * @return the studentUserName
	 * 
	 * Date				: Apr 10, 2017
	 */
	public String getStudentUserName()
	{
		return this.studentUserName;
	}
	/**
	 * Setter method : setStudentUserName
	 * @param studentUserName the studentUserName to set
	 * 
	 * Date          : Apr 10, 2017 6:41:24 PM
	 */
	public void setStudentUserName(String studentUserName)
	{
		this.studentUserName = studentUserName;
	}
	/**
	 * Getter Method	: getCollege
	 * @return the college
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getCollege()
	{
		return this.college;
	}
	/**
	 * Setter method : setCollege
	 * @param college the college to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setCollege(String college)
	{
		this.college = college;
	}
	/**
	 * Getter Method	: getCollegeEng
	 * @return the collegeEng
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getCollegeEng()
	{
		return this.collegeEng;
	}
	/**
	 * Setter method : setCollegeEng
	 * @param collegeEng the collegeEng to set
	 * 
	 * Date          : Oct 17, 2018 9:44:00 AM
	 */
	public void setCollegeEng(String collegeEng)
	{
		this.collegeEng = collegeEng;
	}
	/**
	 * Getter Method	: getCollegeAr
	 * @return the collegeAr
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getCollegeAr()
	{
		return this.collegeAr;
	}
	/**
	 * Setter method : setCollegeAr
	 * @param collegeAr the collegeAr to set
	 * 
	 * Date          : Oct 17, 2018 9:44:00 AM
	 */
	public void setCollegeAr(String collegeAr)
	{
		this.collegeAr = collegeAr;
	}
	/**
	 * Getter Method	: getMajor
	 * @return the major
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getMajor()
	{
		return this.major;
	}
	/**
	 * Setter method : setMajor
	 * @param major the major to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setMajor(String major)
	{
		this.major = major;
	}

	/**
	 * Getter Method	: getMajorEng
	 * @return the majorEng
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getMajorEng()
	{
		return this.majorEng;
	}
	/**
	 * Setter method : setMajorEng
	 * @param majorEng the majorEng to set
	 * 
	 * Date          : Oct 17, 2018 9:33:31 AM
	 */
	public void setMajorEng(String majorEng)
	{
		this.majorEng = majorEng;
	}
	/**
	 * Getter Method	: getMajorAr
	 * @return the majorAr
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getMajorAr()
	{
		return this.majorAr;
	}
	/**
	 * Setter method : setMajorAr
	 * @param majorAr the majorAr to set
	 * 
	 * Date          : Oct 17, 2018 9:33:31 AM
	 */
	public void setMajorAr(String majorAr)
	{
		this.majorAr = majorAr;
	}
	/**
	 * Getter Method	: getSupervisorId
	 * @return the supervisorId
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getSupervisorId()
	{
		return this.supervisorId;
	}
	/**
	 * Setter method : setSupervisorId
	 * @param supervisorId the supervisorId to set
	 * 
	 * Date          : Jan 9, 2017 10:40:01 AM
	 */
	public void setSupervisorId(String supervisorId)
	{
		this.supervisorId = supervisorId;
	}
	/**
	 * Getter Method	: getAdvisorId
	 * @return the advisorId
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getAdvisorId()
	{
		return this.advisorId;
	}
	/**
	 * Setter method : setAdvisorId
	 * @param advisorId the advisorId to set
	 * 
	 * Date          : Jan 9, 2017 10:40:01 AM
	 */
	public void setAdvisorId(String advisorId)
	{
		this.advisorId = advisorId;
	}
	/**
	 * Getter Method	: getDegree
	 * @return the degree
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getDegree()
	{
		return this.degree;
	}
	/**
	 * Setter method : setDegree
	 * @param degree the degree to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	/**
	 * Getter Method	: getDegreeEng
	 * @return the degreeEng
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getDegreeEng()
	{
		return this.degreeEng;
	}
	/**
	 * Setter method : setDegreeEng
	 * @param degreeEng the degreeEng to set
	 * 
	 * Date          : Oct 17, 2018 8:30:28 AM
	 */
	public void setDegreeEng(String degreeEng)
	{
		this.degreeEng = degreeEng;
	}
	/**
	 * Getter Method	: getDegreeAr
	 * @return the degreeAr
	 * 
	 * Date				: Oct 17, 2018
	 */
	public String getDegreeAr()
	{
		return this.degreeAr;
	}
	/**
	 * Setter method : setDegreeAr
	 * @param degreeAr the degreeAr to set
	 * 
	 * Date          : Oct 17, 2018 8:30:28 AM
	 */
	public void setDegreeAr(String degreeAr)
	{
		this.degreeAr = degreeAr;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Jan 10, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Jan 10, 2017 3:05:15 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getStatus
	 * @return the status
	 * 
	 * Date				: Jan 9, 2017
	 */
	public String getStatus()
	{
		return this.status;
	}
	/**
	 * Setter method : setStatus
	 * @param status the status to set
	 * 
	 * Date          : Jan 9, 2017 10:34:35 AM
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	/**
	 * Getter Method	: getEstimatedSemesters
	 * @return the estimatedSemesters
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getEstimatedSemesters()
	{
		return this.estimatedSemesters;
	}
	/**
	 * Setter method : setEstimatedSemesters
	 * @param estimatedSemesters the estimatedSemesters to set
	 * 
	 * Date          : Mar 13, 2017 2:21:33 PM
	 */
	public void setEstimatedSemesters(int estimatedSemesters)
	{
		this.estimatedSemesters = estimatedSemesters;
	}
	/**
	 * Getter Method	: getFromCCYrCode
	 * @return the fromCCYrCode
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getFromCCYrCode()
	{
		return this.fromCCYrCode;
	}
	/**
	 * Setter method : setFromCCYrCode
	 * @param fromCCYrCode the fromCCYrCode to set
	 * 
	 * Date          : Mar 13, 2017 2:21:33 PM
	 */
	public void setFromCCYrCode(int fromCCYrCode)
	{
		this.fromCCYrCode = fromCCYrCode;
	}
	/**
	 * Getter Method	: getFromSemCode
	 * @return the fromSemCode
	 * 
	 * Date				: Mar 13, 2017
	 */
	public int getFromSemCode()
	{
		return this.fromSemCode;
	}
	/**
	 * Setter method : setFromSemCode
	 * @param fromSemCode the fromSemCode to set
	 * 
	 * Date          : Mar 13, 2017 2:21:33 PM
	 */
	public void setFromSemCode(int fromSemCode)
	{
		this.fromSemCode = fromSemCode;
	}
	
	/**
	 * Getter Method	: getCohort
	 * @return the cohort
	 * 
	 * Date				: Apr 17, 2017
	 */
	public int getCohort()
	{
		return this.cohort;
	}
	/**
	 * Setter method : setCohort
	 * @param cohort the cohort to set
	 * 
	 * Date          : Apr 17, 2017 7:49:40 PM
	 */
	public void setCohort(int cohort)
	{
		this.cohort = cohort;
	}
	
	/**
	 * Getter Method	: isRecordApprove
	 * @return the recordApprove
	 * 
	 * Date				: Dec 19, 2017
	 */
	public boolean isRecordApprove()
	{
		return this.recordApprove;
	}
	/**
	 * Setter method : setRecordApprove
	 * @param recordApprove the recordApprove to set
	 * 
	 * Date          : Dec 19, 2017 4:44:58 PM
	 */
	public void setRecordApprove(boolean recordApprove)
	{
		this.recordApprove = recordApprove;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AcademicDetail [id=" + this.id + ", studentNo="
				+ this.studentNo + ", studentName=" + this.studentName
				+ ", studentUserName=" + this.studentUserName + ", college="
				+ this.college + ", collegeEng=" + this.collegeEng
				+ ", collegeAr=" + this.collegeAr + ", major=" + this.major
				+ ", majorEng=" + this.majorEng + ", majorAr=" + this.majorAr
				+ ", supervisorId=" + this.supervisorId + ", advisorId="
				+ this.advisorId + ", degree=" + this.degree + ", degreeEng="
				+ this.degreeEng + ", degreeAr=" + this.degreeAr
				+ ", stdStatCode=" + this.stdStatCode + ", status="
				+ this.status + ", estimatedSemesters="
				+ this.estimatedSemesters + ", fromCCYrCode="
				+ this.fromCCYrCode + ", fromSemCode=" + this.fromSemCode
				+ ", cohort=" + this.cohort + ", recordApprove="
				+ this.recordApprove + "]";
	}

	
	

	
}
