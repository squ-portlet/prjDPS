/**
 * Project				:	prjDPS
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	Constants.java
 * Package Name			:	om.edu.squ.squportal.portlet.dps.utility
 * Date of creation		:	Aug 16, 2015  2:30:11 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.dps.utility;

/**
 * @author Bhabesh
 *
 */
public interface Constants
{
	/************* USER TYPE ******************************/
	public static String	USER_TYPE_STUDENT												=	"student";
	public static String	USER_TYPE_EMPLOYEE												=	"employee";
	/******************************************************/
	
	/************* CONSTANT COLUMN ******************************/
	
	public static final	String	COST_COL_HRMS_EMP_CODE										=	"HRMS_EMP_CODE";
	public static final	String	COST_COL_HRMS_BRANCH_CODE									=	"HRMS_BRANCH_CODE";
	public static final	String	COST_COL_HRMS_DEPT_CODE										=	"HRMS_DEPT_CODE";
	
	
	
	public static final	String	COST_COL_DPS_EMP_NO											=	"EMPNO";
	public static final	String	COST_COL_DPS_USER_NAME										=	"USERNAME";
	public static final	String	COST_COL_DPS_USER_ACCOUNT_CODE								=	"USER_ACCT_CD";					//	This code helps to identify the user (other user might prevent)
	public static final	String	COST_COL_DPS_BRANCH_CODE									=	"BRANCH_CODE";
	public static final	String	COST_COL_DPS_DEPT_CODE										=	"DEPT_CODE";
	public static final	String	COST_COL_DPS_EMP_EMAIL										=	"EMP_EMAIL";
	public static final	String	COST_COL_DPS_EMP_NAME_EN									=	"EMP_NAME_EN";
	public static final	String	COST_COL_DPS_EMP_NAME_AR									=	"EMP_NAME_AR";
	
	public static final	String	COST_COL_DPS_COURSE_YEAR									=	"CCYRCD";
	public static final	String	COST_COL_DPS_SEMESTER_CODE									=	"SEMCD";
	public static final	String	COST_COL_DPS_FROM_COURSE_YEAR_CODE							=	"FROMCCYRCD";
	public static final	String	COST_COL_DPS_FROM_SEMESTER_CODE								=	"FROMSEMCD";
	public static final	String	COST_COL_DPS_CURRENT_YEAR									=	"CURRENT_YEAR";
	
	public static final	String	COST_COL_DPS_ABR_SEM										=	"ABR_SEM";
	public static final	String	COST_COL_DPS_SEMESTER_NAME									=	"SEM_NAME";
	public static final	String	COST_COL_DPS_TO_COURSE_YEAR_CODE							=	"TOCCYRCD";
	public static final	String	COST_COL_DPS_TO_COURSE_SEM_CODE								=	"TOSEMCD";

	
	public static final	String	COST_COL_DPS_CREATE_DATE									=	"CREATE_DATE";
	
	public static final	String	CONST_COLMN_STUDENT_ID										=	"STUDENT_ID";
	public static final	String	CONST_COLMN_STUDENT_NO										=	"STUDENT_NO";
	public static final	String	CONST_COLMN_STDSTATCD										=	"STDSTATCD";
	public static final	String	CONST_COLMN_STUDENT_NAME									=	"STUDENT_NAME";
	public static final	String	CONST_COLMN_STUDENT_NAME_ENG								=	"STUDENT_NAME_ENG";
	public static final	String	CONST_COLMN_STUDENT_NAME_AR									=	"STUDENT_NAME_AR";
	public static final	String	CONST_COLMN_STUDENT_GENDER									=	"STUDENT_GENDER";
	public static final	String	CONST_COLMN_STUDENT_HOME_REGION								=	"STUDENT_HOME_REGION";
	public static final	String	CONST_COLMN_STUDENT_HOME_WILAYAT							=	"STUDENT_HOME_WILAYAT";
	public static final	String	CONST_COLMN_STUDENT_TOWN_VILLAGE							=	"STUDENT_TOWN_VILLAGE";
	public static final	String	CONST_COLMN_STUDENT_HOME_POBOX								=	"STUDENT_HOME_POBOX";
	public static final	String	CONST_COLMN_STUDENT_HOME_POSTALCD							=	"STUDENT_HOME_POSTALCD";
	public static final	String	CONST_COLMN_STUDENT_PHONE									=	"STUDENT_PHONE";
	public static final	String	CONST_COLMN_STUDENT_EMAIL									=	"STUDENT_EMAIL";
	public static final	String	CONST_COLMN_STUDENT_HAS_THESIS								=	"HAS_THESIS";
	public static final	String	CONST_COLMN_DGR_GRAD_ESTIMATE_SEM_COUNT						=	"DGR_GRAD_ESTIMATE_SEM_COUNT";
	public static final	String	CONST_COLMN_DGR_GRAD_MAXIMUM_SEM_COUNT						=	"DGR_GRAD_MAXIMUM_SEM_COUNT";

