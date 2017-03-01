create or replace FUNCTION FUNC_IS_APPROVER 
  (
       paramStudentNo     IN  VARCHAR2
    ,  paramStdStatCode   IN  VARCHAR2
    ,  paramFormName      IN  VARCHAR2
    ,  paramRoleName      IN  VARCHAR2
    ,  paramEmpNo         IN  VARCHAR2
  )
  RETURN VARCHAR2 IS 
/*
  Function Name : FUNC_IS_APPROVER
  
  Summary : Decide for approver link availability for particular role

  Author : Bhabesh
  Create Date : 20-February-2017
*/
COUNT_REC       NUMBER          :=0;
COUNT_REC_OTHER NUMBER          :=0;
SEQ_NO          NUMBER          :=0;
APPROVAL_CODE   VARCHAR2(10);
IS_LINK_AVL     VARCHAR2(1)     :='N';


BEGIN
--      IF (FUNC_STUDENT_APPROVER(paramStudentNo,paramRoleName)=paramEmpNo) THEN  -- TODO WORK IN PROGRESS TO IMPLEMENT THIS FUNCTION
      
          BEGIN
              SELECT
                          APPROVAL_SEQUENCE   
                        , APPROVALCD        
                          INTO  SEQ_NO, APPROVAL_CODE
                  FROM
                        APPROVAL_MASTER   APP_M
                      , SIS_CODES         CODES
                      , SIS_OBJECT        OBJ
                      
                  WHERE
                          APP_M.APPROVER_ROLECD   = CODES.SISCODECD
                      AND APP_M.FORMCD            = OBJ.OBJECTCD 
                      AND CODES.L_ABR_CODE        = paramRoleName
                      AND OBJ.OBJECTNM            = paramFormName;
          END;
          BEGIN
                  SELECT
                      COUNT(STDNO) INTO COUNT_REC
                  FROM
                      APPROVAL_TRANSACTION  APP_T
                  WHERE
                          APP_T.APPROVALCD  = APPROVAL_CODE
                      AND APP_T.APPROVER_EMPNO =paramEmpNo
                      AND APP_T.STDNO          = paramStudentNo;
          END;
     
          BEGIN
                  IF (COUNT_REC=0) THEN
                    IF(SEQ_NO = 1) THEN
                        IS_LINK_AVL := 'Y';
                    ELSE
                      
                      DECLARE
                          CNT_STD     NUMBER;
                          APP_STATUS  VARCHAR2(8);
                          APP_SEQ     NUMBER;
                          CURSOR  CUR_APP IS
                           SELECT 
                                    COUNT(APP_T.STDNO)        AS  CNT
                                  , CODES.L_ABR_CODE          AS  STATUS             
                                  , APP_M.APPROVAL_SEQUENCE   AS  SEQ
                            FROM 
                                    APPROVAL_TRANSACTION  APP_T
                                  , SIS_CODES             CODES
                                  , APPROVAL_MASTER       APP_M
                                  , SIS_OBJECT            OBJ
                            WHERE
                                    APP_M.APPROVALCD       =  APP_T.APPROVALCD (+)
                                 AND  APP_M.FORMCD              = OBJ.OBJECTCD
                                 AND    APP_T.APPROVAL_STATUSCD = CODES.SISCODECD(+)
                                 AND  APP_T.STDNO (+)           = paramStudentNo
                                 AND  APP_T.APPROVER_EMPNO (+)  = paramEmpNo
                                 AND  OBJ.OBJECTNM  = paramFormName
                            
                            GROUP BY   L_ABR_CODE, APPROVAL_SEQUENCE   
                            ORDER BY APP_M.APPROVAL_SEQUENCE; 
                      BEGIN
                        OPEN CUR_APP;
                        LOOP
                          
                          FETCH CUR_APP INTO CNT_STD, APP_STATUS,APP_SEQ ;
                              IF (((SEQ_NO - 1) = APP_SEQ) AND APP_STATUS = 'ACCPT') THEN
                                  IS_LINK_AVL := 'Y';
                                  EXIT;
                              END IF;
                              IF (APP_SEQ >= SEQ_NO ) THEN
                                EXIT;
                              END IF;
                        END LOOP;
                        CLOSE CUR_APP;
                      END;
                    END IF;
                  END IF;
                  
          END;
--    END IF; 
      
  RETURN IS_LINK_AVL;
  EXCEPTION
  WHEN OTHERS THEN
      raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
  
END FUNC_IS_APPROVER;