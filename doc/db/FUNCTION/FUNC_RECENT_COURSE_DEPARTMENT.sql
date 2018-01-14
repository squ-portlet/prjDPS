CREATE OR REPLACE FUNCTION FUNC_RECENT_COURSE_DEPARTMENT 
(
  paramStudentNo IN VARCHAR2 
, paramFormName IN VARCHAR2 
, paramRoleName IN VARCHAR2 
) RETURN VARCHAR2 AS 
/*
  Function Name : FUNC_RECENT_COURSE_DEPARTMENT 
  
  Summary : FindOut department of the student's recent concerned course 
            For a particular form, get the particualar course in question and find the department

  Author : Bhabesh
  Create Date : 13-December-2017
*/
VAR_DEPT_NO  NUMBER(4,0);

BEGIN
VAR_DEPT_NO :=0;
BEGIN
  CASE paramRoleName
    WHEN 'HOD' THEN
       CASE paramFormName 
          WHEN 'DPS9' THEN
                        SELECT 
                            SECT.DEPTNO
                            INTO VAR_DEPT_NO
                        FROM
                              SECT          SECT
                            , T_STD_GRADES  T_GRADES
                        WHERE
                              SECT.SECTCD = T_GRADES.SECTCD
                              AND T_GRADES.STATUSCD IN (
                                         SELECT
                                             CODES.SISCODECD	
                                         FROM
                                                 SIS_CODES       CODES
                                             ,   SIS_CODE_TYPES  TYPES
                                         WHERE
                                                 CODES.SISCODETYPCD 	=  TYPES.SISCODETYPCD
                                             AND TYPES.SISCODETYPNM 	= 'APPROVAL_STATUS'
                                             AND ( CODES.L_ABR_CODE  	 IN ( 'PENDG', 'PRGRS'))
                                    ) 
                                AND T_GRADES.STDNO = paramStudentNo
                                AND ROWNUM = 1 ;
        END CASE;  
  END CASE;
  
    EXCEPTION
      WHEN OTHERS THEN
        VAR_DEPT_NO :=0;
  END;        
  RETURN VAR_DEPT_NO;
END FUNC_RECENT_COURSE_DEPARTMENT ;