	public static final	String	CONST_COLMN_COLLEGE_NAME									=	"COLLEGE_NAME";
	public static final	String	CONST_COLMN_COLLEGE_NAME_ENG								=	"COLLEGE_NAME_ENG";  
	public static final	String	CONST_COLMN_COLLEGE_NAME_AR									=	"COLLEGE_NAME_AR";  
	public static final	String	CONST_COLMN_MAJOR_NAME										=	"MAJOR_NAME";  
	public static final	String	CONST_COLMN_MAJOR_NAME_ENG									=	"MAJOR_NAME_ENG";
	public static final	String	CONST_COLMN_MAJOR_NAME_AR									=	"MAJOR_NAME_AR";
	public static final	String	CONST_COLMN_ADVISOR_ID										=	"ADVISOR_ID";
	public static final	String	CONST_COLMN_ADVISOR_NAME									=	"ADVISOR_NAME";
	public static final	String	CONST_COLMN_SUPERVISOR_ID									=	"SUPERVISOR_ID";
	public static final	String	CONST_COLMN_DEGREE_NAME										=	"DEGREE_NAME";
	public static final	String	CONST_COLMN_DEGREE_NAME_ENG									=	"DEGREE_NAME_ENG";
	public static final	String	CONST_COLMN_DEGREE_NAME_AR									=	"DEGREE_NAME_AR";
	public static final	String	CONST_COLMN_STATUS_NAME										=	"STATUS_NAME";  
	public static final	String	CONST_COLMN_MINOR_NAME										=	"MINOR_NAME";
	public static final	String	CONST_COLMN_SPEC_NAME										=	"SPEC_NAME";
	public static final	String	CONST_COLMN_COURSE_NO										=	"COURSE_NO";
	public static final	String	CONST_COLMN_L_ABR_CRSNO										=	"L_ABR_CRSNO";
	public static final	String	CONST_COLMN_COURSE_NAME										=	"COURSE_NAME";	
	public static final	String	CONST_COLMN_SECTION_NO										=	"SECTION_NO";
	public static final	String	CONST_COLMN_SECT_CODE										=	"SECT_CODE";
	public static final	String	CONST_COLMN_YEAR_SEM										=	"YEAR_SEM";
	public static final	String	CONST_COLMN_CREDITS											=	"CREDITS";
	public static final	String	CONST_COLMN_TUTION_FEE										=	"TUTION_FEE";
	public static final	String	CONST_COLMN_STUDENT_MODE									=	"STD_MODE";
	public static final	String	CONST_COLMN_GRADE_CODE										=	"GRADE_CODE";
	public static final	String	CONST_COLMN_GRADE_VAL										=	"GRADE_VAL";
	public static final	String	CONST_COLMN_GRADE_VAL_OLD									=	"GRADE_VAL_OLD";
	public static final	String	CONST_COLMN_GRADE_VAL_NEW									=	"GRADE_VAL_NEW";
	public static final	String	CONST_COLMN_GRADE_IS_INCOMPLETE_GRADE						=	"IS_INCOMPLETE_GRADE";

	public static final	String	CONST_COLMN_SISCODECD										=	"SISCODECD";
	public static final	String	CONST_COLMN_SISCODENAME										=	"SIS_CODE_NAME";
	public static final	String	CONST_COLMN_STATUS_CODE										=	"STATUS_CODE";
	public static final	String	CONST_COLMN_STATUS_CODE_NAME								=	"STATUS_CODE_NAME";
	public static final	String	CONST_COLMN_STATUS_DESC										=	"STATUS_DESC";
	public static final	String	CONST_COLMN_STATUS_DESC_EN									=	"STATUS_DESC_EN";
	public static final	String	CONST_COLMN_STATUS_DESC_AR									=	"STATUS_DESC_AR";
	public static final	String	CONST_COLMN_COHORT											=	"COHORT";
	public static final	String	CONST_COLMN_COMMENT											=	"COMMENTS";
	public static final	String	CONST_COLMN_REASON											=	"REASON";
	
