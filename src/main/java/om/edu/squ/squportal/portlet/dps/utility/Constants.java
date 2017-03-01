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
	public static String	USER_TYPE_STUDENT									=	"student";
	public static String	USER_TYPE_EMPLOYEE									=	"employee";
	/******************************************************/
	
	/************* CONSTANT COLUMN ******************************/
	
	public static final	String	COST_COL_HRMS_EMP_CODE							=	"HRMS_EMP_CODE";
	public static final	String	COST_COL_HRMS_BRANCH_CODE						=	"HRMS_BRANCH_CODE";
	public static final	String	COST_COL_HRMS_DEPT_CODE							=	"HRMS_DEPT_CODE";
	
	
	
	public static final	String	COST_COL_DPS_EMP_NO								=	"EMPNO";
	public static final	String	COST_COL_DPS_USER_NAME							=	"USERNAME";
	public static final	String	COST_COL_DPS_BRANCH_CODE						=	"BRANCH_CODE";
	public static final	String	COST_COL_DPS_DEPT_CODE							=	"DEPT_CODE";
	public static final	String	COST_COL_DPS_EMP_EMAIL							=	"EMP_EMAIL";
	
	public static final	String	COST_COL_DPS_COURSE_YEAR						=	"CCYRCD";
	public static final	String	COST_COL_DPS_SEMESTER_CODE						=	"SEMCD";
	public static final	String	COST_COL_DPS_ABR_SEM							=	"ABR_SEM";
	public static final	String	COST_COL_DPS_SEMESTER_NAME						=	"SEM_NAME";
	public static final	String	COST_COL_DPS_TO_COURSE_YEAR_CODE				=	"TOCCYRCD";
	public static final	String	COST_COL_DPS_TO_COURSE_SEM_CODE					=	"TOSEMCD";

	
	public static final	String	COST_COL_DPS_CREATE_DATE						=	"CREATE_DATE";
	
	public static final	String	CONST_COLMN_STUDENT_ID							=	"STUDENT_ID";
	public static final	String	CONST_COLMN_STUDENT_NO							=	"STUDENT_NO";
	public static final	String	CONST_COLMN_STDSTATCD							=	"STDSTATCD";
	public static final	String	CONST_COLMN_STUDENT_NAME						=	"STUDENT_NAME";
	public static final	String	CONST_COLMN_STUDENT_HOME_REGION					=	"STUDENT_HOME_REGION";
	public static final	String	CONST_COLMN_STUDENT_HOME_WILAYAT				=	"STUDENT_HOME_WILAYAT";
	public static final	String	CONST_COLMN_STUDENT_TOWN_VILLAGE				=	"STUDENT_TOWN_VILLAGE";
	public static final	String	CONST_COLMN_STUDENT_HOME_POBOX					=	"STUDENT_HOME_POBOX";
	public static final	String	CONST_COLMN_STUDENT_HOME_POSTALCD				=	"STUDENT_HOME_POSTALCD";
	public static final	String	CONST_COLMN_STUDENT_PHONE						=	"STUDENT_PHONE";
	public static final	String	CONST_COLMN_STUDENT_EMAIL						=	"STUDENT_EMAIL";

	public static final	String	CONST_COLMN_COLLEGE_NAME						=	"COLLEGE_NAME";             
	public static final	String	CONST_COLMN_MAJOR_NAME							=	"MAJOR_NAME";  
	public static final	String	CONST_COLMN_ADVISOR_ID							=	"ADVISOR_ID";
	public static final	String	CONST_COLMN_ADVISOR_NAME						=	"ADVISOR_NAME";
	public static final	String	CONST_COLMN_SUPERVISOR_ID						=	"SUPERVISOR_ID";
	public static final	String	CONST_COLMN_DEGREE_NAME							=	"DEGREE_NAME";          
	public static final	String	CONST_COLMN_STATUS_NAME							=	"STATUS_NAME";  
	public static final	String	CONST_COLMN_MINOR_NAME							=	"MINOR_NAME";
	public static final	String	CONST_COLMN_SPEC_NAME							=	"SPEC_NAME";
	
	public static final	String	CONST_COLMN_SISCODECD							=	"SISCODECD";
	public static final	String	CONST_COLMN_STATUS_CODE							=	"STATUS_CODE";
	public static final	String	CONST_COLMN_STATUS_DESC							=	"STATUS_DESC";
	public static final	String	CONST_COLMN_COHORT								=	"COHORT";
	
	public static final	String	CONST_COLMN_EXTENSION_REASON_CODE				=	"EXTENSION_REASON_CODE";
	public static final	String	CONST_COLMN_EXTENSION_REASON_NAME				=	"EXTENSION_REASON_NAME";
	public static final	String	CONST_COLMN_EXTENSION_OTHER_REASON				=	"EXTENSION_OTHER_REASON";
	
	public static final	String	CONST_COLMN_APPROVAL_CODE						=	"APPROVAL_CODE";
	public static final	String	CONST_COLMN_APPROVER_ROLE_CODE					=	"APPROVER_ROLE_CODE";
	public static final	String	CONST_COLMN_APPROVAL_SEQUENCE					=	"APPROVAL_SEQUENCE";
	public static final	String	CONST_COLMN_APPROVAL_MAX_SEQUENCE				=	"APPROVAL_MAX_SEQUENCE";
	
	public static final	String	CONST_COLMN_ROLE_SUPERVISOR_STATUS				=	"SUPERVISOR_STATUS";
	public static final	String	CONST_COLMN_ROLE_COLLEGE_DEAN_STATUS			=	"COLLEGE_DEAN_STATUS";
	public static final	String	CONST_COLMN_ROLE_DPS_DEAN_STATUS				=	"DPS_DEAN_STATUS";
	
	public static final	String	CONST_COLMN_ROLE_IS_APPROVER					=	"IS_APPROVER";
	
	/******************************************************/
	public static final	String	CONST_SQL_STATUS_CODE_PENDING					=	"5539";
	public static final	String	CONST_SQL_STATUS_CODE_NAME_MODFY				=	"MODFY";
	public static final	String	CONST_SQL_STATUS_CODE_NAME_PENDING				=	"PENDG";
	public static final	String	CONST_SQL_STATUS_CODE_REJCT						=	"REJCT";
	public static final	String	CONST_SQL_STATUS_CODE_ACCPT						=	"ACCPT";
	
	/************* SQL CONSTANT STATUS CODE ******************************/
	
	/************* SQL CONSTANT ROLE CODE ******************************/
	public static final	String	CONST_SQL_ROLE_SUPERVISOR						=	"2012";   // SUPRVS
	public static final	String	CONST_SQL_ROLE_COL_DEAN							=	"1883";	  // DEAN
	public static final	String	CONST_SQL_ROLE_DPS_DEAN							=	"5548";
	
	
	/******************************************************/
	
	/************* SQL CONSTANT DPS FORM CODE ******************************/
	public static final	String	CONST_FORM_DPS_EXTENSION_STUDY					=	"3413";
	public static final	String	CONST_FORM_NAME_DPS_EXTENSION_STUDY				=	"DPS19";
	
	/************* PROPERTY FILE ******************************/
	public	static	String	RESOURCE_PROPERTY_FILE_NAME							=	"messages";

	
	/******************************************************/
	
	/************* SQL - HRMS ******************************/
	
	public static final	String	COST_SQL_DPS_HRMS_EMPLOYEE_DETAIL				=	"dps.hrms.select.employee.detail";
	/******************************************************/
	
	/************* SQL - DPS ******************************/
	
	public	static	final	String	CONST_SQL_DPS_CURRENT_YR_SEM				=	"dps.select.current.yr.sem";
	public	static	final	String	CONST_SQL_DPS_NEXT_YR_SEM					=	"dps.select.next.yr.sem";
	public 	static	final	String	COST_SQL_DPS_EMPLOYEE_DETAIL				=	"dps.select.employee.detail";
	public	static 	final	String	SQL_PERSONAL_DETAIL_STUDENT					=	"personal.details.of.student";
	public	static	final	String	SQL_ACADEMIC_DETAIL_STUDENT					=	"academic.details.of.student";
	
	/* ---  SQL - DPS - Extension property--------------------- */
	public	static	final	String	CONST_SQL_EXTENSION_REASONS					=	"dps.extension.select.extension.reasons";
	public	static	final	String	CONST_SQL_EXTENSION_INSERT_STUDENT			=	"dps.extension.insert.student";
	public	static	final	String	CONST_SQL_EXTENSION_UPDATE_STATUS_STUDENT	=	"dps.extension.update.status.student";
	public	static	final	String	CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS	=	"dps.extension.select.student.records";
	public	static	final	String	CONST_SQL_EXTENSION_SELECT_STUDENT_RECORDS_BY_EMPLOYEE	=	"dps.extension.select.student.records.by.employee";
	
	/* ---  SQL - DPS - Role --------------------- */
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_SUPERVISOR			=	"sql.role.is.supervisor";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_ADVISOR				=	"sql.role.is.advisor";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_HOD					=	"sql.role.is.hod";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_POST_GRAD_ASST_DEAN	=	"sql.role.is.college.post.graduate.asst.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_COLLEGE_DEAN			=	"sql.role.is.extension.col.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_IS_DPS_DEAN				=	"sql.role.is.dps.dean";
	public	static	final	String	CONST_PROP_SQL_ROLE_APPROVAL_CODE			=	"sql.role.approval.code";
	public	static	final	String	CONST_PROP_SQL_ROLE_STATUS_CODE				=	"sql.role.status.code";
	
	public	static	final	String	CONST_PROP_SQL_ROLE_APPROVAL_TRANSACTION	=	"sql.role.approval_transaction.insert";


	public	static	final	String	CONST_ROLE_NAME_ADVISOR						=	"ADVISOR";
	public	static	final	String	CONST_ROLE_NAME_SUPERVISOR					=	"SUPRVS";
	public	static	final	String	CONST_ROLE_NAME_HOD							=	"HOD";
	public	static	final	String	CONST_ROLE_NAME_ASST_DEAN					=	"ADEANP";
	public	static	final	String	CONST_ROLE_NAME_COL_DEAN					=	"DEAN";
	public	static	final	String	CONST_ROLE_NAME_DPS_DEAN					=	"DEANP";
	public	static	final	String	CONST_ROLE_NAME_DPS_STAFF					=	"DPS";
	
	/** ================ DPS - ROLE ===================== */
		/* ---  DPS - Role - xml file --------------------- */
	public	static	final	String	CONST_FILE_ROLE_EXTENTION					=	"role/role_extension.xml";
	
	/******************************************************/
}
