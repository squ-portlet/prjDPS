CREATE OR REPLACE TRIGGER TRG_DPS_T_GRADE_CHANGE 
AFTER UPDATE OF STATUSCD ON T_STD_GRADES 
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
/*
  Trigger Name : TRG_DPS_T_GRADE_CHANGE
  
  Summary : Update STD_GRADES table on final acceptance by the higher approver

  Author : Bhabesh
  Create Date : 18-December-2017

  Need to check whether the final approval is accepted or rejected. grade will be updated for approval acceptance only.
  Grade code and final approval date will be updated but not the approver user name because it will change the rule system.
  Rule : only the person entered the grade can able to change the grade
 
*/

DECLARE

VAR_STATUSCD VARCHAR2(8);

BEGIN
  
  SELECT
                                      CODES.L_ABR_CODE
                                     INTO VAR_STATUSCD
			                       FROM
			                               SIS_CODES       CODES
			                           ,   SIS_CODE_TYPES  TYPES
			                       WHERE
			                               CODES.SISCODETYPCD 	=  TYPES.SISCODETYPCD
			                           AND TYPES.SISCODETYPNM 	= 'APPROVAL_STATUS'
			                           AND CODES.SISCODECD  	= :new.STATUSCD;
 
   IF(VAR_STATUSCD = 'ACCPT') 
   THEN
    
       UPDATE
                STD_GRADES
                SET GRADECD = :new.GRADECD_NEW
                ,   UPDDTE  = :new.UPDATE_DATE
          WHERE
                     STDNO = :new.STDNO
                AND CCYRCD=:new.CCYRCD
                AND SEMCD=:new.SEMCD
                AND L_ABR_CRSNO = :new.L_ABR_CRSNO;
  END IF;
END;