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
 * File Name			:	GradeChangeDBImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.grade.gradechange.db
 * Date of creation		:	Nov 13, 2017  3:41:32 PM
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
package om.edu.squ.squportal.portlet.dps.grade.gradechange.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import om.edu.squ.squportal.portlet.dps.bo.AcademicDetail;
import om.edu.squ.squportal.portlet.dps.bo.Employee;
import om.edu.squ.squportal.portlet.dps.bo.PersonalDetail;
import om.edu.squ.squportal.portlet.dps.bo.Student;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NoDBRecordException;
import om.edu.squ.squportal.portlet.dps.dao.db.exception.NotCorrectDBRecordException;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Course;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.Grade;
import om.edu.squ.squportal.portlet.dps.grade.gradechange.bo.GradeDTO;
import om.edu.squ.squportal.portlet.dps.registration.dropw.bo.DropWDTO;
import om.edu.squ.squportal.portlet.dps.role.bo.Advisor;
import om.edu.squ.squportal.portlet.dps.role.bo.DPSAsstDean;
import om.edu.squ.squportal.portlet.dps.role.bo.DpsDean;
import om.edu.squ.squportal.portlet.dps.role.bo.HOD;
import om.edu.squ.squportal.portlet.dps.rule.bo.YearSemester;
import om.edu.squ.squportal.portlet.dps.tags.RoleTagGlyphicon;
import om.edu.squ.squportal.portlet.dps.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bhabesh
 *
 */
