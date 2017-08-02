create or replace FUNCTION FUNC_STUDENT_APPROVER 
(
  paramStudentNo IN VARCHAR2 
, ParamRoleName IN VARCHAR2 
) RETURN VARCHAR2 AS 
/*
  Function Name : FUNC_STUDENT_APPROVER
  
  Summary : FindOut approver empnumber of a particular student based on particular role

  Author : Bhabesh
  Create Date : 21-February-2017
*/
APP_EMP_NUM   VARCHAR2(10);
BEGIN
  CASE ParamRoleName
      WHEN 'ADVISOR' THEN
            SELECT 
                  ADVISOR
                  INTO APP_EMP_NUM
            FROM
                  V_STDINFO_PORTAL
            WHERE
                    STDNO = paramStudentNo
                AND ACTIVE = 'Y'
                AND (
                          DEG_NUMBER IN (2,4,10)
                      OR  (DEG_NUMBER = 6 AND MAJOR_CODE='PODT')
                    );
                
          
      WHEN 'SUPRVS' THEN 
                        SELECT 
                            THESIS.SUPVISREMPNO
                            INTO APP_EMP_NUM
                        FROM 
                          STD_THESIS THESIS
                        WHERE
                              THESIS.STDNO = paramStudentNo
                         AND  THESIS.UPDTE =  ( SELECT 
                                                        MAX(UPDTE)
                                                FROM 
                                                     STD_THESIS
                                                WHERE
                                                      STDNO = paramStudentNo);
                                                                     
      WHEN 'DEAN' THEN
               SELECT USERNAME
               INTO APP_EMP_NUM
               FROM 
               (
                      SELECT 
                            LTRIM(USERS.USERNAME,'e') AS USERNAME
                      FROM    
                            SIS_USERS           USERS
                            , SIS_CODES         CODES
                            , V_STDINFO_PORTAL  PORTAL
                            , COL_CEN           COLCEN
                      WHERE
                                USERS.USERCATEGORY = CODES.SISCODECD
                           AND  CODES.L_ABR_CODE LIKE 'DEAN' 
                           AND USERS.STATUSACTIVE='Y'
                           AND  COLCEN.L_ABR_CC = PORTAL.COLLEGE_CODE
                           AND  COLCEN.COLCENCD = USERS.COLCENCD
                           AND  PORTAL.STDNO = paramStudentNo
                           ORDER BY UPDTDTE DESC
                )
                WHERE
                      ROWNUM = 1;
 
       WHEN 'DEANP' THEN
                      SELECT 
                            LTRIM(USERS.USERNAME,'e')
                            INTO APP_EMP_NUM
                      FROM    
                            SIS_USERS           USERS
                            , SIS_CODES         CODES
                      WHERE
                                USERS.USERCATEGORY = CODES.SISCODECD
                           AND  CODES.L_ABR_CODE LIKE 'DEANP' 
                           AND USERS.STATUSACTIVE='Y';
        
              
  END CASE;
  RETURN APP_EMP_NUM;
END FUNC_STUDENT_APPROVER;