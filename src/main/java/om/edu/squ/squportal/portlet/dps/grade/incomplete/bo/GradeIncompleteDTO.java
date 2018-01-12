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

/**
 * @author Bhabesh
 *
 */
public class GradeIncompleteDTO
{
	private	Course	course;
	private	Student	student;
	private	Grade	grade;
	private	String	comments;
	private	String	userName;
	

	public GradeIncompleteDTO(){}
	
	public GradeIncompleteDTO(IncompleteGradeModel incompleteGradeModel )
	{
		Course			course			=	new Course();
		Student			student			=	new Student();
		AcademicDetail	academicDetail	=	new AcademicDetail();
		
		academicDetail.setStudentNo(incompleteGradeModel.getStudentNo());
		academicDetail.setStdStatCode(incompleteGradeModel.getStdStatCode());
		student.setAcademicDetail(academicDetail);
		
		course.setCourseYear(Integer.parseInt(incompleteGradeModel.getCourseYear()));
		course.setSemester(Integer.parseInt(incompleteGradeModel.getSemester()));
		course.setSectCode(incompleteGradeModel.getSectCode());
		course.setlAbrCourseNo(incompleteGradeModel.getlAbrCourseNo());
		course.setCourseNo(incompleteGradeModel.getCourseNo());
		course.setSectionNo(incompleteGradeModel.getSectionNo());
		
		this.course 	=	course;
		this.student	=	student;
		this.comments	=	incompleteGradeModel.getComment();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeIncompleteDTO [course=" + this.course + ", student="
				+ this.student + ", grade=" + this.grade + ", comments="
				+ this.comments + ", userName=" + this.userName + "]";
	}
	
	
}
