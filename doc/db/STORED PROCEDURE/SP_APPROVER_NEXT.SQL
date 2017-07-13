create or replace PROCEDURE SP_APPROVER_NEXT
(
  paramStudentNo IN VARCHAR2                      --  Student Number
, paramFormName IN VARCHAR2                       --  DPS Form Name
, paramRoleName IN VARCHAR2                       --  Current Role name of the approver
, paramNextSequence IN VARCHAR2                   --  Whether next sequence is required (if not first time submit)
, paramApproverNameEng OUT VARCHAR2               --  Approver name in English
, paramApproverNameAr OUT VARCHAR2                --  Approver name in Arabic
, paramApproverEmail OUT VARCHAR2                 --  Approver email
, paramApproverPhone OUT VARCHAR2                 --  TODO - Phone number of Faculty
, paramApproverRoleEn  OUT VARCHAR2               --  Role name in English
, paramApproverRoleAr  OUT VARCHAR2               --  Role name in Arabic
, paramApproverIsNext  OUT VARCHAR2               --  Whether the approver is next higher one or not
)
AS 
/*
  Stored Procedure Name : SP_APPROVER
  
  Summary : Retrive approver Name, Email, Phone number

  Author : Bhabesh
  Create Date : 10-July-2017
  
  paramNextSequence is 'Y' or 'N'. That means if 'N' then looking for values at the current sequence and don't go further, 
  else find the values of approvers for next sequence only
  
*/

APP_EMP_NUM   VARCHAR2(10);
CURRENT_SEQUENCE  NUMBER;
MAX_SEQUENCE      NUMBER;
NEXT_SEQUENCE     NUMBER;
T_ROLENAME      VARCHAR2(60);

BEGIN
  /* Get current sequence of approver of a particular approver and form*/
  SELECT 
      APPROVAL_SEQUENCE
      INTO CURRENT_SEQUENCE
  FROM
        APPROVAL_MASTER APP
      , SIS_CODES     CODES
      , SIS_OBJECT    OBJ
  WHERE
          APP.FORMCD          =  OBJ.OBJECTCD
      AND APP.APPROVER_ROLECD = CODES.SISCODECD
      AND CODES.L_ABR_CODE    = paramRoleName
      AND OBJ.OBJECTNM        = paramFormName;
 
 /*Get maximum sequence number of approver of a particular form*/
  SELECT MAX(APPROVAL_SEQUENCE)
        INTO MAX_SEQUENCE
  FROM
        APPROVAL_MASTER   APP_M
      , SIS_OBJECT        OBJ
  WHERE
            APP_M.FORMCD          =  OBJ.OBJECTCD
       AND  OBJ.OBJECTNM          = paramFormName;

  
  /* Basis of whether next higher sequence number required or not, next or current approver details will be retrived
     Actually it does two things : 
     1) when studnet first time submits that time only the immediated associated approver is concerned so next approver
         not required. There fore the input of sequence required is 'N'
      2) Apart from all the other case required sequence should be 'Y'. Even though the last approver with the required 
         sequence 'Y' will be taken care of in this code.
  */
      
  CASE paramNextSequence
    WHEN 'N' THEN
        BEGIN
          APP_EMP_NUM := FUNC_STUDENT_APPROVER(paramStudentNo,paramRoleName);
          paramApproverIsNext := 'N';
        END;
    WHEN 'Y' THEN
      BEGIN
        IF (CURRENT_SEQUENCE <> MAX_SEQUENCE) THEN
            NEXT_SEQUENCE := CURRENT_SEQUENCE + 1;
            paramApproverIsNext := 'Y';
        ELSE
            NEXT_SEQUENCE := MAX_SEQUENCE;
            paramApproverIsNext:='N';
        END IF;
            SELECT 
                   CODES.L_ABR_CODE
                   INTO T_ROLENAME
            FROM
                APPROVAL_MASTER APP_M
              , SIS_CODES       CODES  
              , SIS_OBJECT      OBJ
            WHERE
                    APP_M.FORMCD            =  OBJ.OBJECTCD
              AND   OBJ.OBJECTNM            = paramFormName
              AND   APP_M.APPROVAL_SEQUENCE = NEXT_SEQUENCE
              AND  APP_M.APPROVER_ROLECD = CODES.SISCODECD ;
              
             APP_EMP_NUM := FUNC_STUDENT_APPROVER(paramStudentNo,T_ROLENAME); 
      END;
  END CASE;

        /* Fetch Emplyoee name (English/Arabic), email, Role name (English/Arabic) using employee number.
            (TODO) Employee phone is not available at this moment. 
        */

  SELECT
            (FAC.EMPFIRNM || ' ' || FAC.EMPTRIBLNM)       
          , (FAC.A_EMPFIRNM || ' ' || FAC.A_EMPTRIBLNM)   
          , USR.EMAIL 
          , CODES.CODENM
          , CODES.A_CODENM
          INTO paramApproverNameEng, paramApproverNameAr, paramApproverEmail,paramApproverRoleEn,paramApproverRoleAr
  FROM
        FAC_SURNM  FAC
      , SIS_USERS  USR
      , SIS_CODES  CODES
  WHERE
          LTRIM(USR.USERNAME,'e')=TO_CHAR(FAC.EMPNO)
          AND CODES.SISCODECD = USR.USERCATEGORY
          AND FAC.EMPNO = APP_EMP_NUM;
      
EXCEPTION
  WHEN OTHERS THEN
      raise_application_error(-20001,'An error was encountered - '||SQLCODE||' -ERROR- '||SQLERRM);
      
END SP_APPROVER_NEXT;