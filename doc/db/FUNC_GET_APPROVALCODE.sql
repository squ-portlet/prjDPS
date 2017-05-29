create or replace FUNCTION FUNC_GET_APPROVALCODE 
(
  paramFormName IN VARCHAR2 
, paramRoleName IN VARCHAR2 
) RETURN VARCHAR2 AS 
/*
  Function Name : FUNC_GET_APPROVALCODE
  
  Summary : Get Approval Code based on FormName and RoleName

  Author : Bhabesh
  Create Date : 06-March-2017
*/
VAR_APPROVAL_CODE   VARCHAR2(10);
BEGIN
          SELECT 
                APPROVALCD
            INTO VAR_APPROVAL_CODE
      FROM
            APPROVAL_MASTER APP_M
          , SIS_OBJECT      OBJ
          , SIS_CODES       CODES
      WHERE
              APP_M.FORMCD  = OBJ.OBJECTCD
          AND APP_M.APPROVER_ROLECD = CODES.SISCODECD
          AND OBJ.OBJECTNM  = paramFormName
          AND CODES.L_ABR_CODE =  paramRoleName;

  RETURN VAR_APPROVAL_CODE;
   EXCEPTION
  WHEN OTHERS THEN
      raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
END FUNC_GET_APPROVALCODE;