CREATE OR REPLACE FUNCTION FUNC_APPROVER_COMMENT 
(
      paramStudentNo VARCHAR2
    , paramRoleName VARCHAR2 
    , paramFormName VARCHAR2
    , paramSequence IN VARCHAR2 DEFAULT NULL 
) RETURN VARCHAR2 AS

/*
  Function Name : FUNC_APPROVER_COMMENT
  
  Summary : Comments of role based approver

  Author : Bhabesh
  Create Date : 19-December-2017
*/

VAR_COMMENTS  VARCHAR2(1000);

BEGIN
  BEGIN
    SELECT 
          APP_TX.COMMENTS
          INTO VAR_COMMENTS
    FROM
          APPROVAL_MASTER       APP_M
        , APPROVAL_TRANSACTION APP_TX
        , SIS_OBJECT           OBJ
        , SIS_CODES            CODES
    WHERE
                APP_M.APPROVER_ROLECD = CODES.SISCODECD
           AND  APP_M.FORMCD          = OBJ.OBJECTCD
           AND  APP_TX.STDNO          = paramStudentNo
           AND  APP_M.APPROVALCD      = APP_TX.APPROVALCD
           AND CODES.L_ABR_CODE       = paramRoleName
           AND  OBJ.OBJECTNM          = paramFormName
          AND  (
                          paramSequence is null
                     OR  APP_TX.REQUESTCD = paramSequence
               );
  EXCEPTION 
              WHEN OTHERS THEN
                  VAR_COMMENTS := NULL;
  
  END;
  RETURN VAR_COMMENTS;
END FUNC_APPROVER_COMMENT;