	public static final	String	CONST_COLMN_EXTENSION_REASON_CODE							=	"EXTENSION_REASON_CODE";
	public static final	String	CONST_COLMN_EXTENSION_REASON_NAME							=	"EXTENSION_REASON_NAME";
	public static final	String	CONST_COLMN_EXTENSION_OTHER_REASON							=	"EXTENSION_OTHER_REASON";
	
	public static final	String	CONST_COLMN_FIRST_WITHDRAW_DATE								=	"FIRST_WITHDRAW_DATE";
	public static final	String	CONST_COLMN_SECOND_WITHDRAW_DATE							=	"SECOND_WITHDRAW_DATE";
	
	public static final	String	CONST_COLMN_POSTPONE_REASON_CODE							=	"POSTPONE_REASON_CODE";
	public static final	String	CONST_COLMN_POSTPONE_REASON_NAME							=	"POSTPONE_REASON_NAME";
	public static final	String	CONST_COLMN_POSTPONE_OTHER_REASON							=	"POSTPONE_OTHER_REASON";
	
	public static final	String	CONST_COLMN_UNIVERSITY_WITHDRAW_STD_REASON_CODE				=	"UNIVERSITY_STD_REASON_CODE";
	public static final	String	CONST_COLMN_UNIVERSITY_WITHDRAW_STD_REASON_NAME				=	"UNIVERSITY_STD_REASON_NAME";
	
	public static final	String	CONST_COLMN_POSTPONE_GRADE_IS_UPDATABLE						=	"IS_UPDATABLE";
	public static final	String	CONST_COLMN_IS_CHANGE_ALLOWED								=	"CHANGE_ALLOWED";
	public static final	String	CONST_COLMN_RECORD_AVAILABLE								=	"RECORD_AVAILABLE";
	
	public static final	String	CONST_COLMN_APPROVAL_CODE									=	"APPROVAL_CODE";
	public static final	String	CONST_COLMN_APPROVER_ROLE_CODE								=	"APPROVER_ROLE_CODE";
	public static final	String	CONST_COLMN_APPROVER_ROLE_NAME								=	"APPROVER_ROLE_NAME";
	public static final	String	CONST_COLMN_APPROVER_ROLE_NAME_ENG							=	"APPROVER_ROLE_NAME_ENG";
	public static final	String	CONST_COLMN_APPROVER_ROLE_NAME_AR							=	"APPROVER_ROLE_NAME_AR";
	public static final	String	CONST_COLMN_APPROVAL_SEQUENCE								=	"APPROVAL_SEQUENCE";
	public static final	String	CONST_COLMN_APPROVAL_MAX_SEQUENCE							=	"APPROVAL_MAX_SEQUENCE";
	public static final	String	CONST_COLMN_APPROVAL_CODE_ADVISOR 							=	"ADVISOR_APPROVAL_CODE";
	public static final	String	CONST_COLMN_APPROVAL_CODE_SUPERVISOR						=	"SUPERVISOR_APPROVAL_CODE";
	public static final	String	CONST_COLMN_APPROVAL_CODE_COLLEGE_DEAN						=	"COLLEGE_DEAN_APPROVAL_CODE";
	public static final	String	CONST_COLMN_APPROVAL_CODE_DPS_DEAN							=	"DPS_DEAN_APPROVAL_CODE";
	
	
	public static final	String	CONST_COLMN_ROLE_HOD_STATUS									=	"HOD_STATUS";
	public static final	String	CONST_COLMN_ROLE_ADVISOR_STATUS								=	"ADVISOR_STATUS";
	public static final	String	CONST_COLMN_ROLE_SUPERVISOR_STATUS							=	"SUPERVISOR_STATUS";
	public static final	String	CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS						=	"COLLEGE_DEAN_STATUS";
	public static final	String	CONST_COLMN_ROLE_DPS_ASST_DEAN_STATUS						=	"DPS_ASST_DEAN_STATUS";
	public static final	String	CONST_COLMN_ROLE_DPS_DEAN_STATUS							=	"DPS_DEAN_STATUS";
	
