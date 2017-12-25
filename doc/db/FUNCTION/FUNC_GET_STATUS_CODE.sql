--------------------------------------------------------
--  File created - Thursday-November-23-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function FUNC_GET_STATUS_CODE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "DPSPROJECT"."FUNC_GET_STATUS_CODE" 
(
  PARAM_L_ABR_CODE IN VARCHAR2 
) RETURN NUMBER AS 

/*
  Function Name : FUNC_GET_STATUS_CODE
  
  Summary : Get the status code

  Author : Bhabesh
  Create Date : 22-November-2017
*/

RESULT_CODE NUMBER :=0;
BEGIN
  BEGIN
   SELECT
                     CODES.SISCODECD	
                     INTO RESULT_CODE
                 FROM
                         SIS_CODES       CODES
                     ,   SIS_CODE_TYPES  TYPES
                 WHERE
                         CODES.SISCODETYPCD =  TYPES.SISCODETYPCD
                     AND TYPES.SISCODETYPNM = 'APPROVAL_STATUS'
                     AND CODES.L_ABR_CODE  = PARAM_L_ABR_CODE;

  
  EXCEPTION 
              WHEN OTHERS THEN
                  RESULT_CODE:=0;
  END;
  RETURN RESULT_CODE;
END FUNC_GET_STATUS_CODE;

/
