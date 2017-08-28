CREATE OR REPLACE FUNCTION FUNC_IS_SUPERVISOR_AVAILABLE 
(
    paramStudentNo IN VARCHAR2 
  , paramStdStatCode IN VARCHAR2
) RETURN VARCHAR2 AS 
/*
  Function Name : FUNC_IS_SUPERVISOR_AVAILABLE
  
  Summary : FindOut whether the student have supervisor or not

  Author : Bhabesh
  Create Date : 28-August-2017
*/
IS_AVAILABLE VARCHAR2(1);
BEGIN
    SELECT 
          DECODE (
                    COUNT(*),
                    0,'N','Y'
                  )
          INTO IS_AVAILABLE
    FROM
        STD_THESIS
    WHERE
            STDNO = paramStudentNo
        AND STDSTATCD = paramStdStatCode;
  RETURN IS_AVAILABLE;
END FUNC_IS_SUPERVISOR_AVAILABLE;