	public static final	String	CONST_COLMN_ROLE_HOD_COMMENT								=	"HOD_COMMENT";
	public static final	String	CONST_COLMN_ROLE_ADVISOR_COMMENT							=	"ADVISOR_COMMENT";
	public static final	String	CONST_COLMN_ROLE_SUPERVISOR_COMMENT							=	"SUPERVISOR_COMMENT";
	public static final	String	CONST_COLMN_ROLE_COLLEGE_DEAN_COMMENT						=	"COLLEGE_DEAN_COMMENT";
	public static final	String	CONST_COLMN_ROLE_DPS_ASST_DEAN_COMMENT						=	"DPS_ASST_DEAN_COMMENT";
	public static final	String	CONST_COLMN_ROLE_DPS_DEAN_COMMENT							=	"DPS_DEAN_COMMENT";
	
	
	public static final	String	CONST_COLMN_ROLE_IS_APPROVER								=	"IS_APPROVER";
	
	public static final	String	CONST_COLMN_SEQUENCE_NO										=	"SEQUENCE_NUMBER";
	
	public static final	String	CONST_COLMN_DELEGATE_USER_DELEGATED							=	"DELEGATED";
	public static final	String	CONST_COLMN_DELEGATE_USER_DELEGATEE							=	"DELEGATEE";
	public static final	String	CONST_COLMN_DELEGATED_FROM									=	"DELEGATED_FROM";
	public static final	String	CONST_COLMN_DELEGATED_TO									=	"DELEGATED_TO";
	
	public static final	String	CONST_COLMN_DUMMY_DATE_01									=	"01/01/0000";
	
	public static final boolean	CONST_IS_DELEGATION											=	true;	
	public static final boolean	CONST_DELEGATED_APPROVER_DEFAULT_ELIGIBLE					=	false;							//	Flag for default approving for delegatee
	public static final boolean	CONST_DELEGATION_APPROVE_ELIGIBLE							=	true;
	public static final boolean	CONST_DELEGATION_APPROVE_NOT_ELIGIBLE						=	false;
	
	public static final String	CONST_PARAM_NAME_STUDENT_NO									=	"paramStudentNo";
	public static final String	CONST_PARAM_NAME_FORM_NAME									=	"paramFormName";
	public static final String	CONST_PARAM_NAME_ROLE_NAME									=	"paramRoleName";
	public static final String	CONST_PARAM_NAME_IS_SEQUENCE_REQUIRED						=	"paramNextSequence";
	public static final	String	CONST_PARAM_NAME_APPROVER_NAME_ENG							=	"paramApproverNameEng";
	public static final	String	CONST_PARAM_NAME_APPROVER_NAME_AR							=	"paramApproverNameAr";
	public static final	String	CONST_PARAM_NAME_APPROVER_EMAIL								=	"paramApproverEmail";
	public static final String	CONST_PARAM_NAME_APPROVER_PHONE								=	"paramApproverPhone";
	public static final	String	CONST_PARAM_NAME_ROLE_NAME_ENG								=	"paramApproverRoleEn";
	public static final	String	CONST_PARAM_NAME_ROLE_NAME_AR								=	"paramApproverRoleAr";
	public static final	String	CONST_PARAM_NAME_IS_HIGHER_APPROVER							=	"paramApproverIsNext";
	
	public static final String	CONST_YES													=	"Y";
	public static final String	CONST_NO													=	"N";
	
	public static final String	CONST_NOT_USED												=	"NU";
	public static final String	CONST_NOT_AVAILABLE											=	"NA";
	
	public static final String	CONST_FULL_TIME												=	"FULL";
	public static final String	CONST_PART_TIME												=	"PART";
	
	public static final int		CONST_FULL_TIME_ALLOWED_CREDIT_AFTER_DROP					=	9;
	public static final int		CONST_PART_TIME_ALLOWED_CREDIT_AFTER_DROP					=	3;
	
	/******************************************************/
	public static final	String	CONST_SQL_STATUS_CODE_PENDING								=	"5539";
	public static final	String	CONST_SQL_STATUS_CODE_NAME_MODFY							=	"MODFY";
	public static final	String	CONST_SQL_STATUS_CODE_NAME_PROGRESS							=	"PRGRS";
	public static final	String	CONST_SQL_STATUS_CODE_NAME_PENDING							=	"PENDG";
	public static final	String	CONST_SQL_STATUS_CODE_REJCT									=	"REJCT";
	public static final	String	CONST_SQL_STATUS_CODE_ACCPT									=	"ACCPT";
	
