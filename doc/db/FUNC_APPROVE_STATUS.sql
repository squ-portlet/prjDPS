create or replace FUNCTION FUNC_APPROVE_STATUS(paramStudentNo VARCHAR2, paramRoleName VARCHAR2 , paramFormName VARCHAR2) return VARCHAR2 as
/*
  Function Name : FUNC_APPROVE_STATUS
  
  Summary : FindOut approve status of individual student for a particular form and approver's role

  Author : Bhabesh
  Create Date : 18-February-2017
*/
COUNT_REC   NUMBER :=0;
RESULT_STATUS VARCHAR2 (10);
begin
      begin
                      SELECT
                                  COUNT(APP_TX.APPROVAL_STATUSCD) 
                                  INTO COUNT_REC
                            FROM
                                  APPROVAL_MASTER       APP_M
                                  ,APPROVAL_TRANSACTION APP_TX
                                  ,SIS_OBJECT           OBJ
                                  ,SIS_CODES            CODES
                            WHERE
                                      APP_M.APPROVER_ROLECD = CODES.SISCODECD
                                 AND  APP_M.FORMCD          = OBJ.OBJECTCD
                                 AND  APP_TX.STDNO          = paramStudentNo
                                 AND  APP_M.APPROVALCD      = APP_TX.APPROVALCD
                                 AND CODES.L_ABR_CODE       = paramRoleName
                                 AND  OBJ.OBJECTNM          = paramFormName;
          begin
            IF (COUNT_REC = 0) THEN
                RESULT_STATUS:='NA';
            ELSE
                begin
                          SELECT
                                 (
                                   SELECT
                                       DECODE
                                      (
                                        NVL(CODES.L_ABR_CODE,'NA')
                                        ,'ACCPT','Y'
                                        ,'REJCT','N'
                                      )
                                    FROM
                                            SIS_CODES       CODES
                                        ,   SIS_CODE_TYPES  TYPES
                                    WHERE
                                            CODES.SISCODETYPCD =  TYPES.SISCODETYPCD
                                        AND TYPES.SISCODETYPNM = 'APPROVAL_STATUS'
                                        AND CODES.SISCODECD  = APP_TX.APPROVAL_STATUSCD  
                                  )
                                        
                                   INTO    RESULT_STATUS
                            FROM
                                  APPROVAL_MASTER       APP_M
                                  ,APPROVAL_TRANSACTION APP_TX
                                  ,SIS_OBJECT           OBJ
                                  ,SIS_CODES            CODES
                            WHERE
                                 APP_M.APPROVER_ROLECD      = CODES.SISCODECD
                                 AND  APP_M.FORMCD          = OBJ.OBJECTCD
                                 AND  APP_TX.STDNO          = paramStudentNo
                                 AND  APP_M.APPROVALCD      = APP_TX.APPROVALCD
                                 AND  CODES.L_ABR_CODE      = paramRoleName
                                 AND  OBJ.OBJECTNM          = paramFormName;                    
                end;
            END IF;
          end;
          EXCEPTION 
              WHEN NO_DATA_FOUND THEN
                  COUNT_REC:=0;
                  RESULT_STATUS:='NA';
        
      end;
      RETURN RESULT_STATUS;
end;