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
 * File Name			:	GradeChangeModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.model
 * Date of creation		:	Nov 13, 2017  3:40:47 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import om.edu.squ.squportal.portlet.dps.security.Crypto;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeModel
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	String	recordSequence;
	private	String	studentId;
	private	String	studentNo;
	private	String	stdStatCode; 
	private	String	sectCode;
	private	String	courseYear;
	private	String	semCode;
	private	String	sectionNo;
	private	String	courseCode;
	private	String	lAbrCrsNo;
	private	String	gradeCodeOld;
	private	String	gradeCodeNew;
	private	String	gradeValNew;
	private	String	comments;
	private	String	statusCode;
	
	private	String	roleName;

	/* Security cipher */
	private	String	salt;
	private	String	four;
	
	public void decrypt(Crypto crypto, String salt, String four, GradeChangeModel gradeChangeModel )
	{
		this.recordSequence	=	(null==gradeChangeModel.getRecordSequence())?null:crypto.decrypt(salt,four,gradeChangeModel.getRecordSequence());
		this.studentId		=	(null==gradeChangeModel.getStudentId())		?null:crypto.decrypt(salt,four,gradeChangeModel.getStudentId());
		this.studentNo		=	(null==gradeChangeModel.getStudentNo())		?null:crypto.decrypt(salt,four,gradeChangeModel.getStudentNo());
		this.stdStatCode 	=	(null==gradeChangeModel.getStdStatCode())	?null:crypto.decrypt(salt,four,gradeChangeModel.getStdStatCode());
		this.sectCode		=	(null==gradeChangeModel.getSectCode())		?null:crypto.decrypt(salt,four,gradeChangeModel.getSectCode());
		this.courseYear		=	(null==gradeChangeModel.getCourseYear())	?null:crypto.decrypt(salt,four,gradeChangeModel.getCourseYear());
		this.semCode		=	(null==gradeChangeModel.getSemCode())		?null:crypto.decrypt(salt,four,gradeChangeModel.getSemCode());
		this.sectionNo		=	(null==gradeChangeModel.getSectionNo())		?null:crypto.decrypt(salt,four,gradeChangeModel.getSectionNo());
		this.courseCode		=	(null==gradeChangeModel.getCourseCode())	?null:crypto.decrypt(salt,four,gradeChangeModel.getCourseCode());
		this.lAbrCrsNo		=	(null==gradeChangeModel.getlAbrCrsNo())		?null:crypto.decrypt(salt,four,gradeChangeModel.getlAbrCrsNo());
		this.gradeCodeOld	=	(null==gradeChangeModel.getGradeCodeOld())	?null:crypto.decrypt(salt,four,gradeChangeModel.getGradeCodeOld());
		this.gradeCodeNew	=	(null==gradeChangeModel.getGradeCodeNew())	?null:crypto.decrypt(salt,four,gradeChangeModel.getGradeCodeNew());
		this.gradeValNew	=	(null==gradeChangeModel.getGradeValNew())	?null:crypto.decrypt(salt,four,gradeChangeModel.getGradeValNew());
		this.statusCode		=	(null==gradeChangeModel.getStatusCode())	?null:crypto.decrypt(salt,four,gradeChangeModel.getStatusCode());
		this.roleName		=	(null==gradeChangeModel.getRoleName())		?null:crypto.decrypt(salt,four,gradeChangeModel.getRoleName());
	}
	
	/**
	 * Getter Method	: getRecordSequence
	 * @return the recordSequence
	 * 
	 * Date				: Dec 10, 2017
	 */
	public String getRecordSequence()
	{
		return this.recordSequence;
	}
	/**
	 * Setter method : setRecordSequence
	 * @param recordSequence the recordSequence to set
	 * 
	 * Date          : Dec 10, 2017 11:27:45 AM
	 */
	public void setRecordSequence(String recordSequence)
	{
		this.recordSequence = recordSequence;
	}
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Nov 20, 2017 11:58:36 AM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Nov 22, 2017
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Nov 22, 2017 9:28:10 AM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	
	/**
	 * Getter Method	: getSectCode
	 * @return the sectCode
	 * 
	 * Date				: Dec 13, 2017
	 */
	public String getSectCode()
	{
		return this.sectCode;
	}

	/**
	 * Setter method : setSectCode
	 * @param sectCode the sectCode to set
	 * 
	 * Date          : Dec 13, 2017 12:02:03 PM
	 */
	public void setSectCode(String sectCode)
	{
		this.sectCode = sectCode;
	}

	/**
	 * Getter Method	: getCourseYear
	 * @return the courseYear
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getCourseYear()
	{
		return this.courseYear;
	}
	/**
	 * Setter method : setCourseYear
	 * @param courseYear the courseYear to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setCourseYear(String courseYear)
	{
		this.courseYear = courseYear;
	}
	/**
	 * Getter Method	: getSemCode
	 * @return the semCode
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSemCode()
	{
		return this.semCode;
	}
	/**
	 * Setter method : setSemCode
	 * @param semCode the semCode to set
	 * 
	 * Date          : Nov 15, 2017 2:24:32 PM
	 */
	public void setSemCode(String semCode)
	{
		this.semCode = semCode;
	}
	
	/**
	 * Getter Method	: getSectionNo
	 * @return the sectionNo
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getSectionNo()
	{
		return this.sectionNo;
	}
	/**
	 * Setter method : setSectionNo
	 * @param sectionNo the sectionNo to set
	 * 
	 * Date          : Nov 20, 2017 11:58:55 AM
	 */
	public void setSectionNo(String sectionNo)
	{
		this.sectionNo = sectionNo;
	}
	
	/**
	 * Getter Method	: getCourseCode
	 * @return the courseCode
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getCourseCode()
	{
		return this.courseCode;
	}
	/**
	 * Setter method : setCourseCode
	 * @param courseCode the courseCode to set
	 * 
	 * Date          : Nov 20, 2017 11:59:19 AM
	 */
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	/**
	 * Getter Method	: getlAbrCrsNo
	 * @return the lAbrCrsNo
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getlAbrCrsNo()
	{
		return this.lAbrCrsNo;
	}
	/**
	 * Setter method : setlAbrCrsNo
	 * @param lAbrCrsNo the lAbrCrsNo to set
	 * 
	 * Date          : Nov 15, 2017 2:48:18 PM
	 */
	public void setlAbrCrsNo(String lAbrCrsNo)
	{
		this.lAbrCrsNo = lAbrCrsNo;
	}
	
	/**
	 * Getter Method	: getGradeCodeOld
	 * @return the gradeCodeOld
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getGradeCodeOld()
	{
		return this.gradeCodeOld;
	}
	/**
	 * Setter method : setGradeCodeOld
	 * @param gradeCodeOld the gradeCodeOld to set
	 * 
	 * Date          : Nov 20, 2017 11:59:36 AM
	 */
	public void setGradeCodeOld(String gradeCodeOld)
	{
		this.gradeCodeOld = gradeCodeOld;
	}
	/**
	 * Getter Method	: getGradeCodeNew
	 * @return the gradeCodeNew
	 * 
	 * Date				: Nov 20, 2017
	 */
	public String getGradeCodeNew()
	{
		return this.gradeCodeNew;
	}
	/**
	 * Setter method : setGradeCodeNew
	 * @param gradeCodeNew the gradeCodeNew to set
	 * 
	 * Date          : Nov 20, 2017 11:59:36 AM
	 */
	public void setGradeCodeNew(String gradeCodeNew)
	{
		this.gradeCodeNew = gradeCodeNew;
	}
	
	/**
	 * Getter Method	: getComments
	 * @return the comments
	 * 
	 * Date				: Nov 22, 2017
	 */
	public String getComments()
	{
		return this.comments;
	}
	/**
	 * Setter method : setComments
	 * @param comments the comments to set
	 * 
	 * Date          : Nov 22, 2017 8:06:14 PM
	 */
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	/**
	 * Getter Method	: getStatusCode
	 * @return the statusCode
	 * 
	 * Date				: Dec 10, 2017
	 */
	public String getStatusCode()
	{
		return this.statusCode;
	}
	/**
	 * Setter method : setStatusCode
	 * @param statusCode the statusCode to set
	 * 
	 * Date          : Dec 10, 2017 2:22:32 PM
	 */
	public void setStatusCode(String statusCode)
	{
		this.statusCode = statusCode;
	}
	/**
	 * Getter Method	: getRoleName
	 * @return the roleName
	 * 
	 * Date				: Dec 7, 2017
	 */
	public String getRoleName()
	{
		return this.roleName;
	}
	/**
	 * Setter method : setRoleName
	 * @param roleName the roleName to set
	 * 
	 * Date          : Dec 7, 2017 1:16:35 PM
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	/**
	 * Getter Method	: getGradeValNew
	 * @return the gradeValNew
	 * 
	 * Date				: Nov 19, 2017
	 */
	public String getGradeValNew()
	{
		return this.gradeValNew;
	}
	/**
	 * Setter method : setGradeValNew
	 * @param gradeValNew the gradeValNew to set
	 * 
	 * Date          : Nov 19, 2017 1:49:31 PM
	 */
	public void setGradeValNew(String gradeValNew)
	{
		this.gradeValNew = gradeValNew;
	}
	/**
	 * Getter Method	: getSalt
	 * @return the salt
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getSalt()
	{
		return this.salt;
	}
	/**
	 * Setter method : setSalt
	 * @param salt the salt to set
	 * 
	 * Date          : Nov 15, 2017 6:56:03 PM
	 */
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	/**
	 * Getter Method	: getFour
	 * @return the four
	 * 
	 * Date				: Nov 15, 2017
	 */
	public String getFour()
	{
		return this.four;
	}
	/**
	 * Setter method : setFour
	 * @param four the four to set
	 * 
	 * Date          : Nov 15, 2017 6:56:03 PM
	 */
	public void setFour(String four)
	{
		this.four = four;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeChangeModel [logger=" + this.logger + ", recordSequence="
				+ this.recordSequence + ", studentId=" + this.studentId
				+ ", studentNo=" + this.studentNo + ", stdStatCode="
				+ this.stdStatCode + ", sectCode=" + this.sectCode
				+ ", courseYear=" + this.courseYear + ", semCode="
				+ this.semCode + ", sectionNo=" + this.sectionNo
				+ ", courseCode=" + this.courseCode + ", lAbrCrsNo="
				+ this.lAbrCrsNo + ", gradeCodeOld=" + this.gradeCodeOld
				+ ", gradeCodeNew=" + this.gradeCodeNew + ", gradeValNew="
				+ this.gradeValNew + ", comments=" + this.comments
				+ ", statusCode=" + this.statusCode + ", roleName="
				+ this.roleName + ", salt=" + this.salt + ", four=" + this.four
				+ "]";
	}
	
	

	
}