	public static final	String	CONST_RULE_DROP_W_PERIOD_APPLIED							=	"1";
	public static final	String	CONST_RULE_DROP_W_PERIOD_NOT_APPLIED						=	"0";
	public static final	String	CONST_RULE_DROP_W_STUDENT_MODE_NOT_APPLIED					=	"NOT_AVAILABLE";
	
	
	public static final	int		CONST_RULE_POSTPONE_STUDENT_MAXIMUM_ALLOWED					=	2;
	
	/************* SQL CONSTANT STATUS CODE ******************************/
	
	/************* SQL CONSTANT ROLE CODE ******************************/
/*	
	public static final	String	CONST_SQL_ROLE_SUPERVISOR									=	"2012";   // SUPRVS
	public static final	String	CONST_SQL_ROLE_COL_DEAN										=	"1883";	  // DEAN
	public static final	String	CONST_SQL_ROLE_DPS_DEAN										=	"5548";
	
*/	public static final	String	CONST_SQL_ROLE_NAME_HOD										=	"HOD"; 
	public static final	String	CONST_SQL_ROLE_NAME_ADVISOR									=	"ADVISOR";
	public static final	String	CONST_SQL_ROLE_NAME_SUPERVISOR								=	"SUPRVS";   
	public static final	String	CONST_SQL_ROLE_NAME_COL_DEAN								=	"DEAN";	  
	public static final	String	CONST_SQL_ROLE_NAME_DPS_DEAN								=	"DEANP";
	public static final	String	CONST_SQL_ROLE_NAME_DPS_ASSISTANT_DEAN						=	"ADEANP"; 
	public static final	String	CONST_SQL_ROLE_NAME_DPS_STAFF								=	"DPS"; 
	
	/******************************************************/
	
	/************* SQL CONSTANT DPS FORM CODE ******************************/
//	public static final	String	CONST_FORM_DPS_EXTENSION_STUDY								=	"3413";

	public static final	String	CONST_FORM_NAME_DPS_DROP_W									=	"DPS7";
	public static final	String	CONST_FORM_NAME_DPS_INCOMPLETE_GRADE_NOTIFY					=	"DPS8";
	public static final	String	CONST_FORM_NAME_DPS_GRADE_CHANGE							=	"DPS9"; 
	public static final	String	CONST_FORM_NAME_DPS_UNIVERSITY_WITHDRAWAL					=	"DPS11";
	public static final	String	CONST_FORM_NAME_DPS_POSTPONE_STUDY							=	"DPS13";
	public static final	String	CONST_FORM_NAME_DPS_EXTENSION_STUDY							=	"DPS19";
	
	
	
	
	/************* PROPERTY FILE ******************************/
	public	static	String	RESOURCE_PROPERTY_FILE_NAME										=	"messages";
	public	static	String	RESOURCE_PROPERTY_FILE_NAME_EXTENSION							=	"extension";
	

	
	/******************************************************/
	
	/************* SQL - HRMS ******************************/
	
	public static final	String	COST_SQL_DPS_HRMS_EMPLOYEE_DETAIL							=	"dps.hrms.select.employee.detail";
	/******************************************************/
	
	/************* SQL - DPS ******************************/
	
	public	static	final	String	CONST_SQL_DPS_CURRENT_YR_SEM							=	"dps.select.current.yr.sem";
	public	static	final	String	CONST_SQL_DPS_NEXT_YR_SEM								=	"dps.select.next.yr.sem";
	public 	static	final	String	COST_SQL_DPS_EMPLOYEE_DETAIL							=	"dps.select.employee.detail";
	public	static 	final	String	SQL_PERSONAL_DETAIL_STUDENT								=	"personal.details.of.student";
	public	static	final	String	SQL_ACADEMIC_DETAIL_STUDENT								=	"academic.details.of.student";
	public	static	final	String	CONST_SQL_STUDENT_MODE									=	"dps.select.student.mode";				//Full Time / Part Time etc
	public	static	final	String	CONST_SQL_STUDENT_TOTAL_CREDIT							=	"dps.select.student.total.registered.credit";
	public	static	final	String	CONST_SQL_STUDENT_SELECTED_COURSE_CREDIT				=	"dps.select.student.selected.registered.course.credit";
	