public class GradeChangeDBImpl implements GradeChangeDBDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private		Properties					queryProps;
	private		Properties					queryGradeChange;
	private		NamedParameterJdbcTemplate	nPJdbcTemplDpsGradeChange;
	/**
	 * Setter method : setQueryProps
	 * @param queryProps the queryProps to set
	 * 
	 * Date          : Nov 13, 2017 3:51:24 PM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}
	/**
	 * Setter method : setQueryGradeChange
	 * @param queryGradeChange the queryGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setQueryGradeChange(Properties queryGradeChange)
	{
		this.queryGradeChange = queryGradeChange;
	}
	/**
	 * Setter method : setnPJdbcTemplDpsGradeChange
	 * @param nPJdbcTemplDpsGradeChange the nPJdbcTemplDpsGradeChange to set
	 * 
	 * Date          : Nov 13, 2017 3:51:25 PM
	 */
	public void setnPJdbcTemplDpsGradeChange(
			NamedParameterJdbcTemplate nPJdbcTemplDpsGradeChange)
	{
		this.nPJdbcTemplDpsGradeChange = nPJdbcTemplDpsGradeChange;
	}
	
	
	/**
	 * 
	 * method name  : getStudentGrades
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:	Grade list of a student for a particular year, semester, instructor
	 *
	 * Date    		:	Nov 15, 2017 10:08:43 AM
	 */
	public List<GradeDTO>	getStudentGrades(boolean isRuleGradeChangeTimingFollowed, GradeDTO gradeDTO, String employeeNo, Locale locale) throws NoDBRecordException
	{

		String			SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE);
		YearSemester	yearSemester									=	null;
		
		RowMapper<GradeDTO> rowMapper	=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDTO	=	new GradeDTO();
				Course		course		=	new Course();
				Grade		grade		=	new Grade();
				
				gradeDTO.setSectCode(rs.getString(Constants.CONST_COLMN_SECT_CODE));
				course.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
				
				grade.setGradeCode(rs.getInt(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));
				
				gradeDTO.setStudentId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				gradeDTO.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				gradeDTO.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				gradeDTO.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD)); 
				gradeDTO.setCourseYear(rs.getString(Constants.COST_COL_DPS_COURSE_YEAR));
				gradeDTO.setSemester(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
				
				gradeDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				
				gradeDTO.setUpdatable(
										rs.getString(Constants.CONST_COLMN_POSTPONE_GRADE_IS_UPDATABLE).equals(Constants.CONST_YES)?true:false
									);
				
				if(rs.getString(Constants.CONST_COLMN_IS_CHANGE_ALLOWED).equals(Constants.CONST_YES))
				{
					gradeDTO.setChangable(true);
				}
				else
				{
					gradeDTO.setChangable(false);
				}
				
				gradeDTO.setCourse(course);
				gradeDTO.setGrade(grade);
				
				return gradeDTO;
			}
		};
		
		yearSemester	= (isRuleGradeChangeTimingFollowed) ? getRuleYearSem() : getCurrentYearSem();
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdId", gradeDTO.getStudentId());
		namedParameterMap.put("paramYear",  String.valueOf(yearSemester.getYear()));
		namedParameterMap.put("paramSem",  String.valueOf(yearSemester.getSemester()));
		namedParameterMap.put("paramEmpNo", employeeNo);
		if(null == gradeDTO.getCourse().getlAbrCourseNo() || gradeDTO.getCourse().getlAbrCourseNo().trim().equals(""))
		{
			namedParameterMap.put("paramLAbrCrsNo",null);
		}
		else
		{
			namedParameterMap.put("paramLAbrCrsNo", gradeDTO.getCourse().getlAbrCourseNo());
		}
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		try
		{
			return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE, namedParameterMap, rowMapper);
		}
		catch(UncategorizedSQLException sqlEx)
		{
			logger.error("Error occur to find to find grade records for student id:  {} and instructor: {} ",gradeDTO.getStudentId(), employeeNo);
			throw new NoDBRecordException(sqlEx.getMessage());
		}
		
	}
	
	/**
	 * 
	 * method name  : getGrades
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Grade>
	 * 
	 * purpose		: list of all grade values
	 *
	 * Date    		:	Nov 19, 2017 1:44:54 PM
	 */
	public List<Grade> getGrades(Locale locale)
	{
		String	SQL_GRADE_VALUE_LIST		=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_VALUE_LIST);
		RowMapper<Grade> rowMapper			=	new RowMapper<Grade>()
		{
			
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Grade	grade	=	new Grade();
				grade.setGradeCode(rs.getInt(Constants.CONST_COLMN_GRADE_CODE));
				grade.setGradeVal(rs.getString(Constants.CONST_COLMN_GRADE_VAL));
				return grade;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		
		return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_VALUE_LIST, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : getGradeHistory
	 * @param dto
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 19, 2017 4:36:02 PM
	 * @throws NoDBRecordException 
	 */
	public List<GradeDTO> getGradeHistory(boolean isRuleGradeChangeTimingFollowed, GradeDTO dto, Locale locale) throws NoDBRecordException
	{
		String					SQL_GRADE_SELECT_HISORY			=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_HISORY);
		YearSemester			yearSemester					=	null;
		
		RowMapper<GradeDTO> 	rowMapper				=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDto	=	new GradeDTO();
				Course		course		=	new Course();
				Grade		grade		=	new Grade();
				HOD			hod			=	new HOD();
				DPSAsstDean	dpsAsstDean	=	new DPSAsstDean();
				DpsDean		dpsDean		=	new DpsDean();
				
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				
				grade.setGradeValOld(rs.getString(Constants.CONST_COLMN_GRADE_VAL_OLD));
				grade.setGradeValNew(rs.getString(Constants.CONST_COLMN_GRADE_VAL_NEW));
				
				gradeDto.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				gradeDto.setCourse(course);
				
				gradeDto.setGrade(grade);
				
				gradeDto.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				gradeDto.setComments(rs.getString(Constants.CONST_COLMN_COMMENT));
				
				
				hod.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_HOD_STATUS));
				hod.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_HOD_STATUS)));
				hod.setComments(rs.getString(Constants.CONST_COLMN_ROLE_HOD_COMMENT));
				

				dpsAsstDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_STATUS));
				dpsAsstDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_STATUS)));
				dpsAsstDean.setComments(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_COMMENT));

				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));
				dpsDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS)));
				dpsDean.setComments(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_COMMENT));

				gradeDto.setHod(hod);
				gradeDto.setDpsAsstDean(dpsAsstDean);
				gradeDto.setDpsDean(dpsDean);
				
				return gradeDto;
			}
		};	
	
		yearSemester	= (isRuleGradeChangeTimingFollowed) ? getRuleYearSem() : getCurrentYearSem();
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdId", dto.getStudentId());
		namedParameterMap.put("paramYear", String.valueOf(yearSemester.getYear()));
		namedParameterMap.put("paramLAbrCourseNo", dto.getCourse().getlAbrCourseNo());
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE);
		namedParameterMap.put("paramHodRoleName", Constants.CONST_SQL_ROLE_NAME_HOD);
		namedParameterMap.put("paramADeanPRoleName", Constants.CONST_SQL_ROLE_NAME_DPS_ASSISTANT_DEAN);
		namedParameterMap.put("paramDeanPRoleName", Constants.CONST_SQL_ROLE_NAME_DPS_DEAN);
		
		try
		{
			return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_SELECT_HISORY, namedParameterMap, rowMapper);
		}
		catch(UncategorizedSQLException sqlEx)
		{
			logger.error("Error occur to find to find grade change history records for student id:  {} ",dto.getStudentId());
			throw new NoDBRecordException(sqlEx.getMessage());
		}
	}
	
	/**
	 * 
	 * method name  : setInstructorApplyForGradeChange
	 * @param dto
	 * @return
	 * GradeChangeDBImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 21, 2017 12:32:15 PM
	 */
	public int setInstructorApplyForGradeChange(GradeDTO dto) throws NotCorrectDBRecordException
	{
		String	SQL_GRADE_INSERT_APPLY_INSTRUCTOR	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_INSERT_APPLY_INSTRUCTOR);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStdNo", dto.getStudentNo());
		namedParameterMap.put("paramStdStatCode", dto.getStdStatCode()); 
		namedParameterMap.put("paramYear", dto.getCourseYear());
		namedParameterMap.put("paramSem", dto.getSemester());
		namedParameterMap.put("paramSectCode", dto.getSectCode());
		namedParameterMap.put("paramCourseLAbrCode", dto.getCourse().getlAbrCourseNo());
		namedParameterMap.put("paramCourseNo", dto.getCourse().getCourseNo());
		namedParameterMap.put("paramSectNo", dto.getSectionNo());
		namedParameterMap.put("paramGradeCodeOld", String.valueOf(dto.getGrade().getGradeCodeOld()));
		namedParameterMap.put("paramGradeCodeNew", String.valueOf(dto.getGrade().getGradeCodeNew()));
		namedParameterMap.put("paramComments", dto.getComments());
		namedParameterMap.put("paramStatusCode", Constants.CONST_SQL_STATUS_CODE_NAME_PENDING);
		namedParameterMap.put("paramUserName", dto.getUserName());
		
		try
			{
				return nPJdbcTemplDpsGradeChange.update(SQL_GRADE_INSERT_APPLY_INSTRUCTOR, namedParameterMap);
			}
		catch(DuplicateKeyException sqlEx)
		{
			logger.error("Violation of primary key. Details : {}",sqlEx.getMessage());
			throw new NotCorrectDBRecordException(sqlEx.getMessage());
		}
	}
	
	/**
	 * 
	 * method name  : getStudentDetailsForApprovers
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBDao
	 * return type  : List<Student>
	 * 
	 * purpose		: Get list of Students details who applied for grade change
	 *
	 * Date    		:	Dec 5, 2017 8:03:58 PM
	 */
	public List<Student> getStudentDetailsForApprovers(String roleType,  Employee employee, Locale locale)
	{
		String SQL_GRADE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE);
		
		RowMapper<Student> rowMapper	=	new RowMapper<Student>()
		{
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Student			student			=	new Student();
				AcademicDetail	academicDetail	=	new AcademicDetail();
				academicDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				academicDetail.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				academicDetail.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				academicDetail.setStudentName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				academicDetail.setCollege(rs.getString(Constants.CONST_COLMN_COLLEGE_NAME));
				academicDetail.setDegree(rs.getString(Constants.CONST_COLMN_DEGREE_NAME));
				academicDetail.setCohort(rs.getInt(Constants.CONST_COLMN_COHORT));
				
				student.setAcademicDetail(academicDetail);
				
				return student;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramSupervisor", null );
		namedParameterMap.put("paramAdvisor", null);
		namedParameterMap.put("paramDeptCode", null);
		namedParameterMap.put("paramColCode", null);

		switch (roleType)
		{
			case Constants.CONST_ROLE_NAME_ADVISOR:
				namedParameterMap.put("paramAdvisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_SUPERVISOR:
				namedParameterMap.put("paramSupervisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_HOD:
				namedParameterMap.put("paramDeptCode", employee.getDepartment().getDeptCode());
				break;
			case Constants.CONST_ROLE_NAME_COL_DEAN:
				namedParameterMap.put("paramColCode", employee.getBranch().getBranchCode());
				break;	
			default:
				break;
		}
		
		
		 return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE, namedParameterMap, rowMapper);
	}

	
	/**
	 * 	
	 * method name  : getCourseListForGradeChange
	 * @param studentNo
	 * @param studentStatCode
	 * @param roleType
	 * @param employee
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: List of courses with grade change request and their approval details
	 *
	 * Date    		:	Dec 6, 2017 8:26:06 PM
	 */
	public List<GradeDTO> getCourseListForGradeChange(String studentNo, String studentStatCode, String roleType,  Employee employee, Locale locale)
	{
		String	SQL_GRADE_CHANGE_SELECT_COURSE_TEMP		=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_CHANGE_SELECT_COURSE_TEMP);
		
		RowMapper<GradeDTO> rowMapper	=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDto	=	new GradeDTO();
				Course		course		=	new Course();
				Grade		grade		=	new Grade();
				HOD			hod			=	new HOD();
				DPSAsstDean	dpsAsstDean	=	new DPSAsstDean();
				DpsDean		dpsDean		=	new DpsDean();
				
				gradeDto.setRecordSequence(rs.getString(Constants.CONST_COLMN_SEQUENCE_NO));
				gradeDto.setStudentNo(rs.getString(Constants.CONST_COLMN_STUDENT_NO));
				gradeDto.setStdStatCode(rs.getString(Constants.CONST_COLMN_STDSTATCD));
				gradeDto.setCourseYear(rs.getString(Constants.COST_COL_DPS_COURSE_YEAR));
				gradeDto.setSemester(rs.getString(Constants.COST_COL_DPS_SEMESTER_CODE));
				
				gradeDto.setSectCode(rs.getString(Constants.CONST_COLMN_SECT_CODE));
				course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
				course.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
				
				grade.setGradeValOld(rs.getString(Constants.CONST_COLMN_GRADE_VAL_OLD));
				grade.setGradeValNew(rs.getString(Constants.CONST_COLMN_GRADE_VAL_NEW));
				
				gradeDto.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
				gradeDto.setCourse(course);
				
				gradeDto.setGrade(grade);
				
				gradeDto.setStatusDesc(rs.getString(Constants.CONST_COLMN_STATUS_DESC));
				gradeDto.setComments(rs.getString(Constants.CONST_COLMN_COMMENT));
				
				
				hod.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_HOD_STATUS));
				hod.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_HOD_STATUS)));
				hod.setComments(rs.getString(Constants.CONST_COLMN_ROLE_HOD_COMMENT));

				dpsAsstDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_STATUS));
				dpsAsstDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_STATUS)));
				dpsAsstDean.setComments(rs.getString(Constants.CONST_COLMN_ROLE_DPS_ASST_DEAN_COMMENT));
				
				dpsDean.setRoleStatus(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS));
				dpsDean.setRoleStausIkon(RoleTagGlyphicon.showIkon(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_STATUS)));
				dpsDean.setComments(rs.getString(Constants.CONST_COLMN_ROLE_DPS_DEAN_COMMENT));

				gradeDto.setHod(hod);
				gradeDto.setDpsAsstDean(dpsAsstDean);
				gradeDto.setDpsDean(dpsDean);
				
				if(rs.getString(Constants.CONST_COLMN_ROLE_IS_APPROVER).equals(Constants.CONST_YES))
				{
					gradeDto.setApprover(true);
				}
				else
				{
					gradeDto.setApprover(false);
				}
				
				return gradeDto;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());

		namedParameterMap.put("paramStdNo",studentNo );
		namedParameterMap.put("paramStdStatCode",studentStatCode );
		
		namedParameterMap.put("paramEmpNo", employee.getEmpNumber());
		namedParameterMap.put("paramDeptCode", null );
		namedParameterMap.put("paramColCode", null );
		namedParameterMap.put("paramAdvisor",null );
		namedParameterMap.put("paramSupervisor",null );

		switch (roleType)
		{
			case Constants.CONST_ROLE_NAME_ADVISOR:
				namedParameterMap.put("paramAdvisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_SUPERVISOR:
				namedParameterMap.put("paramSupervisor", employee.getEmpNumber());
				break;
			case Constants.CONST_ROLE_NAME_HOD:
				namedParameterMap.put("paramDeptCode", employee.getDepartment().getDeptCode());
				break;
			case Constants.CONST_ROLE_NAME_COL_DEAN:
				namedParameterMap.put("paramColCode", employee.getBranch().getBranchCode());
				break;	
			default:
				break;		
		}

		
		namedParameterMap.put("paramFormName", Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE);
		namedParameterMap.put("paramHodRoleName", Constants.CONST_ROLE_NAME_HOD);
		namedParameterMap.put("paramADeanPRoleName", Constants.CONST_ROLE_NAME_ASST_DEAN_P );
		namedParameterMap.put("paramDeanPRoleName", Constants.CONST_ROLE_NAME_DPS_DEAN);
		
		namedParameterMap.put("paramFormName",Constants.CONST_FORM_NAME_DPS_GRADE_CHANGE );
		namedParameterMap.put("paramRoleName", roleType);

		return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_CHANGE_SELECT_COURSE_TEMP, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : setGradeChangeApproval
	 * @param gradeDTO
	 * @return
	 * GradeChangeDBImpl
	 * return type  : int
	 * 
	 * purpose		: update the status / comment for approval process
	 *
	 * Date    		:	Dec 11, 2017 8:27:04 AM
	 */
	@Transactional
	public int setGradeChangeApproval(GradeDTO gradeDTO)
	{
		
		String SQL_GRADE_CHANGE_UPDATE_APPROVAL_TEMP	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_CHANGE_UPDATE_APPROVAL_TEMP);
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramStatusCode", gradeDTO.getStatusCode());
		namedParameterMap.put("paramUserName", gradeDTO.getUserName());
		namedParameterMap.put("paramStdNo", gradeDTO.getStudentNo());
		namedParameterMap.put("paramStdStatCode", gradeDTO.getStdStatCode());
		namedParameterMap.put("paramSectCode", gradeDTO.getSectCode());
		namedParameterMap.put("paramYear", gradeDTO.getCourseYear());
		namedParameterMap.put("paramSem", gradeDTO.getSemester());
		namedParameterMap.put("paramCourseLAbrCode", gradeDTO.getCourse().getlAbrCourseNo());
		namedParameterMap.put("paramSeqNo", gradeDTO.getRecordSequence());
		return nPJdbcTemplDpsGradeChange.update(SQL_GRADE_CHANGE_UPDATE_APPROVAL_TEMP, namedParameterMap);
	}
	
	/**
	 * 
	 * method name  : getCurrentYearSem
	 * @return
	 * GradeChangeDBImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get Current Year Semester
	 *
	 * Date    		:	Dec 14, 2017 11:52:01 AM
	 */
	public YearSemester		getCurrentYearSem()
	{
		String	SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM);
		RowMapper<YearSemester> 	rowMapper	=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester yearSemester	=	new	YearSemester(); 
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		return nPJdbcTemplDpsGradeChange.queryForObject(SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM, namedParameterMap, rowMapper);
	}
	
	/**
	 * 
	 * method name  : getRuleYearSem
	 * @return
	 * GradeChangeDBImpl
	 * return type  : YearSemester
	 * 
	 * purpose		: Get Year/Semester as per the rule
	 *
	 * Date    		:	Dec 14, 2017 11:59:37 AM
	 */
	public YearSemester		getRuleYearSem()
	{
		String	SQL_GRADE_SELECT_RULE_YEAR_SEM	=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_RULE_YEAR_SEM);
		RowMapper<YearSemester> 	rowMapper	=	new RowMapper<YearSemester>()
		{
			
			@Override
			public YearSemester mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				YearSemester yearSemester	=	new	YearSemester(); 
				yearSemester.setYear(rs.getInt(Constants.COST_COL_DPS_COURSE_YEAR));
				yearSemester.setSemester(rs.getInt(Constants.COST_COL_DPS_SEMESTER_CODE));
				return yearSemester;
			}
		};
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		return nPJdbcTemplDpsGradeChange.queryForObject(SQL_GRADE_SELECT_RULE_YEAR_SEM, namedParameterMap, rowMapper);
	}
	
	
	/**
	 * 
	 * method name  : getCourseList
	 * @param isRuleGradeChangeTimingFollowed
	 * @param employeeNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<GradeDTO>
	 * 
	 * purpose		: Get List of Courses of a faculty
	 *
	 * Date    		:	Dec 14, 2017 1:10:14 PM
	 */
	public List<GradeDTO> getCourseList(boolean isRuleGradeChangeTimingFollowed, String employeeNo, Locale	locale)
	{
		String			SQL_GRADE_SELECT_COURSE_LIST		=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_COURSE_LIST);
		YearSemester	yearSemester						=	null;
		
		RowMapper<GradeDTO> 	rowMapper	=	new RowMapper<GradeDTO>()
		{
			
			@Override
			public GradeDTO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				GradeDTO	gradeDTO	=	new GradeDTO();
					Course	course	=	new Course();
					course.setlAbrCourseNo(rs.getString(Constants.CONST_COLMN_L_ABR_CRSNO));
					course.setCourseNo(rs.getString(Constants.CONST_COLMN_COURSE_NO));
					course.setCourseName(rs.getString(Constants.CONST_COLMN_COURSE_NAME));
					
					gradeDTO.setCourse(course);
					gradeDTO.setSectionNo(rs.getString(Constants.CONST_COLMN_SECTION_NO));
					
				return gradeDTO;
			}
		};
		
			yearSemester	= (isRuleGradeChangeTimingFollowed) ? getRuleYearSem() : getCurrentYearSem();
			
			Map<String,String> namedParameterMap	=	new HashMap<String,String>();
			
			namedParameterMap.put("paramLocale", locale.getLanguage());
			namedParameterMap.put("paramYear", String.valueOf(yearSemester.getYear()));
			namedParameterMap.put("paramSemester", String.valueOf(yearSemester.getSemester()));
			namedParameterMap.put("paramEmpNo", employeeNo);
			
			
			return nPJdbcTemplDpsGradeChange.query(SQL_GRADE_SELECT_COURSE_LIST, namedParameterMap, rowMapper);
			
		
	}
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param isRuleGradeChangeTimingFollowed
	 * @param employeeNo
	 * @param lAbrCourseNo
	 * @param locale
	 * @return
	 * GradeChangeDBImpl
	 * return type  : List<Student>
	 * 
	 * purpose		: List of Students teached by a faculty for a particular course at particular time
	 *
	 * Date    		:	Dec 14, 2017 3:39:51 PM
	 */
	public List<Student> getStudentList(boolean isRuleGradeChangeTimingFollowed, String employeeNo,String lAbrCourseNo,  Locale	locale)
	{
		String	SQL_GRADE_SELECT_STUDENT_LIST		=	queryGradeChange.getProperty(Constants.CONST_SQL_GRADE_SELECT_STUDENT_LIST);
		YearSemester	yearSemester						=	null;
		
		RowMapper<Student> 	rowMapper	=	new RowMapper<Student>()
		{
			
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Student			student			=	new Student();
				PersonalDetail	personalDetail	=	new PersonalDetail();
				
				personalDetail.setId(rs.getString(Constants.CONST_COLMN_STUDENT_ID));
				personalDetail.setName(rs.getString(Constants.CONST_COLMN_STUDENT_NAME));
				
				student.setPersonalDetail(personalDetail);
				return student;
			}
		};
		
		
		yearSemester	= (isRuleGradeChangeTimingFollowed) ? getRuleYearSem() : getCurrentYearSem();
		
		Map<String,String> namedParameterMap	=	new HashMap<String,String>();
		namedParameterMap.put("paramLocale", locale.getLanguage());
		namedParameterMap.put("paramYear", String.valueOf(yearSemester.getYear()));
		namedParameterMap.put("paramSemester", String.valueOf(yearSemester.getSemester()));
		namedParameterMap.put("paramEmpNo", employeeNo);
		namedParameterMap.put("paramLAbrCourseNo", lAbrCourseNo);
		
		return	nPJdbcTemplDpsGradeChange.query(SQL_GRADE_SELECT_STUDENT_LIST, namedParameterMap, rowMapper);
		
	}
	

	
}
