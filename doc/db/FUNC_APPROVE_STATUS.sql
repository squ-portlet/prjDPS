create or replace FUNCTION FUNC_APPROVE_STATUS(paramStudentNo VARCHAR2, paramRoleCode VARCHAR2 , paramFormCode VARCHAR2) return VARCHAR2 as
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
                                   INTO    COUNT_REC
                            FROM
                                  APPROVAL_MASTER       APP_M
                                  ,APPROVAL_TRANSACTION APP_TX
                            WHERE
                                      APP_TX.STDNO = paramStudentNo
                                 AND  APP_M.APPROVALCD = APP_TX.APPROVALCD
                                 AND  APP_M.APPROVER_ROLECD=paramRoleCode
                                 AND  APP_M.FORMCD = paramFormCode ; 
          begin
            IF (COUNT_REC = 0) THEN
                RESULT_STATUS:='NA';
            ELSE
                begin
                      SELECT
                                    DECODE
                                        (
                                            NVL(TO_CHAR(APP_TX.APPROVAL_STATUSCD),'NA') 
                                            ,'5536','Y'               -- ACCEPT / APPROVE
                                            ,'5537','N'               --  REJECT
                                            ,'NA'     
                                        )
                                   INTO    RESULT_STATUS
                            FROM
                                  APPROVAL_MASTER       APP_M
                                  ,APPROVAL_TRANSACTION APP_TX
                            WHERE
                                      APP_TX.STDNO = paramStudentNo
                                  AND   APP_M.APPROVALCD = APP_TX.APPROVALCD
                                  AND   APP_M.APPROVER_ROLECD=paramRoleCode
                                  AND   APP_M.FORMCD = paramFormCode ;                 
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