	public static 	final	String	CONST_SP_APPROVER_NEXT									=	"dps.stored.procedure.sp.approver.next";
	public static 	final	String	CONST_SQL_FUNC_IS_SUPERVISOR_AVAILABLE					=	"dps.function.is.supervisor.available";
	public	static	final	String	CONST_SQL_SEQUENCE_NUM									=	"dps.sequence.no";
	
	/* ---  SQL - DPS - Extension property--------------------- */
	public	static	final	String	CONST_SQL_EXTENSION_REASONS								=	"dps.extension.select.extension.reasons";
	public	static	final	String	CONST_SQL_EXTENSION_INSERT_STUDENT						=	"dps.extension.insert.student";
	public	static	final	String	CONST_SQL_EXTENSION_UPDATE_STATUS_STUDENT				=	"dps.extension.update.status.student";
	public	static	final	String	CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS				=	"dps.extension.select.student.records";
	public	static	final	String	CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	"dps.extension.select.student.records.by.employee";

	/* ---  SQL - DPS - Drop With W property--------------------- */
	public	static	final	String	CONST_SQL_DROPW_SELECT_COURSE_DETAILS					=	"dps.dropw.select.course.details";
	public	static	final	String	CONST_SQL_DROPW_INSERT_COURSE_TEMP						=	"dps.dropw.insert.course.temp.for.drop";
	public	static	final	String	CONST_SQL_DROPW_SELECT_COURSE_TEMP						=	"dps.dropw.select.course.temp.for.drop";
	public	static	final	String	CONST_SQL_DROPW_SELECT_STUDENT_RECORDS_BY_EMPLOYEE		=	"dps.dropw.select.student.records.by.employee";
	public	static	final	String	CONST_SQL_DROPW_UPDATE_COURSE_TEMP						=	"dps.dropw.update.course.temp.for.drop";
	
	/* ---  SQL - DPS - Postponement of Studies property--------------------- */
	public	static	final	String	CONST_SQL_POSTPONE_SELECT_EXISTING_GRADES				=	"dps.postpone.select.existing.grade";
	public	static	final	String	CONST_SQL_POSTPONE_REASONS								=	"dps.postpone.select.postpone.reasons";
	public	static	final	String	CONST_SQL_POSTPONE_SELECT_RECORDS_BY_STUDENT			=	"dps.postpone.select.student.records";
	public	static	final	String	CONST_SQL_POSTPONE_INSERT_STUDENT						=	"dps.postpone.insert.student";
	public	static	final	String	CONST_SQL_POSTPONE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	"dps.postpone.select.student.records.by.employee";
	public	static	final	String	CONST_SQL_POSTPONE_UPDATE_STATUS_STUDENT				=	"dps.postpone.update.status.student";
	
	/* ---  SQL - DPS - Grade Change property--------------------- */
	public	static	final	String	CONST_SQL_GRADE_SELECT_COURSE_LIST						=	"dps.grades.select.course.list";
	public	static	final	String	CONST_SQL_GRADE_SELECT_STUDENT_LIST						=	"dps.grades.select.student.list";
	public	static	final	String	CONST_SQL_GRADE_CHANGE_STUDENT_LIST_OF_EXISTING_GRADE	=	"dps.grades.select.student.grades";
	public	static	final	String	CONST_SQL_GRADE_VALUE_LIST								=	"dps.grades.select.grade.values";
	public	static	final	String	CONST_SQL_GRADE_SELECT_HISORY							=	"dps.grades.select.grade.change.history";
	public	static	final	String	CONST_SQL_GRADE_INSERT_APPLY_INSTRUCTOR					=	"dps.grades.insert.grade.apply.instructor";
	public	static	final	String	CONST_SQL_GRADE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE		=	"dps.grades.select.student.records.by.employee";
	public	static	final	String	CONST_SQL_GRADE_CHANGE_SELECT_COURSE_TEMP				=	"dps.grade.select.course.temp.for.grade.change";
	public	static	final	String	CONST_SQL_GRADE_CHANGE_UPDATE_APPROVAL_TEMP				=	"dps.grades.update.grade.change.approval.by.approver";
	public	static	final	String	CONST_SQL_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM		=	"dps.grades.select.rule.test.current.year.sem";
	public	static	final	String	CONST_SQL_GRADE_SELECT_RULE_YEAR_SEM					=	"dps.grades.select.rule.grade.change.year.sem";
	
	/* ---  SQL - DPS - Incomplete Grade Notification property ------------------ */
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_COURSE_LIST			=	"dps.incomplete.grade.select.course.list";	
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_RULE_TEST_CURRENT_YEAR_SEM		=	"dps.incomplete.grades.select.rule.test.current.year.sem";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_RULE_YEAR_SEM			=	"dps.incomplete.grades.select.rule.grade.change.year.sem";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_STUDENT_LIST			=	"dps.incomplete.grades.select.students";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_INSERT_NOTIFY_INSTRUCTOR		=	"dps.incomplete.grades.insert.notify.by.instructor";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_INSTRUCTOR_COMMENTS	=	"dps.incomplete.grades.select.instructor.comments";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_HISORY				=	"dps.incomplete.grades.select.notify.history";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	"dps.incomplete.grades.select.student.records.by.employee";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_SELECT_NOTIFY				=	"dps.incomplete.grades.select.course.temp.for.notify";
	public	static	final	String	CONST_SQL_INCOMPLETE_GRADE_CHANGE_UPDATE_APPROVAL_TEMP	=	"dps.incomplete.grades.update.approval.by.approver";
	
	/* ---  SQL - DPS - Withdraw from University property ------------------ */
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_COUNT_REC					=	"dps.university.withdraw.select.count.rec";
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_COUNT_REJECT				=	"dps.university.withdraw.select.count.reject";
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_REASON_LIST_STUDENT		=	"dps.university.withdraw.select.reason.list.student";
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_INSERT_APPLY_BY_STUDENT	=	"dps.university.withdraw.insert.apply.by.student";
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_SELECT_RECORDS_BY_STUDENT	=	"dps.university.withdraw.select.student.records";
	public	static	final	String	CONST_SQL_UNIVERSITY_WITHDRAW_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	"dps.university.withdraw.select.student.records.by.employee";
	
	/* --- SQL - DPS - Delegation ---------------------------------------------- */
	public	static	final	String	CONST_SQL_DELEGATE_SELECT_DELEGATED						=	"dps.delegate.select.delegated";
	public	static	final	String	CONST_SQL_DELEGATE_SELECT_DELEGATEE						=	"dps.delegate.select.delegatee";

	/* ---  SQL - DPS - Drop With W -- Stored Procedure -- --------------------- */	
	public	static	final	String	CONST_PROC_DROPW_WITHDRAW_COURSE						=	"WEB_PKG.WITHDRAW_COURSE_DPS";
	
	public	static	final	String	CONST_PROC_COL_NAME_P_STDNO								=	"p_stdno";
	public	static	final	String	CONST_PROC_COL_NAME_P_SECTCD							=	"p_sectcd";
	public	static	final	String	CONST_PROC_COL_NAME_P_SECTNO							=	"p_sectno";
	public	static	final	String	CONST_PROC_COL_NAME_P_USER								=	"p_user";
	
	/* ---  SQL - DPS - Rule --------------------- */
	public	static	final	String	CONST_PROP_SQL_RULE_STUDENT_JOIN_CLOSE_TIME				=	"sql.rule.student.join.close.time";	
	public	static	final	String	CONST_PROP_SQL_RULE_STUDENT_LANGUAGE_COURSE_TAKEN		=	"sql.rule.student.language.course.from.course.start";
	public	static	final	String	CONST_PROP_SQL_RULE_STUDENT_POSTPONE_COUNT				=	"sql.rule.student.count.postpone";
	public	static	final	String	CONST_PROP_SQL_RULE_CURRENT_YEAR_SEMESTER				=	"sql.rule.current.year.semester";
	public	static	final	String	CONST_PROP_SQL_RULE_THESIS_CODE							=	"sql.rule.thesis.code";
	public	static	final	String	CONST_PROP_SQL_RULE_SEMINAR_RECORD_COUNT				=	"sql.rule.seminar.complete.record.count";
	public	static	final	String	CONST_PROP_SQL_RULE_CURR_DATE_IN_SPECIFIC_WEEK			=	"sql.rule.current.date.in.specific.week";
	
	public	static	final	String	CONST_PROP_SQL_RULE_STUDENT_EXTENSION_COUNT				=	"sql.rule.service.extension.select.count.student";
	public	static	final	String	CONST_PROP_SQL_RULE_STUDENT_DROP_W_PERIOD				=	"sql.rule.service.dropw.withdraw.preriod";

	
	/* ---  SQL - DPS - Role --------------------- */
	public	static	final	String	CONST_PROP_SQL_STATUS_DESCRIPTION						=	"sql.status.description";
	public	static	final	String	CONST_PROP_SQL_ROLE_STATUS_DESCRIPTION					=	"sql.role.status.description.for.form.and.role";
	public	static	final	String	CONST_PROP_SQL_ROLE_LIST_FORM							=	"sql.role.sequence.rolename.list.by.form";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_SUPERVISOR						=	"sql.role.is.supervisor";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_ADVISOR							=	"sql.role.is.advisor";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_HOD								=	"sql.role.is.hod";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_POST_GRAD_ASST_DEAN				=	"sql.role.is.college.post.graduate.asst.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_COLLEGE_DEAN						=	"sql.role.is.extension.col.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_DPS_DEAN							=	"sql.role.is.dps.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_DPS_ADMIN_STAFF					=	"sql.role.is.college.post.graduate.dps.admin.staff";
	public	static	final	String	CONST_PROP_SQL_ROLE_APPROVAL_CODE						=	"sql.role.approval.code";
	public	static	final	String	CONST_PROP_SQL_ROLE_STATUS_CODE							=	"sql.role.status.code";
	
	public	static	final	String	CONST_PROP_SQL_ROLE_APPROVAL_TRANSACTION				=	"sql.role.approval_transaction.insert";


	public	static	final	String	CONST_ROLE_NAME_ADVISOR									=	"ADVISOR";
	public	static	final	String	CONST_ROLE_NAME_SUPERVISOR								=	"SUPRVS";
	public	static	final	String	CONST_ROLE_NAME_HOD										=	"HOD";
	public	static	final	String	CONST_ROLE_NAME_ASST_DEAN_P								=	"ADEANP";
	public	static	final	String	CONST_ROLE_NAME_COL_DEAN								=	"DEAN";
	public	static	final	String	CONST_ROLE_NAME_DPS_DEAN								=	"DEANP";
	public	static	final	String	CONST_ROLE_NAME_DPS_STAFF								=	"DPS";
	public	static	final	String	CONST_ROLE_NAME_DPS_ADMIN_STAFF							=	"ADMINP";
	
	
	public	static	final	String	CONST_THESIS_SEMINAR_SEMINAR_01							=	"SEM1";
	public	static	final	String	CONST_WEEK_10											=	"10";

	public	static	final	String	CONST_REQUEST_CODE_DEFAULT								=	"0";
	
	/** ================ DPS - ROLE ===================== */
		/* ---  DPS - Role - xml file --------------------- */
	public	static	final	String	CONST_FILE_ROLE_EXTENTION								=	"role/role_extension.xml";
	
	/******************************************************/
	
	/************* DPS - NOTIFICATION ******************************/
	public	static	final	String	CONST_NOTIFICATION_TYPE_EMAIL							=	"EMAIL";
	public	static	final	String	CONST_NOTIFICATION_TYPE_SMS								=	"SMS";
	
	public	static	final	String	CONST_NOTIFICATION_FORM_TYPE_GENERAL					=	"GEN";
	public	static	final	String	CONST_NOTIFICATION_FORM_TYPE_EXTENSION					=	"EXT";
	
	public	static	final	String	TEMPLATE_NOTIFICATION_STUDENT_EMAIL						=	"TEMPLATE_EMAIL_STUDENT";
	public	static	final	String	TEMPLATE_NOTIFICATION_APPROVER_EMAIL					=	"TEMPLATE_EMAIL_APPROVER";
	public	static	final	String	TEMPLATE_NOTIFICATION_HIGHER_APPROVER_EMAIL				=	"TEMPLATE_EMAIL_HIGHER_APPROVER";
	
	public	static	final	String	TEMPLATE_NOTIFICATION_STUDENT_SMS						=	"TEMPLATE_SMS_STUDENT";
	
	
	
	public	static	final	boolean	CONST_TEST_ENVIRONMENT									=	true;
	public	static	final	String	CONST_EMAIL_FROM										=	"dps_eservices@squ.edu.om";
	public	static	final	String	CONST_DUMMY_USER_EMAIL_TO								=	"bhabesh@squ.edu.om";

	public	static	final	String	CONST_DUMMY_USER_SMS_TO									=	"----"; //TODO Change to phone number only in development environment 
	
	
}
